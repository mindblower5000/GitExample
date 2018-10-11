package com.example.rumpi.gitexample.presenter.repo;


import com.example.rumpi.gitexample.data.model.view.RepoViewModel;
import com.example.rumpi.gitexample.presenter.base.BaseRestView;
import java.util.List;

public interface RepoView extends BaseRestView {
    void setItems(List<RepoViewModel> items);
}
