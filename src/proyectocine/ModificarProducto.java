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
public class ModificarProducto extends JFrame{
    
    ProyectoCine pc;
    JLabel jlIdProd, jlNombreProd, jlDescripProd, jlValorProd, jlCategoria;
    JTextField jtIdProd, jtNombreProd, jtDescripProd, jtValorProd;
    JComboBox jcCategoria;
    JButton jbVolver, jbLimpiar, jbBuscar, jbModificar;

    
    public ModificarProducto(ProyectoCine obj){
        super("Modificar Producto");
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
        
        jlIdProd = new JLabel("Código Producto:");
        jlIdProd.setBounds(60, 80, 200, 30);
        add(jlIdProd);
        
        jtIdProd = new JTextField();
        jtIdProd .setBounds(200, 80, 150, 30);
        add(jtIdProd );
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(400,80,150,30);
        jbBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbBuscar();
            }
        });
        add(jbBuscar);
        
        jlNombreProd = new JLabel("Nombre Producto");
        jlNombreProd.setBounds(60, 120, 150, 30);
        add(jlNombreProd);
        
        jtNombreProd = new JTextField();
        jtNombreProd.setBounds(200, 120, 150, 30);
        add(jtNombreProd); 
        
        jlDescripProd = new JLabel("Descripción");
        jlDescripProd.setBounds(400, 120, 150, 30);
        add(jlDescripProd);
        
        jtDescripProd = new JTextField();
        jtDescripProd.setBounds(520, 120, 150, 30);
        add(jtDescripProd); 
        
        jlCategoria = new JLabel("Categoría Producto:");
        jlCategoria.setBounds(60, 160, 150, 30);
        add(jlCategoria);
        
        jcCategoria = new JComboBox<>();
        jcCategoria.addItem("Comida Rápida");
        jcCategoria.addItem("Mecato");
        jcCategoria.addItem("Bebida");
        jcCategoria.setBounds(200, 160, 150, 30);
        add(jcCategoria);        
        
        jlValorProd = new JLabel("Valor Producto");
        jlValorProd.setBounds(400, 160, 150, 30);
        add(jlValorProd);
        
        jtValorProd = new JTextField();
        jtValorProd .setBounds(520, 160, 150, 30);
        add(jtValorProd ); 
        

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
        Producto u = new Producto();
        String d1 = "", d2 = "", d3 = "";
        String datos[] = new String[6];
        for (int i = 0; i < pc.arrayProductos.size(); i++) {
            Producto obj = pc.arrayProductos.get(i);
            datos[0] = obj.idprod;
            datos[1] = obj.nombreprod;
            datos[2] = obj.descprod;
            datos[3] = obj.valorprod+"";
            datos[4] = obj.categoriaprod;
            datos[5] = obj.estado+"";  
            d1 = datos[1];
            d2 = datos[4];
            d3 = datos[5];
            
            if(jtIdProd.getText().equals(datos[0])){
                jtNombreProd.setText(datos[1]);
                jtDescripProd.setText(datos[2]);
                jtValorProd.setText(datos[3]);
                jcCategoria.setSelectedItem(datos[4]);;
            }
        }
    }
        
        public void evento_jbModificar(){      
        int num = Integer.parseInt(jtIdProd.getText());         
        System.out.println("Entró a for modificar");
        Producto p = new Producto();
         p.idprod = jtIdProd.getText();
         p.nombreprod = jtNombreProd.getText();
         p.descprod = jtDescripProd.getText();
         p.categoriaprod = (String) jcCategoria.getSelectedItem();
         p.valorprod = Double.parseDouble(jtValorProd.getText());  
         pc.arrayProductos.set(num, p);
        JOptionPane.showMessageDialog(this, 
                "¡Producto modificado exitosamente!");       
        evento_jbLimpiar();
        
    //}
    }
        
        public void evento_jbLimpiar(){
        jtIdProd.setText("");
        jtNombreProd.setText("");
        jtDescripProd.setText("");
      //  jrOculto.setSelected(true);
        jcCategoria.setSelectedItem("Comida Rápida");        
        jtValorProd.setText("");
    }
        
        public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        ConsultarProductos pv = new ConsultarProductos(pc); // mostrar la ventana del menu principal
    }    
    
            public void evento_jbEliminar(){
       int num = Integer.parseInt(jtIdProd.getText());         
        System.out.println("Entró a for modificar");
        Producto p = new Producto();
         p.idprod = jtIdProd.getText();
         p.nombreprod = jtNombreProd.getText();
         p.descprod = jtDescripProd.getText();
         p.categoriaprod = (String) jcCategoria.getSelectedItem();
         p.valorprod = Double.parseDouble(jtValorProd.getText());
         p.estado = false;
         pc.arrayProductos.set(num, p);
        JOptionPane.showMessageDialog(this, 
                "¡Producto eliminado exitosamente!");       
        evento_jbLimpiar();
    }
        
}
