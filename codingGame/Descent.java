package codingGame;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
class Descent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            TreeMap<Integer,Integer> mountains = new TreeMap<Integer,Integer>();
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); 
                mountains.put(mountainH,i);
            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            final Entry<Integer,Integer> lastEntry = mountains.lastEntry();
            System.out.println(lastEntry.getValue()); // The index of the mountain to fire on.
        }
    }
}