package com.example.dingo.loginscreentryout;

/**
 * Created by Dingo on 05/01/2018.
 */

public class pedido {
    private String searching;
    private String where;
    private String obs;
    private String idealHomies;

    public pedido(String searching, String where, String obs, String idealHomies) {
        this.searching = searching;
        this.where = where;
        this.obs = obs;
        this.idealHomies = idealHomies;
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
}
