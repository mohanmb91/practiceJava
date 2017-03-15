package Need;

import java.util.*;
class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

  
    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (getFrom() != null ? !getFrom().equals(edge.getFrom()) : edge.getFrom() != null)
            return false;
        return !(getTo() != null ? !getTo().equals(edge.getTo()) : edge.getTo() != null);

    }

    @Override
    public String toString() {
        return "Edge{" +
            "from=" + from +
            ", to=" + to +
            '}';
    }

    @Override
    public int hashCode() {
        int result = getFrom() != null ? getFrom().hashCode() : 0;
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        return result;
    }
}
class Node{
    private final int data;
    private int distance;
    public Node(int data) {
        this.data = data;
        this.distance = 0;
    }
    public int getDistance(){
    	return this.distance;
    }
    public void setDistance(int dist){
    	 this.distance = dist;
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
class Graph{
    Map<Node, Collection<Edge>> adjacencyList= new HashMap<Node,Collection<Edge>>();
    protected Graph() {

    }

    public boolean adjacent(Node x, Node y) {
    	if(adjacencyList.containsKey(x)){
   		  Collection<Edge> edges = adjacencyList.get(x);
   		  for(Edge eachEdge: edges){
   			  if(eachEdge.getTo().getData() == y.getData() ){
   				  return true;
   			  }
   		  }
   	  }
        return false;
    }

    public List<Node> neighbors(Node x) {
    	List<Node> neighborsNodes = new ArrayList<>();
    	if(adjacencyList.containsKey(x)){
   		  Collection<Edge> edges = adjacencyList.get(x);
   		  for(Edge eachEdge: edges){
   			  neighborsNodes.add(eachEdge.getTo());
   		  }
   		  return neighborsNodes;
   	  }
        return neighborsNodes;
    }

    public boolean addNode(Node x) {
    	if(!adjacencyList.containsKey(x)){
    		  adjacencyList.put(x,new ArrayList<Edge>());
    		  return true;
   	  	}
        return false;
    }

    public boolean removeNode(Node x) {
    	if(adjacencyList.containsKey(x)){
  		  adjacencyList.remove(x);
  		for(Map.Entry<Node, Collection<Edge>> entry : adjacencyList.entrySet()) {
			Node key = entry.getKey();
			Collection<Edge> value = entry.getValue();
			for (Iterator iterator = value.iterator(); iterator.hasNext();) {
				Edge edge = (Edge) iterator.next();
				if(edge.getTo().equals(x)){
					iterator.remove();

				}
			}
			adjacencyList.put(key, value);
			}
  		  return true;
 	  }
        return false;
    }

    public boolean addEdge(Edge x) {
    	Node from = x.getFrom();
    	Node to = x.getTo();
    	if(adjacencyList.containsKey(from) && adjacencyList.containsKey(to)){
    		Collection<Edge> edges = adjacencyList.get(from);
    		for(Edge eachEdge : edges){
    			if(eachEdge.equals(x)){
    				return false;
    			}
    		}
    		edges.add(x);
    		adjacencyList.put(from, edges);
    		return true;
    	}
        return false;
    }

    public boolean removeEdge(Edge x) {
    	Node from = x.getFrom();
    	if(adjacencyList.containsKey(from)){
    		Collection<Edge> edges = adjacencyList.get(from);
    		if(edges == null){
    			return false;
    		}
    		Edge removeEdge = null;
    		boolean edgeFound = false;
    		for(Edge eachEdge : edges){
    			if(eachEdge.getTo().equals(x.getTo())){
    				removeEdge = eachEdge;
    				edgeFound = true;
    				break;
    			}
    		}
    		if(!edgeFound){
    			return edgeFound;
    		}
    		edges.remove(removeEdge);
    		adjacencyList.put(from,edges);
    		return true;
    	}
        return false;
    }

 public Node getNodeIndexByData(int data){
    	for (Map.Entry<Node,Collection<Edge>> entry : adjacencyList.entrySet()) {
    		  Node key = entry.getKey();
    		  if( key.getData() ==  data){
      			return key;
      			}
    		  }
    	return null;
    }
}
class Checker implements Comparator<Node>{
	@Override
	public int compare(Node n1,Node n2){
		if(n1.getDistance() > n2.getDistance()){
			return 1;
		}else if(n1.getDistance() < n2.getDistance() ){
			return -1;
		}
		return 0;
	}
}
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q>0){
        	Graph graph = new Graph();
        	int noOfNodes = in.nextInt();
        	for(int i=1;i <= noOfNodes; i ++){
        		graph.addNode(new Node(i));
        	}
        	int noOfEdges = in.nextInt();
        	for(int i =0 ; i < noOfEdges; i ++){
        		Node u = new Node(in.nextInt());
        		Node v = new Node(in.nextInt());
        		graph.addEdge(new Edge(u, v));
        		graph.addEdge(new Edge(v, u));
        	}
        	
        	Node start = new Node(in.nextInt());
        	PriorityQueue<Node> frontier = new PriorityQueue<Node>(10,new Checker());
        	frontier.add(start);
        	HashSet<Node> exploredSet = new HashSet<Node>();
        	HashMap<Node , Edge> parents = new HashMap<Node , Edge>(); 
        	HashMap<Node , Node> getNode = new HashMap<Node , Node>(); 
        	while(!frontier.isEmpty()){
        		Node current = frontier.poll();
        		exploredSet.add(current);
        		for(Node eachNeibhor : graph.neighbors(current) ){
        			if(!exploredSet.contains(eachNeibhor)){
        				int neibhourWeight = 1;
        				int currentNodeWeight = current.getDistance();
        				int combinedWeight = neibhourWeight + currentNodeWeight;
        				if(!frontier.contains(eachNeibhor)){
        					eachNeibhor.setDistance(combinedWeight);
        					frontier.add(eachNeibhor);
        					parents.put(eachNeibhor, new Edge(current, eachNeibhor));
        					getNode.put(eachNeibhor, eachNeibhor);
        					}else{
        					if(combinedWeight < eachNeibhor.getDistance()){
        						frontier.remove(eachNeibhor);
        						eachNeibhor.setDistance(combinedWeight);
        						frontier.add(eachNeibhor);	
        						parents.put(eachNeibhor, new Edge(current, eachNeibhor));
        						getNode.put(eachNeibhor, eachNeibhor);
        					}
        				}
        			}
        		}
        	}
        	for(int i = 1; i <= noOfNodes ; i ++){
        		Node node = new Node(i);
        		if(node.equals(start)){continue;}
        		if(parents.containsKey(node)){
        			System.out.print((getNode.get(node).getDistance() * 6) +  " " );
        		}else{
        			System.out.print("-1 ");
        		}
        	}
        	System.out.println();
        	q--;
        }
        in.close();
    }
}


