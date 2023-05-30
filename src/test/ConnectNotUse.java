
package test;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jiang
 */
public class ConnectNotUse {
        java.sql.Connection connect = null;
    public java.sql.Connection LinkConnection(String jdbc, String user, String password){
        try{
            connect = DriverManager.getConnection(jdbc, user, password);
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
