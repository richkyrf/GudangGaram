/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import KomponenGUI.FDateF;
import Master.*;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.RunSelct;
import LSubProces.Update;
import LSubProces.UpdateAll;
import java.awt.Color;
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
import javax.swing.UIManager;

/**
 *
 * @author richky
 */
public class Penerimaan extends javax.swing.JFrame {

    /**
     * Creates new form MasterPenerimaan
     */
    String IdEdit;

    public Penerimaan() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Penerimaan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF3.setVisible(false);
        JCNoPartai.requestFocus();
    }

    public Penerimaan(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Penerimaan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF1.setVisible(false);
        jbuttonF2.setVisible(false);
        JCNoPartai.requestFocus();
        loadEditData();
        JTNoPenerimaan.setEnabled(true);
    }

    void loadEditData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `IdPenerimaan` as 'ID', `NoPenerimaan` as 'No. Penerimaan', DATE_FORMAT(a.`Tanggal`,'%d-%m-%Y') as 'Tanggal', `Pemasok`, `Peminta`, `NamaBarang` as 'Barang', a.`IdPartai` as 'No. Partai', `KarungPenjual` as 'Karung PJL', `NettoPenjual` as 'Netto PJL', `NoTimbang` as 'No. Timbang', `Plat`, `KarungPelita` as 'Karung PLT', `BruttoPelita` as 'Brutto PLT', `TaraPelita` as 'Tara PLT', `NettoPelita` as 'Netto PLT', a.`Keterangan`, `SelesaiProduksi` FROM `tbpenerimaan`a JOIN `tbmpartai`b ON a.`Idpartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmpeminta`d ON a.`IdPeminta`=d.`IdPeminta` JOIN `tbmpemasok`e ON c.`IdPemasok`=e.`IdPemasok` WHERE `IdPenerimaan` = " + IdEdit);
        ArrayList<String> list = dRunSelctOne.excute();
        JCNoPartai.load("SELECT '-- Pilih No. Partai --' as 'NoPartai' UNION SELECT `IdPartai` FROM `tbmpartai` WHERE `SelesaiTerima` = 0 OR `IdPartai` = " + list.get(6));
        JTNoPenerimaan.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "dd-MM-yyyy"));
        JTPemasok.setText(list.get(3));
        JCPeminta.setSelectedItem(list.get(4));
        JTNamaBarang.setText(list.get(5));
        JCNoPartai.setSelectedItem(list.get(6));
        JTKarungPenjual.setText(list.get(7));
        JTNettoPenjual.setText(list.get(8));
        JTNoTimbang.setText(list.get(9));
        JCPlat.setSelectedItem(list.get(10));
        JTKarungPelita.setText(list.get(11));
        JTBruttoPelita.setText(list.get(12));
        JTTaraPelita.setText(list.get(13));
        JTNettoPelita.setText(list.get(14));
        JTAKeterangan.setText(list.get(15));
        if (list.get(16).equals("1")) {
            JTKarungPenjual.requestFocus();
            JCNoPartai.setEnabled(false);
            jbuttonF8.setEnabled(false);
        }
        UIManager.put("ComboBox.disabledForeground", Color.blue);
    }

    Boolean checkInput() {
        if (JCNoPartai.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih No. Partai Terlebih Dahulu");
            return false;
        } else if (JTNoPenerimaan.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "No. Penerimaan Tidak Boleh Kosong");
            return false;
        } else if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Terima Tidak Boleh Kosong");
            return false;
        } else if (JTKarungPenjual.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Karung Penjual Tidak Boleh Kosong");
            return false;
        } else if (JTNettoPenjual.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Netto Penjual Tidak Boleh Kosong");
            return false;
        } else if (JTNoTimbang.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "No. Timbang Tidak Boleh Kosong");
            return false;
        } else if (JTKarungPelita.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Karung Pelita Tidak Boleh Kosong");
            return false;
        } else if (JTBruttoPelita.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Brutto Pelita Tidak Boleh Kosong");
            return false;
        } else if (JTTaraPelita.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Tara Pelita Tidak Boleh Kosong");
            return false;
        } else if (JTNettoPelita.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Netto Pelita Tidak Boleh Kosong");
            return false;
        } else if (JCPlat.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Plat Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    void setNoPenerimaan() {
        if (JCNoPartai.getSelectedIndex() != 0) {
            if (JCPeminta.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
                JTNoPenerimaan.setText(generateNoPenerimaanPPN());
            } else {
                JTNoPenerimaan.setText(generateNoPenerimaan());
            }
        }
    }

    String generateNoPenerimaan() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPenerimaan = null;
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmpemasok`d ON c.`IdPemasok`=d.`IdPemasok` WHERE `NoPenerimaan` LIKE '%-PN' AND `Pemasok` = '" + JTPemasok.getText() + "' AND a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        if (list.get(0) != null) {
            NoPenerimaan = list.get(0);
        } else {
            RunSelct runSelct = new RunSelct();
            runSelct.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan` WHERE `NoPenerimaan` LIKE '%-PN' ORDER BY `NoPenerimaan` DESC LIMIT 1");
            try {
                ResultSet rs = runSelct.excute();
                if (!rs.isBeforeFirst()) {
                    NoPenerimaan = "GG-" + "000001" + "-PN";
                }
                while (rs.next()) {
                    String nopenjualan = rs.getString("NoPenerimaan");
                    String number = nopenjualan.substring(3, 9);
                    //String month = nopenjualan.substring(8, 10);
                    int p = 1 + parseInt(number);
                    /*if (month.equals(FDateF.datetostr(new Date(), "MM"))) {
                    p = 1 + parseInt(number);
                } else {
                    p = 1;
                }*/
                    if (p != 999999) {
                        NoPenerimaan = "GG-" + nf.format(p) + "-PN";
                    } else if (p == 999999) {
                        p = 1;
                        NoPenerimaan = "GG-" + nf.format(p) + "-PN";
                    }
                }
            } catch (SQLException e) {
                out.println("E6" + e);
                showMessageDialog(null, "Gagal Generate Nomor Penerimaan");
            } finally {
                runSelct.closecon();
            }
        }
        return NoPenerimaan;
    }

    String generateNoPenerimaanPPN() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPenerimaan = null;
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan`a JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` JOIN `tbmbarang`c ON b.`IdBarang`=c.`IdBarang` JOIN `tbmpemasok`d ON c.`IdPemasok`=d.`IdPemasok` WHERE `NoPenerimaan` LIKE '%-PG' AND `Pemasok` = '" + JTPemasok.getText() + "' AND a.`Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        if (list.get(0) != null) {
            NoPenerimaan = list.get(0);
        } else {
            RunSelct runSelct = new RunSelct();
            runSelct.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan` WHERE `NoPenerimaan` LIKE '%-PG' ORDER BY `NoPenerimaan` DESC LIMIT 1");
            try {
                ResultSet rs = runSelct.excute();
                if (!rs.isBeforeFirst()) {
                    NoPenerimaan = "GG-" + "000001" + "-PG";
                }
                while (rs.next()) {
                    String nopenjualan = rs.getString("NoPenerimaan");
                    String number = nopenjualan.substring(3, 9);
                    //String month = nopenjualan.substring(8, 10);
                    int p = 1 + parseInt(number);
                    /*if (month.equals(FDateF.datetostr(new Date(), "MM"))) {
                    p = 1 + parseInt(number);
                } else {
                    p = 1;
                }*/
                    if (p != 999999) {
                        NoPenerimaan = "GG-" + nf.format(p) + "-PG";
                    } else if (p == 999999) {
                        p = 1;
                        NoPenerimaan = "GG-" + nf.format(p) + "-PG";
                    }
                }
            } catch (SQLException e) {
                out.println("E6" + e);
                showMessageDialog(null, "Gagal Generate Nomor Penerimaan");
            } finally {
                runSelct.closecon();
            }
        }
        return NoPenerimaan;
    }

    void loadDataPartai() {
        if (JCNoPartai.getSelectedIndex() != 0) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Panggil Data Partai");
            dRunSelctOne.setQuery("SELECT `Pemasok`, `NamaBarang`, `Netto`, `Karung` FROM `tbmpartai`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbmpemasok`c ON b.`IdPemasok`=c.`IdPemasok` WHERE `IdPartai` = '" + JCNoPartai.getSelectedItem() + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            JTPemasok.setText(list.get(0));
            JTNamaBarang.setText(list.get(1));
            loadTotalTerima();
        } else {
            JTPemasok.setText("");
            JCPeminta.setSelectedItem("");
            JTNamaBarang.setText("");
            JTTotalTerima.setText("");
            JTNoPenerimaan.setText("");
        }
    }

    void loadTotalTerima() {
        if (JCNoPartai.getSelectedIndex() != 0) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Panggil Total Terima");
            dRunSelctOne.setQuery("SELECT CONCAT(IFNULL(FORMAT(SUM(`KarungPelita`),0),0),'/',FORMAT(`Karung`,0),' Karung') as 'TotalKarung' FROM `tbpenerimaan`a LEFT JOIN `tbmpartai`b ON a.`IdPartai`=b.`IdPartai` WHERE b.`IdPartai` = '" + JCNoPartai.getSelectedItem() + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            JTTotalTerima.setText(list.get(0).replace(",", "."));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JTNoTimbang = new KomponenGUI.JtextF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF11 = new KomponenGUI.JlableF();
        jlableF12 = new KomponenGUI.JlableF();
        jlableF13 = new KomponenGUI.JlableF();
        jlableF14 = new KomponenGUI.JlableF();
        jlableF15 = new KomponenGUI.JlableF();
        jlableF16 = new KomponenGUI.JlableF();
        jlableF17 = new KomponenGUI.JlableF();
        jlableF18 = new KomponenGUI.JlableF();
        jlableF19 = new KomponenGUI.JlableF();
        jlableF20 = new KomponenGUI.JlableF();
        jlableF21 = new KomponenGUI.JlableF();
        jlableF22 = new KomponenGUI.JlableF();
        JTBruttoPelita = new KomponenGUI.JRibuanTextField();
        JTTaraPelita = new KomponenGUI.JRibuanTextField();
        JTNettoPelita = new KomponenGUI.JRibuanTextField();
        JTNettoPenjual = new KomponenGUI.JRibuanTextField();
        JTKarungPenjual = new KomponenGUI.JRibuanTextField();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF25 = new KomponenGUI.JlableF();
        jlableF4 = new KomponenGUI.JlableF();
        LBNoTransaksi = new KomponenGUI.JlableF();
        jlableF26 = new KomponenGUI.JlableF();
        JTNoPenerimaan = new KomponenGUI.JtextF();
        JCPlat = new KomponenGUI.JcomboboxF();
        jbuttonF7 = new KomponenGUI.JbuttonF();
        jlableF27 = new KomponenGUI.JlableF();
        jlableF28 = new KomponenGUI.JlableF();
        JTKarungPelita = new KomponenGUI.JRibuanTextField();
        JTPemasok = new KomponenGUI.JtextF();
        JTNamaBarang = new KomponenGUI.JtextF();
        LBNoTransaksi1 = new KomponenGUI.JlableF();
        jlableF29 = new KomponenGUI.JlableF();
        JCNoPartai = new KomponenGUI.JcomboboxF();
        jbuttonF8 = new KomponenGUI.JbuttonF();
        LBNoTransaksi2 = new KomponenGUI.JlableF();
        jlableF30 = new KomponenGUI.JlableF();
        JTTotalTerima = new KomponenGUI.JtextF();
        JCPeminta = new KomponenGUI.JcomboboxF();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        JTPlat = new KomponenGUI.JtextF();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("No. Timbang");

        jlableF2.setText("Nama Barang");

        jlableF3.setText("Keterangan");

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTAKeterangan);

        JTNoTimbang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoTimbangKeyPressed(evt);
            }
        });

        jbuttonF1.setText("Tambah");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Tambah & Tutup");
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

        jlableF6.setText(":");

        jlableF7.setText(":");

        jlableF8.setText(":");

        jbuttonF3.setText("Ubah");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jlableF9.setText("Brutto Pelita");

        jlableF10.setText(":");

        jlableF11.setText("Tara Pelita");

        jlableF12.setText(":");

        jlableF13.setText(":");

        jlableF14.setText("Netto Pelita");

        jlableF15.setText(":");

        jlableF16.setText("Netto Penjual");

        jlableF17.setText("Karung Penjual");

        jlableF18.setText(":");

        jlableF19.setText("Plat");

        jlableF20.setText(":");

        jlableF21.setText("Pemasok");

        jlableF22.setText(":");

        JTBruttoPelita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTBruttoPelitaKeyPressed(evt);
            }
        });

        JTTaraPelita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTTaraPelitaFocusLost(evt);
            }
        });
        JTTaraPelita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTTaraPelitaKeyPressed(evt);
            }
        });

        JTNettoPelita.setEnabled(false);
        JTNettoPelita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNettoPelitaKeyPressed(evt);
            }
        });

        JTNettoPenjual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNettoPenjualKeyPressed(evt);
            }
        });

        JTKarungPenjual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKarungPenjualKeyPressed(evt);
            }
        });

        JDTanggal.setDate(new Date());
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

        jlableF23.setText("Tanggal Terima");

        jlableF24.setText(":");

        jlableF25.setText(":");

        jlableF4.setText("Kepada");

        LBNoTransaksi.setText("No. Pengantar");

        jlableF26.setText(":");

        JTNoPenerimaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPenerimaanKeyPressed(evt);
            }
        });

        JCPlat.load("SELECT `Plat` FROM `tbmkendaraan` WHERE 1 ");
        JCPlat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPlatKeyPressed(evt);
            }
        });

        jbuttonF7.setText("+");
        jbuttonF7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF7ActionPerformed(evt);
            }
        });

        jlableF27.setText("Karung Pelita");

        jlableF28.setText(":");

        JTKarungPelita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKarungPelitaKeyPressed(evt);
            }
        });

        JTPemasok.setEnabled(false);

        JTNamaBarang.setEnabled(false);

        LBNoTransaksi1.setText("No. Partai");

        jlableF29.setText(":");

        JCNoPartai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih No. Partai --" }));
        JCNoPartai.load("SELECT '-- Pilih No. Partai --' as 'NoPartai' UNION SELECT `IdPartai` FROM `tbmpartai` WHERE `SelesaiTerima` = 0 ");
        JCNoPartai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCNoPartaiItemStateChanged(evt);
            }
        });
        JCNoPartai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNoPartaiKeyPressed(evt);
            }
        });

        jbuttonF8.setText("+");
        jbuttonF8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF8ActionPerformed(evt);
            }
        });
        jbuttonF8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbuttonF8KeyPressed(evt);
            }
        });

        LBNoTransaksi2.setText("Total Terima");

        jlableF30.setText(":");

        JTTotalTerima.setEnabled(false);

        JCPeminta.load("SELECT `Peminta` FROM `tbmpeminta`");
        JCPeminta.setNextFocusableComponent(JTKarungPenjual);
        JCPeminta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCPemintaItemStateChanged(evt);
            }
        });
        JCPeminta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPemintaKeyPressed(evt);
            }
        });

        jbuttonF6.setText("+");
        jbuttonF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF6ActionPerformed(evt);
            }
        });

        JTPlat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTPlatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPlatKeyReleased(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCNoPartai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbuttonF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTKarungPelita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jlableF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlableF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlableF23, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JDTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JCPeminta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTNoTimbang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTBruttoPelita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTTaraPelita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTNettoPelita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTNettoPenjual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTKarungPenjual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTTotalTerima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTPemasok, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBNoTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNoPartai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBNoTransaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTotalTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPeminta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKarungPenjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNettoPenjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKarungPelita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTBruttoPelita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTaraPelita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNettoPelita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        dispose();
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void JTNoTimbangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoTimbangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTPlat.requestFocus();
        }
    }//GEN-LAST:event_JTNoTimbangKeyPressed

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (IdEdit == null) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void JDTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPeminta.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JTBruttoPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBruttoPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTTaraPelita.requestFocus();
        }
    }//GEN-LAST:event_JTBruttoPelitaKeyPressed

    private void JTTaraPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTTaraPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTTaraPelitaKeyPressed

    private void JTNettoPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNettoPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKarungPenjual.requestFocus();
        }
    }//GEN-LAST:event_JTNettoPelitaKeyPressed

    private void JTNettoPenjualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNettoPenjualKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNoTimbang.requestFocus();
        }
    }//GEN-LAST:event_JTNettoPenjualKeyPressed

    private void JTKarungPenjualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKarungPenjualKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNettoPenjual.requestFocus();
        }
    }//GEN-LAST:event_JTKarungPenjualKeyPressed

    private void JTTaraPelitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTTaraPelitaFocusLost
        JTNettoPelita.setInt(JTBruttoPelita.getInt() - JTTaraPelita.getInt());
    }//GEN-LAST:event_JTTaraPelitaFocusLost

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange
        
    }//GEN-LAST:event_JDTanggalPropertyChange

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            GlobalVar.Var.tambahPenerimaan = null;
        } else {
            GlobalVar.Var.ubahPenerimaan = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void jbuttonF7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF7ActionPerformed
        if (GlobalVar.Var.tambahKendaraan == null) {
            GlobalVar.Var.tambahKendaraan = new MasterKendaraan("0");
        } else {
            GlobalVar.Var.tambahKendaraan.setState(NORMAL);
            GlobalVar.Var.tambahKendaraan.toFront();
        }
    }//GEN-LAST:event_jbuttonF7ActionPerformed

    private void JTKarungPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKarungPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTBruttoPelita.requestFocus();
        }
    }//GEN-LAST:event_JTKarungPelitaKeyPressed

    private void JCPlatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPlatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKarungPelita.requestFocus();
            JCPlat.hidePopup();
        }
    }//GEN-LAST:event_JCPlatKeyPressed

    private void jbuttonF8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF8ActionPerformed
        if (GlobalVar.Var.tambahPartai == null) {
            GlobalVar.Var.tambahPartai = new MasterPartai();
        } else {
            GlobalVar.Var.tambahPartai.setState(NORMAL);
            GlobalVar.Var.tambahPartai.toFront();
        }
    }//GEN-LAST:event_jbuttonF8ActionPerformed

    private void JCNoPartaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCNoPartaiItemStateChanged
        loadDataPartai();
    }//GEN-LAST:event_JCNoPartaiItemStateChanged

    private void JCNoPartaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNoPartaiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNoPenerimaan.requestFocus();
        }
    }//GEN-LAST:event_JCNoPartaiKeyPressed

    private void jbuttonF8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbuttonF8KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKarungPenjual.requestFocus();
        }
    }//GEN-LAST:event_jbuttonF8KeyPressed

    private void JCPemintaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCPemintaItemStateChanged
        
    }//GEN-LAST:event_JCPemintaItemStateChanged

    private void JCPemintaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPemintaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKarungPenjual.requestFocus();
        }
    }//GEN-LAST:event_JCPemintaKeyPressed

    private void jbuttonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF6ActionPerformed
        if (GlobalVar.Var.tambahPeminta == null) {
            GlobalVar.Var.tambahPeminta = new Masters("0", "Peminta");
        } else {
            GlobalVar.Var.tambahPeminta.setState(NORMAL);
            GlobalVar.Var.tambahPeminta.toFront();
        }
    }//GEN-LAST:event_jbuttonF6ActionPerformed

    private void JTPlatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPlatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKarungPelita.requestFocus();
            JCPlat.hidePopup();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JCPlat.setSelectedIndex(JCPlat.getSelectedIndex() + 1);
            JCPlat.requestFocus();
        }
    }//GEN-LAST:event_JTPlatKeyPressed

    private void JTPlatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPlatKeyReleased
        if (!JTPlat.getText().replace(" ", "").equals("")) {
            JCPlat.Cari(" AND `Plat` REGEXP '" + JTPlat.getText().replace(" ", ".+") + "' ORDER BY `Plat` ASC");
            JCPlat.showPopup();
        }
    }//GEN-LAST:event_JTPlatKeyReleased

    private void JTNoPenerimaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPenerimaanKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            JCPeminta.requestFocus();
        }
    }//GEN-LAST:event_JTNoPenerimaanKeyPressed

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
            java.util.logging.Logger.getLogger(Penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penerimaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCNoPartai;
    public static KomponenGUI.JcomboboxF JCPeminta;
    public KomponenGUI.JcomboboxF JCPlat;
    private static KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTBruttoPelita;
    private KomponenGUI.JRibuanTextField JTKarungPelita;
    private KomponenGUI.JRibuanTextField JTKarungPenjual;
    private KomponenGUI.JtextF JTNamaBarang;
    private KomponenGUI.JRibuanTextField JTNettoPelita;
    private KomponenGUI.JRibuanTextField JTNettoPenjual;
    private KomponenGUI.JtextF JTNoPenerimaan;
    private KomponenGUI.JtextF JTNoTimbang;
    private KomponenGUI.JtextF JTPemasok;
    private KomponenGUI.JtextF JTPlat;
    private KomponenGUI.JRibuanTextField JTTaraPelita;
    private KomponenGUI.JtextF JTTotalTerima;
    private KomponenGUI.JlableF LBNoTransaksi;
    private KomponenGUI.JlableF LBNoTransaksi1;
    private KomponenGUI.JlableF LBNoTransaksi2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF6;
    private KomponenGUI.JbuttonF jbuttonF7;
    private KomponenGUI.JbuttonF jbuttonF8;
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
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            Insert insert = new Insert();
            Boolean berhasil = insert.simpan("INSERT INTO `tbpenerimaan`(`NoPenerimaan`, `Tanggal`, `IdPartai`, `IdPeminta`, `KarungPenjual`, `NettoPenjual`, `NoTimbang`, `Plat`, `KarungPelita`, `BruttoPelita`, `TaraPelita`, `NettoPelita`, `Keterangan`) VALUES ('" + JTNoPenerimaan.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "','" + JCNoPartai.getSelectedItem() + "',(SELECT `IdPeminta` FROM `tbmpeminta` WHERE `Peminta` = '" + JCPeminta.getSelectedItem() + "'),'" + JTKarungPenjual.getInt() + "','" + JTNettoPenjual.getInt() + "','" + JTNoTimbang.getText() + "','" + JCPlat.getSelectedItem() + "','" + JTKarungPelita.getInt() + "','" + JTBruttoPelita.getInt() + "','" + JTTaraPelita.getInt() + "','" + JTNettoPelita.getInt() + "','" + JTAKeterangan.getText() + "')", "Penerimaan", this);
            if (berhasil) {
                if (Integer.valueOf(JTTotalTerima.getText().split("/")[0].replace(".", "")) + JTKarungPelita.getInt() == Integer.valueOf(JTTotalTerima.getText().split("/")[1].split(" ")[0].replace(".", ""))) {
                    UpdateAll updateAll = new UpdateAll();
                    updateAll.Ubah("UPDATE `tbmpartai` SET `SelesaiTerima`=1 WHERE `IdPartai`='" + JCNoPartai.getSelectedItem() + "'", "Partai", this);
                    JOptionPane.showMessageDialog(this, "Partai No." + JCNoPartai.getSelectedItem() + " Telah Ditutup Karena Jumlah Penerimaan Telah Pas");
                    JCNoPartai.load("SELECT '-- Pilih No. Partai --' as 'NoPartai' UNION SELECT `IdPartai` FROM `tbmpartai` WHERE `SelesaiTerima` = 0 ");
                    JCNoPartai.requestFocus();
                    JCNoPartai.setSelectedIndex(0);
                    JTTotalTerima.setText("");
                    JTPemasok.setText("");
                    JTNamaBarang.setText("");
                }
                if (GlobalVar.Var.listPenerimaan != null) {
                    GlobalVar.Var.listPenerimaan.load();
                }
                if (tutup) {
                    GlobalVar.Var.tambahPenerimaan.dispose();
                    GlobalVar.Var.tambahPenerimaan = null;
                } else {
                    loadTotalTerima();
                    JTKarungPenjual.setText("0");
                    JTNettoPenjual.setText("0");
                    JTNoTimbang.setText("");
                    JTPlat.setText("");
                    JTKarungPelita.setText("0");
                    JTBruttoPelita.setText("0");
                    JTTaraPelita.setText("0");
                    JTNettoPelita.setText("0");
                    JTAKeterangan.setText("");
                    JTKarungPenjual.requestFocus();
                }
            }
        }
    }

    void ubahData() {
        if (checkInput()) {
            Update update = new Update();
            Boolean berhasil = update.Ubah("UPDATE `tbpenerimaan` SET `NoPenerimaan`='" + JTNoPenerimaan.getText() + "',`Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdPartai`='" + JCNoPartai.getSelectedItem() + "',`IdPeminta`=(SELECT `IdPeminta` FROM `tbmpeminta` WHERE `Peminta` = '" + JCPeminta.getSelectedItem() + "'),`KarungPenjual`='" + JTKarungPenjual.getInt() + "',`NettoPenjual`='" + JTNettoPenjual.getInt() + "',`NoTimbang`='" + JTNoTimbang.getText() + "',`Plat`='" + JCPlat.getSelectedItem() + "',`KarungPelita`='" + JTKarungPelita.getInt() + "',`BruttoPelita`='" + JTBruttoPelita.getInt() + "',`TaraPelita`='" + JTTaraPelita.getInt() + "',`NettoPelita`='" + JTNettoPelita.getInt() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdPenerimaan` = " + IdEdit, "Penerimaan", this);
            if (GlobalVar.Var.listPenerimaan != null) {
                GlobalVar.Var.listPenerimaan.load();
            }
            if (berhasil) {
                dispose();
            }
        }
    }

}
