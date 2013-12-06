package lista;

import java.util.Iterator;
/**
 * Yhteen suuntaan linkitetty lista.
 *
 */
public class LinkitettyLista<T> implements Iterable {
    ListaSolmu<T> top;
    ListaSolmu<T> bot;

    /**
     * Luo tyhjan listan.
     */
    public LinkitettyLista() {
        top = null;
        bot = null;
    }

    /**
     * Lisaa avaimen viimeiseksi listalla.
     * @param k Lisattava avain.
     */
    public void addLast(T k) {
        ListaSolmu<T> x = new ListaSolmu<T>(k, null);
        if (this.empty())
            top = x;
        else
            bot.next = x;
        bot = x;
    }

    /**
     * Lisaa avaimen ensimmaiseksi listalla.
     * @param k Lisattava avain.
     */
    public void addFirst(T k) {
        ListaSolmu<T> x = new ListaSolmu<T>(k, top);
        if (this.empty())
            bot = x;
        top = x;
    }

    /**
     * Palauttaa avaimen indeksista i tai heittaa poikkeuksen,
     * jos indeksi virheellinen
     * @param i Avaimen indeksi.
     * @return Avain indeksissa i.
     */
    public T get(int i) {
        if (i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException("Index out of bounds!");
        ListaSolmu<T> x = top;
        while (i > 0) {
            x = x.next;
            i--;
        }
        return x.key;
    }

    /**
     * Palauttaa ensimmaisen avaimen listalta, mutta ei poista sita.
     * @return Ensimmainen avain listalla.
     */
    public T peek() {
        if (this.empty())
            return null;
        return top.key;
    }

    /**
     * Palauttaa ja poistaa ensimmaisen avaimen listalta.
     * @return Ensimmainen avain listalla.
     */
    public T removeFirst() {
        if (this.empty())
            return null;
        ListaSolmu<T> x = top;
        top = x.next;
        if (top == null)
            bot = null;
        return x.key;
    }

    /**
     * Poistaa avaimen k listalta.
     * @param k Poistettava avain.
     * @return true = avain poistettiin, false = avainta ei loytynyt
     */
    public boolean remove(T k) {
        ListaSolmu<T> x = top;
        ListaSolmu<T> prev = null;
        while (x != null) {
            if (x.key.equals(k)) {
                remove(x, prev);
                return true;
            }
            prev = x;
            x = x.next;
        }
        return false;
    }

    /**
     * Poistaa avaimen indeksissa i. Heittaa poikkuksen, jos indeksi
     * on virheellinen.
     * @param i Poistettavan avaimen indeksi.
     * @return Poistettu avain.
     */
    public T remove(int i) {
        if (i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException();
        ListaSolmu<T> x = this.top;
        ListaSolmu<T> prev = null;
        int counter = 0;
        while (counter < i) {
            prev = x;
            x = x.next;
            counter++;
        }
        remove(x, prev);
        return x.key;
    }

    /**
     * Poistaa solmun listalta.
     * @param x Poistettava solmu.
     * @param prev Poistettava edeltava solmu.
     */
    private void remove(ListaSolmu<T> x, ListaSolmu<T> prev) {
        if (prev == null && x.next == null) { //poistettiin ainut
            top = null;
            bot = null;
            return;
        }
        if (prev == null) { //poistettiin eka
            top = x.next;
            return;
        }
        if (x.next == null) { //poistettiin vika
            bot = prev;
            prev.next = null;
            return;
        }
        //poistettiin valilta
        prev.next = x.next;

    }

    /**
     * Tarkastaa onko lista tyhja.
     * @return true = lista tyhja, false = lista ei tyhja
     */
    public boolean empty() {
        return (top == null);
    }

    
    /**
     * Palauttaa listan pituuden.
     * @return Listan pituus.
     */
    public int size() {
        int lkm = 0;
        ListaSolmu<T> x = top;
        while (x != null) {
            lkm += 1;
            x = x.next;
        }
        return lkm;
    }

    /**
     * Tarkastaa onko avain listalla.
     * @param k Etsittava avain.
     * @return true = avain listalla, false = avain ei listalla
     */
    public boolean contains(T k) {
        ListaSolmu<T> x = top;
        while (x != null) {
            if (x.key.equals(k))
                return true;
            x = x.next;
        }
        return false;
    }

    /**
     * Palauttaa listaiteraattorin.
     * @return Iteraattori.
     */
    public Iterator<T> iterator() {
        return new ListaIteraattori<T>(this);
    }

    /**
     * Palauttaa iteraattorin joka osoittaa indeksiin i.
     * @param i Haluttu indeksi
     * @return Iteraattori
     */
    public Iterator<T> iterator(int i) {
        if (i < 0 || i >= this.size())
            throw new IndexOutOfBoundsException();
        Iterator<T> it = new ListaIteraattori<T>(this);
        while (i > 0) {
            it.next();
            i--;
        }
        return it;
    }

    /**
     * Tulostaa listan avaimet.
     */
    public void print() {
        ListaSolmu<T> x = top;
        while (x != null) {
            System.out.println(x.key);
            x = x.next;
        }
    }
}