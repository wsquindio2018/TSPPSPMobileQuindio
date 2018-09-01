package com.example.worldskills.tsppspmobile.actividades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.adapter.AdapterProyect;
import com.example.worldskills.tsppspmobile.entidades.ProjectPrincipal;
import com.example.worldskills.tsppspmobile.entidades.ProjectVo;
import com.example.worldskills.tsppspmobile.utilidades.Conexion;
import com.example.worldskills.tsppspmobile.utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Conexion conn;
    SQLiteDatabase bd;
    EditText nombre;
    RecyclerView recyclerView;
    ProjectVo miProjectVo;
    ArrayList<ProjectVo> list;
    int id=0;
    String campoNombre;
    //////holaaaa
    AdapterProyect adapterProyect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se instancia la clase Conexion para trabajar con la base de datos
        conn=new Conexion(getApplicationContext(),"TSP",null,1);

        //Se instancia el campo de texto para capturar el valor ingresado
        nombre=findViewById(R.id.campoNombre);
        recyclerView=findViewById(R.id.recycler);
        list=new ArrayList<>();
        consulta();
    }

    private void consulta() {
        list.clear();
        bd=conn.getReadableDatabase();

        Cursor cursor=bd.rawQuery("SELECT * FROM "+Utilidades.TABLA_PROJECT,null);

        while (cursor.moveToNext()){
            miProjectVo=new ProjectVo();
            miProjectVo.setNombre_projecto(cursor.getString(1));
            miProjectVo.setId(cursor.getInt(0));
            id=cursor.getInt(0)+1;
            list.add(miProjectVo);
        }

        adapterProyect=new AdapterProyect(list);

        recyclerView.setAdapter(adapterProyect);

        adapterProyect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectPrincipal.id=list.get(recyclerView.getChildAdapterPosition(v)).getId();
                Intent miIntent=new Intent(MainActivity.this,MenuOpciones.class);
                startActivity(miIntent);
            }
        });

    }

    public void onClick(View view) {
        campoNombre=nombre.getText().toString();
        bd=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,id);
        values.put(Utilidades.CAMPO_NOMBRE_PROJECT,campoNombre);

        if (campoNombre.equals("")){
            Toast.makeText(getApplicationContext(),"Debe llenar todos los campos",Toast.LENGTH_SHORT).show();
        }else {
            bd.insert(Utilidades.TABLA_PROJECT,Utilidades.CAMPO_ID,values);
            limpiar();
        }

        consulta();
    }

    private void limpiar() {
        nombre.setText(null);
    }
}
