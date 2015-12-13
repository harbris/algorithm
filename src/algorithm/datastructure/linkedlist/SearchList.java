package algorithm.datastructure.linkedlist;

import java.util.HashMap;

public class SearchList {
	public static void main(String[] args) {
		SearchList linkedlist = new SearchList();
		
		//1.search use hashMap
		//
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		HashMap<Integer,ListNode> hm = new HashMap<Integer, ListNode>();
		hm.put(1, n1);
		hm.put(2, n2);
		hm.put(3, n3);
		hm.put(4, n4);
		hm.put(5, n5);
		System.out.println("2th item ? "+((ListNode)hm.get(hm.size() - 3)).getData());
		
		//2.search use two point
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		System.out.println("2th item ? "+linkedlist.NthNodeFromEnd(n1,4).getData());
		
	}
	
	ListNode NthNodeFromEnd(ListNode headNode, int NthNode){
		ListNode pTemp = headNode, pNthNode = null;
		int count = 0;
		while(pTemp != null){
			count++;
			if(NthNode == count){
				pNthNode = headNode;
			}else if(NthNode < count){
				pNthNode = pNthNode.getNext();
			}
			
			pTemp = pTemp.getNext();
		}
		
		return pNthNode;
	}
	
	
}
