/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package assignment.pkg4;

// Imports used for our makeMove method.
import java.util.Scanner;

/**
 * A Human player object
 * - Can read from and use methods from the pile
 * - Can make moves in the Nim Game
 * - Can be given a name
 * - Knows its name
 */
public class Human implements Player
{
    // The pile of marbles our Below Average Computer is making 
    // decisions based on
    private Pile pile = new Pile();
    
    // Human players Name
    private String name = "Human";
    
    /**
    * Create the Human player object.
    * This object can read from the pile and make decisions based on it.
    * @param pile is the pile of marbles our Human player makes decisions
    * based on
    */
    public Human(Pile pile)
    {
        // Set the pile object of this class equal to the one passed by
        // the parameter
        this.pile = pile;
    }
    
    /**
    * getName is used to get the name variable of this class
    * This method will be overriding the method of the Player Interface.
    * @return this will return the name of this Class
    */
    @Override
    public String getName()
    {
        return name;
    }
    
    /**
    * setName is used to give a name to this Class
    * This method will be overriding the method of the Player Interface.
    */
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
    * makeMove is used to have the Human player make a play 
    * and remove a certain amount of marbles from the pile.
    * This method will be overriding the method of the Player Interface.
    */
    @Override
    public void makeMove()
    {
        // Add a scanner object since we need the user to input the
        // amount of marbles to remove for Human players
        Scanner scan = new Scanner(System.in);
        
        // Variable for the number of marbles to remove from the pile
        int amountToRemove;
        
        // Only runs if the pile has 1 marble left
        if(pile.getSize() == 1)
        {
            // Announce how many marbles must be removed
            System.out.println("You must remove the last marble.");
            
            // Remove 1 marble from the pile
            pile.removeMarbles(1);
        }
        // Only runs if the pile has 2 marbles left
        else if(pile.getSize() == 2)
        {
            // Announce how many marbles must be removed
            System.out.println("You must remove 1 or 2 marbles.");
            
            // The user will input a number of marbles to remove.
            amountToRemove = scan.nextInt();
            
            // Check if the user entered a valid number of marbles to remove
            while(amountToRemove != 1 && amountToRemove != 2)
            {
                // The user has input an incorrect option and must try again
                System.out.println("Incorrect entry. You must remove 1 or "
                        + "2 marbles.");
                
                // The user will input a number of marbles to remove.
                amountToRemove = scan.nextInt();
            }
        }
        // Only runs if the pile has more than 2 marbles left
        else
        {
            // Announce how many marbles must be removed
            System.out.println("\nYou must remove a number of marbles between "
                + "1 and " + (pile.getSize()/2)
                + "\nHow many marbles would you like to remove?");
            
            // The user will input a number of marbles to remove.
            amountToRemove = scan.nextInt();
        
            // Check if the user entered a valid number of marbles to remove
            while(amountToRemove < 1 || amountToRemove > (pile.getSize()/2))
            {
                // The user has input an incorrect option and must try again
                System.out.println("Incorrect entry. Please remove "
                        + "a number of " + "marbles between 1 and " 
                        + (pile.getSize()/2));
                
                // The user will input a number of marbles to remove.
                amountToRemove = scan.nextInt();
            }
            
            // Remove a number of marbles equal to the number entered by the
            // user
            pile.removeMarbles(amountToRemove);
            
            // Announce how many marbles have been removed, and how many
            // marbles are left in the pile.
            System.out.println(name + " has removed " + amountToRemove 
                    + " marbles");
            System.out.println("\nPile has " + pile.getSize() 
                    + " marbles left"); 
        }
    }
}
