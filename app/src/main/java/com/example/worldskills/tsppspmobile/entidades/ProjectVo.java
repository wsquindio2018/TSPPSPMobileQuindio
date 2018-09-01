package com.example.worldskills.tsppspmobile.entidades;

public class ProjectVo {

    //Creacion de todas las variables
    private int id;
    private String nombre_projecto;
    private int tiempo;
    private String date;
    private String type;
    private String injected;
    private String remove;
    private int fixTime;
    private String description;
    private String phase;
    private String start;
    private int interruption;
    private String stop;
    private int delta;
    private String comments;


    //Constructor sin parametros
    public ProjectVo() {
    }


    //Metodos Setter y Getter de todas las variable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_projecto() {
        return nombre_projecto;
    }

    public void setNombre_projecto(String nombre_projecto) {
        this.nombre_projecto = nombre_projecto;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInjected() {
        return injected;
    }

    public void setInjected(String injected) {
        this.injected = injected;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public int getFixTime() {
        return fixTime;
    }

    public void setFixTime(int fixTime) {
        this.fixTime = fixTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getInterruption() {
        return interruption;
    }

    public void setInterruption(int interruption) {
        this.interruption = interruption;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
