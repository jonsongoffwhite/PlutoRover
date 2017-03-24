/**
 * Created by JHGWhite on 24/03/2017.
 */
public class Rover {

    // Rover's position properties
    private int x;
    private int y;
    private Orientation orientation;

    private Grid grid;

    public Rover(int x, int y, Orientation orientation, Grid grid) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.grid = grid;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public Orientation getOrientation() {return orientation;}

    // Runs a string of commands, returns false if uninterrupted
    public boolean run(String commands) {
        for (char c : commands.toCharArray()) {
            if(execute(c)) return true;
        }
        return false;
    }

    // Executes a single command, returns false if uninterrupted
    private boolean execute(char command) {
        switch (command) {
            case 'F': return forward();
            case 'B': return backward();
            case 'L': return left();
            case 'R': return right();
        }
        return false;
    }

    // Moves the rover forwards, returns false if uninterrupted
    private boolean forward() {
        int newX = (x + orientation.i + grid.xSize) % grid.xSize;
        int newY = (y + orientation.j + grid.ySize) % grid.ySize;

        if (grid.obstacleMap[newX][newY])
            return true;

        x = newX;
        y = newY;

        return false;
    }

    // Moves the rover backwards, returns false if uninterrupted
    private boolean backward() {
        int newX = (x - orientation.i + grid.xSize) % grid.xSize;
        int newY = (y - orientation.j + grid.ySize) % grid.ySize;

        if (grid.obstacleMap[newX][newY])
            return true;

        x = newX;
        y = newY;

        return false;
    }

    // Rotates the rover left, always uninterrupted
    private boolean left() {
        orientation = orientation.rotateAnticlockwise();
        return false;
    }

    // Rotates the rover right, always uninterrupted
    private boolean right() {
        orientation = orientation.rotateClockwise();
        return false;
    }



}
