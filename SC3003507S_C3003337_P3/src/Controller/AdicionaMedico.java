package Controller;

import DAO.MedicoDAO;
import Model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AdicionaMedico {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCrm;
    @FXML
    private TextField txtEsp;

    public void adicionaMed(ActionEvent actionEvent) {
        if (!"".equals(txtNome.getText()) && !"".equals(txtCrm.getText()) && !"".equals(txtEsp.getText()))
        {
            Medico m = new Medico();
            MedicoDAO dao = new MedicoDAO();
            m.setNome(txtNome.getText());
            m.setCrm(txtCrm.getText());
            m.setEspecialidade(txtEsp.getText());
            dao.create(m);

        }
        else{
                JOptionPane.showMessageDialog(null,"Preencha os campos vazios!");

            }


    }
}