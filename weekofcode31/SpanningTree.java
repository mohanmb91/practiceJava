package weekofcode31;
import java.util.*;

class Edge{
	Node from;
	Node To;
	double a;
	double b;
	double value;
	public Edge(Node from, Node To, double a, double b, double value){
		this.from = from;
		this.To = To;
		this.a = a;
		this.b = b;
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((To == null) ? 0 : To.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
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
		Edge other = (Edge) obj;
		if (To == null) {
			if (other.To != null)
				return false;
		} else if (!To.equals(other.To))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		return true;
	}
}
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

class Checker implements Comparator<Edge>{
	@Override
	public int compare(Edge e1, Edge e2){
		if(e1.value < e2.value){
			return 1;
		}else if(e1.value > e2.value){
			return -1;
		}else{
			if(e1.a > e2.a ){
				return 1;
			}else if(e1.a < e2.a ){
				return -1;
			}
			return 0;
		}
	}
}
public class SpanningTree {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        PriorityQueue<Edge> frontier = new PriorityQueue<>(10, new Checker()); 
	        HashSet<Node> connectedNodes = new HashSet<Node>();
	        int n = in.nextInt();
	        int m = in.nextInt();
	        for(int a0 = 0; a0 < m; a0++){
	            int u = in.nextInt();
	            int v = in.nextInt();
	            double a = in.nextDouble();
	            double b = in.nextDouble();
	            double value = a/b;
	            Node U = new Node(u);
                Node V = new Node(v);
                if(!U.equals(V)){
                	frontier.add(new Edge(U, V, a, b, value));	
                }
	        }
	        int numerator = 0;
	        int denominator = 0;
	        while(!frontier.isEmpty()){
	        	Edge currentEdge = frontier.poll();
	        	Node first = currentEdge.from;
	        	Node second = currentEdge.To;
	        	if( (!( connectedNodes.contains(first)  && connectedNodes.contains(second))) ){
	        		numerator += currentEdge.a;
	        		denominator += currentEdge.b;
	        		connectedNodes.add(first);
	        		connectedNodes.add(second);
	        	}
	        }
	        int gcd = findGCD(numerator,denominator);
	        numerator /= gcd;
	        denominator /= gcd;
	        System.out.println(numerator+"/"+denominator);
	        in.close();
	    }

	private static int findGCD(int a, int b) {
		// TODO Auto-generated method stub
		while(b>0){
			int temp = b;
			b = a %b;
			a = temp;
		}
		return a;
	}

}
/*
3 3
1 2 2 4
0 1 1 1
2 0 4 8

3 3
1 1 2 4
0 1 1 1
2 0 4 8
*/
