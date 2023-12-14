package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import webscraping.Webpage;

/**
 * 
 * Controller class for the main window
 * 
 * @author Dylan Watts
 * @version 0.2
 *
 */
public class MainWindowController {

	@FXML TextField urlTextField;
	@FXML Button scrapeButton;
	@FXML TextArea outputTextArea;
	
	/**
	 * Updates the TextArea when scrape is pressed
	 */
	@FXML public void scrapePressed() {
		if (urlTextField.getText() != "") {
			Webpage page = new Webpage(urlTextField.getText());
			outputTextArea.setText(page.getContent());
		}
	}
	
}
