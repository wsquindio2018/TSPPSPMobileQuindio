package com.example.worldskills.tsppspmobile.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.entidades.ProjectVo;

import java.util.ArrayList;

public class AdapterProyect extends RecyclerView.Adapter<AdapterProyect.ProjectoHolderView> implements View.OnClickListener {

    ArrayList<ProjectVo> lista;
    View.OnClickListener listener;

    //contructor que recible el array list de tipo vo
    public AdapterProyect(ArrayList<ProjectVo> lista) {
        this.lista = lista;
    }

    @Override
    public ProjectoHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo, null);
        view.setOnClickListener(this);
        return new ProjectoHolderView(view);
    }

    @Override
    public void onBindViewHolder(ProjectoHolderView holder, int position) {
        holder.nombre.setText(lista.get(position).getNombre_projecto());
        holder.id.setText(""+lista.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public class ProjectoHolderView extends RecyclerView.ViewHolder {
        TextView id, nombre;

        public ProjectoHolderView(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idModelo);
            nombre = itemView.findViewById(R.id.nombreModelo);
        }
    }
}
