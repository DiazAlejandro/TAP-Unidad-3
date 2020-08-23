package mvcbiblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

public class ControladorBiblioteca implements ActionListener, MouseListener{
    private VistaBiblioteca view;
    private ModeloBiblioteca modelo;
    /**
     * Constructor de la clase Controlador Biblioteca
     * @param view, modelo view determina una intancia de la clase VistaBiblioteca 
     * y el modelo que se encarga de realizar todo lo relacionado 
     * con las operaciones con la base de datos
     */
    public ControladorBiblioteca( VistaBiblioteca view , ModeloBiblioteca modelo){
        this.view   = view;
        this.modelo = modelo;
        cargarTabla();
    }
    
    public void actionPerformed(ActionEvent arg0) {
        Cliente c;
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand(); 
        //Deberá coincidir con alguno de los parámetros indicados en setActionCommand invocado en la
        //  clase VistaBiblioteca
        switch (comando) {
            case "INSERTAR":
                c = new Cliente(this.view.txtNIF.getText(), 
                                this.view.txtNombre.getText(), 
                                this.view.txtApellido.getText());
                modelo.insertCliente(c);
            break;
 
            case "BORRAR":
                //Obtener qué fila se ha pulsado
                int filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se obtiene el nif del cliente

                    //int identificador   = (int)this.view.dtm.getValueAt(filaPulsada, 0);
                    c = new Cliente();
                    String nif = (String) this.view.dtm.getValueAt(filaPulsada,0);
                    c.setNif(nif);
                    modelo.deleteCliente(c);
                }
 
            break;
 
            case "MODIFICAR":
                //Obtener qué fila se ha pulsadao en la tabla
                filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se obtiene el nif de la fila pulsada
                    c = new Cliente();
                    String nif = (String) this.view.dtm.getValueAt(filaPulsada,0);
                    c.setNif(nif);

                    // Se obtienen el nombre y los apellidos de los cuadros de texto
                    c.setNombre(this.view.txtNombre.getText());
                    c.setApellidos(this.view.txtApellido.getText());
                    modelo.updateCliente(c);                    
                }
            break;
             
            case "SALIR":

                // Si se seleccionó salir, se invoca el método que cierra nuestra conexión a la bd y cierra el frame
                 modelo.closeConexion();
                 this.view.dispose();
            break;
            
            default:
                System.err.println("Comando no definido");
            break;
        }
        //limpiar el formulario
        limpia();
 
        //refrescar la tabla
        cargarTabla();
        
        
    }
    /**
     * Método para limpliar el formulario
     */
    private void limpia(){
        this.view.txtNombre.setText("");
        this.view.txtApellido.setText("");
        this.view.txtNIF.setText("");
    }
    
    /**
     * Método para cargar los registros de la tabla clientes
     */
    protected void cargarTabla(){
        Vector<Object> fila;
 
        //Limpiar los datos de la tabla
        for(int i=this.view.dtm.getRowCount(); i>0; i--){
            this.view.dtm.removeRow(i-1);
        }
        // Listado de los clientes que retornó el modelo
        List<Cliente> clientes = modelo.listCliente();
        for(Cliente c: clientes){
            //Añadir registro a registro en el vector
            fila    = new Vector<Object>();
            fila.add(c.getNif());
            fila.add(c.getNombre());
            fila.add(c.getApellidos());
            //Añadir el vector a la tabla de la clase View
            this.view.dtm.addRow(fila);
        }
    }
    
    /**
     * Método qye obtiene la fila pulsada de la tabla, para buscar los datos en
     * la base de datos a través del modelo y cargarlos en los cuadros de texto
     * correspondientes.
     * @param arg0 
     */
    public void mouseClicked(MouseEvent arg0) {
        //Recoger qué fila se ha pulsadao en la tabla
        int filaPulsada = this.view.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0){
            //Se recoge el id de la fila marcada
            Cliente c = new Cliente();
            String nif= (String) this.view.dtm.getValueAt(filaPulsada, 0);
            c.setNif(nif);
            Cliente c2 = modelo.selectCliente(c);
            if (c2 != null){
                this.view.txtNIF.setText(c2.getNif());
                this.view.txtNombre.setText(c2.getNombre());
                this.view.txtApellido.setText(c2.getApellidos());
            }

        }
    }
  // Se implementan el resto de los métodos declarados en las interfaces
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
}
