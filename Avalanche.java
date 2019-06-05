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
     * 
     * @param scene
     * @param stage
     * @param root
     */
    public Avalanche(Scene scene, Stage stage, Pane root)
    {
       //calls the parent constructor
       super(scene, stage, root);
    }

    /**
     * Moves the stones that are clicked on
     * 
     * @param num the location of the stone that is clicked on
     */
    public void move(int num)
    {
        //finds pit where last stone is
        int next = (num + board[num].size()) % 14;
        
        //move normally
        super.move(num);

        //if the last stone falls on a pit that has stones
        while(!isEmpty(next))
        {
            num = next;
            next = (next + board[num].size()) % 14;
            
            //continue moving
            super.move(num);
        }
        
        //switches turns
        switchPlayers();
        
        //shows whose turn it is
        showPlayer();
        
        //hides the buttons on the other player's size
        hideButtons();
        
        //check if anyone won
        isWon();
    }
}
