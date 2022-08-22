
import java.util.ArrayList;

public class UI {
    ArrayList<String> uiLines = new ArrayList<>();

    public UI(){
        uiLines.add("******************");
        uiLines.add("*    **    **    *");// 2 8 14 - 1
        uiLines.add("******************");
        uiLines.add("*    **    **    *");// 2 8 14 - 3
        uiLines.add("******************");
        uiLines.add("*    **    **    *");// 2 8 14 - 5
        uiLines.add("******************");
    }


    /**
     * This function returns the uiLines ArrayList.
     *
     * @return An ArrayList of Strings
     */
    public ArrayList<String> getUiLines() {
        return uiLines;
    }


    /**
     * This function takes in a block number and a character and replaces the character in the block with the new character
     *
     * @param blockNum the block number that the user wants to edit
     * @param character the character that the user has entered
     */
    public void editUILines(String blockNum, char character){
        String currLine;
        // get uiLine and replace it with new character
        if (blockNum.equalsIgnoreCase("1")) {
            // copy line from list // modify line and // replace line with modified line
            currLine = getUiLines().get(1);
            int index = 2;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(1, currLine);


        } else if (blockNum.equalsIgnoreCase("2")) {
            currLine = getUiLines().get(1);

            int index = 8;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(1, currLine);


        } else if (blockNum.equalsIgnoreCase("3")) {
            currLine = getUiLines().get(1);

            int index = 14;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(1, currLine);


        } else if (blockNum.equalsIgnoreCase("4")) {
            currLine = getUiLines().get(3);
            int index = 2;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(3, currLine);

        } else if (blockNum.equalsIgnoreCase("5")) {
            currLine = getUiLines().get(3);

            int index = 8;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(3, currLine);

        } else if (blockNum.equalsIgnoreCase("6")) {
            currLine = getUiLines().get(3);

            int index = 14;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(3, currLine);

        } else if (blockNum.equalsIgnoreCase("7")) {
            currLine = getUiLines().get(5);
            int index = 2;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(5 ,currLine);

        } else if (blockNum.equalsIgnoreCase("8")) {
            currLine = getUiLines().get(5);
            int index = 8;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(5, currLine);

        } else if (blockNum.equalsIgnoreCase("9")) {
            currLine = getUiLines().get(5);
            int index = 14;

            currLine = currLine.substring(0, index) + character
                    + currLine.substring(index + 1);

            modifyGraph(5, currLine);
        }

    }


    /**
     * This function takes a string and sets the second line of the uiLines array to that string.
     *
     * @param line The line to be modified.
     */
    public void modifyGraph(int atLine, String line){
        this.uiLines.set(atLine, line);
    }


    /**
     * This function checks if the attempted block is occupied by a player or not
     *
     * @param attemptedBlock The block that the player is attempting to place their marker in.
     * @return A boolean value.
     */
    public boolean getOccBlock(String attemptedBlock) {

        if (attemptedBlock.equalsIgnoreCase("1")) {
            return (uiLines.get(1).substring(2, 3).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("2")) {
            return (uiLines.get(1).substring(8, 9).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("3")) {
            return (uiLines.get(1).substring(14, 15).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("4")) {
            return (uiLines.get(3).substring(2, 3).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("5")) {
            return (uiLines.get(3).substring(8, 9).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("6")) {
            return (uiLines.get(1).substring(14, 15).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("7")) {
            return (uiLines.get(1).substring(2, 3).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("8")) {
            return (uiLines.get(3).substring(8, 9).equalsIgnoreCase(" "));

        } else if (attemptedBlock.equalsIgnoreCase("9")) {
            return (uiLines.get(1).substring(14, 15).equalsIgnoreCase(" "));
        }

        return false;
    }

}
