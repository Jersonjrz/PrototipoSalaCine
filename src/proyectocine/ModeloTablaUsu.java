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
public class ModeloTablaUsu extends DefaultTableModel{
    
    public ModeloTablaUsu(Object datos[][], Object encazados[]){
         super(datos, encazados);
    }
    
     public boolean isCellEditable(int row, int column){
        //return true;
        return false;
    }
    
}
