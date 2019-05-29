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
    public void move()
    {
    }

    /**
     *  Returns whether the user has won or lost in Capture mode.
     *
     * @return    The true or false depending on win or lose
     */
    public boolean isWon()
    {
        return false;
    }

}
