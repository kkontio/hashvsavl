package avlpuu;

/**
 * AVL-puu
 * @author kkontio
 */
public class Puu<T> {

    private PuuSolmu<T> juuri;

    /**
     * Luo tyhjan puun.
     */
    public Puu() {
        juuri = null;
    }

    /**
     * Lisaa avaimen puuhun. Suorittaa tarvittaessa tasapainotusoperaatiot.
     * @param k, avain
     * @return true = lisays onnistui, false = lisays epaonnistui
     */
    public boolean add(T k) {
        PuuSolmu<T> uusi = this.insert(k);
        if (uusi == null) //avain oli jo puussa!
            return false;
        PuuSolmu<T> p = uusi.parent;
        while (p != null) {
            if (height(p.left) == height(p.right) + 2) { //epatasapaino vasen
                PuuSolmu<T> vvanhempi = p.parent;
                PuuSolmu<T> valipuu;
                if (height(p.left.left) > height(p.left.right)) {
                    valipuu = rightRotate(p);
                } else {
                    valipuu = leftRightRotate(p);
                }
                if (vvanhempi == null) {
                    this.juuri = valipuu;
                } else if(vvanhempi.left == p) {
                    vvanhempi.left = valipuu;
                } else {
                    vvanhempi.right = valipuu;
                }
                if (vvanhempi != null) {
                    vvanhempi.height = Math.max(height(vvanhempi.left), height(vvanhempi.right)) + 1;
                }
                return true;
            }
            if (height(p.right) == height(p.left) + 2) { //epatasapaino oikea
                PuuSolmu<T> ovanhempi = p.parent;
                PuuSolmu<T> oalipuu;
                if (height(p.right.right) > height(p.right.left)) {
                    oalipuu = leftRotate(p);
                } else {
                    oalipuu = rightLeftRotate(p);
                }
                if (ovanhempi == null) {
                    this.juuri = oalipuu;
                } else if (ovanhempi.left == p) {
                    ovanhempi.left = oalipuu;
                } else {
                    ovanhempi.right = oalipuu;
                }
                if (ovanhempi != null) {
                    ovanhempi.height = Math.max(height(ovanhempi.left), height(ovanhempi.right)) + 1;
                }
                return true;
            }
            p.height = Math.max(height(p.left), height(p.right)) + 1;
            p = p.parent;
        }
        return true;
    }

    /**
     * Poistaa avaimen puusta. Suorittaa tarvittaessa tasapainotuksen.
     * @param k Poistettava avain.
     * @return true = poisto onnistui, false = poisto epaonnistui
     */
    public boolean remove(T k) {
        PuuSolmu<T> poistettava = search(k);
        if (poistettava == null)
            return false;

        poistettava = delete(poistettava);

        PuuSolmu<T> p = poistettava.parent;

        while (p != null) {
            PuuSolmu<T> vanhempi;
            PuuSolmu<T> alipuu;
            if ((height(p.left) >= height(p.right) + 2) || (height(p.right) >= height(p.left) + 2)) {
                vanhempi = p.parent;
                // vasenvasen
                if ((height(p.left) >= height(p.right) + 2) && (height(p.left.left) >= height(p.left.right))) {
                    alipuu = rightRotate(p);
                }
                //vasenoikea
                else if ((height(p.left) >= height(p.right) + 2) && (height(p.left.right) > height(p.left.left))) {
                    alipuu = leftRightRotate(p);
                }
                //oikeaoikea
                else if ((height(p.right) >= height(p.left) + 2) && (height(p.right.right) >= height(p.right.left))) {
                    alipuu = leftRotate(p);
                }
                //oikeavasen
                else {
                    alipuu = rightLeftRotate(p);
                }
                //oliko vanhempi juuri
                if (vanhempi == null) {
                    this.juuri = alipuu;
                    return true;
                }
                if (p == vanhempi.left)
                    vanhempi.left = alipuu;
                else
                    vanhempi.right = alipuu;

                p = vanhempi;
            } else {
                p.height = Math.max(height(p.left), height(p.right)) + 1;
                p = p.parent;
            }
        }
        return true;
    }

    /**
     * Tarkastaa onko avain puussa.
     * @param k Etsittava avain.
     * @return true = avain on puussa, false = avain ei ole puussa
     */
    public boolean contains(T k) {
        PuuSolmu<T> s = search(k);
        if (s != null)
            return true;
        else
            return false;
    }

    /**
     * Etsii puusta solmun, jonka avain k.
     * @param k Etsittava avain.
     * @return Palauttaa solmun, jonka avain k. Tai null, jos
     * tallaista solmua ei loydy.
     */
    private PuuSolmu<T> search(T k) {
        Comparable kc = (Comparable)k;
        Comparable xc;
        PuuSolmu<T> x = this.juuri;
        
        while (x != null) {
            xc = (Comparable)x.key;
            if (xc.equals(kc))
                return x;
            if (kc.compareTo(xc) < 0)
                x = x.left;
            else
                x = x.right;
        }
        return null;
    }

    /**
     * Palauttaa solmun korkeuden. Tyhjan alipuun korkeus -1
     * @param s Solmu
     * @return Solmun korkeus.
     */
    private int height(PuuSolmu<T> s) {
        if (s == null)
            return -1;
        else
            return s.height;
    }

