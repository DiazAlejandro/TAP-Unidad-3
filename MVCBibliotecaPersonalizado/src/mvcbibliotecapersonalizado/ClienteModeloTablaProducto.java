package mvcbibliotecapersonalizado;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteModeloTablaProducto extends AbstractTableModel{
    public List <Object []> datos;
    private String namesColums [] = {"NIF","NOMBRE","APELLIDOS"};
    private Class  classColums [] = {String.class, String.class, String.class};
    
    public void setDatos(List <Object []> datos){
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return namesColums.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return datos.get(r)[c];
    }
    
    @Override
    public String getColumnName(int c){
            return namesColums[c];
    }
    
    public Class getColumnClass(int c){
        return classColums[c];
    }
}
