/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 1
 * 
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 */



import java.util.ArrayList;
import java.util.Random;

/**
 * A NumberTile is a square tile with a number from 1 to 9 on each of the 4 sides
 * 
 */
public class NumberTile 
{
    private ArrayList<Integer> tile ;                   // ArrayList of the 4 sided tiles for our game
    private static final Random gen = new Random() ;    // The random number generator used to give values to the tile sides
      
    /**
     * Create a NumberTile object and fills it with 4 random int values in the range 1 to 9
     * Indexes are positioned as follows
     * 0 - left
     * 1 - top
     * 2 - right
     * 3 - bottom
     */
    public NumberTile() 
    {
        // Create a new Tile object every time this class is called
        tile = new ArrayList<>();
        
        // Fill that newly created tile with 4 integer values representing each side of the tile
        tile.add(gen.nextInt(9) + 1);
        tile.add(gen.nextInt(9) + 1);
        tile.add(gen.nextInt(9) + 1);
        tile.add(gen.nextInt(9) + 1);
    }
    
    /**
     * Method used to Rotate the tile 90 degrees to the right
     * Indexes are re-positioned as follows
     * 3 - 0
     * 0 - 1
     * 1 - 2
     * 2 - 3
     */
    public void rotate() 
    {
        // Create a temp ArrayList to clone the tile before we move values to different indexes
        ArrayList<Integer> temp = (ArrayList) tile.clone();
        
        // Clear the tile we want to rotate of all its integer values
        tile.clear();
        
        // Re-add the integer values from the clone at the new positions
        tile.add(temp.get(3));
        tile.add(temp.get(0));
        tile.add(temp.get(1));
        tile.add(temp.get(2));
        
    }
    /**
     * getLeft is used when we need to get the value of the left side of a tile.
     * 
     * @return this will return the integer value on the left side of the NumberTile object
     */
    public int getLeft()
    {
    	// Do NOT modify this method
        return tile.get(0) ;
    }
    
    /**
     * getRight is used when we need to get the value of the right side of a tile.
     * 
     * @return this will return the integer value on the right side of the NumberTile object
     */
    public int getRight() 
    {
        // Do NOT modify this method
        return tile.get(2) ;
    }
    /**
     * Custom toString method that is overriding the standard toString method built into java
     *
     * @return Outputs this NumberTile to text as a multi-line string in the format:
     *      9
     *   3     7
     *      6
     */
    @Override
    public String toString() 
    {
        // single-line return statement with the text output formatted
        return "   " + tile.get(1) + "   \n" + tile.get(0) + "     " + tile.get(2) + "\n   " + tile.get(3) + "   ";
    }    
} // end of NumberTile class