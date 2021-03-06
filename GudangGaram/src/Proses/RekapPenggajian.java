/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import GlobalVar.Terbilang;
import KomponenGUI.FDateF;
import static KomponenGUI.FDateF.datetostr;
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
public class RekapPenggajian extends javax.swing.JFrame {

    /**
     * Creates new form ListPenggajian
     */
    public RekapPenggajian() {
        initComponents();
        setVisible(true);
        setTitle("Print Rekap Gaji Borongan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    Double getGrandTotal() {
        double GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + (Double.valueOf(JTable.getValueAt(x, 4).toString().replace(".", "").replace(",", ".")));
        }
        return GrandTotal;
    }

    /*public static int getDaysInMonth(String year, String monthNumber) {
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
    }*/

 /*Boolean isFirstSaturday(String year, String month) {
        Calendar cacheCalendar = Calendar.getInstance();
        cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cacheCalendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        cacheCalendar.set(Calendar.YEAR, Integer.parseInt(year));
        String date = FDateF.datetostr(cacheCalendar.getTime(), "dd-MM-yyyy");
        return date.equals(FDateF.datetostr(new Date(), "dd-MM-yyyy"));
    }*/
    void loadBonus() {
        /*if (JCBBonusBulanan.isSelected()) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal panggil data bonus");
            dRunSelctOne.setQuery("SELECT COUNT(`Hadir`) as 'Jebol' FROM `tbabsen` WHERE `IdKaryawan` = (SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + jcomboboxF1.getSelectedItem() + "') AND `Tanggal` BETWEEN DATE_FORMAT(CURDATE() - INTERVAL 1 MONTH, '%Y-%m-01') AND DATE_FORMAT(CURDATE() - INTERVAL 1 MONTH, '%Y-%m-31') AND `Hadir` = 0 ");
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
        }*/
    }

