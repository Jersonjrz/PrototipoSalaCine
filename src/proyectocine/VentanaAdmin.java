/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class VentanaAdmin extends JFrame {

    JButton jbCrearUsu, jbCrearProd, jbCrearPeli, jbGenerarInforme, jbCuadrarCaja, jbCerrarSesion;
    ProyectoCine pc;

    public VentanaAdmin(){
        
    }

    public VentanaAdmin(ProyectoCine obj) {
        super("Administrador");
        pc = obj;
        setSize(800, 500); //ancho y alto de la ventana en px
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    public void crearGUI() {
        
                ImageIcon icon = new ImageIcon(getClass().getResource(
                "../imagenes/film.png"));
        JLabel jlImagen = new JLabel(icon);
        jlImagen.setBounds(2, 230, 250, 250); // x, y, ancho y alto
        add(jlImagen);
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource(
                "../imagenes/food.png"));
        JLabel jlImagen2 = new JLabel(icon2);
        jlImagen2.setBounds(580, -10, 250, 250); // x, y, ancho y alto
        add(jlImagen2);
        
        jbCrearUsu = new JButton("Crear Usuario");
        jbCrearUsu.setBounds(200, 100, 150, 30); // x, y, ancho y alto
        add(jbCrearUsu);
                jbCrearUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCrearUsu();
            }
        });

        jbCrearProd = new JButton("Crear Producto");
        jbCrearProd.setBounds(200, 200, 150, 30); // x, y, ancho y alto
        jbCrearProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCrearProd();
            }
        });
        add(jbCrearProd);

        jbCrearPeli = new JButton("Crear Pelicula");
        jbCrearPeli.setBounds(200, 300, 150, 30); // x, y, ancho y alto
        jbCrearPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCrearPeli();
            }
        });
        add(jbCrearPeli);

        jbCuadrarCaja = new JButton("Cuadrar Caja");
        jbCuadrarCaja.setBounds(470, 150, 150, 30); // x, y, ancho y alto
        jbCuadrarCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCuadrarCaja();
            }
        });
        add(jbCuadrarCaja);

        jbGenerarInforme = new JButton("Generar Informe");
        jbGenerarInforme.setBounds(470, 250, 150, 30); // x, y, ancho y alto
                jbGenerarInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGenerarInforme();
            }
        });
        add(jbGenerarInforme);

        jbCerrarSesion = new JButton("Cerrar Sesión");
        jbCerrarSesion.setBounds(600, 400, 150, 30); // x, y, ancho y alto
        jbCerrarSesion.setBackground(Color.BLUE);
        jbCerrarSesion.setForeground(Color.WHITE);
        jbCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCerrarSesion();
            }
        });
        add(jbCerrarSesion);

    }
    
        public void evento_jbCrearUsu() {
         System.out.println("Clic en crear usuario");
          //Prueba p = new Prueba();
         setVisible(false); // ocultar la ventana 
        NewUsuario nu = new NewUsuario(pc);
 
    }
    
    public void evento_jbGenerarInforme() {
          //Prueba p = new Prueba();
         setVisible(false); // ocultar la ventana 
         Graficas g = new Graficas(pc);
       
        
        
    }
         
        
    public void evento_jbCerrarSesion() {
         setVisible(false); // ocultar la ventana 
        dispose();
        pc.setVisible(true);
        
    }
    
    public void evento_jbCrearProd() {         
         setVisible(false); // ocultar la ventana 
     NewProducto np = new NewProducto(pc);
        
    }    
    
        public void evento_jbCrearPeli() {         
         setVisible(false); // ocultar la ventana 
      NewPelicula npe = new NewPelicula(pc);
        
    }   
        
        
        public void evento_jbCuadrarCaja(){
            System.out.println("Clic en cuadrar caja");
      setVisible(false); // ocultar la ventana 
      CuadreCaja npe = new CuadreCaja(pc);
        }
}
