/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import LSubProces.Delete;
import Proses.Penyesuaian;
import static java.awt.Frame.NORMAL;
import javax.swing.JOptionPane;

/**
 *
 * @author riki
 */
public class ListPenyesuaianLain extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ListPenyesuaianLain() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("List Penyesuaian Stok Barang Lain");
        setVisible(true);
        refresh();
        if (!GlobalVar.VarL.level.equals("Administrator")) {
            BtnHapusBarang.setVisible(false);
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

        jcomCariBarang = new KomponenGUI.JcomCari();
        BtnRefreshBarang = new KomponenGUI.JbuttonF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        BtnHapusBarang = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BtnRefreshBarang.setText("Refresh");
        BtnRefreshBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshBarangActionPerformed(evt);
            }
        });

        jbuttonF1.setText("Kembali");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        BtnHapusBarang.setText("Hapus");
        BtnHapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRefreshBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnHapusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jcomCariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcomCariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnHapusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRefreshBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRefreshBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshBarangActionPerformed
        refresh();
    }//GEN-LAST:event_BtnRefreshBarangActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GlobalVar.Var.listPenyesuaianLain = null;
    }//GEN-LAST:event_formWindowClosing

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        GlobalVar.Var.listPenyesuaianLain.dispose();
        GlobalVar.Var.listPenyesuaianLain = null;
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void BtnHapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusBarangActionPerformed
        delete();
    }//GEN-LAST:event_BtnHapusBarangActionPerformed

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
            java.util.logging.Logger.getLogger(ListPenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPenyesuaianLain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF BtnHapusBarang;
    private KomponenGUI.JbuttonF BtnRefreshBarang;
    private KomponenGUI.JbuttonF jbuttonF1;
    public KomponenGUI.JcomCari jcomCariBarang;
    // End of variables declaration//GEN-END:variables

    void delete() {
        if (jcomCariBarang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Delete delete = new LSubProces.Delete();
            if (delete.Hapus(jcomCariBarang.GetIDTable(), "DELETE FROM `tbpenyesuaianlain` WHERE `IdPenyesuaian` = " + jcomCariBarang.GetIDTable(), "Penyesuaian Barang Lain", this)) {
                refresh();
            }
        }
    }

    public void refresh() {
        jcomCariBarang.setQuery("SELECT `IdPenyesuaian` as 'ID', `NoPenyesuaian` as 'No. Penyesuaian', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarangLain` as 'Nama Barang', `Jumlah`, a.`Keterangan` FROM `tbpenyesuaianlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` WHERE 1");
        jcomCariBarang.setRender(new int[]{4}, new String[]{"Decimal"});
        jcomCariBarang.tampilkan();
    }

}
