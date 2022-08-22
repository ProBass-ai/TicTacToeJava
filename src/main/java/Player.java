import java.util.ArrayList;
import java.util.Random;

public class Player {
    char character; //indicating (X / O) the chararcter to be used during gameplay

    public Player(char character){

        this.character = character;

    }

    public void play(){

    }

    public String autoPlay(ArrayList<String> availableSquares){
        // this is a method to be used by computer on single player
        return getRandom(availableSquares);

    }


    public char getCharacter(){
        return this.character;
    }


    public String getRandom(ArrayList<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}
