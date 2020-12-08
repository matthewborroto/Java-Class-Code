/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package assignment.pkg4;

// Import used for our makeMove method.
import java.util.Random;

/**
 * A Below Average Computer object
 * - Can read from and use methods from the pile
 * - Can make moves in the Nim Game
 * - Knows its name
 */
public class BelowAverageComputer implements Player
{
    // The pile of marbles our Below Average Computer is making 
    // decisions based on
    private Pile pile = new Pile();
    
    // Below Average Computers Name
    private String name = "BelowAverageComputer";
    
    /**
    * Create the Below Average Computer object.
    * This object can read from the pile and make decisions based on it.
    * @param pile is the pile of marbles our Below Average Computer makes 
    * decisions based on
    */
    public BelowAverageComputer(Pile pile)
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
        // Single line return method to give the name of the Class
        return name;
    }
    
    /**
    * setName is used to give a name to this Class
    * This method will be overriding the method of the Player Interface.
    */
    @Override
    public void setName(String name)
    {
        // Set the name variable of this class equal to the one passed by
        // the parameter
        this.name = name;
    }
    
    /**
    * makeMove is used to have the Below Average Computer make a play 
    * and remove a certain amount of marbles from the pile.
    * This method will be overriding the method of the Player Interface.
    */
    @Override
    public void makeMove()
    {
        // Random number generator to decide how many marbles to remove
        Random rand = new Random();
        
        // Default the amount to remove at 1 because we must remove atleast
        // 1 marble
        int amountToRemove = 1;
        
        // Only runs if the pile has 1 marble left
        if(pile.getSize() == 1)
        {
            // Remove 1 marble from the pile
            pile.removeMarbles(1);
            
            // Announce how many marbles must be removed
            System.out.println(name + " must remove the last marble.");
        }
        // If the pile has more than 1 marble left
        else
        {
            // Set the number of marbles to remove equal to a random number
            // between 1 and half the size of the pile
            amountToRemove = rand.nextInt((pile.getSize()/2)) + 1;
            
            // Remove a number of marbles equal to the random number we just
            // generated
            pile.removeMarbles(amountToRemove);
        }
        
        // Announce how many marbles have been removed, and how many
        // marbles are left in the pile.
        System.out.println(name + " has removed " + amountToRemove 
                + " marbles");
        System.out.println("\nPile has " + pile.getSize() + " marbles left");
    }
}
