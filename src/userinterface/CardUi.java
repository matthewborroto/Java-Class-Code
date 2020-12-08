package userinterface;

import constants.Constants.Face;
import constants.Constants.Suit;
import core.Card;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class CardUi 
{
    private Card card;
    private ImageIcon imageIcon;
    private JButton button;
    private JLabel label;
    private int position;
        
    public CardUi(Card card, JButton button)
    {
        this.card = card;
        this.button = button;
        
        selectFrontImage(this.button);
    }
    
    public CardUi(Card card, JLabel label, int position)
    {
        this.card = card;
        this.label = label;
        this.position = position;
        
        if(position == 1 || position == 3)
            selectVerticalBackImage();
        else
            selectHorizontalBackImage();
    }

    public CardUi(Card card, JLabel label)
    {
        this.card = card;
        this.label = label;
        
        selectFrontImage(this.label);
    }

    public CardUi(JLabel label)
    {
        this.label = label;
        
        selectHorizontalBackImage();
    }

    public CardUi(JLabel label, Face face, Suit suit)
    {
        this.label = label;
        Card card = new Card();
        card.setFace(face);
        card.setSuit(suit);
        this.card = card;
        selectFrontImage(label);
    }
    
    private void selectFrontImage(JComponent component)
    {
        String fileName = "../images/";
        
        switch(card.getFace())
        {
            case ACE:
                fileName += "Ace";
                break;
            case NINE:
                fileName += "Nine";
                break;
            case TEN:
                fileName += "Ten";
                break;
            case JACK:
                fileName += "Jack";
                break;
            case QUEEN:
                fileName += "Queen";        
                break;
            case KING:
                fileName += "King";             
        }
        
        switch(card.getSuit())
        {
            case CLUBS:
                fileName += "Clubs";
                break;
            case HEARTS:
                fileName += "Hearts";
                break;
            case DIAMONDS:
                fileName += "Diamonds";
                break;
            case SPADES:
                fileName += "Spades";
        }
        
        fileName += ".png";
        
        //System.out.println("image file name is " + fileName);
        try
        {
            URL imgURL = getClass().getResource(fileName);
            //System.out.println("image file name is " + fileName);
            if(imgURL != null)
            {        
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeHorizontal(imageIcon);
            }
        
            if(component instanceof JLabel)
                label = new JLabel(imageIcon);
            else
                button = new JButton(imageIcon);        
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;            
        }
    }
    
    private void selectVerticalBackImage()
    {
        String fileName = "../images/backVertical.jpg";
        
        try
        {
            URL imgURL = getClass().getResource(fileName);

            //System.out.println("image file name is " + fileName);
            if(imgURL != null)
            {
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeVertical(imageIcon);
                label = new JLabel(imageIcon);    
            }
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
    }
    
    private void selectHorizontalBackImage()
    {
        String fileName = "../images/backHorizontal.jpg";
        try
        {
            URL imgURL = getClass().getResource(fileName);
            if(imgURL != null)
            {        
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeHorizontal(imageIcon);
                label = new JLabel(imageIcon);    
            }
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
    }

    private ImageIcon imageResizeHorizontal(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }   

    private ImageIcon imageResizeVertical(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }  
    
    public JButton getButton() 
    {
        return button;
    }
    
    public JLabel getLabel() 
    {
        return label;
    }
}
