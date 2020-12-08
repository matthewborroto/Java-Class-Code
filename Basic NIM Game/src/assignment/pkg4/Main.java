/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package assignment.pkg4;

// import used to scan user input
import java.util.Scanner;

/**
 * A test class for the Nim Game, this will call all 
 * the methods needed to run the game
 */
public class Main 
{
    public static void main(String[] args) 
    {
        // Variable to determine if we continue playing
        int continueGame = 1;
        
        // Loop until the player decides to not play anymore
        while(continueGame == 1)
        {
            // Initiate the scanner object
            Scanner scan = new Scanner(System.in);
            
            // Create a pile of marbles for our game.
            Pile pile = new Pile();
            
            // Variables to record which types of players are going to be 
            // playing this game. User will decide between Human, 
            // Smart Computer, and Below Average Computer
            int playerOneChoice;
            int playerTwoChoice;
        
            // Create the player objects for the 2 players. They will need
            // to read from the pile to make their moves, so that will be
            // placed as a parameter.
            // BelowAverageComputer is used as a placeholder until the User
            // decides which ones will be playing.
            Player player1 = new BelowAverageComputer(pile);
            Player player2 = new BelowAverageComputer(pile);
            
            // Ask the User which 2 kinds of players will be in the game.
            System.out.println("Which types of players are playing? Choose 2 "
                + "of the following:" 
                + "\n1. Human"
                + "\n2. Smart Computer"
                + "\n3. Below Average Computer");
        
            // Decision for which type Player 1 will be
            System.out.println("\nEnter an integer from 1-3 for Player 1: ");
            
            // User will input one of the 3 options available
            playerOneChoice = scan.nextInt();
            
            // Check if an invalid input was entered by the user.
            while(playerOneChoice > 3 || playerOneChoice < 1)
            {
                // If the player made an incorrect choice, ask them again.
                System.out.println("Incorrect entry, please enter an integer "
                    + "from 1-3: ");
                
                // User will input one of the 3 options available
                playerOneChoice = scan.nextInt();
            }
            
            // Based on the choice they gave, we will replace the placeholder
            // object with one of these
            if(playerOneChoice == 1)
            {
                // Create a Human
                player1 = new Human(pile);
                
                // Have the user input a name for the human player
                System.out.println("What is Player 1's name? "
                        + "(First name only): ");
                player1.setName(scan.next());
            }
            if(playerOneChoice == 2)
            {
                // Create a Smart Computer
                player1 = new SmartComputer(pile);
            }
            if(playerOneChoice == 3)
            {
                // Create a Below Average Computer
                player1 = new BelowAverageComputer(pile);
            }
        
            // Decision for which type Player 2 will be
            System.out.println("\nEnter an integer from 1-3 for Player 2: ");
            
            // User will input one of the 3 options available
            playerTwoChoice = scan.nextInt();
            
            // Check if an invalid input was entered by the user.
            while(playerTwoChoice > 3 || playerTwoChoice < 1)
            {
                // If the player made an incorrect choice, ask them again.
                System.out.println("Incorrect entry, please enter an integer "
                    + "from 1-3: ");
                
                // User will input one of the 3 options available
                playerTwoChoice = scan.nextInt();
            }

            // Based on the choice they gave, we will replace the placeholder
            // object with one of these
            if(playerTwoChoice == 1)
            {
                // Create a Human
                player2 = new Human(pile);
                
                // Have the user input a name for the human player
                System.out.println("What is Player 2's name? "
                        + "(First name only): ");
                player2.setName(scan.next());
            }
            if(playerTwoChoice == 2)
            {
                // Create a Smart Computer
                player2 = new SmartComputer(pile);
            }
            if(playerTwoChoice == 3)
            {
                // Create a Below Average Computer
                player2 = new BelowAverageComputer(pile);
            }
        
            
            
            // Announce how many marbles the game will start with.
            System.out.println("\nThe pile contains " + pile.getSize() 
                + " marbles.");
        
            // Create the game object and add the pile and players in
            Nim nimgame = new Nim(pile, player1, player2);
    
            // Play the game
            nimgame.play();
            
            // Ask the user if they want to play again
            System.out.println("\n Would you like to play again? " 
                + "\n1. Yes" + "\n2. No");
            
            // User will enter 1 or 2 
            // 1 to continue playing
            // 2 to exit
            continueGame = scan.nextInt();
            
            // Check for an invalid input from the user
            while(continueGame != 1 && continueGame != 2)
            {
                // Ask the user to enter a valid input.
                System.out.println("Incorrect entry, please enter 1  or 2");
                continueGame = scan.nextInt();
            }
        }
    }
}
