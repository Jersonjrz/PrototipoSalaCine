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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jerso
 */
public class PieChart3DDemo extends JFrame{
    
    JFreeChart chart;
    ProyectoCine pc;
    JButton jbVolver;
    
    public PieChart3DDemo(ProyectoCine obj) {
        super("Grafica Genero");
        pc = obj;
        setSize(800, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 400);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {        
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Femenino", pc.contadormujeres);
        data.setValue("Masculino", pc.contadorhombres);
        data.setValue("Otro", pc.contadorotro);


        chart = ChartFactory.createPieChart3D(
                "Gráfica de Genero", // chart title
                data, // data
                true, // include legend
                true,
                false
        );

        chart.setBackgroundPaint(Color.ORANGE);//Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); //Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);//Color de las etiquetas
        plot.setForegroundAlpha(0.60f);//Color de el fondo del grafico
                
        //esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
        
                        jbVolver = new JButton("Atrás");
        jbVolver.setBounds(150, 425, 150, 30);
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
