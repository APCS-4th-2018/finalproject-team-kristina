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
 * The Avalanche mode of the mancala game
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Avalanche extends Mancala
{
    @Override
    public void start(Stage stage) throws Exception
    {
        
    }
    /**
     * Constructor for objects of class Avalanche
     */
    public Avalanche(Scene scene, Stage stage, Pane root)
    {
        
       super(scene, stage, root);
    }

    /**
     * Moves the stones that are clicked on
     * 
     * @param num the location of the stone that is clicked on
     */
    public void move(int num)
    {
        //super.move();//move normally
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
    
}
