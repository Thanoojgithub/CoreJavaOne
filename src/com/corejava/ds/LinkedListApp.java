package com.corejava.ds;

public class LinkedListApp {

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();

		linkedList.add("2");
		linkedList.add("4");
		linkedList.add("1");
		linkedList.add("3");
		linkedList.add("5");
		linkedList.add("6",3);

		System.out.println("linkedList :: " + linkedList);
		System.out.println("linkedList.size():: " + linkedList.size());
		System.out.println("linkedList.get(3) :: " + linkedList.get(3));
		System.out.println("linkedList.remove(2) :: " + linkedList.remove(2));
		System.out.println("linkedList.get(3) :: " + linkedList.get(3));
		System.out.println("linkedList.size() :: " + linkedList.size());
		System.out.println("linkedList :: " + linkedList);
	}

}

class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node is set to a new node with no data (null)
		head = new Node(null);
		listCount = 0;
	}

	public void add(Object data)
	// appends the specified element to the end of this list.
	{
		Node node = new Node(data);
		Node currentNode = head;
		// starting at the head node, crawl to the end of the list
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		// the last node's "next" reference set to our new node
		currentNode.setNext(node);
		listCount++;// increment the number of elements variable
	}

	public void add(Object data, int index)
	// inserts the specified element at the specified position in this list
	{
		Node node = new Node(data);
		Node currentNode = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 1; i <= index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		node.setNext(currentNode.getNext());
		// now set this node's next-node reference to the new node
		currentNode.setNext(node);
		listCount++;// increment the number of elements variable
	}

	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index <= 0)
			return null;

		Node currentNode = head.getNext();
		for (int i = 1; i <= index; i++) {
			if(currentNode != null)
			if (currentNode.getNext() == null)
				return null;
		}
		return currentNode.getData();
	}

	public boolean remove(int index)
	// removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node currentNode = head;
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null)
				return false;

			currentNode = currentNode.getNext();
		}
		currentNode.setNext(currentNode.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

	public int size()
	// returns the number of elements in this list.
	{
		return listCount;
	}

	public String toString() {
		Node currentNode = head.getNext();
		String output = "";
		while (currentNode != null) {
			output += "[" + currentNode.getData().toString() + "]";
			currentNode = currentNode.getNext();
		}
		return output;
	}

	private class Node {
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;

		// Node constructor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}

		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		// these methods should be self-explanatory
		public Object getData() {
			return data;
		}

		public void setData(Object dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextValue) {
			next = nextValue;
		}
	}
}