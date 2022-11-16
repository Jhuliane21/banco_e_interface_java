package Controller;

import DAO.DoencaDAO;
import Model.Doenca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Doencas {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCid;
    @FXML
    private TextField txtDesc;

    ObservableList<Doenca> listaDoencas;
    private int flag;
    public void initialize() {
        readList();
    }

    private void readList() {
        listaDoencas = FXCollections.observableArrayList();
        DoencaDAO pdao = new DoencaDAO();
        for (Doenca d : pdao.readAll()) {
            Doenca doenca = new Doenca(d.getNome(), d.getCID10(), d.getDescricao());
            listaDoencas.add(doenca);

        }
    }
    public void add(ActionEvent actionEvent) {
        if (!"".equals(txtNome.getText()) && !"".equals(txtCid.getText()) && !"".equals(txtDesc.getText()))
        {
            Doenca d = new Doenca();
            DoencaDAO dao = new DoencaDAO();

        d.setNome(txtNome.getText());
        d.setCID10(txtCid.getText());
        d.setDescricao(txtDesc.getText());

        dao.create(d);
        listaDoencas.add(d);
        readList();

    }
        else{
            JOptionPane.showMessageDialog(null,"Preencha os campos vazios!");

        }
    }
}

