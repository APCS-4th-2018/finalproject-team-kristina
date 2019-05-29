import java.util.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 
import javafx.scene.Group;
import javafx.scene.shape.Circle;
//import javafx.scene.text.TextFlow;
import javafx.scene.control.Label;
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
    protected Scene myScene;
    protected Stage myStage;
    protected Pane myRoot;

    /**
     * Constructor for objects of Mancala
     */
    public Mancala(Scene scene, Stage stage, Pane root)
    {
        myScene = scene;
        myStage = stage;
        myRoot = root;
        board = new LinkedList[14];
        for (int i = 0; i<board.length;i++)
            board[i] = new LinkedList();
        drawStones();
        drawNumbers();
        addButtons();

    }

    private void addButtons()
    {
        Button[] btns = new Button[14];
        for(int i = 1; i < 14; i++)//skips 0 and 7
        {
            if (i != 7)
            {
                btns[i] = new Button();
                btns[i].setShape(new Circle(50));
                btns[i].setLayoutX(setX(i)-50);
                btns[i].setLayoutY(setY(i)-50);
                btns[i].setMinSize(100,100);
                btns[i].toFront();
                myRoot.getChildren().add(btns[i]);
            }
        }

        myStage.setScene(new Scene(myScene.getRoot()));
        myStage.show();
    }

    private void drawStones()
    {
        int[] xy = new int[2];
        for (int i = 1; i < board.length; i++)
        {
            int x = setX(i);
            int y = setY(i);
            if (i != 7)
            {
                for (int num = 1; num <= 4; num++)
                {
                    board[i].add(new Stone(x,y,myScene,myStage));
                }
            }
        }

    }

    private int setX(int i)
    {
        int x = 0;
        if (i == 1 || i == 13)
            x = 219;
        else if (i == 2 || i == 12)
            x = 331;
        else if (i == 3 || i == 11)
            x = 440;
        else if (i == 4 || i == 10)
            x = 552;
        else if (i == 5 || i == 9)
            x = 660;
        else if (i == 6 || i == 8)
            x = 773;

        return x;
    }

    private int setY(int i)
    {
        int y = 0;
        if (i <= 6 )
            y = 423;
        else
            y = 608;
        return y;
    }

    /**
     * Moves the stones that are clicked on
     * 
     * @param num  location user clicked
     */
    public void move(int num)
    {

    }

    /**
     * Returns true if a location on the board is empty
     * 
     * @param num  location to check
     * @return true/false
     */
    public boolean isEmpty(int num)
    {
        boolean empty = false;
        if (board[num].size() == 0)
            empty = true;
        return empty;
    }

    /**
     * Determines whether the game is won yet
     * 
     * @return true if the game is won, false if not
     */
    public boolean isWon()
    {
        boolean won = true;
        return won;
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
            int x;
            int y;
            Text text = new Text(Integer.toString(num));
            if (i <= 7)
                y = 335;
            else
                y = 715;
            if (i == 0)
                x = 100;
            else if (i == 1 || i == 13)
                x = 215;
            else if (i == 2 || i == 12)
                x = 330;
            else if (i == 3 || i == 11)
                x = 440;
            else if (i == 4 || i == 10)
                x = 550;
            else if (i == 5 || i == 9)
                x = 655;
            else if (i == 6 || i == 8)
                x = 770;
            else
                x = 885;

            text.setX(x);
            text.setY(y);
            text.setFont(Font.font("Monospaced", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));
            text.setFill(Color.WHITE);
            Group group = new Group();
            group.setAutoSizeChildren(false);
            group.getChildren().add(myScene.getRoot());
            group.getChildren().add(text);

            text.toFront();
            myScene.setRoot(group);
            myStage.setScene(myScene);
            myStage.show();
        }
    }
}
