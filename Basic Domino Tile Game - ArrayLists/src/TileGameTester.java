/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 1
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 */


/**
 * A test class for the NumberTile Game, this will call all the methods needed to run the game
 * 
 */
public class TileGameTester
{
    public static void main(String[] args)
    {
        // create the hands for each player
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        
        // series of printlines that show the starting hands of both players
        System.out.println("Starting a new game...\n");
        System.out.println("***** Player 1 Initial Hand *****\n");
        System.out.println(hand1.toString());
        System.out.println("***** Player 2 Initial Hand *****\n");
        System.out.println(hand2.toString());
        
        // create the game object, and pass in the hands of both players as the parameters
        TileGame game = new TileGame(hand1, hand2);
        
        // Call the method to start the game, will run until there is a winner or a tie
        game.play();
        
        // Print the output of the results of the game
        System.out.println(game.getResults());
    }
} 
