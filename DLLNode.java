public class DLLNode extends Position {
    private DLLNode next;
    private DLLNode prev;
    
    public DLLNode(int value, DLLNode next, DLLNode prev) {
        super(value);
		
		this.next = next;
		this.prev = prev;
	}
	
	DLLNode getNext() {
		return next;
    }
	
	DLLNode getPrev(){
		return prev;
	}
	
	void setPrev(DLLNode prevNode){
		this.prev = prevNode;
	}
	
	void setNext(DLLNode nextNode){
		this.next = nextNode;
	}
}
