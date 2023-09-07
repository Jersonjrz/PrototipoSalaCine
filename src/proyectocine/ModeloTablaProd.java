/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocine;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jerso
 */
public class ModeloTablaProd extends DefaultTableModel{
    
        public ModeloTablaProd(Object datos[][], Object encazados[]){
         super(datos, encazados);
    }
    
     public boolean isCellEditable(int row, int column){
        //return true;
        return false;
    }
    
    
}
