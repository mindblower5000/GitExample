package com.example.rumpi.gitexample.data.model.realm;

import javax.annotation.Nullable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RepoModel extends RealmObject {

    @PrimaryKey
    public int id;

    @Nullable
    public String imageUrl;
    @Nullable
    public String description;
}
