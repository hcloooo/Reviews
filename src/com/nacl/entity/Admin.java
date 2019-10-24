package com.nacl.entity;

public class Admin {
    private int id;
    private String name;
    private String pwd;
    private String note;
    private int state;

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getNote() {
        return note;
    }

    public Admin(int id, String name, String pwd, String note, int state) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.note = note;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setState(int state) {
        this.state = state;
    }
}
