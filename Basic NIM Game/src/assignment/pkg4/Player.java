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
 * Player interface implemented by the other subclasses.
 * Human, SmartComputer, and BelowAverageComputer all implement this interface
 */
public interface Player 
{
    // Abstract methods called by the subclasses.
    void makeMove();
    String getName();
    void setName(String name);
}
