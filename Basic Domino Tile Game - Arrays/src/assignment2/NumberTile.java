/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 2
 * 
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment2;
import java.util.Random;

/**
 * A NumberTile is a square tile with a 
 * number from 1 to 9 on each of the 4 sides
 */
public class NumberTile 
{
    private int[] tile;    // the 4-sided tile
            
    /**
     * Create a NumberTile object and fills it 
     * with 4 random int values in the range 1 to 9
     * Indexes are positioned as follows:
     * 0 - left
     * 1 - top
     * 2 - right
     * 3 - bottom
     */
    public NumberTile() 
    {
        
        // instantiate our random number generator
        Random gen = new Random() ;  // DO NOT ERASE THIS DECLARATION
        
        // Create the tile array
        tile = new int[4];
        
        // Fill the tile array with 4 integer 
        // values representing each side of the tile
        tile[0] = gen.nextInt(9) + 1;
        tile[1] = gen.nextInt(9) + 1;
        tile[2] = gen.nextInt(9) + 1;
        tile[3] = gen.nextInt(9) + 1;
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
        // Create a temp array to copy over the tile values
        // before we move values to different indexes on the original
        int [] temp = new int[4];
        
        // copy over the current tile to the temp array
        temp[0] = tile[0];
        temp[1] = tile[1];
        temp[2] = tile[2];
        temp[3] = tile[3];
        
        // reposition the tiles at their new indexes
        tile[0] = temp[3];
        tile[1] = temp[0];
        tile[2] = temp[1];
        tile[3] = temp[2];
    }
    
    /**
     * getLeft is used when we need to 
     * get the value of the left side of a tile.
     * 
     * @return this will return the integer value 
     * on the left side of the NumberTile object
     */
    public int getLeft()
    {
        // Do NOT modify this method
        return tile[0];
    }
    
    /**
     * getRight is used when we need to 
     * get the value of the right side of a tile.
     * 
     * @return this will return the integer value 
     * on the right side of the NumberTile object
     */
    public int getRight() 
    {
        // Do NOT modify this method
        return tile[2];
    }
    
    /**
     * Custom toString method that is overriding 
     * the standard toString method built into java
     *
     * @return Outputs this NumberTile 
     * to text as a multi-line string in the format:
     *      9
     *   3     7
     *      6
     */
    @Override
    public String toString() 
    {
        // single-line return statement with the text output formatted
        return "   " + tile[1] + "   \n" + tile[0] + "     " 
                + tile[2] + "\n   " + tile[3] + "   ";
    }    
} // end of NumberTile class