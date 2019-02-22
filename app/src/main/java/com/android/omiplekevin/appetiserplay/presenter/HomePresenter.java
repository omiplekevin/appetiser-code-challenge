package com.android.omiplekevin.appetiserplay.presenter;

import android.content.Context;

import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.data.rest.RestAPICalls;
import com.android.omiplekevin.appetiserplay.data.rest.RestModule;
import com.android.omiplekevin.appetiserplay.helper.injection.DaggerDependencyComponent;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HomePresenter {

    private static final String TAG = "HomePresenter";

    private CompositeSubscription compositeSubscription;
    private HomePresenterCallback callback;

    @Inject
    public RestAPICalls restAPICalls;

    public HomePresenter(HomePresenterCallback callback) {
        this.callback = callback;
        compositeSubscription = new CompositeSubscription();
        DaggerDependencyComponent
                .builder()
                .restModule(new RestModule())
                .build()
        .inject(this);
    }

    /**
     * Call to iTunes API for getting related information about the track given with the parameters provided by the method caller
     *
     * @param searchParams track-related information that is used to filter out results.
     * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching">iTunes Search API</a>
     */
    public void searchTracks(HashMap<String, String> searchParams) {
        Subscription subscription = this.restAPICalls.doSearchTracks(new RestAPICalls.RestAPICallback() {
            @Override
            public void onSuccess(SearchResponseModel searchResponseModels) {
                callback.onSuccess(searchResponseModels);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onError(throwable);
            }
        }, searchParams);
        compositeSubscription.add(subscription);
    }

    ///////////////////////////////////////////////////////////////////////////
    // INTERFACES
    ///////////////////////////////////////////////////////////////////////////
    public interface HomePresenterCallback {
        void onSuccess(SearchResponseModel searchResults);

        void onError(Throwable throwable);
    }

}
