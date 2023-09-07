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
public class VentanaVendedor extends JFrame{
    
     ProyectoCine pc;
     JButton jbCerrarSesion, jbVenderBoleto, jbVenderProducto, jbCuadrarCaja;
    
     public VentanaVendedor(ProyectoCine obj) {
        super("Vendedor");
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
              
        jbVenderBoleto = new JButton("Vender Boleto");
        jbVenderBoleto.setBounds(200, 100, 150, 30); // x, y, ancho y alto
        add(jbVenderBoleto);
                jbVenderBoleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVenderBoleto();
            }
        });

        jbVenderProducto = new JButton("Vender Producto");
        jbVenderProducto.setBounds(200, 200, 150, 30); // x, y, ancho y alto
        jbVenderProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVenderProducto();
            }
        });
        add(jbVenderProducto);

        /*jbCuadrarCaja = new JButton("Cuadrar Caja");
        jbCuadrarCaja.setBounds(200, 300, 150, 30); // x, y, ancho y alto
        jbCuadrarCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCuadrarCaja();
            }
        });
        add(jbCuadrarCaja);*/
              

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
         
        public void evento_jbVenderProducto(){
        setVisible(false);
        VenderProducto vp = new VenderProducto(pc);   
        }  
        
        public void evento_jbVenderBoleto(){
        setVisible(false);
        VenderBoleto vb = new VenderBoleto(pc);   
        }
        
        public void evento_jbCuadrarCaja(){
            
        }
          
        public void evento_jbCerrarSesion() {
        setVisible(false); // ocultar la ventana 
        dispose();
        pc.setVisible(true);
        
    }
        
            public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaVendedor vv = new VentanaVendedor(pc); // mostrar la ventana del menu principal
    }
    
}
