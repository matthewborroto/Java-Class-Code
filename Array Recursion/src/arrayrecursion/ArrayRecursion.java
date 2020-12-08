/**
 * Matthew Borroto
 * ID: 4031431
 * Section: U07, U01, U08
 * File Name: Assignment 7
 * I affirm that this program is entirely my own work 
 * and none of it is the work of any other person.
 */
package arrayrecursion;

//
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class that performs some simple array operations recursively
 */
public class ArrayRecursion
{
    // Instance var's
    private int[] list ;        // Array of ints
    private int count ;         // Number of elements

    /**
     * Create an ArrayRecursion object. 
     * Creates an array with between 10 and 15 elements, and fills it with
     * random positive 2-digit ints
     */
    public ArrayRecursion()
    {
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count ; i++)
        {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /**
     * Return the list as a string
     * @return a string containing all the ints stored in list
     */
    public String toString()
    {
        String out = "";
        for (int i = 0; i < count ; i++)
        {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Returns the smallest value in the array.
     * @return the smallest value in the array
     */
    public int getSmallest()
    {
        // Return the result of the recursive method to find the smallest
        // element in the array
        return recursiveGetSmallest(list, count);
    }

    /**
     * Recursive "helper" method returns the smallest value in list.
     * Called by public method getSmallest()
     * @return the smallest value in the array
     */
    private int recursiveGetSmallest(int[] list, int count)
    {
        // If count reaches 0, we have traversed the entire array without
        // finding a smaller number than the last element of the array leaving 
        // us with 1 element in the sub-array left. Return that number for the 
        // comparison recursion call of the final iteration, which will also 
        // end the recursion as we're not calling the method here.
        if(count == 0)
        {
            return list[0];
        }
        // This will run until there is only 1 element in the array left to 
        // compare with. The last iteration will call the base case above,
        // ending the recursion. The Math.min function will compare 2 
        // integers each iteration, (a) the smallest element in the current
        // sub-array and (b) the return value of the previous recursion call
        else
        {
            return Math.min(list[count - 1], 
                    recursiveGetSmallest(list, count - 1));
        }
    }

    /**
     * Reverse the elements of the array
     */
    public void reverse()
    {
        recursiveReverse(list, 0, count);
    }

    /**
     * Recursive "helper" method to reverse the array.
     * Called by public method reverse()
     */
    private void recursiveReverse(int[] list, int first, int count)
    {
        // On the first iteration, first will equal 0
        // Swap the position of these elements in the array.
        if(first == 0)
        {
            // Save the first element to a temp variable
            int temp = list[first];
            
            // Replace the first element with the last element
            list[first] = list[count - 1];
            
            // Replace the last element with the first element saved in temp
            list[count - 1] = temp;
            
            // Recursively call the next iterations of the swap
            recursiveReverse(list, (first + 1), (count - 1));
        }
        // If this is not the first iteration, keep running this until the
        // first index and length of the sub-array index meet.
        else if(first < count)
        {
            // Save the first element to a temp variable
            int temp = list[first];
            
            // Replace the first element with the last element
            list[first] = list[count - 1];
            
            // Replace the last element with the first element saved in temp
            list[count - 1] = temp;
            
            // Recursively call the next iterations of the swap until the 
            // first and count meet at the middle
            recursiveReverse(list, (first + 1), (count - 1));
        }
    }
   
    /**
     * Does the array contain two or more consecutive ints, ascending or
     * descending?
     * @return true if array contains any consecutive ints; otherwise false
     */
    public boolean hasConsecutives()
    {
        return recursiveHasConsecutives(list, count);
    }
   
    /**
     * Recursive "helper" method called by public method hasConsecutives()
     * @return true if array contains any consecutive ints; otherwise false
     */
    private boolean recursiveHasConsecutives(int[] list, int count)
    {
        // Terminating condition for recursive method. If the count reaches 2
        // then we have reached the end (or in this case beginning) of the 
        // array
        if(count == 2)
        {
            // First check if the last iteration caught an instance of
            // consecutive ints. Check if the current index at count and the 
            // one before are consecutive, either ascending or descending
            if(list[count - 2] - list[count - 1] == 1 || 
                    list[count - 2] - list[count - 1] == -1)
            {
                return true;
            }
            // If the last two numbers are not consecutive, then no numbers
            // in the array are consecutive. Return false.
            else
            {
                return false;
            }
        }
        
        // With each iteration of the recursive method, if we are not on the 
        // last 2 numbers, then check with this if statement. Check if the 
        // current index at count and the one before are consecutive, either 
        // ascending or descending
        if(list[count - 2] - list[count - 1] == 1 || 
                list[count - 2] - list[count - 1] == -1)
        {
            return true;
        }
        // If we did not find a match for consecutive numbers, call the method
        // again with count - 1 to move the index over and keep checking until
        // we reach the end of the array
        else
        {
            return recursiveHasConsecutives(list, count - 1);
        }
    }  
   
    public static void main(String[] args)
    {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);

        System.out.println("Smallest value in the array is " + 
                          list.getSmallest() );
        

        list.reverse();
        System.out.println("\nReversed:  " + list);
     
        System.out.println("The list " + 
                         (list.hasConsecutives() ? "has" : "does not have") +
                         " consecutive ints in consecutive elements") ;
    }
}
