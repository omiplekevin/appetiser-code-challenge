package com.android.omiplekevin.appetiserplay.data.rest;

import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface RestService {

    @GET("search")
    Observable<SearchResponseModel> doTrackSearch(@QueryMap Map<String, String>searchParams);

}
