/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import KomponenGUI.FDateF;
import LSubProces.DRunSelctOne;
import LSubProces.Delete;
import LSubProces.FLaporan;
import LSubProces.History;
import LSubProces.MultiInsert;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author richky
 */
public class Absen extends javax.swing.JFrame {

    /**
     * Creates new form Absen
     */
    public Absen() {
        initComponents();
        setTitle("Absensi Pegawai");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        load();
        hitungTotalHadir();
    }

    Boolean isFirstSaturday(String year, String month) {
        Calendar cacheCalendar = Calendar.getInstance();
        cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cacheCalendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        cacheCalendar.set(Calendar.YEAR, Integer.parseInt(year));
        String date = FDateF.datetostr(cacheCalendar.getTime(), "dd-MM-yyyy");
        return date.equals(FDateF.datetostr(new Date(), "dd-MM-yyyy"));
    }

    void load() {
        JTable.useboolean(true);
        JTable.setbooleanfield(2);
        JTable.setbooleanfield2(3);
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal check absen");
        dRunSelctOne.setQuery("SELECT COUNT(`Tanggal`) FROM `tbabsen` WHERE `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        Calendar cal = Calendar.getInstance();
        cal.setTime(JDTanggal.getDate());
        if (!list.get(0).equals("0")) {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                JTable.setQuery("SELECT `IdKaryawan`, `NamaKaryawan`, IFNULL(`Hadir`,0) as 'Hadir', IFNULL(`Setengah Hari`,0) as 'Setengah Hari', IFNULL(y.`Keterangan`,'') as 'Keterangan' FROM `tbmkaryawan`x LEFT JOIN (SELECT b.`IdKaryawan` as 'ID', `NamaKaryawan` as 'Nama Karyawan', `Hadir`, `SetengahHari` as 'Setengah Hari', a.`Keterangan` FROM `tbabsen`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` JOIN `tbsmjeniskaryawan`c ON b.`IdJenisKaryawan`=c.`IdJenisKaryawan` WHERE 1 AND `Status` = 1 AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY `NamaKaryawan`)y ON x.`IdKaryawan`=y.`ID` WHERE x.`IdJenisKaryawan` = 1 AND x.`Status` = 1 ORDER BY x.`IdJenisKaryawan`, x.`NamaKaryawan`");
                JLTitle.setText("DATA ABSEN TANGGAL " + FDateF.datetostr(JDTanggal.getDate(), "dd-MM-yyyy") + " (HARI MINGGU)");
            } else {
                JTable.setQuery("SELECT `IdKaryawan`, `NamaKaryawan`, IFNULL(`Hadir`,0) as 'Hadir', IFNULL(`Setengah Hari`,0) as 'Setengah Hari', IFNULL(y.`Keterangan`,'') as 'Keterangan' FROM `tbmkaryawan`x LEFT JOIN (SELECT b.`IdKaryawan` as 'ID', `NamaKaryawan` as 'Nama Karyawan', `Hadir`, `SetengahHari` as 'Setengah Hari', a.`Keterangan` FROM `tbabsen`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` JOIN `tbsmjeniskaryawan`c ON b.`IdJenisKaryawan`=c.`IdJenisKaryawan` WHERE 1 AND `Status` = 1 AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY `NamaKaryawan`)y ON x.`IdKaryawan`=y.`ID` WHERE x.`Status` = 1 ORDER BY x.`IdJenisKaryawan`, x.`NamaKaryawan`");
                JLTitle.setText("DATA ABSEN TANGGAL " + FDateF.datetostr(JDTanggal.getDate(), "dd-MM-yyyy"));
            }
        } else {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                JTable.setQuery("SELECT `IdKaryawan` as 'ID', `NamaKaryawan` as 'Nama Karyawan', 1 as 'Hadir', 0 as 'Setengah Hari', '' as 'Keterangan' FROM `tbmkaryawan`a JOIN `tbsmjeniskaryawan`b ON a.`IdJenisKaryawan`=b.`IdJenisKaryawan` WHERE a.`IdJenisKaryawan` = 1 AND `Status` = 1 ORDER BY a.`IdJenisKaryawan`, `NamaKaryawan` ");
                JLTitle.setText("TAMBAH BARU DATA ABSEN KARYAWAN (HARI MINGGU)");
            } else {

                JTable.setQuery("SELECT `IdKaryawan` as 'ID', `NamaKaryawan` as 'Nama Karyawan', 1 as 'Hadir', 0 as 'Setengah Hari', '' as 'Keterangan' FROM `tbmkaryawan`a JOIN `tbsmjeniskaryawan`b ON a.`IdJenisKaryawan`=b.`IdJenisKaryawan` WHERE 1 AND `Status` = 1 ORDER BY a.`IdJenisKaryawan`, `NamaKaryawan` ");
                JLTitle.setText("TAMBAH BARU DATA ABSEN KARYAWAN");
            }
        }
        JTable.tampilkan();
    }

    void hitungTotalHadir() {
        int total = 0;
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (JTable.getValueAt(i, 2).equals(true)) {
                total++;
            }
        }
        jtextF1.setText(String.valueOf(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jlableF2 = new KomponenGUI.JlableF();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF5 = new KomponenGUI.JlableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jtextF1 = new KomponenGUI.JtextF();
        jlableF1 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        JLTitle = new KomponenGUI.JlableF();
        jbuttonF4 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Karyawan", "Jenis Karyawan", "Hadir", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.setColumnSelectionAllowed(true);
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);
        JTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
            JTable.getColumnModel().getColumn(1).setMinWidth(200);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            JTable.getColumnModel().getColumn(1).setMaxWidth(200);
            JTable.getColumnModel().getColumn(2).setMinWidth(50);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(2).setMaxWidth(50);
            JTable.getColumnModel().getColumn(3).setMinWidth(50);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jlableF2.setText("Tanggal");

        JDTanggal.setDate(new Date());
        JDTanggal.setDateFormatString("dd-MM-yyyy");
        JDTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggalPropertyChange(evt);
            }
        });

        jlableF5.setText(":");

        jbuttonF1.setText("Simpan");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Kembali");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF3.setText("Simpan & Tutup");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jtextF1.setText("00");
        jtextF1.setEnabled(false);

        jlableF1.setText("Total Hadir");

        jlableF3.setText(":");

        JLTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitle.setText("TAMBAH DATA ABSEN BARU");
        JLTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jbuttonF4.setText("Print Form Absensi");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jtextF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        tambahData(false);
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        tambahData(true);
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.absen = null;
    }//GEN-LAST:event_formWindowClosed

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange
        load();
        hitungTotalHadir();
    }//GEN-LAST:event_JDTanggalPropertyChange

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked

    }//GEN-LAST:event_JTableMouseClicked

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        HashMap hashs = new HashMap();
        FLaporan fLaporan = new FLaporan();
        hashs.put("Title", "FORM ABSENSI KARYAWAN BORONGAN");
        fLaporan.sethashmap(hashs);
        fLaporan.setfilename("FormAbsensi");
        fLaporan.setErorm("Gagal Menampilkan " + this.getTitle());
        fLaporan.excute();
        History.simpanhistory(GlobalVar.VarL.username, "Print Form Absensi Karyawan Borongan");
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void JTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseReleased
        hitungTotalHadir();
        if (JTable.getSelectedRow() != -1 && JTable.getValueAt(JTable.getSelectedRow(), 2).equals(false) && JTable.getValueAt(JTable.getSelectedRow(), 3).equals(true)) {
            JTable.setValueAt(true, JTable.getSelectedRow(), 2);
        }
    }//GEN-LAST:event_JTableMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Absen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JlableF JLTitle;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JtextF jtextF1;
    // End of variables declaration//GEN-END:variables

    void tambahData(Boolean tutup) {
        boolean Berhasil;
        MultiInsert multiInsert = new MultiInsert();
        Berhasil = multiInsert.OpenConnection();
        if (Berhasil) {
            Berhasil = multiInsert.setautocomit(false);
            if (Berhasil) {
                DRunSelctOne dRunSelctOne = new DRunSelctOne();
                dRunSelctOne.seterorm("Gagal check absen");
                dRunSelctOne.setQuery("SELECT COUNT(`Tanggal`) FROM `tbabsen` WHERE `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
                ArrayList<String> list = dRunSelctOne.excute();
                if (!list.get(0).equals("0")) {
                    Berhasil = multiInsert.Excute("DELETE FROM `tbabsen` WHERE `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'", null);
                }
                if (Berhasil) {
                    String query = "INSERT INTO `tbabsen`(`Tanggal`, `IdKaryawan`, `Hadir`, `SetengahHari`, `Keterangan`) VALUES ";
                    for (int i = 0; i < JTable.getRowCount(); i++) {
                        if (i == 0) {
                            query += "('" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "')," + JTable.getValueAt(i, 2) + "," + JTable.getValueAt(i, 3) + ",'" + JTable.getValueAt(i, 4) + "')";
                        } else {
                            query += ",('" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "')," + JTable.getValueAt(i, 2) + "," + JTable.getValueAt(i, 3) + ",'" + JTable.getValueAt(i, 4) + "')";
                        }
                    }
                    Berhasil = multiInsert.Excute(query, null);
                }
            }
        }
        if (Berhasil == false) {
            multiInsert.rollback();
            multiInsert.closecon();
            JOptionPane.showMessageDialog(this, "Gagal Tambah Data Absen");
        }
        if (Berhasil == true) {
            JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Absen");
            multiInsert.Commit();
            multiInsert.closecon();
            if (tutup) {
                dispose();
            } else {
                load();
            }
        }
    }

}
