package com.android.omiplekevin.appetiserplay.data.rest;

import android.content.SharedPreferences;
import android.util.Log;

import com.android.omiplekevin.appetiserplay.BuildConfig;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class RestModule {

    public RestModule() {

    }

    @Provides
    @Singleton
    Retrofit providesRetrofitCall() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                int trycount = 0;

                while (!originalResponse.isSuccessful() && trycount < 3) {
                    trycount++;
                    Log.d("retroFitCall", "intercept[attempt " + trycount + "/ " + 3 + "]: " + chain.request().url());
                    originalResponse = chain.proceed(chain.request());
                }
                Log.d("call", "intercept: " + originalResponse.request().url());
                return originalResponse;
            }
        };

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(3);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .dispatcher(dispatcher)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public RestService providesRESTService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public RestAPICalls providesRESTCalls(RestService service) {
        return new RestAPICalls(service);
    }
}

