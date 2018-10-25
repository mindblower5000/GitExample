package com.example.rumpi.gitexample.data.usecases;

import com.example.rumpi.gitexample.data.Endpoins;
import com.example.rumpi.gitexample.data.model.realm.RepoModel;
import com.example.rumpi.gitexample.data.model.realm.UserModel;
import com.example.rumpi.gitexample.data.model.view.UserViewModel;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class UserUsecases {

    private Endpoins endpoints;

    public UserUsecases(Endpoins endpoints) {
        this.endpoints = endpoints;
    }

    public Flowable<UserViewModel> getUser() {
        return endpoints
                .getUser()
                .map(userModel -> {
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(realm1 -> realm1.copyToRealmOrUpdate(userModel));

                    realm.close();
                    return new UserViewModel(userModel);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
