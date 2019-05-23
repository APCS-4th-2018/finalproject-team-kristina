
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
    public Avalanche()
    {
       
    }

    /**
     * Moves the stones that are clicked on
     * 
     * @param num the location of the stone that is clicked on
     */
    public void move(int num)
    {
        super.move();//move normally
        /*if(!isEmpty(some int))
            super.move();//continue moving if there are stones there*/
    }
    
    /**
     * Determines whether the game is won yet
     * 
     * @return true if the game is won, false if not
     */
    public boolean isWon()
    {
        return true;
    }
    
    /**
     * Fills the background with a certain color
     */
    public void fillBackground()
    {
    }
}
