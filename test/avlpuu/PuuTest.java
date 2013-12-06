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
public class PuuTest {

    public PuuTest() {
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
     * Test of add method, of class Puu.
     */
    @Test
    public void testAdd() {
        String k = "foobar";
        Puu<String> instance = new Puu<String>();
        boolean expResult = true;
        boolean result = instance.add(k);
        assertEquals(expResult, result);
        expResult = true;
        result = instance.add("bar");
        assertEquals(expResult, result);
        expResult = true;
        result = instance.add("kek");
        assertEquals(expResult, result);
        expResult = true;
        result = instance.add("bur");
        assertEquals(expResult, result);
        expResult = false;
        result = instance.add("bar");
        assertEquals(expResult, result);
        expResult = false;
        result = instance.add("bur");
        assertEquals(expResult, result);
        expResult = false;
        result = instance.add("kek");
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Puu.
     */
    @Test
    public void testRemove() {
        String k = "foobar";
        Puu<String> instance = new Puu<String>();
        instance.add(k);
        boolean expResult = true;
        boolean result = instance.remove(k);
        assertEquals(expResult, result);
        expResult = false;
        instance.add("bar");
        result = instance.remove("barrr");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("kek");
        result = instance.remove("kek");
        assertEquals(expResult, result);
        expResult = false;
        instance.add("longcat");
        result = instance.remove("loooooongcat");
        assertEquals(expResult, result);
        expResult = false;
        instance.add("lulz");
        result = instance.remove("lolz");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("foo");
        result = instance.remove("foo");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("bur");
        result = instance.remove("bur");
        assertEquals(expResult, result);
        expResult = false;
        result = instance.remove("bur");
        assertEquals(expResult, result);
        expResult = false;
        result = instance.remove("kek");
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Puu.
     */
    @Test
    public void testContains() {
        String k = "foobar";
        Puu<String> instance = new Puu<String>();
        instance.add(k);
        boolean expResult = true;
        boolean result = instance.contains(k);
        assertEquals(expResult, result);
        expResult = false;
        instance.add("bar");
        result = instance.contains("barrr");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("kek");
        result = instance.contains("kek");
        assertEquals(expResult, result);
        expResult = false;
        instance.add("longcat");
        result = instance.contains("loooooongcat");
        assertEquals(expResult, result);
        expResult = false;
        instance.add("lulz");
        result = instance.contains("lolz");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("foo");
        result = instance.contains("foo");
        assertEquals(expResult, result);
        expResult = true;
        instance.add("bur");
        result = instance.contains("bur");
        assertEquals(expResult, result);
    }

}