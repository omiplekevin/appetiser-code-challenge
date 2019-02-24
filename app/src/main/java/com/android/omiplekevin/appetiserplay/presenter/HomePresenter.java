package com.android.omiplekevin.appetiserplay.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.view.View;

import com.android.omiplekevin.appetiserplay.App;
import com.android.omiplekevin.appetiserplay.R;
import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.data.rest.RestAPICalls;
import com.android.omiplekevin.appetiserplay.data.rest.RestModule;
import com.android.omiplekevin.appetiserplay.helper.Constants;
import com.android.omiplekevin.appetiserplay.helper.injection.DaggerDependencyComponent;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HomePresenter {

    private static final String TAG = "HomePresenter";

    private CompositeSubscription compositeSubscription;
    private HomePresenterCallback callback;
    private Context context;

    @Inject
    public RestAPICalls restAPICalls;

    /**
     * Default constructor
     *
     * @param context Requires HomePresenterCallback for conveying the result of the an action invoked by HomeActivity
     */
    public HomePresenter(Context context) {
        this.context = context;
        this.callback = (HomePresenterCallback) this.context;
        compositeSubscription = new CompositeSubscription();
        DaggerDependencyComponent
                .builder()
                .restModule(new RestModule())
                .build()
                .inject(this);
    }

    /**
     * Call to iTunes API for getting related information about the track given with the parameters provided by the method caller.
     * If network connectivity is available, method will fetch from iTunes Search API and receives a parsed response from Retrofit.
     * Otherwise, cached json-string content will be retrieved and parsed.
     *
     * Callback will trigger {@link HomePresenterCallback} <code>onSuccess()</code> callback to provide view with the parsed data. <code>onError()</code>
     * otherwise with provided Throwable object with message of reason.
     *
     * @param searchParams track-related information that is used to filter out results.
     * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching">iTunes Search API</a>
     * @see SearchResponseModel
     */
    public void searchTracks(HashMap<String, String> searchParams) {
        if (isNetworkAvailable()) {
            Subscription subscription = this.restAPICalls.doSearchTracks(new RestAPICalls.RestAPICallback() {
                @Override
                public void onSuccess(SearchResponseModel searchResponseModels) {
                    writeToCache(Constants.SHARED_PREFS_RESPONSE_CACHE, new Gson().toJson(searchResponseModels));
                    callback.onSuccess(searchResponseModels);
                }

                @Override
                public void onError(Throwable throwable) {
                    callback.onError(throwable);
                }
            }, searchParams);
            compositeSubscription.add(subscription);
        } else {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            String cachedResponse = sharedPreferences.getString(Constants.SHARED_PREFS_RESPONSE_CACHE, "");
            if (!cachedResponse.isEmpty()) {
                SearchResponseModel searchResponseModel = new Gson().fromJson(cachedResponse, SearchResponseModel.class);
                callback.onSuccess(searchResponseModel);
            } else {
                callback.onError(new Throwable("No Cached response stored!"));
            }
        }
    }

    /**
     * Provides last visit timestamp pre-queried on the App.class
     * @return
     *
     * @see App#getLastVisit()
     */
    public long getLastVisit() {
        return ((App) this.context.getApplicationContext()).getLastVisit();
    }

    /**
     * Format last visit timestamp to readable string
     * @param lastVisit last visit timestamp save from sharedpreferences
     * @return formatted string
     */
    public String parseMillisToDateString(long lastVisit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(lastVisit);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        return this.context.getString(R.string.label_welcome_back_last_visit, mMonth + "/" + mDay + "/" + mYear);
    }

    ///////////////////////////////////////////////////////////////////////////
    // PRIVATE METHODS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Lazy Implementation. Writes string cache to SharedPreference.
     *
     * @param key     to be used as key reference on shared preferences table
     * @param content string value paired on shared preferences table with the key parameter provided
     */
    private void writeToCache(String key, String content) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
        prefs.edit()
                .putString(key, content)
                .apply();
    }

    /**
     * Check network connectivity
     * @return <code>true</code> if network connection is available, <code>false</code> otherwise.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    ///////////////////////////////////////////////////////////////////////////
    // INTERFACES
    ///////////////////////////////////////////////////////////////////////////
    public interface HomePresenterCallback {
        void onSuccess(SearchResponseModel searchResults);

        void onError(Throwable throwable);
    }

}
