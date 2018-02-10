/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Laporan.*;
import Proses.*;
import List.*;

/**
 *
 * @author richk
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menu Utama");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JMFile = new javax.swing.JMenu();
        JMITambahUser = new javax.swing.JMenuItem();
        JMIResetPasswordUser = new javax.swing.JMenuItem();
        SFile = new javax.swing.JPopupMenu.Separator();
        JMIGantiPassword = new javax.swing.JMenuItem();
        JMIExit = new javax.swing.JMenuItem();
        JMMaster = new javax.swing.JMenu();
        JMIMasterKaryawan = new javax.swing.JMenuItem();
        JMIMasterBarang = new javax.swing.JMenuItem();
        JMIMasterKendaraan = new javax.swing.JMenuItem();
        JMIMasterGudang = new javax.swing.JMenuItem();
        JMIMasterPemasok = new javax.swing.JMenuItem();
        JMIMasterPeminta = new javax.swing.JMenuItem();
        JMIMasterPenerima = new javax.swing.JMenuItem();
        JMProses = new javax.swing.JMenu();
        JMIProsesAbsenKaryawan = new javax.swing.JMenuItem();
        JMIProsesPenerimaan = new javax.swing.JMenuItem();
        JMIProsesPenjualan = new javax.swing.JMenuItem();
        JMIProsesPacking = new javax.swing.JMenuItem();
        JMIProsesPoles = new javax.swing.JMenuItem();
        JMIProsesPenggajian = new javax.swing.JMenuItem();
        JMIProsesPenyesuaian = new javax.swing.JMenuItem();
        JMList = new javax.swing.JMenu();
        JMIListPenerimaan = new javax.swing.JMenuItem();
        JMIListPenjualan = new javax.swing.JMenuItem();
        JMIListPacking = new javax.swing.JMenuItem();
        JMIListPoles = new javax.swing.JMenuItem();
        JMIListPenyesuaian = new javax.swing.JMenuItem();
        JMLaporan = new javax.swing.JMenu();
        JMILaporanStokHarian = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JMFile.setText("File");

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMITambahUser.setVisible(false);
        }
        JMITambahUser.setText("Tambah User");
        JMITambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITambahUserActionPerformed(evt);
            }
        });
        JMFile.add(JMITambahUser);

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMIResetPasswordUser.setVisible(false);
            SFile.setVisible(false);
        }
        JMIResetPasswordUser.setText("Reset Password User");
        JMIResetPasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIResetPasswordUserActionPerformed(evt);
            }
        });
        JMFile.add(JMIResetPasswordUser);
        JMFile.add(SFile);

        JMIGantiPassword.setText("Ganti Password");
        JMIGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGantiPasswordActionPerformed(evt);
            }
        });
        JMFile.add(JMIGantiPassword);

        JMIExit.setText("Exit");
        JMIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIExitActionPerformed(evt);
            }
        });
        JMFile.add(JMIExit);

        jMenuBar1.add(JMFile);

        JMMaster.setText("Master");

        JMIMasterKaryawan.setText("Master Karyawan");
        JMIMasterKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterKaryawanActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterKaryawan);

        JMIMasterBarang.setText("Master Barang");
        JMIMasterBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterBarangActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterBarang);

        JMIMasterKendaraan.setText("Master Kendaraan");
        JMIMasterKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterKendaraanActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterKendaraan);

        JMIMasterGudang.setText("Master Gudang");
        JMIMasterGudang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterGudangActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterGudang);

        JMIMasterPemasok.setText("Master Pemasok");
        JMIMasterPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterPemasokActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterPemasok);

        JMIMasterPeminta.setText("Master Peminta");
        JMIMasterPeminta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterPemintaActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterPeminta);

        JMIMasterPenerima.setText("Master Penerima");
        JMIMasterPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterPenerimaActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterPenerima);

        jMenuBar1.add(JMMaster);

        JMProses.setText("Proses");

        JMIProsesAbsenKaryawan.setText("Absen Karyawan");
        JMIProsesAbsenKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesAbsenKaryawanActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesAbsenKaryawan);

        JMIProsesPenerimaan.setText("Penerimaan");
        JMIProsesPenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPenerimaanActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPenerimaan);

        JMIProsesPenjualan.setText("Penjualan");
        JMIProsesPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPenjualanActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPenjualan);

        JMIProsesPacking.setText("Packing");
        JMIProsesPacking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPackingActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPacking);

        JMIProsesPoles.setText("Poles");
        JMIProsesPoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPolesActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPoles);

        JMIProsesPenggajian.setText("Penggajian");
        JMIProsesPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPenggajianActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPenggajian);

        JMIProsesPenyesuaian.setText("Penyesuaian");
        JMIProsesPenyesuaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPenyesuaianActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPenyesuaian);

        jMenuBar1.add(JMProses);

        JMList.setText("List");

        JMIListPenerimaan.setText("List Penerimaan");
        JMIListPenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPenerimaanActionPerformed(evt);
            }
        });
        JMList.add(JMIListPenerimaan);

        JMIListPenjualan.setText("List Penjualan");
        JMIListPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPenjualanActionPerformed(evt);
            }
        });
        JMList.add(JMIListPenjualan);

        JMIListPacking.setText("List Packing");
        JMIListPacking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPackingActionPerformed(evt);
            }
        });
        JMList.add(JMIListPacking);

        JMIListPoles.setText("List Poles");
        JMIListPoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPolesActionPerformed(evt);
            }
        });
        JMList.add(JMIListPoles);

        JMIListPenyesuaian.setText("List Penyesuaian");
        JMIListPenyesuaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPenyesuaianActionPerformed(evt);
            }
        });
        JMList.add(JMIListPenyesuaian);

        jMenuBar1.add(JMList);

        JMLaporan.setText("Laporan");

        JMILaporanStokHarian.setText("Laporan Stok Harian");
        JMILaporanStokHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanStokHarianActionPerformed(evt);
            }
        });
        JMLaporan.add(JMILaporanStokHarian);

        jMenuBar1.add(JMLaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMITambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITambahUserActionPerformed
        if (GlobalVar.Var.tambahUser == null) {
            GlobalVar.Var.tambahUser = new TambahUser();
        } else {
            GlobalVar.Var.tambahUser.setState(NORMAL);
            GlobalVar.Var.tambahUser.toFront();
        }
    }//GEN-LAST:event_JMITambahUserActionPerformed

    private void JMIGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGantiPasswordActionPerformed
        if (GlobalVar.Var.gantiPassword == null) {
            GlobalVar.Var.gantiPassword = new GantiPassword();
        } else {
            GlobalVar.Var.gantiPassword.setState(NORMAL);
            GlobalVar.Var.gantiPassword.toFront();
        }
    }//GEN-LAST:event_JMIGantiPasswordActionPerformed

    private void JMIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JMIExitActionPerformed

    private void JMIMasterKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterKaryawanActionPerformed
        if (GlobalVar.Var.listKaryawan == null) {
            GlobalVar.Var.listKaryawan = new ListKaryawan();
        } else {
            GlobalVar.Var.listKaryawan.setState(NORMAL);
            GlobalVar.Var.listKaryawan.toFront();
        }
    }//GEN-LAST:event_JMIMasterKaryawanActionPerformed

    private void JMIMasterBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterBarangActionPerformed
        if (GlobalVar.Var.listBarang == null) {
            GlobalVar.Var.listBarang = new ListBarang();
        } else {
            GlobalVar.Var.listBarang.setState(NORMAL);
            GlobalVar.Var.listBarang.toFront();
        }
    }//GEN-LAST:event_JMIMasterBarangActionPerformed

    private void JMIProsesPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPenerimaanActionPerformed
        if (GlobalVar.Var.tambahPenerimaan == null) {
            GlobalVar.Var.tambahPenerimaan = new Penerimaan();
        } else {
            GlobalVar.Var.tambahPenerimaan.setState(NORMAL);
            GlobalVar.Var.tambahPenerimaan.toFront();
        }
    }//GEN-LAST:event_JMIProsesPenerimaanActionPerformed

    private void JMIListPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPenerimaanActionPerformed
        if (GlobalVar.Var.listPenerimaan == null) {
            GlobalVar.Var.listPenerimaan = new ListPenerimaan();
        } else {
            GlobalVar.Var.listPenerimaan.setState(NORMAL);
            GlobalVar.Var.listPenerimaan.toFront();
        }
    }//GEN-LAST:event_JMIListPenerimaanActionPerformed

    private void JMIProsesPackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPackingActionPerformed
        if (GlobalVar.Var.tambahPacking == null) {
            GlobalVar.Var.tambahPacking = new Packing();
        } else {
            GlobalVar.Var.tambahPacking.setState(NORMAL);
            GlobalVar.Var.tambahPacking.toFront();
        }
    }//GEN-LAST:event_JMIProsesPackingActionPerformed

    private void JMIListPackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPackingActionPerformed
        if (GlobalVar.Var.listPacking == null) {
            GlobalVar.Var.listPacking = new ListPacking();
        } else {
            GlobalVar.Var.listPacking.setState(NORMAL);
            GlobalVar.Var.listPacking.toFront();
        }
    }//GEN-LAST:event_JMIListPackingActionPerformed

    private void JMIProsesPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPenjualanActionPerformed
        if (GlobalVar.Var.tambahPenjualan == null) {
            GlobalVar.Var.tambahPenjualan = new Penjualan();
        } else {
            GlobalVar.Var.tambahPenjualan.setState(NORMAL);
            GlobalVar.Var.tambahPenjualan.toFront();
        }
    }//GEN-LAST:event_JMIProsesPenjualanActionPerformed

    private void JMIListPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPenjualanActionPerformed
        if (GlobalVar.Var.listPenjualan == null) {
            GlobalVar.Var.listPenjualan = new ListPenjualan();
        } else {
            GlobalVar.Var.listPenjualan.setState(NORMAL);
            GlobalVar.Var.listPenjualan.toFront();
        }
    }//GEN-LAST:event_JMIListPenjualanActionPerformed

    private void JMIProsesPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPenggajianActionPerformed
        if (GlobalVar.Var.penggajian == null) {
            GlobalVar.Var.penggajian = new Penggajian();
        } else {
            GlobalVar.Var.penggajian.setState(NORMAL);
            GlobalVar.Var.penggajian.toFront();
        }
    }//GEN-LAST:event_JMIProsesPenggajianActionPerformed

    private void JMIProsesPolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPolesActionPerformed
        if (GlobalVar.Var.poles == null) {
            GlobalVar.Var.poles = new Poles();
        } else {
            GlobalVar.Var.poles.setState(NORMAL);
            GlobalVar.Var.poles.toFront();
        }
    }//GEN-LAST:event_JMIProsesPolesActionPerformed

    private void JMIProsesPenyesuaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPenyesuaianActionPerformed
        if (GlobalVar.Var.tambahPenyesuaian == null) {
            GlobalVar.Var.tambahPenyesuaian = new Penyesuaiann();
        } else {
            GlobalVar.Var.tambahPenyesuaian.setState(NORMAL);
            GlobalVar.Var.tambahPenyesuaian.toFront();
        }
    }//GEN-LAST:event_JMIProsesPenyesuaianActionPerformed

    private void JMIListPenyesuaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPenyesuaianActionPerformed
        if (GlobalVar.Var.listPenyesuaian == null) {
            GlobalVar.Var.listPenyesuaian = new ListPenyesuaian();
        } else {
            GlobalVar.Var.listPenyesuaian.setState(NORMAL);
            GlobalVar.Var.listPenyesuaian.toFront();
        }
    }//GEN-LAST:event_JMIListPenyesuaianActionPerformed

    private void JMILaporanStokHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanStokHarianActionPerformed
        if (GlobalVar.Var.laporanStokHarian == null) {
            GlobalVar.Var.laporanStokHarian = new LaporanStokHarian();
        } else {
            GlobalVar.Var.laporanStokHarian.setState(NORMAL);
            GlobalVar.Var.laporanStokHarian.toFront();
        }
    }//GEN-LAST:event_JMILaporanStokHarianActionPerformed

    private void JMIProsesAbsenKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesAbsenKaryawanActionPerformed
        if (GlobalVar.Var.absen == null) {
            GlobalVar.Var.absen = new Absen();
        } else {
            GlobalVar.Var.absen.setState(NORMAL);
            GlobalVar.Var.absen.toFront();
        }
    }//GEN-LAST:event_JMIProsesAbsenKaryawanActionPerformed

    private void JMIResetPasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIResetPasswordUserActionPerformed
        if (GlobalVar.Var.resetPasswordUser == null) {
            GlobalVar.Var.resetPasswordUser = new ResetPasswordUser();
        } else {
            GlobalVar.Var.resetPasswordUser.setState(NORMAL);
            GlobalVar.Var.resetPasswordUser.toFront();
        }
    }//GEN-LAST:event_JMIResetPasswordUserActionPerformed

    private void JMIMasterKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterKendaraanActionPerformed
        if (GlobalVar.Var.listKendaraan == null) {
            GlobalVar.Var.listKendaraan = new ListKendaraan();
        } else {
            GlobalVar.Var.listKendaraan.setState(NORMAL);
            GlobalVar.Var.listKendaraan.toFront();
        }
    }//GEN-LAST:event_JMIMasterKendaraanActionPerformed

    private void JMIMasterGudangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterGudangActionPerformed
        if (GlobalVar.Var.listGudang == null) {
            GlobalVar.Var.listGudang = new ListMasters("Gudang");
        } else {
            GlobalVar.Var.listGudang.setState(NORMAL);
            GlobalVar.Var.listGudang.toFront();
        }
    }//GEN-LAST:event_JMIMasterGudangActionPerformed

    private void JMIMasterPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterPemasokActionPerformed
        if (GlobalVar.Var.listPemasok == null) {
            GlobalVar.Var.listPemasok = new ListMasters("Pemasok");
        } else {
            GlobalVar.Var.listPemasok.setState(NORMAL);
            GlobalVar.Var.listPemasok.toFront();
        }
    }//GEN-LAST:event_JMIMasterPemasokActionPerformed

    private void JMIMasterPemintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterPemintaActionPerformed
        if (GlobalVar.Var.listPeminta == null) {
            GlobalVar.Var.listPeminta = new ListMasters("Peminta");
        } else {
            GlobalVar.Var.listPeminta.setState(NORMAL);
            GlobalVar.Var.listPeminta.toFront();
        }
    }//GEN-LAST:event_JMIMasterPemintaActionPerformed

    private void JMIMasterPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterPenerimaActionPerformed
        if (GlobalVar.Var.listPenerima == null) {
            GlobalVar.Var.listPenerima = new ListMasters("Penerima");
        } else {
            GlobalVar.Var.listPenerima.setState(NORMAL);
            GlobalVar.Var.listPenerima.toFront();
        }
    }//GEN-LAST:event_JMIMasterPenerimaActionPerformed

    private void JMIListPolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMIListPolesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMFile;
    private javax.swing.JMenuItem JMIExit;
    private javax.swing.JMenuItem JMIGantiPassword;
    private javax.swing.JMenuItem JMILaporanStokHarian;
    private javax.swing.JMenuItem JMIListPacking;
    private javax.swing.JMenuItem JMIListPenerimaan;
    private javax.swing.JMenuItem JMIListPenjualan;
    private javax.swing.JMenuItem JMIListPenyesuaian;
    private javax.swing.JMenuItem JMIListPoles;
    private javax.swing.JMenuItem JMIMasterBarang;
    private javax.swing.JMenuItem JMIMasterGudang;
    private javax.swing.JMenuItem JMIMasterKaryawan;
    private javax.swing.JMenuItem JMIMasterKendaraan;
    private javax.swing.JMenuItem JMIMasterPemasok;
    private javax.swing.JMenuItem JMIMasterPeminta;
    private javax.swing.JMenuItem JMIMasterPenerima;
    private javax.swing.JMenuItem JMIProsesAbsenKaryawan;
    private javax.swing.JMenuItem JMIProsesPacking;
    private javax.swing.JMenuItem JMIProsesPenerimaan;
    private javax.swing.JMenuItem JMIProsesPenggajian;
    private javax.swing.JMenuItem JMIProsesPenjualan;
    private javax.swing.JMenuItem JMIProsesPenyesuaian;
    private javax.swing.JMenuItem JMIProsesPoles;
    private javax.swing.JMenuItem JMIResetPasswordUser;
    private javax.swing.JMenuItem JMITambahUser;
    private javax.swing.JMenu JMLaporan;
    private javax.swing.JMenu JMList;
    private javax.swing.JMenu JMMaster;
    private javax.swing.JMenu JMProses;
    private javax.swing.JPopupMenu.Separator SFile;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
