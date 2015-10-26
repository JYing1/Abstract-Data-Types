public class ArrayProjectList implements ProjectList<ArrayEntry> {

	private ArrayEntry[] array;

	private int n = 0;

	public ArrayProjectList() {

	}

	public void insertFirst(int value) {
		if (this.isEmpty()) {												//no values in current array
			array = new ArrayEntry[1];										//creates a new array
			array[0] = new ArrayEntry(value, 0);							//enter the value into the array
		}
		else {
			ArrayEntry[] newArray = new ArrayEntry[n + 1];					//creates a new array
			
			for (int i = 0; i < array.length; i++) {						//copies the old array into the new array
				newArray[i] = new ArrayEntry(array[i].getValue(), i);
			}
			newArray[n] = new ArrayEntry(value, n);							//insert the new value into the end of the new array
			array = newArray.clone();										//clones the new array into the old array
		}
		n++;																//increase the number of indexes of the array
	}

	public void insertLast(int value) {
		if (this.isEmpty()) {
			array = new ArrayEntry[1];
			array[0] = new ArrayEntry(value, 0);
		}
		else {
			ArrayEntry[] newArray = new ArrayEntry[n + 1];
			
			for (int i = 0; i < array.length; i++) {
				newArray[i + 1] = new ArrayEntry(array[i].getValue(), i + 1);
			}
			newArray[0] = new ArrayEntry(value, 0);							//inserts the new value into the front of the array
			array = newArray.clone();
		}
		n++;
	}

	public ArrayEntry first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return array[n - 1];
		}
	}

	public ArrayEntry last() {
		if (isEmpty()) {
			return null;
		}
		else {
			return array[0];
		}
	}

	public boolean isFirst(ArrayEntry p) {
		if (p.getIndex() == (n - 1)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isLast(ArrayEntry p) {
		if (p.getIndex() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayEntry before(ArrayEntry p) {
		if (this.isEmpty()) {
			return null;
		}
		else if (p.getIndex() == (n - 1)) {
			return array[0];
		}
		else {
			int index = 0;
			for (int i = 1; i < n; i++) {
				if (p.getIndex() == (i - 1)) {
					index = i;
					break;
				}
			}
			return array[index];
		}
	}

	public ArrayEntry after(ArrayEntry p) {
		if (this.isEmpty()) {
			return null;
		}
		else if (p.getIndex() == 0) {
			return array[n - 1];
		}
		else {
			int index = 0;
			for (int i = (n - 1); i > 0; i--) {
				if (p.getIndex() == (i + 1)) {
					index = i;
					break;
				}
			}
			return array[index];
		}
	}

	public boolean isEmpty() {
		if (n == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return n;
	}

}