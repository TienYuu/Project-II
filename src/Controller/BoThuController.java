package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.MyListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.BoThu;



public class BoThuController implements Initializable {
	 

	 @FXML
	    private Label hanViet;
	 @FXML
	    private void click(MouseEvent actionEvent) {
		 myListener.onClickListener(bothu);
	 }
private MyListener myListener;
private BoThu bothu;
public void setData (BoThu bt,MyListener myListener) {
	this.bothu = bt;
	this.myListener = myListener;
	
	hanViet.setText(bt.getHanViet());
}
@Override
public void initialize(URL location, ResourceBundle resources) {
}

}
