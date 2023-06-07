package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.BoThu;
import java.util.concurrent.TimeUnit;
import java.security.*;
import javafx.animation.*;
import javafx.util.*;
public class QuizController implements Initializable {
	Sound sound = new Sound();
    URL soundURL = getClass().getResource("/sound/Pen Clicking .wav");
    @FXML
    private Button opt1;

    @FXML
    private Button opt2;

    @FXML
    private Button opt3;

    @FXML
    private Button opt4;

    @FXML
    private ImageView question;
    public Image image;
    int quiznum = LoadController.quiz_nums;
    static int[] uniqueNumber(int n) {
    	int []a = new int[n];
    	for (int i=0;i<n;i++) {
    		a[i]=i;
    	}
    	int [] result = new int [n];
    	int x=n;
    	SecureRandom rd = new SecureRandom();
    	for (int i=0;i<n;i++) {
    		int num = rd.nextInt(x);
    		result[i]=a[num];
    		a[num]=a[x-1];
    		x--;
    	}
    	return result;
    }
    Button trueopt = new Button();
    GetData gdt = new GetData();
    public List <BoThu> ls = new ArrayList<>();
    int counter =0;
    static int correct =0;
    static int wrong =0;
    private Stage stage;
	private Scene scene;
	public Parent root;
    int []randomNum = uniqueNumber(39);
    public void loadQuestion (List<BoThu> ls,int [] randomNum) {
    opt1.setStyle("-fx-background-color: RED");
    opt2.setStyle("-fx-background-color: RED");
    opt3.setStyle("-fx-background-color: RED");
    opt4.setStyle("-fx-background-color: RED");
    if (counter==0) {
    image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
    question.setImage(image);
    opt1.setText(ls.get(randomNum[counter+1]).getPinyin());
    opt2.setText(ls.get(randomNum[counter]).getPinyin());
    opt3.setText(ls.get(randomNum[counter+2]).getPinyin());
    opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    trueopt = opt2;
    }
    if (counter==1) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    
    if (counter==2) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter-2]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==3) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter-2]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==4) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+4]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==5) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter+4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+2]).getPinyin());
    }
    if (counter==6) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt2.setText(ls.get(randomNum[counter+4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==7) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter-2]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==8) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==9) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==10) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==11) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-2]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==12) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+3]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+4]).getPinyin());
    }
    if (counter==13) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==14) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==15) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-2]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==16) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+8]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-5]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==17) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==18) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt3.setText(ls.get(randomNum[counter]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==19) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==20) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==21) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-5]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==22) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==23) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]-3).getPinyin());
        opt2.setText(ls.get(randomNum[counter]-2).getPinyin());
        opt3.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==24) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==25) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter+3]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter]).getPinyin());
    }
    if (counter==26) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==27) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter-1]).getPinyin());
        opt2.setText(ls.get(randomNum[counter]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==28) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter]).getPinyin());
        opt2.setText(ls.get(randomNum[counter-7]).getPinyin());
        opt3.setText(ls.get(randomNum[counter+1]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    if (counter==29) {
    	image = new Image (getClass().getResourceAsStream(ls.get(randomNum[counter]).getImgSrc()));
        question.setImage(image);
        opt1.setText(ls.get(randomNum[counter+6]).getPinyin());
        opt2.setText(ls.get(randomNum[counter+4]).getPinyin());
        opt3.setText(ls.get(randomNum[counter]).getPinyin());
        opt4.setText(ls.get(randomNum[counter+3]).getPinyin());
    }
    
    }
    public boolean checkAnswer(String answer,List<BoThu> ls) {
		boolean result=false;
    	if (counter==0) {
		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
				result= true;
				
			} else {result = false;}
		}
    	if (counter==1) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==2) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==3) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==4) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==5) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==6) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==7) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==8) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==9) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==10) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==11) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==12) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==13) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==14) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==15) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==16) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==17) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==18) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==19) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==20) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==21) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==22) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==23) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==24) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==25) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==26) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==27) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==28) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
    	if (counter==29) {
    		if (answer.equals(ls.get(randomNum[counter]).getPinyin())) {
    				result= true;
    			} else {result = false;}
    		}
		return result;
		
	}
    @FXML
    void opt1clicked(ActionEvent event) {
      sound.setFile(soundURL);
	  sound.play(soundURL);
       checkAnswer(opt1.getText(),ls);
       if (checkAnswer(opt1.getText(),ls)) {
    	   correct = correct+1;
    	   opt1.setStyle("-fx-base: lightgreen");
    	   PauseTransition pause = new PauseTransition(Duration.seconds(1));
    	   pause.play();
       }
       else {
    	   wrong = wrong+1;
    	   trueopt.setStyle("-fx-background-color: GREEN");
       }
       if (counter<quiznum-1)  {
    	   counter ++;
    	   loadQuestion(ls,randomNum);
       }
       else {
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/Result.fxml"));
  		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  		  scene = new Scene(root);
  		  stage.setScene(scene);
  		  stage.show();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
       }
    	
    }
    public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("../views/ManHinh.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		 }
   
	@FXML
    void opt2clicked(ActionEvent event) {
		  sound.setFile(soundURL);
		  sound.play(soundURL);
		 checkAnswer(opt1.getText(),ls);
	       if (checkAnswer(opt2.getText(),ls)) {
	    	   correct = correct+1;
	    	   opt2.setStyle("-fx-base: lightgreen");
	    	   PauseTransition pause = new PauseTransition(Duration.seconds(1));
	    	   pause.play();
	    	   
	       }
	       else {
	    	   wrong = wrong+1;
	    	   trueopt.setStyle("-fx-background-color: GREEN");
	       }
	       if (counter<quiznum-1)  {
	    	   counter ++;
	    	   
	    	   loadQuestion(ls,randomNum);
	       }
	       else {
	       	try {
	       	Parent root = FXMLLoader.load(getClass().getResource("/views/Result.fxml"));
	     		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	     		  scene = new Scene(root);
	     		  stage.setScene(scene);
	     		  stage.show();
	       	}
	       	catch (Exception e) {
	       		e.printStackTrace();
	       	}
	          }
    }

    @FXML
    void opt3clicked(ActionEvent event) {
    	  sound.setFile(soundURL);
    	  sound.play(soundURL);
    	 checkAnswer(opt3.getText(),ls);
         if (checkAnswer(opt1.getText(),ls)) {
      	   correct = correct+1;
      	 opt3.setStyle("-fx-background-color: GREEN");
      	
         }
         else {
      	   wrong = wrong+1;
      	   trueopt.setStyle("-fx-background-color: GREEN");
         }
         if (counter<quiznum-1)  {
      	   counter ++;
      	 
      	   loadQuestion(ls,randomNum);
         }
         else {
         	try {
         	Parent root = FXMLLoader.load(getClass().getResource("/views/Result.fxml"));
       		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       		  scene = new Scene(root);
       		  stage.setScene(scene);
       		  stage.show();
         	}
         	catch (Exception e) {
         		e.printStackTrace();
         	}
            }
    }

    @FXML
    void opt4clicked(ActionEvent event) {
    	  sound.setFile(soundURL);
    	  sound.play(soundURL);
    	 checkAnswer(opt4.getText(),ls);
         if (checkAnswer(opt1.getText(),ls)) {
      	   correct = correct+1;
      	 opt4.setStyle("-fx-background-color: GREEN");
      	 
         }
         else {
      	   wrong = wrong+1;
      	  trueopt.setStyle("-fx-background-color: GREEN");
         }
         if (counter<quiznum-1)  {
      	   counter ++;
      	
      	   loadQuestion(ls,randomNum);
         }
         else {
         	try {
         	Parent root = FXMLLoader.load(getClass().getResource("/views/Result.fxml"));
       		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       		  scene = new Scene(root);
       		  stage.setScene(scene);
       		  stage.show();
         	}
         	catch (Exception e) {
         		e.printStackTrace();
         	}
            }
    }
    public void initialize(URL location, ResourceBundle resources) {
    ls.addAll(gdt.getData());
    wrong=0;
    correct=0;
    loadQuestion(ls,randomNum);
    
    
    }
}
