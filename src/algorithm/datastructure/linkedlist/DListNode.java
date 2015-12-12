package algorithm.datastructure.linkedlist;

public class DListNode {
	private int data;
	private DListNode next;
	private DListNode previous;
	DListNode(int data){
		setData(data);
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DListNode getNext() {
		return next;
	}
	public void setNext(DListNode next) {
		this.next = next;
	}
	public DListNode getPrevious() {
		return previous;
	}
	public void setPrevious(DListNode previous) {
		this.previous = previous;
	}
	
	
}
