package LinkedList;

import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class LinkedListPractice
{
    public static Node removeDuplicates(Node head) {
        //Write your code here
          Node currentNode = head;
          Node runner;
          
          if(currentNode != null){
	          while(currentNode != null){
	        	runner = currentNode;
	        	while(runner.next != null){
	        		if(runner.next.data == currentNode.data){
	        			runner.next = runner.next.next;
	        		}else{
		        		runner = runner.next;
	        		}
	        		if(runner == null) break;
		        		
	        	}
	        	currentNode = currentNode.next;
	          }
          }
          
          return head;
      }
    public static Node reverse(Node head){
    	Node current = head;
    	Node reverseList = new Node(current.data);
    	while(current.next != null){
    		Node temp = reverseList;
    		reverseList = new Node(current.next.data);
    		reverseList.next = temp;
    		current =  current.next;
    	}
    	return reverseList;
    }
    
public static  Node insert(Node head,int data)
{
    Node p=new Node(data);			
    if(head==null)
        head=p;
    else if(head.next==null)
        head.next=p;
    else
    {
        Node start=head;
        while(start.next!=null)
            start=start.next;
        start.next=p;

    }
    return head;
}
public static void display(Node head)
    {
          Node start=head;
          while(start!=null)
          {
              System.out.print(start.data+" ");
              start=start.next;
          }
    }
    public static void main(String args[])
    {
          Scanner sc=new Scanner(System.in);
          Node head=null;
          int T=sc.nextInt();
          while(T-->0){
              int ele=sc.nextInt();
              head=insert(head,ele);
          }
          //head=removeDuplicates(head);
          display(reverse(head));

   }
}

