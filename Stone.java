
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
    private int xLocation; //x coordinate
    private int yLocation; //y coordinate
    private Color myColor;
    private Scene myScene;
    private Stage myStage;
    private int num;
    private final int RADIUS = 15; //radius of stone

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
        int x = 0; //set initial x location to 0
        int y = 0; //set initial y location to 0
        if (num != 0 && num != 7) //if num is not 0 and is not theh 7th pit
        {
            x = 25-(int)(Math.random()*50);
            y = 25-(int)(Math.random()*50);
        }
        else
        {
            x = 50-(int)(Math.random()*100);
            y = 150-(int)(Math.random()*300);
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
        //declare and instantiate variable
        int rand = (int) (Math.random() * 8)+1; //finds random number
        if (rand == 1) //if rand is one set stone to white
            myColor = Color.WHITE;
        else if (rand == 2) //if rand is two set stone to red
            myColor = Color.RED;
        else if (rand == 3) //if rand is three set stone to orange
            myColor = Color.ORANGE;
        else if (rand == 4) //if rand is four set stone to yellow
            myColor = Color.YELLOW;
        else if (rand == 5) //if rand is five set stone to green
            myColor = Color.GREEN;
        else if (rand == 6) //if rand is six set stone to dodger blue
            myColor = Color.DODGERBLUE;
        else if (rand == 7) //if rand is seven set stone to medium purple
            myColor = Color.MEDIUMPURPLE;
        else //else if none of those, set stone to pale violet red
            myColor = Color.PALEVIOLETRED;
    }

    /**
     * Gets the circle from Stone object
     *
     * @return myCircle the stone
     */ 
    public Circle getCircle()
    {
        return myCircle; //returns myCricle Circle object
    }

    /**
     * Erases stone by setting color to transparent and making invisable.
     */ 
    public void setTransparent()
    {
        myColor = Color.TRANSPARENT; //sets stone color to transparent
        myCircle.setVisible(false); //sets visibility to false
        draw(); //draws the erased stone
    }
}