    void tambahTabel() {
        if (checkTable()) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JTKeterangan.getText(), Intformatdigit(JTJumlah.getInt()), Intformatdigit(JTRupiah.getInt()), Intformatdigit(JTJumlah.getInt() * JTRupiah.getInt())});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah");
            JTKeterangan.requestFocus();
            RefreshTbl();
            JTGrandTotal.setText(Decformatdigit(getGrandTotal()));
        }
    }

    void RefreshTbl() {
        JTKeterangan.setText("");
        JTJumlah.setText("0");
        JTRupiah.setText("0");
    }

    boolean checkTable() {
        if (JTKeterangan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Keterangan Tambahan Tidak Boleh Kosong");
            return false;
        } else if (JTJumlah.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            return false;
        } else if (JTRupiah.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Rupiah Tidak Boleh Kosong");
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
        JDTanggal1 = new KomponenGUI.JdateCF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        JDTanggal2 = new KomponenGUI.JdateCF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        JTKeterangan = new KomponenGUI.JtextF();
        JTGrandTotal = new KomponenGUI.JtextF();
        JCBBonus = new KomponenGUI.JCheckBoxF();
        JTAKeterangan1 = new KomponenGUI.JtextF();
        JTAKeterangan2 = new KomponenGUI.JtextF();
        JTAKeterangan3 = new KomponenGUI.JtextF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        JTJumlah = new KomponenGUI.JRibuanTextField();
        JTRupiah = new KomponenGUI.JRibuanTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("Periode");

        jlableF2.setText(":");

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

        new JScrollPane(JTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Keterangan", "Jumlah", "@ Rupiah", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(JTable);
        JTable.setrender(new int[]{2,3,4}, new String[]{"Number","Number","Number"});
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
            JTable.getColumnModel().getColumn(2).setMinWidth(100);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(2).setMaxWidth(100);
            JTable.getColumnModel().getColumn(3).setMinWidth(100);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(3).setMaxWidth(100);
            JTable.getColumnModel().getColumn(4).setMinWidth(100);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(4).setMaxWidth(100);
        }

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

        jlableF9.setText("Total");

        jlableF10.setText(":");

        JTKeterangan.setMaxText(30);
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
        });

        JTGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTGrandTotal.setText("0");
        JTGrandTotal.setEnabled(false);

        JCBBonus.setSelected(false);
        JCBBonus.setText("Tambah Bonus Bulanan");
        JCBBonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBBonusActionPerformed(evt);
            }
        });

        JTAKeterangan1.setText("Keterangan (Jika ada tambahan)");
        JTAKeterangan1.setEnabled(false);

        JTAKeterangan2.setText("Jumlah");
        JTAKeterangan2.setEnabled(false);

        JTAKeterangan3.setText("@ Rupiah");
        JTAKeterangan3.setEnabled(false);

        jbuttonF3.setText("Tambah");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jbuttonF4.setText("Refresh");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        JTJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahKeyPressed(evt);
            }
        });

        JTRupiah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTRupiahKeyPressed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTAKeterangan1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTAKeterangan2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(JTJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTAKeterangan3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(JTRupiah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbuttonF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbuttonF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                .addComponent(JDTanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(JCBBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTAKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTAKeterangan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTAKeterangan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTRupiah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void JDTanggal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggal1PropertyChange
        hitungBorongan();
    }//GEN-LAST:event_JDTanggal1PropertyChange

    private void JDTanggal2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggal2PropertyChange
        hitungBorongan();
    }//GEN-LAST:event_JDTanggal2PropertyChange

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        printBorongan();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.rekapPenggajian = null;
    }//GEN-LAST:event_formWindowClosed

    private void JCBBonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBBonusActionPerformed
        hitungBorongan();
    }//GEN-LAST:event_JCBBonusActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        tambahTabel();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        RefreshTbl();
        hitungBorongan();
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlah.requestFocus();
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void JTJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTRupiah.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahKeyPressed

    private void JTRupiahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTRupiahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tambahTabel();
        }
    }//GEN-LAST:event_JTRupiahKeyPressed

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
            java.util.logging.Logger.getLogger(RekapPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RekapPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RekapPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RekapPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RekapPenggajian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JCheckBoxF JCBBonus;
    private KomponenGUI.JdateCF JDTanggal1;
    private KomponenGUI.JdateCF JDTanggal2;
    private KomponenGUI.JtextF JTAKeterangan1;
    private KomponenGUI.JtextF JTAKeterangan2;
    private KomponenGUI.JtextF JTAKeterangan3;
    private KomponenGUI.JtextF JTGrandTotal;
    private KomponenGUI.JRibuanTextField JTJumlah;
    private KomponenGUI.JtextF JTKeterangan;
    private KomponenGUI.JRibuanTextField JTRupiah;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    void hitungBorongan() {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        String queryBonus = " UNION ALL (SELECT IF(`Bonus`=130000,'BONUS FULL BEKERJA ','BONUS TIDAK FULL BEKERJA ') as 'Keterangan', COUNT(`Bonus`) as 'Jumlah', FORMAT(`Bonus`,0) as 'Upah', FORMAT(COUNT(`Bonus`)*`Bonus`,0) as 'Sub Total' FROM (SELECT a.`IdKaryawan`, IF(COUNT(`Hadir`)<=1,130000,IF(COUNT(`Hadir`)=2,65000,0)) as 'Bonus', `IdJenisKaryawan`, a.`Keterangan`, `Status` FROM `tbmkaryawan`a LEFT JOIN (SELECT `IdKaryawan`, `Hadir` FROM `tbabsen` WHERE hadir=0 AND `Tanggal` BETWEEN DATE_FORMAT('"+FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd")+"', '%Y-%m-01') AND DATE_FORMAT('"+FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd")+"', '%Y-%m-31') AND WEEKDAY(`Tanggal`)!=6)b ON a.`IdKaryawan`=b.`IdKaryawan` WHERE 1  AND `IdJenisKaryawan` = 2 AND `Status` = 1 GROUP BY a.`IdKaryawan`) AS `tbtemp` WHERE `Bonus` != 0 GROUP BY `Bonus`) ";
        if (!JCBBonus.isSelected()) {
            queryBonus = "";
        }
        runSelct.setQuery("SELECT * FROM (SELECT CONCAT('UPAH PACKING ',a.`NamaBarang`) as `Keterangan`, FORMAT(IFNULL(SUM(`JumlahHasil`),0),0) as 'JumlahHasil', FORMAT(IFNULL(`UpahPerPak`,0),0) as 'UpahPerPak', FORMAT(IFNULL(SUM(`JumlahHasil`)*`UpahPerPak`,0),0) as 'SubTotal' FROM `tbmbarang`a LEFT JOIN `tbpacking`b ON a.`IdBarang`=b.`IdBarangHasil`  WHERE a.`NamaBarang` NOT LIKE '%@50%' AND `Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' GROUP BY `NamaBarang` ORDER BY `NamaBarang`) AS A UNION ALL SELECT a.`Keterangan`, COUNT(a.`Keterangan`) as 'Jumlah',  FORMAT(`UangDinas`,0) as 'Rupiah', FORMAT(SUM(`UangDinas`),0) as 'Sub Total' FROM `tbdinasluar`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` WHERE `Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' GROUP BY `Keterangan` UNION ALL SELECT 'TUNJ. TRANSPORT & UANG MAKAN ' as 'Keterangan', FORMAT(SUM(IF(WEEKDAY(`Tanggal`)=6,`Hadir`+1,`Hadir`)),0) as 'Jumlah', FORMAT(17500,0) as 'Upah', FORMAT((SUM(IF(WEEKDAY(`Tanggal`)=6,`Hadir`+1,`Hadir`)) * 17500),0) as 'Sub Total' FROM `tbabsen`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` WHERE a.`Tanggal` BETWEEN '" + FDateF.datetostr(JDTanggal1.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggal2.getDate(), "yyyy-MM-dd") + "' AND `Hadir` = 1 AND `StatusUangMakan` = 0 AND `IdJenisKaryawan` = 2 AND `Status` = 1 " + queryBonus);
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", "", ""});
                JTable.setValueAt(row + 1, row, 0);
                JTable.setValueAt(rs.getString(1), row, 1);
                JTable.setValueAt(rs.getString(2).replace(",", "."), row, 2);
                JTable.setValueAt(rs.getString(3).replace(",", "."), row, 3);
                JTable.setValueAt(rs.getString(4).replace(",", "."), row, 4);
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
        JTGrandTotal.setText(Decformatdigit(getGrandTotal()));
    }

    void printBorongan() {
        String Periode1 = datetostr(JDTanggal1.getDate(), "dd-MM-yyyy");
        String Periode2 = datetostr(JDTanggal2.getDate(), "dd-MM-yyyy");
        String[] No = new String[JTable.getRowCount()];
        String[] Barang = new String[JTable.getRowCount()];
        Integer[] Jumlah = new Integer[JTable.getRowCount()];
        String[] Jumlahs = new String[JTable.getRowCount()];
        int[] Upah = new int[JTable.getRowCount()];
        String[] Upahs = new String[JTable.getRowCount()];
        Integer[] Sub = new Integer[JTable.getRowCount()];
        String[] Subs = new String[JTable.getRowCount()];
        for (int i = 0; i < JTable.getRowCount(); i++) {
            No[i] = JTable.getValueAt(i, 0).toString();
            Barang[i] = JTable.getValueAt(i, 1).toString();
            Jumlah[i] = Integer.parseInt(JTable.getValueAt(i, 2).toString().replace(".", ""));
            Jumlahs[i] = Intformatdigit(Jumlah[i]);
            Upah[i] = Integer.parseInt(JTable.getValueAt(i, 3).toString().replace(".", ""));
            Upahs[i] = Intformatdigit(Upah[i]);
            Sub[i] = Integer.parseInt(JTable.getValueAt(i, 4).toString().replace(".", ""));
            Subs[i] = Intformatdigit(Sub[i]);
        }

        String Keterangan = JTKeterangan.getText();

        int Total = (int) Math.round(getGrandTotal());
        String Totals = Intformatdigit(Total);
        Terbilang terbilang = new Terbilang(Total);
        String terbilangg = terbilang.toString();
        String terbilangg2 = terbilang.toString();
        if (terbilangg.length() > 64) {
            terbilangg = terbilangg.substring(0, 64);
        } else {
            terbilangg = terbilangg + " #";
        }
        if (terbilangg2.length() > 64 && terbilangg2.length() < 129) {
            terbilangg2 = terbilangg2.substring(64, terbilangg2.length()) + " #";
        } else if (terbilangg2.length() > 128) {
            terbilangg2 = terbilangg2.substring(64, 128) + " #";
        } else {
            terbilangg2 = "";
        }
        String leftAlignFormat = "%-4s%-33s%-12s%-13s%-16s%-1s%n";
        String OutFormat = "";
        OutFormat += format("%-81s%n", "                     PERMOHONAN PERSETUJUAN PENGELUARAN KAS                     ");
        OutFormat += format("%-81s%n", "                        Untuk Upah Borongan Packing Garam                       ");
        OutFormat += format("%-81s%n", "                        Tanggal " + Periode1 + " s/d " + Periode2 + "                       ");
        OutFormat += format("%n", "");
        //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
        //                              12341234567890123456789012345678901234567890123456712345678912345671234567890123
        OutFormat += format("%-80s%n", "+---+--------------------------------+-----------+------------+---------------+");
        OutFormat += format("%-80s%n", "| NO| KETERANGAN                     |   JUMLAH  |  @ RUPIAH  |   SUB TOTAL   |");
        OutFormat += format("%-80s%n", "+---+--------------------------------+-----------+------------+---------------+");
        for (int i = 0; i < 15; i++) {
            if (i < JTable.getRowCount()) {
                String satuan;
                if (Barang[i].contains("UPAH PACKING")) {
                    satuan = " PAK";
                } else if (Barang[i].contains("UANG MAKAN")) {
                    satuan = "  HR";
                } else if (Barang[i].contains("BONUS") || Barang[i].contains("PELATIHAN")) {
                    satuan = " ORG";
                } else {
                    satuan = "    ";
                }
                OutFormat += format(leftAlignFormat, "| " + (i + 1), "| " + Barang[i], "|" + format("%10s", Jumlahs[i] + satuan), "| Rp" + format("%8s", Upahs[i]), "| Rp" + format("%11s", Subs[i]), "|");
            } else {
                OutFormat += format(leftAlignFormat, "| " + (i + 1), "|", "|", "|", "|", "|");
            }
        }
        OutFormat += format("%-80s%n", "+---+--------------------------------+-----------+------------+---------------+");
        OutFormat += format("%-62s%-16s%-1s%n", "| GRAND TOTAL", "| Rp" + format("%11s", Totals), "|");
        OutFormat += format("%-80s%n", "+-------------------------------------------------------------+---------------+");
        OutFormat += format("%-80s%n", "Terbilang : # " + terbilangg);
        OutFormat += format("%-80s%n", "            " + terbilangg2);
        OutFormat += format("%n", "");
        OutFormat += format("%-80s%n", format("%79s", "TL. DUKU, " + datetostr(new Date(), "dd MMMM yyyy")));
        OutFormat += format("%-33s%-33s%-24s%n", "Disetujui Oleh,", "Diperiksa Oleh,", "Dibuat Oleh,\n \n \n \n ");
        OutFormat += format("%-33s%-33s%-24s%n", "    SUBAGIO", "    ADIANTO", "   ARMAN");
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

}
