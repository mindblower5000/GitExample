package com.example.rumpi.gitexample.data.usecases;

import com.example.rumpi.gitexample.data.Endpoins;
import com.example.rumpi.gitexample.data.model.realm.RepoModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class RepoUsecases {

    private Endpoins endpoints;

    public RepoUsecases(Endpoins endpoints) {
        this.endpoints = endpoints;
    }

    public Flowable<Integer> getRepo() {

        return endpoints
                .getFeed()
                .map(repoModels -> {
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(realm1 -> {
                        int i = 0;
                        for (RepoModel curItem : repoModels) {
                            curItem.id = i;
                            realm1.copyToRealmOrUpdate(curItem);
                            i++;
                        }
                    });

                    realm.close();
                    return repoModels.size();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
