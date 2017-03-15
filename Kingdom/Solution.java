package Kingdom;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    int data;
    boolean isBlue;
    public Node(int data,boolean isBlue){
        this.data = data;
        this.isBlue = isBlue;
    }
    public void setData(int data){
        this.data = data;
    }
    
    public int getData(){
        return this.data;
    }
    
    public void setIsBlue(boolean isBlue){
        this.isBlue = isBlue;
    }
    
    public boolean getIsBlue(){
        return this.isBlue;
    }
    
    @Override 
    public int hashCode(){
        int result = 17;
        result = 31 * result + this.data;
        return result;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(! (o instanceof Node)) return false;
        Node that = (Node) o;
        return this.data == that.getData();
    }
    
}

class Edge {
    private Node from;
    private Node to;
    private int value;

    public Edge(Node from, Node to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        if (getValue() != edge.getValue()) return false;
        if (getFrom() != null ? !getFrom().equals(edge.getFrom()) : edge.getFrom() != null)
            return false;
        return !(getTo() != null ? !getTo().equals(edge.getTo()) : edge.getTo() != null);

    }

    @Override
    public String toString() {
        return "Edge{" +
            "from=" + from +
            ", to=" + to +
            ", value=" + value +
            '}';
    }

    @Override
    public int hashCode() {
        int result = getFrom() != null ? getFrom().hashCode() : 0;
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + getValue();
        return result;
    }
}

class Graph{
    public Map<Node, Collection<Edge>> adjacencyList= new HashMap<Node,Collection<Edge>>();
    public Graph(){
        
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
    			//if(eachEdge.getTo().getData() == x.getTo().getData()){
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
    
    public Node getNode(Node node) {
        Iterator<Node> iterator = adjacencyList.keySet().iterator();
        Node result = null;
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.equals(node)) {
                result = next;
            }
        }
        return result;
    }
}

class Checker implements Comparator<PQ>{
    @Override
    public int compare(PQ s1, PQ s2){
        if(s1.height > s2.height  ){
            return 1;
        }else if(s1.height < s2.height  ){
            return -1;
        }
        else{
           return 0;
        }
    }
}

class PQ{
    Node node;
    int height;
}

public class Solution {
    static Set<Node> visitedNodes = new HashSet<Node>();
    static Set<Node> visitedNodesForHeight = new HashSet<Node>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ex = "I had been already working in Agile - Scrum based project and learned best coding practices. My past experience in this field will help myself to  quickly adapt to any technology and  also to any methodology. Being a productive employee for my employer is one of my key attributes. Having said that, I am a very good team player and I feel a perfect match between your requirements and my skill set. these are the reasons that made me to think as a fit candidate for your organization. looking forward for the positive response.";
        System.out.println(ex.length());
        int n = in.nextInt();
        
        Graph graph = new Graph();
        Node root = null;
        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            Node nodeU = new Node(u,true);
            Node nodeV = new Node(v,true);
            if(root == null){
                root = nodeU;
            }
            graph.addNode(nodeU);
            graph.addNode(nodeV);
            Edge edgeU = new Edge(nodeU,nodeV,1);
            Edge edgeV = new Edge(nodeV,nodeU,1);
            System.err.println("add edge from "+u+" to "+v+" ==> "+graph.addEdge(edgeU));
            System.err.println("add edge from "+v+" to "+u+" ==> "+graph.addEdge(edgeV));
        }
        Node leafNode = dfs(graph,root);
        if(leafNode.getData() == Integer.MIN_VALUE){
            System.out.println(0);
        }else{
            System.out.println( (redConvert(graph,leafNode) - 1) * 2 ) ;
        }
    }
    
    private static int getLongestPathNode(Graph graphs,Node eachNode) {
    	visitedNodesForHeight.add(eachNode);
    	    if(! hasUnvisitedNode(graphs.neighbors(eachNode))){
    	         return 0;
    	    }else{
    	        int maxDepth = 0;

    	        for(Node child : graphs.neighbors(eachNode)){
    	        	if(!visitedNodesForHeight.contains(child) && child.getIsBlue()){
    	        		maxDepth = Math.max(maxDepth, getLongestPathNode(graphs,child));
    	        	}
    	        }
    	        return maxDepth + 1;
    	    }
    }
    
    private static boolean hasUnvisitedNode(List<Node> neibhourNodes) {
		// TODO Auto-generated method stub
		for(Node eachNode : neibhourNodes){
			 if(! visitedNodesForHeight.contains(eachNode)){
				 return true;
			 }
		}
		return false;
	}
    
    public static int redConvert(Graph graph, Node source){
        PriorityQueue<PQ> frontier = new PriorityQueue<PQ>(10, new Checker());
        PQ currentNode = new PQ();
        currentNode.node = source;
        visitedNodes = new HashSet<Node>();
        visitedNodesForHeight = new HashSet<Node>();
        currentNode.height = 0;
        frontier.add(currentNode);
        int count = 1;
        while(! frontier.isEmpty()){
            PQ current = frontier.poll();
            (graph.getNode(current.node)).setIsBlue(false);
            visitedNodes.add(current.node);
            if(isKingdomPeaceFull(graph)){
                count += 1;
            }
            for(Node eachNeibhour: graph.neighbors(current.node)){
                if(eachNeibhour.getIsBlue() && ! visitedNodes.contains(eachNeibhour)){
                    currentNode = new PQ();
                    currentNode.node = eachNeibhour;
                    visitedNodesForHeight = new HashSet<Node>();
                    currentNode.height = getLongestPathNode(graph,eachNeibhour);
                    frontier.add(currentNode);
                }
            }
        }
        return count;
    }
    
    public static Node dfs(Graph graph, Node source){
        Stack<Node> stack = new Stack<Node>();
        stack.push(source);
        Node result = new Node(Integer.MIN_VALUE,true);
        while(!stack.empty()){
            Node currentNode = stack.pop();
            visitedNodes.add(currentNode);
            int initialCount = stack.size();
            for(Node eachNeibhour: graph.neighbors(currentNode)){
                if(! visitedNodes.contains(eachNeibhour)){
                    stack.push(eachNeibhour);
                }
            }
            if(stack.size() == initialCount){
                result =  currentNode;
                break;
            }
        }
        return result;
    }
    
    public static boolean isKingdomPeaceFull(Graph graph){
        Map<Node, Collection<Edge>> adjacencyList = graph.adjacencyList;
        for(Node eachNode: adjacencyList.keySet()){
            boolean isBalancedCity = false;
            for(Edge edges: adjacencyList.get(eachNode)){
                Node to = edges.getTo();
                if(to.getIsBlue() == eachNode.getIsBlue()){
                    isBalancedCity = true;
                    break;
                }
            }
            if(!isBalancedCity){
                return false;
            }
        }
        return true;
    }
}
