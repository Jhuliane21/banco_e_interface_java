package Loader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaExcluirPaciente {
    public void ExcluirPaciente( ) {
        FXMLLoader loader = new FXMLLoader();
        try {
        Pane grafh = loader.load(getClass().getResource("/View/ExcluirPaciente.fxml").openStream());
        Scene scene = new Scene(grafh,668, 297);

        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setTitle("Removoção");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    } catch (IOException e)
    {
        e.printStackTrace();
    }

}
}
