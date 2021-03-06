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
 * A Cylinder is a child class of the Shape3D parent class
 * - Has a center point
 * - Has a Radius
 * - Has a Height
 * - Can output its relative shape info as a String
 * - Can compute the Volume
 * - Can compute the Surface Area
 * - Can use any methods of the parent class
 * -- Can Determine distance of center from the origin
 * -- Knows its center point coordinates
 * -- Knows its name/type
 * -- Can have its volume/distance from origin compared
 * Child class which Extends the Shape3D SuperClass
 */
public class Cylinder extends Shape3D
{
    private int radius;         // Radius of the Cylinder
    private int height;         // Height of the Cylinder
    
    /**
     * Constructor for the Cylinder class, will be passed in 5 parameters
     * @param x - Our x coordinate of the center of the shape
     * @param y - Our y coordinate of the center of the shape
     * @param z - Our z coordinate of the center of the shape
     * @param radius - The length of the radius of the Cylinder
     * @param height - The length of the height of the Cylinder
     */
    public Cylinder(int x, int y, int z, int radius, int height)
    {
        super(x, y, z, "Cylinder");     // Call the constructor of parent class
        this.radius = radius;           // Set the radius of the Cylinder
        this.height = height;           // Set the height of the Cylinder
    }
    
    /**
    * computeVolume is used to calculate the volume of the Sphere
    * This will be overriding the abstract method of the parent class
    * @return The volume of the Cylinder will be returned as a double
    */ 
    @Override
    public double computeVolume()
    {
        // Single line return method using the formula for volume of a Cylinder
        return (Math.PI * (Math.pow(radius, 2)) * height);
    }
    
    /**
    * computeSurfaceArea is used to calculate the surface area of the Cylinder
    * This will be overriding the abstract method of the parent class
    * @return The surface area of the Cylinder will be returned as a double
    */ 
    @Override
    public double computeSurfaceArea()
    {
        // Single line return method using the formula for surface area of 
        // a Cylinder
        return ((2 * Math.PI * Math.pow(radius, 2)) 
                + (2 * Math.PI * radius * height));
    }
    
    /**
    * toString is used to output the data of the shape as a multi-line String
    * This will be overriding the standard toString method
    * @return The name of the shape, the coordinates, and radius will be
    * returned as a multi-line String
    */  
    @Override
    public String toString()
    {
        // Single like method to return the data of the shape as a multi-line
        // String
        return "\nShape: " + super.getName() + "\nCentered at coordinates: " 
                + super.getCenter() + "\nRadius: " + radius 
                + "\nHeight: " + height;
    }
}