package com.example.worldskills.tsppspmobile.actividades;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.entidades.AllFragments;
import com.example.worldskills.tsppspmobile.entidades.Puente;
import com.example.worldskills.tsppspmobile.fragments_menu.TimeLog;

public class Opcion extends AppCompatActivity implements Puente, AllFragments {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);
        Bundle bundle = this.getIntent().getBundleExtra("dato");

        switch (bundle.getInt("pantalla")) {
            case 1:
                fragment = new TimeLog();
                break;
            case 2:
                fragment = new TimeLog();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorOpcion, fragment).commit();
    }

    @Override
    public void metodo() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
