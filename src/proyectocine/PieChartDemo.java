/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jerso
 */
public class PieChartDemo extends JFrame {
    
    JFreeChart chart;
    ProyectoCine pc;
    JButton jbVolver;
    
    public PieChartDemo(ProyectoCine obj) {
        super("Gráfica tipo de comidas");
        pc = obj;
        setSize(800, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 430);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Comida rápida", pc.contadorprodcomrap);
        data.setValue("Mecato", pc.contadorprodmec);
        data.setValue("Bebida", pc.contadorprodbeb);


        chart = ChartFactory.createPieChart(
                "Tipo de Producto más consumido", //Titulo del grafico
                data, //data
                true, //Leyenda
                true,
                false);

        //pintura
        chart.setBackgroundPaint(Color.ORANGE);//Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); //Dar color al titulo

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setExplodePercent("Comida rápida", 0.33);
        plot.setExplodePercent("Mecato", 0.27);
        
        plot.setLabelBackgroundPaint(Color.ORANGE);//Color de las etiquetas
        plot.setBackgroundPaint(Color.WHITE); //Color de el fondo del grafico 
        
                                        jbVolver = new JButton("Atrás");
        jbVolver.setBounds(100, 425, 150, 30);
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
        Graficas g = new Graficas(pc); // mostrar la ventana del menu principal       
    }
    
}
