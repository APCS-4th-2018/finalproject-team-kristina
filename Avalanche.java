import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane; 
/**
 * The Avalanche mode of the mancala game
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Avalanche extends Mancala
{
    /**
     * Constructor for objects of class Avalanche
     */
    public Avalanche(Scene scene, Stage stage, Pane root)
    {
       super(scene, stage, root);
    }

    /**
     * Moves the stones that are clicked on
     * 
     * @param num the location of the stone that is clicked on
     */
    public void move(int num)
    {
        int next = (num + board[num].size()) % 14;
        super.move(num);//move normally

        while(!isEmpty(next))
        {
            num = next;
            next = (next + board[num].size()) % 14;
            //super.switchPlayers();//keep it on the same player
            super.move(num);//continue moving if there are stones there
            
        }
        switchPlayers();
        showPlayer();
        hideButtons();
        isWon();
    }
    
    /**
     * Determines whether the game is won yet
     * 
     * @return true if the game is won, false if not
     */
   // public boolean isWon()
    //{
       // return true;
    //}
    
}
