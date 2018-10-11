package com.example.rumpi.gitexample.data;

import com.example.rumpi.gitexample.data.model.realm.RepoModel;
import java.util.List;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Endpoins {

    @GET("/repositories")
    Flowable<List<RepoModel>> getFeed();
}
