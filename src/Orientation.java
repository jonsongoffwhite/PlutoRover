/**
 * Created by JHGWhite on 24/03/2017.
 */
public enum Orientation {
    N(0, 1), E(1, 0), S(0, -1), W(-1, 0);

    int i;
    int j;

    Orientation(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Returns the orientation clockwise on a compass to the current
    public Orientation rotateClockwise() {
        return Orientation.values()[(this.ordinal()+1) % 4];
    }

    // Returns the orientation anti-clockwise on a compass to the current
    public Orientation rotateAnticlockwise() {
        return Orientation.values()[(this.ordinal()+3) % 4];
    }
}
