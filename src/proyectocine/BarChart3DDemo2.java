/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jerso
 */
public class BarChart3DDemo2 extends JFrame{
    
      JFreeChart chart;
  ProyectoCine pc;
  JButton jbVolver;
  
      public BarChart3DDemo2(ProyectoCine obj) {
        super("Demo de BarChart2");
        pc = obj;
        setSize(800, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 380);
        add(panel);

        setVisible(true);
    }
      
       public void crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(pc.contadorvalorpel, "VS", "Peliculas");
        dataset.setValue(pc.contadorvalorprod, "VS", "Productos");
    
     

        chart = ChartFactory.createBarChart3D(
                "Gráfica de Productos vs Peliculas", //Nombre de la grafica
                "Productos vs Peliculas", //Nombre del eje Horizontal
                "Cantidad vendida", //Nombre del eje vertical
                dataset, //Data
                PlotOrientation.VERTICAL, //Orientacion HORIZONTAL o VERTICAL
                true, //Incluir leyenda
                true, //Informacion al pasar el mouse
                true);                      //URls

        chart.setBackgroundPaint(Color.GRAY);//Dar color al fondo del panel
        chart.getTitle().setPaint(Color.WHITE);//Dar color al titulo 
            	    	    
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);//Color del fondo del gr�fico

        plot.setDomainGridlinesVisible(true);//Lineas divisorias
        plot.setRangeGridlinePaint(Color.BLACK);//Color de lineas divisorias	    

        //Calculo de los valores en el eje x
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);//Asignar color de linea a las barras

        //Dar color a las barras
        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

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
