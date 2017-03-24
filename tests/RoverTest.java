import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by JHGWhite on 24/03/2017.
 */
public class RoverTest {

    @Test
    public void forwardCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("F");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void backwardCommandTest() throws Exception {

        Rover rover = new Rover(1, 1, Orientation.N, new Grid(100, 100));

        rover.run("B");

        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void rotationLeftCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("L");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void rotationRightCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("R");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void compoundCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("FFRFF");

        assertThat(rover.getX(), is(2));
        assertThat(rover.getY(), is(2));
        assertThat(rover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void wrappingXMovementTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("LF");

        assertThat(rover.getX(), is(99));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void wrappingYMovementTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N, new Grid(100, 100));

        rover.run("B");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(99));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

}