/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import KomponenGUI.FDateF;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.RunSelct;
import LSubProces.Update;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author richky
 */
public class PenyesuaianLain extends javax.swing.JFrame {

    public String IdPenyesuaian;

    /**
     * Creates new form Penyesuaian
     */
    public PenyesuaianLain() {
        initComponents();
        JTNoPenyesuaian.setText(getNoPenyesuaianLain());
        JCNamaBarang.requestFocus();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Penyesuaian Stok Barang Lain");
        setVisible(true);
        setStok();
    }

    boolean checkInput() {
        if (JCNamaBarang.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Nama Barang Harus Dipilih");
            JCNamaBarang.requestFocus();
            return false;
        } else if ((Float.parseFloat(JTStokBaruKG.getText().replace(".", "") + "." + JTKomaKG.getText()) - Float.parseFloat(JTStokLamaKG.getText().replace(".", "").replace(",", "."))) == 0) {
            JOptionPane.showMessageDialog(this, "Stok Baru (KG) Tidak Boleh Sama Dengan Stok Lama (KG)");
            return false;
        } else if (JDTanggalPenyesuaian.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Tidak Boleh Kosong");
            return false;
        } else {
            return true;
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

        jlableF1 = new KomponenGUI.JlableF();
        jlableF2 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        jlableF4 = new KomponenGUI.JlableF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF13 = new KomponenGUI.JlableF();
        jlableF14 = new KomponenGUI.JlableF();
        JTNoPenyesuaian = new KomponenGUI.JtextF();
        jlableF17 = new KomponenGUI.JlableF();
        jlableF18 = new KomponenGUI.JlableF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JDTanggalPenyesuaian = new KomponenGUI.JdateCF();
        JCNamaBarang = new KomponenGUI.JcomboboxF();
        JTStokLamaKG = new KomponenGUI.JtextF();
        JTStokBaruKG = new KomponenGUI.JRibuanTextField();
        JTKomaKG = new KomponenGUI.JtKoma();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jlableF16 = new KomponenGUI.JlableF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("No. Penyesuaian");

        jlableF2.setText(":");

        jlableF3.setText("Tanggal");

        jlableF4.setText(":");

        jlableF5.setText("Nama Barang");

        jlableF6.setText(":");

        jlableF9.setText("Stok Lama");

        jlableF10.setText(":");

        jlableF13.setText("Stok Baru");

        jlableF14.setText(":");

        JTNoPenyesuaian.setEnabled(false);

        jlableF17.setText("Keterangan");

        jlableF18.setText(":");

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTAKeterangan);

        JDTanggalPenyesuaian.setDate(new Date());
        JDTanggalPenyesuaian.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggalPenyesuaianPropertyChange(evt);
            }
        });

        JCNamaBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Nama Barang --" }));
        JCNamaBarang.load("(SELECT '-- Pilih Nama Barang --' as 'NamaBarangLain') UNION ALL (SELECT `NamaBarangLain` FROM `tbmbaranglain` WHERE 1 GROUP BY `IdBarangLain` ORDER BY `IdBarangLain`)");
        JCNamaBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCNamaBarangItemStateChanged(evt);
            }
        });
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyPressed(evt);
            }
        });

        JTStokLamaKG.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTStokLamaKG.setText("0,00");
        JTStokLamaKG.setEnabled(false);

        JTStokBaruKG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTStokBaruKGKeyPressed(evt);
            }
        });

        JTKomaKG.setText("00");
        JTKomaKG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKomaKGKeyPressed(evt);
            }
        });

        jbuttonF1.setText("SESUAIKAN");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("KEMBALI");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jlableF16.setText(",");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlableF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlableF4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JTNoPenyesuaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JDTanggalPenyesuaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(JTStokBaruKG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(JTKomaKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JTStokLamaKG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoPenyesuaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggalPenyesuaian, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTStokLamaKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTKomaKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTStokBaruKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.tambahPenyesuaianLain = null;
    }//GEN-LAST:event_formWindowClosed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void JCNamaBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCNamaBarangItemStateChanged
        setStok();
    }//GEN-LAST:event_JCNamaBarangItemStateChanged

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            sesuaikan();
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        sesuaikan();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void JCNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTStokBaruKG.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyPressed

    private void JTStokBaruKGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTStokBaruKGKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKomaKG.requestFocus();
        }
    }//GEN-LAST:event_JTStokBaruKGKeyPressed

    private void JTKomaKGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKomaKGKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTKomaKGKeyPressed

    private void JDTanggalPenyesuaianPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPenyesuaianPropertyChange
        setStok();
    }//GEN-LAST:event_JDTanggalPenyesuaianPropertyChange

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
            java.util.logging.Logger.getLogger(PenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenyesuaianLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenyesuaianLain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCNamaBarang;
    private KomponenGUI.JdateCF JDTanggalPenyesuaian;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JtKoma JTKomaKG;
    private KomponenGUI.JtextF JTNoPenyesuaian;
    private KomponenGUI.JRibuanTextField JTStokBaruKG;
    private KomponenGUI.JtextF JTStokLamaKG;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF13;
    private KomponenGUI.JlableF jlableF14;
    private KomponenGUI.JlableF jlableF16;
    private KomponenGUI.JlableF jlableF17;
    private KomponenGUI.JlableF jlableF18;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    public static String getNoPenyesuaianLain() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPenyesuaian = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPenyesuaian` FROM `tbpenyesuaianlain` ORDER BY `NoPenyesuaian` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPenyesuaian = "GG-" + "000001" + "-PL";
            }
            while (rs.next()) {
                String nopenjualan = rs.getString("NoPenyesuaian");
                String number = nopenjualan.substring(3, 9);
                int p = 1 + parseInt(number);
                if (p != 999999) {
                    NoPenyesuaian = "GG-" + nf.format(p) + "-PL";
                } else if (p == 999999) {
                    p = 1;
                    NoPenyesuaian = "GG-" + nf.format(p) + "-PL";
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Generate Nomor Penyesuaian");
        } finally {
            runSelct.closecon();
        }
        return NoPenyesuaian;
    }

    void setStok() {
        if (JCNamaBarang.getSelectedIndex() != 0) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal setStok()");
            dRunSelctOne.setQuery("SELECT `IdBarangLain`, `NamaBarangLain`, SUM(`Stok`) as 'Stok Awal' FROM (\n"
                    + "SELECT a.`IdBarangLain`, a.`NamaBarangLain`, 0 as 'Stok' FROM `tbmbaranglain`a JOIN `tbsmjenisbaranglain`b ON a.`IdJenisBarangLain`=b.`IdJenisBaranglain` WHERE 1\n"
                    + "	UNION ALL\n"
                    + "SELECT `IdBarangLain`, null as 'NamaBarangLain', SUM(`Netto`) as 'Stok' FROM `tbpenerimaanlain` WHERE 1 AND `Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY `IdBarangLain`\n"
                    + "    UNION ALL\n"
                    + "SELECT a.`IdBarangLain`, null as 'NamaBarangLain', SUM(`Jumlah`)*-1 as 'Stok' FROM `tbpenjualandetail`a JOIN `tbpenjualan`b ON a.`NoTransaksi`=b.`NoTransaksi` JOIN `tbmbaranglain`c ON a.`IdBarangLain`=c.`IdBarangLain` WHERE (c.`IdjenisBarangLain` = 2 OR c.`NamaBarangLain` = 'LAKBAN') AND `StatusLembar` = 0 AND b.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY `IdBarangLain`\n"
                    + "    UNION ALL\n"
                    + "SELECT a.`IdBarangLain`, null as 'NamaBarangLain', SUM(`Jumlah`/`BeratPembagi`)*-1 as 'Stok' FROM `tbpenjualandetail`a JOIN `tbpenjualan`b ON a.`NoTransaksi`=b.`NoTransaksi` JOIN `tbmbaranglain`c ON a.`IdBarangLain`=c.`IdBarangLain` WHERE c.`IdjenisBarangLain` = 2 AND `StatusLembar` = 1 AND b.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY `IdBarangLain`\n"
                    + "    UNION ALL\n"
                    + "SELECT a.`IdBarangLain`, null as 'NamaBarangLain', SUM(`Jumlah`*`Isi`/`BeratPembagi`)*-1 as 'Stok' FROM `tbpenjualandetail`a JOIN `tbpenjualan`b ON a.`NoTransaksi`=b.`NoTransaksi` JOIN `tbmbaranglain`c ON a.`IdBarangLain`=c.`IdBarangLain` JOIN `tbmbarang`d ON c.`IdBarangLain`=d.`IdPlastikDalam` WHERE c.`IdjenisBarangLain` = 1 AND `StatusLembar` = 1 AND b.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY `IdBarangLain`\n"
                    + "    UNION ALL\n"
                    + "SELECT b.`IdPlastikDalam` as 'IdBarangLain', null as 'NamaBarangLain', SUM(a.`JumlahHasil`*b.`Isi`/c.`BeratPembagi`)*-1 as 'Stok' FROM `tbpacking`a JOIN `tbmbarang`b ON a.`IdBarangHasil`=b.`IdBarang` JOIN `tbmbaranglain`c ON b.`IdPlastikDalam`=c.`IdBarangLain` WHERE 1 AND `IdJenisBarangLain` = 1 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY b.`IdPlastikDalam`\n"
                    + "	UNION ALL\n"
                    + "SELECT b.`IdPlastikLuar` as 'IdBarangLain', null as 'NamaBarangLain', SUM(a.`JumlahHasil`/c.`BeratPembagi`)*-1 as 'Stok' FROM `tbpacking`a JOIN `tbmbarang`b ON a.`IdBarangHasil`=b.`IdBarang` JOIN `tbmbaranglain`c ON b.`IdPlastikLuar`=c.`IdBarangLain` WHERE 1 AND `IdJenisBarangLain` = 2 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY b.`IdPlastikLuar`\n"
                    + "	UNION ALL\n"
                    + "SELECT '4' as 'IdBarangLain', null as 'NamaBarangLain', SUM(a.`JumlahBahan`*50*0.5*0.0001)*-1 as 'Stok' FROM `tbpacking`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmbarang`d ON a.`IdBarangHasil`=d.`IdBarang` WHERE 1 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' AND c.`NamaBarang` LIKE '%KSR%' AND d.`NamaBarang` NOT LIKE '%@50 KG%'\n"
                    + "	UNION ALL\n"
                    + "SELECT '2' as 'IdBarangLain', null as 'NamaBarangLain', SUM((a.`JumlahBahan`*0.05)/18)*-1 as 'Stok' FROM `tbpacking`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmbarang`d ON a.`IdBarangHasil`=d.`IdBarang` WHERE 1 AND a.`Tanggal` >= '2018-05-12' AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' AND c.`NamaBarang` LIKE '%KSR%' AND d.`NamaBarang` NOT LIKE '%@50 KG%'\n"
                    + "	UNION ALL\n"
                    + "SELECT a.`IdBarangLain`, null as 'NamaBarangLain', SUM(a.`Jumlah`)*-1 as 'Stok' FROM `tbpemakaianlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` WHERE 1 AND `IdJenisBarangLain` = 3 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY a.`IdBarangLain`\n"
                    + "    	UNION ALL\n"
                    + "SELECT 15 as 'IdBarangLain', null as 'NamaBarangLain', SUM(a.`Jumlah`) as 'Stok' FROM `tbpemakaianlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` WHERE a.`IdBarangLain` = 16 AND `IdJenisBarangLain` = 3 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY a.`IdBarangLain`\n"
                    + "    	UNION ALL\n"
                    + "SELECT 17 as 'IdBarangLain', null as 'NamaBarangLain', SUM(a.`Jumlah`) as 'Stok' FROM `tbpemakaianlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` WHERE a.`IdBarangLain` = 15 AND `IdJenisBarangLain` = 3 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY a.`IdBarangLain`\n"
                    + "    	UNION ALL\n"
                    + "SELECT a.`IdBarangLain`,null as 'NamaBarangLain', SUM(a.`Jumlah`)*-1 as 'Stok' FROM `tbpemakaianlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` WHERE 1 AND `IdJenisBarangLain` < 3 AND a.`Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY a.`IdBarangLain`\n"
                    + "    UNION ALL\n"
                    + "SELECT `IdBarangLain`, null as 'NamaBarangLain', SUM(`Jumlah`) as 'Stok' FROM `tbpenyesuaianlain` WHERE 1 AND `Tanggal` <= '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "' GROUP BY `IdBarangLain` ) t1 WHERE `IdBarangLain` = (SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCNamaBarang.getSelectedItem() + "') GROUP BY `IdBaranglain`");
            ArrayList<String> list = dRunSelctOne.excute();
            double StokLamaKG = Double.valueOf(list.get(2));
            JTStokLamaKG.setText(Decformatdigit(StokLamaKG));
        }
    }

    String Decformatdigit(double Number) {
        double value = 0;
        value = Number;
        String output;
        String pattern = "#,###,###.00";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        if (value < 0) {
            value = abs(value);
            output = "-" + myFormatter.format(value);
        } else if (value >= 0 && value < 1) {
            output = "0" + myFormatter.format(value);
        } else {
            output = myFormatter.format(value);
        }
        return output;
    }

    void sesuaikan() {
        if (checkInput()) {
            Insert insert = new LSubProces.Insert();
            insert.simpan("INSERT INTO `tbpenyesuaianlain` (`NoPenyesuaian`, `Tanggal`, `IdBarangLain`, `Jumlah`, `Keterangan`) VALUES ('" + JTNoPenyesuaian.getText() + "', '" + FDateF.datetostr(JDTanggalPenyesuaian.getDate(), "yyyy-MM-dd") + "',(SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCNamaBarang.getSelectedItem() + "'),'" + ((Float.parseFloat(JTStokBaruKG.getText().replace(".", "") + "." + JTKomaKG.getText()) - Float.parseFloat(JTStokLamaKG.getText().replace(".", "").replace(",", ".")))) + "','" + JTAKeterangan.getText() + "')", "Penyesuaian Barang Lain", null);
            JTStokLamaKG.setText("0,00");
            JTStokBaruKG.setText("0");
            JTKomaKG.setText("00");
            JTAKeterangan.setText("");
            JTNoPenyesuaian.setText(getNoPenyesuaianLain());
            JCNamaBarang.setSelectedIndex(0);
            JCNamaBarang.requestFocus();
        }
    }

}
