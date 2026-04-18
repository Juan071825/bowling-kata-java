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


    private Character extractThrow(Byte index){
        try{
            return getCard().charAt(index);
        } catch(IndexOutOfBoundsException exception) {
            System.out.println("Index no válido.");
            return null;
        }
    }

    
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

            // Frame 10
            } else {
                if(extractThrow(indexThrow) == Simbols.STRIKE.getSimbol() || extractThrow((byte)(indexThrow + 1)) == Simbols.SPARE.getSimbol()){
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







    private Boolean hasSimbol(Character[] frame, Simbols simbol){
        for (Character playerthrow : frame){
            if (playerthrow == simbol.getSimbol()){
                return true;
            }
        }
        return false;
    }


    private Boolean hasSimbol(Character[] frame){
        for (Character playerthrow : frame){
            if (playerthrow == Simbols.STRIKE.getSimbol()
            || playerthrow == Simbols.SPARE.getSimbol()){
                return true;
            }
        }
        return false;
    }


    private Byte numThrowFrame(Character[] frame){
        return (byte)(frame.length);
    }


    private Byte throwValue(Character playerthrow){
        if(playerthrow == Simbols.STRIKE.getSimbol()){
            return Simbols.STRIKE.getValue();
        } else if (playerthrow == Simbols.SPARE.getSimbol()){
            return Simbols.SPARE.getValue();
        } else if (playerthrow == Simbols.FAUL.getSimbol()){
            return Simbols.FAUL.getValue();
        } else{
            Byte playerthrowScore = (byte)(playerthrow - '0');
            return playerthrowScore;
        }
    }

 
    public Integer Score(Character[][] frames){
        Integer score = 0;

        for (Byte indexFrame = 0; indexFrame < frames.length; indexFrame++){

            // Frame 1 a 9
            if(indexFrame < 9){   
                if(hasSimbol(frames[indexFrame], Simbols.STRIKE)){
                    score += throwValue(frames[indexFrame][0]);
                    if(numThrowFrame(frames[indexFrame + 1]) == 1){
                        score += throwValue(frames[indexFrame + 1][0])
                               + throwValue(frames[indexFrame + 2][0]);

                    } else{
                        if(hasSimbol(frames[indexFrame +1], Simbols.SPARE)){
                            score += throwValue(frames[indexFrame + 1][1]);
                        }else{
                            score += throwValue(frames[indexFrame + 1][0])
                                   + throwValue(frames[indexFrame + 1][1]);
                        }
                    }

                } else if (hasSimbol(frames[indexFrame], Simbols.SPARE)){
                    score += throwValue(frames[indexFrame][1]) 
                           + throwValue(frames[indexFrame + 1][0]);

                } else{
                    for (Character playerthrow : frames[indexFrame]){
                        score += throwValue(playerthrow);
                    }
                }
            } 
            // frame 10
            else {

                if(numThrowFrame(frames[indexFrame]) == 2){
                    score += throwValue(frames[indexFrame][0]) 
                           + throwValue(frames[indexFrame][1]);
                } 
                else {

                    if(hasSimbol(frames[indexFrame], Simbols.SPARE)){

                        if(frames[indexFrame][0] == Simbols.STRIKE.getSimbol()){
                            score += throwValue(frames[indexFrame][0])
                               + throwValue(frames[indexFrame][2]);
                        } else{
                            score += throwValue(frames[indexFrame][1])
                               + throwValue(frames[indexFrame][2]);
                        }

                        



                    } else {

                        score += throwValue(frames[indexFrame][0])
                               + throwValue(frames[indexFrame][1])
                               + throwValue(frames[indexFrame][2]);

                    }
                }
            }
        }
        return score;
    }

}
