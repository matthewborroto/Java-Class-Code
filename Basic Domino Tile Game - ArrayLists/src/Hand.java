/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 1
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 */



import java.util.ArrayList;

/**
 * A player's hand of NumberTiles, tiles can be added or removed from the hand
 * 
 */
public class Hand
{
    private ArrayList<NumberTile> hand ;            // the ArrayList containing all the NumberTile objects the player currently holds
    private final static int INITIAL_SIZE = 5 ;     // starting hand size
    
    
    /**
     * Creates a new hand and fills it with INITIAL_SIZE NumberTiles
     */
    public Hand()
    {
        // Create the hand ArrayList so we can fill it with NumberTiles
        hand = new ArrayList<>();
        
        // Fill the hand we just created with 5 NumberTiles, each iteration of the for loop will add a NumberTile
        for(int i = 0; i < INITIAL_SIZE; i++)
        {
            hand.add(i, new NumberTile());
        }
    }
       
    /**
     * Get the NumberTile at the specified index in this Hand
     * @param index is the given index that specifies which NumberTile in the hand we will be getting the info for
     * @return The NumberTile that we are looking for at the specified index will be returned
     */
    public NumberTile get(int index)
    {
       //single-line method that returns a NumberTile at a given index
       return hand.get(index);
    }
    
    /**
     * getSize will get the number of NumberTiles in this Hand
     * @return an integer value to represent the number of NumberTiles in the hand
     */
    public int getSize()
    {
       //single-line method that returns an integer value to represent the number of NumberTiles in the hand
       return hand.size() ;
    }
    
    /**
     * addTile will add a new NumberTile to this Hand
     */
    public void addTile()
    {
        //single-line method that adds a new NumberTile to the hand
        hand.add(new NumberTile());
    }
    
    /**
     * removeTile will remove the NumberTile at the specified index from this Hand
     * @param index is the given index that specifies which NumberTile in the hand we will be removing
     */
    public void removeTile(int index)
    {
        //single-line method that removes a specific NumberTile from the hand at the given index
        hand.remove(index);
    }
    
    /**
     * isEmpty checks if this hand empty, containing no NumberTiles
     * @return a true or false statement, true if the hand is empty, false if the hand still has NumberTiles
     */
    public boolean isEmpty()
    {
       //single-line method that returns true if the hand is empty, or false if the hand is not empty
       return hand.isEmpty() ;
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
        if (hand.isEmpty() == true)
        {
            return "\n[empty]\n";
        }

        // Since we cannot do a return statement for each iteration of the for loop
        // we create an empty string to fill as we iterate through the for loop
        // then simply return the compiled string.
        String printHand = "";
        
        // iterate through each tile in the hand
        for(int i = 0; i < hand.size(); i++)
        {
            //call and add the toString of each tile in the hand to the print string
            printHand += hand.get(i) + "\n";
        }
        
        // return the printHand string of tiles from the hand compiled by the for loop
        return printHand;
    }
}
