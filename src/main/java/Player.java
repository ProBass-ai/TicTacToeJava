import java.util.*;
import java.util.stream.Collectors;

public class Player {

    private final String playerName;
    private final char character; //indicating (X / O) the chararcter to be used during gameplay
    private final ArrayList<String> gamePlaySeq;
    private final boolean autoPlay;
    private final ArrayList<String> validMovesList;
    private final Scanner scanner;
    private String lastMove;
    ArrayList<String> moves;
    String currentGoal;

    private final HashSet<String> winningSequences = new HashSet<>(
            Arrays.asList("123", "147", "159", "258", "456", "357", "789", "369")
    );
    private ArrayList<String> occupiedSquares;


    public Player(String playerName, char character, boolean autoPlay) {

        this.playerName = playerName;
        this.character = character;
        gamePlaySeq = new ArrayList<>();
        this.autoPlay = autoPlay;
        String s = "1-2-3-4-5-6-7-8-9";
        String[] strings = s.split("-");
        validMovesList = new ArrayList<>(List.of(strings));
        moves = new ArrayList<>();
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
            this.lastMove = move;
            return move;
        } else {

            if (gamePlaySeq.size() == 1){

                String s1 = gamePlaySeq.get(0);// don't consider that move

                ArrayList<String> containingS1 = getSequencesContainingChar(s1);

                String sequence = containingS1.get(new Random().nextInt(containingS1.size()));

                char c = sequence.replace(Character.toString(s1.charAt(0)), "").charAt(0);

                if (isValidThirdMove(c)){
                    move = String.valueOf(c);
                } else {
                    move = _switch();
                }

                this.lastMove = move;
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

                if (isValidThirdMove(c)){
                    move = String.valueOf(c);
                } else {
                    move = _switch();
                }

                this.lastMove = move;
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


    private boolean isValidThirdMove(char thirdMove){
        String move = String.valueOf(thirdMove);
        return !occupiedSquares.contains(move);
    }


    public void updateOccupiedBlocks(ArrayList<String> occupiedSquares) {
        this.occupiedSquares = occupiedSquares;
    }


    public String _switch() {

        gamePlaySeq.clear();
        String move = getRandom();
        while (occupiedSquares.contains(move)){
            move = getRandom();
        }
        return move;
    }

    public String trackWinningSeq(){
        // store every move in the moves list
        moves.add(lastMove);


        // match make pairs of three to consider which might make the next win
        // if list is of length 1 conider moving on
        if (moves.size() == 1){
            // move on
        }

        // if list is of length 2, check if a matching last move can be made
        if (moves.size() == 2){
            // see which other blocks are open and consider them based on how increase winnig chances
        }

        // if list is of length 3, generate all possible combinations and which combination has the best possible route
        // do the same for 4 and 5
        if (moves.size() > 2){
            // make all possible combinations of the current moves
            // use these combinations to predict what a better next move
        }

        // consider any one of those pairs as your next move
        return "Suggested move";
    }



}
