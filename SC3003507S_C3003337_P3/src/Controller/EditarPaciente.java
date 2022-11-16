package Controller;



import DAO.DoencaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import Model.Doenca;
import Model.Estado;
import Model.Medico;
import Model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.time.LocalDate;

public class EditarPaciente {
    @FXML
    private TextField txtNome;

    @FXML private TextField txtCPF;

    @FXML private TextField txtCid;

    @FXML private TextField txtCrm;


    @FXML private Button addPaciente;

    @FXML private ToggleGroup respostaConvenio;

    @FXML private ComboBox<Estado.EstadoClinico> cbEstado = new ComboBox<>();

    private LocalDate data = LocalDate.now();
    public void initialize()
    {
        cbEstado.getItems().setAll(Estado.EstadoClinico.values());

    }
    public boolean confereConvenio(String resposta)
    {
        if(! "NÃO".equals(resposta))
        {
            return true;
        }
        else{
            return false;
        }
    }


    public void updatePaciente(ActionEvent actionEvent) {
        RadioButton radio = (RadioButton) respostaConvenio.getSelectedToggle();
        Estado.EstadoClinico respostaComboBox  = cbEstado.getSelectionModel().getSelectedItem();
        if(!"".equals(txtNome.getText()) && !"".equals(txtCPF.getText()) && !"".equals(radio.getText()) && !"".equals(respostaComboBox)&& !"".equals(txtCid.getText())&& !"".equals(txtCrm.getText()))
        {
            Paciente p = new Paciente();
            Medico m = new Medico();
            Doenca d = new Doenca();

            p = PacienteDAO.read(txtCPF.getText());
            p.setNome(txtNome.getText());
            p.setDataAlta(data);
            p.setEstadoClinico(respostaComboBox);
            p.setPossuiConvenio(confereConvenio(radio.getText()));

            m = MedicoDAO.read(txtCrm.getText());
            p.setMedicoResp(m);

            d = DoencaDAO.read(txtCid.getText());
            p.setDoenca(d);


            PacienteDAO.update(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "Preencha os dados vazios!");

        }
    }
}
