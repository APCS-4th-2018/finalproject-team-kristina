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
     */
    private void captured(int num, int next)
    {
        //declare variables
        int size, across, diff, originalSize;
        
        //if you're on player 1 and you end in a player 1 pit...
        if(player == PLAYER1 && next >= 1 && next <= 6)
        {
            originalSize = board[7].size();//get the size of the big pits
            board[7].add(board[next].remove(0));//add the last stone dropped
            across = 13 - next + 1;//finds the location of the pit across
            size = board[across].size();//get the original size of the pit across
            for(int i = 0; i < size; i++)//traverse the pit across to remove them and add them to end pit
                board[7].add(board[across].remove(0));
            drawStones(7, size + 1 + originalSize);//redraws the stones in the end pit
        }
        else if(player == PLAYER2 && next >= 8 && next <= 13)//otherwise if you're player 2 and end in a player 2 pit
        {
            originalSize = board[0].size();//get the size of the big pit of the player
            board[0].add(board[next].remove(0));//add the last stone dropped
            across = 13 - next + 1;//finds the location of the pic 
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
     */
    public void move(int num)
    {
        //int next = (num + board[num].size()) % 14;
        //int size, across, diff, originalSize;
        int next = (num + board[num].size()) % 14;
        super.move(num);
        if(board[next].size() == 1)//if where you end up in an empty pit
        {
            //super.switchPlayers();//keep on the same player
            // if(player == PLAYER1 && next >= 1 && next <= 6)
            // {
            // originalSize = board[0].size();
            // board[0].add(board[next].remove(0));
            // across = 13 - next + 1;
            // size = board[across].size();
            // for(int i = 0; i < size; i++)
            // board[0].add(board[across].remove(0));
            // drawStones(0, size + 1 + originalSize);
            // }
            // else if(player == PLAYER2)
            // {
            // originalSize = board[7].size();
            // board[7].add(board[next].remove(0));
            // drawStones(7, 1);
            // across = 13 - next + 1;
            // size = board[across].size();
            // for(int i = 0; i < size; i++)
            // board[7].add(board[across].remove(0));
            // drawStones(7, size + 1 + originalSize);
            // }
            captured(num, next);
            drawNumbers();
            //isWon();
            //super.switchPlayers();//switchs back
        }
        switchPlayers();//switches what player going
        showPlayer();
        hideButtons();
        isWon();
    }
}
