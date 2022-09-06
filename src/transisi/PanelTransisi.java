/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transisi;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;

/**
 *
 * @author KRISNA
 */
public class PanelTransisi extends javax.swing.JPanel {

    private JLayeredPane body;
    
    public PanelTransisi() {
        initComponents();
        setOpaque(false);
        setLayout(new MigLayout("fill", "0[fill]0", "0[fill]0"));
        body = new JLayeredPane();
        body.setLayout(new CardLayout());
        add(body);
    }
    
    public void display (Component form, Animator animator){
        TransisiForm add = (TransisiForm) form;
        add.addTarget(animator, body);
        if (body.getComponentCount() > 0) {
            TransisiForm remove = (TransisiForm) body.getComponent(0);
            remove.removeTarget();
        } else {
             add.setAlpha(1f);
        }
       
        body.add(form);
        body.repaint();
        body.revalidate();
        body.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
