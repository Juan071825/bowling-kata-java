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


    // crea un frame y le introduce los valores de la carta
    private Character[] frameCreator(Byte initialThrow, Byte numThrows){
        Character[] frame = new Character[numThrows];
        for ( Byte index = 0; index < numThrows; index++ ){
            frame[index] = extractThrow((byte)(initialThrow + index));
        }
        return frame;
    } 

    







    public Character[][] frameListCreator(){

        Character[][] frames = new Character[10][];
        Byte indexThrow = 0;

        for(Byte indexFrame = 0; indexFrame < 10; indexFrame++){

            // Calcula frames del 1 al 9.
            if (indexFrame < 9){
                if (extractThrow(indexThrow) != Simbols.STRIKE.getSimbol()){
                    frames[indexFrame] = frameCreator(indexThrow, (byte)2);
                    indexThrow = (byte)(indexThrow + 2);
                } else {
                    frames[indexFrame] = frameCreator(indexThrow, (byte)1);
                    indexThrow = (byte)(indexThrow + 1);
                }



            } else {
                if(extractThrow(indexThrow) != Simbols.STRIKE.getSimbol()){
                    frames[indexFrame] = new Character[2];
                    frames[indexFrame][0] = extractThrow(indexThrow);
                    frames[indexFrame][1] = extractThrow(indexThrow);
                } else if (extractThrow((byte)(indexThrow + oneThrow)) == Simbols.SPARE.getSimbol()) {
                    frames[indexFrame] = new Character[3];
                    frames[indexFrame][0] = extractThrow(indexThrow);
                    frames[indexFrame][1] = extractThrow(indexThrow);
                    frames[indexFrame][2] = extractThrow(indexThrow);                    
                } else {
                    frames[indexFrame] = new Character[3];
                    frames[indexFrame][0] = extractThrow(indexThrow);
                    frames[indexFrame][1] = extractThrow(indexThrow);
                    frames[indexFrame][2] = extractThrow(indexThrow);
                }
            }
        }

        return frame_list;


    }


}