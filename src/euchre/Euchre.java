package euchre;

import core.Game;
import userinterface.GameUi;
import javax.swing.JOptionPane;

public class Euchre 
{
    public static void main(String[] args) 
    {
        // outputting to the console
        System.out.println("Welcome to Euchre!");

        // this is a static method call ClassName.methodName()
        // do not need to create an instance of the class to use it
        JOptionPane.showMessageDialog(null, "Let's Play Euchre!"); 
        
        Game game = new Game();
        GameUi ui = new GameUi(game);
       
    }    
}
