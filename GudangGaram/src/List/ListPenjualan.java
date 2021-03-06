/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import LSubProces.Delete;
import Proses.Penjualan;
import static java.awt.Frame.NORMAL;
import javax.swing.JOptionPane;

/**
 *
 * @author richky
 */
public class ListPenjualan extends javax.swing.JFrame {

    /**
     * Creates new form ListPenjualan
     */
    public ListPenjualan() {
        initComponents();
        setVisible(true);
        setTitle("List Penjualan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        refreshAll();
        if (!GlobalVar.VarL.level.equals("Administrator")) {
            jbuttonF2.setVisible(false);
        }
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
        jCheckBoxF1 = new KomponenGUI.JCheckBoxF();

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

        jCheckBoxF1.setSelected(false);
        jCheckBoxF1.setText("Tampilkan Detail Penjualan");
        jCheckBoxF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        refreshAll();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.listPenjualan = null;
    }//GEN-LAST:event_formWindowClosed

    private void jCheckBoxF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxF1ActionPerformed
        load();
    }//GEN-LAST:event_jCheckBoxF1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JCheckBoxF jCheckBoxF1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JcomCari jcomCari1;
    // End of variables declaration//GEN-END:variables

    void refreshAll() {
        jcomCari1.refresh();
        load();
    }

    void hapus() {
        if (jcomCari1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Delete delete = new Delete();
            Boolean berhasil = delete.Hapus("ID " + jcomCari1.GetIDTable(), "DELETE FROM `tbpenjualan` WHERE `IdPenjualan` = " + jcomCari1.GetIDTable(), "Penjualan", this);
            if (berhasil) {
                refreshAll();
            }
        }
    }

    void ubah() {
        if (jcomCari1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (GlobalVar.Var.ubahPenjualan == null) {
                GlobalVar.Var.ubahPenjualan = new Penjualan(jcomCari1.getselected11());
            } else {
                GlobalVar.Var.ubahPenjualan.setState(NORMAL);
                GlobalVar.Var.ubahPenjualan.toFront();
            }
        }
    }

    public void load() {
        if (jCheckBoxF1.isSelected()) {
            jcomCari1.setQuery("SELECT `IdPenjualanDetail` as 'ID', a.`NoTransaksi` as 'No. Transaksi', DATE_FORMAT(e.`Tanggal`, '%d-%m-%Y') as 'Tanggal', `NoKolom` as 'No', IF(`StatusRetur`=0 AND `StatusBarcode`=0,IF(a.`IdBarangLain` IS NULL,c.`NamaBarang`,d.`NamaBarangLain`),IF(`StatusRetur`=1 AND `StatusBarcode`=0,CONCAT(IF(a.`IdBarangLain` IS NULL,c.`NamaBarang`,d.`NamaBarangLain`),' (RETUR)'),IF(`StatusRetur`=0 AND `StatusBarcode`=1,CONCAT(IF(a.`IdBarangLain` IS NULL,c.`NamaBarang`,d.`NamaBarangLain`),' (BARCODE)'),CONCAT(IF(a.`IdBarangLain` IS NULL,c.`NamaBarang`,d.`NamaBarangLain`),' (RETUR) (BARCODE)')))) as 'Nama Barang', IF(d.`IdJenisBarangLain`=1,REPLACE(FORMAT(`Jumlah`/25,0),',','.'),REPLACE(FORMAT(`Jumlah`,0),',','.')) as 'Jumlah', REPLACE(IF(c.`Satuan` IS NOT NULL, c.`Satuan`, '-'),'.',',') as 'Berat Satuan', IF(a.`IdBarangLain` IS NULL,REPLACE(FORMAT(`Jumlah`*IF(c.`Satuan` IS NOT NULL, c.`Satuan`, 1)/1000,2),'.',','),'-') as 'Tonase', IF(a.`IdBarangLain` IS NULL,REPLACE(FORMAT(`HargaSatuan`,0),',','.'),'-') as 'Harga', IF(a.`IdBarangLain` IS NULL,REPLACE(FORMAT(`Jumlah`*`HargaSatuan`,0),',','.'),'-') as 'Sub Total' , IF(`StatusRetur`=1,'Ya','Tidak') as 'Retur', IF(`StatusBarcode`=1,'Ya','Tidak') as 'Barcode', IF(`JenisBuruh`=1,'GUDANG GARAM',IF(`JenisBuruh`=2,'PAAL 5','KOPRA')) as 'Jenis Buruh' FROM `tbpenjualandetail`a LEFT JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` LEFT JOIN `tbmbarang`c ON IF(a.`IdPartai` is null,a.`IdBarang`,b.`IdBarang`)=c.`IdBarang` LEFT JOIN `tbmbaranglain`d on a.`IdBarangLain`=d.`IdbarangLain` JOIN `tbpenjualan`e ON a.`NoTransaksi`=e.`NoTransaksi` WHERE 1");
            jcomCari1.setOrder(" ORDER BY e.`Tanggal` DESC, a.`NoTransaksi` DESC, `NoKolom` ASC");
        } else {
            jcomCari1.setQuery("SELECT `IdPenjualan` as 'ID', `NoTransaksi` as 'No Transaksi', IF(`NoDO`='','-',`NoDo`) as 'No DO', DATE_FORMAT(`Tanggal`, '%d-%m-%Y') as 'Tanggal', `JenisPenjualan` as 'Jenis Penjualan', IFNULL(`Plat`,'-') as 'Plat', IFNULL(`JenisKendaraan`,'-') as 'Kendaraan', `NamaSupir` as 'Nama Supir', IFNULL(`Gudang`, IFNULL(`Penerima`, '')) as 'Tujuan', a.`Keterangan` FROM `tbpenjualan`a JOIN `tbsmjenispenjualan`b ON a.`IdJenisPenjualan`=b.`IdJenisPenjualan` LEFT JOIN `tbmkendaraan`c ON a.`IdKendaraan`=c.`IdKendaraan` LEFT JOIN `tbmgudang`d on a.`IdGudang`=d.`IdGudang` LEFT JOIN `tbmpenerima`e ON a.`IdPenerima`=e.`IdPenerima` WHERE 1");
            jcomCari1.setOrder(" ORDER BY a.`Tanggal` DESC, `NoTransaksi` DESC ");
        }
        jcomCari1.tampilkan();
    }

}
