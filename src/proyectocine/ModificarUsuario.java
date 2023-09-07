/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class ModificarUsuario extends JFrame{
    
    ProyectoCine pc;
    JButton jbVolver, jbLimpiar, jbModificar, jbBuscar;
    JTextField jtNumCed, jtApe, jtNom, jtUsuario, jtContrasena;
    JLabel jlNumCed, jlApe, jlNom, jlTipoUsu, jlUsuario, jlContrasena, jlGenero;
    JRadioButton jrMasculino, jrFemenino, jrOtro, jrOculto;
    JComboBox<String> jcTipoUsu;
    JComboBox<String> jcGenero;
    ModeloTablaUsu mtu;
    JTable tabla;
    
    public ModificarUsuario(ProyectoCine obj){
        super("Modificar Usuario");
        pc = obj;
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setLayout(null);
        setResizable(false);
        crearGUI();        
        setVisible(true);
    }
    
    public void crearGUI(){
        JLabel jl = new JLabel("  Modificar usuario");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        jlNumCed = new JLabel("Numero de Cédula:");
        jlNumCed.setBounds(60, 80, 200, 30);
        add(jlNumCed);
        
        jtNumCed = new JTextField();
        jtNumCed.setBounds(200, 80, 150, 30);
        add(jtNumCed);
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(400,80,150,30);
        jbBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbBuscar();
            }
        });
        add(jbBuscar);
        
        jlNom = new JLabel("Nombre(s):");
        jlNom.setBounds(60, 120, 150, 30);
        add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(200, 120, 150, 30);
        add(jtNom); 
        
        jlApe = new JLabel("Apellido(s):");
        jlApe.setBounds(400, 120, 150, 30);
        add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(520, 120, 150, 30);
        add(jtApe); 
        
        jlTipoUsu = new JLabel("Tipo de Usuario:");
        jlTipoUsu.setBounds(60, 160, 150, 30);
        add(jlTipoUsu);
        
        jcTipoUsu = new JComboBox<>();
        jcTipoUsu.addItem("Administrador");
        jcTipoUsu.addItem("Vendedor");
        jcTipoUsu.addItem("Cliente");
        jcTipoUsu.setBounds(200, 160, 150, 30);
        add(jcTipoUsu);        
        
        jlUsuario = new JLabel("Usuario: ");
        jlUsuario.setBounds(400, 160, 150, 30);
        add(jlUsuario);
        
        jtUsuario = new JTextField();
        jtUsuario.setBounds(520, 160, 150, 30);
        add(jtUsuario);         
        
        jlContrasena = new JLabel("Contraseña: ");
        jlContrasena.setBounds(60, 200, 150, 30);
        add(jlContrasena);
        
        jtContrasena = new JTextField();
        jtContrasena.setBounds(200, 200, 150, 30);
        add(jtContrasena);         
        
        jlGenero = new JLabel("Genero");
        jlGenero.setBounds(400, 200, 150, 30);
        add(jlGenero);
        
        jcGenero = new JComboBox<>();
        jcGenero.addItem("Masculino");
        jcGenero.addItem("Femenino");
        jcGenero.addItem("Otro");
        jcGenero.setBounds(520, 200, 150, 30);
        add(jcGenero);  
        /*
        JLabel jlgen = new JLabel("Seleccione un genero:");
        jlgen.setBounds(60, 200, 150, 30);
        add(jlgen);
        
        jrMasculino = new JRadioButton("Masculino");
        jrMasculino.setBounds(200, 200, 100, 30);
        add(jrMasculino);
        
        jrFemenino = new JRadioButton("Femenino");
        jrFemenino.setBounds(300, 200, 100, 30);
        add(jrFemenino);
        
        jrOtro = new JRadioButton("Otro");
        jrOtro.setBounds(400, 200, 100, 30);
        add(jrOtro);
        
        jrOculto = new JRadioButton();
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrOtro);
        bg.add(jrMasculino);
        bg.add(jrFemenino);
        bg.add(jrOculto);   */
        
        jbVolver = new JButton("Atrás");
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
        
        jbLimpiar = new JButton("Eliminar");
        jbLimpiar.setBounds(320, 400, 150, 30);
        jbLimpiar.setBackground(Color.RED);
        jbLimpiar.setForeground(Color.WHITE);
        jbLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbEliminar();
            }
        });
        add(jbLimpiar);
        
        jbModificar = new JButton("Modificar");
        jbModificar.setBounds(490, 400, 150, 30);
        jbModificar.setBackground(Color.ORANGE);
        jbModificar.setForeground(Color.WHITE);
        jbModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbModificar();                 
            }
        });
        add(jbModificar);
        
    }
    
    public void evento_jbBuscar() {
        System.out.println("Entró a buscar");
        Usuario u = new Usuario();
        String d1 = "", d2 = "", d3 = "";
        String datos[] = new String[7];
        for (int i = 0; i < pc.arrayUsuarios.size(); i++) {
            Usuario obj = pc.arrayUsuarios.get(i);
            datos[0] = obj.cedula;
            datos[1] = obj.nombre;
            datos[2] = obj.apellido;
            datos[3] = obj.tipousu;
            datos[4] = obj.usuario;
            datos[5] = obj.contrasena;
            datos[6] = obj.genero;
            d1 = datos[1];
            d2 = datos[4];
            d3 = datos[5];
            
            if(jtNumCed.getText().equals(datos[0])){
                jtNom.setText(datos[1]);
                jtApe.setText(datos[2]);
                jcTipoUsu.setSelectedItem(datos[3]);
                jtUsuario.setText(datos[4]);
                jtContrasena.setText(datos[5]);
                jcGenero.setSelectedItem(datos[6]);
            }
        }
    }
    
    
    //Logica de modificar
    public void evento_jbModificar(){      
        int num = Integer.parseInt(jtNumCed.getText());      
       System.out.println("Posición"+pc.arrayUsuarios.indexOf(num)); 
      //  for (int i = 0; i < pc.arrayUsuarios.size(); i++) {
        System.out.println("Entró a for modificar");
        Usuario u = new Usuario();
         u.cedula = jtNumCed.getText();
         u.apellido = jtApe.getText();
         u.nombre = jtNom.getText();
//        if(jrMasculino.isSelected()) u.genero = "Masculino";
  //      if(jrFemenino.isSelected()) u.genero = "Femenino";
 //       if(jrOtro.isSelected()) u.genero = "Otro";
         u.tipousu = (String) jcTipoUsu.getSelectedItem();
         u.usuario = jtUsuario.getText();
         u.contrasena = jtContrasena.getText();
         u.genero = (String) jcGenero.getSelectedItem();
         //Modifica
        pc.arrayUsuarios.set(num, u);
        JOptionPane.showMessageDialog(this, 
                "¡Usuario modificado exitosamente!");       
        evento_jbLimpiar();
        
    //}
    }
    
    
    //Logica de Eliminar
    public void evento_jbEliminar(){
        int num = Integer.parseInt(jtNumCed.getText());      
        Usuario u = new Usuario();
         u.cedula = jtNumCed.getText();
         u.apellido = jtApe.getText();
         u.nombre = jtNom.getText();
//        if(jrMasculino.isSelected()) u.genero = "Masculino";
  //      if(jrFemenino.isSelected()) u.genero = "Femenino";
 //       if(jrOtro.isSelected()) u.genero = "Otro";
         u.tipousu = (String) jcTipoUsu.getSelectedItem();
         u.usuario = jtUsuario.getText();
         u.contrasena = jtContrasena.getText();         
          u.genero = (String) jcGenero.getSelectedItem();
          u.estado = false;
        pc.arrayUsuarios.set(num, u);
        JOptionPane.showMessageDialog(this, 
                "¡Usuario eliminado exitosamente!");       
        evento_jbLimpiar();
        
    //}
    }
            
    
    public void consultar(){
        System.out.println("Entro a consultar");
        for(int i=0; i<pc.arrayUsuarios.size();i++){
            Usuario obj = pc.arrayUsuarios.get(i);
            String datos[] = new String[7];
            datos[0] = obj.cedula;
            datos[1] = obj.nombre;
            datos[2] = obj.apellido;
            datos[3] = obj.tipousu;
            datos[4] = obj.usuario;
            datos[5] = obj.contrasena;
            datos[6] = obj.genero;
            
            System.out.println("Impresion j0kbre "+datos[1]);
            
        }
    }
    
    public void evento_jbLimpiar(){
        jtNumCed.setText("");
        jtApe.setText("");
        jtNom.setText("");
      //  jrOculto.setSelected(true);
        jcTipoUsu.setSelectedItem("Administrador");        
        jtUsuario.setText("");
        jtContrasena.setText("");
        jtNumCed.requestFocus();
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        ConsultarUsuarios pv = new ConsultarUsuarios(pc); // mostrar la ventana del menu principal
    }
    
}
