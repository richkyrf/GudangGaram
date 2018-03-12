/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import static KomponenGUI.FDateF.datetostr;
import LSubProces.DRunSelctOne;
import LSubProces.RunSelct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.abs;
import static java.lang.String.format;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import static javax.print.DocFlavor.INPUT_STREAM.AUTOSENSE;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import static javax.print.PrintServiceLookup.lookupDefaultPrintService;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import static javax.print.attribute.Size2DSyntax.INCH;
import javax.print.attribute.standard.Copies;
import static javax.print.attribute.standard.MediaSize.findMedia;
import static javax.print.attribute.standard.OrientationRequested.LANDSCAPE;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author richky
 */
public class Poles extends javax.swing.JFrame {

    /**
     * Creates new form Poles
     */
    public Poles() {
        initComponents();
        setVisible(true);
        setTitle("Poles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    void loadBahan() {
        DefaultTableModel model = (DefaultTableModel) JTableBahan.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPoles`, `NamaBarang`, SUM(`Jumlah`) as 'Jumlah', FORMAT((SUM(`Jumlah KG`)/SUM(`Jumlah`)),2) 'Satuan', FORMAT(SUM(`Jumlah KG`),0) as 'Jumlah KG'  FROM (SELECT `NoPoles`, CONCAT(c.`NamaBarang`, ' (PARTAI ',a.`IdPartai`,')') as 'NamaBarang', FORMAT(ROUND(SUM(`JumlahBahan`)),0) as 'Jumlah', ROUND(ROUND(SUM(`JumlahHasil`)) * d.`Satuan`) as 'Jumlah KG' FROM `tbpacking`a JOIN `tbmpartai`b ON a.`IdPartai` = b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmbarang`d ON a.`IdBarangHasil`=d.`IdBarang` WHERE a.`Tanggal` = '" + datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY d.`NamaBarang` ORDER BY `NoPacking` DESC) tbtemo GROUP BY `NamaBarang`");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", ""});
                JTableBahan.setValueAt(row + 1, row, 0);
                JTNoPoles.setText(rs.getString(1));
                JTableBahan.setValueAt(rs.getString(2), row, 1);
                JTableBahan.setValueAt(rs.getString(3).replace(",", "."), row, 2);
                JTableBahan.setValueAt(rs.getString(4).replace(".", ","), row, 3);
                JTableBahan.setValueAt(rs.getString(5).replace(",", "."), row, 4);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Bahan");
        } finally {
            runSelct.closecon();
        }
    }

