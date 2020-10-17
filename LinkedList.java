//Rose Tabares - CS245 - Lab05
import java.util.*;

public class LinkedList<E>{
	private class Node<E>{
		E data;
		Node <E> next;

		public Node(E value){
			data = value;
			next = null;
		}
	}
	Node<E> head;
	int size;
	//Constructor : Your list must have a constructor which will make an instance of your linked list. It will take in a variable of type ListNode.
	public void LinkedList(){
		head = null;
		size = 0;
	}
	//Add : Your code must have TWO add functions. 
	//One of which will take in ListNode and add it to the end of the LinkedList. 
	//The other one takes in both the ListNode and the Position of which it is to be added into. 
	//This should not return anything.
	public void add(E item){
		if(head == null){
			head = new Node<E>(item);
			++size;
		}
		else{
			Node<E> prev = head;
			while(prev.next!= null){
				prev=prev.next;
			}
			Node<E> node = new Node<E>(item);
			prev.next= node;
			++size;
		}
	}
	public void add(E item, int position){
		if(position == 0){
			Node<E> node = new Node<E>(item);
			node.next = head;
			head = node;
			++size;
		}
		else{
			Node<E> prev = head;
			for(int i=0; i<position-1; i++){
				prev = prev.next;
			}
			Node<E> node = new Node<E>(item);
			node.next = prev.next;
			prev.next = node;
			++size;
		}
	}
	//Get : This takes in an integer position which then returns the node at that position in the list. If the position is invalid, return null
	public E get(int position){
		//error check
		if(position<0||position>=size){
			return null;
		}

		Node<E> curr = head;
		for (int i = 0; i<position; i++){
			curr = curr.next;
		}
		return curr.data;
	}
	//Remove: The function takes in an integer position , which it then both removes and returns the ListNode at that position
	public E remove(int position){
		//Error check
		if (position == 0){
			Node<E> node = head;
			head = head.next;
			--size;
			return node.data;
		}
		else{
			Node<E> prev = head;
			for (int i=0; i<position-1; i++){
				prev = prev.next;
			}
			Node<E> node = prev.next;
			prev.next = node.next;
			--size;
			return node.data;
		}
	}
	//Reverse: The function reverses the whole linked list from head to tail. It should take in a parameter ListNode head. And return back the new head once the function is finished.
	public Node<E> reverse(Node<E> head){
		Node<E> prev=null;
		Node<E> curr= head;
		Node<E> next= null;
		while(curr!=null){
			next= curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	//print function
	public void printList(){
		Node<E> node = head;
		while(node != null){
			System.out.print(node.data+"->");
			node = node.next;
		}
		System.out.println("NULL");
	}
	//Main function
	public static void main(String[] args){
		LinkedList<Integer> lL = new LinkedList();
	    //OG list
	    lL.add(1);
	    lL.add(2);
	    lL.add(3);
	    lL.add(4);
	    lL.add(5);

		System.out.println("ADD 6");
		System.out.print("Given List: ");
		//print OG list
		lL.printList();
		System.out.print("Output: ");
		lL.add(6);
		//print new list
		lL.printList();

		System.out.println("ADD 6 POSITION 0");
		System.out.print("Given List: ");
		//print OG list
		lL.printList();
		System.out.print("Output: ");
		lL.add(6, 0);
		//print new list
		lL.printList();

		System.out.println("GET POSITION 2");
		System.out.print("Given List: ");
		//print OG list
		lL.printList();
		System.out.print("Output: ");
		System.out.println(lL.get(2));
		//print value at givven position

		System.out.println("REMOVE POSITION 4");
		System.out.print("Given List: ");
		//print OG list
		lL.printList();
		System.out.print("Output: ");
		lL.remove(4);
		lL.printList();

		System.out.println("REVERSE");
		System.out.print("Given List: ");
		//print OG list
		lL.printList();
		System.out.print("Output: ");
		lL.head = lL.reverse(lL.head);
		//print new list
		lL.printList();

	}
}
