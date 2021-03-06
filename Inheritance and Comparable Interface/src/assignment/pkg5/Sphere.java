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
 * A Sphere is a child class of the Shape3D parent class
 * - Has a center point
 * - Has a radius
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
public class Sphere extends Shape3D
{
    private int radius;         // Radius of the Sphere
    
    /**
     * Constructor for the Sphere class, will be passed in 4 parameters
     * @param x - Our x coordinate of the center of the shape
     * @param y - Our y coordinate of the center of the shape
     * @param z - Our z coordinate of the center of the shape
     * @param radius - The length of the radius of the Sphere
     */
    public Sphere(int x, int y, int z, int radius)
    {
        super(x, y, z, "Sphere");   // Call the constructor of parent class
        this.radius = radius;       // Set the radius of the Sphere
    }

    /**
    * computeVolume is used to calculate the volume of the Sphere
    * This will be overriding the abstract method of the parent class
    * @return The volume of the Sphere will be returned as a double
    */ 
    @Override
    public double computeVolume()
    {
        // Single line return method using the formula for volume of a Sphere
        return ((4/3) * Math.PI * (Math.pow(radius, 3)));
    }
    
    /**
    * computeSurfaceArea is used to calculate the surface area of the Sphere
    * This will be overriding the abstract method of the parent class
    * @return The surface area of the Sphere will be returned as a double
    */ 
    @Override
    public double computeSurfaceArea()
    {
        // Single line return method using the formula for surface area of 
        // a Sphere
        return (4 * Math.PI * Math.pow(radius, 2));
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
                + super.getCenter() + "\nRadius: " + radius;
    }
}
