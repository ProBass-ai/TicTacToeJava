import java.util.ArrayList;

public class RunTimeData {

    // this is so that a user does not occupy squares that
    // already occupied
    ArrayList<String> occupiedSquares = new ArrayList<>();


    public void takeSquare(String square){
        occupiedSquares.add(square);
    }

    public ArrayList<String> getOccupiedSquares() {
        return occupiedSquares;
    }


}
