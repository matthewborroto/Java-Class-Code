/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 3
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */

package Assignment3;

/**
 * A test class for the Knight Tours, this will call all 
 * the methods needed to run the tours and output the results
 */
public class Assignment3 
{
    public static void main(String[] args) 
    {
        // create our board object that the knight will tour around
        Board board = new Board();
        
        // create the knight object that will move around the board, it needs
        // to read from the board, so the board will be passed as a parameter
        Knight knight = new Knight(board);
        
        // create the tour object that will handle moving the knight around
        // the board, it needs to read the board and the knight objects so
        // those will need to be passed in as parameters
        Tour tour = new Tour(board, knight);
        
        // conduct 1000 tours
        for(int i = 0; i < 1000; i++)
        {
            tour.conductTour();
        }
        
        // output the results from the 1000 tours
        System.out.println("\n");
        System.out.println(tour.toString());
        
    }
}
