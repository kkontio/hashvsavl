/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lista;

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
public class ListaSolmuTest {

    public ListaSolmuTest() {
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
        ListaSolmu<Integer> s = new ListaSolmu<Integer>(1, null);
        boolean expresult1 = (s.key == 1);
        boolean expresult2 = (s.next == null);
        assertEquals(expresult1, true);
        assertEquals(expresult2, true);
    }

}