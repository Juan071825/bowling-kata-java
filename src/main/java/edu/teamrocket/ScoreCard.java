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

    public String[] frameCreator(){

        String[] frame_list = new String[numThrows()];

        for(Byte indexThrow = 0; indexThrow < numThrows();){
            if (extractThrow(indexThrow) != Simbols.FAUL.getSimbol() 
            || extractThrow(indexThrow) != Simbols.SPARE.getSimbol()
            || extractThrow(indexThrow) != Simbols.STRIKE.getSimbol()){
                Character[] frame = new Character[2];
                frame[indexThrow] = extractThrow(indexThrow);
                frame[indexThrow + 1] = extractThrow(indexThrow);
                indexThrow = indexThrow + (Byte)2;
            }
        }
    }


}