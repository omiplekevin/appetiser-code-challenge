package com.android.omiplekevin.appetiserplay.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.omiplekevin.appetiserplay.R;
import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.presenter.HomePresenter;

import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomePresenterCallback {

    private static final String TAG = "HomeActivity";

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homePresenter = new HomePresenter(this);
    }

    @Override
    public void onSuccess(SearchResponseModel searchResults) {
        Log.d(TAG, "onSuccess: " + searchResults.toString());
    }

    @Override
    public void onError(Throwable throwable) {
        Log.w(TAG, "onError: " + throwable);
        Toast.makeText(this, "Error! " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
