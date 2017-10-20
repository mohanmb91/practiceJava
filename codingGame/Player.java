package codingGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Send your busters out into the fog to trap ghosts and bring them home!
 **/import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class XY {
	final int x;
    final int y;
    

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof XY)) {
            return false;
        }

        XY coord = (XY) o;

        return  coord.x == x && coord.y == y;
    }

    @Override
    public int hashCode() {
    	int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}

 class Node{
	 int boardState[][];
	 HashMap<Integer,XY> playersCurrentLocations = new HashMap<>();
	 int value;
	 List<Node> childrens;
	 public Node(int[][] board, HashMap<Integer, XY> playerLocations,int value){
		 this.boardState = board;
		 this.value = value;
		 this.playersCurrentLocations = playerLocations; 
		 this.childrens = new ArrayList<Node>();
	 }
	 public HashMap<Integer, XY> getPlayersCurrentLocations() {
			return playersCurrentLocations;
		}
		public void setPlayersCurrentLocations(HashMap<Integer, XY> playersCurrentLocations) {
			this.playersCurrentLocations = playersCurrentLocations;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	public int[][] getBoardState() {
		return boardState;
	}
	public void setBoardState(int[][] boardState) {
		this.boardState = boardState;
	}
	public List<Node> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Node> childrens) {
		this.childrens = childrens;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Node)) return false;

	        Node that = (Node) o;

	        return Arrays.deepEquals(getBoardState(), that.getBoardState());
	    }
	    
	    @Override
	    public int hashCode() {
	    	return Arrays.deepHashCode(getBoardState());
	    }
	
    }
 
 
     
class Player {
	static Node rootNode = null;
	static int rows = 20;
	static int columns = 30;
	static int P;
	static HashMap<Integer,List<XY>> playersLocationsTrack = new HashMap<>();
	static int board[][] = new int[20][30];
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            P = in.nextInt(); // your player number (0 to 3).
            System.err.println(P + " <== Player Index");
            
