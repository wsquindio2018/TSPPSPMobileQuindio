package com.example.worldskills.tsppspmobile.actividades;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.fragments_menu.TimeLog;

public class Opcion extends AppCompatActivity {

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);
        Bundle bundle = this.getIntent().getBundleExtra("dato");
        switch (bundle.getInt("pantalla")){

            case 1:
                fragment = new TimeLog();
                break;

            case 2:
                fragment = new TimeLog();
                break;

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorOpcion,fragment).commit();
    }
}
