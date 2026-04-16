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
        Byte nextThrow = (byte)(indexThrow + 1);

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

                // Frame 10
            } else {
                if(extractThrow(indexThrow) == Simbols.STRIKE.getSimbol() || extractThrow(nextThrow) == Simbols.SPARE.getSimbol()){
                    frames[indexFrame] = frameCreator(indexThrow, (byte)3);
                    indexThrow = (byte)(indexThrow + 3);
                } else {
                    frames[indexFrame] = frameCreator(indexThrow, (byte)2);
                    indexThrow = (byte)(indexThrow + 2);                     
                }
            }
        }
        return frames;
    }


}