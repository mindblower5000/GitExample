package com.example.rumpi.gitexample.di;


import com.example.rumpi.gitexample.data.usecases.RepoUsecases;
import com.example.rumpi.gitexample.data.usecases.UserUsecases;
import com.example.rumpi.gitexample.presenter.repo.RepoPresenter;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules={DaggerNetModule.class, RepoUsecasesModule.class, UserUsecasesModule.class})
public interface AppComponent {
    RepoUsecases repoUsecases();
    UserUsecases userUsecases();

    void injectsToRepoPresenter(RepoPresenter presenter);
}

