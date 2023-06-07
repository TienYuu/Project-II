package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class MainSceneController implements Initializable   {
	   @FXML
	    private Label bkLabel;

	    @FXML
	    private Label nameLabel;
	    @FXML
	    private Button startBtn;
	    URL soundURL = getClass().getResource("/sound/Nhac1.wav");
	    private Stage stage;
		private Scene scene;
		public Parent root;
		Sound sound = new Sound();
		public void switchToScene2(ActionEvent event) throws IOException {
			  Parent root = FXMLLoader.load(getClass().getResource("../views/ManHinh.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  sound.stop(soundURL);
			  
			 }
		public void playMusic(URL url) {
			sound.setFile(url);
			sound.play(url);
		}
		 public void initialize(URL location, ResourceBundle resources) {
		 
		 bkLabel.setText("勇桃 -  河内理工大学");
		 nameLabel.setText("HỌC BỘ THỦ");
		 playMusic(soundURL);
		
	 }
	 
}
