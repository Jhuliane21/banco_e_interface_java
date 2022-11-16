package Loader;

import Model.Medico;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaEdicaoMedico {
    public void JanelaEdicaoMedico() {
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane grafh = loader.load(getClass().getResource("/View/EditarMedico.fxml").openStream());
            Scene scene = new Scene(grafh,468, 261);

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
