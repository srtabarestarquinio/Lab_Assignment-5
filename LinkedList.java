//Rose Tabares - CS245 - Lab05
import java.util.*;

public class LinkedList<T> implements List<T>{
	private class Node<T>{
		T data;
		ListNode <T> next;

		public ListNode(T value){
			data = value;
			next = null;
		}
	}
	private class ListIterator<T> implements Iterator<T>{
		private ListNode node = head;
		public boolean hasNext(){
			return node.next != null;
		}
		public T next(){
			ListNode prev = node;
			node = node.next;
			return prev.data;
		}
	}
	//**
	ListNode<T> head;
	int size;
	//**
	//Constructor : Your list must have a constructor which will make an instance of your linked list. It will take in a variable of type ListNode.
	public LinkedList(ListNode item){
		head = null;
		size = 0;
	}
	//Add : Your code must have TWO add functions. 
	//One of which will take in ListNode and add it to the end of the LinkedList. 
	//The other one takes in both the ListNode and the Position of which it is to be added into. 
	//This should not return anything.
	public void add(ListNode item){
		if(head == null){
			head = new ListNode(item);
			++size;
		}
		else{
			ListNode <T> prev = head;
			while(prev.next!= null){
				prev=prev.next;
			}
			ListNode<T> node = new ListNode(item);
			prev.next= node;
			++size;
		}
	}
	public void add(ListNode item, int position){
		if(position == 0){
			ListNode<T> node = new ListNode(item);
			node.next = head;
			head = node;
			++size;
		}
		else{
			ListNode<T> prev = head;
			for(int i=0; i<position-1; i++){
				prev = prev.next;
			}
			ListNode node = new ListNode(item);
			prev.next = node;
			++size;
		}
	}
	//Get : This takes in an integer position which then returns the node at that position in the list. If the position is invalid, return null
	public ListNode get(int position){
		//error check
		if(position<size||position>=size){
			return null;
		}

		ListNode<T> curr = head;
		for (int i = 0; i<position; i++){
			curr = curr.next;
		}
		return curr.data;
	}
	//Remove: The function takes in an integer position , which it then both removes and returns the ListNode at that position
	public ListNode remove(int position){
		//Error exception
		if (position == 0){
			ListNode<T> node = head;
			head = head.next;
			--size;
			return node.data;
		}
		else{
			ListNode<T> prev = head;
			for (int i=0; i<position-1; i++){
				prev = prev.next;
			}
			ListNode<T> node = prev.next;
			prev.next = node.next;
			--size;
			return node.data;
		}
	}
	//Reverse: The function reverses the whole linked list from head to tail. It should take in a parameter ListNode head. And return back the new head once the function is finished.
	public ListNode<T> reverse(ListNode<T> head){
		ListNode<T> prev=null;
		ListNode<T> curr= head;
		ListNode<T> next= null;
		while(curr!=null){
			next= curr.next;
			curr.next=prev.next;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	public Iterator iterator(){
		return new ListIterator();
	}
	//Print
	public void printList(LinkedList lL){
		// Node currNode = lL.head;
		// System.out.print("LinkedList: ");

		// while(currNode != null){
		// 	System.out.print(currNode.data + " ");
		// 	currNode = currNode.next;
		// }
		iterator = lL.getIterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}

		// ListNode<T> node= head;
		// while(node!=null){
		// 	System.out.print(node.data+"==> ");
		// 	node=node.next;
		// }
		// System.out.println();
	}
	//Main function
	public static void main(String[] args){
		LinkedList<Integer> lL = new LinkedList()<Integer>;

		//OG list
		lL = {1, 2, 3, 4, 5}

		//print OG list
		lL.add(6);
		//print new list

		//print OG list
		lL.add(6, 0);
		//print new list

		//print OG list
		lL.get(2);
		//print value at givven position

		//print OG list
		lL.remove(4);
		printList()

		//print OG list
		lL.reverse();
		lL.head = lL.reverse(lL.head)
		//print new list

	}
}
