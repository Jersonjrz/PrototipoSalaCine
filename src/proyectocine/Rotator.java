/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.chart.plot.PiePlot3D;

/**
 *
 * @author jerso
 */
public class Rotator extends Timer implements ActionListener{

	/** The plot. */
	private PiePlot3D plot;
	
	/** The angle. */
	private int angle = 270;
	
	/**
	* Constructor.
	*
	* @param plot  the plot.
	*/
	Rotator(final PiePlot3D plot) {
		super(100, null);
		this.plot = plot;
		addActionListener(this);
	}
	
	/**
	* Modifies the starting angle.
	*
	* @param event  the action event.
	*/
	public void actionPerformed(final ActionEvent event) {
		this.plot.setStartAngle(this.angle);
		this.angle = this.angle + 1;
		if (this.angle == 360) {
			this.angle = 0;
		}
	}
    
}
