package codingGame;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
enum MOVE{
	LEFT,UP,RIGHT,DOWN,NONE
}
class MoveValue{
	MOVE move;
	int value;
	public MOVE getMove() {
		return move;
	}
	public void setMove(MOVE move) {
		this.move = move;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public MoveValue() {}
	public MoveValue(MOVE move,int value) {
		this.move = move;
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		result = prime * result + value;
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
		MoveValue other = (MoveValue) obj;
		if (move != other.move)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
}
class Tile {
	final int x;
    final int y;
    

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public Tile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Tile other = (Tile) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
    
}
class Player1 {
	private static final int rows = 20;
	private static final int columns = 30;
	static int Board[][] = new int[20][30];
	static int playerCellCount =0, otherPlayersCellCount =0;
	static int P,N;
	static HashMap<Integer,Tile> PlayerCurrentHead = new HashMap<Integer,Tile>();
	static HashMap<Integer, List<Tile>> playerTraces = new HashMap<Integer, List<Tile>>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        chageToNegativeIndex(Board);
        // game loop
        while (true) {
            N = in.nextInt(); // total number of players (2 to 4).
            P = in.nextInt(); // your player number (0 to 3).
            MoveValue finalResult = new MoveValue(MOVE.NONE, 1111);
            for (int i = 0; i < N; i++) {
            	int columnTail = in.nextInt(); // starting X coordinate of lightcycle (or -1)
            	if(columnTail != -1){
	                int rowTail = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
	                int columnHead = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
	                int rowHead = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
	                
	                //tracking Players currentHead
	            	PlayerCurrentHead.put(i,new Tile(rowHead,columnHead));
	            	
	                // Add the Tron traces
	                List<Tile> tiles = new ArrayList<Tile>();
	                if(playerTraces.containsKey(i)){
	                	
	                	tiles = playerTraces.get(i);
	                	tiles.add(new Tile(rowHead,columnHead));
	                }else{
	                	tiles.add(new Tile(rowHead,columnHead));
	                }
	            	playerTraces.put(i, tiles);
	            	Board[rowTail][columnTail] = i;
	            	Board[rowHead][columnHead] = i;
            	}else{
            		// removing traces after player is dead
            		if(playerTraces.containsKey(i)){
            			removeTracesForPlayer(i);
            			playerTraces.remove(i);
            			PlayerCurrentHead.remove(i);
            		}
            	}
            }
            HashMap<Integer,Tile> headCopy = (HashMap<Integer, Tile>) PlayerCurrentHead.clone();
            finalResult = miniMax(Board, P, 10,headCopy);
            if(finalResult.getMove() != MOVE.NONE){
                System.out.println(finalResult.getMove().name());	
            }else{
            	TreeMap<MOVE,Tile> possibility =  getPossibleMoves(Board,P);
            	System.out.println(possibility.firstEntry().getKey().name());
            }
        }
        
    }
	private static void removeTracesForPlayer(int i) {
		List<Tile>tiles = playerTraces.get(i);
		for(Tile eachTile: tiles){
			Board[eachTile.x][eachTile.y] = -1;
		}
	}
	private static MoveValue miniMax(int[][] board, int currentPlayer, int depth, HashMap<Integer, Tile> headCopy) {
		
		if(depth == 0){
			return evaluation(board,headCopy,currentPlayer);
		}
		TreeMap<MOVE,Tile> moves = getPossibleMoves(board,currentPlayer);
		if(currentPlayer == P){// Maximizer
			MoveValue maxValue = new MoveValue(MOVE.NONE, Integer.MIN_VALUE);
			if(moves.size() == 0){
				maxValue = miniMax(board,(currentPlayer+1 >= N)? 0 : currentPlayer+1,depth-1,headCopy);
			}else{
				for(Entry<MOVE,Tile> eachMove: moves.entrySet()){
					int tempBoard[][] = deepCopy(board);
					MOVE madeMove =  eachMove.getKey();
					Tile tempTile = eachMove.getValue();
					tempBoard[tempTile.x][tempTile.y] = currentPlayer;
					if(headCopy.containsKey(currentPlayer)){
						headCopy.put(currentPlayer, new Tile(tempTile.getX(),tempTile.getY()));
					}
					MoveValue tempMove = miniMax(tempBoard,(currentPlayer+1 >= N)? 0 : currentPlayer+1,depth-1,headCopy);
					if(tempMove.getValue() > maxValue.getValue()){
						maxValue.setMove(madeMove);
						maxValue.setValue(tempMove.getValue());
					}
				}
			}
			return maxValue;
		}else{// Minimizer
			MoveValue minValue = new MoveValue(MOVE.NONE, Integer.MAX_VALUE);
			if(moves.size() == 0){
				minValue = miniMax(board,(currentPlayer+1 >= N)? 0 : currentPlayer+1,depth-1,headCopy);
			}else{
				for(Entry<MOVE,Tile> eachMove: moves.entrySet()){
					int tempBoard[][] = deepCopy(board);
					MOVE madeMove =  eachMove.getKey();
					Tile tempTile = eachMove.getValue();
					tempBoard[tempTile.x][tempTile.y] = currentPlayer;
					if(headCopy.containsKey(currentPlayer)){
						headCopy.put(currentPlayer, new Tile(tempTile.getX(),tempTile.getY()));
					}
					MoveValue tempMove = miniMax(tempBoard,(currentPlayer+1 >= N)? 0 : currentPlayer+1,depth-1,headCopy);
					if(tempMove.getValue() < minValue.getValue()){
						minValue.setMove(madeMove);
						minValue.setValue(tempMove.getValue());
					}
				}
			}
			return minValue;
		}
	}
	
	private static MoveValue evaluation(int[][] board,  HashMap<Integer, Tile> headCopy, int currentPlayer) {
		Queue<Tile> frontier = new LinkedList<>();
		
		while(headCopy.size() > 0){
			if(headCopy.containsKey(currentPlayer)){
				frontier.add(headCopy.get(currentPlayer));
				headCopy.remove(currentPlayer);	
			}
			currentPlayer = (currentPlayer+1 >= N)? 0 : currentPlayer+1;
		}
		int[][] boardCopy = deepCopy(board);
		debugBoard(boardCopy);
		playerCellCount =0; otherPlayersCellCount =0;
		while(!frontier.isEmpty()){
			Tile currentTile = frontier.poll();
			int x=currentTile.getX(),y=currentTile.getY(),newX,newY;
			newX = x;
			newY = y -1;
			if(newY >= 0){
				if(boardCopy[newX][newY] < 0){
					boardCopy[newX][newY] = boardCopy[x][y];
					if(boardCopy[newX][newY] == P){
						playerCellCount += 1;
					}else{
						otherPlayersCellCount += 1;
					}
					frontier.add(new Tile(newX,newY));
				}else if(board[newX][newY] < 0 && boardCopy[newX][newY] != boardCopy[x][y]){
					if(boardCopy[x][y] == P){
						playerCellCount -= 1;
					}else{
						otherPlayersCellCount -= 1;
					}
				}
			}
			newX = x + 1;
			newY = y;
			if(newX < rows){
				if(boardCopy[newX][newY] < 0){
					boardCopy[newX][newY] = boardCopy[x][y];
					if(boardCopy[newX][newY] == P){
						playerCellCount += 1;
					}else{
						otherPlayersCellCount += 1;
					}
					frontier.add(new Tile(newX,newY));
				}else if(board[newX][newY] < 0 && boardCopy[newX][newY] != boardCopy[x][y]){
					if(boardCopy[x][y] == P){
						playerCellCount -= 1;
					}else{
						otherPlayersCellCount -= 1;
					}
				}
			}
			newX = x;
			newY = y + 1;
			if(newY < columns){
				if(boardCopy[newX][newY] < 0){
					boardCopy[newX][newY] = boardCopy[x][y];
					if(boardCopy[newX][newY] == P){
						playerCellCount += 1;
					}else{
						otherPlayersCellCount += 1;
					}
					frontier.add(new Tile(newX,newY));
				}else if(board[newX][newY] < 0 && boardCopy[newX][newY] != boardCopy[x][y]){
					if(boardCopy[x][y] == P){
						playerCellCount -= 1;
					}else{
						otherPlayersCellCount -= 1;
					}
				}
			}
			newX = x - 1;
			newY = y;
			if(newX >= 0){
				if(boardCopy[newX][newY] < 0){
					boardCopy[newX][newY] = boardCopy[x][y];
					if(boardCopy[newX][newY] == P){
						playerCellCount += 1;
					}else{
						otherPlayersCellCount += 1;
					}
					frontier.add(new Tile(newX,newY));
				}else if(board[newX][newY] < 0 && boardCopy[newX][newY] != boardCopy[x][y]){
					if(boardCopy[x][y] == P){
						playerCellCount -= 1;
					}else{
						otherPlayersCellCount -= 1;
					}
				}
			}
			debugBoard(boardCopy);
			System.out.println("================================================================================");
		}
		return new MoveValue(MOVE.NONE,playerCellCount - otherPlayersCellCount);
	}
	private static TreeMap<MOVE,Tile> getPossibleMoves(int[][] board, int currentPlayer) {
		//System.err.println("currentPlayer"+currentPlayer);
		Tile playerCurrentHead = PlayerCurrentHead.get(currentPlayer);
		TreeMap<MOVE,Tile> possibleMoves = new TreeMap<MOVE, Tile>();
	    	
	    	int row = playerCurrentHead.x;
	    	int column = playerCurrentHead.y;
	    	if(column - 1 >= 0 && board[row][column - 1] < 0){
				possibleMoves.put(MOVE.LEFT,new Tile(row,column-1));
			}
	    	if(row + 1 < rows && board[row +1][column] < 0){
	    		possibleMoves.put(MOVE.DOWN,new Tile((row+1),column));
			}
	    	if(column + 1 < columns && board[row][column + 1] < 0){
				possibleMoves.put(MOVE.RIGHT,new Tile(row,column+1));
			}
	    	//System.err.println(board[row  - 1][column] + " ==>" + (row -1) + " == >" + column);
			if(row -1 >= 0 && board[row  - 1][column] < 0){
				possibleMoves.put(MOVE.UP,new Tile((row-1),column));
			}
			
			
	    	return possibleMoves;
	}
	private static void chageToNegativeIndex(int[][] board) {
		for(int i=0;i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				board[i][j] = -1;
			}
		}
		
	}
	 private static void debugBoard(int[][] Board){
	        for(int i=0; i < 20;i ++){
	           for(int j=0; j < 30;j ++){
	        	   if(Board[i][j] != -1){
	        		   System.err.print(" " + Board[i][j]+ "   ");   
	        	   }else{
	        		   System.err.print(Board[i][j]+ "   ");   
	        	   }
	               }
	               System.err.println();
	           }
	       }
	 public static int[][] deepCopy(int[][] input) {
		    if (input == null)
		        return null;
		    int[][] result = new int[input.length][];
		    for (int r = 0; r < input.length; r++) {
		        result[r] = input[r].clone();
		    }
		    return result;
		}
}
/*
2
1
15
15
15
15
10
10
10
10
*/