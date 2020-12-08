package assignment.pkg6;


public class Term 
{
    private int coefficient;
    private int exponent;
    
    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
    public int getCoefficient() 
    {
        return coefficient;
    }

    public int getExponent() 
    {
        return exponent;
    }
    
    public void setCoefficient(int coefficient) 
    {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent) 
    {
        this.exponent = exponent;
    }
    
    @Override
    public String toString()
    {
        if(exponent == 1 && coefficient == 1)
        {
            return "x";
        }
        if(coefficient == 1)
        {
            return "x^" + exponent;
        }
        if(exponent == 1)
        {
            return coefficient + "x";
        }
        if(exponent == 0)
        {
            return "" + coefficient;
        }
        return "temp";
    }
}