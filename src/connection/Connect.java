/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My PC
 */
public class Connect {
    Connection connect = null;
    public Connection LinkConnection(String jdbc, String user, String password){
        try{
            connect = DriverManager.getConnection(jdbc, user, password);
            System.out.println("Connection successful" + connect);
            return connect;
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
            return null;
        }
    }
    public void CloseConnection(){
        try {
            connect.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
}
