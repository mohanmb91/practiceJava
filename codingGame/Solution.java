package codingGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        HashMap<Integer,Integer> fEP = new HashMap<Integer,Integer>();
        fEP.put(exitFloor,exitPos);
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            fEP.put(elevatorFloor,elevatorPos);
        }

        // game loop
        String eD = "";
        while (true) {
            int cF = in.nextInt(); 
            int cP = in.nextInt(); 
            String d = in.next(); 
            if(fEP.containsKey(cF)){
                int eP = fEP.get(cF);
                if(cP > eP){eD = "LEFT";}
                else if(cP < eP){eD = "RIGHT";}
                if(eD.equals(d)){System.out.println("WAIT");}
                else{System.out.println("BLOCK");}
            }else{
                System.out.println("WAIT");
            }
        }
    }
}