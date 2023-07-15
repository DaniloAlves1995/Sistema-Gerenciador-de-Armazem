/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class concentrates responsibilities to manage actions related with 
 * TextFields of Forms.
 */
public class ManageFields {
    
    private List<JTextField> fields;
    private boolean value;
    
    /**
    * Set the fields array. The attribute 'fields' of class receives
    * the list of fields to be managed.
    *
    * @param newFields the new list of fields. 
    */
    public void setFields(List<JTextField> newFields){
        this.fields = newFields;
    }
    
    /**
    * Set key pressed event. Change background color to white when 
    * user type and color still isn't white. 
    */
    public void setEvent(){
        this.fields.forEach((t) -> {
            t.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (t.getBackground() != Color.WHITE)
                        t.setBackground(Color.WHITE);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    
                }
            });
               
        });
    }
    
    /**
    * Check fields. Check if there are some fields void. Case true, a message
    * is show to user, the void field is setting to red background color.
    * 
    * @return a boolean indicating if there are void fields
    */
    public boolean checkFields(){
        this.value = true;
        this.fields.forEach((t) -> {
            if ((t.getText().trim().equals("") || t.getText().equals("(  )    -    ")) && this.value == true) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "..: WMS :..", JOptionPane.WARNING_MESSAGE);
                t.setBackground(new Color(255, 51, 51));
                t.requestFocus();
                this.value = false;
            }
        });
        
        return this.value;
    }
    
    /**
    * Clear fields. Set text values of all fields to void.
    */
    public void clearFields(){
        this.fields.forEach((t) -> {
            t.setText("");
        });
    }
}
