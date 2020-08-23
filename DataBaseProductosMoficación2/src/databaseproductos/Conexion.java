package databaseproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    Connection conn;
    boolean bandera;
    //URL de la base de datos. PRODUCTO
    final String url = "jdbc:derby://localhost:1527/";

    public Conexion(String BD, String user, String pass){
        try {
            conn = DriverManager.getConnection(url+""+BD.toLowerCase(),user,pass);
            if (conn.isClosed()) {
            } else {
                bandera = true;
                //JOptionPane.showMessageDialog(null,"Conexion Creada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean getBandera(){
        return bandera;
    
    }
    
    public Connection getConecction(){
        return conn;
    }
    
    public ResultSet getTabla(String consulta){
        Connection cn = getConecction();
        Statement st;
        ResultSet datos = null;
        try{
            st = conn.createStatement();
            datos = st.executeQuery(consulta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
        return datos;
    }
    
}
