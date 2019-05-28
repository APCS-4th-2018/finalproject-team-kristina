import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
/**
 * Specific methods for the game type Capture of Mancala.
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Capture extends Mancala
{
    @Override
    public void start(Stage stage) throws Exception
    {
        
    }
    /**
     *  Constructor for the Capture object
     */
    public Capture(Scene scene, Stage stage)
    {
        super(scene, stage);
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
