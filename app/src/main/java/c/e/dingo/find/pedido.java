package c.e.dingo.find;

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
    private String age;
    private String nome;

    public pedido(String searching, String userid, String where, String obs, String idealHomies, String email, String curso, String nome, String age) {
        this.searching = searching;
        this.userid = userid;
        this.where = where;
        this.obs = obs;
        this.idealHomies = idealHomies;
        this.email = email;
        this.curso = curso;
        this.age = age;
        this.nome = nome;
    }
    public pedido(){}

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
