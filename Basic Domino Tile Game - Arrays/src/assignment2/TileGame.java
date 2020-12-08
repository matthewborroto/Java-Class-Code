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
 * Implements a domino-like game where two players, both of whom are
 * the computer, take turns inserting NumberTiles into a Board
 */
public class TileGame
{
    // instance vars
    private Board board;     // the game board
    private Hand hand1;      // Player 1 hand
    private Hand hand2;      // Player 2 hand
    private String winner;   // the winner - player1, player2, or a tie game
   
    /**
    * Creates a new TileGame with two initial hands, 
    * one for each player, and a Board object
    * @param firstHand The hand for Player 1
    * @param secondHand The hand for Player 2
    */
    public TileGame(Hand firstHand, Hand secondHand)
    {
        hand1 = new Hand();         // Create the Player 1 Hand object
        hand2 = new Hand();         // Create the Player 2 Hand object
        board = new Board();        // Create the Board object
        this.hand1 = firstHand;     // Fill the Player 1 hand 
                                    // with the given hand parameter
        this.hand2 = secondHand;    // Fill the Player 2 hand 
                                    // with the given hand parameter
    }
   
    /**
    * When play is called, Players take turns moving 
    * until one or both hand are empty
    */
    public void play()
    {
        // while loop that keeps looping 
        // until one or both of the hands is/are empty
        while(hand1.isEmpty() != true && hand2.isEmpty() != true)
        {
            // in each round of play, player 1 will make a move, 
            // then player 2 will afterwards.
            makeMove(hand1);
            makeMove(hand2);
        }
    }

    /**
    * getIndexForFit is a utility method called by method makeMove.  
    * Returns the index at which a new tile will be inserted into the 
    * board, or -1 if the tile cannot be inserted.  The new tile may be 
    * inserted either (1) between two existing tiles, (2) as the new first 
    * tile, or (3) as the new last tile
    * 
    * @param tile is the given till we will be checking to see 
    * if there is a spot for on the board
    * @return gives the integer value to represent which index 
    * on the board the tile can fit
    */
    private int getIndexForFit(NumberTile tile)
    {
        // Loop through each number on the tile, 
        // to see if we need to rotate it
        for(int i = 0; i < 4; i++)
        {
            // checks to see if the tile can be added to the front 
            // by comparing the tile's right side to the boards
            // first tile on the left side
            if(tile.getRight() == board.getTile(0).getLeft())
            {
                // if we get a match, the tile can be added to the front. 
                // Add the tile to the board at the front and return 
                // the index that the tile will be added at
                board.addTile(0, tile);
                return 0;
            }
            
            // checks to see if the tile can be added to the end 
            // by comparing the tile's left side to the boards
            // last tile on the right side
            else if(tile.getLeft() == 
                    board.getTile(board.getSize() - 1).getRight())
            {
                // if we get a match, the tile can be added to the end. 
                // Add the tile to the board at the end and return the 
                // index that the tile will be added at
                board.addTile(board.getSize(), tile);
                return board.getSize();
            }
            
            // If the tile cannot be added to the front or back 
            // at the current iteration, rotate the tile and 
            // the for loop will check again.
            else
            {
                // rotate the tile if we do not find a match 
                // at the front or back at the current iteration
                tile.rotate();
            }
        }
        
       
 
        // check for inserting the tile between two adjacent tiles, 
        // adding the - 1 in the for loop because were not iterating
        // through the last tile for this, theres no tile after it to compare 
        // it with. We will be looping through each tile on the board and 
        // comparing it with the adjacent tile to the right
        for(int i = 0; i < board.getSize() - 1; i++)
        {
            
            // Loop through each number on the tile, 
            // to see if we need to rotate it
            for(int j = 0; j < 4; j++)
            {
                // first we compare the tiles left side to the 
                // current indexes right side.
                // second we compare the tiles right side to the 
                // adjacent tiles left side on the board from the 
                // first tile we checked. 
                // if we get a match for both, we can insert the tile
                // from the hand inbetween those two board tiles.
                if(tile.getLeft() == board.getTile(i).getRight() && 
                        tile.getRight() == board.getTile(i + 1).getLeft())
                {
                    // since the new tile will be added after the 
                    // current index of the 2 adjacent tiles, we add a +1 
                    return i + 1;
                }
                
                //if we do not have a match, we try rotating the tile 
                // and the for loop will check again to see if it will match
                else
                {
                    tile.rotate();
                }
            }
        }
        // if no match is found, we cannot place that tile 
        // on the board, return a -1
        return -1 ;
    }

