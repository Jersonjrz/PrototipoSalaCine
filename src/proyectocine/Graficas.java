/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jerso
 */
public class Graficas extends JFrame{
    
    ProyectoCine pc;
    JButton jbVolver, jbGraficaGenero, jbGraficaPeliculas, jbVS, jbTipoProd, jbCantUsu;
    
    public Graficas(ProyectoCine obj){
        super("Graficas");
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
        
                jbGraficaGenero = new JButton("Gráfica Genero");
        jbGraficaGenero.setBounds(200, 100, 180, 30); // x, y, ancho y alto
        add(jbGraficaGenero);
                jbGraficaGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGraficaGenero();
            }
        });
                
        jbGraficaPeliculas = new JButton("Gráficas Ventas Peliculas");
        jbGraficaPeliculas.setBounds(200, 200, 180, 30); // x, y, ancho y alto
        jbGraficaPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGraficaVentasPeliculas();
            }
        });
        
                jbVS = new JButton("Productos vs Peliculas");
        jbVS.setBounds(200, 300, 180, 30); // x, y, ancho y alto
        jbVS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVS();
            }
        });
        add(jbVS);
        
        add(jbGraficaPeliculas);
        
                jbTipoProd = new JButton("Gráficas Tipo Productos");
        jbTipoProd.setBounds(470, 150, 180, 30); // x, y, ancho y alto
        jbTipoProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbTipoProd();
            }
        });
        add(jbTipoProd);
        
                jbCantUsu = new JButton("Cantidad Usuarios");
        jbCantUsu.setBounds(470, 250, 180, 30); // x, y, ancho y alto
                jbCantUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCantUsu();
            }
        });
        add(jbCantUsu);
        
                jbVolver = new JButton("Atrás");
        jbVolver.setBounds(150, 400, 150, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaAdmin nw = new VentanaAdmin(pc); // mostrar la ventana del menu principal
    }
    
        public void evento_jbGraficaGenero(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        PieChart3DDemo nw = new PieChart3DDemo(pc); // mostrar la ventana del menu principal
    }
    
                public void evento_jbCantUsu(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        BarChart3DDemo3 nw = new BarChart3DDemo3(pc); // mostrar la ventana del menu principal
    }
        
        public void evento_jbGraficaVentasPeliculas(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        BarChart3DDemo nw = new BarChart3DDemo(pc); // mostrar la ventana del menu principal
        }
        
 
        public void evento_jbVS(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        BarChart3DDemo2 nw = new BarChart3DDemo2(pc); // mostrar la ventana del menu principal
        }  
        
        public void evento_jbTipoProd(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        PieChartDemo nw = new PieChartDemo(pc); // mostrar la ventana del menu principal
        }  
        
}
