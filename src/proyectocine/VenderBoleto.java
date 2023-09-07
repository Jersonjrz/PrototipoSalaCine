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
import javax.swing.JTextField;

/**
 *
 * @author jerso
 */
public class VenderBoleto extends JFrame{
    
    
    ProyectoCine va;
    JLabel jlIdPeli, jlCantidadBoletos, jlPago, jlCambio, jlNumeroSilla;
    JLabel jla, jlb, jlc, jld, jl1, jl2, jl3, jl4;
    //JTextField para sillas
    JTextField jta1, jta2, jta3, jta4, jtb1, jtb2, jtb3, jtb4, jtc1, jtc2, jtc3, jtc4, jtd1, jtd2, jtd3, jtd4; 
    JTextField jtIdPeli, jtCantidadBoletos, jtPago, jtCambio, jtNumeroSilla;
    JButton jbComprar, jbConsultarAsientos, jbVolver, jbOcupar, jbInicializar;
    Double devolucion;
    
       public VenderBoleto(ProyectoCine obj){
        super("Vender Boleto");
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
        JLabel jl = new JLabel("  Venta de Boletos");
        jl.setBounds(0, 0, 800, 60);
        jl.setOpaque(true);
        jl.setBackground(Color.BLUE);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jl);
       
        jlIdPeli = new JLabel("Código de la pelicula:");
        jlIdPeli.setBounds(60, 80, 200, 30);
        add(jlIdPeli);
        
        jtIdPeli = new JTextField();
        jtIdPeli.setBounds(200, 80, 150, 30);
        add(jtIdPeli);
        
        jlCantidadBoletos = new JLabel("Cantidad de boletos:");
        jlCantidadBoletos .setBounds(400, 80, 150, 30);
        add(jlCantidadBoletos );
        
        jtCantidadBoletos = new JTextField();
        jtCantidadBoletos.setBounds(520, 80, 150, 30);
        add(jtCantidadBoletos); 
        
        jlPago = new JLabel("Pago recibido:");
        jlPago.setBounds(60, 120, 150, 30);
        add(jlPago);
        
        jtPago = new JTextField();
        jtPago.setBounds(200, 120, 150, 30);
        add(jtPago);       

        jbComprar = new JButton("Pagar:");
        jbComprar.setBounds(400, 120, 150, 30);
        
