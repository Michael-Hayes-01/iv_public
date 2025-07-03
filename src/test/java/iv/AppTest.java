package iv;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {

    List<Integer> li;

    @Before
    public void init() {
        li = new ArrayList<>();
    }

    @Test
    public void nullTest() {
        assertNull(null);
    }

    @Test(expected = NullPointerException.class)
    public void exceptionTest() {
        throw new NullPointerException("expected null ptr exception test");
    }

    @Test
    public void duplicateTest() {
        assertNull(null);
    }

    @Test
    public void boundsTest() {
        assertTrue(true);
    }

    @Test
    public void sizeTest() {
        assertEquals(0, li.size());
    }
}