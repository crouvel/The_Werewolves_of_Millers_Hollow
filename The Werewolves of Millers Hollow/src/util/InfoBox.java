/**
 * package util
 */
package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * @author Tiffany Dumaire
 *
 */
public class InfoBox {
	
	/**
	 * Open an error box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxE(String message, String head, String title){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxI(String message, String head, String title){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	/**
	 * Open a warning box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxW(String message, String head, String title){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	/**
	 * Open a confirmation box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static boolean infoBoxC(String message, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION,"",ButtonType.YES, ButtonType.CANCEL);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
        	return true;       
        } else {
        	return false;       
        }
    }
	
}
