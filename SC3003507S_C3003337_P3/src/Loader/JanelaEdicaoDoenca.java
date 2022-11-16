package Loader;

import Model.Doenca;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaEdicaoDoenca {
    public void EdicaoDoenca() {
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane grafh = loader.load(getClass().getResource("/View/EditaDoenca.fxml").openStream());
            Scene scene = new Scene(grafh, 414, 356);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.setTitle("Edição");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}




