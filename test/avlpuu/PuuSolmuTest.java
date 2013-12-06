/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avlpuu;

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
public class PuuSolmuTest {

    public PuuSolmuTest() {
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

    @Test
    public void testConstructor() {
        PuuSolmu<String> s = new PuuSolmu<String>("foobar");
        assertEquals(s.key, "foobar");

    }

}