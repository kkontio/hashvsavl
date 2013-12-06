package seula;

import lista.LinkitettyLista;
import java.util.Iterator;

/**
 * Erastotheneen seula, apuluokka sopivien hajautustaulukon
 * kokojen loytamiseksi.
 * @author kkontio
 */
public class Seula {

    /**
     * Palauttaa annettua lukua seuraavan suuremman alkuluvun.
     * @param luku
     * @return Annettua lukua suurempi alkuluku.
     */
    public static int seuraavaAlkuluku(int luku) {
        if (luku < 0)
            return 2;
        
        LinkitettyLista<Integer> luvut = new LinkitettyLista<Integer>();
        final int koko = luku*2;
        
        for (int i=2;i<=koko;i++) {
            luvut.addLast(i);
        }

        int alkuluku;
        int index = 0;
        int testattava;

        do {
            alkuluku = luvut.get(index);
            Iterator<Integer> it = luvut.iterator(index);
            while (it.hasNext()) {
                testattava = it.next();
                if (testattava != alkuluku && testattava%alkuluku == 0)
                    it.remove();
            }
            index++;
        } while (alkuluku < Math.sqrt(koko));
        

        //Periaatteessa turhaa castausta? Type erasure??
        for (Object o : luvut) {
            int i = (Integer)o;
            if (i > luku)
                return i;
        }
        return -1;
    }
}
