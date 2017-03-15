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

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            HashMap<Node,List<Node>> nodesNeibhor = new HashMap<Node,List<Node>>();
            for(int a1 = 0; a1 < n-1; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                Node U = new Node(u);
                Node V = new Node(v);
                if(nodesNeibhor.containsKey(U)){
                	List<Node> neibhors = nodesNeibhor.get(U);
                	neibhors.add(V);
                	nodesNeibhor.put(U, neibhors);
                }else{
                	List<Node> neibhors = new ArrayList<>();
                	neibhors.add(V);
                	nodesNeibhor.put(U, neibhors);
                }
                if(nodesNeibhor.containsKey(V)){
                	List<Node> neibhors = nodesNeibhor.get(V);
                	neibhors.add(U);
                	nodesNeibhor.put(V, neibhors);
                }else{
                	List<Node> neibhors = new ArrayList<>();
                	neibhors.add(U);
                	nodesNeibhor.put(V, neibhors);
                }
            }
            int g = in.nextInt();
            int k = in.nextInt();
            HashMap<Node,Node> guessess = new HashMap<Node,Node>();
            for(int a1 = 0; a1 < g; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                Node U = new Node(u);
                Node V = new Node(v);
                guessess.put(V,U);
            }
            int possibleCorrectGuess = 0;
            int GCD = 0;
            int total = nodesNeibhor.size();
            for(Node eachNode:nodesNeibhor.keySet()){
            	if(isCorrectGuess(eachNode,nodesNeibhor,guessess,k)){
            		possibleCorrectGuess += 1;
            		if(total % possibleCorrectGuess == 0){
            			GCD = possibleCorrectGuess;
            		}
            	}
            	
            }
            if(possibleCorrectGuess == 0){
            	System.out.println("0/1");
            }else{
            	total = total / GCD;
            	possibleCorrectGuess = possibleCorrectGuess / GCD;
            	System.out.println(possibleCorrectGuess +"/"+ total);
            }
        }
    }

	private static boolean isCorrectGuess(Node root,HashMap<Node,List<Node>> graph, HashMap<Node,Node> guessess,int k) {
		Queue<Node> frontier = new LinkedList<Node>();
		HashSet<Node> visitedNodes = new HashSet<Node>();
		frontier.add(root);
		int count = 0;
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			visitedNodes.add(current);
			for(Node eachNeibhor: graph.get(current)){
				if(!visitedNodes.contains(eachNeibhor)){
					frontier.add(eachNeibhor);
					if(guessess.containsKey(eachNeibhor)){
						if(guessess.get(eachNeibhor).equals(current)){
							count += 1;
							if(count >= k){
								return true;
							}
						}
					}
				}
			}
		}
		if(count >= k){
			return true;
		}
		return false;
	}
}
