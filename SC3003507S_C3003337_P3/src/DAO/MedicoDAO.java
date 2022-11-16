package DAO;


import Connection.ConnectionFactory;
import Model.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void create(Medico d){
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO medicos(crm,especialidade,nome) VALUES(?,?,?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,d.getCrm());
            stmt.setString(2,d.getEspecialidade());
            stmt.setString(3,d.getNome());


            stmt.execute();

            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);

        }
    }
    public static Medico read(String crm)
    {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM medicos WHERE crm = ?";
        Medico m = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,crm);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                m = new Medico(rs.getString("nome"),rs.getString("especialidade"),rs.getString("crm"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt);

        }
        return m;

    }
    public static List<Medico> readAll(){
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM medicos");
            rs = stmt.executeQuery();

            while(rs.next())
            {

                Medico m = new Medico();
                m.setNome(rs.getString("Nome"));
                m.setEspecialidade(rs.getString("Especialidade"));
                m.setEspecialidade(rs.getString("CRM"));
                medicos.add(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return medicos;
    }
    public static void update(Medico d) {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        String sql = "UPDATE medicos SET especialidade=?,nome=? WHERE crm=?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,d.getEspecialidade());
            stmt.setString(2,d.getNome());
            stmt.setString(3,d.getCrm());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }

    }
    public static void delete(Medico m)  {
        Connection con= ConnectionFactory.createConnection();
        PreparedStatement stmt = null;

        String sql =  "DELETE FROM medicos WHERE crm = ?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,m.getCrm());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluído com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }

    }

}


