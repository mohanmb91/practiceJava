package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class NodeTrie{
    char searchKey;
    List<NodeTrie> childrens;
    boolean isCompleteWord;
    public NodeTrie(char newKey){
        searchKey = newKey;
        childrens = new ArrayList<NodeTrie>();
        isCompleteWord = false;
    }
    public List<NodeTrie> getChildrens(){
        return childrens;
    }
    public void setChildrens(List<NodeTrie> newChildrens){
        childrens = newChildrens;
    }
}

class TreeTrie{
    NodeTrie root;
    public void insertNode(String searchKey){
        String key = searchKey;
        int i =0;
        NodeTrie currentNode = root;
        while(key.length() > i){
            char currentKey = key.charAt(i);
            NodeTrie nodeFound = findNode(currentNode,currentKey);
            if(nodeFound.equals(currentNode)){
            		NodeTrie newNode = new NodeTrie(currentKey);
                    List<NodeTrie> childrends = currentNode.getChildrens();
                	if(i == key.length() -1){
                    	newNode.isCompleteWord = true;
                    }
                    childrends.add(newNode);
                    
                    currentNode.setChildrens(childrends);
                    currentNode = newNode;
            }else{
                currentNode = nodeFound;
            }
            i++;
        }
    }
    public NodeTrie findNode(NodeTrie startNode,char searchKey){
        Queue<NodeTrie> queue = new LinkedList();
        queue.add(startNode);
        while(!queue.isEmpty()){
           NodeTrie currentNode = queue.poll();
           boolean nodeFound = false;
           for(NodeTrie eachChildrenNode: currentNode.childrens){
               if(eachChildrenNode.searchKey == searchKey){
                   nodeFound = true;
                   return eachChildrenNode;
               }
           }
            if(!nodeFound){
                return currentNode;
            }
        }
        return null;
    }
	public int findPossiblePath(String string) {
		NodeTrie currentNode = root;
		int count = 0;
		for(int i =0; i < string.length(); i++){
			char currentChar = string.charAt(i);
			NodeTrie foundNode = findNode(currentNode, currentChar);
//			if(foundNode.isCompleteWord){
//				count += 1;
//			}
			if(foundNode.equals(currentNode)){
				return count;
			}
			currentNode = foundNode;
		}
		count = dfs(currentNode,count);
		return count;
	}
	private int  dfs(NodeTrie startNode, int count) {
		// TODO Auto-generated method stub
		Stack<NodeTrie> stack = new Stack<>();
		stack.add(startNode);
		while(!stack.isEmpty()){
			NodeTrie currentNode = stack.pop();
			if(currentNode.isCompleteWord){
				count += 1;
			}
			for(NodeTrie eachNode: currentNode.getChildrens()){
				stack.add(eachNode);
			}
		}
		return count;
	}
}
public class TrieTree {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		  Scanner in = new Scanner(System.in);
	        int size = in.nextInt();
	        TreeTrie tree = new TreeTrie();
	    	tree.root = new NodeTrie('*');
	        //while(size-->=0){
	    	while(in.hasNextLine()){
	           String newLine = in.nextLine();
	            if(newLine.contains("add ")){
	                tree.insertNode(newLine.substring(4));
	            }else if(newLine.contains("find ")){
	                System.out.println(tree.findPossiblePath(newLine.substring(5)));	
	            }
	        }
	    	in.close();
		}
	
    }
/* inout
11
add s
add ss
add sss
add ssss
add sssss
find s
find ss
find sss
find ssss
find sssss
find ssssss
*/
/* expected output
5
4
3
2
1
0
 */

