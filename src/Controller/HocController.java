package Controller;
import model.BoThu;


import java.io.*;

import java.net.URL;

import java.util.*;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import application.MyListener;

public class HocController implements Initializable {
	    @FXML
	    private ImageView AnhChu;

	    @FXML
	    private Label Pinyin;

	    @FXML
	    private VBox TheChon;
	    @FXML
	    private ScrollPane panel;
	    @FXML
	    private GridPane grid;
	    @FXML
	    private Label ynghia;
	    private Stage stage;
		 private Scene scene;
		 private Parent root;
	    private MyListener myListener;
	    public Image image;
	    Sound sound = new Sound();
	    URL soundURL = getClass().getResource("/sound/Pen Clicking .wav");
        List<BoThu> cell = new ArrayList<>();
        public void switchToScene1(ActionEvent event) throws IOException {
      	  root = FXMLLoader.load(getClass().getResource("../views/MainScene.fxml"));
      	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      	  scene = new Scene(root);
      	  stage.setScene(scene);
      	  stage.show();
      	 }
        public void switchToScene3(ActionEvent event) throws IOException {
        	  root = FXMLLoader.load(getClass().getResource("../views/Load.fxml"));
        	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	  scene = new Scene(root);
        	  stage.setScene(scene);
        	  stage.show();
        	 }
        GetData gdt = new GetData();
        
        
        public void setCard (BoThu bt) {
        	Pinyin.setText(bt.getPinyin());
        	ynghia.setText("Ý nghĩa: " + bt.getYNghia());
        	image = new Image (getClass().getResourceAsStream(bt.getImgSrc()));
        	AnhChu.setImage(image);
        }
        @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    
	    cell.addAll(gdt.getData());
	    int collumn=0;
	    int row =0;
	    if (cell.size()>0) {
	    	setCard(cell.get(0));
	    	myListener = new MyListener () {
	    		@Override
	    		public void onClickListener(BoThu bt) {
	    			setCard(bt);
	    			sound.setFile(soundURL);
	    			sound.play(soundURL);
	    		}
	    		
	    	};
	    }
try {
	       for (int i=0;i<cell.size();i++) {
	    	FXMLLoader fxmlLoader = new FXMLLoader();
	    	fxmlLoader.setLocation(getClass().getResource("/views/Cell.fxml"));
	    	
	    		AnchorPane anchorpane=fxmlLoader.load();
	    		BoThuController btc = fxmlLoader.getController();
	    		btc.setData(cell.get(i),myListener);
	    		
	    		grid.add(anchorpane, collumn, row++);
	    	    
	    		GridPane.setMargin(anchorpane,new Insets(10));
	    		} }catch (IOException e) {
	    			e.printStackTrace();
	    		
	    	}
	    
					
		}	

	    

}
