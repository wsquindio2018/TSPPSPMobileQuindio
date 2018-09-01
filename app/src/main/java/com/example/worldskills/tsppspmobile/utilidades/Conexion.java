package com.example.worldskills.tsppspmobile.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {

    //puente para crear la base de datos
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodo para crear la tabla de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_PROJECT);
        db.execSQL(Utilidades.CREAR_TIME);
        db.execSQL(Utilidades.CREAR_DEFECT);
    }

    //metodo actualizar para reiniciar las tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_PROJECT);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_TIME_LOG);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_DEFECT_LOG);

        onCreate(db);
    }
}
