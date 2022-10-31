package singletonMySQL;

import java.sql.SQLException;

public class SingletonMySqlMain {
    public static void main(String[]arg) throws SQLException {
        MySQLClient mysqlClient = MySQLClient.getClient();

        System.out.println(mysqlClient.getNameById(2));
        System.out.println(mysqlClient.getNameById(3));

//      No se puede volver a instanciar la Clase MySQLClient
        MySQLClient mysqlClient2 = MySQLClient.getClient();
    }
}
