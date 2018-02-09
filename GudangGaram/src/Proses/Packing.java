/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import KomponenGUI.FDateF;
import KomponenGUI.JcomboboxF;
import Master.*;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.MultiInsert;
import LSubProces.RunSelct;
import LSubProces.Update;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author richky
 */
public class Packing extends javax.swing.JFrame {

    /**
     * Creates new form MasterPacking
     */
    String NoPacking;

    public Packing() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Packing");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF3.setVisible(false);
        JTNoBak.requestFocus();
        JTNoPacking.setText(generateNoPacking());
    }

    public Packing(Object noPacking) {
        NoPacking = noPacking.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Packing");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF1.setVisible(false);
        jbuttonF2.setVisible(false);
        loadeditdata();
        JCNamaBahan1.requestFocus();
        tableToComponent();
    }

    void loadeditdata() {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPacking`, DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NoBak`, `NoPas`, `NoIndi`, `NamaKaryawan` as 'Nama', c.`AliasBarang` as 'Bahan', `JumlahBahan`, d.`AliasBarang` as 'Hasil', `JumlahHasil`, `UpahPerPak` as 'Upah', a.`Keterangan` FROM `tbpacking`a JOIN `tbmkaryawan`b ON a.`IdKaryawan`=b.`IdKaryawan` JOIN `tbmbarang`c ON a.`IdBarangBahan`=c.`IdBarang` JOIN `tbmbarang`d ON a.`IdBarangHasil`=d.`IdBarang` WHERE `NoPacking` = '" + NoPacking + "' ORDER BY `NoPacking`, `NoIndi`");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                JTNoPacking.setText(rs.getString(1));
                JDTanggal.setDate(FDateF.strtodate(rs.getString(2), "dd-MM-yyyy"));
                model.addRow(new Object[]{"", "", "", "", "", "", "", "", "", "", ""});
                JTable.setValueAt(rs.getString(3), row, 0);
                JTable.setValueAt(rs.getString(4), row, 1);
                JTable.setValueAt(rs.getString(5), row, 2);
                JTable.setValueAt(rs.getString(6), row, 3);
                JTable.setValueAt(rs.getString(7), row, 4);
                JTable.setValueAt(rs.getString(8), row, 6);
                JTable.setValueAt(rs.getString(9), row, 7);
                JTable.setValueAt(rs.getString(10), row, 8);
                JTable.setValueAt(rs.getString(11), row, 9);
                JTable.setValueAt(rs.getString(12), row, 10);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Packing");
        } finally {
            runSelct.closecon();
        }

    }

    Boolean checkInput() {
        if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Terima Tidak Boleh Kosong");
            return false;
        }/* else if (jtextF1.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "No. Timbang Tidak Boleh Kosong");
            return false;
        } else if (JTJumlahBahan.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Brutto Pelita Tidak Boleh Kosong");
            return false;
        } else if (jRibuanTextField2.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Tara Pelita Tidak Boleh Kosong");
            return false;
        } else if (JTUpahPerPack.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Netto Pelita Tidak Boleh Kosong");
            return false;
        } else if (jRibuanTextField4.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Netto Penjual Tidak Boleh Kosong");
            return false;
        } else if (jRibuanTextField5.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Karung Tidak Boleh Kosong");
            return false;
        } else if (jtextF2.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Plat Tidak Boleh Kosong");
            return false;
        } else if (jtextF3.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Pemasok Tidak Boleh Kosong");
            return false;
        }*/ else {
            return true;
        }
    }

    boolean checkTable() {
        if (checkSameItem()) {
            if (JTJumlahBahan1.getInt() == 0) {
                JOptionPane.showMessageDialog(this, "Jumlah Bahan Tidak Boleh Kosong");
                JTJumlahBahan1.requestFocus();
                return false;
            } else if (JTJumlahHasil1.getInt() == 0) {
                JOptionPane.showMessageDialog(this, "Jumlah Hasil Pasangan No. " + JTNoPas1.getText() + " Tidak Boleh Kosong");
                JTJumlahHasil1.requestFocus();
                return false;
            } else if (JTJumlahHasil2.getInt() == 0 && !"".equals(JCNamaKaryawan3.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Jumlah Hasil Pasangan No. " + JTNoPas2.getText() + " Tidak Boleh Kosong");
                JTJumlahHasil2.requestFocus();
                return false;
            } else if ((JTNoPas1.getText().equals("0") || JTNoPas1.getText().equals("")) && (getJumlahKiri() == 1 || getJumlahKiri() == 2)) {
                JOptionPane.showMessageDialog(this, "Silahkan Isi No. Pasangan Sebelah Kiri");
                JTNoPas1.requestFocus();
                return false;
            } else if ((JTNoPas2.getText().equals("0") || JTNoPas2.getText().equals("")) && (getJumlahKanan() == 1 || getJumlahKanan() == 2)) {
                JOptionPane.showMessageDialog(this, "Silahkan Isi No. Pasangan Sebelah Kanan");
                JTNoPas2.requestFocus();
                return false;
            } else if (JCNamaKaryawan1.getSelectedItem().equals("") && !"".equals(JCNamaKaryawan2.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Harap Pindahkan Karyawan No. 2 ke Karyawan No. 1");
                JCNamaKaryawan2.requestFocus();
                return false;
            } else if (JCNamaKaryawan3.getSelectedItem().equals("") && !"".equals(JCNamaKaryawan4.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Harap Pindahkan Karyawan No. 4 ke Karyawan No. 3");
                JCNamaKaryawan4.requestFocus();
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    void RefreshTbl() {
        JTable.clearSelection();
        /*JTJumlah.setText("0");
        JTHargaSatuan.setText("");
        JTKeterangan.setText("");
        JTStock.setText("0,00");*/
    }

    public String generateNoPacking() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPacking = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPacking` FROM `tbpacking` ORDER BY `NoPacking` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPacking = "GG-" + "000001" + "-PG";
            }
            while (rs.next()) {
                String nopenjualan = rs.getString("NoPacking");
                String number = nopenjualan.substring(3, 9);
                //String month = nopenjualan.substring(8, 10);
                int p = 1 + parseInt(number);
                /*if (month.equals(FDateF.datetostr(new Date(), "MM"))) {
                    p = 1 + parseInt(number);
                } else {
                    p = 1;
                }*/
                if (p != 999999) {
                    NoPacking = "GG-" + nf.format(p) + "-PG";
                } else if (p == 999999) {
                    p = 1;
                    NoPacking = "GG-" + nf.format(p) + "-PG";
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Generate Nomor Packing");
        } finally {
            runSelct.closecon();
        }
        return NoPacking;
    }

    void tableToComponent() {
        JTNoBak.setText(JTable.getValueAt(0, 0).toString());
        JCNamaBahan1.setSelectedItem(JTable.getValueAt(0, 4));
        JCNamaHasil.setSelectedItem(JTable.getValueAt(0, 7));
        JTUpahPerPack.setText(JTable.getValueAt(0, 9).toString().replace(".", ""));
        JTNoPas1.setText(JTable.getValueAt(0, 1).toString());
        JCNamaKaryawan1.setSelectedItem(JTable.getValueAt(0, 3));
        JTKeterangan1.setText(JTable.getValueAt(0, 10).toString());
        //====================================================================//
        if (JTable.getRowCount() == 1) {
            JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()))));
            JCNamaBahan2.setSelectedItem("");
            JTJumlahBahan2.setText("0");
            JCNamaKaryawan2.setSelectedItem("");
            JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()))));
            JTNoPas2.setText("0");
            JCNamaKaryawan3.setSelectedItem("");
            JCNamaKaryawan4.setSelectedItem("");
            JTJumlahHasil2.setText("0");
            JTKeterangan2.setText("");
        } //==================================================================//
        else if (JTable.getRowCount() == 2) {
            if (JTable.getValueAt(0, 4).equals(JTable.getValueAt(1, 4))) {
                JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(1, 6).toString()))));
                JCNamaBahan2.setSelectedItem("");
                JTJumlahBahan2.setText("0");

                if (JTable.getValueAt(1, 2).equals("2")) {
                    JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(1, 3));
                    JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                    JTNoPas2.setText("0");
                    JCNamaKaryawan3.setSelectedItem("");
                    JTJumlahHasil2.setText("0");
                } else if (JTable.getValueAt(1, 2).equals("3")) {
                    JCNamaKaryawan2.setSelectedItem("");
                    JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()))));
                    JTNoPas2.setText(JTable.getValueAt(1, 1).toString());
                    JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(1, 3));
                    JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                }
                JCNamaKaryawan4.setSelectedItem("");
                JTKeterangan2.setText(JTable.getValueAt(1, 10).toString());
            } else if (!JTable.getValueAt(0, 4).equals(JTable.getValueAt(1, 4))) {
                JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()))));
                JCNamaBahan2.setSelectedItem(JTable.getValueAt(1, 4));
                JTJumlahBahan2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 6).toString()))));
                JCNamaKaryawan2.setSelectedItem("");
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                JTNoPas2.setText("0");
                JCNamaKaryawan3.setSelectedItem("");
                JCNamaKaryawan4.setSelectedItem("");
                JTJumlahHasil2.setText("0");
                JTKeterangan2.setText("");
            }
        } //==================================================================//
        else if (JTable.getRowCount() == 3) {
            JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(1, 6).toString()) + Double.valueOf(JTable.getValueAt(2, 6).toString()))));
            JCNamaBahan2.setSelectedItem("");
            JTJumlahBahan2.setText("0");
            if (JTable.getValueAt(1, 2).equals("2")) {
                JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(1, 3));
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(2, 3));
                JCNamaKaryawan4.setSelectedItem("");
                JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(2, 8).toString()))));
            } else if (JTable.getValueAt(1, 2).equals("3")) {
                JCNamaKaryawan2.setSelectedItem("");
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()))));
                JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(1, 3));
                JCNamaKaryawan4.setSelectedItem(JTable.getValueAt(2, 3));
                JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 8).toString()) + Double.valueOf(JTable.getValueAt(2, 8).toString()))));
            }
            JTNoPas2.setText(JTable.getValueAt(2, 1).toString());
            JTKeterangan2.setText(JTable.getValueAt(2, 10).toString());
        } //==================================================================//
        else if (JTable.getRowCount() == 4) {
            if (JTable.getValueAt(0, 4).equals(JTable.getValueAt(1, 4))) {
                JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(1, 6).toString()) + Double.valueOf(JTable.getValueAt(2, 6).toString()) + Double.valueOf(JTable.getValueAt(3, 6).toString()))));
                JCNamaBahan2.setSelectedItem("");
                JTJumlahBahan2.setText("0");
                JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(1, 3));
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                JTNoPas2.setText(JTable.getValueAt(3, 1).toString());
                JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(2, 3));
                JCNamaKaryawan4.setSelectedItem(JTable.getValueAt(3, 3));
                JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()))));
                JTKeterangan2.setText(JTable.getValueAt(3, 10).toString());
            } else if (!JTable.getValueAt(0, 4).equals(JTable.getValueAt(1, 4))) {
                JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(2, 6).toString()))));
                JCNamaBahan2.setSelectedItem(JTable.getValueAt(1, 4));
                JTJumlahBahan2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 6).toString()) + Double.valueOf(JTable.getValueAt(3, 6).toString()))));
                if (JTable.getValueAt(2, 2).equals("2")) {
                    JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(2, 3));
                    JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()) + Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()))));
                    JTNoPas2.setText("0");
                    JCNamaKaryawan3.setSelectedItem("");
                    JTJumlahHasil2.setText("0");
                    JTKeterangan2.setText("");
                } else if (JTable.getValueAt(2, 2).equals("3")) {
                    JCNamaKaryawan2.setSelectedItem("");
                    JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                    JTNoPas2.setText(JTable.getValueAt(3, 1).toString());
                    JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(2, 3));
                    JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()))));
                    JTKeterangan2.setText(JTable.getValueAt(3, 10).toString());
                }
                JCNamaKaryawan4.setSelectedItem("");
            }
        } //==================================================================//
        else if (JTable.getRowCount() == 6) {
            JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(2, 6).toString()) + Double.valueOf(JTable.getValueAt(4, 6).toString()))));
            JCNamaBahan2.setSelectedItem(JTable.getValueAt(1, 4));
            JTJumlahBahan2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 6).toString()) + Double.valueOf(JTable.getValueAt(3, 6).toString()) + Double.valueOf(JTable.getValueAt(5, 6).toString()))));
            if (JTable.getValueAt(2, 2).equals("2")) {
                JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(2, 3));
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()) + Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()))));
                JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(4, 3));
                JCNamaKaryawan4.setSelectedItem("");
                JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(4, 8).toString()) + Double.valueOf(JTable.getValueAt(5, 8).toString()))));
            } else if (JTable.getValueAt(2, 2).equals("3")) {
                JCNamaKaryawan2.setSelectedItem("");
                JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()))));
                JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(2, 3));
                JCNamaKaryawan4.setSelectedItem(JTable.getValueAt(4, 3));
                JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()) + Double.valueOf(JTable.getValueAt(4, 8).toString()) + Double.valueOf(JTable.getValueAt(5, 8).toString()))));
            }
            JTNoPas2.setText(JTable.getValueAt(5, 1).toString());
            JTKeterangan2.setText(JTable.getValueAt(5, 10).toString());
        } //==================================================================//
        else if (JTable.getRowCount() == 8) {
            JTJumlahBahan1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 6).toString()) + Double.valueOf(JTable.getValueAt(2, 6).toString()) + Double.valueOf(JTable.getValueAt(4, 6).toString()) + Double.valueOf(JTable.getValueAt(6, 6).toString()))));
            JCNamaBahan2.setSelectedItem(JTable.getValueAt(1, 4));
            JTJumlahBahan2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(1, 6).toString()) + Double.valueOf(JTable.getValueAt(3, 6).toString()) + Double.valueOf(JTable.getValueAt(5, 6).toString()) + Double.valueOf(JTable.getValueAt(7, 6).toString()))));
            JCNamaKaryawan2.setSelectedItem(JTable.getValueAt(2, 3));
            JTJumlahHasil1.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(0, 8).toString()) + Double.valueOf(JTable.getValueAt(1, 8).toString()) + Double.valueOf(JTable.getValueAt(2, 8).toString()) + Double.valueOf(JTable.getValueAt(3, 8).toString()))));
            JTNoPas2.setText(JTable.getValueAt(7, 1).toString());
            JCNamaKaryawan3.setSelectedItem(JTable.getValueAt(4, 3));
            JCNamaKaryawan4.setSelectedItem(JTable.getValueAt(6, 3));
            JTJumlahHasil2.setText(String.valueOf(Math.round(Double.valueOf(JTable.getValueAt(4, 8).toString()) + Double.valueOf(JTable.getValueAt(5, 8).toString()) + Double.valueOf(JTable.getValueAt(6, 8).toString()) + Double.valueOf(JTable.getValueAt(7, 8).toString()))));
            JTKeterangan2.setText(JTable.getValueAt(7, 10).toString());
        }
        DefaultTableModel dm = (DefaultTableModel) JTable.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        tambahtable.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlableF2 = new KomponenGUI.JlableF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jlableF7 = new KomponenGUI.JlableF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        JCNamaBahan1 = new KomponenGUI.JcomboboxF();
        JTJumlahBahan1 = new KomponenGUI.JRibuanTextField();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF4 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        JCNamaHasil = new KomponenGUI.JcomboboxF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF11 = new KomponenGUI.JlableF();
        JCNamaKaryawan1 = new KomponenGUI.JcomboboxF();
        jlableF12 = new KomponenGUI.JlableF();
        jlableF25 = new KomponenGUI.JlableF();
        jlableF26 = new KomponenGUI.JlableF();
        jlableF27 = new KomponenGUI.JlableF();
        jlableF28 = new KomponenGUI.JlableF();
        jlableF29 = new KomponenGUI.JlableF();
        JCNamaKaryawan2 = new KomponenGUI.JcomboboxF();
        JCNamaKaryawan3 = new KomponenGUI.JcomboboxF();
        JCNamaKaryawan4 = new KomponenGUI.JcomboboxF();
        jlableF13 = new KomponenGUI.JlableF();
        jlableF14 = new KomponenGUI.JlableF();
        JTJumlahHasil1 = new KomponenGUI.JRibuanTextField();
        jlableF15 = new KomponenGUI.JlableF();
        jlableF16 = new KomponenGUI.JlableF();
        JTJumlahHasil2 = new KomponenGUI.JRibuanTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        tambahtable = new KomponenGUI.JbuttonF();
        JTUpahPerPack = new KomponenGUI.JRibuanTextField();
        jlableF17 = new KomponenGUI.JlableF();
        jlableF18 = new KomponenGUI.JlableF();
        jlableF19 = new KomponenGUI.JlableF();
        jlableF20 = new KomponenGUI.JlableF();
        JTKeterangan1 = new KomponenGUI.JtextF();
        jlableF21 = new KomponenGUI.JlableF();
        jlableF22 = new KomponenGUI.JlableF();
        JTKeterangan2 = new KomponenGUI.JtextF();
        jlableF30 = new KomponenGUI.JlableF();
        JTNoBak = new KomponenGUI.JRibuanTextField();
        jlableF32 = new KomponenGUI.JlableF();
        JTNoPas1 = new KomponenGUI.JRibuanTextField();
        jlableF33 = new KomponenGUI.JlableF();
        JTNoPas2 = new KomponenGUI.JRibuanTextField();
        jlableF31 = new KomponenGUI.JlableF();
        jlableF34 = new KomponenGUI.JlableF();
        JCNamaBahan2 = new KomponenGUI.JcomboboxF();
        JTJumlahBahan2 = new KomponenGUI.JRibuanTextField();
        jlableF35 = new KomponenGUI.JlableF();
        jlableF36 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF1 = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        JTNoPacking = new KomponenGUI.JtextF();
        jlableF10 = new KomponenGUI.JlableF();
        tambahtable1 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlableF2.setText("Nama Bahan 1");

        jbuttonF1.setText("Simpan");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Simpan & Tutup");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF4.setText("Kembali");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        jlableF7.setText(":");

        jbuttonF3.setText("Ubah");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        JCNamaBahan1.load("SELECT `AliasBarang` FROM `tbmbarang` WHERE `IdJenisBarang` = 1");
        JCNamaBahan1.setNextFocusableComponent(JTJumlahBahan1);
        JCNamaBahan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBahan1KeyPressed(evt);
            }
        });

        JTJumlahBahan1.setNextFocusableComponent(JCNamaBahan2);
        JTJumlahBahan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahBahan1KeyPressed(evt);
            }
        });

        JDTanggal.setDate(new Date());
        JDTanggal.setDateFormatString("dd-MM-yyyy");
        JDTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalKeyPressed(evt);
            }
        });

        jlableF23.setText("Tanggal");

        jlableF24.setText(":");

        jlableF4.setText("Nama Hasil");

        jlableF8.setText(":");

        JCNamaHasil.load("SELECT `AliasBarang` FROM `tbmbarang` WHERE `IdJenisBarang` = 2");
        JCNamaHasil.setNextFocusableComponent(JTUpahPerPack);
        JCNamaHasil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCNamaHasilItemStateChanged(evt);
            }
        });
        JCNamaHasil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaHasilKeyPressed(evt);
            }
        });

        jlableF5.setText("Nama Karyawan");

        jlableF11.setText(":");

        JCNamaKaryawan1.load("SELECT '' as 'NamaKaryawan' UNION SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `IdJenisKaryawan` = 2");
        JCNamaKaryawan1.setSelectedItem("AMBAR");
        JCNamaKaryawan1.setNextFocusableComponent(JCNamaKaryawan2);
        JCNamaKaryawan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawan1KeyPressed(evt);
            }
        });

        jlableF12.setText("Nama Karyawan");

        jlableF25.setText(":");

        jlableF26.setText(":");

        jlableF27.setText("Nama Karyawan");

        jlableF28.setText("Nama Karyawan");

        jlableF29.setText(":");

        JCNamaKaryawan2.load("SELECT '' as 'NamaKaryawan' UNION SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `IdJenisKaryawan` = 2");
        JCNamaKaryawan2.setSelectedItem("MUSLINA");
        JCNamaKaryawan2.setNextFocusableComponent(JTJumlahHasil1);
        JCNamaKaryawan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawan2KeyPressed(evt);
            }
        });

        JCNamaKaryawan3.load("SELECT '' as 'NamaKaryawan' UNION SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `IdJenisKaryawan` = 2");
        JCNamaKaryawan3.setSelectedItem("SINAP");
        JCNamaKaryawan3.setNextFocusableComponent(JCNamaKaryawan4);
        JCNamaKaryawan3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawan3KeyPressed(evt);
            }
        });

        JCNamaKaryawan4.load("SELECT '' as 'NamaKaryawan' UNION SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `IdJenisKaryawan` = 2");
        JCNamaKaryawan4.setSelectedItem("KAYATI");
        JCNamaKaryawan4.setNextFocusableComponent(JTJumlahHasil2);
        JCNamaKaryawan4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawan4KeyPressed(evt);
            }
        });

        jlableF13.setText("Jumlah Hasil");

        jlableF14.setText(":");

        JTJumlahHasil1.setNextFocusableComponent(JTKeterangan1);
        JTJumlahHasil1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahHasil1KeyPressed(evt);
            }
        });

        jlableF15.setText("Jumlah Hasil");

        jlableF16.setText(":");

        JTJumlahHasil2.setNextFocusableComponent(JTKeterangan2);
        JTJumlahHasil2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahHasil2KeyPressed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Bak", "No Pas", "No Indi", "Nama Karyawan", "Bahan", "%", "Jumlah Bahan", "Hasil", "Jumlah Hasil", "Upah", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.setColumnSelectionAllowed(true);
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTable);
        JTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setResizable(false);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(1).setResizable(false);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(2).setResizable(false);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(3).setResizable(false);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            JTable.getColumnModel().getColumn(4).setResizable(false);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(220);
            JTable.getColumnModel().getColumn(5).setResizable(false);
            JTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(6).setResizable(false);
            JTable.getColumnModel().getColumn(6).setPreferredWidth(85);
            JTable.getColumnModel().getColumn(7).setResizable(false);
            JTable.getColumnModel().getColumn(7).setPreferredWidth(200);
            JTable.getColumnModel().getColumn(8).setResizable(false);
            JTable.getColumnModel().getColumn(8).setPreferredWidth(80);
            JTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(10).setResizable(false);
        }

        tambahtable.setText("HITUNG");
        tambahtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtableActionPerformed(evt);
            }
        });

        JTUpahPerPack.setEnabled(false);
        JTUpahPerPack.setNextFocusableComponent(JTNoPas1);
        JTUpahPerPack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTUpahPerPackKeyPressed(evt);
            }
        });

        jlableF17.setText(":");

        jlableF18.setText("Upah Per Pack");

        jlableF19.setText("Keterangan");

        jlableF20.setText(":");

        JTKeterangan1.setNextFocusableComponent(JTNoPas2);
        JTKeterangan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeterangan1KeyPressed(evt);
            }
        });

        jlableF21.setText("Keterangan");

        jlableF22.setText(":");

        JTKeterangan2.setNextFocusableComponent(tambahtable);
        JTKeterangan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeterangan2KeyPressed(evt);
            }
        });

        jlableF30.setText("Bak No.");
        jlableF30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        JTNoBak.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        JTNoBak.setText("1");
        JTNoBak.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JTNoBak.setNextFocusableComponent(JCNamaBahan1);
        JTNoBak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoBakKeyPressed(evt);
            }
        });

        jlableF32.setText("Pasangan No.");

        JTNoPas1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        JTNoPas1.setText("1");
        JTNoPas1.setNextFocusableComponent(JCNamaKaryawan1);
        JTNoPas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPas1KeyPressed(evt);
            }
        });

        jlableF33.setText("Pasangan No.");

        JTNoPas2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        JTNoPas2.setText("2");
        JTNoPas2.setNextFocusableComponent(JCNamaKaryawan3);
        JTNoPas2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTNoPas2FocusLost(evt);
            }
        });
        JTNoPas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPas2KeyPressed(evt);
            }
        });

        jlableF31.setText("Nama Bahan 2");

        jlableF34.setText(":");

        JCNamaBahan2.load("SELECT '' as 'AliasBarang' UNION SELECT `AliasBarang` FROM `tbmbarang` WHERE `IdJenisBarang` = 1");
        JCNamaBahan2.setNextFocusableComponent(JTJumlahBahan2);
        JCNamaBahan2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCNamaBahan2ItemStateChanged(evt);
            }
        });
        JCNamaBahan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBahan2KeyPressed(evt);
            }
        });

        JTJumlahBahan2.setNextFocusableComponent(JCNamaHasil);
        JTJumlahBahan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahBahan2KeyPressed(evt);
            }
        });

        jlableF35.setText(":");

        jlableF36.setText(":");

        jlableF3.setText("Sak");

        jlableF6.setText("Sak");

        jlableF1.setText("No. Packing");

        jlableF9.setText(":");

        JTNoPacking.setEnabled(false);
        JTNoPacking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPackingKeyPressed(evt);
            }
        });

        jlableF10.setForeground(new java.awt.Color(255, 0, 255));
        jlableF10.setText("#JIKA TABEL DIKLIK, MAKA DATA AKAN PINDAH KE KOMPONEN DIATAS#");

        tambahtable1.setText("REFRESH");
        tambahtable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtable1ActionPerformed(evt);
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
                        .addGap(486, 486, 486)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlableF33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlableF36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCNamaKaryawan3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTNoPas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF28, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCNamaKaryawan4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTJumlahHasil2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(252, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlableF30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(JTNoBak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTJumlahBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF31, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaBahan2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTJumlahBahan2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF32, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTNoPas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTJumlahHasil1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTKeterangan1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTUpahPerPack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jlableF23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTNoPacking, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tambahtable1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tambahtable, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNoBak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCNamaBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTJumlahBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCNamaBahan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTJumlahBahan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCNamaHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTUpahPerPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNoPas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNoPas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNoPacking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJumlahHasil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJumlahHasil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKeterangan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tambahtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tambahtable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        tambahData(false);
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        tambahData(true);
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        ubahData();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        if (NoPacking == null) {
            GlobalVar.Var.tambahPacking.dispose();
            GlobalVar.Var.tambahPacking = null;
        } else {
            GlobalVar.Var.ubahPacking.dispose();
            GlobalVar.Var.ubahPacking = null;
        }
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (NoPacking == null) {
            GlobalVar.Var.tambahPacking = null;
        } else {
            GlobalVar.Var.ubahPacking = null;
        }
    }//GEN-LAST:event_formWindowClosing

    private void JCNamaBahan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBahan1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahBahan1.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBahan1KeyPressed

    private void JDTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBahan1.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JTJumlahBahan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahBahan1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBahan2.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahBahan1KeyPressed

    private void JCNamaHasilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaHasilKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNoPas1.requestFocus();
        }
    }//GEN-LAST:event_JCNamaHasilKeyPressed

    private void JCNamaKaryawan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawan1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaKaryawan2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JCNamaKaryawan1.setSelectedItem("");
        }
    }//GEN-LAST:event_JCNamaKaryawan1KeyPressed

    private void JCNamaKaryawan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawan2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahHasil1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JCNamaKaryawan2.setSelectedItem("");
        }
    }//GEN-LAST:event_JCNamaKaryawan2KeyPressed

    private void JCNamaKaryawan3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawan3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaKaryawan4.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JCNamaKaryawan3.setSelectedItem("");
        }
    }//GEN-LAST:event_JCNamaKaryawan3KeyPressed

    private void JCNamaKaryawan4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawan4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahHasil2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JCNamaKaryawan4.setSelectedItem("");
        }
    }//GEN-LAST:event_JCNamaKaryawan4KeyPressed

    private void JTJumlahHasil1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahHasil1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan1.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahHasil1KeyPressed

    private void JTJumlahHasil2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahHasil2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan2.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahHasil2KeyPressed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        if (JTable.getSelectedRow() != -1) {
            tableToComponent();
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void tambahtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtableActionPerformed
        TambahTabel();
    }//GEN-LAST:event_tambahtableActionPerformed

    private void JTUpahPerPackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTUpahPerPackKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTUpahPerPackKeyPressed

    private void JTNoBakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoBakKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBahan1.requestFocus();
        }
    }//GEN-LAST:event_JTNoBakKeyPressed

    private void JCNamaHasilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCNamaHasilItemStateChanged
        loadUpah();
    }//GEN-LAST:event_JCNamaHasilItemStateChanged

    private void JTNoPas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPas1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaKaryawan1.requestFocus();
        }
    }//GEN-LAST:event_JTNoPas1KeyPressed

    private void JTNoPas2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPas2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaKaryawan3.requestFocus();
        }
    }//GEN-LAST:event_JTNoPas2KeyPressed

    private void JCNamaBahan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBahan2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahBahan2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JCNamaBahan2.setSelectedItem("");
        }
    }//GEN-LAST:event_JCNamaBahan2KeyPressed

    private void JTJumlahBahan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahBahan2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaHasil.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahBahan2KeyPressed

    private void JTKeterangan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeterangan1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNoPas2.requestFocus();
        }
    }//GEN-LAST:event_JTKeterangan1KeyPressed

    private void JTKeterangan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeterangan2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && tambahtable.isEnabled()) {
            TambahTabel();
        }
    }//GEN-LAST:event_JTKeterangan2KeyPressed

    private void JTNoPackingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPackingKeyPressed

    }//GEN-LAST:event_JTNoPackingKeyPressed

    private void JTNoPas2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTNoPas2FocusLost
        if (JTNoPas2.getText().equals("0")) {
            JCNamaKaryawan3.setSelectedItem("");
            JCNamaKaryawan4.setSelectedItem("");
            JTJumlahHasil2.setText("0");
            JTKeterangan2.setText("");
        }
    }//GEN-LAST:event_JTNoPas2FocusLost

    private void tambahtable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtable1ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) JTable.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        tambahtable.setEnabled(true);
    }//GEN-LAST:event_tambahtable1ActionPerformed

    private void JCNamaBahan2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCNamaBahan2ItemStateChanged
        if (JCNamaBahan2.getSelectedItem().equals("")) {
            JTJumlahBahan2.setText("0");
        }
    }//GEN-LAST:event_JCNamaBahan2ItemStateChanged

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
            java.util.logging.Logger.getLogger(Packing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Packing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Packing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Packing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Packing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCNamaBahan1;
    private KomponenGUI.JcomboboxF JCNamaBahan2;
    private KomponenGUI.JcomboboxF JCNamaHasil;
    private KomponenGUI.JcomboboxF JCNamaKaryawan1;
    private KomponenGUI.JcomboboxF JCNamaKaryawan2;
    private KomponenGUI.JcomboboxF JCNamaKaryawan3;
    private KomponenGUI.JcomboboxF JCNamaKaryawan4;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JRibuanTextField JTJumlahBahan1;
    private KomponenGUI.JRibuanTextField JTJumlahBahan2;
    private KomponenGUI.JRibuanTextField JTJumlahHasil1;
    private KomponenGUI.JRibuanTextField JTJumlahHasil2;
    private KomponenGUI.JtextF JTKeterangan1;
    private KomponenGUI.JtextF JTKeterangan2;
    private KomponenGUI.JRibuanTextField JTNoBak;
    private KomponenGUI.JtextF JTNoPacking;
    private KomponenGUI.JRibuanTextField JTNoPas1;
    private KomponenGUI.JRibuanTextField JTNoPas2;
    private KomponenGUI.JRibuanTextField JTUpahPerPack;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF11;
    private KomponenGUI.JlableF jlableF12;
    private KomponenGUI.JlableF jlableF13;
    private KomponenGUI.JlableF jlableF14;
    private KomponenGUI.JlableF jlableF15;
    private KomponenGUI.JlableF jlableF16;
    private KomponenGUI.JlableF jlableF17;
    private KomponenGUI.JlableF jlableF18;
    private KomponenGUI.JlableF jlableF19;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF20;
    private KomponenGUI.JlableF jlableF21;
    private KomponenGUI.JlableF jlableF22;
    private KomponenGUI.JlableF jlableF23;
    private KomponenGUI.JlableF jlableF24;
    private KomponenGUI.JlableF jlableF25;
    private KomponenGUI.JlableF jlableF26;
    private KomponenGUI.JlableF jlableF27;
    private KomponenGUI.JlableF jlableF28;
    private KomponenGUI.JlableF jlableF29;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF30;
    private KomponenGUI.JlableF jlableF31;
    private KomponenGUI.JlableF jlableF32;
    private KomponenGUI.JlableF jlableF33;
    private KomponenGUI.JlableF jlableF34;
    private KomponenGUI.JlableF jlableF35;
    private KomponenGUI.JlableF jlableF36;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    private KomponenGUI.JbuttonF tambahtable;
    private KomponenGUI.JbuttonF tambahtable1;
    // End of variables declaration//GEN-END:variables

    void TambahTabel() {
        if (checkTable()) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            if ("".equals(JCNamaBahan2.getSelectedItem())) {

                //1
                if (!"".equals(JCNamaKaryawan1.getSelectedItem())) {
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 1, JCNamaKaryawan1.getSelectedItem(), JCNamaBahan1.getSelectedItem(), getPersen1(), Float.parseFloat(JTJumlahBahan1.getText()) / getJumlahKaryawan(), JCNamaHasil.getSelectedItem(), Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri(), JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                }

                if (!"".equals(JCNamaKaryawan2.getSelectedItem())) {
                    //2
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 2, JCNamaKaryawan2.getSelectedItem(), JCNamaBahan1.getSelectedItem(), getPersen1(), Float.parseFloat(JTJumlahBahan1.getText()) / getJumlahKaryawan(), JCNamaHasil.getSelectedItem(), Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri(), JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                }

                if (!"".equals(JCNamaKaryawan3.getSelectedItem())) {
                    //3
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 3, JCNamaKaryawan3.getSelectedItem(), JCNamaBahan1.getSelectedItem(), getPersen1(), Float.parseFloat(JTJumlahBahan1.getText()) / getJumlahKaryawan(), JCNamaHasil.getSelectedItem(), Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan(), JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                }

                if (!"".equals(JCNamaKaryawan4.getSelectedItem())) {
                    //4
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 4, JCNamaKaryawan4.getSelectedItem(), JCNamaBahan1.getSelectedItem(), getPersen1(), Float.parseFloat(JTJumlahBahan1.getText()) / getJumlahKaryawan(), JCNamaHasil.getSelectedItem(), Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan(), JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                }

            } else {
                if (!"".equals(JCNamaKaryawan1.getSelectedItem())) {
                    //1
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 1, JCNamaKaryawan1.getSelectedItem(), JCNamaBahan1.getSelectedItem(), Math.round(getPersen1() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen1() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri()) * getPersen1() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                    //2
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 1, JCNamaKaryawan1.getSelectedItem(), JCNamaBahan2.getSelectedItem(), Math.round(getPersen2() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen2() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri()) * getPersen2() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                }
                if (!"".equals(JCNamaKaryawan2.getSelectedItem())) {
                    //3
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 2, JCNamaKaryawan2.getSelectedItem(), JCNamaBahan1.getSelectedItem(), Math.round(getPersen1() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen1() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri()) * getPersen1() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                    //4
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas1.getText(), 2, JCNamaKaryawan2.getSelectedItem(), JCNamaBahan2.getSelectedItem(), Math.round(getPersen2() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen2() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil1.getText().replace(".", "")) / getJumlahKiri()) * getPersen2() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan1.getText(),});
                }
                if (!"".equals(JCNamaKaryawan3.getSelectedItem())) {
                    //5
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 3, JCNamaKaryawan3.getSelectedItem(), JCNamaBahan1.getSelectedItem(), Math.round(getPersen1() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen1() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan()) * getPersen1() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                    //6
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 3, JCNamaKaryawan3.getSelectedItem(), JCNamaBahan2.getSelectedItem(), Math.round(getPersen2() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen2() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan()) * getPersen2() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                }
                if (!"".equals(JCNamaKaryawan4.getSelectedItem())) {
                    //7
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 4, JCNamaKaryawan4.getSelectedItem(), JCNamaBahan1.getSelectedItem(), Math.round(getPersen1() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen1() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan()) * getPersen1() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                    //8
                    model.addRow(new Object[]{JTNoBak.getText(), JTNoPas2.getText(), 4, JCNamaKaryawan4.getSelectedItem(), JCNamaBahan2.getSelectedItem(), Math.round(getPersen2() * 100.0) / 100.0, Math.round(((Float.parseFloat(JTJumlahBahan1.getText()) + Float.parseFloat(JTJumlahBahan2.getText())) / getJumlahKaryawan()) * getPersen2() / 100 * 100.0) / 100.0, JCNamaHasil.getSelectedItem(), Math.floor(1000 * ((Float.parseFloat(JTJumlahHasil2.getText().replace(".", "")) / getJumlahKanan()) * getPersen2() / 100) + 0.5) / 1000, JTUpahPerPack.getText(), JTKeterangan2.getText(),});
                }
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hitung");
            RefreshTbl();
            tambahtable.setEnabled(false);
            if (jbuttonF1.isVisible()) {
                jbuttonF1.requestFocus();
            } else {
                jbuttonF3.requestFocus();
            }
        }
    }

    void tambahData(Boolean tutup) {
        if (JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan Hitung Terlebih Dahulu.");
        } else {
            if (checkInput()) {
                boolean Berhasil;
                MultiInsert multiInsert = new MultiInsert();
                Berhasil = multiInsert.OpenConnection();
                if (Berhasil) {
                    Berhasil = multiInsert.setautocomit(false);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbpacking`(`NoPacking`, `Tanggal`, `NoBak`, `NoPas`, `NoIndi`, `IdKaryawan`, `IdBarangBahan`, `JumlahBahan`, `IdBarangHasil`, `JumlahHasil`, `UpahPerPak`, `Keterangan`) VALUES ('" + JTNoPacking.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "','" + JTable.getValueAt(i, 0) + "','" + JTable.getValueAt(i, 1) + "','" + JTable.getValueAt(i, 2) + "',(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 3) + "'),(SELECT `IdBarang` FROM `tbmbarang` WHERE `AliasBarang` = '" + JTable.getValueAt(i, 4) + "'),'" + JTable.getValueAt(i, 6) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `AliasBarang` = '" + JTable.getValueAt(i, 7) + "'),'" + JTable.getValueAt(i, 8) + "','" + JTable.getValueAt(i, 9).toString().replace(".", "") + "', '" + JTable.getValueAt(i, 10) + "')", null);
                        }
                    }
                }
                if (Berhasil == false) {
                    multiInsert.rollback();
                    multiInsert.closecon();
                    JOptionPane.showMessageDialog(this, "Gagal Tambah Data Packing");
                }
                if (Berhasil == true) {
                    JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Packing");
                    multiInsert.Commit();
                    multiInsert.closecon();
                    if (tutup) {
                        GlobalVar.Var.tambahPacking.dispose();
                        GlobalVar.Var.tambahPacking = null;
                    } else {
                        JTNoBak.setText(String.valueOf(Integer.valueOf(JTNoBak.getText()) + 1));
                        JTNoPas1.setText(String.valueOf(Integer.valueOf(JTNoPas1.getText()) + 2));
                        JTNoPas2.setText(String.valueOf(Integer.valueOf(JTNoPas2.getText()) + 2));
                        JTable.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][]{},
                                new String[]{
                                    "No Bak", "No Pas", "No Indi", "Nama Karyawan", "Bahan", "%", "Jumlah Bahan", "Hasil", "Jumlah Hasil", "Upah", "Keterangan"
                                }
                        ));
                        RefreshTbl();
                        JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                        JTable.getColumnModel().getColumn(1).setPreferredWidth(50);
                        JTable.getColumnModel().getColumn(2).setPreferredWidth(50);
                        JTable.getColumnModel().getColumn(3).setPreferredWidth(120);
                        JTable.getColumnModel().getColumn(4).setPreferredWidth(220);
                        JTable.getColumnModel().getColumn(5).setPreferredWidth(50);
                        JTable.getColumnModel().getColumn(6).setPreferredWidth(85);
                        JTable.getColumnModel().getColumn(7).setPreferredWidth(200);
                        JTable.getColumnModel().getColumn(8).setPreferredWidth(80);
                        JTable.getColumnModel().getColumn(9).setPreferredWidth(50);
                        tambahtable.setEnabled(true);
                        JTNoPacking.setText(generateNoPacking());
                        JCNamaKaryawan1.requestFocus();
                    }
                    if (GlobalVar.Var.listPacking != null) {
                        GlobalVar.Var.listPacking.load();
                    }
                }
            }
        }
    }

    void ubahData() {
        if (JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan Hitung Terlebih Dahulu.");
        } else {
            if (checkInput()) {
                boolean Berhasil;
                MultiInsert multiInsert = new MultiInsert();
                Berhasil = multiInsert.OpenConnection();
                if (Berhasil) {
                    Berhasil = multiInsert.setautocomit(false);
                    // query insert luar table
                    //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                    //cek inset gagal / berhasil 
                    // jalankan koding di if paling bawah
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbpacking` WHERE `NoPacking` = '" + NoPacking + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbpacking`(`NoPacking`, `Tanggal`, `NoBak`, `NoPas`, `NoIndi`, `IdKaryawan`, `IdBarangBahan`, `JumlahBahan`, `IdBarangHasil`, `JumlahHasil`, `UpahPerPak`, `Keterangan`) VALUES ('" + JTNoPacking.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "','" + JTable.getValueAt(i, 0) + "','" + JTable.getValueAt(i, 1) + "','" + JTable.getValueAt(i, 2) + "',(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 3) + "'),(SELECT `IdBarang` FROM `tbmbarang` WHERE `AliasBarang` = '" + JTable.getValueAt(i, 4) + "'),'" + JTable.getValueAt(i, 6) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `AliasBarang` = '" + JTable.getValueAt(i, 7) + "'),'" + JTable.getValueAt(i, 8) + "','" + JTable.getValueAt(i, 9).toString().replace(".", "") + "', '" + JTable.getValueAt(i, 10) + "')", null);
                            }
                        }
                    }
                    if (Berhasil == false) {
                        multiInsert.rollback();
                        multiInsert.closecon();
                        JOptionPane.showMessageDialog(this, "Gagal Ubah Data Packing");
                    }
                    if (Berhasil == true) {
                        JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Packing");
                        multiInsert.Commit();
                        multiInsert.closecon();
                        GlobalVar.Var.ubahPacking.dispose();
                        GlobalVar.Var.ubahPacking = null;
                        if (GlobalVar.Var.listPacking != null) {
                            GlobalVar.Var.listPacking.load();
                        }
                    }
                }
            }
        }
    }

    int getJumlahKaryawan() {
        int jumlah = 0;
        if (!"".equals(JCNamaKaryawan1.getSelectedItem())) {
            jumlah++;
        }
        if (!"".equals(JCNamaKaryawan2.getSelectedItem())) {
            jumlah++;
        }
        if (!"".equals(JCNamaKaryawan3.getSelectedItem())) {
            jumlah++;
        }
        if (!"".equals(JCNamaKaryawan4.getSelectedItem())) {
            jumlah++;
        }
        return jumlah;
    }

    int getJumlahKiri() {
        int jumlah = 0;
        if (!"".equals(JCNamaKaryawan1.getSelectedItem())) {
            jumlah++;
        }
        if (!"".equals(JCNamaKaryawan2.getSelectedItem())) {
            jumlah++;
        }
        return jumlah;
    }

    int getJumlahKanan() {
        int jumlah = 0;
        if (!"".equals(JCNamaKaryawan3.getSelectedItem())) {
            jumlah++;
        }
        if (!"".equals(JCNamaKaryawan4.getSelectedItem())) {
            jumlah++;
        }
        return jumlah;
    }

    void loadUpah() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `UpahPacking` FROM `tbmbarang` WHERE `AliasBarang` = '" + JCNamaHasil.getSelectedItem() + "'");
        dRunSelctOne.seterorm("Gagal Load Upah");
        ArrayList<String> list = dRunSelctOne.excute();
        JTUpahPerPack.setText(list.get(0));
    }

    Boolean checkSameItem() {
        String a = JCNamaKaryawan1.getSelectedItem().toString();
        String b = JCNamaKaryawan2.getSelectedItem().toString();
        String c = JCNamaKaryawan3.getSelectedItem().toString();
        String d = JCNamaKaryawan4.getSelectedItem().toString();
        if ((a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d)) && !"".equals(a) && !"".equals(b) && !"".equals(c) && !"".equals(d)) {
            JOptionPane.showMessageDialog(rootPane, "Nama Tidak Boleh Sama");
            return false;
        } else {
            return true;
        }
    }

    float getPersen1() {
        float bahan1 = Float.parseFloat(JTJumlahBahan1.getText().replace(".", ""));
        float bahan2 = Float.parseFloat(JTJumlahBahan2.getText().replace(".", ""));
        return bahan1 / (bahan1 + bahan2) * 100;
    }

    float getPersen2() {
        float bahan1 = Float.parseFloat(JTJumlahBahan1.getText().replace(".", ""));
        float bahan2 = Float.parseFloat(JTJumlahBahan2.getText().replace(".", ""));
        return bahan2 / (bahan1 + bahan2) * 100;
    }

}
