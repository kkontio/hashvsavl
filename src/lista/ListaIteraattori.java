
package lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iteraattori linkitetylle listalle
 * @author kkontio
 * @param <T> Iteraattorin tyyppi.
 */
public class ListaIteraattori<T> implements Iterator {
    private LinkitettyLista<T> l;
    private ListaSolmu<T> x;
    private ListaSolmu<T> prev;
    private int listsize;
    private int counter;
    private boolean removecalled;

    public ListaIteraattori(LinkitettyLista<T> l) {
        this.l = l;
        this.x = null;
        this.prev = null;
        this.listsize = l.size();
        this.counter = 0;
        this.removecalled = true;
    }

    /**
     * Tarkastaa onko iteraattorilla seuraavaa alkiota.
     * @return true = on, false = ei ole.
     */
    public boolean hasNext() {
        return (counter<listsize);
    }

    /**
     * Palauttaa seuraavan alkion tai heittaa poikkeuksen,
     * jos sita ei ole.
     * @return Seuraava alkio.
     */
    public T next() {
        if (this.hasNext() && counter == 0) {
            x = l.top;
            prev = null;
            counter++;
            removecalled = false;
            return x.key;
        } else if (this.hasNext()) {
            prev = x;
            x = x.next;
            counter++;
            removecalled = false;
            return x.key;
        } else {
            throw new NoSuchElementException("No more items on this list.");
        }
    }

    /**
     * Poistaa tamanhetkisen alkion, heittaa poikkeuksen
     * jos alkiota ei ole tai se on jo poistettu.
     */
    public void remove() {
        if (removecalled)
            throw new IllegalStateException("No current object or already removed!");
        if (prev == null && x.next != null) { //poistettiin eka
            l.top = x.next;
            removecalled = true;
            return;
        }
        if (prev != null && x.next == null) { //poistettiin vika
            prev.next = null;
            l.bot = prev;
            removecalled = true;
            return;
        }
        if (prev == null && x.next == null) { //poistettiin ainut
            l.top = null;
            l.bot = null;
            removecalled = true;
            return;
        }
        // poistettiin valilta
        prev.next = x.next;
        removecalled = true;
    }

}
