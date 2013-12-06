/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seula;

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
public class SeulaTest {

    public SeulaTest() {
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
     * Test of seuraavaAlkuluku method, of class Seula.
     */
    @Test
    public void testSeuraavaAlkuluku() {
        int luku = 123456;
        int expResult = 123457;
        int result = Seula.seuraavaAlkuluku(luku);
        assertEquals(expResult, result);
    }

}