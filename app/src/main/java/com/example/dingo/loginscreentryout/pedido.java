package com.example.dingo.loginscreentryout;

/**
 * Created by Dingo on 05/01/2018.
 */

public class pedido {
    private String searching;
    private String userid;
    private String where;
    private String obs;
    private String idealHomies;
    private String email;
    private String curso;

    public pedido(String searching, String userid, String where, String obs, String idealHomies, String email, String curso) {
        this.searching = searching;
        this.userid = userid;
        this.where = where;
        this.obs = obs;
        this.idealHomies = idealHomies;
        this.email = email;
        this.curso = curso;
    }
    public pedido(){}

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSearching() {
        return searching;
    }

    public void setSearching(String searching) {
        this.searching = searching;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getIdealHomies() {
        return idealHomies;
    }

    public void setIdealHomies(String idealHomies) {
        this.idealHomies = idealHomies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
