package com.example.worldskills.tsppspmobile.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AdapterProyect extends RecyclerView.Adapter<AdapterProyect.ProjectoHolderView> {
    @Override
    public ProjectoHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ProjectoHolderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProjectoHolderView extends RecyclerView.ViewHolder {
        public ProjectoHolderView(View itemView) {
            super(itemView);
        }
    }
}
