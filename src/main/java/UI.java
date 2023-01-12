
import java.util.ArrayList;

public class UI {
    ArrayList<String> uiLines;

    public UI(){
        uiLines = new ArrayList<>();
        boardInit();
    }


    public void boardInit(){
        uiLines.add("*******************");
        uiLines.add("*     *     *     *");// 3 9 15 - 1
        uiLines.add("*******************");
        uiLines.add("*     *     *     *");// 3 9 15 - 3
        uiLines.add("*******************");
        uiLines.add("*     *     *     *");// 3 9 15 - 5
        uiLines.add("*******************");
    }


    /**
     * This function returns the uiLines ArrayList.
     *
     * @return An ArrayList of Strings
     */
    public ArrayList<String> getBoard() {
        return uiLines;
    }


    /**
     * This function takes in a block number and a character and replaces the character in the block with the new character
     *
     * @param blockNum the block number that the user wants to edit
     * @param character the character that the user has entered
     */
    public void editBoard(String blockNum, char character){
        String currLine;
        // get uiLine and replace it with new character
        switch (blockNum){

            // copy line from list // modify line and // replace line with modified line
            case ("1"): {

                currLine = getBoard().get(1);
                int index = 3;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(1, currLine);
                break;


            } case ("2"): {

                currLine = getBoard().get(1);

                int index = 9;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(1, currLine);
                break;

            } case("3"): {

                currLine = getBoard().get(1);

                int index = 15;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(1, currLine);
                break;

            } case("4"): {

                currLine = getBoard().get(3);
                int index = 3;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(3, currLine);
                break;

            } case("5"): {

                currLine = getBoard().get(3);

                int index = 9;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(3, currLine);
                break;

            } case ("6"): {

                currLine = getBoard().get(3);

                int index = 15;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(3, currLine);
                break;

            } case ("7"): {

                currLine = getBoard().get(5);
                int index = 3;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(5 ,currLine);
                break;

            } case ("8"): {

                currLine = getBoard().get(5);
                int index = 9;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(5, currLine);
                break;

            } case ("9"): {

                currLine = getBoard().get(5);
                int index = 15;

                currLine = currLine.substring(0, index) + character
                        + currLine.substring(index + 1);

                modifyBoard(5, currLine);
                break;
            }
        }


    }


    /**
     * This function takes a string and sets the second line of the uiLines array to that string.
     *
     * @param line The line to be modified.
     */
    public void modifyBoard(int atLine, String line){
        this.uiLines.set(atLine, line);
    }

}
