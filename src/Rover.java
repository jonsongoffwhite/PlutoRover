/**
 * Created by JHGWhite on 24/03/2017.
 */
public class Rover {

    // Rover's position properties
    private int x;
    private int y;
    private Orientation orientation;

    // Indicates whether the rover encountered an obstacle on its last run
    private boolean encounteredObstacle;

    // The grid that the rover is roaming
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

    public boolean didEncounterObstacle() {return encounteredObstacle;}


    // Runs a string of commands
    public void run(String commands) {
        encounteredObstacle = false;
        for (char c : commands.toCharArray()) {
            execute(c);
            if (encounteredObstacle)
                return;
        }
    }

    // Executes a single command
    private void execute(char command) {
        switch (command) {
            case 'F': forward(); break;
            case 'B': backward(); break;
            case 'L': left(); break;
            case 'R': right(); break;
        }
    }

    // Moves the rover forwards
    private void forward() {
        int newX = (x + orientation.i + grid.xSize) % grid.xSize;
        int newY = (y + orientation.j + grid.ySize) % grid.ySize;

        if (grid.obstacleMap[newX][newY]) {
            encounteredObstacle = true;
            return;
        }

        x = newX;
        y = newY;
    }

    // Moves the rover backwards
    private void backward() {
        int newX = (x - orientation.i + grid.xSize) % grid.xSize;
        int newY = (y - orientation.j + grid.ySize) % grid.ySize;

        if (grid.obstacleMap[newX][newY]) {
            encounteredObstacle = true;
            return;
        }


        x = newX;
        y = newY;
    }

    // Rotates the rover left
    private void left() {
        orientation = orientation.rotateAnticlockwise();
    }

    // Rotates the rover right
    private void right() {
        orientation = orientation.rotateClockwise();
    }
}
