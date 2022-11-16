package DAO;

import Model.Doenca;
import Model.Estado;
import Model.Medico;
import Model.Paciente;
import Model.Estado.EstadoClinico;
import javax.swing.*;
import java.sql.Connection;
import Connection.ConnectionFactory;
import javafx.scene.control.DatePicker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

    public class PacienteDAO {
    public static int confereConvenio(boolean resposta)
    {
        if(resposta == true)
        {
            return 1;
        }
        else{
            return 0;
        }
    }
        public static boolean confereConvenio(int resposta)
        {
            if(resposta == 1)
            {
                return true;
            }
            else{
                return false;
            }
        }
        public static LocalDate conversaoString(String data)
        {
            DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate date = LocalDate.parse(data,formatacao);
            return date;

        }
        private static Estado.EstadoClinico conversaoEnum(String estadoClinico) {
            Estado.EstadoClinico enumConvertido;
            enumConvertido = Estado.EstadoClinico.valueOf(estadoClinico);
            return enumConvertido;
        }
        public static void create(Paciente p){
             Connection con = ConnectionFactory.createConnection();
            PreparedStatement stmt = null;
            String sql = "INSERT INTO pacientes(cpf,nome,dataEntrada,dataAlta,estadoClinico,convenio,crm,cid10) VALUES(?,?,?,?,?,?,?,?)";
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getCpf());
                stmt.setString(2,p.getNome());
                stmt.setString(3,p.getDataEntrada().toString());
                stmt.setString(4,p.getDataAlta().toString());
                stmt.setString(5,p.getEstadoClinico().toString());
                stmt.setInt(6,confereConvenio(p.getPossuiConvenio()));
                System.out.println(confereConvenio(p.getPossuiConvenio()));
                stmt.setString(7,p.getMedicoResp().getCrm());
                stmt.setString(8,p.getDoenca().getCID10());


                stmt.execute();

                JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao salvar: "+e);
            }finally {
                ConnectionFactory.closeConnection(con,stmt);

            }
        }
        public static Paciente read(String cpf)
        {
            Connection con = ConnectionFactory.createConnection();
            PreparedStatement stmt = null;
            String sql = "SELECT * FROM pacientes WHERE cpf = ?";
            Paciente p = new Paciente();
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1,cpf);
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    Medico medico = new Medico();

                    Doenca doenca = new Doenca();
                    p.setCpf(rs.getString("cpf"));
                    p.setNome(rs.getString("nome"));
                    p.setDataEntrada(conversaoString(rs.getString("dataEntrada")));
                    p.setDataAlta(conversaoString(rs.getString("dataAlta")));
                    p.setEstadoClinico(conversaoEnum(rs.getString("estadoClinico")));
                    medico.setCrm((rs.getString("crm")));
                    doenca.setCID10(rs.getString("cid10"));

                    p.setMedicoResp(medico);
                    p.setDoenca(doenca);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                ConnectionFactory.closeConnection(con,stmt);

            }
            return p;

        }
        public static List<Paciente> readAll(){
            Connection con = ConnectionFactory.createConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM pacientes";
            List<Paciente> pacientes = new ArrayList<>();

            try {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while(rs.next())
                {

                    Paciente d = new Paciente();

                    d.setCpf(rs.getString("cpf"));
                    d.setNome(rs.getString("nome"));
                    d.setDataEntrada(conversaoString(rs.getString("dataEntrada")));
                    d.setDataAlta(conversaoString(rs.getString("dataAlta")));
                    d.setEstadoClinico(conversaoEnum(rs.getString("estadoClinico")));
                    d.setPossuiConvenio(confereConvenio(rs.getInt("convenio")));

                    Medico medico = new Medico();
                    medico.setCrm(rs.getString("crm"));

                    Doenca doenca = new Doenca();
                    doenca.setCID10(rs.getString("cid10"));

                    d.setMedicoResp(medico);
                    d.setDoenca(doenca);
                    pacientes.add(d);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {

                ConnectionFactory.closeConnection(con,stmt,rs);
            }
            return pacientes;
        }



        public static void update(Paciente d) {
            Connection con = ConnectionFactory.createConnection();
            PreparedStatement stmt = null;
            String sql = "UPDATE pacientes SET nome=?,dataEntrada=?,dataAlta=?,estadoCLinico=?,convenio=?,crm=?,cid10=? WHERE cpf=?";
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1,d.getNome());
                stmt.setString(2,d.getDataEntrada().toString());
                stmt.setString(3,d.getDataAlta().toString());
                stmt.setString(4,d.getEstadoClinico().toString());
                stmt.setInt(5,confereConvenio(d.getPossuiConvenio()));
                stmt.setString(6,d.getMedicoResp().getCrm());
                stmt.setString(7,d.getDoenca().getCID10());
                stmt.setString(8,d.getCpf());

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+e);
            }finally {
                ConnectionFactory.closeConnection(con,stmt);
            }

        }
        public static void delete(Paciente p)  {
            Connection con= ConnectionFactory.createConnection();
            PreparedStatement stmt = null;

            String sql =  "DELETE FROM pacientes WHERE cpf = ?";
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getCpf());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Excluído com sucesso!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir: "+e);
            }finally {
                ConnectionFactory.closeConnection(con,stmt);
            }

        }

    }




