package edu.teamrocket;

import org.junit.jupiter.api.Test;

public class SimbolosTest {

    @Test
    public void PrintTest(){

        System.out.println(Simbolos.SPARE.getSimbolo());
        System.out.println(Simbolos.STRIKE.getSimbolo());
        System.out.println(Simbolos.FAUL.getSimbolo());
        
        System.out.println(Simbolos.SPARE.getValor());
        System.out.println(Simbolos.SPARE.getValor());
        System.out.println(Simbolos.FAUL.getValor());

    }

}




