package Controller;

import Model.Estado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;

public class AdicionaPacientes {
    @FXML
    private TextField txtNome;

    @FXML private TextField txtCPF;

    @FXML private Button addPaciente;

    @FXML private ToggleGroup respostaConvenio;

    @FXML private ComboBox<Estado.EstadoClinico> cbEstado = new ComboBox<>();



    private LocalDate data= LocalDate.now();

    private String respostaComboBox  = cbEstado.getSelectionModel().getSelectedItem().toString();



    public void initialize() {

        cbEstado.getItems().setAll(Estado.EstadoClinico.values());

    }

    public void adicionaPaciente(ActionEvent actionEvent) {
    }
}
