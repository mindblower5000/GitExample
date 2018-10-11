package com.example.rumpi.gitexample.data.model.view;

import com.example.rumpi.gitexample.data.model.realm.RepoModel;

public class RepoViewModel {
    public int id;
    public String imageUrl;
    public String description;

    public RepoViewModel(int id, String image, String description) {
        this.id = id;
        this.imageUrl = image;
        this.description = description;
    }

    public RepoViewModel(RepoModel model) {
        this(model.id, model.imageUrl, model.description);
    }
}
