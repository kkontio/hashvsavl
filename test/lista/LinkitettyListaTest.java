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
public class LinkitettyListaTest {

    public LinkitettyListaTest() {
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
     * Test of addLast method, of class LinkitettyLista.
     */
    @Test
    public void testAddLast() {
        Object k = "testi";
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(k);
        assertEquals(instance.peek(), k);
    }

    /**
     * Test of addFirst method, of class LinkitettyLista.
     */
    @Test
    public void testAddFirst() {
        Object k = "testi";
        LinkitettyLista instance = new LinkitettyLista();
        instance.addFirst(k);
        assertEquals(instance.peek(), k);
    }

    /**
     * Test of get method, of class LinkitettyLista.
     */
    @Test
    public void testGet() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(1);
        instance.addLast(2);
        instance.addLast(3);
        instance.addLast(4);
        Object expResult = 1;
        Object result = instance.get(0);
        assertEquals(expResult, result);
        expResult = 2;
        result = instance.get(1);
        assertEquals(expResult, result);
        expResult = 3;
        result = instance.get(2);
        assertEquals(expResult, result);
        expResult = 4;
        result = instance.get(3);
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class LinkitettyLista.
     */
    @Test
    public void testPeek() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addFirst(1);
        Object expResult = 1;
        Object result = instance.peek();
        assertEquals(expResult, result);
        instance.addFirst(2);
        expResult = 2;
        result = instance.peek();
        assertEquals(expResult, result);
        instance.addFirst(3);
        expResult = 3;
        result = instance.peek();
        assertEquals(expResult, result);
        instance.addFirst(4);
        expResult = 4;
        result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFirst method, of class LinkitettyLista.
     */
    @Test
    public void testRemoveFirst() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(1);
        instance.addLast(2);
        instance.addLast(3);
        instance.addLast(4);
        Object expResult = 1;
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
        expResult = 2;
        result = result = instance.removeFirst();
        assertEquals(expResult, result);
        expResult = 3;
        result = result = instance.removeFirst();
        assertEquals(expResult, result);
        expResult = 4;
        result = result = instance.removeFirst();
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class LinkitettyLista.
     */
    @Test
    public void testRemove_GenericType() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast("matti");
        instance.addLast("teppo");
        instance.addLast("seppo");
        instance.addLast("kekkonen");
        boolean result = instance.remove("matti");
        assertTrue(result);
        result = instance.remove("kekkonen");
        assertTrue(result);
        result = instance.remove("martti");
        assertFalse(result);
    }

    /**
     * Test of remove method, of class LinkitettyLista.
     */
    @Test
    public void testRemove_int() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(1);
        instance.addLast(2);
        instance.addLast(3);
        instance.addLast(4);
        Object expResult = 1;
        Object result = instance.remove(0);
        assertEquals(expResult, result);
        expResult = 2;
        result = instance.remove(0);
        assertEquals(expResult, result);
        expResult = 3;
        result = instance.remove(0);
        assertEquals(expResult, result);
        expResult = 4;
        result = instance.remove(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class LinkitettyLista.
     */
    @Test
    public void testEmpty() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(1);
        assertFalse(instance.empty());
        Object result = instance.remove(0);
        assertTrue(instance.empty());
    }

    /**
     * Test of size method, of class LinkitettyLista.
     */
    @Test
    public void testSize() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast(1);
        instance.addLast(2);
        instance.addLast(3);
        instance.addLast(4);
        int expResult = 3;
        instance.remove(0);
        int result = instance.size();
        assertEquals(expResult, result);
        expResult = 2;
        instance.remove(0);
        result = instance.size();
        assertEquals(expResult, result);
        expResult = 1;
        instance.remove(0);
        result = instance.size();
        assertEquals(expResult, result);
        expResult = 0;
        instance.remove(0);
        result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class LinkitettyLista.
     */
    @Test
    public void testContains() {
        LinkitettyLista instance = new LinkitettyLista();
        instance.addLast("matti");
        instance.addLast("teppo");
        instance.addLast("seppo");
        instance.addLast("kekkonen");
        boolean result = instance.contains("matti");
        assertTrue(result);
        result = instance.contains("kekkonen");
        assertTrue(result);
        result = instance.contains("martti");
        assertFalse(result);
    }

}