/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 3
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package Assignment3;

// since we are using arraylists to shuffle the order of the possible moves
// use these imports
import java.util.ArrayList;
import java.util.Collections;


/**
 * A Knight object.
 * - Knows its position on the board .
 * - Knows the types of moves it can make.
 * - Can tell you its current row and column.
 * - Can determine if a move would be legal or not.
 * - Can move.
 */
public class Knight 
{
    
    private int currentRow;         // knights current row position
    private int currentCol;         // knights current column position
    
    // these are the possible moves a knight can make, the arrays line up, so, 
    // for example, a knight can make a move of 5 on both rowMoves AND colMoves
    // both moves must use the same index number
    private int rowMoves[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int colMoves[] = {2, 1, -1, -2, -2, -1, 1, 2};
    
    // board object that the knight will use to make moves
    private Board board;
    
    
    /**
     * Create a Knight object and set its position to start at the top left
     * of the board, which is indexes [0][0].
     * @param board This is the board that the knight is referring to when
     * moving around the board. The board in this class is a reference to the 
     * board passed in this parameter.
     */
    public Knight(Board board)
    {
        currentRow = 0; // current position of the knight, its row on the board
        currentCol = 0; // Current position of the knight, its col on the board
        
        // set the board object we created equal to the reference of the board
        // passed in as a parameter
        this.board = board;
    }
    
    /**
     * getRow is used when we need to get the current 
     * position of the knights row.
     * 
     * @return this will return the row that the knight is currently located 
     * at, this is the index of the row portion of the 2D array.
     */
    public int getRow()
    {
        // return the row that the knight is currently located at
        return currentRow;
    }
    
    /**
     * getCol is used when we need to get the current 
     * position of the knights col.
     * 
     * @return this will return the col that the knight is currently located 
     * at, this is the index of the row portion of the 2D array.
     */
    public int getCol()
    {
        // return the col that the knight is currently located at
        return currentCol;
    }
    
    /**
     * isLegal is used when we need to determine if the move a knight is 
     * trying to make is legal or not. A legal move must stay within the 
     * boundaries of the board and the spot must not have been visited already.
     * 
     * @param rowMove the amount of spaces the knight would move in the rows.
     * @param colMove the amount of spaces the knight would move in the cols.
     * @return true will be returned if the move is legal and can be done.
     * false will be returned if the move is NOT legal and cannot be done.
     */
    public boolean isLegal(int rowMove, int colMove)
    {
        // These are the boundaries for what determines 
        // a legal move by the knight
        // The knight will attempt to move and this statement will determine
        // if the knight stayed within the boundaries of the 2D array. The 
        // smallest row and col number can be 0 and the largest can be 7.
        if(((currentRow + rowMove) >= 0 && (currentCol + colMove) >= 0) 
                && ((currentRow + rowMove) < 8 && (currentCol + colMove) < 8))
        {
            // now that we have determined the move would be within the
            // boundaries of the board, we need to check if that spot has 
            // been visited already. A stop that has not been visited yet will
            // contain a * in it
            if(board.getContents(currentRow + rowMove, 
                    currentCol + colMove).contains("*"))
            {
                // if both these conditions are met, then we have a legal 
                // move that can be done, return true
                return true;
            }
        }
        // if any of the conditions above are not met, the move attempted is
        // not legal, so return false
        return false;
    }
    
    /**
     * canMove is used when we need to determine if a knight still has possible
     * moves left. If there are no moves available to make, i.e all 8 possible 
     * moves are not legal, then the tour ends.
     * 
     * @param row the current position of the knight, the row its on.
     * @param col the current position of the knight, the col its on.
     * @return a true statement if the knight still have available moves.
     * a false statement if the knight is out of moves to make.
     */
    public boolean canMove(int row, int col)
    {
        // loop through each of the 8 possible moves a knight can make
        for(int i = 0; i < 8; i++)
        {
            // The knight will attempt to move and this statement will 
            // determine if the knight stayed within the boundaries of the 2D 
            // array. The smallest row and col number can be 0 and the largest
            // can be 7.
            if(((row + rowMoves[i]) >= 0 && (col + colMoves[i]) >= 0) 
                    && ((row + rowMoves[i]) < 8 && (col + colMoves[i]) < 8))
            {
                // now that we have determined the move would be within the
                // boundaries of the board, we need to check if that spot has 
                // been visited already. A stop that has not been visited 
                // yet will contain a * in it
                if(board.getContents(row + rowMoves[i], 
                        col + colMoves[i]).contains("*"))
                {
                    // if both these conditions are met, then we have a legal 
                    // move that can be done, return true
                    return true;
                }
            }
        }
        // if any of the conditions above are not met, the move attempted is
        // not legal, so return false
        return false;
    }
    
    
    
    /**
    * Move is the method called to move the knight around the board in the tour
    * The knight knows the possible moves it can make and will try each of them
    * at random until a valid one is found.
    */
    public void Move()
    {
        // create and ArrayList for the possible moves the knight can make
        // we use an array list so we can utilize its shuffle method to 
        // randomize the choices made
        ArrayList<Integer> optionsToTry = new ArrayList<>();
        
        // fill the array list with the indexes of possibles moves to try
        for(int i = 0; i < 8; i++)
        {
            optionsToTry.add(i);
        }
        
        // shuffle the ArrayList around to randomize the choices
        Collections.shuffle(optionsToTry);
        
        // loop through each of the possible move indexes in the ArrayList
        for(int i = 0; i < 8; i++)
        {
            // determines if the move the knight is trying to do is legal or not
            // passes the rows and columes the knight would move into the
            // isLegal method to determine if that move would be legal or not
            if(isLegal(rowMoves[optionsToTry.get(i)], 
                    colMoves[optionsToTry.get(i)]))
            {
                // if the condition is met and the move is legal, reposition
                // the knight at the new spot it moved to and break the loop.
                currentRow = currentRow + rowMoves[optionsToTry.get(i)];
                currentCol = currentCol + colMoves[optionsToTry.get(i)];
                break;
            }
        }
    }
}
