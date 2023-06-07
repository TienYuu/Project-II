package Controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class LoadController implements Initializable {
	@FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private ListView<String> listview;
    private Stage stage;
	private Scene scene;
	private Parent root;
	String []dong = new String[30];
	int i=0;
	static int quiz_nums;
	public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("../views/ManHinh.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		 }
    public void Btn1Event(ActionEvent event) throws IOException {
  	  quiz_nums =10;
      root = FXMLLoader.load(getClass().getResource("../views/Quiz.fxml"));
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  scene = new Scene(root);
  	  stage.setScene(scene);
  	  stage.show();
  	 }
    public void Btn2Event(ActionEvent event) throws IOException {
    	quiz_nums=20;  
    	root = FXMLLoader.load(getClass().getResource("../views/Quiz.fxml"));
    	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	  scene = new Scene(root);
    	  stage.setScene(scene);
    	  stage.show();
    	 }
    public void Btn3Event(ActionEvent event) throws IOException {
    	quiz_nums=30;
    	root = FXMLLoader.load(getClass().getResource("../views/Quiz.fxml"));
    	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	  scene = new Scene(root);
    	  stage.setScene(scene);
    	  stage.show();
    	 }
    public void initialize(URL location, ResourceBundle resources) {
    	for (int j=0;j<30;j++) {
    		dong[j] = "Empty"; 
    	}
    	try {
    		FileReader reader = new FileReader("log.txt");
    		BufferedReader br = new BufferedReader(reader);
    		String line;
    		while (true) {
    			line = br.readLine();
    			if (line == null) {
    				break;
    			}
    			else {
    				dong[i]=line;
    				i++;
    			}
    			
    			}
    		br.close();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	listview.getItems().addAll(dong);
    }
}
