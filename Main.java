
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
import javafx.stage.Stage; 
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.stage.Popup;
import javafx.scene.shape.Circle;///////////
import javafx.scene.control.Label; //////////
/**
 * Write a description of JavaFX class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main extends Application
{
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

        //window help 1
        Popup help1 = new Popup(); 
        help1.setX(300); 
        help1.setY(200);
        help1.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        Label label = new Label("This is a Popup"); 
        label.setStyle(" -fx-background-color: white;");
        help1.getContent().add(label);
        label.setMinWidth(80); 
        label.setMinHeight(50); 

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
        box.getChildren().add(button1);
        button1.setOnAction(this::buttonClickA);
        box.getChildren().add(button2);
        button2.setOnAction(this::buttonClickC);
        button1.setStyle("-fx-background-radius: 7"); //set rounded borders
        button2.setStyle("-fx-background-radius: 7"); 
        box.getChildren().add(buttonHelp);

        /***** POPUP WINDOW *****/
        buttonHelp.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override public void handle(ActionEvent event) 
                {
                    //help1.show(stage);
                    if (!help1.isShowing()) 
                        help1.show(stage); 
                    else
                        help1.hide();
                }
            });

        /*
        Button hide = new Button("Hide");
        hide.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent event) {
        help1.hide();
        }
        });*/

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

    }

    private void buttonClickA(ActionEvent event)
    {
        Stage stage = new Stage();
        Pane box = new Pane();
        box.setPadding(new Insets(20));

        Scene scene = new Scene(box, 1000, 1000);
        stage.setTitle("Avalanche"); //sets stage title for avalanche game

        stage.setScene(scene);
        box.setBackground(displayBoard('a')); 
        stage.show();
        game = new Avalanche(scene, stage, box);
    }

    private void buttonClickC(ActionEvent event)
    {
        Stage stage = new Stage();
        Pane box = new Pane();
        box.setPadding(new Insets(20));
        Scene scene = new Scene(box, 1000, 1000);
        stage.setTitle("Capture"); //sets stage title for avalanche game
        stage.setScene(scene);
        box.setBackground(displayBoard('c'));

        stage.show();
        game = new Capture(scene, stage, box);
    }

    private Background displayBoard(char letter)
    {
        Image image;
        if (letter == 'a')//depending on what type of game is being played, get the correct image
            image = new Image("NewAvalancheBoard.png"); 
        else 
            image = new Image("NewCaptureBoard.png");

        //instantiate a new background image
        BackgroundImage bimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true, true, true));

        return new Background(bimage);
    }
}
