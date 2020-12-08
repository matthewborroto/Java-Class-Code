package core;

import constants.Constants.Color;
import constants.Constants.Face;
import constants.Constants.Suit;

public class Card
{
    // member variables
    private Face face;
    private Suit suit;
    private Color color;

    public int hashCode()
    {
        int hashcode = 0;
        
        hashcode += face.hashCode();
        hashcode += suit.hashCode();
        hashcode += color.hashCode();
        
        return hashcode;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Card) 
        {
            Card card = (Card) obj;
            // comparing the currently created new Card to each element
            // that is already in the HashSet referencing it via keyword this
            return (card.face.equals(this.face) && 
                    card.color.equals(this.color) &&  
                    card.suit.equals(this.suit));
        } 
        else 
        {
            return false;
        }
    }

    public Face getFace() 
    {
        return face;
    }

    public void setFace(Face face) 
    {
        this.face = face;
    }

    public Suit getSuit() 
    {
        return suit;
    }

    public void setSuit(Suit suit) 
    {
        this.suit = suit;
    }

    public Color getColor() 
    {
        return color;
    }

    public void setColor(Color color) 
    {
        this.color = color;
    }
}
