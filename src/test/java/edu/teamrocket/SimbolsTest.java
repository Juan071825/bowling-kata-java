package edu.teamrocket;

import org.junit.jupiter.api.Test;

public class SimbolsTest {

    @Test
    public void PrintTest(){

        System.out.println(Simbols.SPARE.getSimbol());
        System.out.println(Simbols.STRIKE.getSimbol());
        System.out.println(Simbols.FAUL.getSimbol());
    
        System.out.println(Simbols.SPARE.getValue());
        System.out.println(Simbols.SPARE.getValue());
        System.out.println(Simbols.FAUL.getValue());

        System.out.println(Simbols.getSimbols());

    }

}




