package com.example.codeassignment.domain;

import com.example.codeassignment.data.entity.RepoEntity;

import java.util.List;

import io.reactivex.Single;


public interface Repository_UseCase {

    Single<List<RepoEntity>> getRepositories ();
}
