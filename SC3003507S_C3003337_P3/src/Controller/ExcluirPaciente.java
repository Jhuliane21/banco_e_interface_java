package Controller;

import DAO.PacienteDAO;
import Model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class ExcluirPaciente {
    @FXML private TextField txtCPF;

    public void deletePaciente(ActionEvent actionEvent){
        String cpf = txtCPF.getText();
        if (!"".equals(txtCPF.getText())) {
            Paciente p = PacienteDAO.read(cpf);
            PacienteDAO.delete(p);
        }
        else{
            JOptionPane.showMessageDialog(null,"Digite o CPF para excluir!");
        }
    }
}
