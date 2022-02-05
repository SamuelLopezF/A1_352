public class LLDictionary<Key, E> implements ADTDictionary<Key,E>{
    private static final int defaultSize = 100; // Default size

    private LList<Key> kLList;
    private LList<E> vLList;

    LLDictionary(int size) {
        kLList = new LList<Key>(size);
        vLList = new LList<E>(size);
    }

    public void clear() {
        kLList.clear();
        vLList.clear();
    }

    public void insert(Key k, E e) {
        if (search(k) == -1) {
            kLList.append(k);
            vLList.append(e);
            kLList.next();
            vLList.next();
        } else{
            System.out.println("item already in library");
        }
    }

    public E remove(Key k) {
        int pos = search(k);
        if (pos == -1) {
            return null;
        }else{
            int origin = kLList.currPos();
            vLList.moveToPos(pos);
            E temp = vLList.getValue();
            vLList.moveToPos(origin);
            return temp;
        }
    }

    public E removeAny() {

        kLList.prev();
        vLList.prev();
        kLList.remove();
        return vLList.remove();
    }

    public E find(Key k) {
        int pos = search(k);
        vLList.moveToPos(pos);
        E temp = vLList.getValue();
        vLList.moveToPos(kLList.currPos());
        return temp;
    }

    public int size() {
        return kLList.length();
    }

    public Key getCurrentKey() {
        return null;
    }


    public int search(Key k) {
        int origin = kLList.currPos();
        kLList.moveToStart();
        while(kLList.getValue() != null)
        {
            if(kLList.getValue() == k)
            {
                int pos = kLList.currPos();
                kLList.moveToPos(origin);
                return pos;
            }else{
                kLList.next();
            }

        }
        return -1;
    }


    @Override
    public String toString() {
        int origin = kLList.currPos();
        kLList.moveToStart();
        vLList.moveToStart();
        StringBuffer out = new StringBuffer();
        assert (vLList.length()== kLList.length()): "the dict is inconsistent";
        for(int i = 0; i< kLList.length(); i++) {
            out.append(kLList.getValue().toString());
            kLList.next();
            out.append(":");
            out.append(vLList.getValue().toString());
            out.append(" , ");
            vLList.next();
        }

        kLList.moveToPos(origin);
        vLList.moveToPos(origin);
        return out.toString().trim();

    }

}
