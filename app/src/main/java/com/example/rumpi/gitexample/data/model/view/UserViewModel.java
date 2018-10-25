package com.example.rumpi.gitexample.data.model.view;

import com.example.rumpi.gitexample.data.model.realm.UserModel;

public class UserViewModel {
    public String name;
    public String imageUrl;

    public UserViewModel(UserModel data){
        this.name = data.name;
        this.imageUrl = data.imageUrl;
    }
}
