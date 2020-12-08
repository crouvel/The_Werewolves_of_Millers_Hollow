/**
 * 
 */
package application;
	
/**
 * 
 */
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class TheWerewolvesOfMillersHollow extends Application {
	
	/**
	 * 
	 */
	private static Stage stage = null;

	/**
	 * 
	 * @param resources
	 * @throws IOException
	 */
    public static void setScene(URL resources) throws IOException {
        Parent root = FXMLLoader.load(resources);
        Scene scene = new Scene(root);
        TheWerewolvesOfMillersHollow.stage.setScene(scene);
    }
	
    /**
     * 
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setResizable(false);
			TheWerewolvesOfMillersHollow.stage=primaryStage;
			primaryStage.setTitle("The Werewolves Of Millers Hollow");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/view/StartMenuView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(false);
			primaryStage.getIcons().add(new Image(("file:../../image/logo.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