            String currentMove = "";
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                if(X0 != -1){
                	board[Y1][X1] = i +1; 
                	if(!playersLocationsTrack.containsKey(i)){
                    	List<XY> playersMoves = new ArrayList<>();
                    	playersMoves.add(new XY(Y1, X1));
                    	playersLocationsTrack.put(i, playersMoves);
                    }else{
                    	List<XY> playersMoves = playersLocationsTrack.get(i);
                    	playersMoves.add(new XY(Y1, X1));
                    	playersLocationsTrack.put(i, playersMoves);
                    }
                }else{
                	removePlayer(board,playersLocationsTrack.get(i));
                	playersLocationsTrack.remove(i);
                }
            }
            HashMap<Integer, XY> playersCurrentLocation = new HashMap<>();
            for(Integer eachKey: playersLocationsTrack.keySet()){
            	List<XY> playersMoves = playersLocationsTrack.get(eachKey);
            	playersCurrentLocation.put(eachKey, playersMoves.get(playersMoves.size() -1) );
            }
            Node start = new Node(board,playersCurrentLocation,0);
            Node bestMove = getBestMove(start, 1, true);
            int rowInitial = start.getPlayersCurrentLocations().get(0).getX();
            int columnInitial = start.getPlayersCurrentLocations().get(0).getY();
            int row = bestMove.getPlayersCurrentLocations().get(0).getX();
            int column = bestMove.getPlayersCurrentLocations().get(0).getY();
            currentMove = getMove(rowInitial,columnInitial,row,column);
            System.err.println(currentMove);
            System.out.println(currentMove); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
    
    private static String getMove(int rowInitial, int columnInitial, int row, int column) {
		if(row < rowInitial ){
			return "UP";
		}
		else if(row > rowInitial ){
			return "DOWN";
		}
		else if(column < columnInitial ){
			return "LEFT";
		}
		else if (column > columnInitial ){
			return "RIGHT";
		}
		else{
			return "";
		}
		
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node getBestMove(Node root, Integer depth, Boolean max) {
    	Node bestValue;
        if (depth == 0) {
        	 int value =evaluvateState(root); 
        	 root.setValue(value);
	         return root; // return a number
        }
        if (max) {
            bestValue = new Node(null, null, Integer.MIN_VALUE);
            List<Node> childrens = getPossibleChildrens(root);
            root.setChildrens(childrens);
            for (Node eachNode: root.getChildrens()) {
                Node value = getBestMove(eachNode, depth - 1, false);
                eachNode.setValue(value.getValue());
                bestValue = compareNodesMax(bestValue, eachNode);
            }
            return bestValue;
        } else {
        	bestValue = new Node(null, null, Integer.MAX_VALUE);
        	List<Node> childrens = getPossibleChildrens(root);
            root.setChildrens(childrens);
        	 for (Node eachNode: root.getChildrens()) {
        		 Node value = getBestMove(eachNode, depth - 1, true);
                bestValue = compareNodesMin(bestValue, value);
            }
            return bestValue;
        }
       
    }
    public static int[][] deepCopyIntMatrix(int[][] input) {
	    if (input == null)
	        return null;
	    int[][] result = new int[input.length][];
	    for (int r = 0; r < input.length; r++) {
	        result[r] = input[r].clone();
	    }
	    return result;
	}
    private static int evaluvateState(Node source) {
    	
    	Queue<String> frontier = new LinkedList<>();
		int playerCountCellCount,otherPlayersCellCount,wall = 9;
		playerCountCellCount = otherPlayersCellCount = 0;
		int [][] currentBoardState = deepCopyIntMatrix(source.getBoardState());
		HashMap<String, Integer> cellWithParents = new HashMap<>();
    	
    	for(Integer eachPlayerLocation : source.getPlayersCurrentLocations().keySet()){
    		String rowColumn = source.getPlayersCurrentLocations().get(eachPlayerLocation).getX()
					+ "+" + source.getPlayersCurrentLocations().get(eachPlayerLocation).getY();
    		if(! cellWithParents.containsKey(eachPlayerLocation)){
    			cellWithParents.put(rowColumn, eachPlayerLocation + 1);
    		}
    		frontier.add(rowColumn);
    	}
    	
    	while(! frontier.isEmpty()){
    		String key = frontier.poll();
    		String rowColumn[] = key.split("\\+"); 
    		int x = Integer.parseInt(rowColumn[0]);
    		int y = Integer.parseInt(rowColumn[1]);
    		
    		if(x + 1 < rows && (currentBoardState[x + 1][y] == 0 || currentBoardState[x + 1][y] > 4 && currentBoardState[x + 1][y] <= 20)){
    			String newKey = (x+1) + "+" + y;
    			if(currentBoardState[x + 1][y] == 0){
    			cellWithParents.put(newKey, cellWithParents.get(key));
    			currentBoardState[x+1][y] = cellWithParents.get(key) + 4;
    			if(P + 1 + 4 == currentBoardState[x+1][y]){
    				playerCountCellCount += 1;
    			}else{
    				otherPlayersCellCount += 1;
    			}
    			frontier.add(newKey);
    			}else{
    				if(cellWithParents.get(newKey) != cellWithParents.get(key)){
    					if(currentBoardState[x + 1][y] > 4 && currentBoardState[x + 1][y] != wall){
    						if(P + 1 + 4 == currentBoardState[x + 1][y]){
    		    				playerCountCellCount -= 1;
    		    			}else{
    		    				otherPlayersCellCount -= 1;
    		    			}
	    				currentBoardState[x + 1][y] = wall;
    					}
	    			}
    			}
    		}
    		if(x - 1 >= 0 && (currentBoardState[x - 1][y] == 0 || currentBoardState[x - 1][y] > 4 && currentBoardState[x - 1][y] <= 20)){
    			String newKey = (x-1) + "+" + y;
    			if(currentBoardState[x - 1][y] == 0){
    			cellWithParents.put(newKey, cellWithParents.get(key));
    			currentBoardState[x-1][y] = cellWithParents.get(key) + 4;
    			if(P + 1 + 4 == currentBoardState[x-1][y]){
    				playerCountCellCount += 1;
    			}else{
    				otherPlayersCellCount += 1;
    			}
    			frontier.add(newKey);
    			}else{
    				if(cellWithParents.get(newKey) != cellWithParents.get(key)){
    					if(currentBoardState[x - 1][y] > 4 && currentBoardState[x - 1][y] != wall){
    						if(P + 1 + 4 == currentBoardState[x-1][y]){
    		    				playerCountCellCount -= 1;
    		    			}else{
    		    				otherPlayersCellCount -= 1;
    		    			}
	    				currentBoardState[x - 1][y] = wall;
    					}
	    			}
    			}
    		}
    		if(y + 1 < columns && (currentBoardState[x][y + 1] == 0 || currentBoardState[x][y + 1] > 4 && currentBoardState[x][y + 1] <= 20)){
    			String newKey = x + "+" + (y + 1);
    			if(currentBoardState[x][y+1] == 0){
    			cellWithParents.put(newKey, cellWithParents.get(key));
    			currentBoardState[x][y+1] = cellWithParents.get(key) + 4;
    			if(P + 1 + 4 == currentBoardState[x][y + 1]){
    				playerCountCellCount += 1;
    			}else{
    				otherPlayersCellCount += 1;
    			}
    			frontier.add(newKey);
    			}else{
    				if(cellWithParents.get(newKey) != cellWithParents.get(key)){
    					if(currentBoardState[x][y + 1] > 4  && currentBoardState[x][y + 1] != wall){
    						if(P + 1 + 4 == currentBoardState[x][y + 1]){
    		    				playerCountCellCount -= 1;
    		    			}else{
    		    				otherPlayersCellCount -= 1;
    		    			}
	    				currentBoardState[x][y + 1] = wall;
    					}
	    			}
    			}
    		}
    		if(y - 1 >= 0 && (currentBoardState[x][y - 1] == 0 || currentBoardState[x][y - 1] > 4 && currentBoardState[x][y - 1] <= 20)){
    			String newKey = x + "+" + (y - 1);
    			if(currentBoardState[x][y-1] == 0){
    			cellWithParents.put(newKey, cellWithParents.get(key));
    			currentBoardState[x][y-1] = cellWithParents.get(key) + 4;
    			if(P + 1 + 4 == currentBoardState[x][y - 1]){
    				playerCountCellCount += 1;
    			}else{
    				otherPlayersCellCount += 1;
    			}
    			frontier.add(newKey);
    			}else{
    				if(cellWithParents.get(newKey) != cellWithParents.get(key)){
    					if(currentBoardState[x][y-1] > 4  && currentBoardState[x][y - 1] != wall){
    						if(P + 1 + 4 == currentBoardState[x][y - 1]){
    		    				playerCountCellCount -= 1;
    		    			}else{
    		    				otherPlayersCellCount -= 1;
    		    			}
	    				currentBoardState[x][y-1] = wall;
    					}
	    			}
    			}
    		}
    	
    	}
    	//debugBoard(currentBoardState);
    	return playerCountCellCount - otherPlayersCellCount; 
	}
 
    private static void debugBoard(int[][] Board){
        for(int i=0; i < 20;i ++){
           for(int j=0; j < 30;j ++){
               System.err.print(Board[i][j]+ " ");
               }
               System.err.println();
           }
       }
	private static List<Node> getPossibleChildrens(Node root) {
		TreeMap<String, String> possibleMoves = generatePossibleMove(root);
		List<Node> childrens = getPossibleStates(possibleMoves, root);
		return childrens;
	}
	private static List<Node> getPossibleStates(TreeMap<String, String> possibleMoves, Node start) {
		List<Node> childrens = new ArrayList<>();
		for(Map.Entry<String, String> entry1 :  possibleMoves.entrySet()){
        	String playerMoves[]  = entry1.getValue().split("#");
        	int boardCopy[][] = deepCopyIntMatrix(start.getBoardState());
        	HashMap<Integer, XY> playerCurrentLocations = new HashMap<>();
        	for(int i = 0; i < playerMoves.length ; i++ ){
        		int x = Integer.parseInt(playerMoves[i].split("\\+")[0]);
        		int y = Integer.parseInt(playerMoves[i].split("\\+")[1]);
        		boardCopy[x][y] = i + 1;
        		playerCurrentLocations.put(i, new XY(x,y));
        	}
        	Node child = new Node(boardCopy, playerCurrentLocations, 0);
        	childrens.add(child);
        }
		return childrens;
	}
	private static TreeMap<String, String> generatePossibleMove(Node start) {
		// TODO Auto-generated method stub
		TreeMap<String, String> possibleMoves = new TreeMap<String,String>();
		TreeMap<String, String> otherPossibleMoves = new TreeMap<String,String>();
		HashMap<Integer, XY> playerCurrentLocations = start.getPlayersCurrentLocations();
		int x = playerCurrentLocations.get(P).getX();
    	int y = playerCurrentLocations.get(P).getY();
		possibleMoves = getPossibleMovesTreeMap(start.getBoardState(), x +"+"+ y );
        for(Integer eachPlayer : playerCurrentLocations.keySet()){
        	if(eachPlayer != P){
        		x = playerCurrentLocations.get(eachPlayer).getX();
            	y = playerCurrentLocations.get(eachPlayer).getY();
        		otherPossibleMoves= getPossibleMovesTreeMap(start.getBoardState(),x +"+"+ y);
        		if(otherPossibleMoves.size()> 0){
        			possibleMoves = findPossibleCombinations(possibleMoves,otherPossibleMoves);
        		}
        	}
        }
		return possibleMoves;
	}
	private static TreeMap<String, String> findPossibleCombinations(TreeMap<String, String> possibleMoves1,
			TreeMap<String, String> possibleMoves2) {
    	TreeMap<String,String> result = new TreeMap<String, String>();
    	for(Map.Entry<String, String> entry1 : possibleMoves1.entrySet()){
    		for(Map.Entry<String, String> entry2 : possibleMoves2.entrySet()){
    		String key = entry1.getKey() + "#"+entry2.getKey();
    		String value = entry1.getValue() + "#" + entry2.getValue();
    		result.put(key, value);
        	}
    	}
    	return result;
	}
	private static TreeMap<String,String> getPossibleMovesTreeMap(int[][] board, String currentXY) {
        TreeMap<String,String> possibleMoves = new TreeMap<String, String>();
    	String XY[] = currentXY.split("\\+");
    	int row = Integer.parseInt(XY[0]);
    	int column = Integer.parseInt(XY[1]);
    	
    	if(row + 1 < rows && board[row +1][column] < 1){
    		possibleMoves.put("DOWN",(row+1)+"+"+column);
		}
		if(row -1 >= 0 && board[row  - 1][column] < 1){
			possibleMoves.put("UP",(row-1)+"+"+column);
		}
		if(column + 1 < columns && board[row][column + 1] < 1){
			possibleMoves.put("RIGHT",row+"+"+(column+1));
		}
		if(column - 1 >= 0 && board[row][column - 1] < 1){
			possibleMoves.put("LEFT",row+"+"+(column-1));
		}
    	return possibleMoves;
    }
	private static Node compareNodesMin(Node bestValue, Node newNode) {
		if(bestValue.getValue() < newNode.getValue()){
			return bestValue;
		}
		return newNode;
	}

	private static Node compareNodesMax(Node bestValue, Node newNode) {
		if( bestValue.getValue() > newNode.getValue()){
			return bestValue;
		}
		return newNode;
	}
	private static void removePlayer(int[][] board, List<XY> locations) {
		for(XY eachXY: locations){
			board[eachXY.getX()][eachXY.getY()] = 0;
		}
		
	}
}