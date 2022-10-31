package singletonMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLClient {
    private static MySQLClient client = null;
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    final String server = "localhost";
    final String dataBase = "exampleDB";
    final String user = "root";
    final String pass = "";
    private MySQLClient()
    {
        try{
            String connection = String.format("jdbc:mysql://%s:3306/%s", server, dataBase);
            connect = DriverManager.getConnection(connection, user, pass);
            statement = connect.createStatement();
        }
        catch( SQLException me){
            me.getStackTrace();
        }
    }
    public static MySQLClient getClient()
    {
        if (client == null){
            System.out.println("Primera vez");
            client = new MySQLClient();
        }
        return client;
    }
    public String getNameById(int id)  {
        String name = "";
        try{
            resultSet = this.statement.executeQuery("select name from person where id="+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");
            }
        }
        catch (SQLException ex){
            ex.getStackTrace();
        }
        return name;
    }
}
