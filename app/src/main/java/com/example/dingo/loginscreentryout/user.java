package com.example.dingo.loginscreentryout;

/**
 * Created by tiagogomes on 29/12/17.
 */

public class user {
    private String email;
    private String name;
    private String fac;
    private String curso;
    private String age;

    //Constructor

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public user(String name, String email, String fac, String description, String age) {
        this.name = name;
        this.email = email;
        this.fac = fac;
        this.curso = description;
        this.age = age;
    }

    //Setter, getter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
