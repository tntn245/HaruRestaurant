/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;
/**
 *
 * @author My PC
 */
public class ExcuteSQLStatement {
    public static ResultSet ExcuteSQLQuery(String sqlStatement, Connection connect) {
        try {
            Statement st = connect.createStatement();
            ResultSet resultSet = st.executeQuery(sqlStatement);
            return resultSet;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void ExcuteSQLUpdate(String sqlStatement, Connection connect)
    {
        try {
            Statement st = connect.createStatement();
            st.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
