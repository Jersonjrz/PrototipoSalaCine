/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class ProyectoCine extends JFrame {

    JButton jbIngresar;
    JTextField jtUsuario;
    JPasswordField jpContrasena;
    VentanaAdmin vt;
    
    
    ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
    ArrayList<Producto> arrayProductos = new ArrayList<>();
    ArrayList<Pelicula> arrayPeliculas = new ArrayList<>();
    ArrayList<BoletosVendidos> arrayBoletosVendidos = new ArrayList<>();
    ArrayList<ProductosVendidos> arrayProductosVendidos = new ArrayList<>();
    //Salas de cine
    String matriz1 [][] = new String [4][4]; 
    String matriz2 [][] = new String [4][4]; 
    String matriz3 [][] = new String [4][4]; 
    String matriz4 [][] = new String [4][4];
    int contadorusu = 0, contadorproducto = 0, contadorpelicula = 0, contadorventaprod = 0, contadorventapel = 0, contadorhombres = 0, contadormujeres = 0, contadorotro = 0;
    int contadorpelicula0 = 0, contadorpelicula1 = 0, contadorpelicula2 = 0, contadorpelicula3 = 0;
    Double contadorvalorpel=0.0, contadorvalorprod=0.0;
    int contadorprodcomrap=0, contadorprodmec=0, contadorprodbeb=0;
    int contadoradmin=0, contadorvendedor=0, contadorcliente=0;
    
    public ProyectoCine() {
        super("Login");
        setSize(800, 500); //ancho y alto de la ventana en px
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    public void crearGUI() {

       ImageIcon icon = new ImageIcon(getClass().getResource(
       "/imagenes/user.png"));
        JLabel jlImagen = new JLabel(icon);
        jlImagen.setBounds(270, 5, 256, 256); // x, y, ancho y alto
        add(jlImagen);

        JLabel jlCorreo = new JLabel("Correo electrónico:");
        jlCorreo.setBounds(250, 220, 150, 30); // x, y, ancho y alto
        add(jlCorreo);

        jtUsuario = new JTextField();
        jtUsuario.setBounds(375, 220, 200, 30); // x, y, ancho y alto
        add(jtUsuario);

        JLabel jlContrasena = new JLabel("Contraseña:");
        jlContrasena.setBounds(250, 280, 150, 30); // x, y, ancho y alto
        add(jlContrasena);

        jpContrasena = new JPasswordField();
        jpContrasena.setBounds(375, 280, 200, 30); // x, y, ancho y alto
        add(jpContrasena);

        jbIngresar = new JButton("Iniciar sesión");
        jbIngresar.setBounds(300, 350, 200, 40); // x, y, ancho y alto
        jbIngresar.setBackground(Color.BLUE);
        jbIngresar.setForeground(Color.WHITE);
        jbIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbIngresar();
            }
        });
        add(jbIngresar);

    }

    public void evento_jbIngresar() {

        Usuario u = new Usuario();
        u.usuario = jtUsuario.getText();
        u.contrasena = jpContrasena.getText();

        String d1 = "", d2 = "", d3 = "";
        String datos[] = new String[7];
        
        
        //Credenciales de administrador .equals compara
        if (u.usuario.equals("admin") && u.contrasena.equals("admin")) {
            VentanaAdmin adm = new VentanaAdmin(this);
            setVisible(false); // ocultar la ventana del menu principal        
        } else {
            //Recorre el arrayusuarios
            for (int i = 0; i < arrayUsuarios.size(); i++) {
                Usuario obj = arrayUsuarios.get(i); //Obtener cada usuario
                datos[0] = obj.cedula;
                datos[1] = obj.nombre;
                datos[2] = obj.apellido;
                datos[3] = obj.tipousu;
                datos[4] = obj.usuario;
                datos[5] = obj.contrasena;
                datos[6] = obj.genero;
                //Comparación de credenciales
                if (u.usuario.equals(datos[4]) && u.contrasena.equals(datos[5])) {
                    if (datos[3].equals("Administrador")) {
                        VentanaAdmin adm = new VentanaAdmin(this);
                        setVisible(false); // ocultar la ventana del menu principal 
                    } else if (datos[3].equals("Vendedor")) {
                        VentanaVendedor vv = new VentanaVendedor(this);
                        setVisible(false); // ocultar la ventana del menu principal 
                    } else if (datos[3].equals("Cliente")) {
                        VentanaCliente vc = new VentanaCliente(this);
                        setVisible(false); // ocultar la ventana del menu principal 
                    }
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProyectoCine mp = new ProyectoCine();
    }

}
