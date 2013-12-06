package avlpuu;

/**
 * AVL-puun solmu
 * @author kkontio
 */
public class PuuSolmu<T> {
    T key;
    PuuSolmu<T> left;
    PuuSolmu<T> right;
    PuuSolmu<T> parent;
    int height;

    public PuuSolmu(T key) {
        this.key = key;
    }

    public PuuSolmu(T key,
                    PuuSolmu<T> left,
                    PuuSolmu<T> right,
                    PuuSolmu<T> parent,
                    int height)
    {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.height = height;
    }

}
