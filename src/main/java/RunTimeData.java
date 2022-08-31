import java.util.ArrayList;

public class RunTimeData {

    // this is so that a user does not occupy squares that
    // already occupied
    ArrayList<String> occupiedSquares = new ArrayList<>();
    ArrayList<String> uiLines;


    public void takeSquare(UI ui,String square, char Char){
        occupiedSquares.add(square);
        ui.editUILines(square, Char);
    }

    public ArrayList<String> getOccupiedSquares() {
        return occupiedSquares;
    }

    public boolean ifBlockUnoccupied(UI ui, String attemptedBlock){
        return !getOccBlock(ui, attemptedBlock);
    }


    /**
     * This function checks if the attempted block is occupied by a player or not
     *
     * @param ui
     * @param attemptedBlock The block that the player is attempting to place their marker in.
     * @return A boolean value.
     */
    public boolean getOccBlock(UI ui, String attemptedBlock) {

        uiLines = ui.getUiLines();

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
