package RookieRank2;
import java.util.*;

class Tile{
    int x,y,distance;
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

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Integer> maps = new HashMap<String,Integer>();
        int n = in.nextInt();
        for(int i=1 ; i < n; i ++){
            for(int j=1; j < n; j++){
            	if(maps.get(i+"+"+j) == null){
            		int result = kinghtL(i,j,new Tile(0,0), n);
            		if(j == n-1){
            			System.out.print(result);
            		}else{
            			System.out.print(result+" ");
            		}
                    maps.put(j+"+"+i, result);
            	}else{
            		System.out.print(maps.get(i+"+"+j)+" ");
            	}
            }
            System.out.println();
        }
    }
    public static int kinghtL(int a,int b,Tile start, int boardSize){
        Queue<Tile> frontier = new LinkedList<Tile>();
        List<Tile> exploredSquares = new ArrayList<Tile>();
        HashMap<Tile , Tile> parents = new HashMap<Tile,Tile>(); 
        frontier.add(start);
        parents.put(start, null);
        while(!frontier.isEmpty()){
        	Tile current = frontier.poll();
        	exploredSquares.add(current);
        	for(Tile eachpossibleMove : getPossibleMovesFrom(a,b,current,boardSize) ){
        		if(!exploredSquares.contains(eachpossibleMove)){
        			int neibhourWeight = 1;
    				int currentNodeWeight = current.getDistance();
    				int combinedWeight = neibhourWeight + currentNodeWeight;
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
        		}
        	}
        }
        Tile destination = new Tile(boardSize - 1, boardSize -1); 
        if(parents.containsKey(destination)){
        	int count = 0;
        	while(parents.get(destination) != null ){
        		destination = parents.get(destination);
        		count += 1;
        	}
        	return count;
        }else{
        	return -1;
        }
    }
    public static List<Tile> getPossibleMovesFrom(int a, int b, Tile current,int n){
    	List<Tile> possibleMoves = new ArrayList<Tile>();
    	int x = current.getX();
    	int y = current.getY();
    	if(isInRange(x+a,y+b,n)){
    		possibleMoves.add(new Tile(x+a,y+b));
    	}
    	if(isInRange(x+a,y-b,n)){
    		possibleMoves.add(new Tile(x+a,y-b));
    	}
    	if(isInRange(x-a,y+b,n)){
    		possibleMoves.add(new Tile(x-a,y+b));
    	}
    	if(isInRange(x-a,y-b,n)){
    		possibleMoves.add(new Tile(x-a,y-b));
    	}
    	
    	if(isInRange(x+b,y+a,n)){
    		possibleMoves.add(new Tile(x+b,y+a));
    	}
    	if(isInRange(x+b,y-a,n)){
    		possibleMoves.add(new Tile(x+b,y-a));
    	}
    	if(isInRange(x-b,y+a,n)){
    		possibleMoves.add(new Tile(x-b,y+a));
    	}
    	if(isInRange(x-b,y-a,n)){
    		possibleMoves.add(new Tile(x-b,y-a));
    	}
    	
    	
    	return possibleMoves;
    }
    public static boolean isInRange(int newX, int newY, int n){
    	if((newX >=0 && newX < n) && (newY >= 0 && newY < n)) {
    		return true;
    	}
    	return false;
    }
}
