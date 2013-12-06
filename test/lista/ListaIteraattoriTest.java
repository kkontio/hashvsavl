/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lista;

import java.util.Iterator;
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
public class ListaIteraattoriTest {

    public ListaIteraattoriTest() {
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
     * Test of hasNext method, of class ListaIteraattori.
     */
    @Test
    public void testHasNext() {
        LinkitettyLista instance = new LinkitettyLista();

        Iterator it = instance.iterator();
        boolean expResult = false;
        boolean result = it.hasNext();
        assertEquals(expResult, result);

        instance = new LinkitettyLista();
        instance.addLast("foo");
        it = instance.iterator();
        expResult = true;
        result = it.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class ListaIteraattori.
     */
    @Test
    public void testNext() {
        LinkitettyLista instance = new LinkitettyLista();

        Iterator it = instance.iterator();

        instance.addLast("foo");
        it = instance.iterator();
        String expResult = "foo";
        String result = (String)it.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class ListaIteraattori.
     */
    @Test
    public void testRemove() {
        LinkitettyLista instance = new LinkitettyLista();

        Iterator it = instance.iterator();

        instance.addLast("foo");
        it = instance.iterator();
        boolean expResult = false;
        it.next();
        boolean result = instance.empty();
        assertEquals(expResult, result);
    }

}