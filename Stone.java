import javafx.scene.paint.Color;
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
import javafx.scene.shape.Circle;
import javafx.scene.Group;
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
    private Scene myScene;
    private Stage myStage;
    private final int RADIUS = 15;

    /**
     * Constructor for objects of class Stone
     * 
     * @param x the x location of the stone
     * @param y the y location of the stone
     */
    public Stone(int x, int y, Scene scene, Stage stage)
    {
        xLocation = x;
        yLocation = y;
        setColor();
        myScene = scene;
        myStage = stage;
        draw();
    }

    /**
     * Draws the stone
     *
     * @param  y  a sample parameter for a method
     */
    public void draw()
    {
        Circle circle = new Circle(RADIUS, myColor);
        int x = (int)(Math.random()*35);
        int y = (int)(Math.random()*35);
        circle.setCenterX(xLocation + x);
        circle.setCenterY(yLocation + y);
        Group group = new Group();
        group.setAutoSizeChildren(false); 
        group.getChildren().add(myScene.getRoot());
        
        group.getChildren().add(circle);
        circle.toFront();
        myScene.setRoot(group);
        myStage.setScene(myScene);
        myStage.show();
    }
    
    private void setColor()
    {
        //randomizes the color to be blue, black, or white
        int rand = (int) (Math.random() * 3);
        if(rand == 0)
            myColor = Color.BLUE;
        else 
            if(rand == 1)
                myColor = Color.BLACK;
            else
                myColor = Color.WHITE;
    }
}
