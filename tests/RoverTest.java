import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by JHGWhite on 24/03/2017.
 */
public class RoverTest {

    @Test
    public void forwardCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N);

        rover.run("F");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void rotationCommandTest() throws Exception {

        Rover rover = new Rover(0, 0, Orientation.N);

        rover.run("L");

        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.W));

    }

}