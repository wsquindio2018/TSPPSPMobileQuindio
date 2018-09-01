package com.example.worldskills.tsppspmobile.actividades;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.fragments_menu.DefectLog;
import com.example.worldskills.tsppspmobile.fragments_menu.TimeLog;

public class MenuOpciones extends AppCompatActivity {


    android.support.v4.app.Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
    }

    public void onClick(View view) {
        Intent sumary = new Intent(MenuOpciones.this,ProjectPlanSumary.class);
        Intent opcion = new Intent(MenuOpciones.this,Opcion.class);
        Bundle bundle = new Bundle();

        switch (view.getId()){

            case R.id.btnTimeLog:
                bundle.putInt("pantalla",1);
                opcion.putExtra("dato",bundle);
                startActivity(opcion);
                break;

            case R.id.btnDefectLog:
                bundle.putInt("pantalla",2);
                opcion.putExtra("dato",bundle);
                startActivity(opcion);
                break;

            case R.id.btnPlanSumary:
                startActivity(sumary);
                break;

        }
    }
}
