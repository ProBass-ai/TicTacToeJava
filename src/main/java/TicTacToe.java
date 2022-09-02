import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    // input syntax 1
    // where '1' is there position of the character
    static Scanner scanner;
    static RunTimeData runTimeData;
    static UI ui;
    ArrayList<String> stringArrayList;



    public TicTacToe(){

        scanner = new Scanner(System.in);
        runTimeData = new RunTimeData();
        ui = new UI();
        String s = "1-2-3-4-5-6-7-8-9";
        String[] strings = s.split("-");
        stringArrayList = new ArrayList<>(List.of(strings));

    }


    public static void showLines(){
        ArrayList<String> lines = ui.getUiLines();
        System.out.println("Current board:");
        for (String line: lines) {
            System.out.println(line);
        }
    }


    /**
     * If the ArrayList contains the sequence 1, 2, 3, or 1, 4, 7, or 1, 5, 9, or 2, 5, 8, or 3, 6, 9, in any particular order, then return true
     *
     * @param charSeq The sequence of characters that the player has chosen.
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
        } else return charSeq.contains("3") && charSeq.contains("6") && charSeq.contains("9");

    }


    public void play(){

        System.out.println("Welcome to TicTacToe!!!");
        System.out.println("1. Single or, 2. Multi-player?");
        System.out.println("Select 1 or 2...");
        String userIn = scanner.nextLine();


        if (userIn.equalsIgnoreCase("1")){
            System.out.println("Launching single player...");
            char p1Char = 'X', p2Char = 'O';
            Player player1 = new Player(p1Char);
            Player player2 = new Player(p2Char);

            // start game here
            while ( true ){

                if (runTimeData.getOccupiedSquares().size() == 9) break;

                showLines();
                System.out.println("Player1:");
                userIn = scanner.nextLine();

                if (runTimeData.ifBlockOccupied(userIn)){
                    while (runTimeData.ifBlockOccupied(userIn)){
                        System.out.println("Block Taken!");
                        showLines();
                        System.out.println("Player1:");
                        userIn = scanner.nextLine();
                    }

                }
                runTimeData.takeSquare(ui, userIn, player1.getCharacter());
                player1.setPlaySeq(userIn);

                if (checkSeq(player1.getGamePlaySeq())){
                    showLines();
                    System.out.println("Game Over!!!");
                    System.out.println("Player 1 Won!!!");
                    break;
                }

                //------------------------------------------------------------------------------------------------------
                if (runTimeData.getOccupiedSquares().size() == 9) break;

                showLines();

                System.out.println("Player2:");

                userIn = player2.autoPlay(stringArrayList);
                System.out.println(userIn);

                if (runTimeData.ifBlockOccupied(userIn)){
                    while (runTimeData.ifBlockOccupied(userIn)){
                        System.out.println("Block Taken!");
                        showLines();
                        System.out.println("Player2:");
                        userIn = player2.autoPlay(stringArrayList);
                        System.out.println(userIn);
                    }

                }

                runTimeData.takeSquare(ui, userIn, player2.getCharacter());
                player2.setPlaySeq(userIn);

                if (checkSeq(player2.getGamePlaySeq())){
                    showLines();
                    System.out.println("Game Over!!!");
                    System.out.println("Player 2 Won!!!");
                    break;
                }

            }


        } else if (userIn.equalsIgnoreCase("2")) {

            System.out.println("Launching multi player...");

            char p1Char = 'X', p2Char = 'O';
            Player player1 = new Player(p1Char);
            Player player2 = new Player(p2Char);

            // start game here
            while ( true ){

                if (runTimeData.getOccupiedSquares().size() == 9) break;

                showLines();

                System.out.println("Player1:");
                userIn = scanner.nextLine();

                if (runTimeData.ifBlockOccupied(userIn)){
                    while (runTimeData.ifBlockOccupied(userIn)){
                        System.out.println("Block Taken!");
                        showLines();
                        System.out.println("Player1:");
                        userIn = scanner.nextLine();
                    }
                }

                runTimeData.takeSquare(ui, userIn, player1.getCharacter());
                player1.setPlaySeq(userIn);

                if (checkSeq(player1.getGamePlaySeq())){
                    showLines();
                    System.out.println("Game Over!!!");
                    System.out.println("Player 1 Won!!!");
                    break;
                }



                //------------------------------------------------------------------------------------------------------
                if (runTimeData.getOccupiedSquares().size() == 9) break;
                showLines();

                System.out.println("Player2:");
                userIn = scanner.nextLine();

                if (runTimeData.ifBlockOccupied(userIn)){
                    while (runTimeData.ifBlockOccupied(userIn)){
                        System.out.println("Block Taken!");
                        showLines();
                        System.out.println("Player2:");
                        userIn = scanner.nextLine();
                    }

                }
                runTimeData.takeSquare(ui, userIn, player2.getCharacter());
                player2.setPlaySeq(userIn);

                if (checkSeq(player2.getGamePlaySeq())){
                    showLines();
                    System.out.println("Game Over!!!");
                    System.out.println("Player 2 Won!!!");
                    break;
                }

            }

        }

    }


    public static void main(String[] args) {

        new TicTacToe().play();

    }

}
