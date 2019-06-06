import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 
/**
 * The Capture mode of the mancala game
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Capture extends Mancala
{
    /**
     *  Constructor for the Capture object
     *  
     *  @param scene
     *  @param stage
     *  @param root
     *  @author Kristina Lansang
     */
    public Capture(Scene scene, Stage stage, Pane root)
    {
        super(scene, stage, root);
    }

    /**
     *  Helper method for when stones are captured
     *  
     *  @param num number of the pit clicked on
     *  @param next number of the pit where the last stone lands
     *  @author Kristina Lansang
     */
    private void captured(int num, int next)
    {
        //declare variables
        int size, across, diff, originalSize;
        across = 13 - next + 1;//finds the location of the pit across
        //if you're on player 1 and you end in a player 1 pit...
        if(player == PLAYER1 && next >= 1 && next <= 6 && !board[across].isEmpty())
        {
            originalSize = board[7].size();//get the size of the big pits
            board[7].add(board[next].remove(0));//add the last stone dropped
            size = board[across].size();//get the original size of the pit across
            for(int i = 0; i < size; i++)//traverse the pit across to remove them and add them to end pit
                board[7].add(board[across].remove(0));
            drawStones(7, size + 1 + originalSize);//redraws the stones in the end pit
        }
        else if(player == PLAYER2 && next >= 8 && next <= 13 && !board[across].isEmpty())//otherwise if you're player 2 and end in a player 2 pit
        {
            originalSize = board[0].size();//get the size of the big pit of the player
            board[0].add(board[next].remove(0));//add the last stone dropped
            size = board[across].size();//get the original size of the pit across
            for(int i = 0; i < size; i++)//traverse the pit across to remove them and add them to the end pit
                board[0].add(board[across].remove(0));
            drawStones(0, size + 1 + originalSize);//redraws the stones in the end pit
        }
    }

    /**
     *  Move method specifically for capture game type (how the stones move)
     *  
     *  @param num location of the pit clicked on
     *  @author Kristina Lansang
     */
    public void move(int num)
    {
        int next = (num + board[num].size()) % 14;
        super.move(num);
        if(board[next].size() == 1)//if where you end up in an empty pit
        {
            captured(num, next);
            drawNumbers();
        }
        switchPlayers();//switches what player going
        showPlayer();
        hideButtons();
        isWon();
    }
    
        /**
     * finds the winner
     * 
     * @author Helen Xu
     */
    protected int findWinner(int num)
    {
        //declare variables
        int winner = 0;
        int start, end, own;

        if (num == 1)
        {
            start = 8;
            end = 13;
            own = 7;
        }
        else 
        {
            start = 1; 
            end = 6;
            own = 0;
        }

        //adds remaining pieces to your own
        for (int i = start; i <= end; i++)
            if (board[i] != null)
                while (board[i].size() != 0)
                    board[own].add(board[i].remove(0));

        //tallies total marble in each side
        int count1 = board[7].size();
        int count2 = board[0].size();

        //determines the winner based on who had more stones
        if (count1 > count2)
            winner = PLAYER1;
        else if (count2 > count1)
            winner = PLAYER2;

        return winner;
    }
}
