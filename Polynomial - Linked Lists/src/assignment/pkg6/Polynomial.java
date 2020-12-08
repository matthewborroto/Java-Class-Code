package assignment.pkg6;

/**
 * A class to create, add, and multiply polynomials. A polynomial is defined
 * as a sum of terms where each term has variable x, an int coefficient, and
 * a nonnegative int exponent
 */
public class Polynomial
{
    private Node head ;   // points to the first Node of a Polynomial

    /**
     * Default constructor creates a Polynomial with no terms
     */
    public Polynomial()  // DO NOT MODIFY THIS CONSTRUCTOR
    {
        head = null ;
    }
   
    /**
     * "Copy" constructor. Creates a "deep copy" of a given Polynomial. 
     * I.e. a new Polynomial with identical terms
     * @param p the Polynomial to be copied
     */
    public Polynomial(Polynomial p) 
    {
        Polynomial copy = new Polynomial(p);
    }
   
   
   
   
    /**
     * Creates a new Term and Node containing it and inserts it in its proper
     * place in this Polynomial (i.e. in ascending order by exponent) 
     * @param coeff the coefficient of the new Term
     * @param expo the exponent of the new Term
     */
    public void addTerm(int coeff, int expo)
    {
        Term term = new Term(coeff, expo);
        Node node = new Node(term);
        
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = new Node(term);
            temp = head;
            
            while(head.info.getExponent() <= node.info.getExponent() && head.next != null)
            {
                head = head.next;
            }
            node.next = head.next;
            head = temp;
            head.next = node;
        }
    }      
  

    /**
     * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
     * @return the polynomial as a String
     */
    @Override
    public String toString()
    {   
        String output = "";
        
        
        output += head.info.toString();
        while(head.next != null)
        {
            output += " + ";
            head = head.next;
            output += head.info.toString();
        }
        return output;
    }
   
    // collect terms of a Polynomial object. I.e. replace all terms having the 
    // same exponent with a single term which is their sum
    private void collectTerms()
    {
        while(head.next != null)
        {
            //check if the next term has the same exponent as the head
            if(head.info.getExponent() == head.next.info.getExponent())
            {
                //if the exponents match
                //add the coeffients together and save them in the "head"
                head.info.setCoefficient(head.info.getCoefficient() + head.next.info.getCoefficient());
                
                //update the head.next to be the one after, head.next.next
                head.next = head.next.next;
            } 
        }    
    }
   
    /**
     * Multiply this Polynomial by another Polynomial
     * @param p the other Polynomial
     * @return the product of the two Polynomials
     */
    public Polynomial polyMultiply(Polynomial p)
    {
        
        
        
        
        
        
        
        
        
        // temporary return so class skeleton will compile and run
        return null ;
    }
   
    /**
     * Add this Polynomial and another Polynomial
     * @param p the other Polynomial
     * @return the sum of the two Polynomials
     */
    public Polynomial polyAdd(Polynomial p)
    {      
        
        
        
        
        
        
        
        
        
        
        
        // temporary return so class skeleton will compile and run
        return null ;
    }
   
    // Node class definition - DO NOT MODIFY!
    class Node <E extends Term>
    {
        private E info ;     // each node stores an object of the 
                             // type-parameter class...
        private Node next ;  // ...and a pointer to another node

        // Node Constructor 
        // parameter x is an object of the type-parameter class
        Node(E x)         
        {
            info = x;           // set info portion to parameter passed
            next = null;	// not pointing to another Node yet
        }
    } // end of Node class definition ============================
} // end of Polynomial class definition =========================