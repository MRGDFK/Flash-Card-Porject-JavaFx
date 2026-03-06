
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.soap.Node;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLController implements Initializable {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button btnnewcard;
    @FXML
    private Button btnplaycard;
    @FXML
    private Button btnexit;
    
    Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newcardclick(ActionEvent event) throws IOException {
       

     try {
            System.out.println("Create Card Action");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createCard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Newcard_FXML1Controller createCard = loader.getController();
            createCard.visibilitySetter();

            Stage stageCreate = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageCreate.setScene(scene);
            stageCreate.setTitle("Create Flash Card");
            stageCreate.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnplaycardclick(ActionEvent event) {
         System.out.println("Play card Action");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("playCard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Playcard_FXMLController welcome = loader.getController();

            Stage stagePlay = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stagePlay.setScene(scene);
            stagePlay.setTitle("Play Flash Card");
            stagePlay.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitclick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Do you want to leave ?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }
    
}
