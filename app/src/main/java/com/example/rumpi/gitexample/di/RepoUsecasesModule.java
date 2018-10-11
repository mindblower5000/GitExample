package com.example.rumpi.gitexample.di;


import com.example.rumpi.gitexample.data.Endpoins;
import com.example.rumpi.gitexample.data.usecases.RepoUsecases;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class RepoUsecasesModule {

    @Provides
    @Singleton
    RepoUsecases repoUsecases(Endpoins endpoins) {
        return new RepoUsecases(endpoins);
    }
}
