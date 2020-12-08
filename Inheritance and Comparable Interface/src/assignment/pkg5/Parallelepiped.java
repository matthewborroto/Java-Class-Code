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
 * A Parallelepiped is a child class of the Shape3D parent class
 * - Has a center point
 * - Has a Length
 * - Has a Width
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
public class Parallelepiped extends Shape3D
{
    private int length;         // Length of the Parallelepiped
    private int height;         // Height of the Parallelepiped
    private int width;          // Width of the Parallelepiped
    
    /**
     * Constructor for the Cone class, will be passed in 6 parameters
     * @param x - Our x coordinate of the center of the shape
     * @param y - Our y coordinate of the center of the shape
     * @param z - Our z coordinate of the center of the shape
     * @param length - The length of the Parallelepiped
     * @param width - The width of the Parallelepiped
     * @param height - The height of the Parallelepiped
     */
    public Parallelepiped(int x, int y, int z, int length, int width, 
            int height)
    {
        super(x, y, z, "Parallelepiped");   // Call the const. of parent class
        this.length = length;       // Set the length of the Parallelepiped
        this.width = width;         // Set the width of the Parallelepiped
        this.height = height;       // Set the height of the Parallelepiped
    }
    
    /**
    * computeVolume is used to calculate the volume of the Parallelepiped
    * This will be overriding the abstract method of the parent class
    * @return The volume of the Parallelepiped will be returned as a double
    */ 
    @Override
    public double computeVolume()
    {
        // Single line return method using the formula for volume of 
        // a Parallelepiped
        return (length * width * height);
    }
    
    /**
    * computeSurfaceArea is used to calculate the surface area of 
    * the Parallelepiped
    * This will be overriding the abstract method of the parent class
    * @return The surface area of the Parallelepiped will be returned 
    * as a double
    */ 
    @Override
    public double computeSurfaceArea()
    {
        // Single line return method using the formula for surface area of 
        // a Parallelepiped
        return (((length * width) * 2) + ((length * height) * 2) 
                + ((height * width) * 2));
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
                + super.getCenter() + "\nLength: " + length + "\nHeight: " 
                + height + "\nWidth: " + width;
    }
}