package algorithm.datastructure.linkedlist;

public class DNodeLinkedList {
	public static void main(String[] args) {
		DNodeLinkedList linkedlist = new DNodeLinkedList();
		DListNode n1 = new DListNode(1);
		DListNode n2 = new DListNode(2);
		DListNode n3 = new DListNode(3);
		n1.setNext(n2);
		n2.setPrevious(n1);
		n2.setNext(n3);
		n3.setPrevious(n2);
		DListNode currentNode = n1;
		DListNode n4 = new DListNode(4);
		currentNode = linkedlist.InsertInDLinkedList(n1,n4,4);
		linkedlist.printDLinkedList(currentNode);
		
		currentNode = linkedlist.DeleteInDLinkedList(n1,2);
		linkedlist.printDLinkedList(currentNode);
		
	}
	
	int getListLength(DListNode headNode){
		int length = 0;
		DListNode currentNode = headNode;
		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	DListNode InsertInDLinkedList(DListNode headNode, DListNode nodeToInsert, int position){
		if(headNode == null) return nodeToInsert;
		
		int size = getListLength(headNode);
		if(position > size+1 || position < 1){
			System.out.println("Position of node to insert is invalid"
					         + " the valid inputs are 1 to "+ (size+1));
		}
		
		if(position == 1){
			nodeToInsert.setNext(headNode);
			headNode.setPrevious(nodeToInsert);
			return nodeToInsert;
		}else{
			DListNode nextNode = headNode;
			int count = 1;
			while(count < position -1){
				nextNode = nextNode.getNext();
				count++;
			}
			if(position < size){ 
				nodeToInsert.setNext(nextNode.getNext());
				nextNode.getNext().setPrevious(nodeToInsert);
			}
			nextNode.setNext(nodeToInsert);
		}
		
		return headNode;
	}
	
	DListNode DeleteInDLinkedList(DListNode headNode, int position){
		int size = getListLength(headNode);
		if(position > size+1 || position < 1){
			System.out.println("Position of node to insert is invalid"
					         + " the valid inputs are 1 to "+ (size+1));
		}
		
		DListNode current = null;
		if(position == 1){
			current = headNode.getNext();
			current.setPrevious(null);
			headNode.setNext(null);
			return current;
		}else{
			DListNode nextNode = headNode;
			int count = 1;
			while(count < position -1){
				nextNode = nextNode.getNext();
				count++;
			}
			if(position < size){ 
				nextNode.setNext(nextNode.getNext().getNext());
				nextNode.getNext().setPrevious(nextNode);
			}else{
				nextNode.setNext(null);
			}
		}
		
		return headNode;
	}
	
	void printDLinkedList(DListNode headNode){
		DListNode currentNode = headNode;
		while(currentNode != null){
			System.out.print(currentNode.getData()+"|");
			currentNode = currentNode.getNext();
		}
	}
}
