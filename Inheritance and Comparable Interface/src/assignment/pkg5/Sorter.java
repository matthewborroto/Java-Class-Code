/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 4
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package assignment.pkg5;

// Import used for the implementation of the Comparator interface
import java.util.Comparator;

/**
 * A sorting class used as the conditions for sorting the distance from 
 * the origin in descending order
 * Implements the Comparator class
 */
public class Sorter implements Comparator
{
    /**
     * No-argument constructor for our descending sorter
     */
    public Sorter()
    {
        
    }
    
    /**
    * Compare is used for comparing the distance of two shapes by the distance 
    * of their center from the origin. Our Comparable implementation is
    * comparing with volume, this method was created to sort via a second
    * method, which is by distance from the origin.
    * This will be overriding the standard compare method of the Comparator
    * class
    * @param firstObject - first shape used in comparing
    * @param secondObject - second shape used in comparing
    * @return  -1 if the second object is closer
    *           0 if they are the same distance
    *           1 if the first object is closer
    */          
    @Override
    public int compare(Object firstObject, Object secondObject) 
    {
        // Create the shapes we are comparing so we can copy the parameters
        // into them
        Shape3D shape1 = (Shape3D) firstObject;
        Shape3D shape2 = (Shape3D) secondObject;
        
        // Calculate each shapes' center's distance from the origin
        double distanceFromOrigin1 = shape1.distanceFromOrigin();
        double distanceFromOrigin2 = shape2.distanceFromOrigin();
        
        // Condition for when the first shape is closer
        if(distanceFromOrigin2 > distanceFromOrigin1)
        {
            return 1;
        }
        // Condition for when the second shape is closer
        else if(distanceFromOrigin2 < distanceFromOrigin1)
        {
            return -1;
        }
        // Condition for when the shapes are the same distance
        else
        {
            return 0;
        }
    }
}
