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
public class CuadreCaja extends JFrame{
    
    ProyectoCine va;
    ModeloTablaProductoVend mtp;
    ModeloTablaBoletoVend mtp2;
    JTable tabla;
    JTable tabla2;
    JButton jbVolver;
    JLabel jlVentaProductos, jlVentaBoletos;
    
    public CuadreCaja(ProyectoCine obj){
        super("Ventas");
        va = obj;
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
        setLayout(null);
        setResizable(false);
        crearGUI();  
        crearGUI2();
        llenarTabla();
        llenarTabla2();
        setVisible(true);
    }
    
    public void crearGUI(){
       /* System.out.println("Ventas");
        JLabel jl = new JLabel("  Listado de productos");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);*/
        
        jlVentaProductos = new JLabel("Venta de Productos");
        jlVentaProductos.setBounds(175, 5, 500, 100);
        add(jlVentaProductos);
       
        String encabezados[] = {"Id Venta", "Id Producto", "Nombre Prod.", "Desc. Prod", "Cant Prod.", "Valor Prod.", "Fecha"};
        String datos[][] = {{"", "", "", "", "", "", ""}};
        
        mtp = new ModeloTablaProductoVend(datos, encabezados);
        tabla = new JTable(mtp);
        
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        
        TableColumn tc = tabla.getColumn("Id Producto");
        tc.setPreferredWidth(70); // establecer que la columna del Numero ID tenga 50 px de ancho
        
        DefaultTableCellRenderer tc1 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tc1); // establecer que el contenido de la columna del Numero cedula quede centrado
        
        DefaultTableCellRenderer tc2 = new DefaultTableCellRenderer();
        tc2.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(3).setCellRenderer(tc2); // establecer que el contenido de la columna del genero quede centrado
        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(175, 70, 500, 120); // dar ubicacion y tamaño al JTable
        
        add(js); // adicionar el JTable al JFrame
        

        

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
    
    public void crearGUI2(){
        
        jlVentaBoletos = new JLabel("Venta de Boletos");
        jlVentaBoletos.setBounds(175, 180, 500, 100);
        add(jlVentaBoletos);
        
        String encabezados2[] = {"Id Venta","Id Pelicula", "Cant Boletos", "Pago Total", "Fecha"};
        String datos2[][] = {{"", "", "", "", ""}};
        
        mtp2 = new ModeloTablaBoletoVend(datos2, encabezados2);
        tabla2 = new JTable(mtp2);
        
        tabla2.setSelectionBackground(Color.lightGray);
        tabla2.setSelectionForeground(Color.RED);
        
        TableColumn tc = tabla2.getColumn("Id Pelicula");
        tc.setPreferredWidth(70); // establecer que la columna del Numero ID tenga 50 px de ancho
        
        DefaultTableCellRenderer tc1 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.CENTER);
        tabla2.getColumnModel().getColumn(0).setCellRenderer(tc1); // establecer que el contenido de la columna del Numero cedula quede centrado
        
        DefaultTableCellRenderer tc2 = new DefaultTableCellRenderer();
        tc2.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla2.getColumnModel().getColumn(3).setCellRenderer(tc2); // establecer que el contenido de la columna del genero quede centrado
        
        JScrollPane js2 = new JScrollPane(tabla2);
        js2.setBounds(175, 245, 500, 120); // dar ubicacion y tamaño al JTable
        
        add(js2); // adicionar el JTable al JFrame
    }
         
        public void evento_jbVolver(){          
        // setVisible(false); // ocultar la ventana 
        // NewUsuario nw = new NewUsuario(null);
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaAdmin nw = new VentanaAdmin(va); // mostrar la ventana del menu principal
    }
    
    public void llenarTabla(){
        mtp.removeRow(0);// eliminar la fila por defecto
        for (int i = 0; i < va.arrayProductosVendidos.size(); i++) {// recorrer el ArrayList con los datos de las personas
            ProductosVendidos obj = va.arrayProductosVendidos.get(i); // obtener los datos de cada persona
            String datos[] = new String[7];
            datos[0] = obj.idVenta+"";
            datos[1] = obj.idProducto+"";
            datos[2] = obj.nombreProducto;
            datos[3] = obj.descripcionProducto;
            datos[4] = obj.cantidad+"";
            datos[5] = obj.valorproducto+"";
            datos[6] = obj.fecha;
            mtp.addRow(datos); // adicionar una fila al JTable
    }
    } 
    
        public void llenarTabla2(){
        mtp2.removeRow(0);// eliminar la fila por defecto
        for (int i = 0; i < va.arrayBoletosVendidos.size(); i++) {// recorrer el ArrayList con los datos de las personas
            BoletosVendidos obj = va.arrayBoletosVendidos.get(i); // obtener los datos de cada persona
            String datos[] = new String[5];
            datos[0] = obj.idVenta+"";
            datos[1] = obj.idPelicula+"";
            datos[2] = obj.cantidad+"";
            datos[3] = obj.pago+"";
            datos[4] = obj.fecha;
            mtp2.addRow(datos); // adicionar una fila al JTable
    }
    } 
    
}
