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




	/** Find k using sequential search
	  @return position of key value k */


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
	public E removeCurrent() {
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

		return null;
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


}