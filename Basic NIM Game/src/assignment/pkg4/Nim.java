/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package assignment.pkg4;


/**
 * A Nim Game object
 * - Created with 2 players and a pile of marbles
 * - Can operate the game, and have players make their moves until
 * the pile is empty.
 */
public class Nim 
{
    // Pile of marbles the game is operating on
    private Pile pile;
    
    // Player 1 of our game, can be Human, SmartComputer, 
    // or BelowAverageComputer
    private Player player1;
    
    // Player 2 of our game, can be Human, SmartComputer, 
    // or BelowAverageComputer
    private Player player2;
    
    /**
    * Create the Nim Game object.
    * This object is created with 2 players and a pile of marbles.
    * @param pile is the pile of marbles our game operates on
    * @param player1 is either Human, SmartComputer, or BelowAverageComputer
    * @param player2 is either Human, SmartComputer, or BelowAverageComputer
    */
    public Nim(Pile pile, Player player1, Player player2)
    {
        // The pile of marbles our game is operating on is set equal to the one
        // passed by the parameter
        this.pile = pile;
        
        // The Player 1 of our game which is set equal to the one
        // passed by the parameter
        this.player1 = player1;
        
        // The Player 2 of our game which is set equal to the one
        // passed by the parameter
        this.player2 = player2;
    }
    
    /**
    * play is the only method of this Class.
    * The game will run and players will take turns removing marbles until
    * the pile is empty. The last player to remove a marble loses.
    */
    public void play()
    {
        // Game will run until the pile size reaches 0
        while(pile.getSize() > 0)
        {
            // Announce that player 1 will make the first move
            System.out.println("\nPlayer 1 " + player1.getName() 
                    + " makes a move.");
            
            // Call the makeMove method for player 1
            player1.makeMove();
            
            // If player 1 removed the last marble, end the while loop
            // before finishing this iteration.
            if(pile.getSize() == 0)
            {
                // Announce that player 2 has won because player 1 removed
                // the last marble
                System.out.println("\nPlayer 2 " + player2.getName() 
                        + " is the Winner!");
                
                // End the while loop
                break;
            }
            
            // Announce that player 2 will make the second move
            System.out.println("\nPlayer 2 " + player2.getName() 
                    + " makes a move.");
            
            // Call the makeMove method for player 2
            player2.makeMove();
            
            // If player 2 removed the last marble, end the while loop
            if(pile.getSize() == 0)
            {
                // Announce that player 1 has won because player 2 removed
                // the last marble
                System.out.println("\nPlayer 1 " + player1.getName() 
                        + " is the Winner!");
                
                // End the while loop
                break;
            }
        }
    }
}
