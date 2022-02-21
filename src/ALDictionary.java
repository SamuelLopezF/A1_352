/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/


/** Dictionary implemented by unsorted array-based list. */
public class ALDictionary<Key, E> implements ADTDictionary<Key, E> {

	private static final int defaultSize = 100; // Default size

	private AList<Key> klist;
	private AList<E> vlist;

	private int[] index = null;

	/** Constructors */
	ALDictionary() {
		this(defaultSize);
	}

	ALDictionary(int sz){
		klist = new AList<Key>(sz);
		vlist = new AList<E>(sz);
	}

	/** Reinitialize */
	public void clear() {
		klist.clear();
		vlist.clear();
	}


	/**
	 * Insert an element: append to list
	 */
	public void insert(Key k, E e) {
		if (search(k) == -1) {
			klist.append(k);
			vlist.append((e));
			klist.next();
			vlist.next();
		}else{
			System.out.println("item already exists");
		}
//		}
	}

	/** Use sequential search to find the element to remove */
	public E remove(Key k) {
		int origin = klist.currPos();
		E temp = find(k);
		if (temp != null) {
			klist.remove();
			vlist.remove();
			vlist.prev();
		}
		klist.moveToPos(origin);
		vlist.moveToPos(origin);

		return temp;
	}

	/** Remove the current element */
	public E removeCurrent() {
		if (size() != 0) {
			klist.remove();
			return vlist.remove();
		} else {
			return null;
		}
	}

	/** Remove any element */
	public E removeAny() {
		int origin = klist.currPos();
		klist.moveToStart();
		vlist.moveToStart();
		klist.remove();
		E temp = vlist.remove();
		klist.moveToPos(origin);
		vlist.moveToPos(origin);
		return temp;
	}

	@Override
	public void previous() {

	}

	@Override
	public void next() {

	}

	@Override
	public String getCurrent() {
		return null;
	}


	/** @return List size */
	public int size() {
		assert(klist.length() == vlist.length()): "database is inconsistent";
		return klist.length();
	}


	public E[] toArray() {
		return (vlist.toArray());
	}

@Override
	public String toString() {
	System.out.println("triggering this");
		int origin = klist.currPos();
		klist.moveToStart();
		vlist.moveToStart();
		StringBuffer out = new StringBuffer();
		assert (vlist.length()== klist.length()): "the dict is inconsistent";
		for(int i = 0; i< klist.length(); i++) {
			out.append(klist.getValue().toString());
				klist.next();
				out.append(":");
				out.append(vlist.getValue().toString());
				out.append(" >\n");
				vlist.next();
			}

			klist.moveToPos(origin);
			vlist.moveToPos(origin);
			return out.toString().trim();
	}


	/**
	 * Find k using sequential search
	 *
	 * @return Record with key value k
	 * using the find functionsa
	 */
	public E find(Key k) {


		int position = search(k);
		if(position == -1) {
			return null;
		}else{
			vlist.moveToPos(position);
			E e = vlist.getValue();
			vlist.moveToPos(klist.currPos());
			return e;
		}
	}

	// This method is used to search a position for a given Key//
	public int search(Key k) {
		int original_position = klist.currPos();
		klist.moveToStart();
		for (int i = 0; i < klist.length(); i++) {
			if (klist.getValue().equals(k)) {
				int position = klist.currPos();
				klist.moveToPos(original_position);
				return position;
			}
			klist.next();
		}
		return -1;
	}


}