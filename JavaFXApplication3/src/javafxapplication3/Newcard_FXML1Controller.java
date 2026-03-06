
package javafxapplication3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Newcard_FXML1Controller implements Initializable {

    @FXML
    private TextField txtfldque;
    @FXML
     private AnchorPane scenePane;
    @FXML
    private TextField txtfldans;
    @FXML
    private Button btnnext;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnexit;
    
   
    
    String question;
    String Answer;
    
    FileChooser saveFIleChooser = new FileChooser();
    String store = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void txtfldclickquestion(ActionEvent event) throws IOException {
               try {
            File tempFileSave = new File("file1.txt");

            if (tempFileSave.createNewFile()) {

                Writer myWriter = new BufferedWriter(new FileWriter("file1.txt", true));

                String questionString = txtfldque.getText();
                myWriter.append(questionString + "\n");
                txtfldque.setText("");
                myWriter.close();
                

                txtfldque.setVisible(false);
                txtfldans.setVisible(true);
            } else {
                Writer myWriter = new BufferedWriter(new FileWriter("file1.txt", true));

                String questionString = txtfldque.getText();
                myWriter.append(questionString + "\n");
                txtfldque.setText("");
                myWriter.close();
                txtfldque.setVisible(false);
                txtfldque.setVisible(true);

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
     @FXML
    private void txtfldclickanswer(ActionEvent event) throws IOException {
       try {
            File tempFileSave = new File("file1.txt");
            if (tempFileSave.createNewFile()) {

                Writer myWriter = new BufferedWriter(new FileWriter("file1.txt", true));

                String answerString = txtfldans.getText();
                myWriter.append(answerString + "\n");
                txtfldque.setText("");
                myWriter.close();
                txtfldque.setVisible(true);
                txtfldans.setVisible(false);

            } else {

                Writer answerWriter = new BufferedWriter(new FileWriter("file1.txt", true));

                String answerString = txtfldans.getText();
                answerWriter.append(answerString + "\n");
                txtfldque.setText("");
                answerWriter.close();
                txtfldque.setVisible(true);
                txtfldans.setVisible(false);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    private void clicknext(ActionEvent event) throws IOException {
        System.out.println("Next Action working");

        FileWriter fileWriter = new FileWriter("card_1.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write("");
        printWriter.flush();
        printWriter.close();
        txtfldque.setText("");
        txtfldans.setText("");
    }
    
    void exitAction(ActionEvent event) {

        try {

            FileWriter fileWriter = new FileWriter("card_1.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write("");
            printWriter.flush();
            printWriter.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText("You are about to exit!");
            alert.setContentText("Do you want to leave ?");

            if (alert.showAndWait().get() == ButtonType.OK) {
                Stage stage = (Stage) scenePane.getScene().getWindow();
                stage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void visibilitySetter() {
        txtfldque.setVisible(true);
        txtfldans.setVisible(false);
      
    }
    
    void clicksave(ActionEvent event) throws IOException {

        saveFIleChooser.setTitle("Saving option");
        Window stage = null;
        File file = saveFIleChooser.showSaveDialog(stage);
        if (file != null) {
            saveSystem(file);
        }
    }

    public void saveSystem(File file) throws IOException {

        try {

            FileInputStream inputStream = null;
            FileOutputStream outputStream = null;
            store = file.getAbsolutePath();
            File inputFile = new File("file1.txt");
            File outputFile = new File(store);
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }

            inputStream.close();
            outputStream.close();

            FileWriter fileWriter = new FileWriter("file1.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write("");
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Invalid file type");
        }

    }
    
}
