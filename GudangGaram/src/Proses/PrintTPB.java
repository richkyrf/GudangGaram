/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import LSubProces.RunSelct;
import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.abs;
import static java.lang.String.format;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
    String NoTPB;

    public PrintTPB(Object notpb) {
        NoTPB = notpb.toString();
        initComponents();
        setVisible(true);
        setTitle("Print Tanda Penerimaan Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTNoPenerimaan.setText(NoTPB);
        load();
    }

    public PrintTPB() {
        initComponents();
        setVisible(true);
        setTitle("Print Tanda Penerimaan Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        JTNoPenerimaan = new KomponenGUI.JtextF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF27 = new KomponenGUI.JlableF();
        LBNoTransaksi1 = new KomponenGUI.JlableF();
        LBNoTransaksi2 = new KomponenGUI.JlableF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        JTPemasok = new KomponenGUI.JtextF();
        JTTanggal = new KomponenGUI.JtextF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        LBNoTransaksi.setText("No. Penerimaan");

        jlableF26.setText(":");

        JTNoPenerimaan.setEnabled(false);
        JTNoPenerimaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPenerimaanKeyPressed(evt);
            }
        });

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

        jbuttonF1.setText("Print");
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

        JTPemasok.setEnabled(false);
        JTPemasok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTPemasokKeyPressed(evt);
            }
        });

        JTTanggal.setEnabled(false);
        JTTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTTanggalKeyPressed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTNoPenerimaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPenerimaanKeyPressed

    }//GEN-LAST:event_JTNoPenerimaanKeyPressed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void JTPemasokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPemasokKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTPemasokKeyPressed

    private void JTTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTTanggalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTTanggalKeyPressed

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        printing();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.printTPB = null;
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
                new PrintTPB("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JtextF JTNoPenerimaan;
    private KomponenGUI.JtextF JTPemasok;
    private KomponenGUI.JtextF JTTanggal;
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

    void load() {
        String Tanggal = null;
        String Pemasok = null;
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NamaBarang`, `Plat`, `KarungPelita`, `NettoPenjual`, `NettoPelita`, a.`Keterangan`, DATE_FORMAT(`Tanggal`, '%d-%m-%Y') as 'Tanggal', `Pemasok` FROM `tbpenerimaan`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbmpemasok`c ON a.`IdPemasok`=c.`IdPemasok` WHERE `NoPenerimaan` = '" + NoTPB + "' ORDER BY `IdPenerimaan` ASC");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                Tanggal = rs.getString(7);
                Pemasok = rs.getString(8);
                model.addRow(new Object[]{" ", " ", "", "", "", "", ""});
                JTable.setValueAt(row + 1, row, 0);
                JTable.setValueAt(rs.getString(1), row, 1);
                JTable.setValueAt(rs.getString(2), row, 2);
                JTable.setValueAt(rs.getString(3), row, 3);
                JTable.setValueAt(rs.getString(4), row, 4);
                JTable.setValueAt(rs.getString(5), row, 5);
                JTable.setValueAt(rs.getString(6), row, 6);
                row++;
            }
            JTTanggal.setText(Tanggal);
            JTPemasok.setText(Pemasok);
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

    void printing() {
        String Tanggal = JTTanggal.getText();
        String NoPenerimaan = JTNoPenerimaan.getText();
        String Pemasok = JTPemasok.getText();
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
            Plat[i] = JTable.getValueAt(i, 2).toString();
            Karung[i] = Integer.parseInt(JTable.getValueAt(i, 3).toString());
            Karungs[i] = Intformatdigit(Karung[i]);
            NettoPJL[i] = Integer.parseInt(JTable.getValueAt(i, 4).toString());
            NettoPJLS[i] = Intformatdigit(NettoPJL[i]);
            NettoPLT[i] = Integer.parseInt(JTable.getValueAt(i, 5).toString());
            NettoPLTS[i] = Intformatdigit(NettoPLT[i]);
            Ket[i] = JTable.getValueAt(i, 6).toString();
        }

        Integer TotalPJL = getTotalPJL();
        String TotalPJLS = Intformatdigit(TotalPJL);
        Integer TotalPLT = getTotalPLT();
        String TotalPLTS = Intformatdigit(TotalPLT);

        String leftAlignFormat = "%-5s%-25s%-13s%-6s%-9s%-9s%-12s%-1s%n";
        String OutFormat = "";
        OutFormat += format("%-80s%n", " _____________________________________________________________________________");
        OutFormat += format("%-80s%n", " Tanda Penerimaan Barang");
        OutFormat += format("%-53s%-27s%n", " ", "No Penerimaan: " + NoPenerimaan);
        OutFormat += format("%-53s%-27s%n", " Pemasok : " + Pemasok, "     Tanggal : " + Tanggal);
        //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
        //                              12341234567890123456789012345678901234567890123456712345678912345671234567890123
        OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
        OutFormat += format("%-80s%n", " | NO| NAMA BARANG            |    PLAT    | SAK | NET PJL| NET PLT|    KET    |");
        OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
        for (int i = 0; i < 12; i++) {
            if (i < JTable.getRowCount()) {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + Barang[i], "| " + Plat[i], "|" + format("%4s", Karungs[i]), "|" + format("%7s", NettoPJLS[i]), "|" + format("%7s", NettoPLTS[i]), "|" + Ket[i], "|");
            } else {
                OutFormat += format(leftAlignFormat, " | " + (i + 1), "|", "|", "|", "|", "|", "|", "|", "|");
            }
        }
        OutFormat += format("%-80s%n", " +---+------------------------+------------+-----+--------+--------+-----------+");
        OutFormat += format("%-49s%-9s%-9s%-12s%-1s%n", " | TOTAL ", "|" + format("%7s", TotalPJLS), "|" + format("%7s", TotalPLTS), "| ", "|");
        OutFormat += format("%-80s%n", " +-----------------------------------------------------------------+-----------+");
        //OutFormat += format("%-80s%n", " Terbilang : " + terbilang);
        OutFormat += format("%n", "");
        OutFormat += format("%-66s%-24s%n", " Disiapkan Oleh", "Diterima Oleh \n \n ");
        OutFormat += format("%-66s%-24s%n", " " + "HENDRI", " ");
        OutFormat += format("%-80s%n", " _____________________________________________________________________________");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        directprinting(OutFormat);
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
        return output;
    }

    Integer getTotalPLT() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + Integer.valueOf(JTable.getValueAt(x, 5).toString().replace(".", ""));
        }
        return GrandTotal;
    }

    Integer getTotalPJL() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + Integer.valueOf(JTable.getValueAt(x, 4).toString().replace(".", ""));
        }
        return GrandTotal;
    }

}
