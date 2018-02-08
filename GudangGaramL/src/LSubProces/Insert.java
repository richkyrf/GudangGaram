/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LSubProces;

import Eror.LogEror;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Martono
 */
public class Insert {

    public int returnkey = 0;

    public int getreturnkey() {
        return returnkey;
    }

    public boolean simpan(String Query, String JenisData, Component Parent) {
        boolean BerhasilSimpan = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            int autono = 0;
            Koneksi koneksi = new Koneksi();
            con = koneksi.getConnection();
            pstmt = con.prepareStatement(Query);
            int no = 0;
            no = pstmt.executeUpdate();
            if (no > 0) {
                LSubProces.History.simpanhistory(GlobalVar.VarL.username, "Berhasil Tambah Data " + JenisData);
                showMessageDialog(Parent, "Berhasil Tambah Data " + JenisData);
                BerhasilSimpan = true;
            } else {
                showMessageDialog(Parent, "Gagal Tambah Data " + JenisData);
            }
        } catch (SQLException e) {
            LogEror.SaveString(pstmt.toString());
            Eror.LogEror.SaveEror(e);
            showMessageDialog(Parent, LSubProces.Parsestringeror.GetErorString(e));
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Eror.LogEror.SaveEror(ex);
                //System.out.println("Eror Close Con/Prep");
            }
        }
        return BerhasilSimpan;
    }
}
