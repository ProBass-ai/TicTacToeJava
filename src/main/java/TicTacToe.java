

import java.util.*;

public class TicTacToe {
    // input syntax 1
    // where '1' is there position of the character
    static Scanner scanner;
    static RunTimeData runTimeData;
    static UI ui;
    String status;

    private static final HashSet<String> winningSequences = new HashSet<>(
            Arrays.asList("123", "147", "159", "258", "456", "357", "789", "369")
    );




    public TicTacToe(){

        scanner = new Scanner(System.in);
        runTimeData = new RunTimeData();
        ui = new UI();

    }


    public boolean winnerIs(Player playerObject){
        try {
            return checkSeq(playerObject.getPlaySeq());
        } catch (NullPointerException nullPointerException){
            System.out.println("An internal error seems to have occured - Please try and restart the game");
            System.out.println("If it happens again, please contact me@email.co.za");
            System.exit(0);
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

    static String getBoard(){
        ArrayList<String> board = ui.getBoard();
        StringBuilder boardOut = new StringBuilder();

        for (String line: board){
            boardOut.append(line).append("\n");
        }

        return boardOut.toString();
    }


    static void showBoard() {
        System.out.println("Current board:");
        System.out.println(getBoard());
    }


//    public static void clearScreen(){
//
//        //            if (System.getProperty("os.name").contains("Windows"))
////                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
////            else
////                Runtime.getRuntime().exec("clear");
//        System.out.print("\f");
//    }


    /**
     * If the ArrayList contains any of the following sequences, return true: 1,2,3; 1,4,7; 1,5,9; 2,5,8; 4,5,6; 3,5,7;
     * 7,8,9; 3,6,9
     *
     * @param charSeq This is the ArrayList that contains the sequence of characters that the user has entered.
     * @return A boolean value.
     */
    private boolean checkSeq(ArrayList<String> charSeq) {
        StringBuilder sb = new StringBuilder();
        for(String s : charSeq){
            sb.append(s);
        }
        String str = sb.toString();
        return winningSequences.stream().anyMatch(str::contains);
    }
    
    
    public void changePlayer(ArrayList<Player> playerList){
        Collections.reverse(playerList);
    }


    /**
     * The function takes in a string as a parameter and checks if it is equal to "1" or "2" and if it is, it will launch
     * the game in single player or multiplayer mode respectively
     *
     * @param gameType 1 for single player, 2 for multi player
     */
    public void play(String gameType) {

        String playerMove;
        Player player1;
        Player player2;
        char p1Char = 'X', p2Char = 'O';
        ArrayList<Player> playerArrayList = new ArrayList<>();

        if (gameType.equals("1")) {

            System.out.println("Launching single player...");
            System.out.println("Insert the number of the block you want fill, starting from 1-9: ");
            player1 = new Player("Player 1", p1Char, false);
            player2 = new Player("Player 2", p2Char, true);


        } else {

            System.out.println("Launching multi player...");
            System.out.println("Insert the number of the block you want fill, starting from 1-9: ");
            player1 = new Player("Player 1", p1Char, false);
            player2 = new Player("Player 2", p2Char, false);


        }

        playerArrayList.add(player1);
        playerArrayList.add(player2);

        // start game here
        while (true) {

            Player player = playerArrayList.get(0);
            showBoard();
            System.out.println(player.getPlayerName() + " :");
            playerMove = player.playMove();

            while (runTimeData.ifBlockOccupied(playerMove)) {
                System.out.println("Block Taken!");
                showBoard();
                System.out.println(player.getPlayerName() + " :");
                playerMove = player.playMove();
            }

            //update game progress
            runTimeData.takeSquare(playerMove);
            ui.editBoard(playerMove, player.getCharacter());
            player.setPlaySeq(playerMove);

            //validate
            if (ifGameIsFinished(runTimeData.getOccupiedSquares(), player)) {
                showBoard();
                System.out.println(status);
                break;
            }

            changePlayer(playerArrayList); // this is how players take turns

        }

    }



    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe!!!\n" +
                "1. Single or, 2. Multi-player?\n" +
                "Select 1 or 2...");

        String userIn = scanner.nextLine();
        boolean valid = userIn.equals("1") || userIn.equals("2");

        while (!valid) {
           System.out.println("Choose only between 1 and 2");
           userIn = scanner.nextLine();
           valid = userIn.equals("1") || userIn.equals("2");
        }

        new TicTacToe().play(userIn);

    }

}
