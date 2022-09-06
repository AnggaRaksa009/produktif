/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formStaff;

import FormLoginRegister.LoginMain;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;
//import intface.olah_staff;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.String.format;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.AbstractBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import koneksi.koneksi;

/**
 * *
 ****
 **
 * @author B3
 */
public class EditProfile extends javax.swing.JFrame {

//    private AbstractBorder circleBorder = new CircleBorder(); 
    private final AbstractBorder circleBorder = new CircleBorder();
    static boolean maximized = true;
    int xMouse;
    int yMouse;

    File f = null;
    String path = null;
    private ImageIcon format = null;
    String fname = null;
    int s = 0;
    byte[] pimage = null;

    Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    BufferedImage bufferedImage = null;
    byte[] person_image;
    private BufferedImage image;
//    public ArrayList<koneksi> userList(){
//        ArrayList<koneksi> userList = new ArrayList<>();
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/mbaknis", "root", "");
//            java.sql.Statement state = conn.createStatement();
//            String query1 = "Select * from staff";
//            Statement st = (Statement) conn.createStatement();
//            pst = (PreparedStatement) st.executeQuery(query1);
//        } catch (Exception e) {
//        }
//        return null;
//        
//    }

    public EditProfile() {
        initComponents();
        this.person_image = null;
        imgX.setBorder(circleBorder);
        imgX.setForeground(new Color(0, 0, 0, 0));
        imgX.setBackground(new Color(0, 0, 0, 0));
//        txt_ID.disable();
//        Table();
    }

    public void LoadImage() {
        try {
            byte[] imagedata = rs.getBytes("Image");
            format = new ImageIcon(imagedata);
            Image mm = format.getImage();
            Image img2 = mm.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img2);

            imgX.setIcon(image);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgX = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        txt_nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_Reset = new javax.swing.JButton();
        txt_no_hp = new javax.swing.JTextField();
        txt_location = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        txt_ID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgX.setBackground(new java.awt.Color(0, 0, 0));
        imgX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(imgX, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 170, 190));

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setText("Ambil Gambar");
        b1.setBorder(null);
        b1.setFocusPainted(false);
        b1.setFocusable(false);
        b1.setRequestFocusEnabled(false);
        b1.setVerifyInputWhenFocusTarget(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 210, 30));

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 250, -1));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane1.setViewportView(txt_alamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 250, 50));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - laki", "perempuan" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 250, -1));

        btn_Reset.setText("Reset");
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 110, 30));
        getContentPane().add(txt_no_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 250, -1));

        txt_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_locationActionPerformed(evt);
            }
        });
        getContentPane().add(txt_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 210, 30));

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 110, 30));

        txt_ID.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                txt_IDComponentRemoved(evt);
            }
        });
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });
        txt_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_IDKeyReleased(evt);
            }
        });
        getContentPane().add(txt_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 250, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageForm/StaffEditProfil.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(1050, 560));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        chooser.addChoosableFileFilter(fnef);
        int load = chooser.showOpenDialog(null);

        if (load == chooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();

            path = f.getAbsolutePath();
            txt_location.setText(path);
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imgX.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        // TODO add your handling code here:
        imgX.setIcon(null);
        txt_ID.setText(null);
        txt_nama.setText(null);
        txt_alamat.setText(null);
        txt_no_hp.setText(null);
        txt_location.setText(null);

    }//GEN-LAST:event_btn_ResetActionPerformed

    private void txt_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_locationActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_locationActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:       
        System.out.print("Image Path - = " + path);
//        System.out.print("Image Name - = "+f.getName());
        try {

            InputStream is = new FileInputStream(f);
            pst = conn.prepareStatement(" UPDATE staff SET nama_staff =? ,jk =? , alamat =?, no_hp =? ,Image_Path=? , Image=?  WHERE kode_staff = " + txt_ID.getText());
            pst.setString(1, txt_nama.getText());
            pst.setString(2, (String) jComboBox1.getSelectedItem());
            pst.setString(3, txt_alamat.getText());
            pst.setString(4, txt_no_hp.getText());
            pst.setString(5, path);
            pst.setBlob(6, is);

            int inserted = pst.executeUpdate();
            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Data Successfully Inserted");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Table();
//        addTableHeader();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void txt_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IDKeyReleased
//        // TODO add your handling code here:

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mbaknis", "root", "");
            java.sql.Statement state = conn.createStatement();
            String sql = "select nama_staff,jk ,no_hp, alamat ,Image_path ,Image from staff where kode_staff = " + txt_ID.getText();

            rs = state.executeQuery(sql);
            if (sql != txt_ID.getText()) {
                txt_nama.setText(null);
                txt_no_hp.setText(null);
                txt_alamat.setText(null);

                txt_location.setText(null);
                imgX.setIcon(null);
            }

            while (rs.next()) {
                txt_nama.setText(rs.getString(1));
                jComboBox1.setSelectedItem(rs.getString(2));
                txt_no_hp.setText(rs.getString(3));
                txt_alamat.setText(rs.getString(4));

                txt_location.setText(rs.getString(5));

            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(imgX, "dek dek");
        }
//test
        String imgID = txt_ID.getText();
        try {
            pst = conn.prepareStatement("SELECT Image FROM staff WHERE kode_staff=?");
            pst.setString(1, imgID);
            rs = pst.executeQuery();

            if (rs.next()) {
                LoadImage();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txt_IDKeyReleased

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void txt_IDComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txt_IDComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDComponentRemoved

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel imgX;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_location;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_no_hp;
    // End of variables declaration//GEN-END:variables

}
