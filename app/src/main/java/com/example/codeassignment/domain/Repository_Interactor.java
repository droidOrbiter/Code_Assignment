package com.example.codeassignment.domain;

import com.example.codeassignment.data.ApiService;
import com.example.codeassignment.data.RetrofitInstance;
import com.example.codeassignment.data.entity.RepoEntity;

import java.util.List;

import io.reactivex.Single;



public class Repository_Interactor implements Repository_UseCase{


    /**
     * Get Retrofit instance and init the stream.
     *
     * @return Single Stream with all the repos
     *
     */
    @Override
    public Single<List<RepoEntity>> getRepositories () {

        ApiService apiService = RetrofitInstance.getRetrofitInstance();

        return apiService.getRepository();
    }
}
