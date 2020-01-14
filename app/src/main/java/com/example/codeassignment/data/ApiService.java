package com.example.codeassignment.data;

import com.example.codeassignment.data.entity.RepoEntity;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface ApiService {

    // Url Endpoint.
    //
    @GET("orgs/square/repos")
    Single<List<RepoEntity>> getRepository();

}
