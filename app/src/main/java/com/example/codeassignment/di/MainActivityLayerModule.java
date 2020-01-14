package com.example.codeassignment.di;



import com.example.codeassignment.domain.Repository_Interactor;
import com.example.codeassignment.domain.Repository_UseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityLayerModule {

    @Provides
    Repository_UseCase provideRepository_UseCase () {

        return new Repository_Interactor();
    }
/*    @Provides
    UseCaseData provideUseCaseData () {

        return new DataInteractor();
    }


    @Provides
    DomainUseCase provideDomainUseCase () {

        return new DomainInteractor(provideUseCaseData() );
    }*/
}
