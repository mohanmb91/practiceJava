package LinkedList;

import java.util.*;
class Point{
	int x,y;
	double dist;
	public Point(int x, int y, Point origin){
		this.x = x;
		this.y = y;
		this.dist = Math.hypot(x - origin.x, y - origin.y);
	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
		this.dist = 0.0;
	}
}
public class ClosestPoints {
	
	public static void main(String args[]){
		Collection<Point> points = new ArrayList<Point>();
		Point origin = new Point(0,0);
		points.add(new Point(1, 1, origin));
	    points.add(new Point(1, 3, origin));
	    points.add(new Point(-1, 1, origin));
	    points.add(new Point(-1, 3, origin));
	    points.add(new Point(1, -1, origin));
	    points.add(new Point(3, -1, origin));
	    points.add(new Point(-1, -1, origin));
	    points.add(new Point(-1, 3, origin));
	    points.add(new Point(2, 2, origin));
	    int k = 9;
	    double minDistance = Double.MAX_VALUE;
	    for(int i =0; i < k; i ++){
	    	Point firstClosePoint = null;
	    for(Point eachPoint : points){
	    	if(eachPoint.dist < minDistance){
	    		minDistance = eachPoint.dist;
	    		firstClosePoint = eachPoint;
	    	}
	    }
	    System.out.println(firstClosePoint.x + "----" + firstClosePoint.y);
	    points.remove(firstClosePoint);
	    minDistance = Double.MAX_VALUE;
	    }
	}
	
}
