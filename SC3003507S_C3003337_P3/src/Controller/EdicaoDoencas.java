package Controller;

import DAO.DoencaDAO;
import Model.Doenca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;


public class EdicaoDoencas {

    @FXML private TextField txtCidAntigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtDesc;

    public void update(ActionEvent actionEvent) {

        String cidAntigo = txtCidAntigo.getText();
        if(!"".equals(txtCidAntigo.getText()) && !"".equals(txtNome.getText()) && !"".equals(txtDesc.getText()))
        {
            Doenca d = new Doenca();
            d.setCID10(cidAntigo);
            d.setNome(txtNome.getText());
            d.setDescricao(txtDesc.getText());

            DoencaDAO.update(d);
        }
        else{
            JOptionPane.showMessageDialog(null,"Preencha os campos!");

        }

    }


    }


