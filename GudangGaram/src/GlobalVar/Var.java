/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalVar;

import Laporan.*;
import Proses.Penggajian;
import File.*;
import Proses.*;
import List.*;
import Master.*;

/**
 *
 * @author richk
 */

public class Var {
    
    public static String Username, Password, Level;
    public static TambahUser tambahUser;
    public static GantiPassword gantiPassword;
    
    public static MasterKaryawan tambahKaryawan,ubahKaryawan;
    public static MasterBarang tambahBarang,ubahBarang;
    
    public static SubMaster tambahJenisKaryawan, ubahJenisKaryawan, tambahJenisBarang, ubahJenisBarang, tambahJenisPenjualan, ubahJenisPenjualan;
    
    public static Absen absen;
    public static Penerimaan tambahPenerimaan, ubahPenerimaan;
    public static Packing tambahPacking, ubahPacking;
    public static Penjualan tambahPenjualan, ubahPenjualan;
    public static Penyesuaian tambahPenyesuaian, ubahPenyesuaian;
    
    public static Penggajian penggajian;
    public static PrintTPB printTPB;
    public static Poles poles;
    
    public static ListKaryawan listKaryawan;
    public static ListBarang listBarang;
    public static ListPenerimaan listPenerimaan;
    public static ListPacking listPacking;
    public static ListPenjualan listPenjualan;
    public static ListPenyesuaian listPenyesuaian;
    
    public static ListSubMaster listJenisKaryawan, listJenisBarang, listJenisPenjualan;
    
    public static LaporanStokHarian laporanStokHarian;
    
    public static Jcari jcari;
}
