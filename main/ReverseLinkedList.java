package main;

import java.util.*;
class Node<T>{
T data;
Node<T> next;
public Node(T data){this.data = data;this.next = null;}
public T getData(){return this.data;}
}

class LinkedList<T>{
Node<T> head = null;

public void insert(T data){
 Node<T> newNode = new Node<T>(data);

if(head == null){
	head = newNode;
}else{
	Node<T> currentNode = head;
	while(currentNode.next != null){
		currentNode=currentNode.next;
	}
	currentNode.next = newNode;
}
}
public void printLinkedList(){
Node<T> currentNode = head;
while(currentNode != null){
System.out.println(currentNode.getData());
currentNode = currentNode.next;
}
}
}
class practice{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
int size = in.nextInt();
LinkedList<Integer> linked = new LinkedList<Integer>();
for(int i=0;i < size; i ++){
linked.insert(in.nextInt());
}

System.out.println("Printing the LinkedList before reverse");

linked. printLinkedList();

Node<Integer> currentNode = linked.head;
Node<Integer> previous = null;
Node<Integer> next = null;

while(currentNode.next != null){
	next = currentNode.next;
	currentNode.next =previous;
	previous = currentNode;
	currentNode = next;
}
linked.head = currentNode;
linked.head.next = previous;
System.out.println("Printing the LinkedList after reverse");

linked.printLinkedList();

in.close();
}
}