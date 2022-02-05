public class DLDictionary<Key, E> implements ADTDictionary<Key, E> {

    private static final int defaultSize = 100; //Default size

    private DList<Key> kDlist;
    private DList<E> vDlist;

    /** Constructors:
     * @param size
     */
    DLDictionary(int size) {
        kDlist = new DList<Key>(size);
        vDlist = new DList<E>(size);
    }

    public void clear() {
        kDlist.clear();
        vDlist.clear();
    }

    /** This function appends an item at the end of the list
     * give a Key Value pair. It will first search sequentially
     * if the item is already stored in the list
     * @param k The key for the record being inserted.
     * @param e The record as an object of InventoryRecord being inserted.
     */
    public void insert(Key k, E e) {
        if (search(k) == -1) {
            kDlist.append(k);
            vDlist.append(e);
            kDlist.next();
            vDlist.next();
        }else{
            System.out.println("item already exists");
        }

    }

    /** This function removes a key/value pair
     * given a key, using a sequential search to see
     * if the item exists.
     * @param k The key of the record to be removed.
     * @return
     */
    public E remove(Key k) {
        int origin = kDlist.currPos();
        E temp = find(k);
        if(temp != null)
        {
            kDlist.remove();
            vDlist.remove();
        }
        kDlist.moveToPos(origin);
        vDlist.moveToPos(origin);
        return temp;
    }

    @Override
    public E removeAny() {
        kDlist.prev();
        vDlist.prev();
        if(size() != 0)
        {
            kDlist.remove();
            E temp = vDlist.getValue();
            vDlist.remove();
            return temp;
        }
        return null;
    }
    @Override
    public E find(Key k) {
        int pos = search(k);
        if (pos == -1) {
            return null;
        }else{
            vDlist.moveToPos(pos);
            E temp = vDlist.getValue();
            vDlist.moveToPos(kDlist.currPos());
            return temp;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key getCurrentKey() {
        return null;
    }

    public int search(Key k) {
        int origin = kDlist.currPos();
        kDlist.moveToStart();
        for (int i = 0; i < kDlist.length(); i++) {
            if (kDlist.getValue().equals(k)) {
                int pos = kDlist.currPos();
                kDlist.moveToPos(origin);
                return pos;
            }else{
                kDlist.next();
            }
        }
        return -1;
    }
}
