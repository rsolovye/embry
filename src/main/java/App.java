import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(App.class, "bla"); //(java.lang.String[])null
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            SplitPane page =  FXMLLoader.load(App.class.getResource("vitrificationfx.fxml"));
            Scene scene = new Scene(page);

            primaryStage.setScene(scene);
            primaryStage.setTitle("FXML Vitrification");
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}