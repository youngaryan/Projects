package pices;

public class Pawn {
    private int currentPositionX;
    private int currentPositionY;
    private Boolean upCase;

    public Pawn(Boolean upCase, int initialX, int initialY) {
        this.upCase = upCase;
        this.currentPositionX = initialX;
        this.currentPositionY = initialY;
    }
    public boolean isValidMove(int targetX, int targetY) {
        // Pawn move validation logic
        // Implement the specific rules for pawn movement

        // Check if the target position is within the board boundaries
        if (targetX < 0 || targetX >= 8 || targetY < 0 || targetY >= 8) {
            return false;


        }
