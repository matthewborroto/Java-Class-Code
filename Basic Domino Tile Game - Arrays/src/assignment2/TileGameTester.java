/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 2
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment2;
import java.util.Scanner;



/**
 * A test class for the NumberTile Game, this will call all 
 * the methods needed to run the game
 */
public class TileGameTester
{
   public static void main(String[] args)
   {
        // create the scanner so we can ask our player if they want to
        // play again
        Scanner scan = new Scanner(System.in);
       
        // variable used to keep track if we are playing another game or not
        int continuegame = 1;
        
        // loop until the player does not want to play again.
        while(continuegame == 1)
        {
            // create the hands for each player
            Hand hand1 = new Hand();
            Hand hand2 = new Hand();
        
            // series of printlines that show the starting hands 
            // of both players
            System.out.println("\nStarting a new game...\n");
            System.out.println("***** Player 1 Initial Hand *****\n");
            System.out.println(hand1.toString());
            System.out.println("***** Player 2 Initial Hand *****\n");
            System.out.println(hand2.toString());
        
            // create the game object, and pass in the hands of both 
            // players as the parameters
            TileGame game = new TileGame(hand1, hand2);
        
            // Call the method to start the game, 
            // will run until there is a winner or a tie
            game.play();
        
            // Print the output of the results of the game
            System.out.println(game.getResults());
            
            // ask the user if he wants to play again
            System.out.println("\n Would you like to play again? "
                    + "(1 for yes, 2 for no)");
            System.out.println("\nEntry: ");
            
            // User input, 1 for yes, 2 for no
            continuegame = scan.nextInt();
            
            // checks to see if anything other than 1 or 2 was entered
            while(continuegame != 1 && continuegame != 2)
            {
                System.out.println("\nInvalid Entry, Please Enter 1 or 2.");
                System.out.println("Entry: ");
                
                // user will need to write 1 or 2 another time
                continuegame = scan.nextInt();
            }
        }
        
        // if the user chose not to play again
        if(continuegame == 2)
        {
            System.out.println("\nGoodbye.");
        }
   }
}