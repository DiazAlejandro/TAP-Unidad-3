package mvcbiblioteca;

import javax.swing.*; //Importa las librerias necesarias
import javax.swing.table.DefaultTableModel;

public class VistaBiblioteca extends JFrame{
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DECLARACIÓN DE LAS ETIQUETAS
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblNIF;
 
    //DECLARACIÓN DE LOS CUADROS DE TEXTO
    protected JTextField txtNombre;
    protected JTextField txtApellido;
    protected JTextField txtNIF;
 
    //DECLARACIÓN DE LOS BOTONES
    protected JButton btnAdd;  // Agregar
    protected JButton btnDel;  // Borrar
    protected JButton btnUpd;  // Editar
    protected JButton btnExit; // Salir
 
    //DECLARACIÓN DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll;     //Panel de scroll que contiene la tabla
    protected Object[][] datos;     //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Modelo de la tabla, el cual es el predeterminado
    protected JTable tabla;         //Tabla 
    
    VistaBiblioteca() {
        setBounds(100, 100, 450, 400);           //Dimensiones del frame
        setTitle("USUARIO DE LA BIBLIOTECA");    //Barra de título del frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Acción al pulsar salir
 
        //INSTANCIAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO AL FRAME
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //USAR EL LAYOUTMANAGER SpringLayout
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        lblNombre = new JLabel("Nombre:");  //Crear la instancia
        contenedor.add(lblNombre);      //Añadirlo al contenedor

       // ESTABLECER LOS CONSTRAINTS PARA UBICAR LA ETIQUETA NOMBRE
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 10, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10, SpringLayout.WEST, contenedor);
        
        lblApellido = new JLabel("Apellidos:");
        contenedor.add(lblApellido);

       // ESTABLECER LOS CONSTRAINTS PARA UBICAR LA ETIQUETA APELLIDOS
        sp.putConstraint(SpringLayout.NORTH, lblApellido, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblApellido,  10, SpringLayout.WEST, contenedor);
        
         lblNIF = new JLabel("NIF:");
        contenedor.add(lblNIF);

       // ESTABLECER LOS CONSTRAINTS PARA UBICAR LA ETIQUETA NIF
        sp.putConstraint(SpringLayout.NORTH, lblNIF, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNIF,  10, SpringLayout.WEST, contenedor);
        
        //INSTANCIAMOS CUADROS DE TEXTO Y LOS UBICAMOS EN EL PANEL.
        
        //Cuadro de texto para el nombre.
        txtNombre       = new JTextField();
        contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 10, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNombre, 300, SpringLayout.WEST, contenedor);
        
        //Cuadro de texto para el Apellido.
        txtApellido = new JTextField();
        contenedor.add(txtApellido);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtApellido, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtApellido, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtApellido, 300, SpringLayout.WEST, contenedor);
        
        //Cuadro de texto para la NIF.
        txtNIF = new JTextField();
        contenedor.add(txtNIF);
        sp.putConstraint(SpringLayout.NORTH, txtNIF, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNIF, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNIF, 300, SpringLayout.WEST, contenedor);
        
        //Instanciamos la tabla, definimos la cabecera, instanciamos el modelo 
        //y agregamos un JScrollPane para la tabla
        scroll      = new JScrollPane();
        cabecera    = new String[] {"NIF","NOMBRE","APELLIDOS"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50, SpringLayout.SOUTH, contenedor);
        
        //Intamciar y añadir el botón AÑADIR
        btnAdd          = new JButton("Añadir");
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10, SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnAdd,   35, SpringLayout.WEST, contenedor);
        
        //Intamciar y añadir el botón BORRAR
        btnDel          = new JButton("Borrar");
        contenedor.add(btnDel);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnDel,  145, SpringLayout.WEST, contenedor);
        
        //Intamciar y añadir el botón EDITAR
        btnUpd          = new JButton("Editar");
        contenedor.add(btnUpd);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnUpd,  245, SpringLayout.WEST, contenedor);
        
        //Intamciar y añadir el botón SALIR
        btnExit            = new JButton("Salir");
        contenedor.add(btnExit);
        sp.putConstraint(SpringLayout.SOUTH, btnExit, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnExit, 355,
                        SpringLayout.WEST,contenedor);
        
        setVisible(true);
    }
     
    //Método concectaControlador, se añade el método setActionCommand para identificar el botón pulsado
     public void conectaControlador(  ControladorBiblioteca c  ){
 
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
 
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
 
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
        
        btnExit.addActionListener(c);
        btnExit.setActionCommand("SALIR");
 
        tabla.addMouseListener(c);
        //sólo se permite pulsar una fila a la vez.
        //tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
