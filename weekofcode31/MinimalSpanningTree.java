package weekofcode31;

import java.util.*;

class NodeG<T>{
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeG(T data) {
		this.data = data;
	}
	
	public NodeG(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		NodeG other = (NodeG) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
}
class PointAB{
	int a;
	int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
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
		PointAB other = (PointAB) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	public PointAB(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
}
class GraphEdge<T>{
	public NodeG<T> from;
	public NodeG<T> to;
	public PointAB PointAB;
	public NodeG<T> getFrom() {
		return from;
	}
	public void setFrom(NodeG<T> from) {
		this.from = from;
	}
	public NodeG<T> getTo() {
		return to;
	}
	public void setTo(NodeG<T> to) {
		this.to = to;
	}
	public PointAB getPointAB() {
		return PointAB;
	}
	public void setPointAB(PointAB PointAB) {
		this.PointAB = PointAB;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((PointAB == null) ? 0 : PointAB.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		GraphEdge other = (GraphEdge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (PointAB == null) {
			if (other.PointAB != null)
				return false;
		} else if (!PointAB.equals(other.PointAB))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	public GraphEdge(NodeG<T> from, NodeG<T> to, PointAB PointAB) {
		super();
		this.from = from;
		this.to = to;
		this.PointAB = PointAB;
	}

	
	public static Comparator<GraphEdge> GraphEdgeComparator
    = new Comparator<GraphEdge>() {

		@Override
		public int compare(GraphEdge o1, GraphEdge o2) {
			int a1=o1.getPointAB().getA();
			int b1=o1.getPointAB().getB();
			int a2=o2.getPointAB().getA();
			int b2=o2.getPointAB().getB();
			//System.out.println(a1+"   "+b1);
			double first=(double)a1/b1;
			//System.out.println(first);
			double second = (double)a2/b2;
			if(first<second)
				return 1;
			else if(first>second)
				return -1;
			else 
				if(a1<a2 && b1<b2)
					return -1;
				else if(a1>a2 && b1>b2)
					return 1;
				else 
						return 0;
		}
		
	};
	
	
}

class DisjointSet {

	private static Map<Integer,Node> map=new HashMap<>();
	class Node{
		int rank;
		int data;
		Node parent;
	}
	public void makeSet(int data){
		Node node=new Node();
		node.data=data;
		//PointABing to itself
		node.parent=node;
		node.rank=0;
		map.put(data,node);		
	}
	
	public boolean union(int data1,int data2){
		Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findParentSet(node1);
        Node parent2 = findParentSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
	}
	public int findSet(int data) {
        return findParentSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node findParentSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findParentSet(node.parent);
        return node.parent;
    }
}


public class MinimalSpanningTree {

	public static List<GraphEdge> listOfGraphEdges=new ArrayList<GraphEdge>();
	public static Set<Integer> allNodes = new HashSet<Integer>(); 
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int e=scan.nextInt();
		
		for(int i=0;i<e;i++){
			int fromData = scan.nextInt();
			int toData = scan.nextInt();
			NodeG from = new NodeG(fromData);
			NodeG to = new NodeG(toData); 
			allNodes.add(fromData);
			allNodes.add(toData);
			PointAB PointAB = new PointAB(scan.nextInt(),scan.nextInt());	
			listOfGraphEdges.add(new GraphEdge(from, to, PointAB));
		}
		
		Collections.sort(listOfGraphEdges,GraphEdge.GraphEdgeComparator);
		//System.out.println("****************************************");
        /*
		for(GraphEdge eachEdge: listOfGraphEdges){
			System.out.println(eachEdge.PointAB.getA() + "  A : B  " + eachEdge.PointAB.getB());
		}*/
		String answer=getMST(n);
		System.out.println(answer);

	}

	public static long nr=0;
	public static long dr=0;
	
	private static String getMST(int noOfNodes) {
		DisjointSet disjointSet = new DisjointSet();
		
		for(Integer eachNode : allNodes){
			disjointSet.makeSet(eachNode);
		}
		
		for(GraphEdge eachEdge: listOfGraphEdges){
			int root1= disjointSet.findSet((int)eachEdge.getFrom().getData());
			int root2= disjointSet.findSet((int)eachEdge.getTo().getData());
			
			//System.out.println(eachEdge.getFrom().getData() + "   "+ eachEdge.getTo().getData());	
			//System.out.println(root1 + " root 1 : root 2 "+root2);
			
			if(root1!=root2){
				//System.out.println("***");
				//System.out.println(eachEdge.getPointAB().getA() +"/"+eachEdge.getPointAB().getB());
				nr+=eachEdge.getPointAB().getA();
				dr+=eachEdge.getPointAB().getB();
				disjointSet.union((int)eachEdge.getFrom().getData(), (int)eachEdge.getTo().getData());
			}
		}
		
		return nr+"/"+dr;
	}

}