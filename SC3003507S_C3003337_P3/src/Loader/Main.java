package Loader;

import Utilidades.Dados;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        //Dados.emulando_dados();
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Pane grafh = loader.load(getClass().getResource("/View/Tabela_Paciente.fxml"));
        Scene scene = new Scene(grafh,940,460);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tabela de Pacientes");
        primaryStage.show();
    }
}
