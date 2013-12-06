/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hajautus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kkontio
 */
public class HajautustauluTest {

    public HajautustauluTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Hajautustaulu.
     */
    @Test
    public void testInsert() {
        String key = "foobar";
        Hajautustaulu<String> instance = new Hajautustaulu();
        instance.insert(key);
        assertTrue(instance.contains("foobar"));
        key = "foobar";
        instance = new Hajautustaulu(500);
        instance.insert(key);
        assertTrue(instance.contains("foobar"));
    }

    /**
     * Test of remove method, of class Hajautustaulu.
     */
    @Test
    public void testRemove() {
        String key = "foobar";
        Hajautustaulu<String> instance = new Hajautustaulu();
        instance.insert(key);
        assertFalse(instance.remove("bar"));
        assertTrue(instance.remove("foobar"));
        key = "foobar";
        instance = new Hajautustaulu(500);
        instance.insert(key);assertFalse(instance.remove("bar"));
        assertTrue(instance.remove("foobar"));
    }

    /**
     * Test of contains method, of class Hajautustaulu.
     */
    @Test
    public void testContains() {
        String key = "foobar";
        Hajautustaulu<String> instance = new Hajautustaulu();
        instance.insert(key);
        assertTrue(instance.contains("foobar"));
        instance.remove("foobar");
        assertFalse(instance.contains("foobar"));
        key = "foobar";
        instance = new Hajautustaulu(500);
        instance.insert(key);assertFalse(instance.remove("bar"));
        assertTrue(instance.contains("foobar"));
        instance.remove("foobar");
        assertFalse(instance.contains("foobar"));
    }

}