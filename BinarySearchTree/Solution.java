package BinarySearchTree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Tile{
    int row;
    int column;
    char type;    
    public Tile(int row, int column, char type){
        this.row = row;
        this.column = column;
        this.type = type;
    }
}

public class Solution {
static void nextMove(int n, int r, int c, String [] grid){
    Tile start = null;
    Tile destination = null;
    Tile[][] tiles = new Tile[n][n];
    for(int i =0; i < grid.length; i ++){
        String eachRow = grid[i];
        for(int j =0; j < eachRow.length(); j ++){
            char eachCellType = eachRow.charAt(j);
            tiles[i][j] = new Tile(i,j,eachCellType);
            if(eachCellType == 'm'){
                start = tiles[i][j];
            }
            if(eachCellType == 'p'){
                destination = tiles[i][j];
            }
        }
    }
    List<Tile> visitedTiles = new ArrayList<Tile>();
    Queue<Tile> frontier = new LinkedList<>();
    frontier.add(start);
    HashMap<Tile,Tile> parents = new HashMap<Tile,Tile>();
    parents.put(start,null);
    String result = "";
    boolean nodeFound = false;
    while(!frontier.isEmpty()){
        Tile currentTile = frontier.poll();
        visitedTiles.add(currentTile);
        for(Tile eachNeibhour: getNeibhours(currentTile,tiles)){
            if(!visitedTiles.contains(eachNeibhour)){
                parents.put(eachNeibhour,currentTile);
                
                //destination Reached
                if(eachNeibhour.type == 'p'){
                    nodeFound = true;
                    Tile current = eachNeibhour;
                    while(parents.get(parents.get(current)) != null ){
                        current = parents.get(current);
                    }
                    result = calculateDirection(start,current);
                    break;
                }else if(eachNeibhour.type == '-'){ // 
                    frontier.add(eachNeibhour);
                }
            }
        }
        if(nodeFound){
            break;
        }
    }
    System.out.println(result);
  }
    public static String calculateDirection(Tile start, Tile nextTile){
        if(nextTile.row > start.row){
            return "DOWN";
        }
        else if(nextTile.row < start.row){
            return "UP";
        }
        else if(nextTile.column > start.column){
            return "RIGHT";
        }
        else{
            return "LEFT";
        }
    }
    public static List<Tile> getNeibhours(Tile currentTile,Tile[][] tiles){
        int row = currentTile.row;
        int column = currentTile.column;
        List<Tile> neibhours = new ArrayList<Tile>();
        
        // Left
        if(column -1 >= 0){
            neibhours.add(tiles[row][column - 1]);
        }
        // Right
        if(column +1 < tiles.length){
            neibhours.add(tiles[row][column + 1]);
        }
        // UP
        if(row -1 >= 0){
            neibhours.add(tiles[row - 1][column]);
        }
        // Down
        if(row  + 1 < tiles.length){
            neibhours.add(tiles[row + 1][column]);
        }
        return neibhours;
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];
        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }
    nextMove(n,r,c,grid);
    }
}
