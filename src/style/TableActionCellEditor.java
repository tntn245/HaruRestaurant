/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package style;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author My PC
 */
public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;
    private Color color1;
    private Color color2;
    private boolean flag_edit;
    private boolean flag_delete;
    private String edit_img = "";
    private String delete_img = "";

    private boolean flag_Date = true;
    private int col = 3;
    
    public TableActionCellEditor(TableActionEvent event, Color color1, Color color2, boolean edit, boolean delete) {
        super(new JCheckBox());
        this.event = event;
        this.color1= color1;
        this.color2= color2;
        this.flag_edit = edit;
        this.flag_delete = delete;
    }
        
    public TableActionCellEditor(TableActionEvent event, Color color1, Color color2, boolean edit, boolean delete, String edit_img, String delete_img){
        super(new JCheckBox());
        this.event = event;
        this.color1= color1;
        this.color2= color2;
        this.flag_edit = edit;
        this.flag_delete = delete;
        this.edit_img = edit_img;
        this.delete_img = delete_img;
    }
    
    public TableActionCellEditor(TableActionEvent event, Color color1, Color color2, boolean edit, boolean delete, boolean Kho, int col) {
        super(new JCheckBox());
        this.event = event;
        this.color1= color1;
        this.color2= color2;
        this.flag_edit = edit;
        this.flag_delete = delete;
        this.flag_Date = Kho;
        this.col = col;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action;
        if(edit_img.equals(""))
            action = new PanelAction(flag_edit, flag_delete);
        else
            action = new PanelAction(flag_edit, flag_delete, edit_img, delete_img);
        
        action.initEvent(event, row);
        if (row % 2 == 0) {
            action.setBackground(color1);
        } else {
            action.setBackground(color2);
        }
        if (!flag_Date) {
            String NgNhap = jtable.getValueAt(row, col).toString();

            Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);

            if(!(today.equals(NgNhap))){
                action.cmdDelete.setVisible(false);
                action.cmdEdit.setVisible(false);
            }
        }
        return action;
    }
}
