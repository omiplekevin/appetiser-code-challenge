package com.android.omiplekevin.appetiserplay;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.omiplekevin.appetiserplay.helper.Constants;

import lombok.Getter;
import lombok.Setter;

public class App extends Application {

    @Getter @Setter
    public long lastVisit = 0L;

    @Override
    public void onCreate() {
        super.onCreate();
        getAndWriteVisitTimeStamp();
    }

    /**
     * Retrieves and saves timestamp for logging in last visit
     */
    private void getAndWriteVisitTimeStamp() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //retrieve and set saved timestamp from last visit
        setLastVisit(sharedPreferences.getLong(Constants.SHARED_PREFS_LAST_VISIT, 0L));
        //save current timestamp as last visit field on shared preferences
        sharedPreferences
                .edit()
                .putLong(Constants.SHARED_PREFS_LAST_VISIT, System.currentTimeMillis())
                .apply();
    }
}
