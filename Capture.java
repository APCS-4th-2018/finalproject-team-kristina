import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 
/**
 * Specific methods for the game type Capture of Mancala.
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Capture extends Mancala
{
    /**
     *  Constructor for the Capture object
     */
    public Capture(Scene scene, Stage stage, Pane root)
    {
        super(scene, stage, root);
    }

    /**
     *  Helper method for when stones are captured
     */
    private void captured()
    {
    }

    /**
     *  Move method specifically for capture game type (how the stones move)
     */
    public void move(int num)
    {
        int next = (num + board[num].size()) % 14;
        int size, across, diff;
        super.move(num);
        size = board[next].size();
        //hello if you're looking at this know that it doesn't capture all the stones from the opposite pit for some reason
        if(board[next].size() == 1)//if where you end up in an empty pit
        {
            if(player == PLAYER1)
            {
                board[0].add(board[next].remove(0));
                drawStones(0, 1);
                across = 13 - next + 1;
                for(int i = 0; i < board[across].size(); i++)
                    board[0].add(board[across].remove(i));
                drawStones(0, board[across].size());
            }
            else
            {
                board[7].add(board[next].remove(0));
                drawStones(7, 1);
                across = 13 - next + 1;
                for(int i = 0; i < board[across].size(); i++)
                    board[7].add(board[across].remove(i));
                drawStones(7, board[across].size());
            }
            drawNumbers();
            isWon();
        }

    }
    /**
     *  Returns whether the user has won or lost in Capture mode.
     *
     * @return    The true or false depending on win or lose
     */
    //public boolean isWon()
    //{
    //return false;
    //}

}
