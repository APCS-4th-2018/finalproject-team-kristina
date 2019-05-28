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
 * Generalized game of Mancala
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public abstract class Mancala extends Application
{
    // instance variable
    protected LinkedList[] board;  //Mancala board
    
    /**
     * Constructor for objects of Mancala
     */
    public Mancala(Scene scene, Stage stage)
    {
        board = new LinkedList[14];
        for (int i = 0; i<board.length;i++)
            board[i] = new LinkedList();
        for (int i = 1; i < board.length; i++)
        {
            int x = 0;
            int y = 0;
            if (i <= 6 )
                y = 425;
            else
                y = 610;
            if (i == 1 || i == 13)
                x = 220;
            else if (i == 2 || i == 12)
                x = 335;
            else if (i == 3 || i == 11)
                x = 440;
            else if (i == 4 || i == 10)
                x = 555;
            else if (i == 5 || i == 9)
                x = 660;
            else if (i == 6 || i == 8)
                x = 775;
            if (i != 7)
            {
                for (int num = 1; num <= 4; num++)
                {
                    board[i].add(new Stone(x,y,scene,stage));
                }
            }
        }
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
            
        }
    }
}
