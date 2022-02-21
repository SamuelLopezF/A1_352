/** Samuel Lopez-Ferrada
 *
 * This file contains the Doubly Linked List class. It manages two lists in parallel
 * and links them together. It uses the LList class and implements the
 * Abstract Data Type Dictionary Interface.
 * @param <Key> corresponds to the given key;
 * @param <E> corresponds to the given element;
 */

public class DLDictionary<Key, E> implements ADTDictionary<Key, E> {

    private static final int defaultSize = 100; //Default size

    private DList<Key> kDList;
    private final DList<E> vDList;

    /** Constructors:
     * @param size is the lenght of the list
     */
    DLDictionary(int size) {
        kDList = new DList<Key>(size);
        vDList = new DList<E>(size);
    }

    /*
        Start of functions :
     */

    /** This function empties both lists
     */
    public void clear() {
        kDList.clear();
        vDList.clear();
    }

    /** This function appends an item at the end of the list
     * give a Key Value pair. It will first search sequentially
     * if the key is already stored in the list
     * @param k The key for the record being inserted.
     * @param e The record as an object of InventoryRecord being inserted.
     */
    public void insert(Key k, E e) {
        int origin = kDList.currPos();
        for(int i = 0 ; i <= kDList.length(); i ++) {
            if (i == kDList.length())
            {
                kDList.moveToEnd();
                vDList.moveToEnd();
                kDList.append(k);
                vDList.append(e);
                break;
            } else if (kDList.getValue().equals(k)) {
                break;
            }
            kDList.next();
            vDList.next();
        }
        kDList.moveToPos(origin);
        vDList.moveToPos(origin);
    }

    /** This function removes a key/value pair
     * given a key, using a sequential search to see
     * if the item exists.
     * @param k The key of the record to be removed.
     * @return the value of the element
     */
    public E remove(Key k) {
        E temp = null;

        int origin = kDList.currPos();
        kDList.moveToStart();
        vDList.moveToStart();
        for (int i = 0; i < kDList.length(); i++) {
            if (kDList.getValue().equals(k)) {
                kDList.remove();
                temp = vDList.remove();
                break;
            }
            kDList.next();
            vDList.next();
        }
        kDList.moveToPos(origin);
        vDList.moveToPos(origin);
        return temp;
    }

    /**This function removes the element the cursor is currently pointing at
     * @return the element that was removed
     */
    public E removeCurrent() {
        kDList.remove();
        return vDList.remove();
    }


    /** Remove any function, removes whatever element the cursor
     * is currently pointing at. The function was vague, so the
     * implementation was not over-complicated
     * @return the element removed, null if cursor pointing at null
     */
    public E removeAny() {
        if(kDList.curr == null)
        {
            //this means that current is pointing at the tail
            return null;
        }else{
            return removeCurrent();
        }
    }

    public void previous() {
        kDList.prev();
        vDList.prev();
    }

    public void next() {
        kDList.next();
        vDList.next();
    }

    public String getCurrent() {
        return kDList.getValue().toString() + vDList.getValue().toString();
    }

    /**
     * This function searches a key, using sequential search,
     * and return the corresponding element associated.
     * @param k The key of the record to find
     * @return the element corresponding to @param k, null if not found;
     */
    public E find(Key k) {
        int origin = kDList.currPos();
        E temp = null;
        kDList.moveToStart();
        vDList.moveToStart();
        for(int i = 0; i < kDList.length(); i ++)
        {
            if(kDList.getValue().equals(k))
            {
                temp = vDList.getValue();
                break;
            }
            kDList.next();
            vDList.next();
        }

        kDList.moveToPos(origin);
        vDList.moveToPos(origin);
        return temp;
    }


    /**
     * Simple method that returns the size, and asserts that both lists
     * have the same length
     * @return the length of the dictionary
     */

    public int size() {
        assert(kDList.length() == vDList.length());
        return kDList.length();
    }

    /**
     * A readable version of the list to be printed on the output console
     * @return a string object
     */
    @Override
    public String toString() {
        int origin = kDList.currPos();
        kDList.moveToStart();
        vDList.moveToStart();
        StringBuffer out = new StringBuffer();
        assert (vDList.length() == kDList.length());
        for (int i = 0; i < kDList.length(); i++) {
            out.append(kDList.getValue().toString());
            kDList.next();
            out.append(":");
            out.append(vDList.getValue().toString());
            out.append(" , ");
            vDList.next();
        }
        kDList.moveToPos(origin);
        vDList.moveToPos(origin);
        return out.toString().trim();
    }
}