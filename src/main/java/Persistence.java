import java.util.ArrayList;

public class Persistence {

    // this is so that a user does not occupy squares that
    // already occupied
    ArrayList<String> occupiedSquares = new ArrayList<>();

    public void takeSquare(String square){
        occupiedSquares.add(square);
    }

    public ArrayList<String> getOccupiedSquares() {
        return occupiedSquares;
    }

    public boolean ifBlockOccupied(String attemptedBlock){
        return occupiedSquares.contains(attemptedBlock);
    }


}
