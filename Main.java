
import javafx.application.Application;
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
import javafx.stage.Stage; 
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.control.Label;

/**
 * Driver class that handles initial screen
 *
 * @author Helen, Kylie, Kristina
 * @version 5/22/19
 */
public class Main extends Application
{
    //local variable
    private Mancala game;

    @Override
    public void start(Stage stage) throws Exception
    {
        //instantiate variables
        VBox box = new VBox();
        Text title = new Text("Mancala"); //create title text
        Scene scene = new Scene(box, 500, 250);
        Button button1 = new Button("Avalanche"); //creates avalanche button
        Button button2 = new Button("Capture"); //creates capture button
        Button buttonHelp = new Button("Help"); //creates help button for instructions
        DropShadow shadow = new DropShadow(); //for button shadow

        //formatting for the box
        box.setPadding(new Insets(20));
        box.setSpacing(20); //sets spacing of words
        box.setAlignment(Pos.CENTER); //sets to center

        //title the screen
        title.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 55));
        title.setStrokeWidth(2); //setting width  
        title.setStroke(Color.WHITE); //setting border
        title.setFill(Color.TAN); //set text color
        box.getChildren().add(title);
        stage.setTitle("Mancala");
        stage.setScene(scene);

        //set background color
        box.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, new CornerRadii(1), new Insets(1))));
        stage.show();

        //add the buttons to the window
        box.getChildren().add(button1); //button1 added to box
        button1.setOnAction(this::buttonClickA); //on action go to buttonClickA
        box.getChildren().add(button2); //button2 added to box
        button2.setOnAction(this::buttonClickC); //on action go to buttonClickC
        box.getChildren().add(buttonHelp); //buttonHelp added to box
        buttonHelp.setOnAction(this::showStage); //on action go to showStage
        button1.setStyle("-fx-background-radius: 7"); //set rounded borders
        button2.setStyle("-fx-background-radius: 7"); 
        buttonHelp.setStyle("-fx-background-radius: 7"); 

        /***** BUTTON LAYOUT *****/
        // adds shadow/color to first button when cursor is on the mouse
        button1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    button1.setEffect(shadow); //shadow effect
                    button1.setStyle("-fx-background-radius: 7;" + "-fx-text-fill: cadetblue;"); //highlight blue
                }
            });

        // shadow/color disappears on first button when the cursor is removed
        button1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    button1.setEffect(null); //shadow effect is turned off
                    button1.setStyle("-fx-background-radius: 7;" +"-fx-text-fill: black;"); //color effect turned off
                }
            });

        // adds shadow/color to first button when cursor is on the mouse
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    button2.setEffect(shadow); //shadow effect
                    button2.setStyle("-fx-background-radius: 7;" + "-fx-text-fill: cadetblue;"); //highlight blue
                }
            });

        // shadow/color disappears on first button when the cursor is removed
        button2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    button2.setEffect(null); //shadow effect is turned off
                    button2.setStyle("-fx-background-radius: 7;" + "-fx-text-fill: black;"); //highlight blue
                }
            });

        // adds shadow/color to first button when cursor is on the mouse
        buttonHelp.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    buttonHelp.setEffect(shadow); //shadow effect
                    buttonHelp.setStyle("-fx-background-radius: 7;" + "-fx-text-fill: cadetblue;"); //highlight blue
                }
            });

        // shadow/color disappears on first button when the cursor is removed
        buttonHelp.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() 
            {
                @Override
                public void handle(MouseEvent e) 
                {
                    buttonHelp.setEffect(null); //shadow effect is turned off
                    buttonHelp.setStyle("-fx-background-radius: 7;" +"-fx-text-fill: black;"); //color effect turned off
                }
            });
        /**** END OF BUTTON LAYOUT ****/
    }

    //when the Avalanche button is clicked
    private void buttonClickA(ActionEvent event)
    {
        //declares and instantiates variables
        Stage stage = new Stage();
        Pane box = new Pane();
        box.setPadding(new Insets(20));
        Scene scene = new Scene(box, 1000, 1000);
        stage.setScene(scene);

        //sets stage title for avalanche game
        stage.setTitle("Avalanche"); 

        //sets the background image (board)
        box.setBackground(displayBoard('a')); 

        stage.show();

        //instantiates new Avalanche game
        game = new Avalanche(scene, stage, box);
    }

    //when the Capture button is clicked
    private void buttonClickC(ActionEvent event)
    {
        //declares and instantiates variables
        Stage stage = new Stage();
        Pane box = new Pane();
        box.setPadding(new Insets(20));
        Scene scene = new Scene(box, 1000, 1000);
        stage.setScene(scene);

        //sets stage title for avalanche game
        stage.setTitle("Capture"); 

        //sets the background image (board)
        box.setBackground(displayBoard('c'));

        stage.show();

        //instantiates new Capture game
        game = new Capture(scene, stage, box);
    }

    private void showStage(ActionEvent event)
    {
        //declare and initialize variables
        VBox box = new VBox();
        Stage stage = new Stage();

        //sets stage title for help
        stage.setTitle("Help"); 

        //formatting for the box
        box.setPadding(new Insets(20));
        box.setSpacing(20); //sets spacing of words
        box.setAlignment(Pos.CENTER); //sets to center

        //title header
        Text title = new Text("Instructions:"); //create title text
        title.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 50));
        title.setStrokeWidth(2); //setting width  
        title.setStroke(Color.WHITE); //setting border
        title.setFill(Color.TAN); //set text color
        box.getChildren().add(title);

        //declaring instructions to the box
        Label capture = new Label("Capture Mode Rules:"); //capture mode label
        Label capture1 = new Label("Each player owns one side of the board. Players take turns selecting \na pile of stones "
                + "from each of their own highlighted pits. The stones from \nthe selected pit will move clockwise, dropping one stone over "
                + "every pit \nuntil the player runs out of stones. If the last stone dropped is in an empty \nhole on the current "
                + "player's pit, the player will capture all stones on the same \npit on the opposite side of the board, capturing "
                + "the other players' stones.\nThe game ends when all six holes on neither player's side are empty. \nThe player "
                + "with the most stones is the winner,"); //capture mode label

        Label avalanche = new Label("Avalanche Mode Rules:"); //avalanche mode label
        Label avalanche1 = new Label("Each player owns one side of the board. Players take turns selecting \na pile of stones "
        + "from each of their own highlighted pits. The stones from \nthe selected pit will move clockwise, dropping one stone over "
        + "every pit \nuntil the player runs out of stones. If the last stone dropped is in a unempty \nhole on either player's"
        + "pit, the player will pick up all the stones in that pit \nand continue to deposit the stones clockwise. The player's\n"
        + "turn ends when the last stone dropped is in an empty pit. \nThe game ends when all six holes on neither player's side are empty. \n"
        + "The player with the most stones is the winner."); //avalanche mode label

        //formatting labels and adding to box
        box.getChildren().add(capture); //adds capture header text
        box.getChildren().add(capture1);  //adds capture instructions
        box.getChildren().add(avalanche); //adds avalanche header text
        box.getChildren().add(avalanche1);  //adds avalanche instructions
        capture.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 20)); //capture header
        capture1.setFont(Font.font("Monospaced", FontPosture.REGULAR, 15)); //instruction format
        avalanche.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 20)); //avalanche header
        avalanche.setFont(Font.font("Monospaced", FontPosture.REGULAR, 15)); //instruction format

        //set background color
        box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(1), new Insets(1))));
        stage.show();

        Scene stageScene = new Scene(box, 525, 600);
        stage.setScene(stageScene);
        stage.show();
    }

    //chooses correct background image depending on the type of Mancala
    private Background displayBoard(char letter)
    {
        Image image;

        //depending on what type of game is being played, get the correct image
        if (letter == 'a')
            image = new Image("NewAvalancheBoard.png"); 
        else 
            image = new Image("NewCaptureBoard.png");

        //instantiate a new background image
        BackgroundImage bimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true, true, true));

        return new Background(bimage);
    }
}
