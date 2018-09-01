package com.example.worldskills.tsppspmobile.utilidades;

public class Utilidades {


    //Se crean los campos de la tabla project
    public static final String TABLA_PROJECT = "PROJECT";
    public static final String CAMPO_ID = "ID";
    public static final String CAMPO_NOMBRE_PROJECT = "NOMBRE";
    public static final String CAMPO_TIEMPO = "TIEMPO";
    public static final String CREAR_PROJECT = "CREATE TABLE " + TABLA_PROJECT + " ( " + CAMPO_ID + " INT, " + CAMPO_NOMBRE_PROJECT + " VARCHAR, "
            + CAMPO_TIEMPO + " INT)";

    //Se crean los campos de la tabla timelog
    public static final String TABLA_TIME_LOG = "TIME";
    public static final String CAMPO_ID_TIME = "ID";
    public static final String CAMPO_PHASE = "PHASE";
    public static final String CAMPO_START = "START";
    public static final String CAMPO_INTERRUPTION = "INTERRUPTION";
    public static final String CAMPO_STOP = "STOP";
    public static final String CAMPO_DELTA = "DELTA";
    public static final String CAMPO_COMMENTS = "COMMENTS";
    public static final String CREAR_TIME = "CREATE TABLE " + TABLA_TIME_LOG + " ( " + CAMPO_ID_TIME + " INT, " + CAMPO_PHASE + " VARCHAR, "
            + CAMPO_START + " VARCHAR, " + CAMPO_INTERRUPTION + " INT, " + CAMPO_STOP + " VARCHAR, " + CAMPO_DELTA + " INT, "
            + CAMPO_COMMENTS + " VARCHAR)";


    //Se crean los campos de la tabla defectlog
    public static final String TABLA_DEFECT_LOG = "DEFECT";
    public static final String CAMPO_ID_DEFECT = "ID";
    public static final String CAMPO_DATE = "DATE";
    public static final String CAMPO_TYPE = "TYPE";
    public static final String CAMPO_PAHESE_INJECTED = "INJECTED";
    public static final String CAMPO_PHASE_REMOVE = "REMOVE";
    public static final String CAMPO_FIX = "FIX";
    public static final String CAMPO_DEFECT_DESCRIPTION = "DESCRIPTION";
    public static final String CREAR_DEFECT = "CREATE TABLE " + TABLA_DEFECT_LOG + " ( " + CAMPO_ID_DEFECT + " INT, " + CAMPO_DATE + " VARCHAR, "
            + CAMPO_TYPE + " VARCHAR, " + CAMPO_PAHESE_INJECTED + " VARCHAR, " + CAMPO_PHASE_REMOVE + " VARCHAR, " + CAMPO_FIX + " INT, "
            + CAMPO_DEFECT_DESCRIPTION + " VARCHAR)";
}
