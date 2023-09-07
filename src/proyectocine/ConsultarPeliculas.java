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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jerso
 */
public class ConsultarPeliculas extends JFrame{
    
    JButton jbVolver, jbModificar;
    ModeloTablaPel mtpe;
    JTable tabla;
    ProyectoCine va;
    
    public ConsultarPeliculas(ProyectoCine obj){
        super("Listado de Peliculas");
        va = obj;
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setLayout(null);
        setResizable(false);
        crearGUI();    
        llenarTabla();
        setVisible(true);
    }
    
     public void crearGUI() {
        System.out.println("Consultar Peliculas");
        JLabel jl = new JLabel("  Listado de peliculas");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
        
        String encabezados[] = {"Id Pelicula", "Nombre", "Hora", "Duración", "Categoria", "Precio", "Estado"};
        String datos[][] = {{"", "", "", "", "", "", ""}};
        
        mtpe = new ModeloTablaPel(datos, encabezados);
        tabla = new JTable(mtpe);
        
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        
        TableColumn tc = tabla.getColumn("Id Pelicula");
        tc.setPreferredWidth(70); // establecer que la columna del Numero ID tenga 50 px de ancho
        
        DefaultTableCellRenderer tc1 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tc1); // establecer que el contenido de la columna del Numero cedula quede centrado
        
        DefaultTableCellRenderer tc2 = new DefaultTableCellRenderer();
        tc2.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(3).setCellRenderer(tc2); // establecer que el contenido de la columna del genero quede centrado
        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(175, 140, 450, 150); // dar ubicacion y tamaño al JTable
        
        add(js); // adicionar el JTable al JFrame

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
        
                jbModificar = new JButton("Modificar/Eliminar");
        jbModificar.setBounds(320, 400, 150, 30);
        jbModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbModificar();
            }
        });
        add(jbModificar);
    }
    
        public void evento_jbVolver(){          
        // setVisible(false); // ocultar la ventana 
        // NewUsuario nw = new NewUsuario(null);
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        NewPelicula nw = new NewPelicula(va); // mostrar la ventana del menu principal
    }
        
        public void llenarTabla(){
             System.out.println("Entró a llenar tabla desde Listado");
            System.out.println("Entro a llenar tabla");
          
        mtpe.removeRow(0);// eliminar la fila por defecto
        for (int i = 0; i < va.arrayPeliculas.size(); i++) {// recorrer el ArrayList con los datos de las personas
            Pelicula obj = va.arrayPeliculas.get(i); // obtener los datos de cada persona
            String datos[] = new String[7];
            datos[0] = obj.idPelicula;
            datos[1] = obj.nomPelicula;
            datos[2] = obj.horaPelicula;
            datos[3] = obj.duracionPelicula;
            datos[4] = obj.catPelicula;
            datos[5] = obj.precio+"";
            datos[6] = obj.estado+"";
            mtpe.addRow(datos); // adicionar una fila al JTable
            
        }  
    }
    
        public void evento_jbModificar(){
        setVisible(false);
        ModificarPelicula mu = new ModificarPelicula(va);
        }
        
}
