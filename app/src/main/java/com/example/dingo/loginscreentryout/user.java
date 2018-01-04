package com.example.dingo.loginscreentryout;

/**
 * Created by tiagogomes on 29/12/17.
 */

public class user {
    private int idade;
    private String name;
    private String curso;

    //Constructor

    public user(int id, String name, String description) {
        this.idade = id;
        this.name = name;
        this.curso = description;
    }

    //Setter, getter

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
