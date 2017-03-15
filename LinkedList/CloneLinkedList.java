package LinkedList;

import java.util.HashMap;

class NodeData{
	int data;
	NodeData nextNode;
	NodeData arbitaryNode;
	public NodeData(int data){
		this.data = data;
		this.nextNode = this.arbitaryNode = null;
	}
}

class LinkedListCustom{
	NodeData head;
	public LinkedListCustom() {
		this.head = null;
	}
	public LinkedListCustom(NodeData node){
		this.head = node;
	}
	public NodeData push(int data){
		NodeData node = new NodeData(data);
		if(this.head == null){
			this.head = node;
		}else{
			node.nextNode = this.head;
			this.head = node;
		}
		return this.head;
	}
	
	public void print(NodeData temp){
		while(temp != null){
			System.out.println("Node data ==> " + temp.data + " Arbitarty Data ==> " + temp.arbitaryNode.data);
			temp = temp.nextNode;
		}
	}
	
	public NodeData cloneLinkedList(NodeData orgHead){
		HashMap<NodeData, NodeData> map = new HashMap<>();
		NodeData tempOrgNode = orgHead;
		while(tempOrgNode != null){
			NodeData temp = new NodeData(tempOrgNode.data);
			map.put(tempOrgNode, temp);
			tempOrgNode = tempOrgNode.nextNode;
		}
		
		tempOrgNode = orgHead;
		while(tempOrgNode != null){
			NodeData temp = map.get(tempOrgNode);
			temp.nextNode = map.get(tempOrgNode.nextNode);
			temp.arbitaryNode = map.get(tempOrgNode.arbitaryNode);
			tempOrgNode = tempOrgNode.nextNode;
		}
		System.out.println(Math.hypot(3, 6));
		return map.get(orgHead);
	}
	
}

public class CloneLinkedList {
	public static void main(String args[]){
		LinkedListCustom list = new LinkedListCustom();
		list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
 
        // Setting up random references.
        list.head.arbitaryNode = list.head.nextNode.nextNode;
        list.head.nextNode.arbitaryNode = 
        		list.head.nextNode.nextNode.nextNode;
        list.head.nextNode.nextNode.arbitaryNode = list.head;
        list.head.nextNode.nextNode.nextNode.arbitaryNode = list.head.nextNode;
       
        
        
        NodeData clone = list.cloneLinkedList(list.head);
        
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
        System.out.println("\nCloned linked list");
        list.print(clone);
	}
	
	
	
	
}
