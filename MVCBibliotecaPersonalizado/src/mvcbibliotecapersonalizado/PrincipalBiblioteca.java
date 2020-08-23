/**
 * Interfaz para poder realiar las operaciones con el DBMS
 * @autor Alejandro Diaz Ruiz
 * @version 20-04-2020
 */
package mvcbibliotecapersonalizado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrincipalBiblioteca extends javax.swing.JFrame {
    /**Objetos de la clase cliente y una instancia de la clase BibliotecaModelo*/
    Cliente cliente;
    BibliotecaModelo modeloCliente = new BibliotecaModelo("dbbiblioteca");
    
    /**Cosntructor del Frame*/
    public PrincipalBiblioteca() throws SQLException {
        initComponents();
        modeloCliente = new BibliotecaModelo("dbbiblioteca");
        modeloCliente.Listar();
        this.setLocationRelativeTo(null);
        mostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtNif = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Personal Biblioteca");

        jLabel2.setText("NIF:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(22, 22, 22))
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNif, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                            .addComponent(txtName))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**Método del evento actionPermormed del botón INSERTAR 
     * @param evt Parametro del evento.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Crea un nuevo objeto de la clase cliente con datos que se ingresaron desde los JTextField
        cliente = new Cliente((String)txtNif.getText(), 
                              (String)txtName.getText(), 
                              (String)txtLastName.getText());
        /**Del modeloCliente implementamos el método insertar y
         * le pasamos como parámetro el objeto cliente creado anteriormente*/
        modeloCliente.insertCliente(cliente);
        
        try {
            mostrar(); //Actualiza la tabla cada que se inserta un nuevo registro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos", 
                    "Confirmacion", JOptionPane.ERROR_MESSAGE);
        }
        limpiar(); //Limpiar los campos del formulario
    }//GEN-LAST:event_jButton1ActionPerformed

    /**Método del evento actionPermormed del botón BORRAR
     * Borra los registros de la tabla seleccionando un renglón  (tupla)
     * @param evt Parametro del evento.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filaPulsada = tabla.getSelectedRow(); //Obtener qué fila se ha pulsado
        if(filaPulsada >= 0){               //Condicion si se ha pulsado una fila
            cliente = new Cliente();
            String nif = (String) tabla.getValueAt(filaPulsada,0); //Se obtiene el nif del cliente
            cliente.setNif(nif);
            modeloCliente.deleteCliente(cliente); //Ejecuta el comando delete del modelo
        }
        try {
            mostrar(); //Actualiza la tabla cada que se borra un nuevo registro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos", 
                    "Confirmacion", JOptionPane.ERROR_MESSAGE);
        }
        limpiar();    //Limpiar los campos del formulario
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**Método del evento actionPermormed del botón Actualizar
     * Actualiza los registros de la tabla seleccionando un renglón  (tupla)
     * @param evt Parametro del evento.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaPulsada = tabla.getSelectedRow(); //Obtener qué fila se ha pulsado
        if(filaPulsada>=0){ //Si se ha pulsado una fila
            cliente = new Cliente();
            String nif = (String) tabla.getValueAt(filaPulsada,0); //Se obtiene el nif de la fila pulsada
            cliente.setNif(nif);
            
            // Se obtienen el nombre y los apellidos y se muestran en los cuadros de texto
            cliente.setNombre(txtName.getText());
            cliente.setApellidos(txtLastName.getText());
            modeloCliente.updateCliente(cliente); //Ejecuta la instruccion update
        }
        try {
            mostrar();  //Actualiza la tabla cada que se actualiza un nuevo registro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos", 
                    "Confirmacion", JOptionPane.ERROR_MESSAGE);
        }
        limpiar();  //Limpiar los campos del formulario
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**Método del evento actionPermormed del botón Salir
     * Cierra el programa
     * @param evt Parametro del evento.
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        //Recoger qué fila se ha pulsadao en la tabla
        int filaPulsada = tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0){
            //Se recoge el id de la fila marcada
            Cliente c = new Cliente();
            String nif = (String) tabla.getValueAt(filaPulsada,0);
            c.setNif(nif);
            Cliente c2 = modeloCliente.selectCliente(c);
            if (c2 != null){
                txtNif.setText(c2.getNif());
                txtName.setText(c2.getNombre());
                txtLastName.setText(c2.getApellidos());
            }
        }
    }//GEN-LAST:event_tablaMouseClicked
    
    public void limpiar(){
        txtNif.setText("");
        txtName.setText("");
        txtLastName.setText("");
    }
    
    /**
     * Método que se encarga de mostrar los datos de la base de datos dentro
     * de la tabla
     */
    public void mostrar() throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "Select nif, nombre, apellidos from scbiblioteca.cliente;";
        ResultSet rs = modeloCliente.getTabla(SQL);
        modelo.setColumnIdentifiers(new Object[]{"NIF", "NOMBRE","APELLIDOS"});
        try{
            while(rs.next()){
                modelo.addRow(new Object[]{
                rs.getString("nif"),
                rs.getString("nombre"),
                rs.getString("apellidos")});
            }
            tabla.setModel(modelo);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PrincipalBiblioteca().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNif;
    // End of variables declaration//GEN-END:variables
}
