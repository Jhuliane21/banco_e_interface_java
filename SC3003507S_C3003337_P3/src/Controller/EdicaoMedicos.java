package Controller;

import DAO.DoencaDAO;
import DAO.MedicoDAO;
import Model.Doenca;
import Model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class EdicaoMedicos {
    @FXML private TextField txtNome;
    @FXML private TextField txtCrm;
    @FXML private TextField txtEsp;

    public void updateMed(ActionEvent actionEvent) {
        String crm = txtCrm.getText();
        if(!"".equals(txtCrm.getText()))
        {
            Medico m = new Medico();
            m.setCrm(crm);
            m.setNome(txtNome.getText());
            m.setEspecialidade(txtEsp.getText());

            MedicoDAO.update(m);
        }
        else{
            JOptionPane.showMessageDialog(null,"Digite o CRM do médico a ser editado!");

        }

    }
}
