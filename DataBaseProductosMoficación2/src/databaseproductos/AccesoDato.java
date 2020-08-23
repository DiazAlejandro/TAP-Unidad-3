package databaseproductos;

import javax.swing.JOptionPane;

public class AccesoDato {
    Conexion conex = new Conexion("producto","adm", "12345");
    // Sql es una cadena que indica una sentencia sql de un "INSERT O UPDATE"
    public boolean actualizaDatos(String sql){ 
        boolean res=false;
        try{
            java.sql.Statement st=  conex.getConecction().createStatement();
            st.executeUpdate(sql);
            res = true;
            JOptionPane.showMessageDialog(null, "Registro agregado Correctamente");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al ejecutar la orden.");
        }    
        return res;  
    
    }
    
    public String SQL(int idProd, String descripcion, int cantidad, double precio){
        //"VALUES (?,?,?,?)"
        return "INSERT INTO ADM.PRODUCTOS (idProd, descripcion, cantidad, precio) VALUES("+idProd+",'"+descripcion+"',"+cantidad+","+precio+")";
    }
}
