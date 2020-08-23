package mvcbibliotecapersonalizado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BibliotecaModelo {
    //Atributos de nuestro BDMS
    private String  host        = "localhost";
    private String  usuario     = "postgres";
    private String  password    = "AlE@1253";
    private int     puerto      =  5432;
    private String  servidor    = "";

    private String baseDatos;
    private static Connection conexion  = null;
    
    /**
     * Constructor de la clase del Modelo Biblioteca
     * @param baseDatos El parametro baseDatos define el nombre 
     * de la base de datos a conectar.
     */
    public BibliotecaModelo (String baseDatos){
        this.baseDatos = baseDatos;
        conexionBD();
    }
    /**
     * Método para crear la conexion a la Base de Datos
     */
    protected void conexionBD(){
        this.servidor = "jdbc:postgresql://"+host+":"+ puerto+"/"+baseDatos;
        //Registrar el Driver
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.err.println("Error al registrar el DRIVER "+e);
            System.exit(0); //Detienen el proceso
        }
        
        //Establecer la concexion con el servidor
        try{
            conexion = DriverManager.getConnection(this.servidor, this.usuario, this.password);
        }catch(SQLException e){
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0);
        }
        System.out.println("Conectado a " + baseDatos);
    }
    /**
     * Método para obtener el objeto Connection que se usará en Controller
     */
    public Connection getConexion(){
        return conexion;
    }
    
    /**
     * Método para insertar registros de la tabla Cliente
     * @param c El parámetro c define los datos de la tabla Cliente
     */
    boolean insertCliente(Cliente c){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into scbiblioteca.cliente values (?,?,?);";
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setString(1, c.getNif());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            //Ejecutar el comando insert
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Realizado con Éxito.");
            return true;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Inserción de datos: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Método para borrar registros de la tabla Cliente mediante un nif
     * @param c El parámetro c define los datos de la tabla Cliente
     */
    public boolean deleteCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlDeleteCliente = "delete from scbiblioteca.cliente where nif = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlDeleteCliente);
            //Indicar qué información se pasa al Statement
            ps.setString(1, c.getNif());
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            JOptionPane.showMessageDialog(null, "Registro Borrado con Éxito", "Confirmacion", JOptionPane.ERROR_MESSAGE);
            return true;
        }catch (SQLException e) {
            System.err.println("Error en el BORRADO "+ e);
            return false;
        }
    }
    
    /**
     * Método para actualizar registros de la tabla Cliente
     * @param c El parámetro c define los datos de la tabla Cliente
     */
    protected boolean updateCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlUpdateCliente = "update scbiblioteca.cliente set nombre = ?, apellidos = ? where nif = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdateCliente);  
            //Indicar qué información se pasa al procedimiento
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getNif());
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            JOptionPane.showMessageDialog(null, "Actualización de Registro Correctamente");
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la MODIFICACION");
            return false;
        }
    }
    
    protected Cliente selectCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        
        // Objeto con el cliente encontrado
        Cliente clienteEncontrado= null;
            
        String sqlConsulta = "select nif, nombre, apellidos from scbiblioteca.cliente where nif = ?;";
        try{
            //Preparar el statement
            ps  = getConexion().prepareStatement(sqlConsulta);
                       
            //Indicar qué información se pasa al statement
            ps.setString(1, c.getNif());
            //Ejecutar el procedimiento
            rs  = ps.executeQuery();
            //Cargar los datos devueltos en una instancia cliente
            if(rs.next()){
                clienteEncontrado = new Cliente(rs.getString(1), rs.getString(2),rs.getString(3));           
            }
            
        }catch (SQLException e) {
            System.err.println("Error al CARGAR UN CLIENTE "+ e);
        }
        return clienteEncontrado;
    }

    /**
     * Método que regresa en una  lista, los clientes registrados en la bd
     */
    protected List<Object[]> listCliente(){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;
        //Obtener datos de todos los clientes
        String consultaSQL = "Select nif, nombre, apellidos from scbiblioteca.cliente;";
        // Objeto List que contendrá todos los clientes
        List<Object [] > clientes = new ArrayList<Object []>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Object clt [] = new Object[3];
                //Añadir registro a registro en el vector
                /**clt[0] = rs.getString("nif");
                clt[1] = rs.getString("nombre");
                clt[2] = rs.getString("apellidos");*/
                clt[0] = rs.getString(1);
                clt[1] = rs.getString(2);
                clt[2] = rs.getString(3);
                // agregar a la lista cada uno de los clientes
                clientes.add(clt);
            }
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return clientes;
    }
    
    public void Listar(){
        List <Object []> datos = listCliente();
        for(int i = 0; i < datos.size() ; i++)
            System.out.println(
                    datos.get(i)[0]+" -- "+
                    datos.get(i)[1]+" -- "+
                    datos.get(i)[2]+" -- ");
    }
    
    public ResultSet getTabla(String consulta){
        Statement st;
        ResultSet datos = null;
        try{
            st = getConexion().createStatement();
            datos = st.executeQuery(consulta);
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error Mostrar Tabla");
        }
        return datos;
    }
    
    /**
     * Método que se encarga de cerrar la conexión activa de la BD
     */
    protected void closeConexion(){
    // verifica que la conexión esté activa
        if ( getConexion() != null){
            try {
                getConexion().close();
            } catch(SQLException e){
                System.err.println("Error al cerrar la bd "+ e);
            }
        }
    }
}
