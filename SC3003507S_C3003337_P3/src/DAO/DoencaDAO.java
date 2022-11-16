package DAO;

import Model.Doenca;
import Connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoencaDAO {

    public void create(Doenca d){
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO doencas(cid10,descricao,nome) VALUES(?,?,?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,d.getCID10());
            stmt.setString(2,d.getDescricao());
            stmt.setString(3,d.getNome());


            stmt.execute();

            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);

        }
    }
    public static Doenca read(String cid)
    {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM doencas WHERE cid10 = ?";
        Doenca d = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
            d = new Doenca(rs.getString("cid10"),rs.getString("nome"),rs.getString("descricao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con,stmt);

        }
        return d;

    }
    public static List<Doenca> readAll(){
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Doenca> doencas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM doencas");
            rs = stmt.executeQuery();

            while(rs.next())
            {

                Doenca d = new Doenca();
                d.setNome(rs.getString("Nome"));
                d.setCID10(rs.getString("CID10"));
                d.setDescricao(rs.getString("Descricao"));
                doencas.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return doencas;
    }
    public static void update(Doenca d) {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
        //cid10,descricao,nome
        String sql = "UPDATE doencas SET descricao=?,nome=? WHERE cid10=?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,d.getDescricao());
            stmt.setString(2,d.getNome());
            stmt.setString(3,d.getCID10());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }

    }
    public static void delete(Doenca d)  {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;

        String sql =  "DELETE FROM doencas WHERE cid10 = ?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,d.getCID10());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluído com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }

    }

}


