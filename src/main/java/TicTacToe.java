import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TicTacToe {
    // input syntax 1
    // where '1' is there position of the character
    static Scanner scanner;
    static RunTimeData runTimeData;
    static UI ui;
    ArrayList<String> stringArrayList;
    String status;




    public TicTacToe(){

        scanner = new Scanner(System.in);
        runTimeData = new RunTimeData();
        ui = new UI();

    }


    public boolean winnerIs(Player playerObject){
        try {
            return checkSeq(playerObject.getGamePlaySeq());
        } catch (NullPointerException nullPointerException){
            return false;
        }
    }


    /**
     * If the board is full and there is no winner, it's a tie. If the board is not full and there is a winner, the winner
     * is the player
     *
     * @param boared This is the list of all the moves that have been made by the players.
     * @param playerObject The player object that is being checked to see if they are the winner.
     * @return A boolean value.
     */
    public boolean ifGameIsFinished(ArrayList<String> boared, Player playerObject){

        int listSize = boared.size();
        boolean winnerIsPlayer = winnerIs(playerObject);

        if (listSize == 9 && !winnerIsPlayer){
            this.status = "It's a tie!!!";
            return true;
        } else if (winnerIsPlayer) {
            this.status = "Winner is " + playerObject.getPlayerName();
            return true;
        }

        return false;
    }


    public static void showBoard() {
        ArrayList<String> lines = ui.getUiLines();
        System.out.println("Current board:");
        for (String line: lines) {
            System.out.println(line);
        }
    }


    /**
     * If the ArrayList contains any of the following sequences, return true: 1,2,3; 1,4,7; 1,5,9; 2,5,8; 4,5,6; 3,5,7;
     * 7,8,9; 3,6,9
     *
     * @param charSeq This is the ArrayList that contains the sequence of characters that the user has entered.
     * @return A boolean value.
     */
    private static boolean checkSeq(@NotNull ArrayList<String> charSeq){

        if (charSeq.contains("1") && charSeq.contains("2") && charSeq.contains("3")){
            return true;
        } else if (charSeq.contains("1") && charSeq.contains("4") && charSeq.contains("7")) {
            return true;
        } else if (charSeq.contains("1") && charSeq.contains("5") && charSeq.contains("9")) {
            return true;
        } else if (charSeq.contains("2") && charSeq.contains("5") && charSeq.contains("8")) {
            return true;
        } else if (charSeq.contains("4") && charSeq.contains("5") && charSeq.contains("6")) {
            return true;
        }else if (charSeq.contains("3") && charSeq.contains("5") && charSeq.contains("7")) {
            return true;
        } else if (charSeq.contains("7") && charSeq.contains("8") && charSeq.contains("9")) {
            return true;
        } else return charSeq.contains("3") && charSeq.contains("6") && charSeq.contains("9");

    }


    /**
     * The function takes in a string as a parameter and checks if it is equal to "1" or "2" and if it is, it will launch
     * the game in single player or multiplayer mode respectively
     *
     * @param gameType 1 for single player, 2 for multi player
     */
    public void play(String gameType){

        String userIn;

        ArrayList<Player> playerArrayList = new ArrayList<>();

        if (gameType.equals("1")){

            System.out.println("Launching single player...");
            char p1Char = 'X', p2Char = 'O';
            Player player1 = new Player("Player 1", p1Char, false);
            Player player2 = new Player("Player 2", p2Char, true);
            playerArrayList.add(player1); playerArrayList.add(player2);


            // start game here
            while (true) {
                Player player = playerArrayList.get(0);
                showBoard();
                System.out.println( player.getPlayerName() + " :");
                userIn = player.play();

                while (runTimeData.ifBlockOccupied(userIn)) {
                    System.out.println("Block Taken!");
                    showBoard();
                    System.out.println(player.getPlayerName() + " :");
                    userIn = player.play();
                }

                runTimeData.takeSquare(ui, userIn, player.getCharacter());
                player.setPlaySeq(userIn);

                if (ifGameIsFinished(runTimeData.getOccupiedSquares(), player)) {
                    showBoard();
                    System.out.println(status);
                    break;
                }

                Collections.reverse(playerArrayList); // this is how players take turns

            }



        } else if (gameType.equals("2")) {

            System.out.println("Launching multi player...");
            char p1Char = 'X', p2Char = 'O';
            Player player1 = new Player("Player 1", p1Char, false);
            Player player2 = new Player("Player 2", p2Char, false);
            playerArrayList.add(player1); playerArrayList.add(player2);

            // start game here
            while (true) {
                Player player = playerArrayList.get(0);
                showBoard();
                System.out.println( player.getPlayerName() + " :");
                userIn = player.play();

                while (runTimeData.ifBlockOccupied(userIn)) {
                    System.out.println("Block Taken!");
                    showBoard();
                    System.out.println(player.getPlayerName() + " :");
                    userIn = player.play();
                }

                runTimeData.takeSquare(ui, userIn, player.getCharacter());
                player.setPlaySeq(userIn);

                if (ifGameIsFinished(runTimeData.getOccupiedSquares(), player)) {
                    showBoard();
                    System.out.println(status);
                    break;
                }

                Collections.reverse(playerArrayList); // this is how players take turns

            }
        }
    }



    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe!!!\n" +
                "1. Single or, 2. Multi-player?\n" +
                "Select 1 or 2...");

        String userIn = scanner.nextLine();
        boolean valid = userIn.equals("1") || userIn.equals("2");

        while (!valid){
           System.out.println("Choose only between 1 and 2");
           userIn = scanner.nextLine();
           valid = userIn.equals("1") || userIn.equals("2");
        }

        new TicTacToe().play(userIn);

    }

}
