package vertailu;

import avlpuu.Puu;
import hajautus.Hajautustaulu;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author kkontio
 */
public class Main {
    private static Scanner lukija;
    private static File file;
    private static Puu avlpuu;
    private static Hajautustaulu hajtaulu;
    private static TreeSet setti;
    private static HashSet hashi;
    private static long time;

    public static void main(String[] args) {
        System.out.println("Koneessa olisi hyvä olla ainakin jonkun verran vapaata muistia...");
        testaaUlysses();
        testaaSotajarauha();
        testaaStrings();
        testaaMoarStrings();
    }
    
    private static void testaaSotajarauha() {
       
        // sota ja rauha
        init();

        System.out.println("\nTolstoin Sota ja rauha...");
        
        lueSotajarauha();
        avlLisays();

        lueSotajarauha();
        hajLisays();

        lueSotajarauha();
        hashLisays();

        lueSotajarauha();
        treeLisays();

        System.out.println("");
        lueSotajarauha();
        avlHaku();

        lueSotajarauha();
        hajHaku();

        lueSotajarauha();
        hashHaku();

        lueSotajarauha();
        treeHaku();

        System.out.println("");
        lueSotajarauha();
        avlPoisto();

        lueSotajarauha();
        hajPoisto();

        lueSotajarauha();
        hashPoisto();

        lueSotajarauha();
        treePoisto();
        
    }

    private static void testaaUlysses() {
        // ulysses
        init();

        System.out.println("\nTestataan lisaamalla rakenteisiin James Joycen Ulysses.");
        lueUlysses();
        avlLisays();

        lueUlysses();
        hajLisays();

        lueUlysses();
        hashLisays();

        lueUlysses();
        treeLisays();

        System.out.println("");
        lueUlysses();
        avlHaku();

        lueUlysses();
        hajHaku();

        lueUlysses();
        hashHaku();

        lueUlysses();
        treeHaku();

        System.out.println("");
        lueUlysses();
        avlPoisto();

        lueUlysses();
        hajPoisto();

        lueUlysses();
        hashPoisto();

        lueUlysses();
        treePoisto();
    }

    private static void testaaStrings() {
        // strings
        init();

        System.out.println("\n300000 satunnaista merkkijonoa...");
        lueStrings();
        avlLisays();

        lueStrings();
        hajLisays();

        lueStrings();
        hashLisays();

        lueStrings();
        treeLisays();

        System.out.println("");
        lueStrings();
        avlHaku();

        lueStrings();
        hajHaku();

        lueStrings();
        hashHaku();

        lueStrings();
        treeHaku();

        System.out.println("");
        lueStrings();
        avlPoisto();

        lueStrings();
        hajPoisto();

        lueStrings();
        hashPoisto();

        lueStrings();
        treePoisto();
    }
    
    private static void testaaMoarStrings() {
        // moar strings
        init();

        System.out.println("\n1000000 satunnaista merkkijonoa...");
        lueMoarStrings();
        avlLisays();

        lueMoarStrings();
        hajLisays();

        lueMoarStrings();
        hashLisays();

        lueMoarStrings();
        treeLisays();

        System.out.println("");
        lueMoarStrings();
        avlHaku();

        lueMoarStrings();
        hajHaku();

        lueMoarStrings();
        hashHaku();

        lueMoarStrings();
        treeHaku();

        System.out.println("");
        lueMoarStrings();
        avlPoisto();

        lueMoarStrings();
        hajPoisto();

        lueMoarStrings();
        hashPoisto();

        lueMoarStrings();
        treePoisto();
    }

    private static void init() {
        avlpuu = new Puu<String>();
        hajtaulu = new Hajautustaulu<String>();
        setti = new TreeSet<String>();
        hashi = new HashSet<String>();

    }

    private static void lueUlysses() {
        file = new File("ulysses.txt");
        try {
            lukija = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }
    
    private static void lueSotajarauha() {
        file = new File("warandpeace.txt");
        try {
            lukija = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }

    private static void lueStrings() {
        file = new File("strings.txt");
        try {
            lukija = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }
    
    private static void lueMoarStrings() {
        file = new File("moarstrings.txt");
        try {
            lukija = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }

    private static void hajLisays() {
        System.out.print("Hajautustaulu lisays: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hajtaulu.insert(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void avlLisays() {
        System.out.print("AVL-puu lisays: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            avlpuu.add(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void hajHaku() {
        System.out.print("Hajautustaulu haku: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hajtaulu.contains(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void avlHaku() {
        System.out.print("AVL-puu haku: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            avlpuu.contains(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void avlPoisto() {
        System.out.print("AVL-puu poisto: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            avlpuu.remove(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void hajPoisto() {
        System.out.print("Hajautustaulu poisto: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hajtaulu.remove(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void hashLisays() {
        System.out.print("HashSet lisays: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hashi.add(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void hashHaku() {
        System.out.print("HashSet haku: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hashi.contains(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void hashPoisto() {
        System.out.print("HashSet poisto: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            hashi.remove(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void treeLisays() {
        System.out.print("TreeSet lisays: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            setti.add(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void treeHaku() {
        System.out.print("TreeSet haku: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            setti.contains(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void treePoisto() {
        System.out.print("TreeSet poisto: ");
        time = System.currentTimeMillis();
        while (lukija.hasNext()) {
            setti.remove(lukija.next());
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }


}
