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
import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.String.format;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author richky
 */
public class PrintTPB extends javax.swing.JFrame {

    /**
     * Creates new form PrintTPB
     */
    public PrintTPB() {
        initComponents();
        setVisible(true);
        setTitle("Print Tanda Penerimaan Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setNoTPB();
    }

    Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    void setNoTPB() {
        if (JCPemasok.getSelectedIndex() == 0) {
            JTNoTPB.setText("");
            DefaultTableModel dm = (DefaultTableModel) JTable.getModel();
            int rowCount = dm.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
        } else {
            NumberFormat nf = new DecimalFormat("000000");
            String NoTransaksi = null;
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.setQuery("SELECT `NoTpb` FROM `tbtpb` WHERE `Pemasok` = '" + JCPemasok.getSelectedItem() + "' AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            if (list.get(0) != null) {
                NoTransaksi = list.get(0);
            } else {
                RunSelct runSelct = new RunSelct();
                runSelct.setQuery("SELECT `NoTpb` FROM `tbtpb` ORDER BY `NoTpb` DESC LIMIT 1");
                try {
                    ResultSet rs = runSelct.excute();
                    if (!rs.isBeforeFirst()) {
                        NoTransaksi = "GG-" + "000001" + "-PG";
                    }
                    while (rs.next()) {
                        String nopenjualan = rs.getString("NoTpb");
                        String number = nopenjualan.substring(3, 9);
                        int p = 1 + parseInt(number);
                        if (p != 999999) {
                            NoTransaksi = "GG-" + nf.format(p) + "-PG";
                        } else if (p == 999999) {
                            p = 1;
                            NoTransaksi = "GG-" + nf.format(p) + "-PG";
                        }
                    }
                } catch (SQLException e) {
                    out.println("E6" + e);
                    showMessageDialog(null, "Gagal Generate Nomor TPB");
                } finally {
                    runSelct.closecon();
                }
            }
            JTNoTPB.setText(NoTransaksi);
        }
    }

    void loadPemasok() {
        JCPemasok.setEnabled(true);
        JCPemasok.load("SELECT * FROM (SELECT '-- Pilih Nama Pemasok --' as 'Pemasok' UNION ALL SELECT `Pemasok` FROM `tbpenerimaan`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmpemasok`d ON c.`IdPemasok`=d.`IdPemasok` WHERE a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY `Pemasok` UNION ALL SELECT `PemasokLain` as 'Pemasok' FROM `tbpenerimaanlain`a JOIN `tbmpemasoklain`b ON a.`IdPemasokLain`=b.`IdPemasokLain` WHERE a.`IdPemasokLain` IS NOT NULL AND a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' GROUP BY `PemasokLain`) t1 GROUP BY `Pemasok` ");
        if (JCPemasok.getItemCount() == 1) {
            JCPemasok.load("SELECT '' ");
            JCPemasok.setEnabled(false);
        }
        JTNoTPB.requestFocus();
        JTNoTPB.setText("");
        DefaultTableModel dm = (DefaultTableModel) JTable.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
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

        LBNoTransaksi = new KomponenGUI.JlableF();
        jlableF26 = new KomponenGUI.JlableF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF27 = new KomponenGUI.JlableF();
        LBNoTransaksi1 = new KomponenGUI.JlableF();
        LBNoTransaksi2 = new KomponenGUI.JlableF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        JDTanggal = new KomponenGUI.JdateCF();
        JTNoTPB = new KomponenGUI.JtextF();
        JCPemasok = new KomponenGUI.JcomboboxF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        LBNoTransaksi.setText("No. TPB");

        jlableF26.setText(":");

        jlableF23.setText("Tanggal");

        jlableF24.setText(":");

        jlableF27.setText(":");

        LBNoTransaksi1.setText("Pemasok");

        LBNoTransaksi2.setText("TANDA PENERIMAAN BARANG");

        new JScrollPane(JTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Barang", "Plat", "Karung", "Netto Penjual", "Netto Pelita", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(JTable);
        JTable.setrender(new int[]{3,4,5,6}, new String[]{"Number", "Number", "Number", "Number"});

        jbuttonF1.setText("Simpan & Print");
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

        JDTanggal.setDate(yesterday());
        JDTanggal.setDateFormatString("dd-MM-yyyy");
        JDTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggalPropertyChange(evt);
            }
        });