    void loadHasil() {
        DefaultTableModel model = (DefaultTableModel) JTableHasil.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT b.`NamaBarang`, FORMAT(ROUND(SUM(`JumlahHasil`)),0) as 'Jumlah', b.`Satuan`, FORMAT(ROUND(ROUND(SUM(`JumlahHasil`)) * b.`Satuan`),0) as 'Jumlah KG' FROM `tbpacking`a JOIN `tbmbarang`b ON a.`IdBarangHasil` = b.`IdBarang` WHERE `Tanggal` = '" + datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY b.`NamaBarang` ORDER BY `NoPacking` DESC");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", ""});
                JTableHasil.setValueAt(row + 1, row, 0);
                JTableHasil.setValueAt(rs.getString(1), row, 1);
                JTableHasil.setValueAt(rs.getString(2).replace(",", "."), row, 2);
                JTableHasil.setValueAt(rs.getString(3).replace(".", ","), row, 3);
                JTableHasil.setValueAt(rs.getString(4).replace(",", "."), row, 4);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Hasil");
        } finally {
            runSelct.closecon();
        }
    }

    Integer getTotalBahan() {
        int TotalBahan = 0;
        for (int x = 0; x < JTableBahan.getRowCount(); x++) {
            TotalBahan = TotalBahan + Integer.valueOf(JTableBahan.getValueAt(x, 4).toString().replace(".", "").replace(",", "."));
        }
        return TotalBahan;
    }

    Integer getTotalHasil() {
        int TotalHasil = 0;
        for (int x = 0; x < JTableHasil.getRowCount(); x++) {
            TotalHasil = TotalHasil + Integer.valueOf(JTableHasil.getValueAt(x, 4).toString().replace(".", "").replace(",", "."));
        }
        return TotalHasil;
    }

    boolean checkPacking() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Check Packing");
        dRunSelctOne.setQuery("SELECT c.`NamaBarang`, ROUND(SUM(`JumlahBahan`)) as 'Jumlah', c.`Satuan`, ROUND(ROUND(SUM(`JumlahBahan`)) * c.`Satuan`) as 'Jumlah KG' FROM `tbpacking`a JOIN `tbmpartai`b ON a.`IdPartai` = b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` WHERE a.`Tanggal` = '" + datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY c.`NamaBarang`");
        ArrayList<String> list = dRunSelctOne.excute();

        return list.get(0) != null;
    }

    Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            cal.add(Calendar.DATE, -2);
        } else {
            cal.add(Calendar.DATE, -1);
        }
        return cal.getTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlableF8 = new KomponenGUI.JlableF();
        jlableF1 = new KomponenGUI.JlableF();
        JTNoPoles = new KomponenGUI.JtextF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        JDTanggal = new KomponenGUI.JdateCF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBahan = new KomponenGUI.JtableF();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableHasil = new KomponenGUI.JtableF();
        JTNoPoles1 = new KomponenGUI.JtextF();
        JTNoPoles2 = new KomponenGUI.JtextF();
        JTTotalBahan = new KomponenGUI.JRibuanTextField();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF2 = new KomponenGUI.JlableF();
        JTTotalHasil = new KomponenGUI.JRibuanTextField();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        jbuttonF2 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF8.setText(":");

        jlableF1.setText("No Poles");

        JTNoPoles.setEnabled(false);
        JTNoPoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPolesKeyPressed(evt);
            }
        });

        jlableF23.setText("Tanggal");

        jlableF24.setText(":");

        JDTanggal.setDate(yesterday());
        JDTanggal.setDateFormatString("dd-MM-yyyy");
        JDTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggalPropertyChange(evt);
            }
        });
        JDTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalKeyPressed(evt);
            }
        });

        JTableBahan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Barang", "Jumlah Sak", "Satuan", "Jumlah KG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBahan.setColumnSelectionAllowed(true);
        JTableBahan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableBahan);
        JTableBahan.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (JTableBahan.getColumnModel().getColumnCount() > 0) {
            JTableBahan.getColumnModel().getColumn(0).setMinWidth(50);
            JTableBahan.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTableBahan.getColumnModel().getColumn(0).setMaxWidth(50);
            JTableBahan.getColumnModel().getColumn(2).setMinWidth(120);
            JTableBahan.getColumnModel().getColumn(2).setPreferredWidth(120);
            JTableBahan.getColumnModel().getColumn(2).setMaxWidth(120);
            JTableBahan.getColumnModel().getColumn(3).setMinWidth(100);
            JTableBahan.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTableBahan.getColumnModel().getColumn(3).setMaxWidth(100);
            JTableBahan.getColumnModel().getColumn(4).setMinWidth(120);
            JTableBahan.getColumnModel().getColumn(4).setPreferredWidth(120);
            JTableBahan.getColumnModel().getColumn(4).setMaxWidth(120);
        }
        JTableBahan.setrender(new int[]{2,3,4}, new String[]{"Number", "Number", "Number"});

        JTableHasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Barang", "Jumlah Sak", "Satuan", "Jumlah KG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableHasil.setColumnSelectionAllowed(true);
        JTableHasil.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTableHasil);
        JTableHasil.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (JTableHasil.getColumnModel().getColumnCount() > 0) {
            JTableHasil.getColumnModel().getColumn(0).setMinWidth(50);
            JTableHasil.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTableHasil.getColumnModel().getColumn(0).setMaxWidth(50);
            JTableHasil.getColumnModel().getColumn(2).setMinWidth(120);
            JTableHasil.getColumnModel().getColumn(2).setPreferredWidth(120);
            JTableHasil.getColumnModel().getColumn(2).setMaxWidth(120);
            JTableHasil.getColumnModel().getColumn(3).setMinWidth(100);
            JTableHasil.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTableHasil.getColumnModel().getColumn(3).setMaxWidth(100);
            JTableHasil.getColumnModel().getColumn(4).setMinWidth(120);
            JTableHasil.getColumnModel().getColumn(4).setPreferredWidth(120);
            JTableHasil.getColumnModel().getColumn(4).setMaxWidth(120);
        }
        JTableHasil.setrender(new int[]{2,3,4}, new String[]{"Number", "Number", "Number"});

        JTNoPoles1.setText("Bahan Poles :");
        JTNoPoles1.setEnabled(false);
        JTNoPoles1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPoles1KeyPressed(evt);
            }
        });

        JTNoPoles2.setText("Hasil Poles   :");
        JTNoPoles2.setEnabled(false);
        JTNoPoles2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPoles2KeyPressed(evt);
            }
        });

        JTTotalBahan.setEnabled(false);

        jlableF9.setText(":");

        jlableF2.setText("Total Bahan");

        JTTotalHasil.setEnabled(false);

        jlableF10.setText(":");

        jlableF3.setText("Total Hasil");

        jbuttonF2.setText("Print");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTNoPoles2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTNoPoles1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                        .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTNoPoles, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbuttonF2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTTotalHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTTotalBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTNoPoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(JTNoPoles1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTTotalBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(JTNoPoles2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTTotalHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTNoPolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPolesKeyPressed

    }//GEN-LAST:event_JTNoPolesKeyPressed

    private void JDTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeyPressed

    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange
        if (checkPacking()) {
            loadBahan();
            JTTotalBahan.setText(String.valueOf(getTotalBahan()));
            loadHasil();
            JTTotalHasil.setText(String.valueOf(getTotalHasil()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Belum ada data Packing pada Tanggal " + datetostr(JDTanggal.getDate(), "dd-MM-yyyy"));
            for (int a = 0; a < JTableBahan.getRowCount(); a++) {
                ((DefaultTableModel) JTableBahan.getModel()).removeRow(0);
            }
            for (int a = 0; a < JTableHasil.getRowCount(); a++) {
                ((DefaultTableModel) JTableHasil.getModel()).removeRow(0);
            }
        }
    }//GEN-LAST:event_JDTanggalPropertyChange

    private void JTNoPoles1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPoles1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNoPoles1KeyPressed

    private void JTNoPoles2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPoles2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNoPoles2KeyPressed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        printing();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.poles = null;
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
            java.util.logging.Logger.getLogger(Poles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Poles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Poles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Poles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Poles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JtextF JTNoPoles;
    private KomponenGUI.JtextF JTNoPoles1;
    private KomponenGUI.JtextF JTNoPoles2;
    private KomponenGUI.JRibuanTextField JTTotalBahan;
    private KomponenGUI.JRibuanTextField JTTotalHasil;
    private KomponenGUI.JtableF JTableBahan;
    private KomponenGUI.JtableF JTableHasil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF23;
    private KomponenGUI.JlableF jlableF24;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    void printing() {
        String Tanggal = datetostr(JDTanggal.getDate(), "dd-MM-yyyy");
        String NoPoles = JTNoPoles.getText();

        String[] BarangBahan = new String[JTableBahan.getRowCount()];
        int[] JumlahBahan = new int[JTableBahan.getRowCount()];
        String[] JumlahBahans = new String[JTableBahan.getRowCount()];
        double[] SatuanBahan = new double[JTableBahan.getRowCount()];
        String[] SatuanBahans = new String[JTableBahan.getRowCount()];
        int[] JumlahKGBahan = new int[JTableBahan.getRowCount()];
        String[] JumlahKGBahans = new String[JTableBahan.getRowCount()];
        for (int i = 0; i < JTableBahan.getRowCount(); i++) {
            BarangBahan[i] = JTableBahan.getValueAt(i, 1).toString();
            JumlahBahan[i] = Integer.valueOf(JTableBahan.getValueAt(i, 2).toString().replace(".", "").replace(",", "."));
            JumlahBahans[i] = Intformatdigit(JumlahBahan[i]);
            SatuanBahan[i] = Double.valueOf(JTableBahan.getValueAt(i, 3).toString().replace(".", "").replace(",", "."));
            SatuanBahans[i] = Decformatdigit(SatuanBahan[i]);
            JumlahKGBahan[i] = Integer.valueOf(JTableBahan.getValueAt(i, 4).toString().replace(".", "").replace(",", "."));
            JumlahKGBahans[i] = Intformatdigit(JumlahKGBahan[i]);
        }
        String[] BarangHasil = new String[JTableHasil.getRowCount()];
        int[] JumlahHasil = new int[JTableHasil.getRowCount()];
        String[] JumlahHasils = new String[JTableHasil.getRowCount()];
        double[] SatuanHasil = new double[JTableHasil.getRowCount()];
        String[] SatuanHasils = new String[JTableHasil.getRowCount()];
        int[] JumlahKGHasil = new int[JTableHasil.getRowCount()];
        String[] JumlahKGHasils = new String[JTableHasil.getRowCount()];
        for (int i = 0; i < JTableHasil.getRowCount(); i++) {
            BarangHasil[i] = JTableHasil.getValueAt(i, 1).toString();
            JumlahHasil[i] = Integer.valueOf(JTableHasil.getValueAt(i, 2).toString().replace(".", "").replace(",", "."));
            JumlahHasils[i] = Intformatdigit(JumlahHasil[i]);
            SatuanHasil[i] = Double.valueOf(JTableHasil.getValueAt(i, 3).toString().replace(".", "").replace(",", "."));
            SatuanHasils[i] = Decformatdigit(SatuanHasil[i]);
            JumlahKGHasil[i] = Integer.valueOf(JTableHasil.getValueAt(i, 4).toString().replace(".", "").replace(",", "."));
            JumlahKGHasils[i] = Intformatdigit(JumlahKGHasil[i]);
        }

        Integer TotalBahan = getTotalBahan();
        String TotalBahans = Intformatdigit(TotalBahan);

        Integer TotalHasil = getTotalHasil();
        String TotalHasils = Intformatdigit(TotalHasil);

        String leftAlignFormat = "%-5s%-44s%-9s%-9s%-12s%-1s%n";
        String OutFormat = "";
        OutFormat += format("%-58s%-22s%n", " LAPORAN PROSES POLES", "No.Poles: " + NoPoles);
        OutFormat += format("%-58s%-22s%n", " ", "Tanggal : " + Tanggal);
        //                               12345678901234567890123456789012345678901234567890123456789012345678901234567890
        //                               12341234567890123456789012345678901234567890123456712345678912345671234567890123
        OutFormat += format("%-80s%n", " BAHAN PROSES:");
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        OutFormat += format("%-80s%n", " | NO| NAMA BARANG                               | JUMLAH | KG/ZAK | SUB TOTAL |");
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        for (int i = 0; i < 3; i++) {
            if (i < JTableBahan.getRowCount()) {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + BarangBahan[i], "|" + format("%7s", JumlahBahans[i]), "|" + format("%7s", SatuanBahans[i]), "|" + format("%10s", JumlahKGBahans[i]), "|");
            } else {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "|", "|", "|", "|", "|", "|", "|");
            }
        }
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        OutFormat += format("%-49s%-31s%n", " ", "|   TOTAL BAHAN   | " + format("%10s", TotalBahans) + "|");
        OutFormat += format("%-49s%-31s%n", " HASIL PROSES:", "+--------+--------+-----------+");
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        OutFormat += format("%-80s%n", " | NO| NAMA BARANG                               | JUMLAH | KG/ZAK | SUB TOTAL |");
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        for (int i = 0; i < 6; i++) {
            if (i < JTableHasil.getRowCount()) {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + BarangHasil[i], "|" + format("%7s", JumlahHasils[i]), "|" + format("%7s", SatuanHasils[i]), "|" + format("%10s", JumlahKGHasils[i]), "|");
            } else {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "|", "|", "|", "|", "|", "|", "|");
            }
        }
        OutFormat += format("%-80s%n", " +---+-------------------------------------------+--------+--------+-----------+");
        OutFormat += format("%-49s%-31s%n", " ", "|   TOTAL HASIL   | " + format("%10s", TotalHasils) + "|");
        OutFormat += format("%-49s%-31s%n", " ", "+--------+--------+-----------+");
        OutFormat += format("%n", "");
        OutFormat += format("%-80s%n", " Disiapkan Oleh");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        OutFormat += format("%-80s%n", " " + "HENDRI");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        //System.out.println(OutFormat);
        directprinting(OutFormat);
    }

    /**
     *
     * @param Teks
     */
    public static void directprinting(String Teks) {
        String testprint = Teks;
        String defaultPrinter
                = lookupDefaultPrintService().getName();
        PrintService service = lookupDefaultPrintService();
        try {
            InputStream in = new ByteArrayInputStream(testprint.getBytes());
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            pras.add(LANDSCAPE);
            pras.add(findMedia(8.5f, 5.5f, INCH));
            pras.add(new Copies(1));
            DocAttributeSet docs = new HashDocAttributeSet();
            docs.add(LANDSCAPE);
            docs.add(findMedia(8.5f, 5.5f, INCH));
            try {
                DocFlavor flavor = AUTOSENSE;
                Doc doc = new SimpleDoc(in, flavor, docs);
                DocPrintJob job = service.createPrintJob();
                PrintJobWatcher pjw = new PrintJobWatcher(job);
                job.print(doc, pras);
                pjw.waitForDone();
                in.close();
            } catch (PrintException e) {
            }
        } catch (IOException e) {
        }
    }

    /**
     *
     */
    public static class PrintJobWatcher {

        private boolean done = false;

        PrintJobWatcher(DocPrintJob job) {
            job.addPrintJobListener(new PrintJobAdapter() {
                @Override
                public void printJobCanceled(PrintJobEvent pje) {
                    allDone();
                }

                @Override
                public void printJobCompleted(PrintJobEvent pje) {
                    allDone();
                }

                @Override
                public void printJobFailed(PrintJobEvent pje) {
                    allDone();
                }

                @Override
                public void printJobNoMoreEvents(PrintJobEvent pje) {
                    allDone();
                }

                void allDone() {
                    synchronized (PrintJobWatcher.this) {
                        done = true;
                        PrintJobWatcher.this.notify();
                    }
                }
            });
        }

        /**
         *
         */
        public synchronized void waitForDone() {
            try {
                while (!done) {
                    wait();
                }
            } catch (InterruptedException e) {
            }
        }
    }

    String Intformatdigit(int Number) {
        int value = 0;
        value = Number;
        String output;
        if (value < 0) {
            value = abs(value);
            String pattern = "#,###,###";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = "(" + myFormatter.format(value) + ")";
        } else {
            String pattern = "#,###,###";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = myFormatter.format(value);
        }
        return output.replace(",", ".");
    }

    String Decformatdigit(double Number) {
        double value = 0;
        value = Number;
        String output;
        if (value < 0) {
            value = abs(value);
            String pattern = "#,###,###.00";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = "(" + myFormatter.format(value) + ")";
        } else {
            String pattern = "#,###,###.00";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = myFormatter.format(value);
        }
        return output;
    }

}
