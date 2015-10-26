public class DLLProjectList implements ProjectList<DLLNode> {

    private DLLNode head;
    private DLLNode tail;
    
    public DLLProjectList() {
        head = tail = null;
    }
    
    public void insertFirst(int value) {
    	if (head == null) {
    		head = tail = new DLLNode(value, null, null);
    	}
    	else{
    		head = new DLLNode(value, head, null);
    		head.getNext().setPrev(head);
    	}
    }
    
    public void insertLast(int value) {
    	if (tail == null) {
    		head = tail = new DLLNode(value, null, null);
    	}
    	else{
    		tail = new DLLNode(value, null, tail);
    		tail.getPrev().setNext(tail);
    	}
    }
    
    public DLLNode first() {
        return head;
    }

    public DLLNode last() {
        return tail;
    }

    public boolean isFirst(DLLNode p) {
        if (head == p) {
        	return true;
        }
        return false;
    }

    public boolean isLast(DLLNode p) {
        if (tail == p) {
        	return true;
        }
        return false;
    }
    
    public DLLNode before(DLLNode p) {
    	if (head == p) {
    		return null;
    	}
    	return p.getPrev();
    }
    
    public DLLNode after(DLLNode p) {
        if (tail == p) {
        	return null;
        }
        return p.getNext();
    }
	
    public boolean isEmpty() {
        if (tail == null) {
        	return true;
        }
        return false;
    }

    public int size() {
        int count = 0;
        DLLNode temp = head;
        while (temp != null) {
        	temp = temp.getNext();
        	count++;
        }
        return count;
    }
}