        JCPemasok.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCPemasokItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTNoTPB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoTPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        tambahData();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.printTPB = null;
    }//GEN-LAST:event_formWindowClosed

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange
        loadPemasok();
    }//GEN-LAST:event_JDTanggalPropertyChange

    private void JCPemasokItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCPemasokItemStateChanged
        setNoTPB();
        load();
    }//GEN-LAST:event_JCPemasokItemStateChanged

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
            java.util.logging.Logger.getLogger(PrintTPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintTPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintTPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintTPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintTPB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCPemasok;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JtextF JTNoTPB;
    private KomponenGUI.JtableF JTable;
    private KomponenGUI.JlableF LBNoTransaksi;
    private KomponenGUI.JlableF LBNoTransaksi1;
    private KomponenGUI.JlableF LBNoTransaksi2;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JlableF jlableF23;
    private KomponenGUI.JlableF jlableF24;
    private KomponenGUI.JlableF jlableF26;
    private KomponenGUI.JlableF jlableF27;
    // End of variables declaration//GEN-END:variables

    void tambahData() {
        if (JTable.getRowCount() >= 1) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.setQuery("SELECT COUNT(`NoTpb`) FROM `tbtpb` WHERE `Pemasok` = '" + JCPemasok.getSelectedItem() + "' AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            boolean berhasil = true;
            if (list.get(0).equals("0")) {
                Insert insert = new Insert();
                berhasil = insert.simpan("INSERT INTO `tbtpb` (`Tanggal`, `Pemasok`, `NoTpb`) VALUES ('" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "', '" + JCPemasok.getSelectedItem() + "', '" + JTNoTPB.getText() + "')", "TPB", this);
            } else {
                Update update = new Update();
                berhasil = update.Ubah("UPDATE `tbtpb` SET `NoTpb` = '" + JTNoTPB.getText() + "' WHERE `Pemasok` = '" + JCPemasok.getSelectedItem() + "' AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'", "TPB", this);
            }
            if (berhasil) {
                printing();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Gagal Print Karena Tidak Ada Data Penerimaan Di Tanggal " + FDateF.datetostr(JDTanggal.getDate(), "dd-MM-yyyy"));
        }
    }

    void load() {
        if (JCPemasok.getSelectedIndex() != 0) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.getDataVector().removeAllElements();
            RunSelct runSelct = new RunSelct();
            runSelct.setQuery("(SELECT `NamaBarang`, `Plat`, REPLACE(FORMAT(`KarungPelita`,0),',','.') as 'Karung', REPLACE(FORMAT(`NettoPenjual`,0),',','.') as 'Netto PJL', REPLACE(FORMAT(`NettoPelita`,0),',','.') as 'Netto PLT', IF(`NettoPelita`-`NettoPenjual`<0, CONCAT(REPLACE(FORMAT(`NettoPelita`-`NettoPenjual`,0),',','.'), ' KG'),IF(`NettoPelita`-`NettoPenjual`>0, CONCAT('+',REPLACE(FORMAT(`NettoPelita`-`NettoPenjual`,0),',','.'),' KG'), '')) as `Keterangan`, `Pemasok` FROM `tbpenerimaan`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmpemasok`d ON c.`IdPemasok`=d.`IdPemasok` WHERE `Pemasok` = '" + JCPemasok.getSelectedItem() + "' AND  a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "' ORDER BY `IdPenerimaan` ASC) UNION ALL SELECT `NamaBarangLain`, IFNULL(`Plat`,'-') as 'Plat', IF(`Jumlah`=0,'',REPLACE(FORMAT(`Jumlah`,0),',','.')) as 'Karung', IF(`Brutto`=0,'',REPLACE(REPLACE(REPLACE(FORMAT(`Brutto`,1),',','*'),'.',','),'*','.')) as 'Netto PJL', REPLACE(REPLACE(REPLACE(FORMAT(`Netto`,1),',','*'),'.',','),'*','.') as 'Netto PLT', IF(`Netto`-`Brutto`<0, CONCAT(REPLACE(REPLACE(REPLACE(FORMAT(`Netto`-`Brutto`,1),',','*'),'.',','),'*','.'), ' KG'),IF(`Netto`-`Brutto`>0, CONCAT('+',REPLACE(REPLACE(REPLACE(FORMAT(`Netto`-`Brutto`,1),',','*'),'.',','),'*','.'),' KG'), '')) as `Keterangan`, `PemasokLain` FROM `tbpenerimaanlain`a JOIN `tbmbaranglain`b ON a.`IdBarangLain`=b.`IdBarangLain` LEFT JOIN `tbmpemasoklain`c ON a.`IdPemasokLain`=c.`IdPemasokLain` LEFT JOIN `tbmkendaraan`d ON a.`IdKendaraan`=d.`IdKendaraan` WHERE `PemasokLain` = '" + JCPemasok.getSelectedItem() + "' AND a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
            try {
                ResultSet rs = runSelct.excute();
                int row = 0;
                while (rs.next()) {
                    model.addRow(new Object[]{" ", " ", "", "", "", "", ""});
                    JTable.setValueAt(row + 1, row, 0);
                    JTable.setValueAt(rs.getString(1), row, 1);
                    JTable.setValueAt(rs.getString(2), row, 2);
                    JTable.setValueAt(rs.getString(3), row, 3);
                    JTable.setValueAt(rs.getString(4), row, 4);
                    JTable.setValueAt(rs.getString(5), row, 5);
                    if (JTable.getValueAt(row, 1).toString().contains("ODIUM")) {
                        JTable.setValueAt(rs.getString(5).split("\\,")[0], row, 5);
                    }
                    JTable.setValueAt(rs.getString(6), row, 6);
                    if (JTable.getValueAt(row, 1).toString().contains("ODIUM")) {
                        JTable.setValueAt("", row, 6);
                    }
                    row++;
                }
            } catch (SQLException e) {
                out.println("E6" + e);
                showMessageDialog(null, "Gagal Panggil Data Print TPB");
            } finally {
                runSelct.closecon();
            }
            for (int column = 0; column < JTable.getColumnCount(); column++) {
                TableColumn tableColumn = JTable.getColumnModel().getColumn(column);
                int preferredWidth = 50;
                int maxWidth = 400;

                for (int row = 0; row < JTable.getRowCount(); row++) {
                    TableCellRenderer cellRenderer = JTable.getCellRenderer(row, column);
                    Component c = JTable.prepareRenderer(cellRenderer, row, column);
                    int width = c.getPreferredSize().width + JTable.getIntercellSpacing().width;
                    preferredWidth = Math.max(preferredWidth, width);

                    //  We've exceeded the maximum width, no need to check other rows
                    if (preferredWidth >= maxWidth) {
                        preferredWidth = maxWidth;
                    }
                }
                tableColumn.setPreferredWidth(preferredWidth + 15);
            }
            JTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            JTable.getTableHeader().setReorderingAllowed(false);
        }
    }

    void printing() {
        if (JTable.getValueAt(0, 1).toString().contains("PLASTIK")) {
            String Tanggal = FDateF.datetostr(JDTanggal.getDate(), "dd-MM-yyyy");
            String NoPenerimaan = JTNoTPB.getText();
            String Pemasok = JCPemasok.getSelectedItem().toString();
            String[] No = new String[JTable.getRowCount()];
            String[] Barang = new String[JTable.getRowCount()];
            String[] Plat = new String[JTable.getRowCount()];
            int[] Karung = new int[JTable.getRowCount()];
            String[] Karungs = new String[JTable.getRowCount()];
            double[] NettoPJL = new double[JTable.getRowCount()];
            String[] NettoPJLS = new String[JTable.getRowCount()];
            double[] NettoPLT = new double[JTable.getRowCount()];
            String[] NettoPLTS = new String[JTable.getRowCount()];
            String[] Ket = new String[JTable.getRowCount()];
            for (int i = 0; i < JTable.getRowCount(); i++) {
                No[i] = JTable.getValueAt(i, 0).toString();
                Barang[i] = JTable.getValueAt(i, 1).toString();
                if (JTable.getValueAt(i, 1).toString().length() > 23) {
                    Barang[i] = JTable.getValueAt(i, 1).toString().substring(0, 23);
                }
                Plat[i] = JTable.getValueAt(i, 2).toString();
                Karung[i] = Integer.parseInt(JTable.getValueAt(i, 3).toString().replace(".", ""));
                Karungs[i] = Intformatdigit(Karung[i]);
                NettoPJL[i] = Double.parseDouble(JTable.getValueAt(i, 4).toString().replace(".", "").replace(",", "."));
                NettoPJLS[i] = Decformatdigit(NettoPJL[i]);
                NettoPLT[i] = Double.parseDouble(JTable.getValueAt(i, 5).toString().replace(".", "").replace(",", "."));
                NettoPLTS[i] = Decformatdigit(NettoPLT[i]);
                Ket[i] = JTable.getValueAt(i, 6).toString();
                if (JTable.getValueAt(i, 6).toString().length() > 11) {
                    Ket[i] = JTable.getValueAt(i, 6).toString().substring(0, 11);
                }
            }

            Double TotalPJL = getTotalPJLPlastik();
            String TotalPJLS = Decformatdigit(TotalPJL);
            Double TotalPLT = getTotalPLTPlastik();
            String TotalPLTS = Decformatdigit(TotalPLT);
            Double TotalSelisih = getTotalSelisihPlastik();
            String TotalSelisihS = Decformatdigit(TotalSelisih);

            String leftAlignFormat = "%-5s%-25s%-13s%-6s%-9s%-9s%-12s%-1s%n";
            String OutFormat = "";
            OutFormat += format("%-80s%n", " _____________________________________________________________________________");
            OutFormat += format("%-80s%n", " Tanda Penerimaan Barang");
            OutFormat += format("%-53s%-27s%n", " ", "     Tanggal : " + Tanggal);
            OutFormat += format("%-53s%-27s%n", " Pemasok : " + Pemasok, "No Penerimaan: " + NoPenerimaan);
            //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
            //                              12341234567890123456789012345678901234567890123456712345678912345671234567890123
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            OutFormat += format("%-80s%n", " | NO| NAMA BARANG            |    PLAT    | BAL | BRUTTO |  NETTO |    KET    |");
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            for (int i = 0; i < 12; i++) {
                if (i < JTable.getRowCount()) {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + Barang[i], "| " + Plat[i], "|" + format("%4s", Karungs[i]), "|" + format("%8s", NettoPJLS[i]), "|" + format("%8s", NettoPLTS[i]), "|" + format("%10s", Ket[i]), "|");
                } else {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "|", "|", "|", "|", "|", "|", "|", "|");
                }
            }
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            OutFormat += format("%-49s%-9s%-9s%-12s%-1s%n", " | TOTAL ", "|" + format("%8s", TotalPJLS), "|" + format("%8s", TotalPLTS), "| " + format("%9s", TotalSelisihS + " KG"), "|");
            OutFormat += format("%-80s%n", " +-----------------------------------------------------------------+-----------+");
            //OutFormat += format("%-80s%n", " Terbilang : " + terbilang);
            OutFormat += format("%n", "");
            OutFormat += format("%-66s%-24s%n", " Disiapkan Oleh", "Diperiksa Oleh \n \n ");
            OutFormat += format("%-66s%-24s%n", " " + "    HENDRI", " Stock Keeper");
            OutFormat += format("%-80s%n", " _____________________________________________________________________________");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            directprinting(OutFormat);
            //System.out.println(OutFormat);
        } else {
            String Tanggal = FDateF.datetostr(JDTanggal.getDate(), "dd-MM-yyyy");
            String NoPenerimaan = JTNoTPB.getText();
            String Pemasok = JCPemasok.getSelectedItem().toString();
            String[] No = new String[JTable.getRowCount()];
            String[] Barang = new String[JTable.getRowCount()];
            String[] Plat = new String[JTable.getRowCount()];
            int[] Karung = new int[JTable.getRowCount()];
            String[] Karungs = new String[JTable.getRowCount()];
            int[] NettoPJL = new int[JTable.getRowCount()];
            String[] NettoPJLS = new String[JTable.getRowCount()];
            int[] NettoPLT = new int[JTable.getRowCount()];
            String[] NettoPLTS = new String[JTable.getRowCount()];
            String[] Ket = new String[JTable.getRowCount()];
            for (int i = 0; i < JTable.getRowCount(); i++) {
                No[i] = JTable.getValueAt(i, 0).toString();
                Barang[i] = JTable.getValueAt(i, 1).toString();
                if (JTable.getValueAt(i, 1).toString().length() > 23) {
                    Barang[i] = JTable.getValueAt(i, 1).toString().substring(0, 23);
                }
                Plat[i] = JTable.getValueAt(i, 2).toString();
                Karung[i] = 0;
                Karungs[i] = "";
                if (!JTable.getValueAt(i, 3).toString().replace(".", "").equals("")) {
                    Karung[i] = Integer.parseInt(JTable.getValueAt(i, 3).toString().replace(".", ""));
                    Karungs[i] = Intformatdigit(Karung[i]);
                }
                NettoPJL[i] = 0;
                NettoPJLS[i] = "";
                if (!JTable.getValueAt(i, 4).toString().replace(".", "").equals("")) {
                    NettoPJL[i] = Integer.parseInt(JTable.getValueAt(i, 4).toString().replace(".", ""));
                    NettoPJLS[i] = Intformatdigit(NettoPJL[i]);
                }
                NettoPLT[i] = Integer.parseInt(JTable.getValueAt(i, 5).toString().replace(".", ""));
                NettoPLTS[i] = Intformatdigit(NettoPLT[i]);
                Ket[i] = JTable.getValueAt(i, 6).toString();
                if (JTable.getValueAt(i, 6).toString().length() > 11) {
                    Ket[i] = JTable.getValueAt(i, 6).toString().substring(0, 11);
                }
            }

            Integer TotalPJL = getTotalPJL();
            String TotalPJLS = Intformatdigit(TotalPJL);
            Integer TotalPLT = getTotalPLT();
            String TotalPLTS = Intformatdigit(TotalPLT);
            Integer TotalSelisih = getTotalSelisih();
            String TotalSelisihS;
            if (TotalSelisih <= 0) {
                TotalSelisihS = Intformatdigit(TotalSelisih);
            } else {
                TotalSelisihS = "+" + Intformatdigit(TotalSelisih);
            }

            String leftAlignFormat = "%-5s%-25s%-13s%-6s%-9s%-9s%-12s%-1s%n";
            String OutFormat = "";
            OutFormat += format("%-80s%n", " _____________________________________________________________________________");
            OutFormat += format("%-80s%n", " Tanda Penerimaan Barang");
            OutFormat += format("%-53s%-27s%n", " ", "     Tanggal : " + Tanggal);
            OutFormat += format("%-53s%-27s%n", " Pemasok : " + Pemasok, "No Penerimaan: " + NoPenerimaan);
            //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
            //                              12341234567890123456789012345678901234567890123456712345678912345671234567890123
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            OutFormat += format("%-80s%n", " | NO| NAMA BARANG            |    PLAT    | SAK | NET PJL| NET PLT|    KET    |");
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            for (int i = 0; i < 12; i++) {
                if (i < JTable.getRowCount()) {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + Barang[i], "| " + Plat[i], "|" + format("%4s", Karungs[i]), "|" + format("%7s", NettoPJLS[i]), "|" + format("%7s", NettoPLTS[i]), "|" + format("%10s", Ket[i]), "|");
                } else {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "|", "|", "|", "|", "|", "|", "|", "|");
                }
            }
            OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
            OutFormat += format("%-49s%-9s%-9s%-12s%-1s%n", " | TOTAL ", "|" + format("%7s", TotalPJLS), "|" + format("%7s", TotalPLTS), "| " + format("%9s", TotalSelisihS + " KG"), "|");
            OutFormat += format("%-80s%n", " +-----------------------------------------------------------------+-----------+");
            //OutFormat += format("%-80s%n", " Terbilang : " + terbilang);
            OutFormat += format("%n", "");
            OutFormat += format("%-66s%-24s%n", " Disiapkan Oleh", "Diperiksa Oleh \n \n ");
            OutFormat += format("%-66s%-24s%n", " " + "    HENDRI", " Stock Keeper");
            OutFormat += format("%-80s%n", " _____________________________________________________________________________");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            directprinting(OutFormat);
            //System.out.println(OutFormat);
        }
    }

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
        String pattern = "#,###,###";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        if (value <= -1) {
            value = abs(value);
            return "-" + myFormatter.format(value);
        } else if (value < 0 && value > -1) {
            value = abs(value);
            return "-0" + myFormatter.format(value);
        } else if (value < 1 && value >= 0) {
            return "0" + myFormatter.format(value);
        } else {
            return myFormatter.format(value);
        }
    }

    String Decformatdigit(double Number) {
        double value = 0;
        value = Number;
        String pattern = "#,###,###.0";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        if (value <= -1) {
            value = abs(value);
            return "-" + myFormatter.format(value);
        } else if (value < 0 && value > -1) {
            value = abs(value);
            return "-0" + myFormatter.format(value);
        } else if (value < 1 && value >= 0) {
            return "0" + myFormatter.format(value);
        } else {
            return myFormatter.format(value);
        }
    }

    Integer getTotalPLT() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            if (!JTable.getValueAt(x, 1).toString().contains("ODIUM")) {
                GrandTotal = GrandTotal + Integer.valueOf(JTable.getValueAt(x, 5).toString().replace(".", ""));
            }
        }
        return GrandTotal;
    }

    Double getTotalPLTPlastik() {
        double GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + Double.valueOf(JTable.getValueAt(x, 5).toString().replace(".", "").replace(",", "."));
        }
        return GrandTotal;
    }

    Integer getTotalPJL() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            String PJL = JTable.getValueAt(x, 4).toString().replace(".", "");
            if (PJL.equals("")) {
                PJL = "0";
            }
            GrandTotal = GrandTotal + Integer.valueOf(PJL);
        }
        return GrandTotal;
    }

    double getTotalPJLPlastik() {
        double GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            String PJL = JTable.getValueAt(x, 4).toString().replace(".", "").replace(",", ".");
            if (PJL.equals("")) {
                PJL = "0";
            }
            GrandTotal = GrandTotal + Double.valueOf(PJL);
        }
        return GrandTotal;
    }

    Integer getTotalSelisih() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            String selisih = JTable.getValueAt(x, 6).toString().replace(".", "").split("\\ KG")[0];
            if (selisih.equals("")) {
                selisih = "0";
            }
            GrandTotal = GrandTotal + Integer.valueOf(selisih);
        }
        return GrandTotal;
    }

    Double getTotalSelisihPlastik() {
        double GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            String selisih = JTable.getValueAt(x, 6).toString().replace(".", "").replace(",", ".").split("\\ KG")[0];
            if (selisih.equals("")) {
                selisih = "0";
            }
            GrandTotal = GrandTotal + Double.valueOf(selisih);
        }
        return GrandTotal;
    }

}
