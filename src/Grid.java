import java.util.HashMap;

/**
 * Created by JHGWhite on 24/03/2017.
 */
public class Grid {

    // Width of the grid
    public final int xSize;

    // Height of the grid
    public final int ySize;

    // Map representing which co-ordinates contain obstacles
    public final boolean[][] obstacleMap;

    // Initialise with no obstacles
    public Grid(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

        this.obstacleMap = new boolean[xSize][ySize];
    }

    // Initialise with provided obstacle map
    public Grid(int xSize, int ySize, boolean[][] obstacleMap) {
        this.xSize = xSize;
        this.ySize = ySize;

        this.obstacleMap = obstacleMap;
    }

}
