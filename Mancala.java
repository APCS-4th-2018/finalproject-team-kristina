
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
    protected Group group;
    protected LinkedList[] board;  //Mancala board
    protected Text[] count;
    protected Button[] btns;
    protected Text[]  players;

    /**
     * Constructor for objects of Mancala
     * 
     * @param scene
     * @param stage
     * @param root
     * @author Helen Xu and Kristina Lansang
     */
    public Mancala(Scene scene, Stage stage, Pane root)
    {
        //initializes instance variables
        myScene = scene;
        myStage = stage;
        group = new Group();
        group.setAutoSizeChildren(false);
        group.getChildren().add(myScene.getRoot());
        
        board = new LinkedList[BOARDSIZE];
        count = new Text[BOARDSIZE];
        players = new Text[2];
        btns = new Button[14];
        won = false;

        //adds buttons to Mancala board
        addButtons(root);

        //begins with 4 stones in each pit
        for (int i = 1; i < BOARDSIZE; i++)
            if (i != 7)
                drawStones(i, 4);

        //adds numbers to each pit to indicate number of stones
        drawNumbers();

        //shows which side belongs to which player
        displayPlayers();

        //begins with player 1
        player = PLAYER1;

        //shows current player
        showPlayer();

        //hides the buttons for the other player
        hideButtons();
    }

    /**
     * shows which side of the board belong to which player
     * 
     * @author Helen Xu
     */
    private void displayPlayers()
    {
        //adds text indicating each player's side of the board
        for (int i = 0; i < 2; i++)
        {
            players[i] = new Text("Player " + (i+1));

            //sets x and y location
            players[i].setX(400);
            if (i == 0)
                players[i].setY(240);
            else
                players[i].setY(820);

            //set font and size
            players[i].setFont(Font.font("Monospaced", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));

            //add to group
            group.getChildren().add(players[i]);
        }

        //update myScene
        myScene.setRoot(group);
    }

    /**
     * Method displays which player it's on
     * 
     * @author Helen Xu
     */
    protected void showPlayer()
    {
        //remove what is currently showing
        if (turn != null)
            //turn.setOpacity(0.0);
            group.getChildren().remove(turn);

        //sets appropriate text
        if (player == PLAYER1)
            turn = new Text("Next turn: player 1");
        else 
            turn = new Text("Next turn: player 2");

        //sets location and font/size
        turn.setX(100);
        turn.setY(100);
        turn.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //adds new stuff to group
        group.getChildren().add(turn);

        //updates myScene
        myScene.setRoot(group);
    }

    /**
     * shows which side of the board belong to which player
     * 
     * @author Kristina Lansang
     */
    private void addButtons(Pane root)
    {
        for(int i = 1; i < 14; i++) //skips 0 and 7
        {
            if (i != 7)
            {
                btns[i] = new Button(); //make the button
                btns[i].setShape(new Circle(50)); //make the button a circle

                //set the location
                btns[i].setLayoutX(setX(i)-50); 
                btns[i].setLayoutY(setY(i)-50);
                btns[i].setMinSize(100,100); //size the button
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
    }

    /**
     * moves the stones in pit 1 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick1(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[1].size() != 0)
            move(1);
    }

    /**
     * moves the stones in pit 2 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick2(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[2].size() != 0)
            move(2);
    }

    /**
     * moves the stones in pit 3 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick3(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[3].size() != 0)
            move(3);
    }

    /**
     * moves the stones in pit 4 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick4(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[4].size() != 0)
            move(4);
    }

    /**
     * moves the stones in pit 5 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick5(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[5].size() != 0)
            move(5);
    }

    /**
     * moves the stones in pit 6 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick6(ActionEvent event)
    {
        if (!won && player == PLAYER1 && board[6].size() != 0)
            move(6);
    }

    /**
     * moves the stones in pit 8 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick8(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[8].size() != 0)
            move(8);
    }

    /**
     * moves the stones in pit 9 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick9(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[9].size() != 0)
            move(9);
    }

    /**
     * moves the stones in pit 8 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick10(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[10].size() != 0)
            move(10);
    }

    /**
     * moves the stones in pit 11 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick11(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[11].size() != 0)
            move(11);
    }

    /**
     * moves the stones in pit 12 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick12(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[12].size() != 0)
            move(12);
    }

    /**
     * moves the stones in pit 13 when clicked on
     * 
     * @author Helen Xu
     */
    private void buttonClick13(ActionEvent event)
    {
        if (!won && player == PLAYER2 && board[13].size() != 0)
            move(13);
    }

    /**
     * makes it so that you can only see the buttons for the player's turn it's on
     * 
     * @author Helen Xu
     */
    protected void hideButtons()
    {
        if (player == PLAYER1)
        {
            for (int i = 1; i <= 6; i++)
                btns[i].setVisible(true); //only be able to see buttons 1-6
            for (int i = 8; i <= 13; i++)
                btns[i].setVisible(false); //don't see buttons 8-13
        }
        else
        {
            for (int i = 1; i <= 6; i++)
                btns[i].setVisible(false); //don't see buttons 1-6
            for (int i = 8; i <= 13; i++)
                btns[i].setVisible(true); //only be able to see 8-13
        }
    }

    /**
     * draws the stones at the correct location
     * 
     * @param num the location to draw the stones
     * @param count the number of stones to draw
     * 
     * @author Helen Xu
     */
    protected void drawStones(int num, int count)
    {
        //removes what was previously there
        if (board[num] != null)
            for (int i = 0; i < board[num].size(); i++)
                //((Stone)board[num].get(i)).setTransparent();      
                group.getChildren().remove(((Stone)board[num].get(i)).getCircle());

        //instantiates new LinkedList
        board[num] = new LinkedList();

        //set X and Y position
        int x = setX(num);
        int y = setY(num);

        //if it's in the pits on the end
        if (num == 0 || num == 7)
            y = y + 93;

        //make and add the new stones
        for (int i = 1; i <= count; i++)
        {
            board[num].add(new Stone(num,x,y,myScene, group));
        }
    }

    /**
     * sets the X location
     * 
     * @author Helen Xu and Kristina Lansang
     */
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

    /**
     * sets the y location
     * 
     * @author Helen Xu and Kristina Lansang
     */
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
     * @author Helen Xu
     */
    protected void move(int num)
    {
        //local variables
        int count = 1;
        int size = board[num].size();
        int index;

        //repeats once for each stone in num
        for(int i = 1; i <= size; i++)
        {
            //finds number of pit that next stone should be dropped in
            index = (num + count) % 14;

            //instantiates new LinkedList if there wasn't one
            if (board[index] == null)
                board[index] = new LinkedList();

            //skip opponents big pit
            if (player == PLAYER1 && index == 0)
                i--;
            else if (player == PLAYER2 && index == 7)
                i--; 
            //otherwise add stone to the location
            else
            {
                board[index].add(board[num%14].remove(0));

                //redraw stones in the new location
                drawStones(index, board[index].size());
            }

            //move to the next location
            count++;
        }

        //update final number of stones
        drawStones(num%14, board[num%14].size());

        //update numbers
        drawNumbers();
    }

    /**
     * Switches what player it's on
     * 
     * @author Helen Xu
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
     * @author Kristina Lansang
     */
    protected boolean isEmpty(int num)
    {
        boolean empty = false;
        if (board[num].size() == 0)
            empty = true;
        return empty;
    }

    /**
     * Determines whether the game is won yet
     * 
     * @author Helen Xu
     * 
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

        //if either row of pits are empty...
        if (allEmpty1 || allEmpty2)
        {
            if (allEmpty1) //if 1-6 are empty, determine the winner
            {
                won = true;
                winner = findWinner(1);
            }
            else if (allEmpty2) //if 8-13 are empty, determine the winner
            {
                won = true;
                winner = findWinner(2);
            }
            for (int i = 0; i <= BOARDSIZE; i++)
                drawStones(i, board[i].size());
            declareWinner(winner);
        }
    }

    /**
     * creates new window that declares the winner
     * 
     * @author Helen Xu
     */
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

    /**
     * finds the winner
     * 
     * @author Helen Xu
     */
    private int findWinner(int num)
    {
        //declare variables
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

        //adds remaining pieces to your own
        for (int i = start; i <= end; i++)
            if (board[i] != null)
                while (board[i].size() != 0)
                    board[own].add(board[i].remove(0));

        //tallies total marble in each side
        int count1 = board[0].size();
        int count2 = board[7].size();

        //determines the winner based on who had more stones
        if (count1 > count2)
            winner = PLAYER1;
        else if (count2 > count1)
            winner = PLAYER2;

        return winner;
    }

    /**
     * Prints out the number of stones in each pit
     * 
     * @author Helen Xu
     */
    protected void drawNumbers()
    {
        //for each pit
        for (int i = 0; i < board.length; i++)
        {
            //if there's nothing there
            if (board[i] == null) 
                board[i] = new LinkedList();

            int num = board[i].size();
            int x, y;

            //remove what was previously there
            if (count[i] != null)
                //count[i].setOpacity(0.0);
                group.getChildren().remove(count[i]);

            //create new Text object
            count[i] = new Text(Integer.toString(num));

            //set X and Y location
            if (i <= 7)
                y = setY(i) - 88;
            else 
                y = setY(i) + 107;
            x = setX(i) - 10;
            count[i].setX(x);
            count[i].setY(y);

            //set font, size, color
            count[i].setFont(Font.font("Monospaced", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));
            count[i].setFill(Color.WHITE);

            //add to group
            group.getChildren().add(count[i]);
        }

        //update myScene
        myScene.setRoot(group);
    }
}
