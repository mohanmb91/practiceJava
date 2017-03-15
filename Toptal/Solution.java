package Toptal;
import java.util.*;

class Tile{
    int x,y;
    int distance;
    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = 0;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getDistance(){
        return this.distance;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public void setY(int y){
        this.y = y;
    }
    @Override
    public int hashCode(){
        int result = getX();
        result = result  * 31 +  getY();
        return result;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){ return true; }
        if(!(o instanceof Tile)){ return false;}
        Tile that = (Tile) o;
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
class Solution {
    public int solution(int A, int B) {
    	 int distance = kinghtL(2,1,new Tile(0,0),new Tile(A,B));
    	 if(distance > 100000000){
    		 return -2;
    	 }
    	 return distance;
    }
     public static int kinghtL(int a,int b,Tile start,Tile destination){
        Queue<Tile> frontier = new LinkedList<Tile>();
        List<Tile> exploredSquares = new ArrayList<Tile>();
        HashMap<Tile , Tile> parents = new HashMap<Tile,Tile>(); 
        boolean isNotReachable = false;
        frontier.add(start);
        parents.put(start, null);
        while(!frontier.isEmpty()){
        	Tile current = frontier.poll();
        	if(current.getDistance() == Integer.MAX_VALUE){
        		return -1;
        	}
        	exploredSquares.add(current);
        	for(Tile eachpossibleMove : getPossibleMovesFrom(a,b,current) ){
        		if(!exploredSquares.contains(eachpossibleMove)){
        			int neibhourWeight = 1;
    				int currentNodeWeight = current.getDistance();
    				int  combinedWeight = neibhourWeight + currentNodeWeight;
    				eachpossibleMove.setDistance(combinedWeight);
    				if(!frontier.contains(eachpossibleMove)){
    					frontier.add(eachpossibleMove);
    					parents.put(eachpossibleMove, current);
    				}else{
    					if(combinedWeight < eachpossibleMove.getDistance()){
    						frontier.remove(eachpossibleMove);
    						eachpossibleMove.setDistance(combinedWeight);
    						frontier.add(eachpossibleMove);	
    						parents.put(eachpossibleMove, current);
    					}
    				}
    				if(eachpossibleMove.equals(destination)){
    					return eachpossibleMove.distance;
    				}
    				
        		}
        	}
        }
        return -1;
    }
    public static List<Tile> getPossibleMovesFrom(int a, int b, Tile current){
    	List<Tile> possibleMoves = new ArrayList<Tile>();
    	int x = current.getX();
    	int y = current.getY();
    	if(isInRange(x+a,y+b)){
    		possibleMoves.add(new Tile(x+a,y+b));
    	}
    	if(isInRange(x+a,y-b)){
    		possibleMoves.add(new Tile(x+a,y-b));
    	}
    	if(isInRange(x-a,y+b)){
    		possibleMoves.add(new Tile(x-a,y+b));
    	}
    	if(isInRange(x-a,y-b)){
    		possibleMoves.add(new Tile(x-a,y-b));
    	}
    	
    	if(isInRange(x+b,y+a)){
    		possibleMoves.add(new Tile(x+b,y+a));
    	}
    	if(isInRange(x+b,y-a)){
    		possibleMoves.add(new Tile(x+b,y-a));
    	}
    	if(isInRange(x-b,y+a)){
    		possibleMoves.add(new Tile(x-b,y+a));
    	}
    	if(isInRange(x-b,y-a)){
    		possibleMoves.add(new Tile(x-b,y-a));
    	}
    	
    	
    	return possibleMoves;
    }
    public static boolean isInRange(int newX, int newY){
    	if(newX >=0 && newY >= 0){
    		return true;
    	}
    	return false;
    }
}