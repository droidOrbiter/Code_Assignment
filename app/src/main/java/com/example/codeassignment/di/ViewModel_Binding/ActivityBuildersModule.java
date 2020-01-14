package com.example.codeassignment.di.ViewModel_Binding;

import com.example.codeassignment.presentation.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainActivityModelModule.class})
    abstract MainActivity contributeAuthActivity();
}
