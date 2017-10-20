package codeSprint;

import java.util.*;

class AdjacencyList{
	public int noOfCites = 0;
	static Map<Node,HashSet<Node>> NodeReachedFrom = new HashMap<Node,HashSet<Node>>();
    public AdjacencyList() {
    }
    public void mergeReachalbes(Node from,Node to){
    	HashSet<Node> reachablesTo = new HashSet<>();
    	HashSet<Node> reachablesFrom = new HashSet<>();
    	if(NodeReachedFrom.containsKey(to)){
    		reachablesTo = NodeReachedFrom.get(to);
    	}
    	
    	if(NodeReachedFrom.containsKey(from)){
    		reachablesFrom = NodeReachedFrom.get(from);
    	}
    	reachablesTo.add(from);
    	reachablesTo.addAll(reachablesFrom);
    	NodeReachedFrom.put(to, reachablesTo);
    }
    public boolean backtracking(Node source,Node destination){
    	Queue<Node> frontier = new LinkedList<>();
    	HashSet<Node> visitedNodes = new HashSet<>();
    	if(NodeReachedFrom.containsKey(source)){
    		HashSet<Node> reachedFrom = NodeReachedFrom.get(source);
    		if(reachedFrom.contains(destination)){
    			return true;
    		}
    		frontier.addAll(reachedFrom);
    	}
    	while(! frontier.isEmpty()){
    		Node current = frontier.poll();
    		if(!visitedNodes.contains(current)){
    			visitedNodes.add(current);
    			if(current.equals(destination)){
    				return true;
    			}
    			if(NodeReachedFrom.containsKey(current)){
    	    		HashSet<Node> reachedFrom = NodeReachedFrom.get(current);
    	    		if(reachedFrom.contains(destination)){
    	    			return true;
    	    		}
    	    		frontier.addAll(reachedFrom);
    			}
    		}
    	}
    	return false;
    }
   
}

class Node {
    private final int data;
    public Node(int data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Node{" +
            "cityIndex=" + data +
            '}';
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
}
public class CityConstruction {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        AdjacencyList graph = new AdjacencyList();
	        graph.noOfCites = n;
	        for(int a0 = 0; a0 < m; a0++){
	            int from = in.nextInt();
	            int to = in.nextInt();
	            Node fromNode = new Node(from);
	            Node toNode = new Node(to);
	            graph.mergeReachalbes(fromNode,toNode);
	        }
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int command = in.nextInt();
	            if(command == 1){
	            	graph.noOfCites += 1;
	            	Node newNode = new Node(graph.noOfCites);
	            	Node existingNode = new Node(in.nextInt());
	            	int direction = in.nextInt();
	            	if(direction == 0){
	            		graph.mergeReachalbes(existingNode, newNode);
	            	}else{
	    	            graph.mergeReachalbes(newNode, existingNode);
	            	}
	            }else{
	            	// find connections
	            	Node from = new Node(in.nextInt());
	            	Node to = new Node(in.nextInt());
	            	if(graph.backtracking(to, from)){
	            		System.out.println("Yes");
	            	}else{
	            		System.out.println("No");
	            	}
	            }
	        }
	        in.close();
	 }
}
