package Connection;


import java.sql.*;

public class ConnectionFactory implements AutoCloseable {// para o try-with-resources
    private  static Connection connection;
    private  static PreparedStatement preparedStatement;
    private static Statement statement;


    public static Connection createConnection()
    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raiane\\IdeaProjects\\SC3003507S_C3003337_P3\\.idea\\hospital.db");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //cria um objeto statement
    public static PreparedStatement createPreparedStatement(String sql)
    {
        try {
            preparedStatement = createConnection().prepareStatement(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
    public static Statement createStatement()
    {
        try{
            statement = createConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }
    public static void closeConnection(Connection con){

        try {
            if(con!=null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeConnection(Connection con,PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt!=null) {
                stmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeConnection(Connection con,PreparedStatement stmt,ResultSet rs) {
        closeConnection(con,stmt);
        try {
            if(rs!=null) {
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {//invocado no final  do try-with-resources
        if(connection != null)
        {
            connection.close();
            if(statement != null)
                statement.close();
        }
    }
}
