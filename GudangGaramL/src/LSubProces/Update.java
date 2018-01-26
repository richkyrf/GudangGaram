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
 * @author zeppr
 */
public class Update {

    public boolean Ubah(String Query, String JenisData, Component Parent) {
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
                LSubProces.History.simpanhistory(GlobalVar.VarL.Username, "Berhasil Ubah Data " + JenisData);
                showMessageDialog(Parent, "Berhasil Ubah Data " + JenisData);
                BerhasilSimpan = true;
            } else {
                showMessageDialog(Parent, "Gagal Ubah Data " + JenisData);
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