        add(jbComprar);
        jbComprar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                evento_jbComprar();
            }
        });
        add(jbComprar);
        
        
        jlCambio = new JLabel("Cambio:");
        jlCambio.setBounds(60, 160, 150, 30);
        add(jlCambio);
        
        jtCambio = new JTextField();
        jtCambio.setBounds(200, 160, 150, 30);
        jtCambio.setEditable(false); //Pone la caja de texto en false, o sea que la bloquea
        add(jtCambio);
        
        jlNumeroSilla = new JLabel("No. Silla");
        jlNumeroSilla.setBounds(60, 270, 150, 30);
        add(jlNumeroSilla);
        
        jtNumeroSilla = new JTextField();
        jtNumeroSilla.setBounds(130, 270, 50, 30);
        add(jtNumeroSilla);
        
        jbOcupar = new JButton("Ocupar");
        jbOcupar.setBounds(60, 320, 150, 30);
        jbOcupar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbOcupar();
            }
        });
        add(jbOcupar);
        
        jbVolver = new JButton("Atrás");
        jbVolver.setBounds(30, 400, 150, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        jbInicializar = new JButton("Reinciar Salas");
        jbInicializar.setBounds(200, 400, 150, 30);
        jbInicializar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbInicializarSalas();
            }
        });
        add(jbInicializar);
        
        jbConsultarAsientos = new JButton ("Consultar Asientos");
        jbConsultarAsientos.setBounds(60, 210, 150, 30);
        jbConsultarAsientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbConsultarAsientos();
            }
        });
        add(jbConsultarAsientos);
        
        jl1 = new JLabel("1");
        jl1.setBounds(410,180,30,30); //Primer numero fila, segundo numero columna
        add(jl1);
        
        jl2 = new JLabel("2");
        jl2.setBounds(460,180,30,30);
        add(jl2);
        
        jl3 = new JLabel("3");
        jl3.setBounds(510,180,30,30);
        add(jl3);
        
        jl4 = new JLabel("4");
        jl4.setBounds(560,180,30,30);
        add(jl4); 
        
        jla = new JLabel("A");
        jla.setBounds(370,210,30,30);
        add(jla);

        jlb = new JLabel("B");
        jlb.setBounds(370,260,30,30);
        add(jlb);

        jlc = new JLabel("C");
        jlc.setBounds(370,310,30,30);
        add(jlc);

        jld = new JLabel("D");
        jld.setBounds(370,360,30,30);
        add(jld);
        
        
        //--------------SILLAS----------------------------------
        
        jta1 = new JTextField();
        jta1.setHorizontalAlignment(JTextField.CENTER);
        jta1.setBounds(400,210,30,30);
        add(jta1);
        
        jta2 = new JTextField();
        jta2.setHorizontalAlignment(JTextField.CENTER);
        jta2.setBounds(450,210,30,30);
        add(jta2);
        
        jta3 = new JTextField();
        jta3.setHorizontalAlignment(JTextField.CENTER);
        jta3.setBounds(500,210,30,30);
        add(jta3);
        
        jta4 = new JTextField();
        jta4.setHorizontalAlignment(JTextField.CENTER);
        jta4.setBounds(550,210,30,30);
        add(jta4);
        
        jtb1 = new JTextField();
        jtb1.setHorizontalAlignment(JTextField.CENTER);
        jtb1.setBounds(400,260,30,30);
        add(jtb1);
        
        jtb2 = new JTextField();
        jtb2.setHorizontalAlignment(JTextField.CENTER);
        jtb2.setBounds(450,260,30,30);
        add(jtb2);
        
        jtb3 = new JTextField();
        jtb3.setHorizontalAlignment(JTextField.CENTER);
        jtb3.setBounds(500,260,30,30);
        add(jtb3);
        
        jtb4 = new JTextField();
        jtb4.setHorizontalAlignment(JTextField.CENTER);
        jtb4.setBounds(550,260,30,30);
        add(jtb4);        
        
        jtc1 = new JTextField();
        jtc1.setHorizontalAlignment(JTextField.CENTER);
        jtc1.setBounds(400,310,30,30);
        add(jtc1);
        
        jtc2 = new JTextField();
        jtc2.setHorizontalAlignment(JTextField.CENTER);
        jtc2.setBounds(450,310,30,30);
        add(jtc2);
        
        jtc3 = new JTextField();
        jtc3.setHorizontalAlignment(JTextField.CENTER);
        jtc3.setBounds(500,310,30,30);
        add(jtc3);
        
        jtc4 = new JTextField();
        jtc4.setHorizontalAlignment(JTextField.CENTER);
        jtc4.setBounds(550,310,30,30);
        add(jtc4);
        
        jtd1 = new JTextField();
        jtd1.setHorizontalAlignment(JTextField.CENTER);
        jtd1.setBounds(400,360,30,30);
        add(jtd1);
        
        jtd2 = new JTextField();
        jtd2.setHorizontalAlignment(JTextField.CENTER);
        jtd2.setBounds(450,360,30,30);
        add(jtd2);
        
        jtd3 = new JTextField();
        jtd3.setHorizontalAlignment(JTextField.CENTER);
        jtd3.setBounds(500,360,30,30);
        add(jtd3);
        
        jtd4 = new JTextField();
        jtd4.setHorizontalAlignment(JTextField.CENTER);
        jtd4.setBounds(550,360,30,30);
        add(jtd4);
       }
       
       
       
       //Empieza la logica
       public void evento_jbComprar(){
           System.out.println("Entró a comprar");
             for (int i = 0; i < va.arrayPeliculas.size(); i++) {// recorrer el ArrayList con los datos de las personas
            Pelicula obj = va.arrayPeliculas.get(i); // obtener los datos de cada persona
            String datos[] = new String[6];
            datos[0] = obj.idPelicula;
            datos[1] = obj.nomPelicula;
            datos[2] = obj.horaPelicula;
            datos[3] = obj.duracionPelicula;
            datos[4] = obj.catPelicula;
            datos[5] = obj.precio+""; 
                if(jtIdPeli.getText().equals(datos[0])){
                devolucion = Double.parseDouble(jtPago.getText())-(Double.parseDouble(datos[5])*Double.parseDouble(jtCantidadBoletos.getText()));
                va.contadorvalorpel+=Double.parseDouble(datos[5])*Double.parseDouble(jtCantidadBoletos.getText());
                System.out.println("Su devolucion es: "+devolucion);
                jtCambio.setText(devolucion+"");
                if(jtIdPeli.getText().equals("0")){
                    va.contadorpelicula0+=Integer.parseInt(jtCantidadBoletos.getText());
                }else if(jtIdPeli.getText().equals("1")){
                    va.contadorpelicula1+=Integer.parseInt(jtCantidadBoletos.getText());
                }else if(jtIdPeli.getText().equals("2")){
                    va.contadorpelicula2+=Integer.parseInt(jtCantidadBoletos.getText());
                }else if(jtIdPeli.getText().equals("3")){
                    va.contadorpelicula3+=Integer.parseInt(jtCantidadBoletos.getText());
                }
            }
        } 
            facturarBoletos(); 
      }
       
       //Reiniciar sillas
     public void evento_jbInicializarSalas(){
        va.matriz1[0][0] = "";
        va.matriz1[0][1] = "";
        va.matriz1[0][2] = "";
        va.matriz1[0][3] = "";
        va.matriz1[1][0] = "";
        va.matriz1[1][1] = "";
        va.matriz1[1][2] = "";
        va.matriz1[1][3] = "";
        va.matriz1[2][0] = "";
        va.matriz1[2][1] = "";
        va.matriz1[2][2] = "";
        va.matriz1[2][3] = "";
        va.matriz1[3][0] = "";
        va.matriz1[3][1] = "";
        va.matriz1[3][2] = "";
        va.matriz1[3][3] = "";
        
        va.matriz2[0][0] = "";
        va.matriz2[0][1] = "";
        va.matriz2[0][2] = "";
        va.matriz2[0][3] = "";
        va.matriz2[1][0] = "";
        va.matriz2[1][1] = "";
        va.matriz2[1][2] = "";
        va.matriz2[1][3] = "";
        va.matriz2[2][0] = "";
        va.matriz2[2][1] = "";
        va.matriz2[2][2] = "";
        va.matriz2[2][3] = "";
        va.matriz2[3][0] = "";
        va.matriz2[3][1] = "";
        va.matriz2[3][2] = "";
        va.matriz2[3][3] = "";
        
        va.matriz3[0][0] = "";
        va.matriz3[0][1] = "";
        va.matriz3[0][2] = "";
        va.matriz3[0][3] = "";
        va.matriz3[1][0] = "";
        va.matriz3[1][1] = "";
        va.matriz3[1][2] = "";
        va.matriz3[1][3] = "";
        va.matriz3[2][0] = "";
        va.matriz3[2][1] = "";
        va.matriz3[2][2] = "";
        va.matriz3[2][3] = "";
        va.matriz3[3][0] = "";
        va.matriz3[3][1] = "";
        va.matriz3[3][2] = "";
        va.matriz3[3][3] = "";
        
        va.matriz4[0][0] = "";
        va.matriz4[0][1] = "";
        va.matriz4[0][2] = "";
        va.matriz4[0][3] = "";
        va.matriz4[1][0] = "";
        va.matriz4[1][1] = "";
        va.matriz4[1][2] = "";
        va.matriz4[1][3] = "";
        va.matriz4[2][0] = "";
        va.matriz4[2][1] = "";
        va.matriz4[2][2] = "";
        va.matriz4[2][3] = "";
        va.matriz4[3][0] = "";
        va.matriz4[3][1] = "";
        va.matriz4[3][2] = "";
        va.matriz4[3][3] = "";
       
        evento_jbConsultarAsientos();
     }
     
     
     //Comsultar sillas
    public void evento_jbConsultarAsientos() {
        if (jtIdPeli.getText().equals("0")) {
            System.out.println("Entro a if consultar asientos");
            //Recorre matriz
            for (int x = 0; x < va.matriz1.length; x++) {
                for (int y = 0; y < va.matriz1.length; y++) {
                    System.out.println(va.matriz1[x][y]);
                    jta1.setText(va.matriz1[0][0]);
                    jta2.setText(va.matriz1[0][1]);
                    jta3.setText(va.matriz1[0][2]);
                    jta4.setText(va.matriz1[0][3]);

                    jtb1.setText(va.matriz1[1][0]);
                    jtb2.setText(va.matriz1[1][1]);
                    jtb3.setText(va.matriz1[1][2]);
                    jtb4.setText(va.matriz1[1][3]);

                    jtc1.setText(va.matriz1[2][0]);
                    jtc2.setText(va.matriz1[2][1]);
                    jtc3.setText(va.matriz1[2][2]);
                    jtc4.setText(va.matriz1[2][3]);

                    jtd1.setText(va.matriz1[3][0]);
                    jtd2.setText(va.matriz1[3][1]);
                    jtd3.setText(va.matriz1[3][2]);
                    jtd4.setText(va.matriz1[3][3]);
                }
            }
        } else if (jtIdPeli.getText().equals("1")) {
            for (int x = 0; x < va.matriz2.length; x++) {
                for (int y = 0; y < va.matriz2.length; y++) {
                    System.out.println(va.matriz1[x][y]);
                    jta1.setText(va.matriz2[0][0]);
                    jta2.setText(va.matriz2[0][1]);
                    jta3.setText(va.matriz2[0][2]);
                    jta4.setText(va.matriz2[0][3]);

                    jtb1.setText(va.matriz2[1][0]);
                    jtb2.setText(va.matriz2[1][1]);
                    jtb3.setText(va.matriz2[1][2]);
                    jtb4.setText(va.matriz2[1][3]);

                    jtc1.setText(va.matriz2[2][0]);
                    jtc2.setText(va.matriz2[2][1]);
                    jtc3.setText(va.matriz2[2][2]);
                    jtc4.setText(va.matriz2[2][3]);

                    jtd1.setText(va.matriz2[3][0]);
                    jtd2.setText(va.matriz2[3][1]);
                    jtd3.setText(va.matriz2[3][2]);
                    jtd4.setText(va.matriz2[3][3]);
                }
            }
        } else if (jtIdPeli.getText().equals("2")) {
            for (int x = 0; x < va.matriz3.length; x++) {
                for (int y = 0; y < va.matriz3.length; y++) {
                    System.out.println(va.matriz3[x][y]);
                    jta1.setText(va.matriz3[0][0]);
                    jta2.setText(va.matriz3[0][1]);
                    jta3.setText(va.matriz3[0][2]);
                    jta4.setText(va.matriz3[0][3]);

                    jtb1.setText(va.matriz3[1][0]);
                    jtb2.setText(va.matriz3[1][1]);
                    jtb3.setText(va.matriz3[1][2]);
                    jtb4.setText(va.matriz3[1][3]);

                    jtc1.setText(va.matriz3[2][0]);
                    jtc2.setText(va.matriz3[2][1]);
                    jtc3.setText(va.matriz3[2][2]);
                    jtc4.setText(va.matriz3[2][3]);

                    jtd1.setText(va.matriz3[3][0]);
                    jtd2.setText(va.matriz3[3][1]);
                    jtd3.setText(va.matriz3[3][2]);
                    jtd4.setText(va.matriz3[3][3]);

                }
            }

        } else if(jtIdPeli.getText().equals("3")){
                       for (int x = 0; x < va.matriz4.length; x++) {
                for (int y = 0; y < va.matriz4.length; y++) {
                    System.out.println(va.matriz4[x][y]);
                    jta1.setText(va.matriz4[0][0]);
                    jta2.setText(va.matriz4[0][1]);
                    jta3.setText(va.matriz4[0][2]);
                    jta4.setText(va.matriz4[0][3]);

                    jtb1.setText(va.matriz4[1][0]);
                    jtb2.setText(va.matriz4[1][1]);
                    jtb3.setText(va.matriz4[1][2]);
                    jtb4.setText(va.matriz4[1][3]);

                    jtc1.setText(va.matriz4[2][0]);
                    jtc2.setText(va.matriz4[2][1]);
                    jtc3.setText(va.matriz4[2][2]);
                    jtc4.setText(va.matriz4[2][3]);

                    jtd1.setText(va.matriz4[3][0]);
                    jtd2.setText(va.matriz4[3][1]);
                    jtd3.setText(va.matriz4[3][2]);
                    jtd4.setText(va.matriz4[3][3]);
                }
            } 
        }
    }  
        
    public void evento_jbOcupar() {
        
        
        System.out.println("Entro a jbOcupar");
        String silla = jtNumeroSilla.getText();
        
         if (jtIdPeli.getText().equals("0")){
        switch (silla) {
            case "A1":
                    va.matriz1 [0][0] = "X";
                    evento_jbConsultarAsientos();
                break;
            case "A2":
                    va.matriz1 [0][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A3":
                    va.matriz1 [0][2] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A4":
                    va.matriz1 [0][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B1":
                    va.matriz1 [1][0] = "X";
                     evento_jbConsultarAsientos();
                break;                
             case "B2":
                    va.matriz1 [1][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B3":
                    va.matriz1 [1][2] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "B4":
                    va.matriz1 [1][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "C1":
                    va.matriz1 [2][0] = "X";
                    evento_jbConsultarAsientos();
                break;                 
            case "C2":
                    va.matriz1 [2][1] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C3":
                    va.matriz1 [2][2] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C4":
                    va.matriz1 [2][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "D1":
                    va.matriz1 [3][0] = "X";
                    evento_jbConsultarAsientos();
                break; 
             case "D2":
                    va.matriz1 [3][1] = "X";
                     evento_jbConsultarAsientos();
                break;
             case "D3":
                    va.matriz1 [3][2] = "X";
                    evento_jbConsultarAsientos();
                break;                 
             case "D4":
                    va.matriz1 [3][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
        }
         }else if(jtIdPeli.getText().equals("1")){
            switch (silla) {
            case "A1":
                    va.matriz2 [0][0] = "X";
                    evento_jbConsultarAsientos();
                break;
            case "A2":
                    va.matriz2 [0][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A3":
                    va.matriz2 [0][2] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A4":
                    va.matriz2 [0][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B1":
                    va.matriz2 [1][0] = "X";
                     evento_jbConsultarAsientos();
                break;                
             case "B2":
                    va.matriz2 [1][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B3":
                    va.matriz2 [1][2] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "B4":
                    va.matriz2 [1][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "C1":
                    va.matriz2 [2][0] = "X";
                    evento_jbConsultarAsientos();
                break;                 
            case "C2":
                    va.matriz2 [2][1] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C3":
                    va.matriz2 [2][2] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C4":
                    va.matriz2 [2][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "D1":
                    va.matriz2 [3][0] = "X";
                    evento_jbConsultarAsientos();
                break; 
             case "D2":
                    va.matriz2 [3][1] = "X";
                     evento_jbConsultarAsientos();
                break;
             case "D3":
                    va.matriz2 [3][2] = "X";
                    evento_jbConsultarAsientos();
                break;                 
             case "D4":
                    va.matriz2 [3][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
        }             
         }else if(jtIdPeli.getText().equals("2")){
             switch (silla) {
            case "A1":
                    va.matriz3 [0][0] = "X";
                    evento_jbConsultarAsientos();
                break;
            case "A2":
                    va.matriz3 [0][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A3":
                    va.matriz3 [0][2] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A4":
                    va.matriz3 [0][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B1":
                    va.matriz3 [1][0] = "X";
                     evento_jbConsultarAsientos();
                break;                
             case "B2":
                    va.matriz3 [1][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B3":
                    va.matriz3 [1][2] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "B4":
                    va.matriz3 [1][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "C1":
                    va.matriz3 [2][0] = "X";
                    evento_jbConsultarAsientos();
                break;                 
            case "C2":
                    va.matriz3 [2][1] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C3":
                    va.matriz3 [2][2] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C4":
                    va.matriz3 [2][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "D1":
                    va.matriz3 [3][0] = "X";
                    evento_jbConsultarAsientos();
                break; 
             case "D2":
                    va.matriz3 [3][1] = "X";
                     evento_jbConsultarAsientos();
                break;
             case "D3":
                    va.matriz3 [3][2] = "X";
                    evento_jbConsultarAsientos();
                break;                 
             case "D4":
                    va.matriz3 [3][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
        }    
         }else if(jtIdPeli.getText().equals("3")){
             switch (silla) {
            case "A1":
                    va.matriz4 [0][0] = "X";
                    evento_jbConsultarAsientos();
                break;
            case "A2":
                    va.matriz4 [0][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A3":
                    va.matriz4 [0][2] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "A4":
                    va.matriz4 [0][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B1":
                    va.matriz4 [1][0] = "X";
                     evento_jbConsultarAsientos();
                break;                
             case "B2":
                    va.matriz4 [1][1] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "B3":
                    va.matriz4 [1][2] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "B4":
                    va.matriz4 [1][3] = "X";
                     evento_jbConsultarAsientos();
                break;
            case "C1":
                    va.matriz4 [2][0] = "X";
                    evento_jbConsultarAsientos();
                break;                 
            case "C2":
                    va.matriz4 [2][1] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C3":
                    va.matriz4 [2][2] = "X";
                    evento_jbConsultarAsientos();
                break; 
            case "C4":
                    va.matriz4 [2][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
            case "D1":
                    va.matriz4 [3][0] = "X";
                    evento_jbConsultarAsientos();
                break; 
             case "D2":
                    va.matriz4 [3][1] = "X";
                     evento_jbConsultarAsientos();
                break;
             case "D3":
                    va.matriz4 [3][2] = "X";
                    evento_jbConsultarAsientos();
                break;                 
             case "D4":
                    va.matriz4 [3][3] = "X";
                     evento_jbConsultarAsientos();
                break; 
        }                
         }

    }
       
    
    public void facturarBoletos(){
    
        BoletosVendidos bv = new BoletosVendidos();
        bv.idVenta = va.contadorventapel;
        bv.idPelicula = Integer.parseInt(jtIdPeli.getText());
        bv.cantidad = Integer.parseInt(jtCantidadBoletos.getText());
        bv.pago = Double.parseDouble(jtPago.getText());  
        bv.fecha = Instant.now()+"";
        va.arrayBoletosVendidos.add(bv);     
        va.contadorventapel+=1;
        }
    
       
         public void evento_jbVolver(){          
        // setVisible(false); // ocultar la ventana 
        // NewUsuario nw = new NewUsuario(null);
        setVisible(false); // ocultar la ventana del formulario
        dispose(); // destruir la ventana de la memoria
        VentanaVendedor nw = new VentanaVendedor(va); // mostrar la ventana del menu principal
    }
         


    
}
