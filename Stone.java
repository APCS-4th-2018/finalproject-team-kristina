
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
    private Circle myCircle;
    private int xLocation;
    private int yLocation;
    private Color myColor;
    private Scene myScene;
    private Stage myStage;
    private int num;
    private final int RADIUS = 15;

    /**
     * Constructor for objects of class Stone
     * 
     * @param x the x location of the stone
     * @param y the y location of the stone
     */
    public Stone(int n, int x, int y, Scene scene, Stage stage)
    {
        xLocation = x;
        yLocation = y;
        setColor();
        myScene = scene;
        myStage = stage;
        num = n;
        draw();
    }

    /**
     * Draws the stone
     *
     * @param  y  a sample parameter for a method
     */
    public void draw()
    {
        //Circle circle = new Circle(RADIUS);
        myCircle = new Circle(RADIUS, myColor);
        int x = 0;
        int y = 0;
        if (num != 0 && num != 7)
        {
            x = 25-(int)(Math.random()*50);
            y = 25-(int)(Math.random()*50);
        }
        else
        {
            x = 100-(int)(Math.random()*200);
            y = 500-(int)(Math.random()*1000);
        }
        myCircle.setCenterX(xLocation + x);
        myCircle.setCenterY(yLocation + y);

        Group group = new Group();
        group.setAutoSizeChildren(false); 
        group.getChildren().add(myScene.getRoot());

        group.getChildren().add(myCircle);
        myScene.setRoot(group);
        myStage.setScene(myScene);
        myStage.show();
    }

    private void setColor()
    {
        int rand = (int) (Math.random() * 8)+1;
        if (rand == 1)
            myColor = Color.WHITE;
        else if (rand == 2)
            myColor = Color.RED;
        else if (rand == 3)
            myColor = Color.ORANGE;
        else if (rand == 4)
            myColor = Color.YELLOW;
        else if (rand == 5)
            myColor = Color.GREEN;
        else if (rand == 6)
            myColor = Color.DODGERBLUE;
        else if (rand == 7)
            myColor = Color.MEDIUMPURPLE;
        else
            myColor = Color.PALEVIOLETRED;
    }

    public Circle getCircle()
    {
        return myCircle;
    }

    public void setTransparent()
    {
        myColor = Color.TRANSPARENT;
        myCircle.setVisible(false);
        draw();
    }
}
