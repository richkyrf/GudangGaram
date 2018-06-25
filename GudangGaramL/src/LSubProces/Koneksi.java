package LSubProces;

import Eror.LogEror;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {

    private Connection Con = null;
    String url = "jdbc:mysql://192.168.7.32:1358/";
    String url2 = "jdbc:mysql://118.97.150.178:33333/";
    String user = "databasedo";
    String pass = "Win32&serVer";
    //String url = "jdbc:mysql://localhost/";
    //String url2 = "jdbc:mysql://localhost/";
    //String user = "root";
    //String pass = "";
    String db = "dbgaram";

    public String GetUrl() {
        return url;
    }

    public String GetDb() {
        return db;
    }

    public String GetUser() {
        return user;
    }

    public String GetPass() {
        return pass;
    }

    public Connection getConnection() {
        if (GlobalVar.VarL.koneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Con = DriverManager.getConnection(url + db, user, pass);
                GlobalVar.VarL.koneksi = Con;
                return Con;
            } catch (ClassNotFoundException | SQLException ex) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Con = DriverManager.getConnection(url2 + db, user, pass);
                    GlobalVar.VarL.koneksi = Con;
                    return Con;
                } catch (ClassNotFoundException | SQLException ex2) {
                    LogEror.SaveEror(ex2);
                    JOptionPane.showMessageDialog(null, "Koneksi Ke Server Database Gagal !!!");
                    GlobalVar.VarL.koneksi = null;
                    return null;
                }
            }
        } else {
            return GlobalVar.VarL.koneksi;
        }
    }
}
