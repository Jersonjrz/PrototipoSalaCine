/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */


public class NewPelicula extends JFrame{
    
    JLabel jlIdPeli, jlNomPeli, jlHoraPeli, jlDuracionPeli, jlCatPeli, jlPrecioPeli;
    JTextField jtIdPeli, jtNomPeli, jtHoraPeli, jtDuracionPeli, jtPrecioPeli;
    JComboBox jcCategoria;
    JButton jbVolver, jbLimpiar, jbGuardar, jbConsultarPeli;
    ProyectoCine va;
    
    public NewPelicula(ProyectoCine obj){
                super("Nuevo Producto");
        va = obj;
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setLayout(null);
        setResizable(false);
        crearGUI();        
        setVisible(true);
    }
    
     public void crearGUI(){
        JLabel jl = new JLabel("  Crear nueva Pelicula");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        jlIdPeli = new JLabel("Código de la pelicula:");
        jlIdPeli.setBounds(60, 80, 200, 30);
        add(jlIdPeli);
        
        jtIdPeli= new JTextField();
        jtIdPeli.setBounds(200, 80, 150, 30);
        jtIdPeli.setEditable(false);
        add(jtIdPeli);
        
        jlNomPeli = new JLabel("Nombre pelicula:");
        jlNomPeli.setBounds(400, 80, 150, 30);
        add(jlNomPeli);
        
        jtNomPeli = new JTextField();
        jtNomPeli.setBounds(520, 80, 150, 30);
        add(jtNomPeli); 
        
        jlHoraPeli = new JLabel("Hora Pelicula:");
        jlHoraPeli.setBounds(60, 120, 150, 30);
        add(jlHoraPeli );
        
        jtHoraPeli  = new JTextField();
        jtHoraPeli.setBounds(200, 120, 150, 30);
        add(jtHoraPeli);       

        jlDuracionPeli = new JLabel("Duración Pelicula:");
        jlDuracionPeli.setBounds(400, 120, 150, 30);
        add(jlDuracionPeli);
        
        jtDuracionPeli = new JTextField();
        jtDuracionPeli.setBounds(520, 120, 150, 30);
        add(jtDuracionPeli);
        
        jlCatPeli = new JLabel("Categoría Producto:");
        jlCatPeli.setBounds(60, 160, 150, 30);
        add(jlCatPeli);        
        
        jcCategoria = new JComboBox<>();
        jcCategoria.addItem("Acción");
        jcCategoria.addItem("Terror");
        jcCategoria.addItem("Comedia");
        jcCategoria.addItem("Animada");
        jcCategoria.addItem("Suspenso");
        jcCategoria.addItem("Drama");
        jcCategoria.setBounds(200, 160, 150, 30);
        add(jcCategoria);        
        
        jlPrecioPeli = new JLabel("Precio de película");
        jlPrecioPeli.setBounds(400, 160, 150, 30);
        add(jlPrecioPeli); 
         
        jtPrecioPeli = new JTextField();
        jtPrecioPeli.setBounds(520, 160, 150, 30);
        add(jtPrecioPeli);    

     /*  String encabezados[] = {"Cédula", "Nombre(s)", "Apellido(s)", "Tipo", "Usuario", "Contraseña", "Genero"};
        String datos[][] = {{"", "", "", "", "", "", ""}};
        
        mtu = new ModeloTablaUsu(datos, encabezados);
        tabla = new JTable(mtu);
        
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        
        TableColumn tc = tabla.getColumn("Cédula");
        tc.setPreferredWidth(70); // establecer que la columna del Numero ID tenga 50 px de ancho
        
        DefaultTableCellRenderer tc1 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tc1); // establecer que el contenido de la columna del Numero cedula quede centrado
        
        DefaultTableCellRenderer tc2 = new DefaultTableCellRenderer();
        tc2.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(3).setCellRenderer(tc2); // establecer que el contenido de la columna del genero quede centrado
        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(175, 240, 450, 150); // dar ubicacion y tamaño al JTable
        
        add(js); // adicionar el JTable al JFrame*/
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(150, 400, 150, 30);
        jbVolver.setBackground(Color.BLUE);
        jbVolver.setForeground(Color.WHITE);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.setBounds(320, 400, 150, 30);
        jbLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbLimpiar();
            }
        });
        add(jbLimpiar);
        
        jbGuardar = new JButton("Guardar");
        jbGuardar.setBounds(490, 400, 150, 30);
        jbGuardar.setBackground(Color.GREEN);
        jbGuardar.setForeground(Color.WHITE);        
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGuardar();
            }
        });
        add(jbGuardar);
        
       jbConsultarPeli = new JButton("Consultar Peliculas");
        jbConsultarPeli.setBounds(320, 280, 150, 30);
        jbConsultarPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultarPeli();
            }
        });
        add(jbConsultarPeli);
    }
    
    public void evento_jbConsultarPeli(){  
        setVisible(false);
        ConsultarPeliculas cpe = new ConsultarPeliculas(va);
        
    }
    
    public void evento_jbGuardar(){
        Pelicula p = new Pelicula();
        p.idPelicula = va.contadorpelicula+"";
        p.nomPelicula = jtNomPeli.getText();
        p.horaPelicula = jtHoraPeli.getText();
        p.duracionPelicula = jtDuracionPeli.getText();
        p.catPelicula = (String) jcCategoria.getSelectedItem();
        p.precio = Double.parseDouble(jtPrecioPeli.getText());
        p.estado = true;
        va.arrayPeliculas.add(p);
        JOptionPane.showMessageDialog(this, 
                "¡Pelicula creada exitosamente!");
        va.contadorpelicula += 1;
        evento_jbLimpiar();
        
    }
    
    public void evento_jbLimpiar(){
        jtIdPeli.setText("");
        jtNomPeli.setText("");
        jtHoraPeli.setText("");
        jtDuracionPeli.setText("");
        jcCategoria.setSelectedItem("Acción");        
        jtPrecioPeli.setText("");
    }
    
   
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaAdmin pv = new VentanaAdmin(va); // mostrar la ventana del menu principal
    }
}
