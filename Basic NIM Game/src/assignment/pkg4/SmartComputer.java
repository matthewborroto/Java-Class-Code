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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A Smart Computer object
 * - Can read from and use methods from the pile
 * - Can make moves in the Nim Game
 * - Knows its name
 */
public class SmartComputer implements Player
{
    // List of best moves to make for the Smart Computer for the makeMove
    // method
    private List<Integer> list;
    
    // Random number generator for the makeMove method
    private Random rand = new Random();
    
    // The pile of marbles our Smart Computer is making decisions based on
    private Pile pile = new Pile();
    
    // Smart Computers Name
    private String name = "SmartComputer";
    
    
    /**
    * Create the Smart Computer object.
    * This object can read from the pile and make decisions based on it.
    * @param pile is the pile of marbles our Smart Computer makes decisions
    * based on
    */
    public SmartComputer(Pile pile)
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
    * makeMove is used to have the Smart Computer make a play and remove 
    * a certain amount of marbles from the pile.
    * This method will be overriding the method of the Player Interface.
    */
    @Override
    public void makeMove()
    {
        // Create the array list of the best moves the Smart Computer can make
        list = new ArrayList<>();
        
        // Add each of the possible best moves to the ArrayList
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(15);
        list.add(31);
        list.add(63);

        // Set the min and max allowed for the amount of marbles that can be
        // taken.
        int min = 1;
        int max = (pile.getSize()/2);
        
        // This is the number of marbles that will be removed from the pile
        int amountToRemove;
        
        // This will only run when the pile has 1 marble left
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
            // Set the amount to remove equal to a random selection of the best
            // moves the Smart Computer can make.
            amountToRemove = list.get(rand.nextInt(list.size()));
            
            // If the random selection is not between the mix and max, try
            // another until it works.
            while(amountToRemove < min || amountToRemove > max)
            {
                // Try another move if the one selected isnt in the range.
                amountToRemove = list.get(rand.nextInt(list.size()));
            }
            
            // Once we have a correct amount of marbles to remove, take
            // them out of the pile
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
