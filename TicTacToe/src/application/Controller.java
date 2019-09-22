package application;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {

	@FXML
	private Button textBoxOne;
	@FXML
	private Button textBoxTwo;
	@FXML
	private Text textOne;
	@FXML
	private Text textTwo;
	@FXML
	private Text textThree;
	@FXML
	private Text textFour;
	@FXML
	private Text textFive;
	@FXML
	private Text textSix;
	@FXML
	private Text textSeven;
	@FXML
	private Text textEight;
	@FXML
	private Text textNine;
	@FXML
	private Text textWinner;

	private int turn = 0;
	

	int placeHolder = 0;
	static Stage stage;
	private void EqualsThis(String string, Text text, Text text2, Text text3) {
		if (text.getText().equals(string) && text2.getText().equals(string) && text3.getText().equals(string)) {
			textWinner.setText("Player " + string + " is the Winner!");

			textOne.setDisable(true);
			textTwo.setDisable(true);
			textThree.setDisable(true);
			textFour.setDisable(true);
			textFive.setDisable(true);
			textSix.setDisable(true);
			textSeven.setDisable(true);
			textEight.setDisable(true);
			

			 try {
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("winner.fxml"));
			        Parent root1 = (Parent) loader.load();
			        stage = new Stage();
			        stage.setResizable(false);
			        stage.setTitle("Play?");
			        stage.initModality(Modality.APPLICATION_MODAL);
			        stage.setScene(new Scene(root1));  
			        stage.show();
			    } catch(Exception e) {
			        e.printStackTrace();
			    }


		} else if (!textOne.getText().isEmpty() && !textTwo.getText().isEmpty() && !textThree.getText().isEmpty()
				&& !textEight.getText().isEmpty() && !textSeven.getText().isEmpty() && !textSix.getText().isEmpty()
				&& !textSeven.getText().isEmpty() && !textEight.getText().isEmpty() && !textNine.getText().isEmpty()) {
			textWinner.setText("Tie!");
			textOne.setDisable(true);
			textTwo.setDisable(true);
			textThree.setDisable(true);
			textFour.setDisable(true);
			textFive.setDisable(true);
			textSix.setDisable(true);
			textSeven.setDisable(true);
			textEight.setDisable(true);
			placeHolder++;
			if(placeHolder==8) {
				placeHolder=0;
				try {
					
					 FXMLLoader loader = new FXMLLoader(getClass().getResource("winner.fxml"));
				        Parent root1 = (Parent) loader.load();
				        stage = new Stage();
				        stage.setResizable(false);
				        stage.setTitle("Play?");
				        stage.initModality(Modality.APPLICATION_MODAL);
				        stage.setScene(new Scene(root1));  
				        stage.show();
				    } catch(Exception e) {
				        e.printStackTrace();
				    }
			}
		}
	}

	private void WinnerCheck(String string) {
		// horizontal
		EqualsThis(string, textOne, textTwo, textThree);
		EqualsThis(string, textFour, textFive, textSix);
		EqualsThis(string, textSeven, textEight, textNine);
		// vertical
		EqualsThis(string, textOne, textFour, textSeven);
		EqualsThis(string, textTwo, textFive, textEight);
		EqualsThis(string, textThree, textSix, textNine);
		// diagonal
		EqualsThis(string, textOne, textFive, textNine);
		EqualsThis(string, textThree, textFive, textSeven);
	}

	private void doThisOnClick(Text text) {
		turn++;
		if (!text.getText().equals("")) {
		}
		else if (turn % 2 == 1) {
			text.setText("X");
			WinnerCheck("X");

		} else {
			text.setText("O");
			WinnerCheck("O");
		}
	}

	public void TextOnClickOne() {	
		doThisOnClick(textOne);
	}

	public void TextOnClickTwo() {
		doThisOnClick(textTwo);
	}

	public void TextOnClickThree() {
		doThisOnClick(textThree);
	}

	public void TextOnClickFour() {
		doThisOnClick(textFour);
	}

	public void TextOnClickFive() {
		doThisOnClick(textFive);
	}

	public void TextOnClickSix() {
		doThisOnClick(textSix);
	}

	public void TextOnClickSeven() {
		doThisOnClick(textSeven);
	}

	public void TextOnClickEight() {
		doThisOnClick(textEight);
	}

	public void TextOnClickNine() {
		doThisOnClick(textNine);
	}
	
	public void textBoxPlayAgain() {
		  	stage.close();
		    Main newController = new Main();
			newController.start(Main.current);
	}
	
	public void textBoxExit() {
		Platform.exit();
	}
	
	
}
