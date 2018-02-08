package Master;

import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.Update;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

/**
 *
 * @author Martono
 */
public class MasterKendaraan extends javax.swing.JFrame {

    String idEdit;

    /**
     * Creates new form MasterPemasok
     */
    public MasterKendaraan(Object id) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        if (idEdit.equals("0")) {
            setTitle("Tambah Kendaraan");
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Kendaraan");
            loadData();
            JBTambah.setVisible(false);
            JBTambahTutup.setVisible(false);
        }
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLPlatKendaraan = new KomponenGUI.JlableF();
        JLPlatKendaraan2 = new KomponenGUI.JlableF();
        JTPlatKendaraan = new KomponenGUI.JtextF();
        JLJenisKendaraan = new KomponenGUI.JlableF();
        JLJenisKendaraan2 = new KomponenGUI.JlableF();
        JTJenisKendaraan = new KomponenGUI.JtextF();
        JLKeterangan = new KomponenGUI.JlableF();
        JLKeterangan2 = new KomponenGUI.JlableF();
        JSPKeterangan = new javax.swing.JScrollPane();
        JTKeterangan = new KomponenGUI.JTextAreaF();
        JBKembali = new KomponenGUI.JbuttonF();
        JBTambah = new KomponenGUI.JbuttonF();
        JBTambahTutup = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JLPlatKendaraan.setText("Plat Kendaraan");

        JLPlatKendaraan2.setText(":");

        JTPlatKendaraan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPlatKendaraanKeyReleased(evt);
            }
        });
        JTPlatKendaraan.setMaxText(12);

        JLJenisKendaraan.setText("Jenis Kendaraan");

        JLJenisKendaraan2.setText(":");

        JTJenisKendaraan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTJenisKendaraanKeyReleased(evt);
            }
        });
        JTJenisKendaraan.setMaxText(50);

        JLKeterangan.setText("Keterangan");

        JLKeterangan2.setText(":");

        JTKeterangan.setColumns(20);
        JTKeterangan.setLineWrap(true);
        JTKeterangan.setRows(5);
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
        });
        JSPKeterangan.setViewportView(JTKeterangan);

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBTambah.setText("Tambah");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
            }
        });

        JBTambahTutup.setText("Tambah & Tutup");
        JBTambahTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahTutupActionPerformed(evt);
            }
        });

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLJenisKendaraan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLPlatKendaraan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLPlatKendaraan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTPlatKendaraan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSPKeterangan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLJenisKendaraan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTJenisKendaraan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPlatKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLPlatKendaraan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPlatKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJenisKendaraan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JSPKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        tambah(true);
    }//GEN-LAST:event_JBTambahTutupActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambah(false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubah();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JTPlatKendaraanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPlatKendaraanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJenisKendaraan.requestFocus();
        }
    }//GEN-LAST:event_JTPlatKendaraanKeyReleased

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JBTambah.isVisible()) {
                tambah(false);
            } else {
                ubah();
            }
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahKendaraan = null;
        } else {
            GlobalVar.Var.ubahKendaraan = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JTJenisKendaraanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisKendaraanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTJenisKendaraanKeyReleased

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
            java.util.logging.Logger.getLogger(MasterKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterKendaraan("0");
            }
        });
    }

    boolean checkInput() {
        if (JTPlatKendaraan.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plat Kendaraan Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JTPlatKendaraan.requestFocus();
            return false;
        } else if (JTJenisKendaraan.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jenis Kendaraan Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JTJenisKendaraan.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    void tambah(boolean tutup) {
        if (checkInput()) {
            Insert insert = new LSubProces.Insert();
            boolean simpan = insert.simpan("INSERT INTO `tbmkendaraan`(`Plat`, `JenisKendaraan`, `Keterangan`) VALUES ('" + JTPlatKendaraan.getText() + "', '" + JTJenisKendaraan.getText() + "', '" + JTKeterangan.getText() + "')", "Master Kendaraan", this);
            if (simpan) {
                if (GlobalVar.Var.listKendaraan != null) {
                    GlobalVar.Var.listKendaraan.load();
                }
                if (GlobalVar.Var.tambahPenerimaan != null) {
                    GlobalVar.Var.tambahPenerimaan.JCPlat.load("SELECT `Plat` FROM `tbmkendaraan`");
                    GlobalVar.Var.tambahPenerimaan.JCPlat.setSelectedItem(JTPlatKendaraan.getText());
                    GlobalVar.Var.tambahPenerimaan.JCPlat.requestFocus();
                }
                if (GlobalVar.Var.ubahPenerimaan != null) {
                    GlobalVar.Var.ubahPenerimaan.JCPlat.load("SELECT `Plat` FROM `tbmkendaraan`");
                    GlobalVar.Var.ubahPenerimaan.JCPlat.setSelectedItem(JTPlatKendaraan.getText());
                    GlobalVar.Var.ubahPenerimaan.JCPlat.requestFocus();
                }
                if (tutup) {
                    dispose();
                } else {
                    clearText();
                    JTPlatKendaraan.requestFocus();
                }
            }
        }
    }

    void clearText() {
        JTPlatKendaraan.setText("");
        JTJenisKendaraan.setText("");
        JTKeterangan.setText("");
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Menampilkan Data Master Kendaraan");
        dRunSelctOne.setQuery("SELECT `IdKendaraan`, `Plat`, `JenisKendaraan`, `Keterangan` FROM `tbmkendaraan` WHERE `IdKendaraan`='" + idEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTPlatKendaraan.setText(list.get(1));
        JTJenisKendaraan.setText(list.get(2));
        JTKeterangan.setText(list.get(3));
    }

    void ubah() {
        if (checkInput()) {
            Update update = new LSubProces.Update();
            boolean ubah = update.Ubah("UPDATE `tbmkendaraan` SET `Plat`='" + JTPlatKendaraan.getText() + "', `JenisKendaraan`='" + JTJenisKendaraan.getText() + "', `Keterangan`='" + JTKeterangan.getText() + "' WHERE `IdJenisBarang`=" + idEdit, "Master Kendaraan", this);
            if (ubah) {
                dispose();
                GlobalVar.Var.listKendaraan.load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JlableF JLJenisKendaraan;
    private KomponenGUI.JlableF JLJenisKendaraan2;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLPlatKendaraan;
    private KomponenGUI.JlableF JLPlatKendaraan2;
    private javax.swing.JScrollPane JSPKeterangan;
    private KomponenGUI.JtextF JTJenisKendaraan;
    private KomponenGUI.JTextAreaF JTKeterangan;
    private KomponenGUI.JtextF JTPlatKendaraan;
    // End of variables declaration//GEN-END:variables
}