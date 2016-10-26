package main;

class BSTNode<T>{
	BSTNode left;
	BSTNode right;
	T data;
	public BSTNode(T newData) {
		this.data = newData;
		this.left = this.right = null;
	}
	public BSTNode(T newData,BSTNode<T> newLeft,BSTNode<T> newRight) {
		this.data = newData;
		this.left = newLeft;
		this.right = newRight;
	}
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}	

} 

public class BSTree<T> {
	
	BSTNode root = null;
	
	public void insert(T data){
		BSTNode<T> node = new BSTNode(data);
		if(root == null){
			root = node;
		}else{
			
		}
	}
	
	public static void main (String[] args){
		
	}
}
