package hajautus;

import lista.LinkitettyLista;
import seula.Seula;

/**
 * Ylivuotolistoilla toteutettu geneerinen hajautusrakenne, joka tarjoaa
 * joukko-operaatiot insert, remove, contains
 * @author kkontio
 * @param <T> Listan tyyppi.
 */
public class Hajautustaulu<T> {

    private LinkitettyLista<T>[] taulu;
    private int pituus;
    private int avaimia;
    private int kynnys;

    /**
     * Luo hajautustaulun
     */
    public Hajautustaulu() {
        pituus = 503;
        taulu = new LinkitettyLista[pituus];
        avaimia = 0;
        kynnys = asetakynnys(pituus);
        
        for (int i=0;i<taulu.length;i++)
            taulu[i] = new LinkitettyLista<T>();
    }

    /**
     * Luo hajautustaulun, jonka alkukoko on annettua lukua seuraava
     * suurempi alkuluku.
     * @param koko
     */
    public Hajautustaulu(int koko) {
        taulu = new LinkitettyLista[Seula.seuraavaAlkuluku(koko)];
        pituus = koko;
        avaimia = 0;
        kynnys = asetakynnys(pituus);
        
        for (int i=0;i<taulu.length;i++)
            taulu[i] = new LinkitettyLista<T>();
    }

    /**
     * Lisaa avaimen hajautustauluun.
     * @param key Lisattava avain.
     * @return true = lisays onnistui, false = avain oli jo lisatty
     */
    public boolean insert(T key) {
        if (this.contains(key))
            return false;
        else {
            LinkitettyLista<T> l = taulu[hash(key)];
            l.addLast(key);
            this.avaimia++;
            if (this.avaimia > this.kynnys)
                uudelleenhajauta();
            return true;
        }
    }

    /**
     * Poistaa avaimen hajautustaulusta.
     * @param key Poistettava avain.
     * @return true = avain poistettiin, false = avainta ei loytynyt
     */
    public boolean remove(T key) {
        LinkitettyLista<T> l = taulu[hash(key)];
        boolean removed = l.remove(key);
        if (removed)
            this.avaimia--;
        return removed;
    }

    /**
     * Tarkastaa loytyyko avain hajautustaulusta.
     * @param key Etsittava avain.
     * @return true = loytyy, false = ei loydy
     */
    public boolean contains(T key) {
        LinkitettyLista<T> l = taulu[hash(key)];
        return l.contains(key);
    }

    /**
     * Hajauttaa avaimen rakenteeseen, avaimen tulee toteuttaa
     * hashCode(), jotta tama onnistuu.
     * @param key Hajautettava avain.
     * @return Avaimen sisaltavan ylivuotolistan indeksi.
     */
    private int hash(T key) {
        return Math.abs(key.hashCode()) % taulu.length;
    }

    /**
     * Asettaa avaimien lukumaaralle kynnysarvon, jonka ylityttya
     * tehdaan uudelleenhajautus noin kaksi kertaa suurempaan
     * hajautustauluun.
     * @param pituus Hajautustaulun pituus.
     * @return Kynnysarvo.
     */
    private int asetakynnys(int pituus) {
        return pituus*3;
    }

    /**
     * Uudelleenhajauttaa avaimet noin kaksi kertaa suurempaan
     * hajautustauluun.
     */
    private void uudelleenhajauta() {
        // seula alkaa hidastumaan suuremmilla luvuilla
        if (this.pituus > 20000)
            this.pituus = 2 * this.pituus;
        else
            this.pituus = Seula.seuraavaAlkuluku(2*this.pituus);
        this.kynnys = asetakynnys(this.pituus);
        LinkitettyLista<T>[] vanha = this.taulu;
        LinkitettyLista<T>[] uusi = new LinkitettyLista[this.pituus];
        this.taulu = uusi;
        this.avaimia = 0;
        
        for (int i=0;i<this.taulu.length;i++)
            this.taulu[i] = new LinkitettyLista<T>();
        
        for (LinkitettyLista<T> l : vanha)
            for (Object key : l) 
                this.insert((T)key);
    }
}
