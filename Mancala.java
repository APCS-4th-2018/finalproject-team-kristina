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
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
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
    protected Text[] count;
    protected Scene myScene;
    protected Stage myStage;
    protected Pane myRoot;
    protected final int BOARDSIZE = 14;
    protected final int PLAYER1 = 1;
    protected final int PLAYER2 = 2;
    protected int player;
    protected boolean won;

    /**
     * Constructor for objects of Mancala
     */
    public Mancala(Scene scene, Stage stage, Pane root)
    {
        //player = PLAYER1;
        player = PLAYER2;
        myScene = scene;
        myStage = stage;
        myRoot = root;
        board = new LinkedList[BOARDSIZE];
        count = new Text[BOARDSIZE];
        won = false;
        //for (int i = 0; i < BOARDSIZE; i++)
        //board[i] = new LinkedList();
        addButtons();
        for (int i = 1; i < BOARDSIZE; i++)
            if (i != 7)
                drawStones(i, 4);
        drawNumbers();
        //play();
        //initialize(1);
    }

    private void buttonClick1(ActionEvent event)
    {
        if (!won)
            move(1);
    }

    private void buttonClick2(ActionEvent event)
    {
        if (!won)
            move(2);
    }

    private void buttonClick3(ActionEvent event)
    {
        if (!won)
            move(3);
    }

    private void buttonClick4(ActionEvent event)
    {
        if (!won)
            move(4);
    }

    private void buttonClick5(ActionEvent event)
    {
        if (!won)
            move(5);
    }

    private void buttonClick6(ActionEvent event)
    {
        if (!won)
            move(6);
    }

    private void buttonClick8(ActionEvent event)
    {
        if (!won)
            move(8);
    }

    private void buttonClick9(ActionEvent event)
    {
        if (!won)
            move(9);
    }

    private void buttonClick10(ActionEvent event)
    {
        if (!won)
            move(10);
    }

    private void buttonClick11(ActionEvent event)
    {
        if (!won)
            move(11);
    }

    private void buttonClick12(ActionEvent event)
    {
        if (!won)
            move(12);
    }

    private void buttonClick13(ActionEvent event)
    {
        if (!won)
            move(13);
    }

    private void play()
    {
        
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
                btns[i].setVisible(true);
                myRoot.getChildren().add(btns[i]);
                btns[i].toFront();
                if (i == 1)
                    btns[i].setOnAction(this::buttonClick1);
                else if (i == 2)
                    btns[i].setOnAction(this::buttonClick2);
                else if (i == 3)
                    btns[i].setOnAction(this::buttonClick3);
                else if (i == 4)
                    btns[i].setOnAction(this::buttonClick4);
                else if (i == 5)
                    btns[i].setOnAction(this::buttonClick5);
                else if (i == 6)
                    btns[i].setOnAction(this::buttonClick6);
                else if (i == 8)
                    btns[i].setOnAction(this::buttonClick8);
                else if (i == 9)
                    btns[i].setOnAction(this::buttonClick9);
                else if (i == 10)
                    btns[i].setOnAction(this::buttonClick10);
                else if (i == 11)
                    btns[i].setOnAction(this::buttonClick11);
                else if (i == 12)
                    btns[i].setOnAction(this::buttonClick12);
                else if (i == 13)
                    btns[i].setOnAction(this::buttonClick13);
            }
        }
        //myStage.show();
    }

    private void drawStones(int num, int count)
    {
        if (board[num] != null)
            for (int i = 0; i < board[num].size(); i++)
                ((Stone)board[num].get(i)).setTransparent();      

        board[num] = new LinkedList();
        int x = setX(num);
        int y = setY(num);

        if (num == 0 || num == 7)
            y = y + 93;

        for (int i = 1; i <= count; i++)
        {
            Stone s = new Stone(num,x,y,myScene,myStage);
            board[num].add(s);
        }
        myStage.show();
    }

    private int setX(int i)
    {
        int x = 0;
        if (i == 0)
            x = 95;
        else if (i == 7)
            x = 880;
        else if (i == 1 || i == 13)
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
        if (i <= 7)
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
        int count = 1;
        int size = board[num].size();
        Group group = new Group();
        group.setAutoSizeChildren(false); 
        group.getChildren().add(myScene.getRoot());

        for(int i = 1; i <= size; i++)
        {
            int index = num + count % 13;
            if (board[index] == null)
                board[index] = new LinkedList();
            if (player == PLAYER1 && num+count == 7)
                i--;
            else if (player == PLAYER2 && num+count == 0)
                i--; 
            else
            {
                board[index].add(board[num].remove(0));
                drawStones(num, board[num].size());
                drawStones(index, board[index].size());
            }
            count++;
        }
        drawNumbers();
        if (player == PLAYER1)
            player = PLAYER2;
        else 
            player = PLAYER1;
        //isWon();
    }

    private void initialize(int num)
    {
        // Rectangle rectangle = new Rectangle(678, 185);

        // Path path = new Path();
        // MoveTo moveTo = new MoveTo(100,100);
        // path.getElements().add(moveTo);
        // Group group = new Group();
        // group.setAutoSizeChildren(false);
        // group.getChildren().add(myScene.getRoot());
        // for(int i = 0; i < board[num].size(); i++)
        // group.getChildren().add((Circle)board[num].get(i));
        // PathTransition transition = new PathTransition();
        // transition.setDuration(Duration.seconds(5));
        // transition.setNode(group);
        // transition.setPath(path);
        // transition.setCycleCount(1);
        // transition.setAutoReverse(false);
        // transition.play();
        // myScene.setRoot(group);
        // myStage.setScene(myScene);
        // myStage.show();

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
    public void isWon()
    {
        won = true;
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
        Group group = new Group();
        group.setAutoSizeChildren(false);
        group.getChildren().add(myScene.getRoot());
        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == null)
                board[i] = new LinkedList();
            int num = board[i].size();
            int x;
            int y;
            if (count[i] != null)
                count[i].setOpacity(0.0);
            count[i] = new Text(Integer.toString(num));
            if (i <= 7)
                y = setY(i) - 88;
            else 
                y = setY(i) + 107;
            x = setX(i) - 10;
            // if (i <= 7)
            // y = 335;
            // else
            // y = 715;
            // if (i == 0)
            // x = 95;
            // else if (i == 1 || i == 13)
            // x = 207;
            // else if (i == 2 || i == 12)
            // x = 322;
            // else if (i == 3 || i == 11)
            // x = 432;
            // else if (i == 4 || i == 10)
            // x = 542;
            // else if (i == 5 || i == 9)
            // x = 647;
            // else if (i == 6 || i == 8)
            // x = 762;
            // else
            // x = 880;
            count[i].setX(x);
            count[i].setY(y);
            count[i].setFont(Font.font("Monospaced", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));
            count[i].setFill(Color.WHITE);
            group.getChildren().add(count[i]);
        }
        myScene.setRoot(group);
        myStage.setScene(myScene);
        myStage.show();
    }
}
