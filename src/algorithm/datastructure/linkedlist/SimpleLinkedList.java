package algorithm.datastructure.linkedlist;

public class SimpleLinkedList {
	
	public static void main(String[] args) {
		SimpleLinkedList linkedlist = new SimpleLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.setNext(n2);
		n2.setNext(n3);
		ListNode currentNode = n1;
		//System.out.println(linkedlist.getListLength(currentNode));
		linkedlist.printLinkedList(currentNode);
		currentNode = linkedlist.DeleteNodeFromLinkedList(n1,2);
		//System.out.println(linkedlist.getListLength(currentNode));
		linkedlist.printLinkedList(currentNode);
	}
	
	int getListLength(ListNode headNode){
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
		if(headNode == null) return nodeToInsert;
		
		int size = getListLength(headNode);
		if(position > size+1 || position < 1){
			System.out.println("Position of node to insert is invalid"
					         + " the valid inputs are 1 to "+ (size+1));
		}
		
		if(position == 1){
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}else{
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position - 1){
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		
		return headNode;
	}
	
	ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
		int size = getListLength(headNode);
		if(position > size+1 || position < 1){
			System.out.println("Position of node to insert is invalid"
					         + " the valid inputs are 1 to "+ (size+1));
		}
		
		if(position == 1){
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}else{
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position - 1){
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		
		return headNode;
	}
	
	void printLinkedList(ListNode headNode){
		ListNode currentNode = headNode;
		while(currentNode != null){
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}
