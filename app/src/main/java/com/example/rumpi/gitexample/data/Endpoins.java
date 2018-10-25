package com.example.rumpi.gitexample.data;

import com.example.rumpi.gitexample.data.model.realm.RepoModel;
import com.example.rumpi.gitexample.data.model.realm.UserModel;

import java.util.List;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Endpoins {

    @GET("/repositories")
    Flowable<List<RepoModel>> getFeed();

    @GET("/users/rumpilstilstkin")
    Flowable<UserModel> getUser();
}
