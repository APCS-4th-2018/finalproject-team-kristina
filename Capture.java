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
        int size, across, diff, originalSize;
        super.move(num);
        //hello if you're looking at this know that it doesn't capture all the stones from the opposite pit for some reason
        if(board[next].size() == 1)//if where you end up in an empty pit
        {
            //super.switchPlayers();//keep on the same player
            if(player == PLAYER1 && next >= 1 && next <= 6)
            {
                originalSize = board[0].size();
                board[0].add(board[next].remove(0));
                across = 13 - next + 1;
                size = board[across].size();
                for(int i = 0; i < size; i++)
                    board[0].add(board[across].remove(0));
                drawStones(0, size + 1 + originalSize);
            }
            else if(player == PLAYER2)
            {
                originalSize = board[7].size();
                board[7].add(board[next].remove(0));
                drawStones(7, 1);
                across = 13 - next + 1;
                size = board[across].size();
                for(int i = 0; i < size; i++)
                    board[7].add(board[across].remove(0));
                drawStones(7, size + 1 + originalSize);
            }
            drawNumbers();
            //isWon();
            //super.switchPlayers();//switchs back
        }
        switchPlayers();//switches what player going
        showPlayer();
        isWon();
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
