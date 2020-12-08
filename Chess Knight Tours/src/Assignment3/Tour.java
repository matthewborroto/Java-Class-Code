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
 * Implements a Tour where a Knight on an 8x8 chess board makes possible 
 * moves until there are no options left.
 * - Knows the number of moves of the longest tour.
 * - Knows how many tours of each length were done.
 * - Can conduct a tour across the chess board.
 * - Can return the longest tour and records as a multi-line string.
 */
public class Tour 
{
    private int longestTour = 0; // track which tour had the most stops
    private int currentMaxIndex = 0; // track which tour index was longest
    private int tourStops;      // track number of stops in each tour iteration
    private int tourCounter = 0; // track which tour we are currently on
    private int[] toursDone = new int[64];  // record of tours done
    private Knight knight;       // our knight object moving around the board
    private Board board;         // board the knight is touring around
    private String longestTourBoard;  // copy of the longest tours' toString
    
    
    /**
    * Creates a new Tour that the Knight will be doing. We need to read from
    * the board and knights possible moves so they will be passed in as 
    * parameters
    * @param board the chess board our Tour is using to refer to
    * @param knight the knight object the tour is using to move 
    * around the board
    */
    public Tour(Board board, Knight knight)
    {
        // Set the knight used in the tour as the reference 
        // passed in as a paramter
        this.knight = knight;
        
        // Set the board used in the tour as the reference 
        // passed in as a paramter
        this.board = board;
    }
    
    public void conductTour()
    {
        // Set the amount of stops in the tour to 1 at the start of every tour
        // The knight is always on the top left tile at the start.
        tourStops = 1;
        
        // Keep track of which tour we are on in the 1000 requested.
        tourCounter++;
        
        // Clear the board so we have a completely empty 
        // chess board to work with
        board.clearBoard();
        
        // Place the knight on the top left of the board, first tile every game
        board.addEntry(0, 0, "1");
        
        // Loop through the remaining tiles on the board to see if the knight
        // can move. Start from 2 because the first move has already been
        // made by default. Loop until we hit 64.
        for(int i = 2; i < 65; i++)
        {
            // Check if the knight has a possible move available. Use the 
            // canMove method and pass in the knights current position.
            if(knight.canMove(knight.getRow(), knight.getCol()))
            {
                // If the conditions are met and the knight can move, use the
                // move method to make a legal move the knight has
                knight.Move();
                
                // Place the stop the knight made on the board after its made
                // its move. Use the knights current position and the current
                // index of the for loop which matches the stop #
                board.addEntry(knight.getRow(), knight.getCol(), "" + i);
                
                // Increment our stop counter by 1, recording how many stops
                // in this tour.
                tourStops++;
            } 
        }
        
        // Add how many stops this tour made in our tour records.
        toursDone[tourStops - 1]++;
        
        // This is used to keep track of our most successful tour
        // If the stops on this tour is greater than our current max, then 
        // we record it as our most successful tour so far
        if(tourStops > currentMaxIndex)
        {
            // Set this tour as the largest number of stops done
            currentMaxIndex = tourStops;
            
            // Record which tour of the 1000 was the most successfull
            longestTour = tourCounter;
            
            // Save a copy of the most successful tours boards' toString 
            // so we can output it
            longestTourBoard = board.toString();
        } 
    }
 
    /**
     * toString will return a multi-line string containing a record of the
     * most successful tour, and a record of all the tours
     * this will override the standard toString method in java
     * @return a multi-line string with the chess board of the most successful
     * tour, and a record of all the tours
     */
    @Override
    public String toString()
    {
        // Our string to print before the board. Contains the stats of the
        // most successful tour
        String printStats = "";
        
        // Since we cannot do a return statement for each iteration of 
        // the for loop we create an empty string to fill as we iterate 
        // through the for loop then simply return the compiled string.
        // This will contain the records of all tours
        String printRecord = "";

        // The stats of our most successful tour formatted
        printStats += "\nTour Number: " + longestTour + "\nNumber of Moves: " 
                + currentMaxIndex
                + "\n==============================================" 
                + "===========\n";
 
        // Loop through each of the records and save that to our output string
        for(int i = 0; i < 64; i++)
        {
            printRecord += "\nTours with " + (i + 1) 
                    + " stops: " + toursDone[i];
        }
        
        // Return the compiled string of the stats, the chess board, and record
        // of all tours
        return printStats + longestTourBoard + printRecord;
    }
}
