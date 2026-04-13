package edu.teamrocket;

import java.util.EnumSet;

public enum Simbols {

    SPARE("/", (byte)10),
    STRIKE("X", (byte)10),
    FAUL("-", (byte)0);


    private String simbol;
    private Byte value;

    private Simbols(String simbol, Byte value){
        this.simbol = simbol;
        this.value = value;
    }

    public String getSimbol() {
        return this.simbol;
    }

    public Byte getValue() {
        return this.value;
    }

    public static EnumSet<Simbols> getSimbols(){
        return EnumSet.allOf(Simbols.class);
    }
}