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
        } else {
            Byte playerthrowScore = (byte)(playerthrow - '0');
            return playerthrowScore;
        }
    }


    private Byte simbolIndex(Character[] frame, Simbols simbol){
        for (Byte index = 0; index < frame.length; index++){
            if (frame[index] == simbol.getSimbol()){
                return index;
            }
        }
        return null;
    }


    private Integer sumFrameThrows(Character[] frame){

        Integer sumFrameThrows = 0;
        if(hasSimbol(frame, Simbols.SPARE)){
            Byte simbolIndex = simbolIndex(frame, Simbols.SPARE);
            for(Byte indexThrow = 0; indexThrow < frame.length; indexThrow++){
                if(indexThrow != simbolIndex - 1){
                    sumFrameThrows += throwValue(frame[indexThrow]);
                }
            }
        } else {
            for (Character playerthrow : frame){
                sumFrameThrows += throwValue(playerthrow);
            }
        }
        return sumFrameThrows;
    }

    private Integer sumFrameThrows(Character[] frame, Byte index){

        Integer sumFrameThrows = 0;
        if(hasSimbol(frame, Simbols.SPARE)){
            Byte simbolIndex = simbolIndex(frame, Simbols.SPARE);
            for(Byte indexThrow = 0; indexThrow < index; indexThrow++){
                if(indexThrow != simbolIndex - 1){
                    sumFrameThrows += throwValue(frame[indexThrow]);
                }
            }
        } else {
            for (Byte indexThrow = 0; indexThrow < index; indexThrow++){
                sumFrameThrows += throwValue(frame[indexThrow]);
            }
        }
        return sumFrameThrows;
    } 



    public Integer Score(Character[][] frames){
        Integer score = 0;

        for (Byte indexFrame = 0; indexFrame < frames.length; indexFrame++){

            // Frame 1 a 9
            if(indexFrame < 9){   
                if(hasSimbol(frames[indexFrame], Simbols.STRIKE)){
                    score += sumFrameThrows(frames[indexFrame]);
                    if(numThrowFrame(frames[indexFrame + 1]) == 1){
                        score += sumFrameThrows(frames[indexFrame + 1])
                               + throwValue(frames[indexFrame + 2][0]);
                    } else {
                       score += sumFrameThrows(frames[indexFrame + 1], (byte)2);
                    }

                } else if (hasSimbol(frames[indexFrame], Simbols.SPARE)){
                    score += sumFrameThrows(frames[indexFrame]) 
                           + throwValue(frames[indexFrame + 1][0]);
                } else{
                    score += sumFrameThrows(frames[indexFrame]);
                }
            } 



            // frame 10
            else {
                score += sumFrameThrows(frames[indexFrame]);
            }
        }
        return score;
    }
}
