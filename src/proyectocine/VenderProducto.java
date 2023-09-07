/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class VenderProducto extends JFrame{
    
    JLabel jlIdProducto, jlNombreProducto, jlDescProducto, jlValorProducto, jlCantidad, jlPagoParcial, jlCambio, jlPago, jlTipo;
    JTextField jtIdProducto, jtNombreProducto, jtDescProducto, jtValorProducto, jtCantidad, jtPagoParcial, jtCambio, jtPago, jtTipo;
    ProyectoCine va;
    JButton jbFinalizarCompra, jbAgregarProducto, jbBuscar, jbVolver;
    Double precioProd=0.0, Cambio=0.0, pagoParcial=0.0, pagoAlmacenado=0.0;
    String datos[] = new String[5];
   
 
    
    public VenderProducto(ProyectoCine obj){
        super("Vender Producto");
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
        JLabel jl = new JLabel("  Venta de Productos");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
       
        jlIdProducto = new JLabel("Código del producto:");
        jlIdProducto.setBounds(60, 80, 200, 30);
        add(jlIdProducto);
        
        jtIdProducto = new JTextField();
        jtIdProducto.setBounds(200, 80, 150, 30);
        add(jtIdProducto);
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(400, 80, 150, 30);
        jbBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                evento_jbBuscar();
            }
        });
        add(jbBuscar);      
      
        jlNombreProducto = new JLabel("Nombre del Producto:");
        jlNombreProducto.setBounds(60, 120, 150, 30);
        add(jlNombreProducto);
        
        jtNombreProducto = new JTextField();
        jtNombreProducto.setBounds(200, 120, 150, 30);
        jtNombreProducto.setEditable(false);
        add(jtNombreProducto);       

        jlDescProducto = new JLabel("Descripción del Producto:");
        jlDescProducto.setBounds(400, 120, 150, 30);        
        add(jlDescProducto);

        jtDescProducto = new JTextField();
        jtDescProducto.setBounds(580, 120, 150, 30);
        jtDescProducto.setEditable(false);
        add(jtDescProducto);        
        
        jlValorProducto = new JLabel("Valor del Producto:");
        jlValorProducto.setBounds(60, 160, 150, 30);
        add(jlValorProducto);
        
        jtValorProducto = new JTextField();
        jtValorProducto.setBounds(200, 160, 150, 30);
        jtValorProducto.setEditable(false);
        add(jtValorProducto);
        
        jlCantidad = new JLabel("Cantidad:");
        jlCantidad.setBounds(400, 160, 150, 30);
        add(jlCantidad);
        
        jtCantidad = new JTextField();
        jtCantidad.setBounds(580, 160, 150, 30);
        add(jtCantidad);
        
        jlTipo = new JLabel("Tipo de Comida");
        jlTipo.setBounds(60, 200, 150,30);
        add(jlTipo);
        
        jtTipo = new JTextField();
        jtTipo.setBounds(200,200,150,30);
        jtTipo.setEditable(false);
        add(jtTipo);
        
        jbVolver = new JButton("Atrás");
        jbVolver.setBounds(150, 400, 150, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        jbAgregarProducto = new JButton ("Agregar producto");
        jbAgregarProducto.setBounds(350, 235, 150, 30);
        jbAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAgregarProducto();
            }
        });
        add(jbAgregarProducto);   

        
        jlPagoParcial = new JLabel("Total Parcial:");
        jlPagoParcial .setBounds(60, 300, 150, 30);
        add(jlPagoParcial );
        
        jtPagoParcial  = new JTextField();
        jtPagoParcial.setBounds(200, 300, 150, 30);
        jtPagoParcial.setEditable(false);
        add(jtPagoParcial);
        
        jlPago = new JLabel("Pago:");
        jlPago.setBounds(400, 300, 150, 30);
        add(jlPago);
        
        jtPago = new JTextField();
        jtPago.setBounds(580, 300, 150, 30);
        add(jtPago);
        
        jlCambio = new JLabel("Cambio:");
        jlCambio.setBounds(60, 340, 150, 30);
        add(jlCambio);
        
        jtCambio  = new JTextField();
        jtCambio.setBounds(200, 340, 150, 30);
        jtCambio.setEditable(false);
        add(jtCambio);
        
        jbFinalizarCompra = new JButton ("Finalizar Compra");
        jbFinalizarCompra.setBounds(400, 340, 150, 30);
        jbFinalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbFinalizarCompra();
            }
        });
        add(jbFinalizarCompra);
        
       }
        

    
        public void evento_jbBuscar(){
        System.out.println("Entró a buscar");
        Producto p = new Producto();    
        
        for (int i = 0; i < va.arrayProductos.size(); i++) {
            Producto obj = va.arrayProductos.get(i);
            datos[0] = obj.idprod;
            datos[1] = obj.nombreprod;
            datos[2] = obj.descprod;
            datos[3] = obj.valorprod+"";
            datos[4] = obj.categoriaprod;            
            if(jtIdProducto.getText().equals(datos[0])){
                jtNombreProducto.setText(datos[1]);
                jtDescProducto.setText(datos[2]);
                jtValorProducto.setText(datos[3]);
                precioProd = Double.parseDouble(datos[3]);
                jtTipo.setText(datos[4]);
              
                
            }
        }
        
        
        }
        
        
        public void evento_jbAgregarProducto(){
            facturarProducto();
            System.out.println("Valor producto"+precioProd);
            pagoParcial = precioProd*Double.parseDouble(jtCantidad.getText());
            System.out.println("Pago Almacenado"+pagoParcial);
            //Almacena el pago
            pagoAlmacenado += pagoParcial;
            System.out.println("Pago Almacenado"+pagoAlmacenado);
            jtIdProducto.setText("");
            jtNombreProducto.setText("");
            jtDescProducto.setText("");
            jtValorProducto.setText("");
            jtCantidad.setText("");
            jtPagoParcial.setText(pagoAlmacenado+"");
            va.contadorvalorprod+=pagoAlmacenado;
            
            if(jtTipo.getText().equals("ComidaRapida")){
                va.contadorprodcomrap+=1;
            }else if(jtTipo.getText().equals("Mecato")){
                 va.contadorprodmec+=1;
            }else if(jtTipo.getText().equals("Bebida")){
                va.contadorprodbeb+=1;
            }
        }
        
        public void evento_jbFinalizarCompra(){
            Cambio = Double.parseDouble(jtPago.getText())-pagoAlmacenado; 
            jtIdProducto.setText("");
            jtNombreProducto.setText("");
            jtDescProducto.setText("");
            jtValorProducto.setText("");
            jtCantidad.setText("");
            jtCambio.setText(Cambio+""); //Pone el cambio del pago de los productos
            
        }
        
        public void facturarProducto(){
        ProductosVendidos pv = new ProductosVendidos();
        pv.idVenta = va.contadorventaprod;
        pv.idProducto = Integer.parseInt(jtIdProducto.getText());
        pv.nombreProducto = jtNombreProducto.getText();
        pv.descripcionProducto = jtDescProducto.getText();
       pv.cantidad = Integer.parseInt(jtCantidad.getText());
        pv.valorproducto = Double.parseDouble(jtValorProducto.getText());
       pv.fecha = Instant.now()+"";
        
        System.out.println(jtNombreProducto.getText()+" "+jtDescProducto.getText()+ pv.fecha);
        va.arrayProductosVendidos.add(pv);     
        va.contadorventaprod+=1;
        }
        
        public void evento_jbVolver(){
         // setVisible(false); // ocultar la ventana 
        // NewUsuario nw = new NewUsuario(null);
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaVendedor nw = new VentanaVendedor(va); // mostrar la ventana del menu principal    
        }
 
    
}
