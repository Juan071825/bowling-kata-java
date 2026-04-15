package edu.teamrocket;

public class ScoreCard {

    private String card;

    public ScoreCard(String card){
        this.card = card;
    }


    public String getCard(){
        return this.card;
    }

    public Integer numThrows(){
        return getCard().length();
    }

    public Character extractThrow(Byte index){
        try{
            return getCard().charAt(index);
        } catch(IndexOutOfBoundsException exception) {
            System.out.println("Index no válido.");
            return null;
        }
    }



    /*public Character[] selectFrame (Character[][] match, Byte index){
        Character[] frame = match[index];
        return frame;
    }*/


        public Character[] frameCreator(Byte initialThrow, Byte numThrows){
            Character[] frame = new Character[numThrows];
            for ( Byte indexThrow = initialThrow; indexThrow < (initialThrow + 3); indexThrow++ ){
                frame[initialThrow]
            }
        }

    public Character[][] frameListCreator(){

        Character[][] match = new Character[10][];
        Byte indexThrow;

        for(Byte indexMatch = 0; indexMatch < 10; indexMatch++){
            Byte twoThrows = 2;
            Byte oneThrow = 1;

            // Calcula frames del 1 al 9.
            if (indexMatch < 10){
                if (extractThrow(indexThrow) != Simbols.STRIKE.getSimbol()){
                    match[indexMatch] = new Character[2];
                    match[indexMatch][0] = extractThrow(indexThrow);
                    match[indexMatch][1] = extractThrow(indexThrow);
                    indexThrow = (byte)(indexThrow + oneThrow);
                } else {
                    match[indexMatch] = new Character[1];
                    match[indexMatch][0] = extractThrow(indexThrow);
                    indexThrow = (byte)(indexThrow + twoThrows);
                }


            } else {
                if(extractThrow(indexThrow) != Simbols.STRIKE.getSimbol()){
                    match[indexMatch] = new Character[2];
                    match[indexMatch][0] = extractThrow(indexThrow);
                    match[indexMatch][1] = extractThrow(indexThrow);
                } else if (extractThrow((byte)(indexThrow + oneThrow)) == Simbols.SPARE.getSimbol()) {
                    match[indexMatch] = new Character[3];
                    match[indexMatch][0] = extractThrow(indexThrow);
                    match[indexMatch][1] = extractThrow(indexThrow);
                    match[indexMatch][2] = extractThrow(indexThrow);                    
                } else {
                    match[indexMatch] = new Character[3];
                    match[indexMatch][0] = extractThrow(indexThrow);
                    match[indexMatch][1] = extractThrow(indexThrow);
                    match[indexMatch][2] = extractThrow(indexThrow);
                }
            }
        }

        return frame_list;


    }


}