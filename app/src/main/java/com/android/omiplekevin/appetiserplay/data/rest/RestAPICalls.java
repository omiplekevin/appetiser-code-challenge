package com.android.omiplekevin.appetiserplay.data.rest;

import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RestAPICalls {

    private final RestService restService;
    private static final String TAG = "RestAPICalls";

    public RestAPICalls(RestService restService) {
        this.restService = restService;
    }

    /**
     * Performs iTunes Search API call using retrofit and receives parsed Object via Observable.
     *
     * @param callback returning interface for this method caller
     * @param searchParams parameters that will be used as QueryMap for RetroFit.
     * @return
     */
    public Subscription doSearchTracks(final RestAPICallback callback, HashMap<String, String> searchParams) {
        return restService.doTrackSearch(searchParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends SearchResponseModel>>() {
                    @Override
                    public Observable<? extends SearchResponseModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Observer<SearchResponseModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(SearchResponseModel searchResponseModel) {
                        callback.onSuccess(searchResponseModel);
                    }
                });
    }

    public interface RestAPICallback {
        void onSuccess(SearchResponseModel searchResponseModels);

        void onError(Throwable throwable);
    }
}
