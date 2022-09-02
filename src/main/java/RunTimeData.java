import java.util.ArrayList;

public class RunTimeData {

    // this is so that a user does not occupy squares that
    // already occupied
    ArrayList<String> occupiedSquares = new ArrayList<>();


    public void takeSquare(UI ui, String square, char Char){
        occupiedSquares.add(square);
        ui.editUILines(square, Char);
    }

    public ArrayList<String> getOccupiedSquares() {
        return occupiedSquares;
    }

    public boolean ifBlockOccupied(String attemptedBlock){
        return occupiedSquares.contains(attemptedBlock);
    }


}
