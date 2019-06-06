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
     * @author Kristina Lansang
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
     * @author Kristina Lansang
     */
    public void move(int num)
    {
        //finds pit where last stone is
        int next = (num + board[num].size()) % 14;
        
        //move normally
        super.move(num);

        //if the last stone falls on a pit that has stones
        while(board[next].size() != 1 && next != 0 && next != 7)
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
    
    /**
     * find out who the winner of the game is
     * 
     * @param num the side that emptied all the pits
     * @author Kristina Lansang
     */
    protected int findWinner(int num)
    {
        int winner = 0;
        if(board[0].size() > board[7].size())
            winner = PLAYER2;
        else if(board[0].size() < board[7].size())
            winner = PLAYER1;
            
        return winner;
    }
}
