

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
 * Write a description of JavaFX class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        //instantiate variables
        VBox box = new VBox();
        Text title = new Text("Mancala");
        Scene scene = new Scene(box, 500, 250);
        Button button1 = new Button("Avalanche");
        Button button2 = new Button("Capture");
        
        //formatting for the box
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        
        //title the screen
        title.setFont(Font.font("Monospaced", 50));
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
    }
    private void buttonClickA(ActionEvent event)
    {
        Stage stage = new Stage();
        VBox box = new VBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(box, 1000, 1000);
        stage.setTitle("Avalanche");
        
        stage.setScene(scene);
        box.setBackground(displayBoard());
        
        stage.show();
    }
    private void buttonClickC(ActionEvent event)
    {
        Stage stage = new Stage();
        VBox box = new VBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 1000, 1000);
        stage.setTitle("Capture");
        stage.setScene(scene);
        box.setBackground(displayBoard());
        
        stage.show();
    }
    private Background displayBoard()
    {
        Image image = new Image ("mancalaboard.png");
        BackgroundImage bimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true, true, true));
        return new Background(bimage);
    }
}
