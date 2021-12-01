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
import javax.swing.JTextField;

/**
 * This class concentrates responsibilities to manage actions related with 
 * TextFields of Forms.
 */
public class ManageFields {
    
    private List<JTextField> fields;
    
    /**
    * Set the fields array. The attribute 'fields' of class receives
    * the list of fields to be managed.
    *
    * @param newFields the new list of fields. 
    */
    public void setFields(List<JTextField> newFields){
        this.fields = newFields;
    }
    
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
}
