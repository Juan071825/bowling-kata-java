package edu.teamrocket;

import java.util.EnumSet;

public enum Simbolos {

    SPARE("/", (byte)10),
    STRIKE("X", (byte)10),
    FAUL("-", (byte)0);


    private String simbolo;
    private Byte valor;

    private Simbolos(String simbolo, Byte valor){
        this.simbolo = simbolo;
        this.valor = valor;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public Byte getValor() {
        return this.valor;
    }

    

}