package com.example.codeassignment.di.ViewModel_Binding;

import androidx.lifecycle.ViewModelProvider;

import com.example.codeassignment.presentation.viewModel.ViewModelProviderFactory;


import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
