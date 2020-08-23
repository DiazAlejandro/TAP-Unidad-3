package databaseproductos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProducto extends AbstractTableModel{
    public List <Object []> datos;
    private String nomColumnas [] = {"IdProd","Nombre","Cantidad","Precio","Comprar","Importe"};
    private Class  claColumnas [] = {Integer.class, String.class, Integer.class, Double.class,Integer.class,Double.class};
    
    public String [] getNameColumnas(){
        return nomColumnas;
    }
    
    public void setDatos(List <Object []> datos){
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nomColumnas.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return datos.get(r)[c];
    }
    @Override
    public String getColumnName(int c){
            return nomColumnas[c];
    }
    
    public Class getColumnClass(int c){
        return claColumnas[c];
    }
    @Override
    public boolean isCellEditable(int r, int c){
        if (c == 3) {
            System.out.println("No se edita la columna 3");
            return true;}else
        return false;
    }
}