    /**
     * Binaarihakupuu-insert. Ei tasapainota!
     * @param k Lisattava avain.
     * @return Palauttaa viitteen lisattyyn solmuun tai null,
     * jos avain oli jo puussa.
     */
    private PuuSolmu<T> insert(T k) {
        if (this.contains(k)) //avain jo puussa!
            return null;
        
        PuuSolmu<T> uusi = new PuuSolmu<T>(k);
        uusi.left = uusi.right = uusi.parent = null;
        
        if (this.juuri == null) {
            this.juuri = uusi;
            return uusi;
        }
        
        PuuSolmu<T> x = this.juuri;
        PuuSolmu<T> p = null;
        Comparable uc = (Comparable)uusi.key;
        
        while (x != null) {
            p = x;
            Comparable xc = (Comparable)x.key;
            if (uc.compareTo(xc) < 0)
                x = x.left;
            else
                x = x.right;
        }
        
        uusi.parent = p;
        Comparable pc = (Comparable)p.key;
        
        if (uc.compareTo(pc) < 0)
            p.left = uusi;
        else
            p.right = uusi;
        
        return uusi;
    }

    /**
     * Binaarihakupuu-delete. Ei tasapainota!
     * @param poistettava Poistettava solmu.
     * @return Palauttaa viitteen poistettuun solmuun.
     */
    private PuuSolmu<T> delete(PuuSolmu<T> poistettava) {
        PuuSolmu<T> vanhempi;
        PuuSolmu<T> lapsi;
        PuuSolmu<T> seuraaja;
        
        if (poistettava.left == null && poistettava.right == null) { //ei lapsia
            vanhempi = poistettava.parent;
            if (vanhempi == null) { //ainut solmu
                this.juuri = null;
                return poistettava;
            }
            if (poistettava == vanhempi.left)
                vanhempi.left = null;
            else
                vanhempi.right = null;
            return poistettava;
        }
        
        if (poistettava.left == null  || poistettava.right == null) { //1 lapsi
            if (poistettava.left != null) {
                lapsi = poistettava.left;
            } else {
                lapsi = poistettava.right;
            }
            vanhempi = poistettava.parent;
            lapsi.parent = vanhempi;
            if (vanhempi == null) { //poistettava on juuri
                this.juuri = lapsi;
                return poistettava;
            }
            if (poistettava == vanhempi.left) {
                vanhempi.left = lapsi;
            } else {
                vanhempi.right = lapsi;
            }
            return poistettava;
        }
        
        seuraaja = poistettava.right; // kaksi lasta
        
        while (seuraaja.left != null) {
            seuraaja = seuraaja.left;
        }
        
        poistettava.key = seuraaja.key; // korvataan poistettavan avain
        lapsi = seuraaja.right;
        vanhempi = seuraaja.parent;
        
        if (vanhempi.left == seuraaja) { //korvataan solmu lapsella
            vanhempi.left = lapsi;
        } else {
            vanhempi.right = lapsi;
        }
        
        if (lapsi != null) {
            lapsi.parent = vanhempi;
        }
        
        return seuraaja;
    }

    /**
     * Kierto oikealle.
     * @param s1 Kierrettava solmu.
     * @return Viite solmuun, joka kiertyi s1 paikalle.
     */
    private PuuSolmu<T> rightRotate(PuuSolmu<T> s1) {
        PuuSolmu<T> s2 = s1.left;
        s2.parent = s1.parent;
        s1.parent = s2;
        s1.left = s2.right;
        s2.right = s1;
        
        if (s1.left != null)
            s1.left.parent = s1;
        
        s1.height = Math.max(height(s1.left), height(s1.right)) + 1;
        s2.height = Math.max(height(s2.left), height(s2.right)) + 1;
        return s2;
    }

    /**
     * Kierto vasemmalle.
     * @param s1 Kierrettava solmu.
     * @return Viite solmuun, joka kiertyi s1 paikalle.
     */
    private PuuSolmu<T> leftRotate(PuuSolmu<T> s1) {
        PuuSolmu<T> s2 = s1.right;
        s2.parent = s1.parent;
        s1.parent = s2;
        s1.right = s2.left;
        s2.left = s1;
        
        if (s1.right != null)
            s1.right.parent = s1;
        
        s1.height = Math.max(height(s1.left), height(s1.right)) + 1;
        s2.height = Math.max(height(s2.left), height(s2.right)) + 1;
        return s2;
    }

    /**
     * Oikea-vasen kaksoiskierto.
     * @param s1 Kierrettava solmu.
     * @return Viite solmuun, joka kiertyi s1 paikalle.
     */
    private PuuSolmu<T> rightLeftRotate(PuuSolmu<T> s1) {
        PuuSolmu<T> s2 = s1.right;
        s1.right = rightRotate(s2);
        return leftRotate(s1);
    }

    /**
     * Vasen-oikea kaksoiskierto.
     * @param s1 Kierrettava solmu.
     * @return Viite solmuun, joka kiertyi s1 paikalle.
     */
    private PuuSolmu<T> leftRightRotate(PuuSolmu<T> s1) {
        PuuSolmu<T> s2 = s1.left;
        s1.left = leftRotate(s2);
        return rightRotate(s1);
    }

}
