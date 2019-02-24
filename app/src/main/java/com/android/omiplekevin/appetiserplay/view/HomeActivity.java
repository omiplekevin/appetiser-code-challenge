package com.android.omiplekevin.appetiserplay.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.omiplekevin.appetiserplay.R;
import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.helper.adapter.EntityAdapter;
import com.android.omiplekevin.appetiserplay.presenter.HomePresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomePresenterCallback {

    private static final String TAG = "HomeActivity";

    private HomePresenter homePresenter;

    @BindView(R.id.listingRecyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homePresenter = new HomePresenter(this);
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
    private void prepareRecyclerView() {
        if (this.recyclerView != null) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            this.recyclerView.setLayoutManager(mLayoutManager);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        } else {
            Toast.makeText(this, getString(R.string.toast_recycler_failure), Toast.LENGTH_LONG).show();
        }
    }

    private HashMap<String, String> createSearchParam() {
        HashMap<String, String> params = new HashMap<>();
        params.put("term", "star");
        params.put("country", "au");
        params.put("media", "movie");
        return params;
    }
}
