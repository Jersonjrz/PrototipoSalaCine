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
public class ModificarPelicula extends JFrame{
    
    
    ProyectoCine pc;
    JLabel jlIdPelicula, jlNomPelicula, jlHoraPelicula, jlDuracionPelicula, jlCatPelicula, jlValorPelicula;
    JTextField jtIdPelicula, jtNomPelicula, jtHoraPelicula, jtDuracionPelicula,  jtValorPelicula;
    JComboBox jcCategoria;
    JButton jbVolver, jbLimpiar, jbBuscar, jbModificar;
  
    
    public ModificarPelicula(ProyectoCine obj){
        super("Modificar Pelicula");
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
                 JLabel jl = new JLabel("  Modificar pelicula");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        jlIdPelicula = new JLabel("Código Pelicula:");
        jlIdPelicula.setBounds(60, 80, 200, 30);
        add(jlIdPelicula);
        
        jtIdPelicula = new JTextField();
        jtIdPelicula.setBounds(200, 80, 150, 30);
        add(jtIdPelicula);
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(400,80,150,30);
        jbBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbBuscar();
            }
        });
        add(jbBuscar);
        
        jlNomPelicula = new JLabel("Nombre Pelicula");
        jlNomPelicula.setBounds(60, 120, 150, 30);
        add(jlNomPelicula);
        
        jtNomPelicula = new JTextField();
        jtNomPelicula.setBounds(200, 120, 150, 30);
        add(jtNomPelicula); 
        
        jlHoraPelicula = new JLabel("Hora Pelicula");
        jlHoraPelicula.setBounds(400, 120, 150, 30);
        add(jlHoraPelicula);
        
        jtHoraPelicula = new JTextField();
        jtHoraPelicula.setBounds(520, 120, 150, 30);
        add(jtHoraPelicula); 
        
        jlCatPelicula = new JLabel("Categoría Pelicula:");
        jlCatPelicula.setBounds(60, 160, 150, 30);
        add(jlCatPelicula);
        
        jcCategoria = new JComboBox<>();
        jcCategoria.addItem("Acción");
        jcCategoria.addItem("Terror");
        jcCategoria.addItem("Comedia");
        jcCategoria.addItem("Animada");
        jcCategoria.addItem("Suspenso");
        jcCategoria.addItem("Drama");
        jcCategoria.setBounds(200, 160, 150, 30);
        add(jcCategoria);        
        
        jlDuracionPelicula = new JLabel("Duracion Pelicula");
        jlDuracionPelicula.setBounds(400, 160, 150, 30);
        add(jlDuracionPelicula);
        
        jtDuracionPelicula = new JTextField();
        jtDuracionPelicula.setBounds(520, 160, 150, 30);
        add(jtDuracionPelicula); 
        
        jlValorPelicula = new JLabel("Valor Pelicula");
        jlValorPelicula.setBounds(60, 200, 150, 30);
        add(jlValorPelicula);
        
        jtValorPelicula = new JTextField();
        jtValorPelicula.setBounds(200, 200, 150, 30);
        add(jtValorPelicula); 

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
        Pelicula u = new Pelicula();
        String d1 = "", d2 = "", d3 = "";
        String datos[] = new String[6];
        for (int i = 0; i < pc.arrayPeliculas.size(); i++) {
            Pelicula obj = pc.arrayPeliculas.get(i);
            datos[0] = obj.idPelicula;
            datos[1] = obj.nomPelicula;
            datos[2] = obj.horaPelicula;
            datos[3] = obj.precio+"";
            datos[4] = obj.duracionPelicula;
            datos[5] = obj.catPelicula;  
            d1 = datos[1];
            d2 = datos[4];
            d3 = datos[5];
            
            if(jtIdPelicula.getText().equals(datos[0])){
                jtNomPelicula.setText(datos[1]);
                jtHoraPelicula.setText(datos[2]);
                jtValorPelicula.setText(datos[3]);
                jtDuracionPelicula.setText(datos[4]);
                jcCategoria.setSelectedItem(datos[5]);;
            }
        }
    }
    
        public void evento_jbModificar(){      
        int num = Integer.parseInt(jtIdPelicula.getText());         
        System.out.println("Entró a for modificar");
        Pelicula p = new Pelicula();
         p.idPelicula = jtIdPelicula.getText();
         p.nomPelicula = jtNomPelicula.getText();
         p.horaPelicula = jtHoraPelicula.getText();
         p.catPelicula = (String) jcCategoria.getSelectedItem();
         p.precio = Double.parseDouble(jtValorPelicula.getText());
         p.duracionPelicula = jtDuracionPelicula.getText();
         pc.arrayPeliculas.set(num, p);
        JOptionPane.showMessageDialog(this, 
                "¡Pelicula modificada exitosamente!");       
        evento_jbLimpiar();
        
    //}
    }
        
        public void evento_jbLimpiar(){
        jtIdPelicula.setText("");
        jtNomPelicula.setText("");
        jtHoraPelicula.setText("");      
        jcCategoria.setSelectedItem("Acción");        
        jtValorPelicula.setText("");
        jtDuracionPelicula.setText("");
    }
        
        public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        ConsultarPeliculas pv = new ConsultarPeliculas(pc); // mostrar la ventana del menu principal
    }    
    
            public void evento_jbEliminar(){
        int num = Integer.parseInt(jtIdPelicula.getText());         
        System.out.println("Entró a for modificar");
        Pelicula p = new Pelicula();
         p.idPelicula = jtIdPelicula.getText();
         p.nomPelicula = jtNomPelicula.getText();
         p.horaPelicula = jtHoraPelicula.getText();
         p.catPelicula = (String) jcCategoria.getSelectedItem();
         p.precio = Double.parseDouble(jtValorPelicula.getText());
         p.duracionPelicula = jtDuracionPelicula.getText();
         p.estado = false;
         pc.arrayPeliculas.set(num, p);
        JOptionPane.showMessageDialog(this, 
                "¡Pelicula eliminada exitosamente!");       
        evento_jbLimpiar();
    }
    
}
