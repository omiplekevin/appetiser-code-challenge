package com.android.omiplekevin.appetiserplay.helper.injection;

import com.android.omiplekevin.appetiserplay.data.rest.RestModule;
import com.android.omiplekevin.appetiserplay.presenter.HomePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = RestModule.class)
public interface DependencyComponent {

    void inject(HomePresenter homePresenter);

}
