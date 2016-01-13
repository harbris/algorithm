package algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode(1);
		BinaryTreeNode b = new BinaryTreeNode(2);
		BinaryTreeNode c = new BinaryTreeNode(3);
		BinaryTreeNode d = new BinaryTreeNode(4);
		BinaryTreeNode e = new BinaryTreeNode(5);
		BinaryTreeNode f = new BinaryTreeNode(6);
		BinaryTreeNode g = new BinaryTreeNode(7);
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		
		Tree tr = new Tree();
		/*tr.PostOrder(a);
		System.out.println("===========");*/
		//tr.levelOrder(a);
		System.out.println(tr.maxValueNotRecursive(a));
		/*Stack s = new Stack();
		s.push(2);
		s.push(1);
		System.out.println(s.firstElement());*/
	}
	
	void PreOrder(BinaryTreeNode root){
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	void PreOrderNonRecursive(BinaryTreeNode root){
		if(root == null) return;
		Stack s = new Stack();
		while(true){
			while(root != null){
				System.out.println(root.getData());
				s.push(root);
				root = root.getLeft();
			}
			if(s == null) break;
			root = (BinaryTreeNode)s.pop();
			root = root.getRight();
		}
		return;
	}
	
	void InOrder(BinaryTreeNode root){
		if(root != null){
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}
	
	void InOrderNonRecursive(BinaryTreeNode root){
		if(root == null) return;
		Stack s = new Stack();
		while(true){
			while(root != null){
				s.push(root);
				root = root.getLeft();
			}
			if(s == null) break;
			root = (BinaryTreeNode)s.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
		return;
	}
	
	void PostOrder(BinaryTreeNode root){
		if(root != null){
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}
	
	void PostOrderNonRecursive(BinaryTreeNode root){
		if(root == null) return;
		Stack s = new Stack();
		while(true){
			if(root != null){
				s.push(root);
				root = root.getLeft();
			}else{
				if(s.isEmpty()){
					return;
				}else{ 
					if( ((BinaryTreeNode)s.lastElement()).getRight() == null){
						root = (BinaryTreeNode)s.pop();
						System.out.println(root.getData());
						while(!s.empty() && root == ((BinaryTreeNode)s.lastElement()).getRight()){
							root = (BinaryTreeNode)s.pop();
							System.out.println(root.getData());
						}
					}

					if(!s.isEmpty()){
							root = ((BinaryTreeNode)s.lastElement()).getRight();
					}else{
							root = null;
					}
				}
			}
		}
	}
	
	void levelOrder(BinaryTreeNode root){
		BinaryTreeNode temp;
	    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	    if(root == null){
	    	return;
	    }
	    q.add(root);
	    while(!q.isEmpty()){
	    	temp = q.poll();
	    	System.out.println(temp.getData());
	    	if(temp.getLeft() != null){
	    		q.add(temp.getLeft());
	    	}
	    	
	    	if(temp.getRight() != null){
	    		q.add(temp.getRight());
	    	}
	    }
	}
	
	//최대값 재귀
	int maxValueRecursive(BinaryTreeNode root){
		int rootVal,left,right,max = 0;
		if(root != null){
			rootVal = root.getData();
			left = maxValueRecursive(root.getLeft());
			right = maxValueRecursive(root.getRight());
			max = left > right ? left:right;
			if(rootVal > max){
				max = rootVal;
			}
		}
		return max;
	}
	
	//최대값 재귀없이
	int maxValueNotRecursive(BinaryTreeNode root){
		int rootVal,left,right,max = 0;
		BinaryTreeNode temp;
	    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	    
	    q.add(root);
	    while(!q.isEmpty()){
	    	temp = q.poll();
	    	max = max > temp.getData() ? max:temp.getData();
	    	if(temp.getLeft() != null){
	    		q.add(temp.getLeft());
	    	}
	    	
	    	if(temp.getRight() != null){
	    		q.add(temp.getRight());
	    	}
	    }
		return max;
	}
}
