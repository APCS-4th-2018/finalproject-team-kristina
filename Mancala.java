import java.util.*;
/**
 * Generalized game of Mancala
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public abstract class Mancala
{
    // instance variable
    protected LinkedList[][] board;  //Mancala board
    
    /**
     * Constructor for objects of Mancala
     */
    public Mancala()
    {
        board = new LinkedList[8][2];
        for (int r = 1; r < board.length-1; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
                for (int i = 1; i <= 4; i++)
                {
                    //board[r][c].add(new Stone());
                }
            }
        }
    }

    
}
