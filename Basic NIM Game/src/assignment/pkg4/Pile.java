/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package assignment.pkg4;

// Import used for our random number generator
import java.util.Random;

/**
 * A Pile object.
 * - Created with a random amount of marbles between 20-95
 * - Knows its size.
 * - Knows if its empty or not.
 * - Can have marbles removed by a player.
 */
public class Pile 
{
    // Create our random number generator
    private Random rand = new Random();
    
    // Variable to track the number of marbles in the pile
    private int marbles;
    
    /**
     * Create the Pile of marbles object with a random number of marbles
     * anywhere from 20-95
     */
    public Pile()
    {
        // Set the marbles variable equal to a random number between 20-95
        marbles = rand.nextInt(75) + 20;
    }
    
    /**
     * getSize is used to get the number of marbles left in the pile.
     * 
     * @return this will return the amount of marbles left in the pile.
     */
    public int getSize()
    {
        // Single line method to return the number of marbles in the pile.
        return marbles;
    }
    
    /**
     * isEmpty is used to determine if there are any marbles left in the pile.
     * 
     * @return this will return true if the pile is empty, and false if the
     * pile is not empty
     */
    public boolean isEmpty()
    {
        // Checks if the pile has 0 marbles 
        if(marbles == 0)
        {
            // Return true if there are 0 marbles in the pile.
            return true;
        }
        
        // Return false if there are marbles in the pile.
        return false;
    }
    
    /**
    * removeMarbles is the method called to remove a number of marbles from the
    * pile equal to the number specified by the user
    * @param amountToRemove the number of marbles to remove from the pile 
    * specified by the user or computer
    */
    public void removeMarbles(int amountToRemove)
    {
        // Remove the number of marbles specified from the pile
        marbles = marbles - amountToRemove;
    }
}
