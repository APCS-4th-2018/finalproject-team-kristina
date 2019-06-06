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
    private final int RADIUS = 15; //radius of stone
    private Scene myScene;
    private Circle myCircle;
    private int xLocation; //x coordinate
    private int yLocation; //y coordinate
    private Color myColor; //color of the stone
    private int num; //number of the pit
    private Group group;
    

    /**
     * Constructor for objects of class Stone
     * 
     * @param n the number of the pit it is in
     * @param x the x location of the stone
     * @param y the y location of the stone
     * @param scene
     * @author Helen Xu
     */
    public Stone(int n, int x, int y, Scene scene, Group g)
    {
        xLocation = x;
        yLocation = y;
        setColor();
        myScene = scene;
        num = n;
        group = g;
        draw();
    }

    /**
     * Draws the stone
     *
     * @param  y  a sample parameter for a method
     * @author Helen Xu
     */
    public void draw()
    {
        myCircle = new Circle(RADIUS, myColor);
        int x = 0; //set initial x location to 0
        int y = 0; //set initial y location to 0
        
        //if not in the two big pits
        if (num != 0 && num != 7) 
        {
            //slightly randomizes locations so stones are not directly on top of each other
            x = 20-(int)(Math.random()*40);
            y = 25-(int)(Math.random()*50);
        }
        else
        {
            //slightly randomizes locations so stones are not directly on top of each other
            x = 20-(int)(Math.random()*40);
            y = 100-(int)(Math.random()*200);
        }
        
        //sets center of the circle
        myCircle.setCenterX(xLocation + x);
        myCircle.setCenterY(yLocation + y);

        //add myCircle to group
        group.getChildren().add(myCircle);
        myScene.setRoot(group);
    }

    //chooses random color
    /**
     * method sets the color of each stone 
     * 
     * @author Kristina Lansang
     */
    private void setColor()
    {
        //finds random number
        int rand = (int) (Math.random() * 8)+1; 
        
        if (rand == 1) //if rand is one set stone to white
            myColor = Color.DARKGRAY;
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
     * Returns the circle
     * 
     * @return circle
     * @author Helen Xu
     */
    public Circle getCircle()
    {
        return myCircle;
    }
}
