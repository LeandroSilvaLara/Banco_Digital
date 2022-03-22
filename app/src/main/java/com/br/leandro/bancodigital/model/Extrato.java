package com.br.leandro.bancodigital.model;

import com.br.leandro.bancodigital.helper.FirebaseHelper;
import com.google.firebase.database.DatabaseReference;

public class Extrato {

    private String id;
    private String operation;
    private  long data;
    private double valor;
    private String tipo;

    public Extrato() {
        DatabaseReference extratoRef = FirebaseHelper.getDatabaseReference();
        setId(extratoRef.push().getKey());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
