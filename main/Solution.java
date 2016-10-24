package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TreeNode{
	String directoryName;
	List<TreeNode> childrens;
	TreeNode parent;
	
	public TreeNode(String newDirectoryName, TreeNode nodeParent){
		this.directoryName = newDirectoryName;
		this.childrens = new ArrayList<TreeNode>();
		this.parent =  nodeParent;
	}
	
	public List<TreeNode> getChildrens(){
		return this.childrens;
	}
	public String getDirectoryName(){
		return this.directoryName;
	}

	public void setChildrens(List<TreeNode> newChildrens) {
		// TODO Auto-generated method stub
		this.childrens = newChildrens;
	}
}
class NTree{
	TreeNode root;
	
	public void setRoot(TreeNode rootNode){
		this.root = rootNode;
	}
	public TreeNode addNode(TreeNode parentNode,TreeNode addNode){
		TreeNode parent = searchNode(parentNode.getDirectoryName());
		List<TreeNode> childrens = parent.getChildrens();
		childrens.add(addNode);
		parent.setChildrens(childrens);
		return root;
	}
	public TreeNode searchNode(String nodeName){
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode currentNode = queue.poll();
			if(currentNode.getDirectoryName().equals(nodeName)){
				return currentNode;
			}
			for(TreeNode eachChild : currentNode.getChildrens()){
				queue.add(eachChild);
			}
		}
		
		return null;
	}
}
public class Solution {
public static void main(String[] args) {
	NTree tree = new NTree();
	TreeNode root = new TreeNode("start", null);
	tree.setRoot(root);
	String input = "dir1\n dir11\n  dir111\n   mohan.jpeg\ndir2\ndir3\n dir31\n guru.jpeg\ndir4";
	System.out.println(input);
	HashMap<Integer, String> levelTrack = new HashMap<>();
	String[] dirs = input.split("\n");
	String current = null;
	int currentLevel = Integer.MAX_VALUE,maxPathLength = 0;
	String maxPath = "";
	for(String eachdir: dirs){
		
		String[] spaces = eachdir.split(" ");
		currentLevel = spaces.length -1;
		current = eachdir;
		current = current.replaceAll(" ", "");
		if(!current.contains(".")){
			levelTrack.put(currentLevel, current);
		}
		else{
			String path = "";
			for(int i =0; i <= currentLevel; i ++){
				if(i == currentLevel){
					path += current;
					break;
				}
				path += levelTrack.get(i) + "/";
			}
			int tempPathLength = path.length();
			if(tempPathLength > maxPathLength){
				maxPathLength = tempPathLength;
				maxPath = path;
			}
		}

	}
	System.out.println(maxPath+"   =====>    "+maxPathLength );
	System.out.println("end");
}
}












//if(currentLevel == 0){
//tree.addNode(tree.root, new TreeNode(current, tree.root));
//}else{
//if(levelTrack.containsKey(currentLevel -1)){
//tree.addNode(tree.searchNode(levelTrack.get(currentLevel -1)), new TreeNode(current, tree.searchNode(levelTrack.get(currentLevel -1))) );
//}
//}