package Controller;

import DAO.DoencaDAO;
import Model.Doenca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;


public class ExcluirDoenca {
    @FXML private TextField txtCid;

    public void delete(ActionEvent actionEvent) {
        String cidSelecionado = txtCid.getText();
        if (!"".equals(txtCid.getText())) {
            Doenca d = DoencaDAO.read(cidSelecionado);
            DoencaDAO.delete(d);
        }
        else{
            JOptionPane.showMessageDialog(null,"Digite o CID para excluir!");
        }
    }
}
