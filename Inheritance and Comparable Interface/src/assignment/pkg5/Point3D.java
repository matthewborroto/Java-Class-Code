/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment.pkg5;

/**
 * Point 3D is a class to represent the coordinates of the center of the shape
 */
public class Point3D 
{
    private int x;      // x coordinate
    private int y;      // y coordinate
    private int z;      // z coordinate
    
    /**
     * Constructor for the Point3D class, will be passed in 3 parameters
     * because the coordinates are predetermined
     * @param x - Our x coordinate of the center of the shape
     * @param y - Our y coordinate of the center of the shape
     * @param z - Our z coordinate of the center of the shape
     */
    public Point3D(int x, int y, int z)
    {
        this.x = x;     // Set the x variable equal to the x parameter
        this.y = y;     // Set the y variable equal to the y parameter
        this.z = z;     // Set the z variable equal to the z parameter
    }   
    
    /**
     * getX will return the x coordinate of the center of the shape
     * @return The x coordinate of the center of the shape will be returned
     */
    public int getX()
    {
        // Return x coordinate
        return x;
    }
    
    /**
     * getY will return the y coordinate of the center of the shape
     * @return The y coordinate of the center of the shape will be returned
     */
    public int getY()
    {
        // Return the y coordinate
        return y;
    }
    
    /**
     * getZ will return the z coordinate of the center of the shape
     * @return The z coordinate of the center of the shape will be returned
     */
    public int getZ()
    {
        // Return the z coordinate
        return z;
    }
    
    /**
    * toString is used to output the coordinates of the center of the shape
    * as a String
    * This will be overriding the standard toString method
    * @return The coordinates of the center of the shape will be returned as
    * a String
    */  
    @Override
    public String toString()
    {
        // Single line return method to output the coordinates of the center
        // of the shape
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
