/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LSubProces;

import Eror.LogEror;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class DrunChekDuplicate {

    String SQL;
    Connection con;
    String Erorm;
    boolean iskosong = false;
    
    public boolean IsNotDuplicate(String Query,String ErorM) {
        SQL=Query;
        Erorm=ErorM;
        Koneksi koneksi = new Koneksi();
        con = koneksi.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs;
        try {
            pstmt = con.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if (!rs.isBeforeFirst()) {iskosong=true;
            }
        } catch (SQLException sqle) {
            LogEror.SaveString(pstmt.toString());
            LogEror.SaveEror(sqle);
            if (Erorm != null) {
                showMessageDialog(null, Erorm);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            LogEror.SaveEror(ex);
            }
        }
        return iskosong;
    }

}
