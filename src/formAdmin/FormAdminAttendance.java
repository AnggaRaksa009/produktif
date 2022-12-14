/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import transisi.TransisiForm;

/**
 *
 * @author KRISNA
 */
public class FormAdminAttendance extends TransisiForm {

    Timer updateTimer;
    int DELAY = 100;

    /**
     * Creates new form Form
     */
    public FormAdminAttendance() {
        initComponents();
        updateTimer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date currentTime = new Date();
                String formatTimerStr = "HH:mm:ss";
                DateFormat formatTime = new SimpleDateFormat(formatTimerStr);
                String formattedTimeStr = formatTime.format(currentTime);
                jLabel2.setText(formattedTimeStr);
            }
        });
        updateTimer.start();
        table();
        table.fixTable(jScrollPane2);
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tahun = new javax.swing.JTextField();
        bulan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new customtable.CustomTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(82, 82, 82));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 100, 30));

        tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tahunKeyReleased(evt);
            }
        });
        add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 150, 30));

        bulan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bulanKeyReleased(evt);
            }
        });
        add(bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 150, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("00:00:00");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 140, 70));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 610, 150));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageForm/AdminAbsensi.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "SELECT staff.`kode_staff`,staff.`nama_staff`,absen.`waktu_absen`\n"
                    + "FROM staff,absen\n"
                    + "WHERE staff.`kode_staff` = absen.`kode_staff`\n"
                    + "HAVING MONTH (waktu_absen) ='" + bulan.getText() + "' OR YEAR (waktu_absen) = '" + tahun.getText() + "'";
            java.sql.Connection konek = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = konek.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            table();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Staff");
            model.addColumn("Nama Staff");
//            model.addColumn("Alamat");
//            model.addColumn("Jenis Kelamin");
            model.addColumn("Waktu");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)
//                    rs.getString(4), rs.getString(5)
                });
                table.setModel(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bulanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bulanKeyReleased
        // TODO add your handling code here:
        try {
            int har = Integer.parseInt(bulan.getText());
        } catch (NumberFormatException ex) {
            bulan.setText(null);
        }
    }//GEN-LAST:event_bulanKeyReleased

    private void tahunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunKeyReleased
        // TODO add your handling code here:
        try {
            int har = Integer.parseInt(tahun.getText());
        } catch (NumberFormatException ex) {
            tahun.setText(null);
        }
    }//GEN-LAST:event_tahunKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bulan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private customtable.CustomTable table;
    private javax.swing.JTextField tahun;
    // End of variables declaration//GEN-END:variables

    private void table() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("JK");
        model.addColumn("Waktu dan tanggal Absen");
        model.addColumn("Kode Absen");

        try {
            String sql = "SELECT staff.`nama_staff`,staff.`alamat`,staff.`jk`,absen.`waktu_absen`,absen.`kode_staff`\n"
                    + "FROM staff,absen\n"
                    + "WHERE staff.`kode_staff` = absen.`kode_staff`;";
            java.sql.Connection konek = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = konek.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                });
                table.setModel(model);
            }
        } catch (SQLException e) {
        }
    }
}
