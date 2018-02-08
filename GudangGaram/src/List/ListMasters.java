/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import LSubProces.Delete;
import Master.*;
import javax.swing.JOptionPane;

/**
 *
 * @author richky
 */
public class ListMasters extends javax.swing.JFrame {

    /**
     * Creates new form ListKaryawan
     */
    String Title;

    public ListMasters(String title) {
        Title = title;
        initComponents();
        setVisible(true);
        setTitle("List Master " + Title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jcomCari1 = new KomponenGUI.JcomCari();
        jbuttonF5 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jbuttonF1.setText("Ubah");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Hapus");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF3.setText("Refresh");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jbuttonF4.setText("Kembali");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        jbuttonF5.setText("Tambah");
        jbuttonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        ubah();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        hapus();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        refresh();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void jbuttonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF5ActionPerformed
        tambah();
    }//GEN-LAST:event_jbuttonF5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        switch (Title) {
            case "Gudang":
                GlobalVar.Var.listGudang = null;
                break;
            case "Pemasok":
                GlobalVar.Var.listPemasok = null;
                break;
            case "Peminta":
                GlobalVar.Var.listPeminta = null;
                break;
            case "Penerima":
                GlobalVar.Var.listPenerima = null;
                break;
            case "Jenis Karyawan":
                GlobalVar.Var.listJenisKaryawan = null;
                break;
            case "Jenis Barang":
                GlobalVar.Var.listJenisBarang = null;
                break;
            case "Jenis Penjualan":
                GlobalVar.Var.listJenisPenjualan = null;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ListMasters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMasters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMasters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMasters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMasters("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF5;
    private KomponenGUI.JcomCari jcomCari1;
    // End of variables declaration//GEN-END:variables

    void tambah() {
        switch (Title) {
            case "Gudang":
                if (GlobalVar.Var.tambahGudang == null) {
                    GlobalVar.Var.tambahGudang = new Masters("0", "Gudang");
                }
                break;
            case "Pemasok":
                if (GlobalVar.Var.tambahPemasok == null) {
                    GlobalVar.Var.tambahPemasok = new Masters("0", "Pemasok");
                }
                break;
            case "Peminta":
                if (GlobalVar.Var.tambahPeminta == null) {
                    GlobalVar.Var.tambahPeminta = new Masters("0", "Peminta");
                }
                break;
            case "Penerima":
                if (GlobalVar.Var.tambahPenerima == null) {
                    GlobalVar.Var.tambahPenerima = new Masters("0", "Penerima");
                }
                break;
            case "Jenis Karyawan":
                if (GlobalVar.Var.tambahJenisKaryawan == null) {
                    GlobalVar.Var.tambahJenisKaryawan = new Masters("0", "Jenis Karyawan");
                }
                break;
            case "Jenis Barang":
                if (GlobalVar.Var.tambahJenisBarang == null) {
                    GlobalVar.Var.tambahJenisBarang = new Masters("0", "Jenis Barang");
                }
                break;
            case "Jenis Penjualan":
                if (GlobalVar.Var.tambahJenisPenjualan == null) {
                    GlobalVar.Var.tambahJenisPenjualan = new Masters("0", "Jenis Penjualan");
                }
                break;
            default:
                break;
        }
    }

    void hapus() {
        if (jcomCari1.getSelectedRow() != -1) {
            Delete delete = new Delete();
            boolean berhasil = false;
            switch (Title) {
                case "Gudang":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbmgudang` WHERE `IdGudang` = " + jcomCari1.GetIDTable(), "Gudang", this);
                    break;
                case "Pemasok":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbmpemasok` WHERE `IdPemasok` = " + jcomCari1.GetIDTable(), "Pemasok", this);
                    break;
                case "Peminta":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbmpeminta` WHERE `IdPeminta` = " + jcomCari1.GetIDTable(), "Peminta", this);
                    break;
                case "Penerima":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbmpenerima` WHERE `IdPenerima` = " + jcomCari1.GetIDTable(), "Penerima", this);
                    break;
                case "Jenis Karyawan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbsmjeniskaryawan` WHERE `IdJenisKaryawan` = " + jcomCari1.GetIDTable(), "Jenis Karyawan", this);
                    break;
                case "Jenis Barang":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbsmjenisbarang` WHERE `IdJenisBarang` = " + jcomCari1.GetIDTable(), "Jenis Barang", this);
                    break;
                case "Jenis Penjualan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `tbsmjenispenjualan` WHERE `IdJenisPenjualan` = " + jcomCari1.GetIDTable(), "Jenis Penjualan", this);
                    break;
                default:
                    break;
            }
            if (berhasil) {
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu");
        }
    }

    void ubah() {
        if (jcomCari1.getSelectedRow() != -1) {
            switch (Title) {
                case "Gudang":
                    if (GlobalVar.Var.ubahGudang == null) {
                        GlobalVar.Var.ubahGudang = new Masters(jcomCari1.GetIDTable(), "Gudang");
                    }
                    break;
                case "Pemasok":
                    if (GlobalVar.Var.ubahPemasok == null) {
                        GlobalVar.Var.ubahPemasok = new Masters(jcomCari1.GetIDTable(), "Pemasok");
                    }
                    break;
                case "Peminta":
                    if (GlobalVar.Var.ubahPeminta == null) {
                        GlobalVar.Var.ubahPeminta = new Masters(jcomCari1.GetIDTable(), "Peminta");
                    }
                    break;
                case "Penerima":
                    if (GlobalVar.Var.ubahPenerima == null) {
                        GlobalVar.Var.ubahPenerima = new Masters(jcomCari1.GetIDTable(), "Penerima");
                    }
                    break;
                case "Jenis Karyawan":
                    if (GlobalVar.Var.ubahJenisKaryawan == null) {
                        GlobalVar.Var.ubahJenisKaryawan = new Masters(jcomCari1.GetIDTable(), "Jenis Karyawan");
                    }
                    break;
                case "Jenis Barang":
                    if (GlobalVar.Var.ubahJenisBarang == null) {
                        GlobalVar.Var.ubahJenisBarang = new Masters(jcomCari1.GetIDTable(), "Jenis Barang");
                    }
                    break;
                case "Jenis Penjualan":
                    if (GlobalVar.Var.ubahJenisPenjualan == null) {
                        GlobalVar.Var.ubahJenisPenjualan = new Masters(jcomCari1.GetIDTable(), "Jenis Penjualan");
                    }
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu");
        }
    }

    public void refresh() {
        switch (Title) {
            case "Gudang":
                jcomCari1.setQuery("SELECT `IdGudang` as 'ID', `Gudang`, `Keterangan` FROM `tbmgudang` WHERE 1");
                break;
            case "Pemasok":
                jcomCari1.setQuery("SELECT `IdPemasok` as 'ID', `Pemasok`, `Keterangan` FROM `tbmpemasok` WHERE 1");
                break;
            case "Peminta":
                jcomCari1.setQuery("SELECT `IdPeminta` as 'ID', `Peminta`, `Keterangan` FROM `tbmpeminta` WHERE 1");
                break;
            case "Penerima":
                jcomCari1.setQuery("SELECT `IdPenerima` as 'ID', `Penerima`, `Keterangan` FROM `tbmpenerima` WHERE 1");
                break;
            case "Jenis Karyawan":
                jcomCari1.setQuery("SELECT `IdJenisKaryawan` as 'ID', `JenisKaryawan` as 'Jenis', `Keterangan` FROM `tbsmjeniskaryawan` WHERE 1");
                break;
            case "Jenis Barang":
                jcomCari1.setQuery("SELECT `IdJenisBarang` as 'ID', `JenisBarang` as 'Jenis', `Keterangan` FROM `tbsmjenisbarang` WHERE 1");
                break;
            case "Jenis Penjualan":
                jcomCari1.setQuery("SELECT `IdJenisPenjualan` as 'ID', `JenisPenjualan` as 'Jenis', `Keterangan` FROM `tbsmjenispenjualan` WHERE 1");
                break;
            default:
                break;
        }
        jcomCari1.tampilkan();
    }

}
