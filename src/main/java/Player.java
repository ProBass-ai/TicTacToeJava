import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private final String playerName;
    private final char character; //indicating (X / O) the chararcter to be used during gameplay
    private final ArrayList<String> gamePlaySeq;
    private final boolean autoPlay;

    private final ArrayList<String> validMovesList;
    private final Scanner scanner;



    public Player(String playerName, char character, boolean autoPlay) {

        this.playerName = playerName;
        this.character = character;
        gamePlaySeq = new ArrayList<>();
        this.autoPlay = autoPlay;
        String s = "1-2-3-4-5-6-7-8-9";
        String[] strings = s.split("-");
        validMovesList = new ArrayList<>(List.of(strings));
        scanner = new Scanner(System.in);

    }


    public void setPlaySeq(String c){
        //Player : "I played these moves"
        gamePlaySeq.add(c);
    }


    public String playMove(){
        if (autoPlay){
            return getRandom(validMovesList);
        } else {

            String move = scanner.nextLine();
            while (!validMovesList.contains(move)) {
                System.out.println("Invalid Move!\n");
                move = scanner.nextLine();
            }

            return move;
        }
    }


    public ArrayList<String> getPlaySeq() { return gamePlaySeq; }


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