    /**
    * makeMove is a utility method called by method play().  
    * Checks consecutive tiles in the hand - by calling method 
    * getIndexForFit() - to see if one can be inserted into the board. 
    * When the first tile that fits is found, removes it from
    * the hand, inserts it into the board, and the move ends.  
    * The tile may be rotated up to 3 times. If none of the tiles fit, 
    * adds a new, random tile to the hand.
    * @param hand is the given hand of the player making the current move
    */ 
    private void makeMove(Hand hand)
    {
        // loop through each tile in the hand until there is a match, 
        // which will break the for loop
        for(int i = 0; i < hand.getSize(); i++)
        {
            
            // if our method getIndexForFit returns anything 0 or higher, 
            // we have a match that can be added to the board
            if(getIndexForFit(hand.get(i)) >= 0)
            {
                // remove the tile from the hand at the current 
                // for loop index and break the loop, the turn has ended.
                hand.removeTile(i);
                break;
            }
            
            //if no match was found at the end of the last 
            // iteration of the for loop. Add a tile to the players hand
            if(i == hand.getSize() - 1)
            {
                hand.addTile();
            }
        }
    }
   
    /**
    * getResults will return results of the game as a humongous 
    * multi-line String containing the final board, both both player's 
    * final hands, and the winner
    * @return a very long multi-line string with the game results
    */
    public String getResults()
    {
        // In the event that player 1 is the winner, 
        // this will be the output used
        // First the final board is shown with all the tiles in place
        // Second both final hands of the players are shown, 
        // the winning players hand will be empty
        // Lastly a winner will be declared
        if(hand1.isEmpty() == true && hand2.isEmpty() == false)
        {
            // set the winner string as player 1
            winner = "Player 1";
            return "\n***** The Final Board *****\n" + board.toString() 
                    + "\n***** Player 1 Final Hand *****\n" + hand1.toString() 
                    + "\n***** Player 2 Final Hand *****\n" + hand2.toString() 
                    + "\n***** The Winner is " + winner + " *****\n";
        }
        
        // In the event that player 2 is the winner, 
        // this will be the output used
        // First the final board is shown with all the tiles in place
        // Second both final hands of the players are shown, 
        // the winning players hand will be empty
        // Lastly a winner will be declared
        if(hand1.isEmpty() == false && hand2.isEmpty() == true)
        {
            // set the winner string as player 2
            winner = "Player 2";
            return "\n***** The Final Board *****\n" + board.toString() 
                    + "\n***** Player 1 Final Hand *****\n" + hand1.toString() 
                    + "\n***** Player 2 Final Hand *****\n" + hand2.toString() 
                    + "\n***** The Winner is " + winner + " *****\n";
        }
        
        // In the event that the game is a tie, this will be the output used
        // First the final board is shown with all the tiles in place
        // Second both final hands of the players are shown, 
        // both will be empty since it is a tie
        // Lastly the game will be declared as a tie
        if(hand1.isEmpty() == true && hand2.isEmpty() == true)
        {
            // set the winner string as a tie
            winner = "Tie!";
            return "\n***** The Final Board *****\n" + board.toString() 
                    + "\n***** Player 1 Final Hand *****\n" + hand1.toString() 
                    + "\n***** Player 2 Final Hand *****\n" + hand2.toString() 
                    + "\n***** There is a " + winner + " *****\n";
        }
        
        // blank return statement so the method will compile
        return "";
    }
} // end of TileGame2 class