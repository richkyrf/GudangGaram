package LSubProces;

import Eror.LogEror;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {

    private Connection Con = null;
    String url = "jdbc:mysql://m4rtono.com/";
    //String url = "jdbc:mysql://192.168.0.211:1358/";
    String db = "martono_test";
    String user = "martono_coba";
    String pass = "12345678";

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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url + db, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            LogEror.SaveEror(ex);
            JOptionPane.showMessageDialog(null, "Eror Tidak Dapat Terhubung Dengan Server !!!");
           
        }
        return Con;
    }
}
