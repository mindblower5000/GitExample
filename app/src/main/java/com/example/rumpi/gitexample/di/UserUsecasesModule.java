package com.example.rumpi.gitexample.di;

import com.example.rumpi.gitexample.data.Endpoins;
import com.example.rumpi.gitexample.data.usecases.RepoUsecases;
import com.example.rumpi.gitexample.data.usecases.UserUsecases;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserUsecasesModule {

    @Provides
    @Singleton
    UserUsecases userUsecases(Endpoins endpoins) {
        return new UserUsecases(endpoins);
    }
}
