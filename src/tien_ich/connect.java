/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien_ich;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class connect {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection oConn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        oConn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTP;user=sa;password=123");
        return oConn;
    }
    
    public static void closeConnection(Connection oConn) throws SQLException{
        if (oConn != null) {
            oConn.close();
        }
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }
    }
}
