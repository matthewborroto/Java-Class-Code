package core;

import constants.Constants.Face;
import constants.Constants.Suit;
import javax.swing.JOptionPane;

public class HumanPlayer extends Player 
{

    
    private Game game;

    
    
    @Override
    public Card playCard() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void makeTrump() 
    {
        if(game.getTrumpCheck() == 3)
        {
            JOptionPane.showMessageDialog(null, "Sorry " + this.getName() + ", you need to accept the trump suit");
            setAcceptTrump(true);
        }
        else
        {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to accept the Trump Suit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if(response == JOptionPane.YES_OPTION)
            {
                setAcceptTrump(true);
            }
            else
            {
                setAcceptTrump(false);
            }
        }
    }  
    
    public void setGame(Game game) 
    {
        this.game = game;
    }
}
