package com.example.rumpi.gitexample.view.repo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.rumpi.gitexample.R;
import com.example.rumpi.gitexample.data.model.view.RepoViewModel;
import com.example.rumpi.gitexample.presenter.repo.RepoPresenter;
import com.example.rumpi.gitexample.presenter.repo.RepoView;
import java.util.List;

public class RepoFragment extends MvpAppCompatFragment implements
                                                       RepoView,
                                                       RepoAdapter.Listener {

    @InjectPresenter
    RepoPresenter presenter;

    @BindView(R.id.feed_list)
    RecyclerView feedList;

    private RepoAdapter adapter = new RepoAdapter(this);

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        feedList.setAdapter(adapter);
    }

    @Override
    public void setItems(List<RepoViewModel> items) {
        adapter.setItems(items);
    }

    @Override
    public void hideLOading() {
        //hide loading
    }

    @Override
    public void showError(String str) {
        //show error
    }

    @Override
    public void startLoading() {
        //show loading
    }

    @Override
    public void onFeedClick(long id) {
        //go to details
    }
}
