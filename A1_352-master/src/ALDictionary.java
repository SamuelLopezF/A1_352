import org.junit.jupiter.api.Test;

import javax.lang.model.element.Element;


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
		klist.append(k);
		vlist.append(e);
		klist.next();
		vlist.next();
//		}
	}

	/** Use sequential search to find the element to remove */
	public E remove(Key k) {
		int origin = klist.currPos();
		E temp = find(k);
		if (temp != null) {
			klist.remove();
			vlist.remove();
		}
		klist.moveToPos(origin);
		vlist.moveToPos(origin);
		return temp;
	}

	/** Remove the current element */
	public E removeAny() {
//		klist.moveToPos(klist.currPos()-1);
//		vlist.moveToPos(klist.currPos());
		previous();
		if (size() != 0) {
		  klist.remove();
		  E temp = vlist.getValue();
		  vlist.remove();
		  return temp;
		}
		else
			return null;
	}


	/** @return List size */
	public int size() {
		return klist.length();
	}

	public E[] toArray() {
		return vlist.toArray();
	}

@Override
	public String toString() {
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
				out.append(" , ");
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
	 */
	public E find(Key k) {
		int position = -1;
		position = search(k);
		if(position == -1)
		{
			return null;
		}else{
			vlist.moveToPos(position);
			E e =  vlist.getValue();
			vlist.moveToPos(klist.currPos());
			return e;
		}
	}

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

	/** this function moves the cursor
	 * for both list to next positions
	 */
	public void next() {
		klist.next();
		vlist.next();
	}

	/** This function moves the cursor to
	 * the next position
	 */
	public void previous() {
		klist.prev();
		vlist.prev();
	}

	/** This function moves the cursor to
	 * the a specified index
	 * @param pos
	 */
	public void moveToPosition(int pos) {
		klist.moveToPos(pos);
		vlist.moveToPos(pos);
	}

	/** This function moves the cursor
	 * to the specified Key k value
	 * using sequential search from search function
	 * @param key
	 */
	public void moveToPosition(Key key) {
		int pos = search(key);
		moveToPosition(pos);
	}

	public Key getCurrentKey() {
		return klist.getValue();
	}
	public E getCurrentValue() {
		return vlist.getValue();
	}
}