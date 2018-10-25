package com.example.rumpi.gitexample.data.model.realm;

import javax.annotation.Nullable;

import io.realm.RealmObject;

public class UserModel extends RealmObject {

    @Nullable
    public String imageUrl;

    @Nullable
    public String name;
}
