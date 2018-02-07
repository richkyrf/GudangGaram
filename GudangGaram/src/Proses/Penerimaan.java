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
        JCTujuan.requestFocus();
        if (JCTujuan.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
            JTNoPenerimaan.setText(generateNoPenerimaanPPN());
        } else {
            JTNoPenerimaan.setText(generateNoPenerimaan());
        }
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
        loadEditData();
        JCTujuan.requestFocus();
    }

    void loadEditData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `IdPenerimaan` as 'ID', `NoTimbang` as 'No. Timbang', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarang` as 'Nama Barang', `BruttoPelita` as 'Brutto PLT', `TaraPelita` as 'Tara PLT', `NettoPelita` as 'Netto PLT', `NettoPenjual` as 'Netto PJL', `Karung`, `Plat`, `Customer`, a.`Keterangan`, `NoPenerimaan` FROM `tbpenerimaan`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbmcustomer`c ON a.`IdCustomer`=c.`IdCustomer` WHERE `IdPenerimaan` = " + IdEdit);
        ArrayList<String> list = dRunSelctOne.excute();
        JTNoTimbang.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "dd-MM-yyyy"));
        JCNamaBarang.setSelectedItem(list.get(3));
        JTBruttoPelita.setText(list.get(4));
        JTTaraPelita.setText(list.get(5));
        JTNettoPelita.setText(list.get(6));
        JTNettoPenjual.setText(list.get(7));
        JTJumlahKarung.setText(list.get(8));
        JCPlat.setSelectedItem(list.get(9));
        JCCustomer.setSelectedItem(list.get(10));
        JTAKeterangan.setText(list.get(11));
        JTNoPenerimaan.setText(list.get(12));
    }

    Boolean checkInput() {
        if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Terima Tidak Boleh Kosong");
            return false;
        } else if (JTNoTimbang.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "No. Timbang Tidak Boleh Kosong");
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
        } else if (JTNettoPenjual.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Netto Penjual Tidak Boleh Kosong");
            return false;
        } else if (JTJumlahKarung.getText().replace("0", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Karung Tidak Boleh Kosong");
            return false;
        } else if (JCPlat.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Plat Tidak Boleh Kosong");
            return false;
        } else if (JCCustomer.getSelectedItem().toString().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Customer Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    String generateNoPenerimaan() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPenerimaan = null;
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan`a JOIN `tbmcustomer`b ON a.`IdCustomer`=b.`IdCustomer` WHERE `NoPenerimaan` LIKE '%-PN' AND `Customer` = '" + JCCustomer.getSelectedItem() + "' AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
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
        dRunSelctOne.setQuery("SELECT `NoPenerimaan` FROM `tbpenerimaan`a JOIN `tbmcustomer`b ON a.`IdCustomer`=b.`IdCustomer` WHERE `NoPenerimaan` LIKE '%-PG' AND `Customer` = '" + JCCustomer.getSelectedItem() + "' AND `Tanggal` = '" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "'");
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
        JCNamaBarang = new KomponenGUI.JcomboboxF();
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
        JTJumlahKarung = new KomponenGUI.JRibuanTextField();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF25 = new KomponenGUI.JlableF();
        JCTujuan = new KomponenGUI.JcomboboxF();
        jlableF4 = new KomponenGUI.JlableF();
        LBNoTransaksi = new KomponenGUI.JlableF();
        jlableF26 = new KomponenGUI.JlableF();
        JTNoPenerimaan = new KomponenGUI.JtextF();
        JCCustomer = new KomponenGUI.JcomboboxF();
        JCPlat = new KomponenGUI.JcomboboxF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        JCNamaBarang.load("SELECT `NamaBarang` FROM `tbmbarang`");
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyPressed(evt);
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

        jlableF17.setText("Jumlah Karung");

        jlableF18.setText(":");

        jlableF19.setText("Plat");

        jlableF20.setText(":");

        jlableF21.setText("Beli Dari");

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

        JTJumlahKarung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahKarungKeyPressed(evt);
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

        JCTujuan.load("SELECT `Peminta` FROM `tbmpeminta`");
        JCTujuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCTujuanItemStateChanged(evt);
            }
        });
        JCTujuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCTujuanKeyPressed(evt);
            }
        });

        jlableF4.setText("Tujuan");

        LBNoTransaksi.setText("No. Penerimaan");

        jlableF26.setText(":");

        JTNoPenerimaan.setEnabled(false);
        JTNoPenerimaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoPenerimaanKeyPressed(evt);
            }
        });

        JCCustomer.load("SELECT `Customer` FROM `tbmcustomer` ");
        JCCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCCustomerItemStateChanged(evt);
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
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTBruttoPelita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF23, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JCTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTNoTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTTaraPelita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNettoPelita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNettoPenjual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTJumlahKarung, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCPlat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNettoPenjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJumlahKarung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
        if (IdEdit == null) {
            GlobalVar.Var.tambahPenerimaan.dispose();
            GlobalVar.Var.tambahPenerimaan = null;
        } else {
            GlobalVar.Var.ubahPenerimaan.dispose();
            GlobalVar.Var.ubahPenerimaan = null;
        }
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (IdEdit == null) {
            GlobalVar.Var.tambahPenerimaan = null;
        } else {
            GlobalVar.Var.ubahPenerimaan = null;
        }
    }//GEN-LAST:event_formWindowClosing

    private void JTNoTimbangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoTimbangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JTNoTimbangKeyPressed

    private void JCNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTBruttoPelita.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyPressed

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
            JCTujuan.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JTBruttoPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBruttoPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTTaraPelita.requestFocus();
        }
    }//GEN-LAST:event_JTBruttoPelitaKeyPressed

    private void JTTaraPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTTaraPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNettoPenjual.requestFocus();
        }
    }//GEN-LAST:event_JTTaraPelitaKeyPressed

    private void JTNettoPelitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNettoPelitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahKarung.requestFocus();
        }
    }//GEN-LAST:event_JTNettoPelitaKeyPressed

    private void JTNettoPenjualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNettoPenjualKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahKarung.requestFocus();
        }
    }//GEN-LAST:event_JTNettoPenjualKeyPressed

    private void JTJumlahKarungKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKarungKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahKarungKeyPressed

    private void JTTaraPelitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTTaraPelitaFocusLost
        JTNettoPelita.setInt(JTBruttoPelita.getInt() - JTTaraPelita.getInt());
    }//GEN-LAST:event_JTTaraPelitaFocusLost

    private void JCTujuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCTujuanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCCustomer.requestFocus();
        }
    }//GEN-LAST:event_JCTujuanKeyPressed

    private void JTNoPenerimaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoPenerimaanKeyPressed

    }//GEN-LAST:event_JTNoPenerimaanKeyPressed

    private void JCTujuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCTujuanItemStateChanged
        if (JCTujuan.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
            JTNoPenerimaan.setText(generateNoPenerimaanPPN());
        } else {
            JTNoPenerimaan.setText(generateNoPenerimaan());
        }
    }//GEN-LAST:event_JCTujuanItemStateChanged

    private void JCCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCCustomerItemStateChanged
        if (JCTujuan.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
            JTNoPenerimaan.setText(generateNoPenerimaanPPN());
        } else {
            JTNoPenerimaan.setText(generateNoPenerimaan());
        }
    }//GEN-LAST:event_JCCustomerItemStateChanged

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange
        if (JCTujuan.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
            JTNoPenerimaan.setText(generateNoPenerimaanPPN());
        } else {
            JTNoPenerimaan.setText(generateNoPenerimaan());
        }
    }//GEN-LAST:event_JDTanggalPropertyChange

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
    private KomponenGUI.JcomboboxF JCCustomer;
    private KomponenGUI.JcomboboxF JCNamaBarang;
    private KomponenGUI.JcomboboxF JCPlat;
    private KomponenGUI.JcomboboxF JCTujuan;
    private static KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTBruttoPelita;
    private KomponenGUI.JRibuanTextField JTJumlahKarung;
    private KomponenGUI.JRibuanTextField JTNettoPelita;
    private KomponenGUI.JRibuanTextField JTNettoPenjual;
    private KomponenGUI.JtextF JTNoPenerimaan;
    private KomponenGUI.JtextF JTNoTimbang;
    private KomponenGUI.JRibuanTextField JTTaraPelita;
    private KomponenGUI.JlableF LBNoTransaksi;
    private javax.swing.JScrollPane jScrollPane1;
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
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            Insert insert = new Insert();
            Boolean berhasil = insert.simpan("INSERT INTO `tbpenerimaan`(`NoPenerimaan`, `IdPeminta`, `NoTimbang`, `Tanggal`, `IdBarang`, `BruttoPelita`, `TaraPelita`, `NettoPelita`, `NettoPenjual`, `Karung`, `Plat`, `IdCustomer`, `Keterangan`) VALUES ('" + JTNoPenerimaan.getText() + "',(SELECT `IdPeminta` FROM `tbmpeminta` WHERE `Peminta` = '" + JCTujuan.getSelectedItem() + "'),'" + JTNoTimbang.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'),'" + JTBruttoPelita.getInt() + "','" + JTTaraPelita.getInt() + "','" + JTNettoPelita.getInt() + "','" + JTNettoPenjual.getInt() + "','" + JTJumlahKarung.getInt() + "','" + JCPlat.getSelectedItem() + "',(SELECT `IdCustomer` FROM `tbmcustomer` WHERE `Customer` = '" + JCCustomer.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", "Penerimaan", this);
            if (berhasil) {
                if (tutup) {
                    GlobalVar.Var.tambahPenerimaan.dispose();
                    GlobalVar.Var.tambahPenerimaan = null;
                } else {
                    //jtextF1.setText("");
                    //jRibuanTextField1.setText("0");
                    //jRibuanTextField2.setText("0");
                    //jRibuanTextField3.setText("0");
                    //jRibuanTextField4.setText("0");
                    //jRibuanTextField5.setText("0");
                    //jtextF2.setText("");
                    //jTextAreaF1.setText("");
                    //jtextF1.requestFocus();
                    JTNettoPelita.requestFocus();
                    if (JCTujuan.getSelectedItem().equals("PT. INTI GARAM CEMERLANG")) {
                        JTNoPenerimaan.setText(generateNoPenerimaanPPN());
                    } else {
                        JTNoPenerimaan.setText(generateNoPenerimaan());
                    }
                }
                if (GlobalVar.Var.listPenerimaan != null) {
                    GlobalVar.Var.listPenerimaan.load();
                }
            }
        }
    }

    void ubahData() {
        if (checkInput()) {
            Update update = new Update();
            Boolean berhasil = update.Ubah("UPDATE `tbpenerimaan` SET `NoPenerimaan`='" + JTNoPenerimaan.getText() + "', `IdPeminta`=(SELECT `IdPeminta` FROM `tbmpeminta` WHERE `Peminta` = '" + JCTujuan.getSelectedItem() + "'), `NoTimbang`='" + JTNoTimbang.getText() + "',`Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdBarang`=(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'),`BruttoPelita`='" + JTBruttoPelita.getInt() + "',`TaraPelita`='" + JTTaraPelita.getInt() + "',`NettoPelita`='" + JTNettoPelita.getInt() + "',`NettoPenjual`='" + JTNettoPenjual.getInt() + "',`Karung`='" + JTJumlahKarung.getInt() + "',`Plat`='" + JCPlat.getSelectedItem() + "',`IdCustomer`=(SELECT `Customer` FROM `tbmcustomer` WHERE `Customer` = '" + JCCustomer.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdPenerimaan` = " + IdEdit, "Penerimaan", this);
            if (berhasil) {
                GlobalVar.Var.listPenerimaan.load();
                GlobalVar.Var.ubahPenerimaan.dispose();
                GlobalVar.Var.ubahPenerimaan = null;
            }
        }
    }

}
