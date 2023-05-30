/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jiang
 */
public class ExcuteSQLStatement1 {
    public static ResultSet ExcuteSQLQuery(String sqlStatement) {
        try {
            ConnectNotUse conn = new ConnectNotUse();
            Connection con = conn.LinkConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "MANAGER_RES", "1");
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sqlStatement);
            return resultSet;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void ExcuteSQLUpdate(String sqlStatement)
    {
        try {
            ConnectNotUse conn = new ConnectNotUse();
            Connection con = conn.LinkConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "MANAGER_RES", "1");
            Statement st = con.createStatement();
            st.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
