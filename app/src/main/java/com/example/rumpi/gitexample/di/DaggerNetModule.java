package com.example.rumpi.gitexample.di;

import com.example.rumpi.gitexample.data.Endpoins;
import com.example.rumpi.gitexample.data.ServiceGenerator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class DaggerNetModule {
    @Provides
    @Singleton
    Endpoins getEndpoins(){
        return new ServiceGenerator().createService(Endpoins.class);
    }
}

