/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment.pkg5;

//import used for Arrays method
import java.util.Arrays;

/**
 * A test class for the Shape sorting methods. We will create 4 different
 * shapes that will be compared by their volumes and distance from the origin
 */
public class MainTester 
{
    public static void main(String[] args) 
    {
        // Create sphere object
        Shape3D sphere = new Sphere(8, 5, 2, 14);
        
        // Create cone object
        Shape3D cone = new Cone(-1, 4, -5, 11, 15);
        
        // Create cylinder object
        Shape3D cylinder = new Cylinder(5, -7, -35, 14, 12);
        
        // Create rectangle object
        Shape3D rectangle = new Parallelepiped(9, 16, 7, 19, 9, 13);
        
        // Create an array of the super class type to store all of these
        // shapes for sorting purposes
        Shape3D[] array = {rectangle, sphere, cone, cylinder};
        
        // Extra class created for implementation of the Comparator interface
        // used to sort by distance from the origin
        Sorter sort = new Sorter();

        // Prompt before output of the shape data
        System.out.println("ALL SHAPES INFO");
        System.out.println("-------------------------------------------\n");
        
        // Loop through each element in the array and print their respective
        // shape data
        for(int i = 0; i < array.length; i++)
        {
            // Call the toString method of each shape respectively to display
            // the coordinates of the center of the shape
            System.out.println(array[i].toString());
            
            // Display the surface area of the shape
            System.out.println("Surface Area: " 
                    + array[i].computeSurfaceArea());
        }
        
        // Sort the array in ascending order. Ascending order is defined by the
        // compareTo method inside of the Shape3D class.
        Arrays.sort(array);
        
        // Prompt before output of the shapes sorted by volume in ascending
        // order
        System.out.println("\n\nSORTED BY VOLUME IN ASCENDING ORDER");
        System.out.println("-------------------------------------------\n");
        
        // Loop through each shape in the array
        for(int i = 0; i < array.length; i++)
        {
            // Output the type of shape it is
            System.out.println("Shape: " + array[i].getName());
            
            // Output the volume of the shape
            System.out.println("Volume: " + array[i].computeVolume() + "\n");
        }
        
        // Sort the array by distance from the origin in descending order
        // The distance is computed by using the distance formula of a 3D
        // point and comparing the coordinates of the center of the shape 
        // to the origin (0,0,0)
        Arrays.sort(array, sort);
        
        // Prompt before output of the shapes sorted by distance from the 
        // origin in descending order
        System.out.println("\n\nSORTED IN DESCENDING ORDER BY DISTANCE "
                + "FROM ORIGIN");
        System.out.println("-------------------------------------------\n");
        
        // Loop through each shape in the array
        for(int i = 0; i < array.length; i++)
        {
            // Output the type of shape it is
            System.out.println("Shape: " + array[i].getName());
            
            // Output the distance from the origin
            System.out.println("Distance from origin: " 
                    + array[i].distanceFromOrigin() + "\n");
        }
    }   
}
