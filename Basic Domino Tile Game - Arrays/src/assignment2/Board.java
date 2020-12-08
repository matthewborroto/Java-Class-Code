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
 * The board used for the NumberTile game
 */  
public class Board
{
    private NumberTile [] board;   // the board for the game
    private int boardSize;         // current number of tiles on the board
    private static final int MAX_BOARD = 100;  // maximum number of tiles
    
    /**
     * Creates a new Board containing a single NumberTile to start the game
     */
    public Board()
    {
        // create the board array of numbertiles of the maximum size  
        board = new NumberTile[MAX_BOARD];
        
        // add the first tile on the board to start the game off
        board[0] = new NumberTile();
    }
    
    /**
     * getTile will get the NumberTile at the specified index on this Board
     * @param index is the specified index that indicates which 
     * tile on the board we will get the info for
     * @return the NumberTile on the board at the specified index
     */
    public NumberTile getTile (int index)
    {
        //single-line method that returns the NumberTile at the specified index
        return board[index];   
    }
    
    /**
     * getSize returns the current number of NumberTiles on this Board
     * @return an integer value representing the amount of 
     * NumberTiles on the board
     */
    public int getSize()
    {
        // set the size to 0 each time we run this, that way our size counter
        // doesnt keep infinitely getting larger each time its ran
        boardSize = 0;
        
        // loop through the board
        for(int i = 0; i < MAX_BOARD; i++)
        {
            // if any tile we loop through is not empty, add +1 to the counter
            // to represent the number of tiles we currently have
            if(board[i] != null)
            {
                boardSize++;
            }
        }
        
        // return the counter after having looped through the whole board
        return boardSize;
    }
    
    /**
     * addTile inserts a new NumberTile into this Board at the specified index
     * @param index is the specified index that indicates where the 
     * NumberTile will be placed on the board
     * @param tile Is a given NumberTile that we will be adding to the board
     */
    public void addTile(int index, NumberTile tile)
    {
        // if we are adding to the front (left side of the board)
        if(index == 0)
        {
            // shift the board 1 position to the right so we have an 
            // empty spot in the front start from index 98 (99 is last) 
            // and moving backwards, and set the next tile as the current tile
            // for example, starting from index 98, we copy that to index 99 
            // since its next then move to 97 we copy whats in 97 to 98 and 
            // continue until we get to the front of the array we are shifting 
            // the entire board, moving everything 1 position to the right
            for(int i = MAX_BOARD - 2; i >= 0; i--)
            {
                // we only need to move entries that are not null
                if(board[i] != null)
                {
                    // since we are starting from the back, we can just shift
                    // each tile 1 position to the right, starting from the
                    // last to the front, leaving the first slot open
                    board[i + 1] = board[i]; 
                }
            }
            
            // add the tile to the front
            board[index] = tile;
        }
        
        // if we are adding to the back (right side of the board)
        // since our hand is organized to keep all tiles at the front of
        // the array, our 0 index will always be filled if the array has
        // atleast 1 tile in it. If we are adding to the back, the index
        // where we want to add the tile will also be null
        if(board[0] != null && board[index] == null)
        {
            // loop through the board from the first entry in the array to 
            // find the first null entry available(the back of the line)
            for(int i = 0; i < MAX_BOARD; i++)
            {
                // check for the first found null (back of the line)
                if(board[i] == null)
                {
                    // add the tile at the null entry
                    board[i] = tile;
                    
                    // break out of the for loop
                    break;
                }
            }
        }
        
        // if we are adding in the middle
        // since our hand is organized to keep all tiles at the front of
        // the array, our 0 index will always be filled if the array has
        // atleast 1 tile in it. If the index we want to add the tile in 
        // is not null, then we are not at the back of the line, so that
        // mean this must be inserted inbetween adjacent tiles.
        if(index != 0 && board[index] != null)
        {
            // loop through the board from the back to the index we are going 
            // to be adding the new tile at. We start with a -2 to MAX_BOARD
            // because we are not starting from the last tile, we have no
            // adjacent tile to the right to compare it to.
            for(int i = MAX_BOARD - 2; i > index; i--)
            {
                // only consider the entries that are not null
                if(board[i] != null)
                {
                    // shift the position of all tiles 1 to the right
                    board[i + 1] = board[i]; 
                }
            }
            
            //add the tile at the given index
            board[index] = tile;
        } 
    }
    
    /**
     * toString will return a multi-line string containing all 
     * the NumberTiles on this Board
     * this will override the standard toString method in java
     * @return a multi-line string with all the NumberTiles on the board
     */
    @Override
    public String toString()
    {
        // Since we cannot do a return statement for each iteration of 
        // the for loop we create an empty string to fill as we iterate 
        // through the for loop then simply return the compiled string.
        String printBoard = "";
        
        // iterate through each tile on the board
        for(int i = 0; i < MAX_BOARD; i++)
        {
            // only consider the non empty tiles
            if(board[i] != null)
            {
                // call and add the toString of each tile 
                // in the hand to the print string
                printBoard += board[i].toString() + "\n";
            }
        }
        
        // return the printBoard string of tiles from 
        // the board compiled by the for loop
        return printBoard;
    }           
}