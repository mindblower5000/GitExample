package com.example.rumpi.gitexample.presenter.repo;


import com.arellomobile.mvp.InjectViewState;
import com.example.rumpi.gitexample.MainApp;
import com.example.rumpi.gitexample.data.model.realm.RepoModel;
import com.example.rumpi.gitexample.data.model.view.RepoViewModel;
import com.example.rumpi.gitexample.data.usecases.RepoUsecases;
import com.example.rumpi.gitexample.presenter.base.BaseRestPresenter;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.ArrayList;
import javax.inject.Inject;


@InjectViewState
public class RepoPresenter extends BaseRestPresenter<Integer, RepoView> {

    @Inject
    RepoUsecases usecases;

    Realm realm;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        realm = Realm.getDefaultInstance();
        MainApp.getComponent().injectsToRepoPresenter(this);
        update();
    }

    @Override
    public void attachView(RepoView view) {
        super.attachView(view);
        setData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onNext(Integer o) {
        setData();
    }

    private void update() {
        usecases.getRepo().subscribe(this);
    }

    private void setData() {
        RealmResults<RepoModel> Repo = realm.where(RepoModel.class).findAll();
        ArrayList<RepoViewModel> result = new ArrayList<RepoViewModel>();
        for (RepoModel curItem : Repo) {
            result.add(new RepoViewModel(curItem));
        }
        getViewState().setItems(result);
    }
}
