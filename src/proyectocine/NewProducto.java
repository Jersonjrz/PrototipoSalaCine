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
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class NewProducto extends JFrame{
    
    JLabel jlIdProd, jlNombreProd, jlDescripProd, jlValorProd, jlCategoria;
    JTextField jtIdProd, jtNombreProd, jtDescripProd, jtValorProd, jtCategoria;
    JComboBox jcCategoria;
    JButton jbVolver, jbLimpiar, jbGuardar, jbConsultarUsu;
    ProyectoCine va;
    
    public NewProducto(ProyectoCine obj){
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
        JLabel jl = new JLabel("  Crear nuevo producto");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        jlIdProd = new JLabel("Código del producto:");
        jlIdProd.setBounds(60, 80, 200, 30);
        add(jlIdProd);
        
        jtIdProd = new JTextField();
        jtIdProd.setBounds(200, 80, 150, 30);
        jtIdProd.setEditable(false);
        add(jtIdProd);
        
        jlNombreProd = new JLabel("Nombre producto:");
        jlNombreProd.setBounds(400, 80, 150, 30);
        add(jlNombreProd);
        
        jtNombreProd = new JTextField();
        jtNombreProd.setBounds(520, 80, 150, 30);
        add(jtNombreProd); 
        
        jlDescripProd = new JLabel("Descripción Producto:");
        jlDescripProd.setBounds(60, 120, 150, 30);
        add(jlDescripProd);
        
        jtDescripProd = new JTextField();
        jtDescripProd.setBounds(200, 120, 150, 30);
        add(jtDescripProd);       

        jlValorProd = new JLabel("Valor Producto:");
        jlValorProd.setBounds(400, 120, 150, 30);
        add(jlValorProd);
        
        jtValorProd = new JTextField();
        jtValorProd.setBounds(520, 120, 150, 30);
        add(jtValorProd);
        
        jlCategoria = new JLabel("Categoría Producto:");
        jlCategoria.setBounds(60, 160, 150, 30);
        add(jlCategoria);        
        
        jcCategoria = new JComboBox<>();
        jcCategoria.addItem("ComidaRapida");
        jcCategoria.addItem("Mecato");
        jcCategoria.addItem("Bebida");
        jcCategoria.setBounds(200, 160, 150, 30);
        add(jcCategoria);        

        
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
        
       jbConsultarUsu = new JButton("Consultar Producto");
        jbConsultarUsu .setBounds(320, 280, 150, 30);
        jbConsultarUsu .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultarProd();
            }
        });
        add(jbConsultarUsu);
    }
     
        public void evento_jbConsultarProd(){  
        setVisible(false);
        ConsultarProductos cu = new ConsultarProductos(va);
        
    }
    
    public void evento_jbGuardar(){
        Producto p = new Producto();
        p.idprod = va.contadorproducto+"";
        p.nombreprod = jtNombreProd.getText();
        p.descprod = jtDescripProd.getText();
        p.valorprod = Double.parseDouble(jtValorProd.getText());
        p.categoriaprod = (String) jcCategoria.getSelectedItem();
        p.estado = true;
        va.arrayProductos.add(p);
        JOptionPane.showMessageDialog(this, 
                "¡Producto creado exitosamente!");
        evento_jbLimpiar();
        va.contadorproducto+=1;
    }
    
    public void evento_jbLimpiar(){
        jtIdProd.setText("");
        jtNombreProd.setText("");
        jtDescripProd.setText("");
        jtValorProd.setText("");
        jcCategoria.setSelectedItem("Comida Rápida");        

    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaAdmin pv = new VentanaAdmin(va); // mostrar la ventana del menu principal
    }
    
}
