import javafx.scene.paint.Color;
/**
 * Represents a stone of the mancala game
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Stone
{
    // instance variables 
    private int xLocation;
    private int yLocation;
    private Color myColor;

    /**
     * Constructor for objects of class Stone
     * 
     * @param x the x location of the stone
     * @param y the y location of the stone
     */
    public Stone(int x, int y)
    {
        xLocation = x;
        yLocation = y;
        setColor();
    }

    /**
     * Draws the stone
     *
     * @param  y  a sample parameter for a method
     */
    public void draw()
    {
        //something javafx or scenebuilder
    }
    
    private void setColor()
    {
        //randomizes the color to be blue, black, or white
        int rand = (int) (Math.random() * 2);
        if(rand == 0)
            myColor = Color.BLUE;
        else 
            if(rand == 1)
                myColor = Color.BLACK;
            else
                myColor = Color.WHITE;
    }
}
