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
    protected LinkedList[] board;  //Mancala board
    
    /**
     * Constructor for objects of Mancala
     */
    public Mancala()
    {
        board = new LinkedList[14];
        for (int i = 1; i < board.length-1; i++)
        {
            for (int num = 1; num <= 4; num++)
            {
                //board[i].add(new Stone());
            }
        }
    }

    /**
     * 
     */
    public void move()
    {
        
    }
    
    /**
     * 
     */
    public boolean isWon()
    {
        boolean won = true;
        return won;
    }
    
    /**
     * The color of the background (depends on the type of Mancala)
     */
    public abstract void fillBackground();
    
    /**
     * Draws the board 
     */
    public void drawBoard()
    {
        
    }
    
    //draws the stones in each pit
    private void drawStones(int location)
    {
        
    }
    
    /**
     * Prints out the number of stones in each pit
     */
    
    public void drawNumbers()
    {
        for (int i = 0; i < board.length; i++)
        {
            int num = board[i].size();
            
        }
    }
}
