import static org.junit.Assert.assertEquals;

/** Samuel Lopez-Ferrada
 *
 * This file contains the Linked List class. It manages two lists in parallel
 * and links them together. It uses the LList class and implements the
 * Abstract Data Type Dictionary Interface.
 * @param <Key> corresponds to the given key;
 * @param <E> corresponds to the given element;
 */

public class LLDictionary<Key, E> implements ADTDictionary<Key, E> {
    private static final int defaultSize = 100;
    private  LList<Key> kLList;
    private  LList<E> vLList;

    /** Constructors:
     * @param size is the length of the list
     */
    LLDictionary(int size) {
        this.kLList = new LList(size);
        this.vLList = new LList(size);
    }

    /** This function appends an item at the end of the list
     * give a Key Value pair. It will first search sequentially
     * if the key is already stored in the list, if the loop arrives
     * at the end of the list then the key did not exist and appends
     * the new element.
     * @param k The key for the record being inserted.
     * @param e The record as an object of InventoryRecord being inserted.
     */
    public void insert(Key k, E e) {
        int origin = kLList.currPos();

        for (int i = 0; i <= kLList.length(); i++) {
            //System.out.println(kLList.getValue() + "<->" + k);
            if( i == kLList.length())
            {
                kLList.moveToEnd();
                vLList.moveToEnd();
                kLList.append(k);
                vLList.append(e);
                break;
            } else if (kLList.getValue().equals(k)) {
                break;
            }

            kLList.next();
            vLList.next();
        }
        kLList.moveToPos(origin);
        vLList.moveToPos(origin);
    }

    //Functions :

    /** This function empties both lists
     */
    public void clear() {
        this.kLList.clear();
        this.vLList.clear();
    }

    /** This function removes a key/value pair
     * given a key, using a sequential search to see
     * if the item exists.
     * @param k The key of the record to be removed.
     * @return the value of the object associated with the key
     */
    public E remove(Key k) {
        int origin = kLList.currPos();
        kLList.moveToStart();
        vLList.moveToStart();
        E temp = null;
        for(int i = 0; i < kLList.length(); i++)
        {
            //System.out.println(kLList.getValue() + " <-> " + k);

            if(kLList.getValue().equals(k)){
                kLList.remove();
                temp = vLList.remove();
                break;
            }
            kLList.next();
            vLList.next();
        }
        kLList.moveToPos(origin);
        vLList.moveToPos(origin);
        return  temp;
    }

    /**This function removes the element the cursor is currently pointing at
     * @return the element that was removed
     */
    public E removeCurrent() {
        kLList.remove();
        return vLList.remove();
    }


    /** Remove any function, removes whatever element the cursor
     * is currently pointing at. The function was vague, so the
     * implementation was not over-complicated
     * @return the element removed, null if cursor pointing at null
     */
    public E removeAny() {
        if(kLList.curr == null)
        {
            //this means that current is pointing at the tail
            return null;
        }else{
            return removeCurrent();
        }
    }


    /**This function searches a key, using sequential search,
     * and return the corresponding element associated.
     * @param k The key of the record to find
     * @return the element corresponding to @param k, null if not found;
     */
    public E find(Key k) {
        int origin = kLList.currPos();
        E temp = null;
        kLList.moveToStart();
        vLList.moveToStart();
        for(int i = 0 ; i < kLList.length(); i ++)
        {
            if(kLList.getValue().equals(k))
            {
                temp = vLList.getValue();
                break;
            }
            kLList.next();
            vLList.next();
        }

        kLList.moveToPos(origin);
        vLList.moveToPos(origin);
        return temp;
    }

    /**Simple method that returns the size, and asserts that both lists
     * have the same length
     * @return the length of the dictionary
     */
    public int size() {
        assert(kLList.length() == vLList.length());
        return this.kLList.length();
    }

    /**This function moves the cursor to the previous position
     */
    public void previous()
    {
        kLList.prev();
        vLList.prev();
    }

    /**This function moves the cursor to the next position
     */
    public void next()
    {
        kLList.next();
        vLList.next();
    }

    /**This function returns the string value of the current element.
     * @return a readable key pair value
     */
    public String getCurrent()
    {
        return kLList.getValue().toString() + vLList.getValue().toString();
    }


    /**A readable version of the list to be printed on the output console
     * @return a string object
     */
    @Override
    public String toString() {
        int origin = this.kLList.currPos();
        this.kLList.moveToStart();
        this.vLList.moveToStart();
        StringBuffer out = new StringBuffer();

        assert this.vLList.length() == this.kLList.length() : "the dict is inconsistent";

        for(int i = 0; i < this.kLList.length(); ++i) {
            out.append("KEY -> ");
            out.append(this.kLList.getValue().toString());
            this.kLList.next();
            out.append("\t");
            out.append(this.vLList.getValue().toString());
            this.vLList.next();
        }

        this.kLList.moveToPos(origin);
        this.vLList.moveToPos(origin);
        return out.toString().trim();
    }

}

