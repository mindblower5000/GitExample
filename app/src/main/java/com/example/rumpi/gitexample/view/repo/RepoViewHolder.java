package com.example.rumpi.gitexample.view.repo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rumpi.gitexample.R;
import com.example.rumpi.gitexample.data.model.view.RepoViewModel;

public class RepoViewHolder extends RecyclerView.ViewHolder {

    private View root;
    private TextView description;
    private ImageView image;

    private RepoViewModel model;
    RepoAdapter.Listener listener;

    private RepoViewHolder(View view) {
        super(view);
        root = view;
        root.setOnClickListener(view1 -> {
                    if (listener != null) {
                        listener.onFeedClick(model.id);
                    }
                }
        );
        description = root.findViewById(R.id.description);
        image = root.findViewById(R.id.imageView);
    }

    public void bind(RepoViewModel model, RepoAdapter.Listener listener) {
        this.listener = listener;
        this.model = model;
        description.setText(model.description);
    }

    static RepoViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new RepoViewHolder(inflater.inflate(R.layout.item_feed, parent, false));
    }
}
