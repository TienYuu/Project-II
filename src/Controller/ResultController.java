package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import java.io.*;
public class ResultController implements Initializable {
	@FXML
    private ProgressIndicator correct;

    @FXML
    private ProgressIndicator incorrect;

    @FXML
    private Label score;
    private Stage stage;
	private Scene scene;
	public Parent root;
	String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("../views/ManHinh.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  }
    public void retry(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("../views/Load.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  }
    public void initialize(URL location, ResourceBundle resources) {
    	score.setText(QuizController.correct+ "/"+LoadController.quiz_nums);
    	float correctf = (float)QuizController.correct/LoadController.quiz_nums;
    	correct.setProgress(correctf);
    	float wrongf = (float)QuizController.wrong/LoadController.quiz_nums;
    	incorrect.setProgress(wrongf);
    	try {
    		FileWriter writer = new FileWriter("log.txt",true);
    		BufferedWriter bw = new BufferedWriter(writer);
    		String tmp = date + " Score: " + QuizController.correct+"/"+LoadController.quiz_nums+"\n";
    		bw.write(tmp);
    		bw.close();
    		writer.close();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
}
