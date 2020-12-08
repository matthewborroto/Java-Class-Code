/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 1
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 */



import java.util.ArrayList;

/**
 * The board used for the NumberTile game
 */
public class Board
{
    private ArrayList<NumberTile> board ;    // instantiate the board for a NumberTile game
    
    /**
     * Creates a new Board containing a single NumberTile to start the game
     */
    public Board()
    {
        // Create the board object
        board = new ArrayList<>();
        
        // Add the first NumberTile to the board
        board.add(new NumberTile());
    }
    
    /**
     * getTile will get the NumberTile at the specified index on this Board
     * @param index is the specified index that indicates which tile on the board we will get the info for
     * @return the NumberTile on the board at the specified index
     */
    public NumberTile getTile (int index)
    {
       //single-line method that returns the NumberTile at the specified index
       return board.get(index);   
    }
    
    /**
     * getSize returns the current number of NumberTiles on this Board
     * @return an integer value representing the amount of NumberTiles on the board
     */
    public int getSize()
    {
       //single-line method that returns an integer value representing the amount of NumberTiles on the board
       return board.size();
    }
    
    /**
     * addTile inserts a new NumberTile into this Board at the specified index
     * @param index is the specified index that indicates where the NumberTile will be placed on the board
     * @param tile Is a given NumberTile that we will be adding to the board
     */
    public void addTile(int index, NumberTile tile)
    {
        //single-line method that adds a given NumberTile to a specific index on the board
        board.add(index, tile);
    }
    
    /**
     * toString will return a multi-line string containing all the NumberTiles on this Board
     * this will override the standard toString method in java
     * @return a multi-line string with all the NumberTiles on the board
     */
    @Override
    public String toString()
    {
        // Since we cannot do a return statement for each iteration of the for loop
        // we create an empty string to fill as we iterate through the for loop
        // then simply return the compiled string.
        String printBoard = "";
        
        // iterate through each tile on the board
        for(int i = 0; i < board.size(); i++)
        {
            //call and add the toString of each tile on the board to the print string
            printBoard += board.get(i) + "\n";
        }
        
        // return the printBoard string of tiles from the board compiled by the for loop
        return printBoard;
    }           
}
