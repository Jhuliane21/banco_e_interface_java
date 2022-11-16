package Controller;

import DAO.DoencaDAO;
import DAO.MedicoDAO;
import Model.Doenca;
import Model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class ExcluirMedico {

    @FXML private TextField txtCrm;

    public void deleteMedico(ActionEvent actionEvent) {
        String crmDigitado = txtCrm.getText();
        if (!"".equals(txtCrm.getText())) {
            Medico m = MedicoDAO.read(crmDigitado);
            MedicoDAO.delete(m);
        }
        else{
            JOptionPane.showMessageDialog(null,"Digite o CRM para excluir!");
        }
    }
}
