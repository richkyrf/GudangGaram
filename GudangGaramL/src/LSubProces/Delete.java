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
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author zeppr
 */
public class Delete {

    public boolean Hapus(Object ID, String Query, String JenisData, Component Parent) {
        Connection con;
        Koneksi koneksi = new Koneksi();
        con = koneksi.getConnection();
        boolean berhasilhapus = false;
        int reply = showConfirmDialog(Parent, "Apakah Anda Yakin Mau Menghapus Data " + JenisData + " Dengan " + ID, "konfirmasi", YES_NO_OPTION);
        if (reply == YES_OPTION) {
            PreparedStatement pstmt = null;
            try {
                pstmt = con.prepareStatement(Query);
                int no = 0;
                no = pstmt.executeUpdate();
                if (no > 0) {
                    LSubProces.History.simpanhistory(GlobalVar.VarL.Username, "Berhasil menghapus  data " + JenisData);
                    showMessageDialog(Parent, "Berhasil menghapus  data " + JenisData);
                    berhasilhapus = true;
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
                } catch (SQLException ex) { Eror.LogEror.SaveEror(ex);
                    //System.out.println("Eror Close Con/Prep");
                }
            }
        } else {
            showMessageDialog(null, "Batal Menghapus Data " + JenisData);
        }
        return berhasilhapus;
    }

}
