package com.softwaresa.salaomais.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.softwaresa.salaomais.DAO.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {

    private String id;
    private String nome;
    private String senha;
    private String recuperar;
    private String email;

    public Usuarios() {

    }

    public void salvar(){

        DatabaseReference referneciaFirebase = ConfiguracaoFirebase.getFirebase();
        referneciaFirebase.child("usuário").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude

    public Map<String, Object> toMap(){

        HashMap<String, Object> hashMapUsuarios = new HashMap<>();

        hashMapUsuarios.put("id",getId());
        hashMapUsuarios.put("nome",getNome());
        hashMapUsuarios.put("senha",getSenha());
        hashMapUsuarios.put("recuperar",getRecuperar());
        hashMapUsuarios.put("email",getEmail());

        return hashMapUsuarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String getRecuperar() {
        return recuperar;
    }

    public void setRecuperar(String recuperar) {
        this.recuperar = recuperar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
