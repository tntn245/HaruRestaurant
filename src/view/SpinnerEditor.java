/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author My PC
 */
public class SpinnerEditor extends DefaultCellEditor {
    private JSpinner spinner;

    public SpinnerEditor(int minval){
        super( new JTextField() );
        spinner = new JSpinner(new SpinnerNumberModel(minval, minval, 100, 1));
        spinner.setBorder( null );
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        spinner.setValue( value );
        return spinner;
    }

    public Object getCellEditorValue()
    {
        return spinner.getValue();
    }
}