import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {

    private final String playerName;
    private final char character; //indicating (X / O) the chararcter to be used during gameplay
    private final ArrayList<String> gamePlaySeq;
    private final boolean autoPlay;

    private final ArrayList<String> validMovesList;
    private final Scanner scanner;
    private String lastMove;

    private final HashSet<String> winningSequences = new HashSet<>(
            Arrays.asList("123", "147", "159", "258", "456", "357", "789", "369")
    );


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

        if (autoPlay) {
            return nextMoveAI();
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


    public String getRandom() {
        Random rand = new Random();
        return validMovesList.get(rand.nextInt(
                validMovesList.size() - 1 + 1)
        );
    }


    public String getPlayerName() {
        return playerName;
    }


    public String nextMoveAI() {

        String move;
        if (gamePlaySeq.isEmpty()){
            move = getRandom();
            lastMove = move;
            return move;
        } else {
            // consider the players current
            // check if what our last move was and select another move other that it
            if (gamePlaySeq.size() == 1){

                String s1 = gamePlaySeq.get(0);// don't consider that move

                ArrayList<String> containingS1 = getSequencesContainingChar(s1);

                String sequence = containingS1.get(new Random().nextInt(containingS1.size()));

                char c = sequence.replace(Character.toString(s1.charAt(0)), "").charAt(0);

                move = String.valueOf(c);
                lastMove = move;
                return move;
            }

            if (gamePlaySeq.size() == 2){
                String s1 = gamePlaySeq.get(0);
                String s2 = gamePlaySeq.get(1);

                ArrayList<String> containingS1S2 = getSequencesContainingChars(s1, s2);

                System.out.println(s1 + " " + s2);
                System.out.println(containingS1S2.size());

                String sequence = containingS1S2.get(new Random().nextInt(containingS1S2.size()));

                char c = sequence.replace(Character.toString(s1.charAt(0)), "")
                        .replace(Character.toString(s1.charAt(0)), "").charAt(0);

                move = String.valueOf(c);
                lastMove = move;
                return move;

            }

        }
        return "";
    }

    private ArrayList<String> getSequencesContainingChar(String c) {
        return winningSequences.stream()
                .filter(sequence -> sequence.contains(c))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> getSequencesContainingChars(String c, String c1) {
        return winningSequences.stream()
                .filter(sequence -> sequence.contains(c) && sequence.contains(c1))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
