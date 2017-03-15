package WeekOfCode29;
import java.math.*;
import java.util.*;
class Point{
	double x;
	double y;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Point(){}
	public Point(double x,double y){
		this.x = x;this.y = y;
	}
	@Override
	public boolean equals(Object o){
		if(o == null){return false;}
		if (!(o instanceof Point)) {return false;}
		Point that = (Point) o;
		return this.x == that.x && this.y == that.y;
	}
	@Override
	public int hashCode(){
		int result = Double.valueOf(this.getX()).hashCode();
		result += 31.0 * Double.valueOf(this.getY()).hashCode();
		return result;
	}
}
public class Solution3 {
	public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        double w = Double.parseDouble(in.next());
		        double h = Double.parseDouble(in.next());
		        Point circleCenter = new Point( Double.parseDouble(in.next()) , Double.parseDouble(in.next()) );
		        double r =  Double.parseDouble(in.next());
		        HashSet<Point> circlePoints = getCirclePoints(circleCenter,w,h,r);
		        Point A = new Point( Double.parseDouble(in.next()) , Double.parseDouble(in.next()) );
		        Point C = new Point( Double.parseDouble(in.next()) , Double.parseDouble(in.next()) );
		        HashSet<Point> squarePoints = getSquarePoints(A,C,w,h);
		        for(int i=0;i<h;i++){
		        	for(int j=0;j<w;j++){
		        		if(squarePoints.contains(new Point(j,i)) || circlePoints.contains(new Point(j,i)) ){
		        			System.out.print("#");
		        		}else{
		        			System.out.print(".");
		        		}
		        	}
		        	System.out.println();
		        }
	}

	private static HashSet<Point> getSquarePoints(Point a, Point c, double w, double h) {
		List<Point> otherPoints = getTwoVertexOfSquare(a,c);
		Point b = otherPoints.get(0);
		Point d = otherPoints.get(1);
		Point squareCenter = midPoint(a, c);
		HashSet<Point> validPoints = new HashSet<Point>();
		Queue<Point> frontier = new LinkedList<>();
		frontier.add(squareCenter);
		HashSet<Point> exploredSet = new HashSet<Point>();
		validPoints.add(squareCenter);
		while(!frontier.isEmpty()){
			Point current = frontier.poll();
			exploredSet.add(current);
			for(Point eachNeibhour: getNeibhors(current,w,h)){
				boolean isInside = isPointInsideSquare(a,b,c,d, eachNeibhour);
				if(!exploredSet.contains(eachNeibhour) && isInside){
					validPoints.add(eachNeibhour);
					frontier.add(eachNeibhour);
				}
			}
		}
		return validPoints;
	}
	private static boolean isPointInsideSquare(Point a, Point b, Point c, Point d, Point eachNeibhour) {
		double squareSide = distanceBetweenTwoPoints(a, b);double squareArea = squareSide * squareSide;
		String decimal = (String.valueOf(squareArea)).split("\\.")[1];
		String whole = String.valueOf(squareArea).split("\\.")[0];
		squareArea = Double.valueOf(whole+"."+(decimal.length() <= 4 ? decimal : decimal.substring(0,4)));
		double aBPArea =  findArea(distanceBetweenTwoPoints(eachNeibhour ,a),distanceBetweenTwoPoints(eachNeibhour ,b),distanceBetweenTwoPoints(a ,b));
		double aDPArea =  findArea(distanceBetweenTwoPoints(eachNeibhour ,a),distanceBetweenTwoPoints(eachNeibhour ,d),distanceBetweenTwoPoints(a ,d));
		double cDPArea =  findArea(distanceBetweenTwoPoints(eachNeibhour ,c),distanceBetweenTwoPoints(eachNeibhour ,d),distanceBetweenTwoPoints(c ,d));
		double cBPArea =  findArea(distanceBetweenTwoPoints(eachNeibhour ,c),distanceBetweenTwoPoints(eachNeibhour ,b),distanceBetweenTwoPoints(c ,b));
		double totalArea = aBPArea + aDPArea + cBPArea + cDPArea;
		decimal = String.valueOf(totalArea).split("\\.")[1];
		whole = String.valueOf(totalArea).split("\\.")[0];
		totalArea = Double.valueOf(whole+"."+(decimal.length() <= 4 ? decimal : decimal.substring(0,4)));
		if(totalArea == squareArea){return true;}
		return false;
	}
	 public static double findArea(double sideA, double sideB, double sideC)
	    { 
		 	double area; double s;
	        s = 1/2.0 * (sideA + sideB + sideC);
	        area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	        if (Double.isNaN(area)) {
	        	area = 0.0;
        	}
	        return area;
	    }
	private static HashSet<Point> getCirclePoints(Point circleCenter, double w, double h, double r) {
		HashSet<Point> validPoints = new HashSet<Point>();
		
		Queue<Point> frontier = new LinkedList<>();
		frontier.add(circleCenter);
		HashSet<Point> exploredSet = new HashSet<Point>();
		validPoints.add(circleCenter);
		while(!frontier.isEmpty()){
			Point current = frontier.poll();
			exploredSet.add(current);
			for(Point eachNeibhour: getNeibhors(current,w,h)){
				double distance = distanceBetweenTwoPoints(circleCenter, eachNeibhour);
				if(!exploredSet.contains(eachNeibhour) && distance <= r ){
					validPoints.add(eachNeibhour);
					frontier.add(eachNeibhour);
				}
			}
		}
		return validPoints;
	}
	public static List<Point> getNeibhors(Point current, double w, double h) {
		double x = current.getX();
		double y = current.getY();
		List<Point> neibhors = new ArrayList<>();
		if(x+1.0 < w){
			neibhors.add(new Point(x+1.0,y));
		}
		if(x- 1.0 >= 0.0){
			neibhors.add(new Point(x-1.0,y));
		}
		if(y+1.0 < h){
			neibhors.add(new Point(x,y+1.0));
		}
		if(y-1.0 >= 0.0){
			neibhors.add(new Point(x,y-1.0));
		}
		return neibhors;
	}
	public static List<Point> getTwoVertexOfSquare(Point p1, Point p2){
		double x1,x2,y1,y2,xc,yc,yd,xd,x3,y3,x4,y4;
		  x1 = p1.x  ; y1 = p1.y ;    // First diagonal point
		  x2 = p2.x  ; y2 = p2.y ;    // Second diagonal point

		  xc = (x1 + x2)/2  ;  yc = (y1 + y2)/2  ;    // Center point
		  xd = (x1 - x2)/2  ;  yd = (y1 - y2)/2  ;    // Half-diagonal

		  x3 = xc - yd  ;  y3 = yc + xd;    // Third corner
		  x4 = xc + yd  ;  y4 = yc - xd;    // Fourth corner
		  List<Point> results = new ArrayList<>();
		  results.add(new Point(x3,y3));
		  results.add(new Point(x4,y4));
		  return results;
	}
	public static Point midPoint(Point p1,Point p2){
		Point result = new Point();
		result.setX((p1.x + p2.x)/2.0);
		result.setY((p1.y + p2.y)/2.0);
		return result;
	}
	public static double distanceBetweenTwoPoints(Point p1,Point p2){
		double distance = 0.0;
		distance = Math.sqrt(( (p1.y - p2.y)*(p1.y - p2.y) ) + ((p1.x - p2.x)*(p1.x - p2.x)) ) ;
		return distance;
	}
}
