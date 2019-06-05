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
    // instance variables
    protected final int BOARDSIZE = 14;
    protected final int PLAYER1 = 1;
    protected final int PLAYER2 = 2;
    protected int player;
    protected boolean won;
    protected Scene myScene;
    protected Stage myStage;
    protected Text turn;
    protected LinkedList[] board;  //Mancala board
    protected Text[] count;
    protected Button[] btns;
    protected Text[]  players;

    /**
     * Constructor for objects of Mancala
     * 
     * 
     */
    public Mancala(Scene scene, Stage stage, Pane root)
    {
        player = PLAYER1;
        myScene = scene;
        myStage = stage;
        //myRoot = root;
        board = new LinkedList[BOARDSIZE];
        count = new Text[BOARDSIZE];
        players = new Text[2];
        btns = new Button[14];
        won = false;
        addButtons(root);
        for (int i = 1; i < BOARDSIZE; i++)
            if (i != 7)
                drawStones(i, 4);
        drawNumbers();
        displayPlayers();
        showPlayer();
        hideButtons();
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
    }

    /**
     * Method displays which player it's on
     */
    protected void showPlayer()
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

    private void addButtons(Pane root)
    {
        //Button[] btns = new Button[14];
        for(int i = 1; i < 14; i++)//skips 0 and 7
        {
            if (i != 7)
            {
                btns[i] = new Button();//make the button
                btns[i].setShape(new Circle(50));//make the button a circle
                btns[i].setLayoutX(setX(i)-50);//set the location
                btns[i].setLayoutY(setY(i)-50);
                btns[i].setMinSize(100,100);//size the button
                btns[i].setVisible(true);
                root.getChildren().add(btns[i]);
                btns[i].toFront();
                //make it so something different happens on each button click
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

    /**
     * makes it so that you can only see the buttons for the player's turn it's on
     */
    protected void hideButtons()
    {
        if (player == PLAYER1)
        {
            for (int i = 1; i <= 6; i++)
                btns[i].setVisible(true);//only be able to see buttons 1-6
            for (int i = 8; i <= 13; i++)
                btns[i].setVisible(false);//don't see buttons 8-13
        }
        else
        {
            for (int i = 1; i <= 6; i++)
                btns[i].setVisible(false);//don't see buttons 1-6
            for (int i = 8; i <= 13; i++)
                btns[i].setVisible(true);//only be able to see 8-13
        }
    }

    /**
     * draws the stones at the correct location
     * 
     * @param num the location to draw the stones
     * @param count the number of stones to draw
     */
    public void drawStones(int num, int count)
    {
        if (board[num] != null)
            for (int i = 0; i < board[num].size(); i++)
                ((Stone)board[num].get(i)).setTransparent();      

        board[num] = new LinkedList();
        int x = setX(num);
        int y = setY(num);

        //if its in the pits on the end
        if (num == 0 || num == 7)
            y = y + 93;

        Stone s;
        //make and add the new stones
        for (int i = 1; i <= count; i++)
        {
            s = new Stone(num,x,y,myScene,myStage);
            board[num].add(s);
        }
        myStage.show();
    }

    private int setX(int i)
    {
        int x = 0;

        //set the x location based on the int i passed
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

        //set the y location based on the i passed
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
        int index;

        for(int i = 1; i <= size; i++)
        {
            index = (num + count) % 14;
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
    }

    /**
     * method switches what player it's on
     * 
     */
    protected void switchPlayers()
    {
        if (player == PLAYER1)
            player = PLAYER2;
        else 
            player = PLAYER1;
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
    protected void isWon()
    {
        int winner = 0;
        boolean allEmpty1 = true;
        boolean allEmpty2 = true;

        //traverse pits 1-6 to see if they're all empty
        for (int i = 1; i <= 6; i++)
            if (!isEmpty(i))
                allEmpty1 = false;

        //traverse pits 8-13 to see if they're all empty
        for (int i = 8; i <= 13; i++)
            if (!isEmpty(i))
                allEmpty2 = false;

        //if either row of pits is empty...
        if (allEmpty1 || allEmpty2)
        {
            if (allEmpty1)//if 1-6 is empty, determine the winner
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
        //Declare variables
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

        //Set the text for what player won
        if (winner == 0)
            result = new Text("It's a tie!");
        else if (winner == 1)
            result = new Text("Player 1!");
        else 
            result = new Text("Player 2!");

        //sets visual effects for the text
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
        //Declare variables
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
            if (board[i] == null)//if there's nothing there
                board[i] = new LinkedList();
            int num = board[i].size();
            int x, y;
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
    }
}
