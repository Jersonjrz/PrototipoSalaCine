/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jerso
 */
class NewUsuario extends JFrame{

    JButton jbVolver, jbLimpiar, jbGuardar, jbConsultarUsu;
    JTextField jtNumCed, jtApe, jtNom, jtUsuario, jtContrasena;
    JLabel jlNumCed, jlApe, jlNom, jlTipoUsu, jlUsuario, jlContrasena;
    JRadioButton jrMasculino, jrFemenino, jrOtro, jrOculto;
    JComboBox<String> jcTipoUsu;
    ModeloTablaUsu mtu;
    JTable tabla;
    ProyectoCine va;
    //ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
    
 
    
    public NewUsuario(ProyectoCine obj){
        super("Nuevo Usuario");
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
        JLabel jl = new JLabel("  Crear nuevo usuario");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        jlNumCed = new JLabel("Id Cliente:");
        jlNumCed.setBounds(60, 80, 200, 30);
        add(jlNumCed);
        
        jtNumCed = new JTextField();
        jtNumCed.setBounds(200, 80, 150, 30);
        jtNumCed.setEditable(false);
        add(jtNumCed);
        
        jlNom = new JLabel("Nombre(s):");
        jlNom.setBounds(400, 80, 150, 30);
        add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(520, 80, 150, 30);
        add(jtNom); 
        
        jlApe = new JLabel("Apellido(s):");
        jlApe.setBounds(60, 120, 150, 30);
        add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(200, 120, 150, 30);
        add(jtApe); 
        
        jlTipoUsu = new JLabel("Tipo de Usuario:");
        jlTipoUsu.setBounds(400, 120, 150, 30);
        add(jlTipoUsu);
        
        jcTipoUsu = new JComboBox<>();
        jcTipoUsu.addItem("Administrador");
        jcTipoUsu.addItem("Vendedor");
        jcTipoUsu.addItem("Cliente");
        jcTipoUsu.setBounds(520, 120, 150, 30);
        add(jcTipoUsu);        
        
        jlUsuario = new JLabel("Usuario: ");
        jlUsuario.setBounds(60, 160, 150, 30);
        add(jlUsuario);
        
        jtUsuario = new JTextField();
        jtUsuario.setBounds(200, 160, 150, 30);
        add(jtUsuario);         
        
        jlContrasena = new JLabel("Contraseña: ");
        jlContrasena.setBounds(400, 160, 150, 30);
        add(jlContrasena);
        
        jtContrasena = new JTextField();
        jtContrasena.setBounds(520, 160, 150, 30);
        add(jtContrasena);         
        
        
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
        bg.add(jrOculto);   
        
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
                  //consultar();
            }
        });
        add(jbGuardar);
        
       jbConsultarUsu = new JButton("Consultar Usuarios");
        jbConsultarUsu .setBounds(320, 280, 150, 30);
        jbConsultarUsu .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultarUsu();
              
            }
        });
        add(jbConsultarUsu);
    }
    
       public void evento_jbConsultarUsu(){  
        setVisible(false);
        ConsultarUsuarios cu = new ConsultarUsuarios(va);
        
    }
    
       //Empieza la logica
       
    public void evento_jbGuardar(){
        Usuario u = new Usuario();
        u.cedula = va.contadorusu+"";
        u.apellido = jtApe.getText();
        u.nombre = jtNom.getText();
        if(jrMasculino.isSelected()) {
             u.genero = "Masculino";
             va.contadorhombres+=1;
        }           
        if(jrFemenino.isSelected()){
            u.genero = "Femenino";
             va.contadormujeres+=1;
        }
        if(jrOtro.isSelected()) {
            u.genero = "Otro";
            va.contadorotro+=1;
        }
        u.tipousu = (String) jcTipoUsu.getSelectedItem();
        if(u.tipousu.equals("Administrador")){
            va.contadoradmin+=1;
        }else if(u.tipousu.equals("Cliente")){
            va.contadorcliente+=1;
        }else if(u.tipousu.equals("Vendedor")){
            va.contadorvendedor+=1;
        }
        u.usuario = jtUsuario.getText();
        u.contrasena = jtContrasena.getText();
        u.estado = true;
        //Agregar en el Arraylist
        va.arrayUsuarios.add(u);
        JOptionPane.showMessageDialog(this, 
                "¡Usuario creado exitosamente!");       
        evento_jbLimpiar();
        //Aumentar contador automático
        va.contadorusu+=1;
    }
    
    
    /*
    public void consultar(){
        System.out.println("Entro a consultar");
        for(int i=0; i<va.arrayUsuarios.size();i++){
            Usuario obj = va.arrayUsuarios.get(i);
            String datos[] = new String[8];
            datos[0] = obj.cedula;
            datos[1] = obj.nombre;
            datos[2] = obj.apellido;
            datos[3] = obj.tipousu;
            datos[4] = obj.usuario;
            datos[5] = obj.contrasena;
            datos[6] = obj.genero;
            datos[7] = obj.estado+"";
            
            System.out.println("Impresion cedula "+datos[0]);
            
        }
    }*/
    
    public void evento_jbLimpiar(){
        jtNumCed.setText("");
        jtApe.setText("");
        jtNom.setText("");
        jrOculto.setSelected(true);
        jcTipoUsu.setSelectedItem("Administrador");        
        jtUsuario.setText("");
        jtContrasena.setText("");
        jtNumCed.requestFocus();
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaAdmin pv = new VentanaAdmin(va); // mostrar la ventana del menu principal
    }
    

}
