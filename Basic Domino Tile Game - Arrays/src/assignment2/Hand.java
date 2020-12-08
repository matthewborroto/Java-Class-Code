/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 2
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment2;

/**
 * A player's hand of NumberTiles, tiles can be 
 * added or removed from the hand
 */
public class Hand
{
    private NumberTile[] hand;    // a player's hand of tiles
    private int handSize;          // current number of tiles in the hand
    private static final int MAX_TILES = 50;    // maximum hand size
    private static final int INITIAL_SIZE = 5;  // starting hand size
    
    /**
     * Creates a new hand containing INITIAL_SIZE NumberTiles, but with a
     * capacity of MAX_TILES
     */
    public Hand()
    {
        // create the array of NumberTiles for the hand
        hand = new NumberTile[MAX_TILES];
        
        // fill the hand with the 5 starting NumberTiles
        for(int i = 0; i < INITIAL_SIZE; i++)
        {
            hand[i] = new NumberTile();
        }
    }
       
    /**
     * Get the NumberTile at the specified index in this Hand
     * @param index is the given index that specifies which NumberTile 
     * in the hand we will be getting the info for
     * @return The NumberTile that we are looking for at the 
     * specified index will be returned
     */
    public NumberTile get(int index)
    {
        // single-line method that returns a NumberTile at a given index
        return hand[index];
    }
    
    /**
     * getSize will get the number of NumberTiles in this Hand
     * @return an integer value to represent 
     * the number of NumberTiles in the hand
     */
    public int getSize()
    {
        // set the size to 0 each time we run this, that way our size counter
        // doesnt keep infinitely getting larger each time its ran
        handSize = 0;
        
        // loop through the hand
        for(int i = 0; i < MAX_TILES; i++)
        {
            // if any tile we loop through is not empty, add +1 to the counter
            // to represent the number of tiles we currently have
            if(hand[i] != null)
            {
                handSize++;
            }
        }
        
        // return the counter after having looped through the whole hand
        return handSize;
    }
    
    /**
     * addTile will add a new NumberTile to this Hand
     */
    public void addTile()
    {
        // loop through the entire hand until we find an empty slot
        for(int i = 0; i < MAX_TILES; i++)
        {
            // if we find a null value, thats an empty slot for our new tile
            if(hand[i] == null)
            {
                // add the tile to the empty slot and break the for loop
                hand[i] = new NumberTile();
                break;
            }
        }
    }
    
    /**
     * removeTile will remove the NumberTile at 
     * the specified index from this Hand
     * @param index is the given index that specifies 
     * which NumberTile in the hand we will be removing
     */
    public void removeTile(int index)
    {
        // Delete the tile we have at the specified index
        hand[index] = null;
        
        // shift the tiles on the right side of the 
        // removed tile over 1 to the left
        // do not include the last tile in this operation because
        // there is no empty slot to the right available, its the last one
        
        // loop through all tiles in the hand starting from the index
        // where we removed a tile until the second to last tile.
        for(int i = index; i < MAX_TILES - 1; i++)
        {
            // move the next available tile to the current position
            // shifting it 1 position to the left
            hand[i] = hand[i + 1];
            
            // once that tile has been moved to the left, delete the entry
            // from where it used to be, then continue until the end
            // of the hand
            hand[i + 1] = null;
        }
    }
    
    /**
     * isEmpty checks if this hand empty, containing no NumberTiles
     * @return a true or false statement, true if the hand is empty, 
     * false if the hand still has NumberTiles
     */
    public boolean isEmpty()
    {
        // loop through all the tiles in the hand
        for(int i = 0; i < MAX_TILES; i++)
        {
            // if one of the tiles comes back as not null, then our
            // hand is not empty, so return false.
            if(hand[i] != null)
            {
                return false;
            }
        }
        
        // if we go through our entire for loop and do not find any entries
        // then we return true for an empty hand.
        return true;
    }
    
    /**
     * toString returns this Hand as a multi-line String.
     * If this Hand is empty, return an appropriate message
     * This state will be overriding the standard java toString method
     * @return a multi-line string with all the NumberTiles in the hand
     */
    @Override
    public String toString()
    {
        // check if the hand is empty first, if so this will be the output
        // since our hand is set to keep all tiles in order, if we have
        // index 0 as null, our hand is empty.
        if(hand[0] == null)
        {
            return "\n[empty]\n";
        }
        
        // Since we cannot do a return statement for each iteration of 
        // the for loop we create an empty string to fill as we iterate 
        // through the for loop then simply return the compiled string.
        String printHand = "";
        
        // iterate through each tile in the hand
        for(int i = 0; i < MAX_TILES; i++)
        {
            // only consider the non empty tiles
            if(hand[i] != null)
            {
                // call and add the toString of each tile 
                // in the hand to the print string
                printHand += hand[i] + "\n";
            }
        }
        // return the printHand string of tiles from 
        // the hand compiled by the for loop
        return printHand;
    }
}