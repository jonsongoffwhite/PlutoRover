import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by JHGWhite on 24/03/2017.
 */
public class OrientationTest {

    @Test
    public void testRotateClockwise() throws Exception {
        Orientation o = Orientation.N;

        o = o.rotateClockwise();

        assertThat(o, is(Orientation.E));
    }

    @Test
    public void testRotateAnticlockwise() throws Exception {
        Orientation o = Orientation.N;

        o = o.rotateAnticlockwise();

        assertThat(o, is(Orientation.W));
    }
}