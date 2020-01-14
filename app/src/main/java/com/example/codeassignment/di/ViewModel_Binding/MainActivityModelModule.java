package com.example.codeassignment.di.ViewModel_Binding;

import androidx.lifecycle.ViewModel;

import com.example.codeassignment.presentation.viewModel.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainActivityModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public abstract ViewModel bindMainActivityViewModel(MainActivityViewModel viewModel);
}
