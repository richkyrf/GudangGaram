/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import KomponenGUI.FDateF;
import static KomponenGUI.FDateF.datetostr;
import Master.*;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.MultiInsert;
import LSubProces.RunSelct;
import LSubProces.Update;
import java.awt.event.KeyEvent;
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
public class Penjualan extends javax.swing.JFrame {

    /**
     * Creates new form MasterPenjualan
     */
    String IdEdit;

    public Penjualan() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Penjualan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF3.setVisible(false);
        JCJenisPenjualan.requestFocus();
        if (JCJenisPenjualan.getSelectedItem().equals("PENJUALAN")) {
            JTNoTransaksi.setText(getNoPenjualan());
            LBTujuan.setText("Kepada");
        } else if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
            JTNoTransaksi.setText(getNoMutasi());
            LBTujuan.setText("Ke Gudang");
        }
    }

    public Penjualan(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Penjualan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF1.setVisible(false);
        jbuttonF2.setVisible(false);
        loadeditdata();
        JCJenisPenjualan.requestFocus();
    }

    void loadeditdata() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Eror gagal Menampilkan Data Penjualan");
        dRunSelctOne.setQuery("SELECT `IdPenjualan`, `NoTransaksi`, `Tanggal`, `JenisPenjualan`, `Plat`, `JenisKendaraan`, IFNULL(`Gudang`, '') as 'Gudang', IFNULL(`Penerima`, '') as 'Penerima', a.`Keterangan` FROM `tbpenjualan`a JOIN `tbsmjenispenjualan`b ON a.`IdJenisPenjualan`=b.`IdJenisPenjualan` JOIN `tbmkendaraan`c ON a.`IdKendaraan`=c.`IdKendaraan` LEFT JOIN `tbmgudang`d on a.`IdGudang`=d.`IdGudang` LEFT JOIN `tbmpenerima`e ON a.`IdPenerima`=e.`IdPenerima` WHERE `NoTransaksi` = '" + IdEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTNoTransaksi.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "yyyy-MM-dd"));
        JCJenisPenjualan.setSelectedItem(list.get(3));
        JCPlat.setSelectedItem(list.get(4));
        JTJenisKendaraan.setText(list.get(5));
        if (!list.get(6).equals("")) {
            LBTujuan.setText("Ke Gudang");
            JCTujuan.load("SELECT `Gudang` FROM `tbmgudang`");
            JCTujuan.setSelectedItem(list.get(6));
        } else {
            LBTujuan.setText("Kepada");
            JCTujuan.load("SELECT `Penerima` FROM `tbmpenerima`");
            JCTujuan.setSelectedItem(list.get(7));
        }
        JTAKeterangan.setText(list.get(8));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `IdPenjualanDetail`, `NoTransaksi`, `NoKolom`, `NamaBarang`, `Jumlah`, `HargaSatuan`, `Jumlah`*`HargaSatuan` as 'Sub Total' FROM `tbpenjualandetail`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` WHERE `NoTransaksi` = '" + list.get(1) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", ""});
                JTable.setValueAt(rs.getString(3), row, 0);
                JTable.setValueAt(rs.getString(4), row, 1);
                JTable.setValueAt(rs.getString(5), row, 2);
                JTable.setValueAt(rs.getString(6), row, 3);
                JTable.setValueAt(rs.getString(7), row, 4);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Detail Penjualan");
        } finally {
            runSelct.closecon();
        }
        JTGrandTotal.setText(String.valueOf(getGrandTotal()));
    }

    Boolean checkInput() {
        if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Terima Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    public static String getNoMutasi() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoPenjualan = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoTransaksi` FROM `tbpenjualan` WHERE `NoTransaksi` LIKE '%-SJ' ORDER BY `NoTransaksi` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPenjualan = "GG-" + "000001" + "-SJ";
            }
            while (rs.next()) {
                String nopenjualan = rs.getString("NoTransaksi");
                String number = nopenjualan.substring(3, 9);
                //String month = nopenjualan.substring(8, 10);
                int p = 1 + parseInt(number);
                /*if (month.equals(FDateF.datetostr(new Date(), "MM"))) {
                    p = 1 + parseInt(number);
                } else {
                    p = 1;
                }*/
                if (p != 999999) {
                    NoPenjualan = "GG-" + nf.format(p) + "-SJ";
                } else if (p == 999999) {
                    p = 1;
                    NoPenjualan = "GG-" + nf.format(p) + "-SJ";
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Generate Nomor Transaksi");
        } finally {
            runSelct.closecon();
        }
        return NoPenjualan;
    }

    public static String getNoPenjualan() {
        NumberFormat nf = new DecimalFormat("000000");
        String NoTransaksi = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoTransaksi` FROM `tbpenjualan` WHERE `NoTransaksi` LIKE '%-PJ' ORDER BY `NoTransaksi` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoTransaksi = "GG-" + "000001" + "-PJ";
            }
            while (rs.next()) {
                String nopenjualan = rs.getString("NoTransaksi");
                String number = nopenjualan.substring(3, 9);
                //String month = nopenjualan.substring(8, 10);
                int p = 1 + parseInt(number);
                /*if (month.equals(FDateF.datetostr(new Date(), "MM"))) {
                    p = 1 + parseInt(number);
                } else {
                    p = 1;
                }*/
                if (p != 999999) {
                    NoTransaksi = "GG-" + nf.format(p) + "-PJ";
                } else if (p == 999999) {
                    p = 1;
                    NoTransaksi = "GG-" + nf.format(p) + "-PJ";
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Generate Nomor Penjualan");
        } finally {
            runSelct.closecon();
        }
        return NoTransaksi;
    }

    boolean checkTable() {
        if (JTJumlah.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            JTJumlah.requestFocus();
            return false;
        } else if (JTable.getRowCount() > 6) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Yang Diinput Tidak Bisa Lebih Dari 6");
            return false;
        } else if (Float.parseFloat(JTJumlah.getText()) > Float.parseFloat(JTStock.getText().replace(".", "").replace(",", "."))) {
            JOptionPane.showMessageDialog(this, "Jumlah Permintaan Tidak Bisa Melebihi Stok");
            JTJumlah.requestFocus();
            return false;
        } else if (cekdoubleitem(JCNamaBarang.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Input Barang Yang Sama");
            JCNamaBarang.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean checkTableUbah() {
        if (JTJumlah.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            JTJumlah.requestFocus();
            return false;
        } else if (JTable.getRowCount() > 6) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Yang Diinput Tidak Bisa Lebih Dari 6");
            return false;
        } else {
            return true;
        }
    }

    boolean isAlphanumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a) {
                return false;
            }
        }
        return true;
    }

    boolean cekdoubleitem(String item) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item.equals(JTable.getValueAt(i, 2))) {
                return true;
            }
        }
        return false;
    }

    void RefreshTbl() {
        JTable.clearSelection();
        JTJumlah.setText("0");
        JTHargaSatuan.setText("0");
        JTSubTotal.setText("0");
        JTStock.setText("0,00");
    }

    void setHarga() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Panggil Data Harga");
        dRunSelctOne.setQuery("SELECT `Harga` FROM `tbmbarang` WHERE `NamaBarang`= '" + JCNamaBarang.getSelectedItem() + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTHargaSatuan.setText(list.get(0));
    }

    void setSubTotal() {
        int jumlah = Integer.valueOf(JTJumlah.getText());
        int harga = Integer.valueOf(JTHargaSatuan.getText().replace(".", ""));
        int subtotal = jumlah * harga;
        String subtotals = String.valueOf(subtotal);
        JTSubTotal.setText(subtotals);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        LBNoTransaksi = new KomponenGUI.JlableF();
        jlableF4 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF2 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        JTNoTransaksi = new KomponenGUI.JtextF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        JCJenisPenjualan = new KomponenGUI.JcomboboxF();
        jlableF19 = new KomponenGUI.JlableF();
        jlableF20 = new KomponenGUI.JlableF();
        jlableF21 = new KomponenGUI.JlableF();
        jlableF22 = new KomponenGUI.JlableF();
        JTJenisKendaraan = new KomponenGUI.JtextF();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jlabelF7 = new KomponenGUI.JtextF();
        JCNamaBarang = new KomponenGUI.JcomboboxF();
        jlabelF8 = new KomponenGUI.JtextF();
        JTJumlah = new KomponenGUI.JNumberOnly();
        jlabelF9 = new KomponenGUI.JtextF();
        jlabelF10 = new KomponenGUI.JtextF();
        tambahtable = new KomponenGUI.JbuttonF();
        ubahtable = new KomponenGUI.JbuttonF();
        hapustable = new KomponenGUI.JbuttonF();
        hapustable1 = new KomponenGUI.JbuttonF();
        JTStock = new KomponenGUI.JtextF();
        jlabelF11 = new KomponenGUI.JtextF();
        JTHargaSatuan = new KomponenGUI.JRibuanTextField();
        jbuttonF5 = new KomponenGUI.JbuttonF();
        JTSubTotal = new KomponenGUI.JRibuanTextField();
        LBTujuan = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        JCTujuan = new KomponenGUI.JcomboboxF();
        JCPlat = new KomponenGUI.JcomboboxF();
        jlableF25 = new KomponenGUI.JlableF();
        jlableF26 = new KomponenGUI.JlableF();
        JTNamaSupir = new KomponenGUI.JtextF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JTGrandTotal = new KomponenGUI.JRibuanTextField();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        jbuttonF7 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        LBNoTransaksi.setText("No. Transaksi");

        jlableF4.setText("Total");

        jlableF10.setText(":");

        jlableF2.setText("Jenis Penjualan");

        jlableF3.setText("Keterangan");

        JTNoTransaksi.setEnabled(false);
        JTNoTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNoTransaksiKeyPressed(evt);
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

        JCJenisPenjualan.load("SELECT `JenisPenjualan` FROM `tbsmjenispenjualan`");
        JCJenisPenjualan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCJenisPenjualanItemStateChanged(evt);
            }
        });
        JCJenisPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCJenisPenjualanKeyPressed(evt);
            }
        });

        jlableF19.setText("Jenis Kendaraan");

        jlableF20.setText(":");

        jlableF21.setText("Plat");

        jlableF22.setText(":");

        JTJenisKendaraan.setEnabled(false);
        JTJenisKendaraan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJenisKendaraanKeyPressed(evt);
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

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Barang", "Jumlah", "Harga Satuan", "Sub Total"
            }
        ));
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
            JTable.getColumnModel().getColumn(1).setMinWidth(310);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(310);
            JTable.getColumnModel().getColumn(1).setMaxWidth(310);
            JTable.getColumnModel().getColumn(2).setMinWidth(85);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(85);
            JTable.getColumnModel().getColumn(2).setMaxWidth(85);
            JTable.getColumnModel().getColumn(3).setMinWidth(15);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(115);
            JTable.getColumnModel().getColumn(3).setMaxWidth(115);
        }

        jlabelF7.setText("Nama Barang");
        jlabelF7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jlabelF7.setEnabled(false);

        JCNamaBarang.load("SELECT `NamaBarang` FROM `tbmbarang`");
        JCNamaBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JCNamaBarangFocusLost(evt);
            }
        });
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyPressed(evt);
            }
        });

        jlabelF8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jlabelF8.setText("Jumlah");
        jlabelF8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jlabelF8.setEnabled(false);

        JTJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTJumlah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTJumlahFocusLost(evt);
            }
        });
        JTJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahKeyPressed(evt);
            }
        });

        jlabelF9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jlabelF9.setText("Harga Satuan");
        jlabelF9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jlabelF9.setEnabled(false);

        jlabelF10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jlabelF10.setText("Stock");
        jlabelF10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jlabelF10.setEnabled(false);

        tambahtable.setText("TAMBAH");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), tambahtable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        tambahtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtableActionPerformed(evt);
            }
        });

        ubahtable.setText("UBAH");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), ubahtable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        ubahtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahtableActionPerformed(evt);
            }
        });

        hapustable.setText("HAPUS");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), hapustable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        hapustable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustableActionPerformed(evt);
            }
        });

        hapustable1.setText("REFRESH");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), hapustable1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        hapustable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustable1ActionPerformed(evt);
            }
        });

        JTStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTStock.setText("0,00");
        JTStock.setEnabled(false);

        jlabelF11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jlabelF11.setText("Sub Total");
        jlabelF11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jlabelF11.setEnabled(false);

        JTHargaSatuan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTHargaSatuanFocusLost(evt);
            }
        });
        JTHargaSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTHargaSatuanKeyPressed(evt);
            }
        });

        jbuttonF5.setText("Print");
        jbuttonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF5ActionPerformed(evt);
            }
        });

        JTSubTotal.setEnabled(false);
        JTSubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTSubTotalKeyPressed(evt);
            }
        });

        LBTujuan.setText("Kepada");

        jlableF9.setText(":");

        if (JCJenisPenjualan.getSelectedItem().equals("PENJUALAN")) {
            JCTujuan.load("SELECT `Penerima` FROM `tbmpenerima` ");
        } else if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
            JCTujuan.load("SELECT `Gudang` FROM `tbmgudang` ");
        }
        JCTujuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCTujuanKeyPressed(evt);
            }
        });

        JCPlat.load("SELECT `Plat` FROM `tbmkendaraan`");
        JCPlat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPlatKeyPressed(evt);
            }
        });

        jlableF25.setText("Nama Supir");

        jlableF26.setText(":");

        JTNamaSupir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNamaSupirKeyPressed(evt);
            }
        });

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        jScrollPane1.setViewportView(JTAKeterangan);

        JTGrandTotal.setEnabled(false);

        jbuttonF6.setText("+");
        jbuttonF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF6ActionPerformed(evt);
            }
        });

        jbuttonF7.setText("+");
        jbuttonF7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF7ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JCNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .addComponent(jlabelF7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelF8, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(JTJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelF9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTHargaSatuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelF11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTStock, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jlabelF10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCJenisPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlableF25, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(jlableF21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LBTujuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTNamaSupir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LBNoTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                        .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hapustable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ubahtable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tambahtable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hapustable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCJenisPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTNamaSupir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabelF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ubahtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapustable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapustable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bindingGroup.bind();

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
            GlobalVar.Var.tambahPenjualan.dispose();
            GlobalVar.Var.tambahPenjualan = null;
        } else {
            GlobalVar.Var.ubahPenjualan.dispose();
            GlobalVar.Var.ubahPenjualan = null;
        }
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (IdEdit == null) {
            GlobalVar.Var.tambahPenjualan = null;
        } else {
            GlobalVar.Var.ubahPenjualan = null;
        }
    }//GEN-LAST:event_formWindowClosing

    private void JTNoTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNoTransaksiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCJenisPenjualan.requestFocus();
        }
    }//GEN-LAST:event_JTNoTransaksiKeyPressed

    private void JCJenisPenjualanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCJenisPenjualanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCTujuan.requestFocus();
        }
    }//GEN-LAST:event_JCJenisPenjualanKeyPressed

    private void JTJenisKendaraanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisKendaraanKeyPressed

    }//GEN-LAST:event_JTJenisKendaraanKeyPressed

    private void JDTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNoTransaksi.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JCNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlah.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyPressed

    private void tambahtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtableActionPerformed
        TambahTabel();
        JTGrandTotal.setText(String.valueOf(getGrandTotal()));
    }//GEN-LAST:event_tambahtableActionPerformed

    private void ubahtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahtableActionPerformed
        ubahtable();
        JTGrandTotal.setText(String.valueOf(getGrandTotal()));
    }//GEN-LAST:event_ubahtableActionPerformed

    private void hapustableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustableActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            RefreshTbl();
        }
        JCNamaBarang.requestFocus();
        JTGrandTotal.setText(String.valueOf(getGrandTotal()));
    }//GEN-LAST:event_hapustableActionPerformed

    private void hapustable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustable1ActionPerformed
        RefreshTbl();
    }//GEN-LAST:event_hapustable1ActionPerformed

    private void JTJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTHargaSatuan.requestFocus();
            setSubTotal();
        }
    }//GEN-LAST:event_JTJumlahKeyPressed

    private void JCNamaBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCNamaBarangFocusLost
        setHarga();
        setStok();
    }//GEN-LAST:event_JCNamaBarangFocusLost

    private void JTHargaSatuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTHargaSatuanKeyPressed
        setSubTotal();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tambahtable.isEnabled()) {
                TambahTabel();
            } else {
                ubahtable();
            }
        }
    }//GEN-LAST:event_JTHargaSatuanKeyPressed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        if (JTable.getSelectedRow() != -1) {
            JCNamaBarang.setSelectedItem(JTable.getValueAt(JTable.getSelectedRow(), 1).toString());
            JTJumlah.setText(JTable.getValueAt(JTable.getSelectedRow(), 2).toString());
            JTHargaSatuan.setText(JTable.getValueAt(JTable.getSelectedRow(), 3).toString().replace(".", ""));
            JTSubTotal.setText(JTable.getValueAt(JTable.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void jbuttonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF5ActionPerformed
        printing();
    }//GEN-LAST:event_jbuttonF5ActionPerformed

    private void JTSubTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTSubTotalKeyPressed

    }//GEN-LAST:event_JTSubTotalKeyPressed

    private void JCJenisPenjualanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCJenisPenjualanItemStateChanged
        if (IdEdit == null) {
            if (JCJenisPenjualan.getSelectedItem().equals("PENJUALAN")) {
                JTNoTransaksi.setText(getNoPenjualan());
                JCTujuan.load("SELECT `Penerima` FROM `tbmpenerima` ");
                LBTujuan.setText("Kepada");
            } else if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
                JTNoTransaksi.setText(getNoMutasi());
                JCTujuan.load("SELECT `Gudang` FROM `tbmgudang` ");
                LBTujuan.setText("Ke Gudang");
            }
        }
    }//GEN-LAST:event_JCJenisPenjualanItemStateChanged

    private void JCTujuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCTujuanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPlat.requestFocus();
        }
    }//GEN-LAST:event_JCTujuanKeyPressed

    private void JCPlatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPlatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNamaSupir.requestFocus();
        }
    }//GEN-LAST:event_JCPlatKeyPressed

    private void JTJumlahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTJumlahFocusLost
        setSubTotal();
    }//GEN-LAST:event_JTJumlahFocusLost

    private void JTHargaSatuanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTHargaSatuanFocusLost
        setSubTotal();
    }//GEN-LAST:event_JTHargaSatuanFocusLost

    private void JTNamaSupirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaSupirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JTNamaSupirKeyPressed

    private void jbuttonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF6ActionPerformed
        if (JCJenisPenjualan.getSelectedItem().equals("PENJUALAN")) {
            if (GlobalVar.Var.tambahPeminta == null) {
                GlobalVar.Var.tambahPeminta = new Masters("0", "Penerima");
            } else {
                GlobalVar.Var.tambahPeminta.setState(NORMAL);
                GlobalVar.Var.tambahPeminta.toFront();
            }
        } else if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
            if (GlobalVar.Var.tambahGudang == null) {
                GlobalVar.Var.tambahGudang = new Masters("0", "Gudang");
            } else {
                GlobalVar.Var.tambahGudang.setState(NORMAL);
                GlobalVar.Var.tambahGudang.toFront();
            }
        }
    }//GEN-LAST:event_jbuttonF6ActionPerformed

    private void jbuttonF7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF7ActionPerformed
        if (GlobalVar.Var.tambahKendaraan == null) {
            GlobalVar.Var.tambahKendaraan = new MasterKendaraan("0");
        } else {
            GlobalVar.Var.tambahKendaraan.setState(NORMAL);
            GlobalVar.Var.tambahKendaraan.toFront();
        }
    }//GEN-LAST:event_jbuttonF7ActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static KomponenGUI.JcomboboxF JCJenisPenjualan;
    private KomponenGUI.JcomboboxF JCNamaBarang;
    public static KomponenGUI.JcomboboxF JCPlat;
    public static KomponenGUI.JcomboboxF JCTujuan;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTGrandTotal;
    private KomponenGUI.JRibuanTextField JTHargaSatuan;
    private KomponenGUI.JtextF JTJenisKendaraan;
    private KomponenGUI.JNumberOnly JTJumlah;
    private KomponenGUI.JtextF JTNamaSupir;
    private KomponenGUI.JtextF JTNoTransaksi;
    private KomponenGUI.JtextF JTStock;
    private KomponenGUI.JRibuanTextField JTSubTotal;
    private KomponenGUI.JtableF JTable;
    private KomponenGUI.JlableF LBNoTransaksi;
    public static KomponenGUI.JlableF LBTujuan;
    private KomponenGUI.JbuttonF hapustable;
    private KomponenGUI.JbuttonF hapustable1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF5;
    private KomponenGUI.JbuttonF jbuttonF6;
    private KomponenGUI.JbuttonF jbuttonF7;
    private KomponenGUI.JtextF jlabelF10;
    private KomponenGUI.JtextF jlabelF11;
    private KomponenGUI.JtextF jlabelF7;
    private KomponenGUI.JtextF jlabelF8;
    private KomponenGUI.JtextF jlabelF9;
    private KomponenGUI.JlableF jlableF10;
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
    private KomponenGUI.JbuttonF tambahtable;
    private KomponenGUI.JbuttonF ubahtable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void TambahTabel() {
        if (checkTable()) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JCNamaBarang.getSelectedItem(), JTJumlah.getText(), JTHargaSatuan.getText(), JTSubTotal.getText()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah Permintaan");
            JCNamaBarang.requestFocus();
            RefreshTbl();
        }
    }

    void ubahtable() {
        if (checkTableUbah()) {
            JTable.setValueAt(JCNamaBarang.getSelectedItem(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTJumlah.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTHargaSatuan.getText(), JTable.getSelectedRow(), 3);
            JTable.setValueAt(JTSubTotal.getText(), JTable.getSelectedRow(), 4);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
            RefreshTbl();
            JCNamaBarang.requestFocus();
        }
    }

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
                        Berhasil = multiInsert.Excute("INSERT INTO `tbpenjualan`(`NoTransaksi`, `Tanggal`, `IdJenisPenjualan`, `IdKendaraan`, `IdGudang`, `Keterangan`) VALUES ('" + JTNoTransaksi.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdJenisPenjualan` FROM `tbsmjenispenjualan` WHERE `JenisPenjualan` = '" + JCJenisPenjualan.getSelectedItem() + "'),(SELECT `IdKendaraan` FROM `tbmkendaraan` WHERE `Plat` = '" + JCPlat.getSelectedItem() + "'),(SELECT `IdGudang` FROM `tbmgudang` WHERE `Gudang` = '" + JCTujuan.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    } else if (JCJenisPenjualan.getSelectedItem().equals("PENJUALAN")) {
                        Berhasil = multiInsert.Excute("INSERT INTO `tbpenjualan`(`NoTransaksi`, `Tanggal`, `IdJenisPenjualan`, `IdKendaraan`, `IdPenerima`, `Keterangan`) VALUES ('" + JTNoTransaksi.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdJenisPenjualan` FROM `tbsmjenispenjualan` WHERE `JenisPenjualan` = '" + JCJenisPenjualan.getSelectedItem() + "'),(SELECT `IdKendaraan` FROM `tbmkendaraan` WHERE `Plat` = '" + JCPlat.getSelectedItem() + "'),(SELECT `Idpenerima` FROM `tbmpenerima` WHERE `Penerima` = '" + JCTujuan.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    }
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbpenjualandetail`(`NoTransaksi`, `NoKolom`, `IdBarang`, `Jumlah`, `HargaSatuan`) VALUES ('" + JTNoTransaksi.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2).toString().replace(".", "") + "','" + JTable.getValueAt(i, 3).toString().replace(".", "") + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Penjualan");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Penjualan");
                multiInsert.Commit();
                multiInsert.closecon();
                if (tutup) {
                    GlobalVar.Var.tambahPenjualan.dispose();
                    GlobalVar.Var.tambahPenjualan = null;
                } else {
                    JTAKeterangan.setText("");
                    JTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "No", "Nama Barang", "Jumlah", "Harga Satuan", "Sub Total"
                            }
                    ));
                    RefreshTbl();
                    JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                    JTable.getColumnModel().getColumn(1).setPreferredWidth(310);
                    JTable.getColumnModel().getColumn(2).setPreferredWidth(85);
                    JTable.getColumnModel().getColumn(3).setPreferredWidth(115);
                    JTNoTransaksi.setText(getNoPenjualan());
                }
                if (GlobalVar.Var.listPenjualan != null) {
                    GlobalVar.Var.listPenjualan.load();
                }
            }
        }
    }

    void ubahData() {
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
                    Berhasil = multiInsert.Excute("UPDATE `tbpenjualan` SET `NoTransaksi`='" + JTNoTransaksi.getText() + "',`Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdJenisPenjualan`=(SELECT `IdJenisPenjualan` FROM `tbsmjenispenjualan` WHERE `JenisPenjualan` = '" + JCJenisPenjualan.getSelectedItem() + "'),`IdKendaraan`=(SELECT `IdKendaraan` FROM `tbmkendaraan` WHERE `Plat` = '" + JCPlat.getSelectedItem() + "'),`IdGudang`=(SELECT `IdGudang` FROM `tbmgudang` WHERE `Gudang` = '" + JCTujuan.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `NoTransaksi` = '" + JTNoTransaksi.getText() + "'", null);
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbpenjualandetail` WHERE `NoTransaksi` = '" + JTNoTransaksi.getText() + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbpenjualandetail`(`NoTransaksi`, `NoKolom`, `IdBarang`, `Jumlah`, `HargaSatuan`) VALUES ('" + JTNoTransaksi.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2).toString().replace(".", "") + "','" + JTable.getValueAt(i, 3).toString().replace(".", "") + "')", null);
                            }
                        }
                    }
                }
                if (Berhasil == false) {
                    multiInsert.rollback();
                    multiInsert.closecon();
                    JOptionPane.showMessageDialog(this, "Gagal Ubah Data Penjualan");
                }
                if (Berhasil == true) {
                    JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Penjualan");
                    multiInsert.Commit();
                    multiInsert.closecon();
                    GlobalVar.Var.ubahPenjualan.dispose();
                    GlobalVar.Var.ubahPenjualan = null;
                    if (GlobalVar.Var.listPenjualan != null) {
                        GlobalVar.Var.listPenjualan.load();
                    }
                }
            }
        }
    }

    void printing() {
        String NamaSupir = JTNamaSupir.getText();
        String Plat = JCPlat.getSelectedItem().toString();
        String JenisKendaraan = JTJenisKendaraan.getText();
        String NoTransaksi = JTNoTransaksi.getText();
        String Tujuan = JCTujuan.getSelectedItem().toString();
        String Tanggal = datetostr(JDTanggal.getDate(), "dd-MM-yyyy");
        String Keterangan = JTAKeterangan.getText();

        String[] Barang = new String[JTable.getRowCount()];
        int[] Jumlah = new int[JTable.getRowCount()];
        String[] Jumlahs = new String[JTable.getRowCount()];
        int[] Harga = new int[JTable.getRowCount()];
        String[] Hargas = new String[JTable.getRowCount()];
        int[] Sub = new int[JTable.getRowCount()];
        String[] Subs = new String[JTable.getRowCount()];

        for (int i = 0; i < JTable.getRowCount(); i++) {
            Barang[i] = JTable.getValueAt(0, 1).toString();
            Jumlah[i] = Integer.parseInt(JTable.getValueAt(0, 2).toString().replace(".", ""));
            Jumlahs[i] = Intformatdigit(Jumlah[i]);
            Harga[i] = Integer.parseInt(JTable.getValueAt(0, 3).toString().replace(".", ""));
            Hargas[i] = Intformatdigit(Harga[i]);
            Sub[i] = Integer.parseInt(JTable.getValueAt(0, 4).toString().replace(".", ""));
            Subs[i] = Intformatdigit(Sub[i]);
        }

        int Total = getGrandTotal();
        String terbilang = "";
        String Totals = Intformatdigit(Total);
        terbilang = angkaToTerbilang(Long.valueOf(Total));
        if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
            String leftAlignFormat = "%-5s%-37s%-9s%-15s%-13s%-1s%n";
            String OutFormat = "";
            OutFormat += format("%-81s%n", " _____________________________________________________________________________");
            OutFormat += format("%-54s%-26s%n", " SURAT JALAN", "No Transaksi: " + NoTransaksi);
            OutFormat += format("%-54s%-26s%n", " ", "    Tanggal : " + Tanggal);
            if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
                OutFormat += format("%-54s%-26s%n", " Ke Gudang : " + Tujuan, " ");
            } else {
                OutFormat += format("%-54s%-26s%n", " Kepada    : " + Tujuan, " ");
            }
            OutFormat += format("%-54s%-26s%n", " Plat      : " + Plat, " ");
            OutFormat += format("%-54s%-26s%n", " Kendaraan : " + JenisKendaraan, " ");
            //                              12341234567890123456789012345678901234567812345678912345678901234512345678901234
            //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            OutFormat += format("%-80s%n", " | NO| NAMA BARANG                        | JUMLAH | HARGA SATUAN |  SUB TOTAL |");
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            for (int i = 0; i < 6; i++) {
                if (i < JTable.getRowCount()) {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + Barang[i], "|" + format("%7s", Jumlahs[i]), "|" + format("%13s", Hargas[i]), "|" + format("%11s", Subs[i]), "|");
                } else {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "|" + " ", "|" + " ", "|" + " ", "|" + " ", "|");
                }
            }
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            OutFormat += format("%-23s%-43s%-13s%-1s%n", " | GRAND TOTAL", " ", "|" + format("%11s", Totals), "|");
            OutFormat += format("%-80s%n", " +----------------------------------------------------------------+------------+");
            OutFormat += format("%-80s%n", " Ket : " + Keterangan);
            OutFormat += format("%n", "");
            OutFormat += format("%-80s%n", " Terbilang : " + terbilang + "RUPIAH");
            OutFormat += format("%n", "");
            OutFormat += format("%-67s%-24s%n", " Disiapkan Oleh", "Diterima Oleh \n \n ");
            OutFormat += format("%-67s%-24s%n", " HENDRI", NamaSupir);
            OutFormat += format("%-80s%n", " ______________________________________________________________________________");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            System.out.println(OutFormat);
            directprinting(OutFormat);
        } else {
            String leftAlignFormat = "%-5s%-37s%-9s%-15s%-13s%-1s%n";
            String OutFormat = "";
            OutFormat += format("%-81s%n", " _____________________________________________________________________________");
            OutFormat += format("%-54s%-26s%n", " FAKTUR PENJUALAN", "No Transaksi: " + NoTransaksi);
            OutFormat += format("%-54s%-26s%n", " ", "    Tanggal : " + Tanggal);
            if (JCJenisPenjualan.getSelectedItem().equals("MUTASI GUDANG")) {
                OutFormat += format("%-54s%-26s%n", " Ke Gudang : " + Tujuan, " ");
            } else {
                OutFormat += format("%-54s%-26s%n", " Kepada    : " + Tujuan, " ");
            }
            OutFormat += format("%-54s%-26s%n", " Plat      : " + Plat, " ");
            OutFormat += format("%-54s%-26s%n", " Kendaraan : " + JenisKendaraan, " ");
            //                              12341234567890123456789012345678901234567812345678912345678901234512345678901234
            //                              12345678901234567890123456789012345678901234567890123456789012345678901234567890
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            OutFormat += format("%-80s%n", " | NO| NAMA BARANG                        | JUMLAH | HARGA SATUAN |  SUB TOTAL |");
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            for (int i = 0; i < 6; i++) {
                if (i < JTable.getRowCount()) {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "| " + Barang[i], "|" + format("%7s", Jumlahs[i]), "|" + format("%13s", Hargas[i]), "|" + format("%11s", Subs[i]), "|");
                } else {
                    OutFormat += format(leftAlignFormat, " | " + (i + 1), "|" + " ", "|" + " ", "|" + " ", "|" + " ", "|");
                }
            }
            OutFormat += format("%-80s%n", " +---+------------------------------------+--------+--------------+------------+");
            OutFormat += format("%-23s%-43s%-13s%-1s%n", " | GRAND TOTAL", " ", "|" + format("%11s", Totals), "|");
            OutFormat += format("%-80s%n", " +----------------------------------------------------------------+------------+");
            OutFormat += format("%-80s%n", " Ket : " + Keterangan);
            OutFormat += format("%n", "");
            OutFormat += format("%-80s%n", " Terbilang : " + terbilang + "RUPIAH");
            OutFormat += format("%n", "");
            OutFormat += format("%-67s%-24s%n", " Disiapkan Oleh", "Diterima Oleh \n \n ");
            OutFormat += format("%-67s%-24s%n", " HENDRI", NamaSupir);
            OutFormat += format("%-80s%n", " ______________________________________________________________________________");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            OutFormat += format("%n", "");
            System.out.println(OutFormat);
            directprinting(OutFormat);
        }
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
        return output;
    }

    String Decformatdigit(double Number) {
        double value = 0;
        value = Number;
        String output;
        if (value < 0) {
            value = abs(value);
            String pattern = "#,###,###.00";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = "-" + myFormatter.format(value);
        } else {
            String pattern = "#,###,###.00";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = myFormatter.format(value);
        }
        return output;
    }

    Integer getGrandTotal() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + (Integer.valueOf(JTable.getValueAt(x, 2).toString().replace(",", "")) * Integer.valueOf(JTable.getValueAt(x, 3).toString().replace(",", "")));
        }
        return GrandTotal;
    }

    public static String angkaToTerbilang(Long angka) {
        String[] huruf = {"", "SATU", "DUA", "TIGA", "EMPAT", "LIMA", "ENAM", "TUJUH", "DELAPAN", "SEMBILAN", "SEPULUH", "SEBELAS"};
        if (angka < 12) {
            return huruf[angka.intValue()];
        }
        if (angka >= 12 && angka <= 19) {
            return huruf[angka.intValue() % 10] + " BELAS";
        }
        if (angka >= 20 && angka <= 99) {
            return angkaToTerbilang(angka / 10) + " PULUH " + huruf[angka.intValue() % 10];
        }
        if (angka >= 100 && angka <= 199) {
            return "SERATUS " + angkaToTerbilang(angka % 100);
        }
        if (angka >= 200 && angka <= 999) {
            return angkaToTerbilang(angka / 100) + " RATUS " + angkaToTerbilang(angka % 100);
        }
        if (angka >= 1000 && angka <= 1999) {
            return "SERIBU " + angkaToTerbilang(angka % 1000);
        }
        if (angka >= 2000 && angka <= 999999) {
            return angkaToTerbilang(angka / 1000) + " RIBU " + angkaToTerbilang(angka % 1000);
        }
        if (angka >= 1000000 && angka <= 999999999) {
            return angkaToTerbilang(angka / 1000000) + " JUTA " + angkaToTerbilang(angka % 1000000);
        }
        if (angka >= 1000000000 && angka <= 999999999999L) {
            return angkaToTerbilang(angka / 1000000000) + " MILYAR " + angkaToTerbilang(angka % 1000000000);
        }
        if (angka >= 1000000000000L && angka <= 999999999999999L) {
            return angkaToTerbilang(angka / 1000000000000L) + " TRILIUN " + angkaToTerbilang(angka % 1000000000000L);
        }
        if (angka >= 1000000000000000L && angka <= 999999999999999999L) {
            return angkaToTerbilang(angka / 1000000000000000L) + " QUADRILYUN " + angkaToTerbilang(angka % 1000000000000000L);
        }
        return "";
    }

    void setStok() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal setStok()");
        dRunSelctOne.setQuery("SELECT `IdBarang`, `NamaBarang`, SUM(`Stok`) as 'Stok', SUM(`KG`) as 'KG' FROM (\n"
                + "SELECT `IdBarang`, `NamaBarang`, 0 as 'Stok', 0 as 'KG' FROM `tbmbarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + "UNION ALL\n"
                + "SELECT a.`IdBarang`, `NamaBarang`, ifnull(`KarungPelita`,0) AS 'Stok', ifnull(`NettoPelita`,0) AS 'KG' FROM `tbpenerimaan`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + "UNION ALL\n"
                + "SELECT a.`IdBarang`, `NamaBarang`, ifnull(`Jumlah`*-1,0) AS 'Stok', ifnull(`Jumlah`*-1*`Satuan`,0) AS 'KG' FROM `tbpenjualandetail`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbpenjualan`c ON a.`NoTransaksi`=c.`NoTransaksi` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + "UNION ALL\n"
                + "SELECT  `IdBarangBahan`, `NamaBarang`, (ROUND(`JumlahBahan` * 10) / 10 )*-1 AS 'Stok', `JumlahBahan`*`Satuan`*-1 AS 'KG' FROM `tbpacking`a JOIN `tbmbarang`b ON a.`IdBarangBahan`=b.`IdBarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + "UNION ALL\n"
                + "SELECT  `IdBarangHasil`, `NamaBarang`, (ROUND(`JumlahHasil` * 10 ) / 10) AS 'Stok', `JumlahHasil`*`Satuan` AS 'KG' FROM `tbpacking`a JOIN `tbmbarang`b ON a.`IdBarangHasil`=b.`IdBarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + "UNION ALL\n"
                + "SELECT a.`IdBarang`, `NamaBarang`, ifnull(`Sak`,0) AS 'Stok', ifnull(`Jumlah`,0) AS 'KG' FROM `tbpenyesuaian`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'\n"
                + ") as tbTemp GROUP BY `IdBarang`");
        ArrayList<String> list = dRunSelctOne.excute();
        double dobel = Double.valueOf(list.get(2));
        JTStock.setText(Decformatdigit(dobel));
    }

}
