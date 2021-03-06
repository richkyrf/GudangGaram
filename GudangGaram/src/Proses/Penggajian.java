/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import GlobalVar.Terbilang;
import KomponenGUI.FDateF;
import static KomponenGUI.FDateF.datetostr;
import LSubProces.DRunSelctOne;
import LSubProces.RunSelct;
import java.awt.Component;
import java.awt.event.KeyEvent;
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
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import static javax.print.attribute.Size2DSyntax.INCH;
import javax.print.attribute.standard.Copies;
import static javax.print.attribute.standard.MediaSize.findMedia;
import static javax.print.attribute.standard.OrientationRequested.LANDSCAPE;
import javax.print.attribute.standard.PrinterName;
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
public class Penggajian extends javax.swing.JFrame {

    /**
     * Creates new form ListPenggajian
     */
    public Penggajian() {
        initComponents();
        setVisible(true);
        setTitle("Print Gaji Borongan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    Double getGrandTotal() {
        double GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + (Double.valueOf(JTable.getValueAt(x, 5).toString().replace(".", "").replace(",", ".")));
        }
        return GrandTotal;
    }

    public static int getDaysInMonth(String year, String monthNumber) {
        int days = 0;
        if (Integer.parseInt(monthNumber) >= 0 && Integer.parseInt(monthNumber) < 12) {
            try {
                Calendar calendar = Calendar.getInstance();
                int date = 1;
                calendar.set(Integer.parseInt(year), Integer.parseInt(monthNumber) - 1, date);
                days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            } catch (Exception e) {
                if (e != null) {
                    e.printStackTrace();
                }
            }
        }
        return days;
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

    void loadBonus() {
        if (JCBBonusBulanan.isSelected()) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal panggil data bonus");
            dRunSelctOne.setQuery("SELECT COUNT(`Hadir`) as 'Jebol' FROM `tbabsen` WHERE `IdKaryawan` = (SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "') AND `Tanggal` BETWEEN DATE_FORMAT('" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "', '%Y-%m-01') AND DATE_FORMAT('" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "', '%Y-%m-31') AND WEEKDAY(`Tanggal`)!=6 AND `Hadir` = 0 ");
            ArrayList<String> list = dRunSelctOne.excute();
            int bonus;
            if (Integer.valueOf(list.get(0)) <= 1) {
                bonus = 130000;
            } else if (Integer.valueOf(list.get(0)) == 2) {
                bonus = 130000 / 2;
            } else {
                bonus = 0;
            }
            JTBonus.setText(Intformatdigit(bonus));
            JTGrandTotal.setText(Decformatdigit(getGrandTotal() + bonus));
        } else {
            JTBonus.setText("0");
            JTGrandTotal.setText(Decformatdigit(getGrandTotal()));
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
        JDTanggal1 = new KomponenGUI.JdateCF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        JDTanggal2 = new KomponenGUI.JdateCF();
        jcomboboxF1 = new KomponenGUI.JcomboboxF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        JTAKeterangan = new KomponenGUI.JtextF();
        JTGrandTotal = new KomponenGUI.JtextF();
        jlableF12 = new KomponenGUI.JlableF();
        JTBonus = new KomponenGUI.JRibuanTextField();
        JCBBonusBulanan = new KomponenGUI.JCheckBoxF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("Periode");

        jlableF2.setText(":");

        jlableF3.setText("Karyawan");

        jlableF4.setText(":");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -7);
        JDTanggal1.setDate(cal.getTime());
        JDTanggal1.setDateFormatString("dd-MM-yyyy");
        JDTanggal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggal1PropertyChange(evt);
            }
        });
        JDTanggal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggal1KeyPressed(evt);
            }
        });

        jlableF5.setText("Hingga");

        jlableF6.setText(":");

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, -1);
        JDTanggal2.setDate(cal2.getTime());
        JDTanggal2.setDateFormatString("dd-MM-yyyy");
        JDTanggal2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggal2PropertyChange(evt);
            }
        });
        JDTanggal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggal2KeyPressed(evt);
            }
        });

        jcomboboxF1.load("SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `IdJenisKaryawan` = 2 AND `Status` = 1 ORDER BY `NamaKaryawan` ");
        jcomboboxF1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboboxF1ItemStateChanged(evt);
            }
        });

        new JScrollPane(JTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tanggal", "Keterangan", "Jumlah", "Upah", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(JTable);
        JTable.setrender(new int[]{3,4,5}, new String[]{"Number","Number","Number"});
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
            JTable.getColumnModel().getColumn(1).setMinWidth(100);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(1).setMaxWidth(100);
            JTable.getColumnModel().getColumn(3).setMinWidth(100);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(3).setMaxWidth(100);
            JTable.getColumnModel().getColumn(4).setMinWidth(100);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(4).setMaxWidth(100);
            JTable.getColumnModel().getColumn(5).setMinWidth(100);
            JTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jbuttonF1.setText("Print");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jlableF7.setText("Keterangan");

        jlableF8.setText(":");

        jbuttonF2.setText("Kembali");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jlableF9.setText("Total");

        jlableF10.setText(":");

        JTGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTGrandTotal.setText("0");
        JTGrandTotal.setEnabled(false);

        jlableF12.setText(":");

        JTBonus.setEnabled(false);
        JTBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTBonusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTBonusKeyReleased(evt);
            }
        });

        JCBBonusBulanan.setSelected(false);
        JCBBonusBulanan.setText("Bonus Bulanan");
        JCBBonusBulanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBBonusBulananActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDTanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDTanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcomboboxF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(570, 570, 570)
                                        .addComponent(jlableF9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTAKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JCBBonusBulanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTBonus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JDTanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JDTanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboboxF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTAKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBBonusBulanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JDTanggal1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggal1KeyPressed

    }//GEN-LAST:event_JDTanggal1KeyPressed

    private void JDTanggal2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggal2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDTanggal2KeyPressed

    private void jcomboboxF1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboboxF1ItemStateChanged
        hitungBorongan();
        loadBonus();
    }//GEN-LAST:event_jcomboboxF1ItemStateChanged

    private void JDTanggal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggal1PropertyChange
        if (getJenisKaryawan().toLowerCase().equals("harian")) {

        } else {
            hitungBorongan();
        }
    }//GEN-LAST:event_JDTanggal1PropertyChange

    private void JDTanggal2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggal2PropertyChange
        if (getJenisKaryawan().toLowerCase().equals("harian")) {

        } else {
            hitungBorongan();
        }
    }//GEN-LAST:event_JDTanggal2PropertyChange

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        if (getJenisKaryawan().toLowerCase().equals("harian")) {

        } else {
            printBorongan();
        }
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.penggajian = null;
    }//GEN-LAST:event_formWindowClosed

    private void JTBonusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBonusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbuttonF1.requestFocus();
        }
    }//GEN-LAST:event_JTBonusKeyPressed

    private void JTBonusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBonusKeyReleased
        if (!JTBonus.getText().equals("")) {
            JTGrandTotal.setText(Decformatdigit(getGrandTotal() + Double.parseDouble(JTBonus.getText().replace(".", ""))));
        } else {
            JTGrandTotal.setText(Decformatdigit(getGrandTotal()));
        }
    }//GEN-LAST:event_JTBonusKeyReleased

    private void JCBBonusBulananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBBonusBulananActionPerformed
        loadBonus();
        if (JCBBonusBulanan.isSelected()) {
            JTBonus.setEnabled(true);
        } else {
            JTBonus.setEnabled(false);
        }
    }//GEN-LAST:event_JCBBonusBulananActionPerformed

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
            java.util.logging.Logger.getLogger(Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penggajian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JCheckBoxF JCBBonusBulanan;
    private KomponenGUI.JdateCF JDTanggal1;
    private KomponenGUI.JdateCF JDTanggal2;
    private KomponenGUI.JtextF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTBonus;
    private KomponenGUI.JtextF JTGrandTotal;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JcomboboxF jcomboboxF1;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF12;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    String getJenisKaryawan() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `JenisKaryawan` FROM `tbmkaryawan`a JOIN `tbsmjeniskaryawan`b ON a.`IdJenisKaryawan`=b.`IdJenisKaryawan` WHERE `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        return list.get(0);
    }

    void hitungBorongan() {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT * FROM (SELECT DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', CONCAT('UPAH PACKING ',c.`NamaBarang`), FORMAT(SUM(`JumlahHasil`),2) as 'JumlahHasil', FORMAT(`UpahPerPak`,0) as 'UpahPerPak', FORMAT(SUM(`JumlahHasil`)*`UpahPerPak`,2) as 'SubTotal' FROM `tbpacking`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`Idkaryawan` JOIN `tbmbarang`c ON a.`IdBarangHasil`=c.`IdBarang`  WHERE `Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' AND `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "' GROUP BY DATE_FORMAT(`Tanggal`,'%d-%m-%Y'), CONCAT('UPAH PACKING ',c.`NamaBarang`) ORDER BY `Tanggal`) AS A UNION ALL SELECT DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', a.`Keterangan`, 1 as 'Jumlah',  FORMAT(`UangDinas`,0), FORMAT(`UangDinas`,2) FROM `tbdinasluar`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` WHERE `Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' AND `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "' UNION ALL SELECT '' as 'Tanggal', CONCAT('UM TGL ',GROUP_CONCAT(IF(WEEKDAY(`Tanggal`)=6,CONCAT('(',DATE_FORMAT(`Tanggal`,'%d'),'x2)'),DATE_FORMAT(`Tanggal`,'%d')) ORDER BY `Tanggal`)) as 'Keterangan', FORMAT(SUM(IF(WEEKDAY(`Tanggal`)=6,`Hadir`+1,`Hadir`)),0) as 'Jumlah', FORMAT(17500,0) as 'Upah', FORMAT((SUM(IF(WEEKDAY(`Tanggal`)=6,`Hadir`+1,`Hadir`)) * 17500),2) as 'Sub Total' FROM `tbabsen`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` WHERE a.`Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' AND `Hadir` = 1 AND `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "' AND `StatusUangMakan` = 0 GROUP BY `NamaKaryawan` ORDER BY DATE_FORMAT(`Tanggal`,'%Y-%m-%d') ");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", "", ""});
                JTable.setValueAt(row + 1, row, 0);
                JTable.setValueAt(rs.getString(1), row, 1);
                JTable.setValueAt(rs.getString(2), row, 2);
                JTable.setValueAt(rs.getString(3).replace(".", ","), row, 3);
                JTable.setValueAt(rs.getString(4).replace(",", "."), row, 4);
                JTable.setValueAt(rs.getString(5).replace(",", "*").replace(".", ",").replace("*", "."), row, 5);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Perhitungan Upah Packing");
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
        JTGrandTotal.setText(Decformatdigit(getGrandTotal() + JTBonus.getInt()));
    }

    void printBorongan() {
        String Periode1 = datetostr(JDTanggal1.getDate(), "dd-MM-yyyy");
        String Periode2 = datetostr(JDTanggal2.getDate(), "dd-MM-yyyy");
        String Penerima = jcomboboxF1.getSelectedItem().toString();
        String[] No = new String[JTable.getRowCount()];
        String[] Tanggal = new String[JTable.getRowCount()];
        String[] Barang = new String[JTable.getRowCount()];
        Double[] Jumlah = new Double[JTable.getRowCount()];
        String[] Jumlahs = new String[JTable.getRowCount()];
        int[] Upah = new int[JTable.getRowCount()];
        String[] Upahs = new String[JTable.getRowCount()];
        Double[] Sub = new Double[JTable.getRowCount()];
        String[] Subs = new String[JTable.getRowCount()];
        for (int i = 0; i < JTable.getRowCount(); i++) {
            No[i] = JTable.getValueAt(i, 0).toString();
            Tanggal[i] = JTable.getValueAt(i, 1).toString();
            Barang[i] = JTable.getValueAt(i, 2).toString();
            Jumlah[i] = Double.parseDouble(JTable.getValueAt(i, 3).toString().replace(",", "."));
            Jumlahs[i] = Decformatdigit(Jumlah[i]);
            Upah[i] = Integer.parseInt(JTable.getValueAt(i, 4).toString().replace(".", ""));
            Upahs[i] = Intformatdigit(Upah[i]);
            Sub[i] = Double.parseDouble(JTable.getValueAt(i, 5).toString().replace(".", "").replace(",", "."));
            Subs[i] = Decformatdigit(Sub[i]);
        }

        String Keterangan = JTAKeterangan.getText();

        double Total = getGrandTotal();
        String Totals = Decformatdigit(Total + JTBonus.getInt());
        Terbilang terbilang = new Terbilang(Total);
        String terbilangg = terbilang.toString();
        if (terbilangg.length() > 66) {
            terbilangg = terbilangg.substring(0, 66);
        }

        String leftAlignFormat = "%-4s%-13s%-33s%-9s%-8s%-12s%-1s%n";
        String OutFormat = "";
        OutFormat += format("%-81s%n", " _____________________________________________________________________________");
        OutFormat += format("%-61s%-19s%n", " Rincian Pembayaran Gaji Karyawan Borongan", "Periode: " + Periode1);
        OutFormat += format("%-61s%-19s%n", " Nama : " + Penerima, "Hingga : " + Periode2);
        //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
        //                              12341234567890123456789012345678901234567890123456712345678912345671234567890123
        OutFormat += format("%-80s%n", "+---+------------+--------------------------------+--------+-------+-----------+");
        OutFormat += format("%-80s%n", "| NO|  TANGGAL   | KETERANGAN                     | JUMLAH |  UPAH | SUB TOTAL |");
        OutFormat += format("%-80s%n", "+---+------------+--------------------------------+--------+-------+-----------+");
        for (int i = 0; i < 13; i++) {
            if (i < JTable.getRowCount()) {
                OutFormat += format(leftAlignFormat, "| " + (i + 1), "| " + Tanggal[i], "| " + Barang[i], "|" + format("%7s", Jumlahs[i]), "|" + format("%7s", Upahs[i]), "|" + format("%10s", Subs[i]), "|");
            } else if (JTBonus.getInt() > 0 && i == JTable.getRowCount()) {
                String keteranganBonus = "UANG BONUS FULL BEKERJA";
                if (JTBonus.getInt() == 65000) {
                    keteranganBonus = "UANG BONUS 1/2 FULL BEKERJA";
                }
                OutFormat += format(leftAlignFormat, "| " + (i + 1), "| ", "| " + keteranganBonus, "|" + "", "|" + "", "|" + format("%10s", Decformatdigit(JTBonus.getInt())), "|");
            } else {
                OutFormat += format(leftAlignFormat, "| " + (i + 1), "|", "|", "|", "|", "|", "|");
            }
        }
        OutFormat += format("%-80s%n", "+---+------------+--------------------------------+--------+-------+-----------+");
        OutFormat += format("%-67s%-12s%-1s%n", "| GRAND TOTAL", "|" + format("%10s", Totals), "|");
        OutFormat += format("%-80s%n", "+------------------------------------------------------------------+-----------+");
        OutFormat += format("%n", "");
        OutFormat += format("%-66s%-24s%n", "Disiapkan Oleh", "Diterima Oleh \n \n ");
        OutFormat += format("%-66s%-24s%n", "" + "ARMAN", Penerima);
        OutFormat += format("%-80s%n", " _____________________________________________________________________________");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        OutFormat += format("%n", "");
        directprinting(OutFormat);
        if (jcomboboxF1.getSelectedIndex() == jcomboboxF1.getItemCount() - 1) {
            JOptionPane.showMessageDialog(this, jcomboboxF1.getSelectedItem() + " Adalah Karyawan Terakhir.");
        } else {
            jcomboboxF1.setSelectedIndex(jcomboboxF1.getSelectedIndex() + 1);
        }
    }

    /**
     *
     * @param Teks
     */
    public static void directprinting(String Teks) {
        String testprint = Teks;
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
                HashAttributeSet aset = new HashAttributeSet();
                aset.add(new PrinterName("EPSON LX-310", null));
                PrintService[] pservices = PrintServiceLookup.lookupPrintServices(null, aset);
                DocFlavor flavor = AUTOSENSE;
                Doc doc = new SimpleDoc(in, flavor, docs);
                DocPrintJob job = pservices[0].createPrintJob();
                Poles.PrintJobWatcher pjw = new Poles.PrintJobWatcher(job);
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
        if (value < 0) {
            value = abs(value);
            output = "(" + myFormatter.format(value) + ")";
        } else if (value >= 0 && value < 1) {
            output = "0" + myFormatter.format(value);
        } else {
            output = myFormatter.format(value);
        }
        return output.replace(",", ".");
    }

    String Decformatdigit(double Number) {
        double value = 0;
        value = Number;
        String output;
        String pattern = "#,###,###.00";
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

}
