package Graph;

import java.util.*;

class Node{
    private final int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
            "data=" + data +
            '}';
    }

    @Override
    public boolean equals(Object o) {
    	Node node = (Node) o;
        return this.getData() == node.getData();
    }
    @Override
    public int hashCode() {
    	int hashCode = 1;
    	hashCode = 31 * this.getData();
    	return hashCode;
    }
}

public class Solution2 {
	static int edgesRemoved = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        HashMap<Node,HashSet<Node>> nodesNeibhor = new HashMap<Node,HashSet<Node>>();;
        for(int a0 = 0; a0 < e; a0++){
                int u = in.nextInt();
                int v = in.nextInt();
                Node U = new Node(u);
                Node V = new Node(v);
                if(nodesNeibhor.containsKey(U)){
                	HashSet<Node> neibhors = nodesNeibhor.get(U);
                	if(!neibhors.contains(V)){
                	neibhors.add(V);
                	nodesNeibhor.put(U, neibhors);
                	}
                }else{
                	HashSet<Node> neibhors = new HashSet<>();
                	neibhors.add(V);
                	nodesNeibhor.put(U, neibhors);
                }
                if(nodesNeibhor.containsKey(V)){
                	HashSet<Node> neibhors = nodesNeibhor.get(V);
                	if(!neibhors.contains(V))
	                	neibhors.add(U);
	                	nodesNeibhor.put(V, neibhors);
                }else{
                	HashSet<Node> neibhors = new HashSet<>();
                	neibhors.add(U);
                	nodesNeibhor.put(V, neibhors);
                }
            }
        
        Node root = new Node(1);
        HashSet<Node> visitedNodes = new HashSet<>();
        dfs(root,nodesNeibhor,visitedNodes);
        System.out.println(edgesRemoved);
        in.close();
    }

	private static int dfs(Node root, HashMap<Node, HashSet<Node>> nodesNeibhor, HashSet<Node> visitedNodes) {
		visitedNodes.add(root);
		int result = 0;
		for(Node eachNeibhour: nodesNeibhor.get(root)){
			if(!visitedNodes.contains(eachNeibhour)){
				int  temp = dfs(eachNeibhour, nodesNeibhor, visitedNodes);
				if(temp % 2 == 0)
					edgesRemoved += 1;
				result += temp ;
		}
		}
		result += 1;
		return result;
	}
	
}



