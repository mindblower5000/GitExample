package com.example.rumpi.gitexample.presenter.base;

import com.arellomobile.mvp.MvpView;

public interface BaseRestView extends MvpView {
    void startLoading();
    void hideLOading();
    void showError(String str);

}
