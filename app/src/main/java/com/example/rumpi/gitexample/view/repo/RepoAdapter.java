package com.example.rumpi.gitexample.view.repo;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.rumpi.gitexample.data.model.view.RepoViewModel;
import java.util.ArrayList;
import java.util.List;


public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private ArrayList<RepoViewModel> data = new ArrayList<>();
    private Listener listener;

    RepoAdapter(Listener listener){
        super();
        this.listener = listener;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RepoViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<RepoViewModel> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void addItems(List<RepoViewModel> list){
        int oldIndex=data.size();
        data.addAll(list);
        notifyItemRangeInserted(oldIndex, list.size());
    }

    public interface Listener {
        void onFeedClick(long id);
    }
}
