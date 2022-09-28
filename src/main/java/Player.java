import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private final String playerName;
    private final char character; //indicating (X / O) the chararcter to be used during gameplay
    private final ArrayList<String> gamePlaySeq;
    private final boolean autoPlay;

    private final ArrayList<String> stringArrayList;
    private Scanner scanner;




    public Player(String playerName, char character, boolean autoPlay){

        this.playerName = playerName;
        this.character = character;
        gamePlaySeq = new ArrayList<>();
        this.autoPlay = autoPlay;
        String s = "1-2-3-4-5-6-7-8-9";
        String[] strings = s.split("-");
        stringArrayList = new ArrayList<>(List.of(strings));
        this.scanner = new Scanner(System.in);

    }


    public void setPlaySeq(String c){
        gamePlaySeq.add(c);
    }

    public String play(){
        if (autoPlay){
            return getRandom(stringArrayList);
        } else {
            return scanner.nextLine();
        }
    }


    public ArrayList<String> getGamePlaySeq() { return gamePlaySeq; }





    public char getCharacter(){
        return this.character;
    }


    public String getRandom(ArrayList<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size() - 1 + 1));
    }


    public String getPlayerName() {
        return playerName;
    }

}
