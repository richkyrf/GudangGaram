/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Master;

import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.Update;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author richky
 */
public class MasterBarang extends javax.swing.JFrame {

    /**
     * Creates new form MasterBarang
     */
    String IdEdit;

    public MasterBarang() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF3.setVisible(false);
        jlableF14.setEnabled(false);
        jlableF16.setEnabled(false);
        JTHarga.setEnabled(false);
        jlableF2.setEnabled(false);
        jlableF7.setEnabled(false);
        JLIsi.setText("Isi Dalam 1 Sak");
        JLSatuan.setText("Total KG Per Sak");
        JCPlastikDalam.setEnabled(false);
        jlableF9.setEnabled(false);
        jlableF10.setEnabled(false);
        jbuttonF6.setEnabled(false);
        JCPlastikLuar.setEnabled(false);
        jlableF20.setEnabled(false);
        jlableF21.setEnabled(false);
        jbuttonF7.setEnabled(false);
        JTUpahPacking.setEnabled(false);
    }

    public MasterBarang(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF1.setVisible(false);
        jbuttonF2.setVisible(false);
        loadeditdata();
    }

    void loadeditdata() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `IdBarang` as 'ID', `NamaBarang` as 'Nama', `JenisBarang` as 'Jenis', `Pemasok`, `Isi`, a.`Satuan`, `Harga`, `UpahPacking` as 'Upah', d.`NamaBarangLain` as 'Plastik Dalam', e.`NamaBarangLain` as 'Plastik Luar', a.`Keterangan`, IF(`Status`=1,'Aktif','Tidak Aktif') as 'Status' FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` LEFT JOIN `tbmpemasok`c ON a.`IdPemasok`=c.`IdPemasok` LEFT JOIN `tbmbaranglain`d ON a.`IdPlastikDalam`=d.`IdBarangLain` LEFT JOIN `tbmbaranglain`e ON a.`IdPlastikLuar`=e.`IdBarangLain` WHERE `IdBarang` = " + IdEdit);
        ArrayList<String> list = dRunSelctOne.excute();
        JTNamaBarang.setText(list.get(1));
        JCJenisBarang.setSelectedItem(list.get(2));
        if (list.get(2).toUpperCase().equals("BAHAN") || list.get(1).toUpperCase().contains("@50 KG")) {
            JCPemasok.setSelectedItem(list.get(3));
            jlableF14.setEnabled(false);
            jlableF16.setEnabled(false);
            JTHarga.setEnabled(false);
            jlableF2.setEnabled(false);
            jlableF7.setEnabled(false);
            JLIsi.setText("Isi Dalam 1 Sak");
            JLSatuan.setText("Total KG Per Sak");
            JCPlastikDalam.setEnabled(false);
            jlableF9.setEnabled(false);
            jlableF10.setEnabled(false);
            jbuttonF6.setEnabled(false);
            JCPlastikLuar.setEnabled(false);
            jlableF20.setEnabled(false);
            jlableF21.setEnabled(false);
            jbuttonF7.setEnabled(false);
            JTUpahPacking.setEnabled(false);
        } else {
            JLIsi.setText("Isi Dalam 1 Pak");
            JLSatuan.setText("Total KG Per Pak");
            JCPlastikDalam.setSelectedItem(list.get(8));
            JCPlastikLuar.setSelectedItem(list.get(9));
        }
        JTIsi.setText(list.get(4));
        JTSatuan.setText(list.get(5).substring(0, (list.get(5).length() - 3)));
        JTKoma.setText(list.get(5).substring((list.get(5).length() - 2), list.get(5).length()));
        JTHarga.setText(list.get(6));
        JTUpahPacking.setText(list.get(7));
        JTAKeterangan.setText(list.get(10));
        JCBStatus.setSelected(list.get(11).equals("Aktif"));
    }

    Boolean checkInput() {
        if (JTNamaBarang.getText().replace(" ", "").equals("")) {
            JOptionPane.showMessageDialog(this, "Nama Tidak Boleh Kosong");
            return false;
        } else if (JTIsi.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Isi Tidak Boleh Kosong");
            return false;
        } else if (JTSatuan.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Satuan KG Tidak Boleh Kosong");
            return false;
        } else if (JCPlastikDalam.getSelectedIndex() == 0 && JCJenisBarang.getSelectedItem().equals("HASIL") && !JTNamaBarang.getText().toUpperCase().contains("@50 KG")) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Plastik Dalam Terlebih Dahulu");
            return false;
        } else if (JCPlastikLuar.getSelectedIndex() == 0 && JCJenisBarang.getSelectedItem().equals("HASIL") && !JTNamaBarang.getText().toUpperCase().contains("@50 KG")) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Plastik Luar Terlebih Dahulu");
            return false;
        }
        return true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JTNamaBarang = new KomponenGUI.JtextF();
        JCBStatus = new KomponenGUI.JCheckBoxF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jlableF11 = new KomponenGUI.JlableF();
        jlableF12 = new KomponenGUI.JlableF();
        JCJenisBarang = new KomponenGUI.JcomboboxF();
        JLSatuan = new KomponenGUI.JlableF();
        jlableF14 = new KomponenGUI.JlableF();
        jlableF15 = new KomponenGUI.JlableF();
        jlableF16 = new KomponenGUI.JlableF();
        jlableF17 = new KomponenGUI.JlableF();
        jlableF18 = new KomponenGUI.JlableF();
        JCPemasok = new KomponenGUI.JcomboboxF();
        jbuttonF5 = new KomponenGUI.JbuttonF();
        JTKoma = new KomponenGUI.JtKoma();
        jlableF19 = new KomponenGUI.JlableF();
        JTUpahPacking = new KomponenGUI.JRibuanTextField();
        JTHarga = new KomponenGUI.JRibuanTextField();
        JTSatuan = new KomponenGUI.JRibuanTextField();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        JCPlastikDalam = new KomponenGUI.JcomboboxF();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        jlableF20 = new KomponenGUI.JlableF();
        jlableF21 = new KomponenGUI.JlableF();
        JCPlastikLuar = new KomponenGUI.JcomboboxF();
        jbuttonF7 = new KomponenGUI.JbuttonF();
        JTIsi = new KomponenGUI.JRibuanTextField();
        jlableF22 = new KomponenGUI.JlableF();
        JLIsi = new KomponenGUI.JlableF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("Nama Barang");

        jlableF2.setText("Upah Packing");

        jlableF3.setText("Keterangan");

        jlableF4.setText("Status");

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTAKeterangan);

        JTNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNamaBarangKeyPressed(evt);
            }
        });
        JTNamaBarang.setMaxText(30);

        JCBStatus.setText("Aktif");

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

        jlableF5.setText(":");

        jlableF6.setText(":");

        jlableF7.setText(":");

        jlableF8.setText(":");

        jbuttonF3.setText("Ubah");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jlableF11.setText("Jenis Barang");

        jlableF12.setText(":");

        JCJenisBarang.load("SELECT `JenisBarang` FROM `tbsmjenisbarang` ");
        JCJenisBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCJenisBarangItemStateChanged(evt);
            }
        });
        JCJenisBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCJenisBarangKeyPressed(evt);
            }
        });

        JLSatuan.setText("Total KG / Sak");

        jlableF14.setText("Harga Jual");

        jlableF15.setText(":");

        jlableF16.setText(":");

        jlableF17.setText("Pemasok");

        jlableF18.setText(":");

        JCPemasok.load("SELECT `Pemasok` FROM `tbmpemasok` ");
        JCPemasok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPemasokKeyPressed(evt);
            }
        });

        jbuttonF5.setText("+");
        jbuttonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF5ActionPerformed(evt);
            }
        });

        JTKoma.setText("00");
        JTKoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKomaKeyPressed(evt);
            }
        });

        jlableF19.setText(",");

        JTUpahPacking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTUpahPackingKeyPressed(evt);
            }
        });

        JTHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTHargaKeyPressed(evt);
            }
        });

        JTSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTSatuanKeyPressed(evt);
            }
        });

        jlableF9.setText("Plastik Dalam");

        jlableF10.setText(":");

        JCPlastikDalam.load("SELECT '-- Pilih Plastik Dalam --' as 'NamaBarangLain' UNION ALL SELECT `NamaBaranglain` FROM `tbmbaranglain` WHERE `IdJenisBarangLain` = 1");
        JCPlastikDalam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPlastikDalamKeyPressed(evt);
            }
        });

        jbuttonF6.setText("+");
        jbuttonF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF6ActionPerformed(evt);
            }
        });

        jlableF20.setText("Plastik Luar");

        jlableF21.setText(":");

        JCPlastikLuar.load("SELECT '-- Pilih Plastik Luar --' as 'NamaBarangLain' UNION ALL SELECT `NamaBaranglain` FROM `tbmbaranglain` WHERE `IdJenisBarangLain` = 2");
        JCPlastikLuar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPlastikLuarKeyPressed(evt);
            }
        });

        jbuttonF7.setText("+");
        jbuttonF7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF7ActionPerformed(evt);
            }
        });

        JTIsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTIsiKeyPressed(evt);
            }
        });

        jlableF22.setText(":");

        JLIsi.setText("Isi Dalam 1 Sak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jlableF17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlableF11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlableF1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                            .addComponent(JLSatuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JTKoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCPemasok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JCJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlableF20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jlableF3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                            .addComponent(JTUpahPacking, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCBStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCPlastikDalam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCPlastikLuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTUpahPacking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPlastikDalam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPlastikLuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
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

    private void JTNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCJenisBarang.requestFocus();
        }
    }//GEN-LAST:event_JTNamaBarangKeyPressed

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (IdEdit == null) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void JCJenisBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCJenisBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JCPemasok.isVisible()) {
                JCPemasok.requestFocus();
            } else {
                JTIsi.requestFocus();
            }
        }
    }//GEN-LAST:event_JCJenisBarangKeyPressed

    private void JTHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTHargaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTUpahPacking.requestFocus();
        }
    }//GEN-LAST:event_JTHargaKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            GlobalVar.Var.tambahBarang = null;
        } else {
            GlobalVar.Var.ubahBarang = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JCPemasokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPemasokKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTIsi.requestFocus();
        }
    }//GEN-LAST:event_JCPemasokKeyPressed

    private void JCJenisBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCJenisBarangItemStateChanged
        if (JCJenisBarang.getSelectedItem().toString().toUpperCase().equals("BAHAN")) {
            jlableF17.setVisible(true);
            jlableF18.setVisible(true);
            JCPemasok.setVisible(true);
            jbuttonF5.setVisible(true);
            jlableF14.setEnabled(false);
            jlableF16.setEnabled(false);
            JTHarga.setEnabled(false);
            jlableF2.setEnabled(false);
            jlableF7.setEnabled(false);
            JLIsi.setText("Isi Dalam 1 Sak");
            JLSatuan.setText("Total KG Per Sak");
            JCPlastikDalam.setEnabled(false);
            jlableF9.setEnabled(false);
            jlableF10.setEnabled(false);
            jbuttonF6.setEnabled(false);
            JCPlastikLuar.setEnabled(false);
            jlableF20.setEnabled(false);
            jlableF21.setEnabled(false);
            jbuttonF7.setEnabled(false);
            JTUpahPacking.setEnabled(false);
        } else {
            jlableF17.setVisible(false);
            jlableF18.setVisible(false);
            JCPemasok.setVisible(false);
            jbuttonF5.setVisible(false);
            jlableF14.setEnabled(true);
            jlableF16.setEnabled(true);
            JTHarga.setEnabled(true);
            jlableF2.setEnabled(true);
            jlableF7.setEnabled(true);
            JLIsi.setText("Isi Dalam 1 Pak");
            JLSatuan.setText("Total KG Per Pak");
            JCPlastikDalam.setEnabled(true);
            jlableF9.setEnabled(true);
            jlableF10.setEnabled(true);
            jbuttonF6.setEnabled(true);
            JCPlastikLuar.setEnabled(true);
            jlableF20.setEnabled(true);
            jlableF21.setEnabled(true);
            jbuttonF7.setEnabled(true);
            JTUpahPacking.setEnabled(true);
        }
    }//GEN-LAST:event_JCJenisBarangItemStateChanged

    private void jbuttonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF5ActionPerformed
        if (GlobalVar.Var.tambahPemasok == null) {
            GlobalVar.Var.tambahPemasok = new Masters("0", "Pemasok");
        } else {
            GlobalVar.Var.tambahPemasok.setState(NORMAL);
            GlobalVar.Var.tambahPemasok.toFront();
        }
    }//GEN-LAST:event_jbuttonF5ActionPerformed

    private void JTUpahPackingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTUpahPackingKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JCPlastikDalam.isEnabled()) {
                JCPlastikDalam.requestFocus();
            } else {
                JTAKeterangan.requestFocus();
            }
        }
    }//GEN-LAST:event_JTUpahPackingKeyPressed

    private void JTKomaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKomaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JTHarga.isEnabled()) {
                JTHarga.requestFocus();
            } else {
                JTAKeterangan.requestFocus();
            }
        }
    }//GEN-LAST:event_JTKomaKeyPressed

    private void JTSatuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTSatuanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKoma.requestFocus();
        }
    }//GEN-LAST:event_JTSatuanKeyPressed

    private void JCPlastikDalamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPlastikDalamKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPlastikLuar.requestFocus();
        }
    }//GEN-LAST:event_JCPlastikDalamKeyPressed

    private void jbuttonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF6ActionPerformed
        if (GlobalVar.Var.tambahBarangLain == null) {
            GlobalVar.Var.tambahBarangLain = new MasterBarangLain();
            GlobalVar.Var.tambahBarangLain.JCJenisBarangLain.setSelectedIndex(0);
            GlobalVar.Var.tambahBarangLain.JCJenisBarangLain.setEnabled(false);
        } else {
            GlobalVar.Var.tambahBarangLain.setState(NORMAL);
            GlobalVar.Var.tambahBarangLain.toFront();
        }
    }//GEN-LAST:event_jbuttonF6ActionPerformed

    private void JCPlastikLuarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPlastikLuarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JCPlastikLuarKeyPressed

    private void jbuttonF7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF7ActionPerformed
        if (GlobalVar.Var.tambahBarangLain == null) {
            GlobalVar.Var.tambahBarangLain = new MasterBarangLain();
            GlobalVar.Var.tambahBarangLain.JCJenisBarangLain.setSelectedIndex(1);
            GlobalVar.Var.tambahBarangLain.JCJenisBarangLain.setEnabled(false);
        } else {
            GlobalVar.Var.tambahBarangLain.setState(NORMAL);
            GlobalVar.Var.tambahBarangLain.toFront();
        }
    }//GEN-LAST:event_jbuttonF7ActionPerformed

    private void JTIsiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTIsiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTSatuan.requestFocus();
        }
    }//GEN-LAST:event_JTIsiKeyPressed

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
            java.util.logging.Logger.getLogger(MasterBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JCheckBoxF JCBStatus;
    public static KomponenGUI.JcomboboxF JCJenisBarang;
    public static KomponenGUI.JcomboboxF JCPemasok;
    public static KomponenGUI.JcomboboxF JCPlastikDalam;
    public static KomponenGUI.JcomboboxF JCPlastikLuar;
    private KomponenGUI.JlableF JLIsi;
    private KomponenGUI.JlableF JLSatuan;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTHarga;
    private KomponenGUI.JRibuanTextField JTIsi;
    private KomponenGUI.JtKoma JTKoma;
    private KomponenGUI.JtextF JTNamaBarang;
    private KomponenGUI.JRibuanTextField JTSatuan;
    private KomponenGUI.JRibuanTextField JTUpahPacking;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF5;
    private KomponenGUI.JbuttonF jbuttonF6;
    private KomponenGUI.JbuttonF jbuttonF7;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF11;
    private KomponenGUI.JlableF jlableF12;
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
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    String getIdPemasok() {
        if (JCPemasok.isVisible()) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Get ID Pemasok");
            dRunSelctOne.setQuery("SELECT `IdPemasok` FROm `tbmpemasok` WHERE `Pemasok` = '" + JCPemasok.getSelectedItem() + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            return list.get(0);
        } else {
            return null;
        }
    }

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            Insert insert = new Insert();
            Boolean berhasil = insert.simpan("INSERT INTO `tbmbarang`(`NamaBarang`, `IdJenisBarang`, `IdPemasok`, `Isi`, `Satuan`, `Harga`, `UpahPacking`, `IdPlastikDalam`, `IdPlastikLuar`, `Keterangan`, `Status`) VALUES ('" + JTNamaBarang.getText() + "',(SELECT `IdJenisBarang` FROM `tbsmjenisbarang` WHERE `JenisBarang` = '" + JCJenisBarang.getSelectedItem() + "')," + getIdPemasok() + ",'" + JTIsi.getInt() + "','" + JTSatuan.getText() + "." + JTKoma.getText() + "','" + JTHarga.getInt() + "','" + JTUpahPacking.getInt() + "',(SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCPlastikDalam.getSelectedItem() + "'),(SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCPlastikLuar.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "'," + JCBStatus.isSelected() + ")", "Barang", this);
            if (berhasil) {
                if (GlobalVar.Var.tambahPartai != null) {
                    GlobalVar.Var.tambahPartai.JCNamaBarang.load("SELECT `NamaBarang` FROM `tbmbarang`a LEFT JOIN `tbmpemasok`b ON a.`IdPemasok`=b.`IdPemasok` JOIN `tbsmjenisbarang`c ON a.`IdJenisBarang`=c.`IdJenisBarang` WHERE `JenisBarang` = 'Bahan' AND `Pemasok` = '" + JCPemasok.getSelectedItem() + "'");
                    GlobalVar.Var.tambahPartai.JCNamaBarang.setSelectedItem(JTNamaBarang.getText());
                    GlobalVar.Var.tambahPartai.JCNamaBarang.requestFocus();
                }
                if (GlobalVar.Var.ubahPartai != null) {
                    GlobalVar.Var.ubahPartai.JCNamaBarang.load("SELECT `NamaBarang` FROM `tbmbarang`a LEFT JOIN `tbmpemasok`b ON a.`IdPemasok`=b.`IdPemasok` JOIN `tbsmjenisbarang`c ON a.`IdJenisBarang`=c.`IdJenisBarang` WHERE `JenisBarang` = 'Bahan' AND `Pemasok` = '" + JCPemasok.getSelectedItem() + "'");
                    GlobalVar.Var.ubahPartai.JCNamaBarang.setSelectedItem(JTNamaBarang.getText());
                    GlobalVar.Var.ubahPartai.JCNamaBarang.requestFocus();
                }
                if (GlobalVar.Var.listBarang != null) {
                    GlobalVar.Var.listBarang.load();
                }
                if (tutup) {
                    dispose();
                } else {
                    JTNamaBarang.setText("");
                    JTSatuan.setText("0");
                    JTHarga.setText("0");
                    JTUpahPacking.setText("0");
                    JTAKeterangan.setText("");
                    JTNamaBarang.requestFocus();
                }
            }
        }
    }

    void ubahData() {
        if (checkInput()) {
            Update update = new Update();
            Boolean berhasil = update.Ubah("UPDATE `tbmbarang` SET `NamaBarang`='" + JTNamaBarang.getText() + "',`IdJenisBarang`=(SELECT `IdJenisBarang` FROM `tbsmjenisbarang` WHERE `JenisBarang` = '" + JCJenisBarang.getSelectedItem() + "'),`IdPemasok`=" + getIdPemasok() + ",`Isi`='" + JTIsi.getInt() + "',`Satuan`='" + JTSatuan.getText() + "." + JTKoma.getText() + "',`Harga`='" + JTHarga.getInt() + "',`UpahPacking`='" + JTUpahPacking.getInt() + "',`IdPlastikDalam`=(SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCPlastikDalam.getSelectedItem() + "'),`IdPlastikLuar`=(SELECT `IdBarangLain` FROM `tbmbaranglain` WHERE `NamaBarangLain` = '" + JCPlastikLuar.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "',`Status`=" + JCBStatus.isSelected() + " WHERE `IdBarang` = " + IdEdit, "Barang", this);
            if (berhasil) {
                dispose();
                if (GlobalVar.Var.listBarang != null) {
                    GlobalVar.Var.listBarang.load();
                }
            }
        }
    }

}
