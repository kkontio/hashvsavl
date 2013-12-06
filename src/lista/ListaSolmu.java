package lista;

/**
 * Geneerisen yhteen suuntaan linkitetyn listan solmu.
 * @author kkontio
 * @param <T> Solmun tyyppi.
 */
public class ListaSolmu<T> {
    T key;
    ListaSolmu<T> next;

    /**
     * Luo solmun jonka avain key ja seuraava solmu next
     * annetaan parametreina.
     * @param key Solmun avain.
     * @param next Solmua seuraava solmu.
     */
    public ListaSolmu(T key, ListaSolmu next) {
        this.key = key;
        this.next = next;
    }
}