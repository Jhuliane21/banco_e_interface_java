package Model;

import java.time.LocalDate;
public class Paciente {
    private String nome, cpf;
    private LocalDate dataEntrada, dataAlta = LocalDate.now();
    private Estado.EstadoClinico estadoClinico;
    private boolean possuiConvenio;
    private Medico medicoResp;
    private Doenca doenca;
    public Paciente() {

    }


    public Paciente(String nome, String cpf, LocalDate dataEntrada, LocalDate dataAlta, Estado.EstadoClinico estadoClinico, boolean possuiConvenio, Medico medicoResp, Doenca doenca) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataEntrada = dataEntrada;
        this.dataAlta = dataAlta;
        this.estadoClinico = estadoClinico;
        this.possuiConvenio = possuiConvenio;
        this.medicoResp = medicoResp;
        this.doenca = doenca;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Estado.EstadoClinico getEstadoClinico() {
        return estadoClinico;
    }

    public void setEstadoClinico(Estado.EstadoClinico estadoClinico) {
        this.estadoClinico = estadoClinico;
    }

    public boolean getPossuiConvenio() {
        return possuiConvenio;
    }

    public void setPossuiConvenio(boolean possuiConvenio) {
        this.possuiConvenio = possuiConvenio;
    }

    public Medico getMedicoResp() {
        return medicoResp;
    }

    public void setMedicoResp(Medico medicoResp) {
        this.medicoResp = medicoResp;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }
}