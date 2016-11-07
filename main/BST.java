package main;

import java.util.LinkedList;
import java.util.Queue;

class BSTNode<T>{
	T data;
	BSTNode<T> left;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BSTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	public BSTNode<T> getRight() {
		return right;
	}
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	BSTNode<T> right;
	public BSTNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BSTTree<T>{
	BSTNode<T> root;
	public void insert(BSTNode<Integer> rootNode, BSTNode<Integer> insertNode) {
		// TODO Auto-generated method stub
			if(rootNode.data >= insertNode.data){
				if(rootNode.left != null){
				insert(rootNode.left,insertNode);
				}else{
					rootNode.left = insertNode;
				}
			}else{
				if(rootNode.right != null){
					insert(rootNode.right,insertNode);
					}else{
						rootNode.right = insertNode;
					}
			}
	}
	public BSTNode<Integer> search(BSTNode<Integer> rootNode, int data){
			BSTNode<Integer> nodeFound = null;
			BSTNode<Integer> currentNode =  (BSTNode<Integer>) rootNode;
			if(currentNode.data == data){
				nodeFound = currentNode;
			}else{
				if(rootNode.data >= data){
					nodeFound = search(rootNode.left,data);
				}else{
					nodeFound = search(rootNode.right,data);
				}
			
			}
			
			return nodeFound;
	}
}
public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTTree<Integer> tree = new  BSTTree<Integer>();
		tree.root = new BSTNode<Integer>(5);
		tree.insert(tree.root,new BSTNode<Integer>(4));
		tree.insert(tree.root,new BSTNode<Integer>(3));
		tree.insert(tree.root,new BSTNode<Integer>(6));
		BSTNode<Integer> searchNode = tree.search(tree.root,3);
		System.out.println(searchNode == null ? "node not found": "node found with value "+searchNode.data);
	}

	

}
