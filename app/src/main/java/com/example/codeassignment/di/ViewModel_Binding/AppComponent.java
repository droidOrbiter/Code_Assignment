package com.example.codeassignment.di.ViewModel_Binding;

import android.app.Application;

import com.example.codeassignment.BaseApplication;
import com.example.codeassignment.di.MainActivityLayerModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                MainActivityLayerModule.class,
                ViewModelFactoryModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
