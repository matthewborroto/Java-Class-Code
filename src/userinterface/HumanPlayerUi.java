package userinterface;

import core.HumanPlayer;
import core.Player;
import constants.Constants;
import constants.Constants.Suit;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HumanPlayerUi extends JPanel
{
    private HumanPlayer human;
    private ArrayList<JButton> cards;
    private CardUi cardUi;
    private Suit suit;
    private GameUi gameUi;
    
    public HumanPlayerUi(Player player, GameUi gameUi)
    {
        human = (HumanPlayer)player;
        human.setUi(gameUi);
        
        initComponents();
    }
    
    private void initComponents()
    {
        this.setBorder(BorderFactory.createTitledBorder(human.getName()));
        this.setMinimumSize(new Dimension(250, 150));
        this.setPreferredSize(new Dimension(250, 150));
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        displayCards();
    }
    
    private void displayCards()
    {                        
        cards = new ArrayList<JButton>();

        for(int c = 0; c < Constants.CARDS_EACH; c++)
        {
            // instantiate the JButton
            JButton card = new JButton();
            card.setMinimumSize(new Dimension(60,100));
            card.setPreferredSize(new Dimension(60,100));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cardUi = new CardUi(human.getHand().get(c), card);
            card = cardUi.getButton(); 

            // add clientProperties
            card.putClientProperty("position", c);
            card.putClientProperty("face", human.getHand().get(c).getFace());
            card.putClientProperty("suit", human.getHand().get(c).getSuit());
            // register an ActionListener
            
            // add the object to the the ArrayList and UI
            cards.add(card);
            
            for(JButton button : cards)
                this.add(button);
        }
    }
}
