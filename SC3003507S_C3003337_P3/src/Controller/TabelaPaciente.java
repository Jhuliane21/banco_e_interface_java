package Controller;

import DAO.PacienteDAO;
import Loader.*;
import Model.Doenca;
import Model.Medico;
import Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TabelaPaciente {
    @FXML
    private TableView<Paciente> tabela;
    @FXML
    private TableColumn<Paciente, String> tbNome;
    @FXML
    private TableColumn<Paciente, String> tbcpf;
    @FXML
    private TableColumn<Paciente, String> tbentrada;
    @FXML
    private TableColumn<Paciente, Integer> tbalta;
    @FXML
    private TableColumn<Paciente, Boolean> tbconvenio;
    @FXML private TableColumn<Paciente, String> tbCrm;
    @FXML private TableColumn<Paciente, String> tbCid;
    @FXML
    private TableColumn<Paciente, String> tbclinico;
    private LocalDate data = LocalDate.now();

    ObservableList<Paciente> pacientes;
    List<Paciente> pacientesList = new ArrayList<>();
    PacienteDAO dao = new PacienteDAO();
    public void initialize()
    {
        pegandoDados();
        ligarTabelaModelo();
        ligandoDados();
        carregandoDadosTabela();
    }

    private void ligandoDados() {
        pacientes = FXCollections.observableArrayList();
        tabela.setItems(pacientes);
    }
    private void carregandoDadosTabela() {
        pacientes.clear();
        pacientes.addAll(pacientesList);
        tabela.refresh();
    }

    public void pegandoDados()
    {
        //PacienteDAO dao = new PacienteDAO();
        /*for(Paciente p: dao.readAll())
        {
            p.setNome(p.getNome());
            p.setCpf(p.getCpf());
            p.setDataEntrada(p.getDataEntrada());
            p.setDataAlta(p.getDataAlta());
            p.setEstadoClinico(p.getEstadoClinico());
            p.setPossuiConvenio(p.getPossuiConvenio());
            p.setMedicoResp(p.getMedicoResp().getCrm());
            p.setDoenca(p.getDoenca().getCID10());
            pacientesList.add(p);
        }*/
        pacientesList = PacienteDAO.readAll();

    }

    private void LigandoDados() {
        pacientes = FXCollections.observableArrayList();
        tabela.setItems(pacientes);
    }
    private void ligarTabelaModelo()
    {
        tbNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tbentrada.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
        tbalta.setCellValueFactory(new PropertyValueFactory<>("dataAlta"));
        tbconvenio.setCellValueFactory(new PropertyValueFactory<>("possuiConvenio"));
        tbclinico.setCellValueFactory(new PropertyValueFactory<>("estadoClinico"));
        tbCrm.setCellValueFactory(new PropertyValueFactory<>("medicoResp"));
        tbCid.setCellValueFactory(new PropertyValueFactory<>("doenca"));
    }

    public void addPac(ActionEvent actionEvent) {
        JanelaAdicionar janela = new JanelaAdicionar();
        janela.MostrarTravar();


    }

    public void updatePac(ActionEvent actionEvent) {
    JanelaEditarPaciente janela = new JanelaEditarPaciente();
    janela.EditarPaciente();
    }

    public void deletePac(ActionEvent actionEvent) {
        JanelaExcluirPaciente janela = new JanelaExcluirPaciente();
        janela.ExcluirPaciente();
    }

    public void addMed(ActionEvent actionEvent) {
        JanelaMedico janela = new JanelaMedico();
        janela.JanelaCadastroMedico();

    }

    public void updateMed(ActionEvent actionEvent) {
    JanelaEdicaoMedico janela = new JanelaEdicaoMedico();
    janela.JanelaEdicaoMedico();
    }

    public void deleteMed(ActionEvent actionEvent) {
        JanelaExcluirMedico janela = new JanelaExcluirMedico();
        janela.ExcluirMedico();
    }

    public void addDoenca(ActionEvent actionEvent) {
        JanelaDoenca janela = new JanelaDoenca();
        janela.JanelaCadastroDoenca();
    }

    public void updateDoenca(ActionEvent actionEvent) {
    JanelaEdicaoDoenca janela = new JanelaEdicaoDoenca();
    janela.EdicaoDoenca();
    }


    public void deleteDoenca(ActionEvent actionEvent) {
        JanelaExcluirDoenca janela = new JanelaExcluirDoenca();
        janela.ExcluirDoenca();
    }
}
