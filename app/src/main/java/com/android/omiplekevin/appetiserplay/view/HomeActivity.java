package com.android.omiplekevin.appetiserplay.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.omiplekevin.appetiserplay.App;
import com.android.omiplekevin.appetiserplay.R;
import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.helper.adapter.EntityAdapter;
import com.android.omiplekevin.appetiserplay.presenter.HomePresenter;

import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomePresenterCallback {

    private static final String TAG = "HomeActivity";

    private HomePresenter homePresenter;

    @BindView(R.id.listingRecyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.lastVisit)
    public TextView lastVisitLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homePresenter = new HomePresenter(this);
        setLastVisit();
        prepareRecyclerView();
        homePresenter.searchTracks(createSearchParam());

    }

    @Override
    public void onSuccess(SearchResponseModel searchResults) {
        Log.d(TAG, "onSuccess: " + searchResults.toString());
        this.recyclerView.setAdapter(new EntityAdapter(this, searchResults));
    }

    @Override
    public void onError(Throwable throwable) {
        Log.w(TAG, "onError: " + throwable);
        Toast.makeText(this, "Error! " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    ///////////////////////////////////////////////////////////////////////////
    // PRIVATE METHODS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Sets necessary requirements for recycler view to properly display the list
     */
    private void prepareRecyclerView() {
        if (this.recyclerView != null) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            this.recyclerView.setLayoutManager(mLayoutManager);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        } else {
            Toast.makeText(this, getString(R.string.toast_recycler_failure), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Sets last visit label above the list
     */
    private void setLastVisit() {
        long lastVisit = homePresenter.getLastVisit();
        if (lastVisit == 0L) {
            lastVisitLabel.setVisibility(View.GONE);
        } else {
            lastVisitLabel.setText(homePresenter.parseMillisToDateString(lastVisit));
        }
    }

    /**
     * Creates a HashMap<String, String> parameter needed for querying the source API.
     * @return {@code HashMap<String, String>} that contains parameters needed for querying
     *
     * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching">iTunes Search API</a>
     */
    private HashMap<String, String> createSearchParam() {
        HashMap<String, String> params = new HashMap<>();
        params.put("term", "space");
        params.put("country", "au");
        params.put("media", "movie");
        return params;
    }
}
