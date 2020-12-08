/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment.pkg5;

// Import used for mathematical operations
import java.lang.Math;

/**
 * Shape3D is an abstract SuperClass used as the parent class for the 
 * individual shapes
 * - Knows its center's coordinates
 * - Knows its Shape type
 * - Abstract method to calculate volume
 * - Abstract method to calculate Surface Area
 * - Can calculate the center's distance from the origin
 * - Can compare the volumes of different shapes
 * Implements the Comparable class casted to Shape3D objects
 */
public abstract class Shape3D implements Comparable<Shape3D>
{
    // Instance variable for coordinates of the center of the shape
    private Point3D shapeCenter;
    
    // String to track which shape we are using
    private String name;
    
    /**
     * Constructor for the Shape3D class, will be passed in 4 parameters
     * @param x - Our x coordinate of the center of the shape
     * @param y - Our y coordinate of the center of the shape
     * @param z - Our z coordinate of the center of the shape
     * @param name - Type of shape
     */
    public Shape3D(int x, int y, int z, String name)
    {
        // Create a point for the center of the shape
        shapeCenter = new Point3D(x, y, z);
        
        // Assign the shape a name to determine its type
        this.name = name;
    }
    
    /**
     * Abstract method to compute the shapes volume
     */
    public abstract double computeVolume();
    
    /**
     * Abstract method to compute the shapes surface area
     */
    public abstract double computeSurfaceArea();
    
    /**
     * getName is used when we need to see/output the type of shape
     * @return The name/type of the shape will be returned
     */
    public String getName()
    {
        // Single line return method to give the type of shape as a String
        return name;
    }
    
    /**
     * getCenter is used when we need to see/output the coordinates of 
     * the center of the shape
     * @return The coordinates of the center of the shape will be returned
     */
    public String getCenter()
    {
        // Single line return method to give the coordinates of the center
        // of the shape
        return shapeCenter.toString();
    }
    
    /**
     * distanceFromOrigin is used to calculate the distance of the center of 
     * the shape from the origin at (0,0,0)
     * @return The computed distance between the shapes center and the origin
     * will be returned
     */
    public double distanceFromOrigin()
    {
        // Single like return method that uses the distance formula for 
        // 2 points in 3D space
        return Math.sqrt(Math.pow(shapeCenter.getX() - 0, 2) 
                + Math.pow(shapeCenter.getY() - 0, 2) 
                + Math.pow(shapeCenter.getZ() - 0, 2));
    }
    
    /**
    * toString is used to output the coordinates of the center of the shape
    * as a String, by calling the toString method of the Point3D class object
    * This will be overriding the standard toString method
    * @return The coordinates of the center of the shape will be returned as 
    * a String
    */  
    @Override
    public String toString()
    {
        // Single like return method which calls the Point3D 
        // objects toString method
        return shapeCenter.toString();
    }
    
    /**
    * CompareTo is used compare which shape comes before/after the other in 
    * terms of volume. Since we are using ascending order for this, we will
    * go by those rules. The smaller volumes will be at the front of the array
    * This will be overriding the standard compareTo method of the Comparable
    * class
    * @param temp - the explicit "second" parameter that we are comparing with
    * @return  -1 implicit comes before explicit
    *           0 if they are the same volume
    *           1 implicit comes after explicit
    */ 
    @Override
    public int compareTo(Shape3D temp) 
    {    
        // Condition for when the implicit parameter is comes 
        // after the explicit parameter
        if((computeVolume() > temp.computeVolume()))
        {
            return 1;
        }
        // Condition for when the implicit parameter is comes 
        // before the explicit parameter
        else if(computeVolume() < temp.computeVolume())
        {
            return -1;
        }
        // Condition for when the implicit parameter and explicit parameter
        // are the same
        else
        {
            return 0;
        }
    }
}

