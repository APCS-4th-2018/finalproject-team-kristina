import java.util.LinkedList;
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
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    protected Text[]  players;
    protected Text turn;

    /**
     * Constructor for objects of Mancala
     */
    public Mancala(Scene scene, Stage stage, Pane root)
    {
        player = PLAYER1;
        myScene = scene;
        myStage = stage;
        myRoot = root;
        board = new LinkedList[BOARDSIZE];
        count = new Text[BOARDSIZE];
        players = new Text[2];
        won = false;
        addButtons();
        for (int i = 1; i < BOARDSIZE; i++)
            if (i != 7)
                drawStones(i, 4);
        drawNumbers();
        displayPlayers();
        showPlayer();
        //play();
        //initialize(1);
    }

    private void displayPlayers()
    {
        Group group = new Group();
        group.setAutoSizeChildren(false);
        group.getChildren().add(myScene.getRoot());
        for (int i = 0; i < 2; i++)
        {
            players[i] = new Text("Player " + (i+1));
            players[i].setX(400);
            if (i == 0)
                players[i].setY(240);
            else
                players[i].setY(820);
            players[i].setFont(Font.font("Monospaced", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));
            group.getChildren().add(players[i]);
        }
        myScene.setRoot(group);
        myStage.setScene(myScene);
        myStage.show();
    }

    private void showPlayer()
    {
        if (turn != null)
            turn.setOpacity(0.0);
        if (player == PLAYER1)
            turn = new Text("Next turn: player 1");
        else 
            turn = new Text("Next turn: player 2");
        turn.setX(100);
        turn.setY(100);
        turn.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Group group = new Group();
        group.setAutoSizeChildren(false);
        group.getChildren().add(myScene.getRoot());
        group.getChildren().add(turn);
        myScene.setRoot(group);
        myStage.setScene(myScene);
        myStage.show();

        //add something in case of free turn- maybe override in avalanche/capture
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
        
        for(int i = 1; i <= size; i++)
        {
            int index = (num + count) % 14;
            if (board[index] == null)
                board[index] = new LinkedList();
            if (player == PLAYER1 && index == 7)
                i--;
            else if (player == PLAYER2 && index == 0)
                i--; 
            else
            {
                board[index].add(board[num%14].remove(0));
                drawStones(num%14, board[num%14].size());
                drawStones(index, board[index].size());
            }
            count++;
        }
        drawNumbers();
        if (player == PLAYER1)
            player = PLAYER2;
        else 
            player = PLAYER1;
            showPlayer();
        isWon();
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
        int winner = 0;
        boolean allEmpty1 = true;
        boolean allEmpty2 = true;
        for (int i = 1; i <= 6; i++)
            if (!isEmpty(i))
                allEmpty1 = false;
        for (int i = 8; i <= 13; i++)
            if (!isEmpty(i))
                allEmpty2 = false;
        if (allEmpty1 || allEmpty2)
        {
            if (allEmpty1)
            {
                won = true;
                winner = findWinner(1);
            }
            else if (allEmpty2)
            {
                won = true;
                winner = findWinner(2);
            }
            declareWinner(winner);
        }
    }

    private void declareWinner(int winner)
    {
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        Stage stage = new Stage();
        VBox box = new VBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);

        Text title = new Text("The winner is...");
        title.setFont(Font.font("Monospaced", 36));

        Text result;
        if (winner == 0)
            result = new Text("It's a tie!");
        else if (winner == 1)
            result = new Text("Player 1!");
        else 
            result = new Text("Player 2!");
        result.setEffect(is);
        result.setFill(Color.MEDIUMORCHID);
        result.setX(380);
        result.setFont(Font.font(null, FontWeight.BOLD, 80));
        box.getChildren().add(title);
        box.getChildren().add(result);
        Scene scene = new Scene(box, 500, 250);
        stage.setTitle("Results");
        stage.setScene(scene);
        stage.show();
    }

    private int findWinner(int num)
    {
        int winner = 0;
        int start, end, own;
        if (num == 1)
        {
            start = 8;
            end = 13;
            own = 7;
        }
        else 
        {
            start = 1; 
            end = 6;
            own = 0;
        }
        for (int i = start; i <= end; i++)
            if (board[i] != null)
                while (board[i].size() != 0)
                    board[own].add(board[i].remove(0));
        int count1 = board[0].size();
        int count2 = board[7].size();
        if (count1 > count2)
            winner = PLAYER1;
        else if (count2 > count1)
            winner = PLAYER2;
        return winner;
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
