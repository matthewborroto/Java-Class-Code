/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 3
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package Assignment3;

/**
 * The chess board used for the Knights Tours.
 * - Knows the contents of each tile.
 * - Can tell you the contents of any given tile.
 * - Can place a number in a given tile.
 * - Can return the board as a multi-line string.
 */  
public class Board 
{
    private String[][] board;       // the 2D array board for the tour
    
    /**
     * Creates a new Board and fills all the tiles with a * to 
     * mark them as non-visited
     */
    public Board()
    {
        // Create the board object, the size is an 8x8
        board = new String[8][8];
        
        // Loop through each tile and fill the board with a * to 
        // mark the tile as non-visited
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board[i][j] = "*";
            }
        }  
    }
    
    /**
     * getContents will get the contents of the board at a 
     * specified row and column.
     * @param row The specified row on the board we are looking for.
     * @param col The specified col on the board we are looking for.
     * @return will return the String that is contained in the spot on the 
     * board that we requested
     */
    public String getContents (int row, int col)
    {
        // Return the String on the board at the specified row and column
        return board[row][col];
    }
    
    /**
     * addEntry will add a number on the board to record where the knight
     * stopped at and which stop that was.
     * @param row the specified row on the board the knight visited.
     * @param col the specified col on the board the knight visited.
     * @param entry the String of the stop # that the knight is currently on
     * this will be entered on the board.
     */
    public void addEntry(int row, int col, String entry)
    {
        // Add the new stop on the board. The String passed in as a parameter
        // is the stop # the knight is currently on. The row and col are the
        // positions of the board the knight moved to.
        board[row][col] = entry;
    }
    
    /**
     * clearBoard is used when we need to empty the board of entries so that a 
     * new tour can take place.
     */
    public void clearBoard()
    {
        // Loop through each tile and fill the board with a * to 
        // mark the tile as non-visited
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board[i][j] = "*";
            }
        } 
    }
    
    /**
     * toString will return a multi-line string of the chess board and the
     * tour that the knight did across the board.
     * This will override the standard toString method in java.
     * @return a multi-line string of a chess board and the tour the knight did.
     */
    @Override
    public String toString()
    {
        // Since we cannot do a return statement for each iteration of 
        // the for loop we create an empty string to fill as we iterate 
        // through the for loop then simply return the compiled string.
        String printBoard = "";
   
        // Loop through each tile on the 8x8 chess board.
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                // Output the string on the current tile 
                // and add a tab for spacing
                printBoard += board[i][j] + "\t";
            }
            printBoard += "\n\n";
        }
        
        // return the printBoard string of tiles 
        // from the board compiled by the for loop
        return printBoard;
    } 
}
