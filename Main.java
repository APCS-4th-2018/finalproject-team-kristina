

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
        HBox box = new HBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        Text title = new Text("Mancala");
        title.setFont(Font.font("SanSerif", 50));
        box.getChildren().add(title);
        Scene scene = new Scene(box, 500, 250);
        stage.setTitle("Mancala");
        stage.setScene(scene);
        stage.show();
    }
    private void buttonClick(ActionEvent event)
    {

    }
}
