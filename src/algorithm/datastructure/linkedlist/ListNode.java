package algorithm.datastructure.linkedlist;

public class ListNode {
	private int data;
	private ListNode next;
	ListNode(int data){
		setData(data);
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}
