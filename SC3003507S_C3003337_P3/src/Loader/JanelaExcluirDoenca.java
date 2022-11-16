package Loader;

import Model.Doenca;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaExcluirDoenca {
    public void ExcluirDoenca() {
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane grafh = loader.load(getClass().getResource("/View/ExcluirDoenca.fxml").openStream());
            Scene scene = new Scene(grafh, 417, 245);

            Stage stage = new Stage();
            stage.setScene(scene);

            stage.setTitle("Exclusão");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
