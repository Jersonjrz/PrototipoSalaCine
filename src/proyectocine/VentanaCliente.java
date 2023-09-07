/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jerso
 */
public class VentanaCliente extends JFrame{
    
    ProyectoCine pc;
    JButton jbCerrarSesion, jbConsultPeli, jbConsultProd;
    
    public VentanaCliente(ProyectoCine obj){
        super("Cliente");
        pc = obj;
        setSize(800, 500); //ancho y alto de la ventana en px
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }
    
         public void crearGUI(){
             
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
             
        jbConsultPeli = new JButton("Consultar Peliculas");
        jbConsultPeli .setBounds(200, 100, 200, 30); // x, y, ancho y alto
        add(jbConsultPeli );
                jbConsultPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultPeli();
            }
        });

        jbConsultProd = new JButton("Consultar Productos");
        jbConsultProd.setBounds(200, 200, 200, 30); // x, y, ancho y alto
        jbConsultProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultProd();
            }
        });
        add(jbConsultProd);
             
        jbCerrarSesion = new JButton("Cerrar Sesión");
        jbCerrarSesion.setBounds(600, 400, 150, 30); // x, y, ancho y alto
        jbCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCerrarSesion();
            }
        });
        add(jbCerrarSesion);
     }
         
        public void evento_jbCerrarSesion() {
        setVisible(false); // ocultar la ventana 
        dispose();
        pc.setVisible(true);
        
    }
        
        public void evento_jbConsultPeli() {
   
        setVisible(false);
        ConsultarPeliculasCli cpe = new ConsultarPeliculasCli(pc);
        
    }
        
    
        
       public void evento_jbConsultProd() {
        setVisible(false);
        ConsultarProductosCli cpr = new ConsultarProductosCli(pc);
        
    }
    
}
