package core;

import constants.Constants.Face;
import static constants.Constants.MIN_TRUMP;
import constants.Constants.Suit;
import javax.swing.JOptionPane;

public class AiPlayer extends Player
{ 

    private Game game;
    
    @Override
    public Card playCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void makeTrump() 
    {
       if(game.getTrumpCheck() == 3)
       {
           JOptionPane.showMessageDialog(null, this.getName() + " needs to accept trump");
           setAcceptTrump(true);
       }
       else
       {
           int numberOfTrumpCards = 0;
           for(Card card : this.getHand())
           {
               if(card.getSuit() == game.getTrump().getSuit())
               {
                   numberOfTrumpCards++;  
               }
           }
           
           if(numberOfTrumpCards >= MIN_TRUMP)
            {
                setAcceptTrump(true);
                JOptionPane.showMessageDialog(null, this.getName() + " picks it up!");
            }
            else
            {
                setAcceptTrump(false);
                JOptionPane.showMessageDialog(null, this.getName() + " says ''Pass'' ");
            }
        }
    }
    
    public void setGame(Game game) 
    {
        this.game = game;
    }
}
