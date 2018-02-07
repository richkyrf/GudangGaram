package KomponenGUI;

import LSubProces.Koneksi;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JcomCari extends javax.swing.JPanel {

    Component parent = null;
    public String Query = "", Order = "";
    public ArrayList<String> DbColomName = new ArrayList<>();
    Object SelectedValue = null;
    int selectedIndex = 1;

    public Object GetIDTable() {
        return jtablef.getValueAt(jtablef.getSelectedRow(), 0);
    }

    public int getSelectedRows() {
        int row = 0;
        for (int i = 0; i < jtablef.getRowCount(); i++) {
            if (jtablef.getValueAt(i, jtablef.getColumnCount() - 1).toString().equals("true")) {
                row++;
            }
        }
        return row;
    }

    public Object[] getSelectedIDs() {
        Object[] a = new Object[getSelectedRows()];
        int row = 0;
        for (int i = 0; i < jtablef.getRowCount(); i++) {
            if (jtablef.getValueAt(i, jtablef.getColumnCount() - 1).toString().equals("true")) {
                a[row] = jtablef.getValueAt(i, 0);
                row++;
            }
        }
        return a;
    }

    public Object GetIDTable1() {
        return jtablef.getValueAt(jtablef.getSelectedRow(), 1);
    }

    public Object GetIDTable3() {
        return jtablef.getValueAt(jtablef.getSelectedRow(), 3);
    }

    public int getSelectedRow() {
        return jtablef.getSelectedRow();
    }

    public int getselectedcolumn() {
        return jtablef.getSelectedColumn();
    }

    public Object getSelectedValue() {
        return jtablef.getValueAt(jtablef.getSelectedRow(), jtablef.getSelectedColumn());
    }

    public String getselected11() {
        return jtablef.getValueAt(jtablef.getSelectedRow(), 1).toString();
    }

    public void refresh() {
        jtextF1.setText("");
        jcomboboxF1.setSelectedIndex(1);
        jcomboboxF2.setSelectedIndex(3);
    }

    public void Clear() {
        jtextF1.setText("");
        jcomboboxF1.setSelectedIndex(0);
        jcomboboxF2.setSelectedIndex(0);
    }

    public JcomCari() {
        initComponents();
        jtextF1.setText("");
    }

    public void setQuery(String query) {
        Query = query;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    @SuppressWarnings("unchecked")
    public void tampilkan() {
        if (JcomCari.jcomboboxF1.getSelectedItem().toString().equals("-")) {
            getjcombobox();
        }
        this.jtablef.setQuery(this.Query + " " + this.Order);
        this.jtablef.tampilkan();
        jtextF1.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void getjcombobox() {
        DefaultComboBoxModel modelbaru = new DefaultComboBoxModel();
        jcomboboxF1.setModel(modelbaru);
        ArrayList<String> groupNames = new ArrayList<>();
        DbColomName = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            int autono = 0;
            Koneksi koneksi = new Koneksi();
            con = koneksi.getConnection();
            //System.out.println("KomponenGUI.JcomCari.getjcombobox()"+Query);
            pstmt = con.prepareStatement(Query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {
                int columnsNumber = rs.getMetaData().getColumnCount();
                for (int i = 1; i < columnsNumber + 1; i++) {
                    {
                        groupNames.add(rs.getMetaData().getColumnLabel(i));
                        DbColomName.add(rs.getMetaData().getColumnName(i));
                    }
                }
            }
            if (!rs.isBeforeFirst()) {
                groupNames.add("-");
                DbColomName.add("");
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
            jcomboboxF1.setModel(model);
        } catch (SQLException e) {
            showMessageDialog(parent, LSubProces.Parsestringeror.GetErorString(e));
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                //System.out.println("Eror Close Con/Prep");
            }
        }
        jcomboboxF1.setSelectedIndex(selectedIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcomboboxF1 = new KomponenGUI.JcomboboxF();
        jtextF1 = new KomponenGUI.JtextF();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablef = new KomponenGUI.JtableF();
        jlableF2 = new KomponenGUI.JlableF();
        jcomboboxF2 = new KomponenGUI.JcomboboxF();

        jcomboboxF1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jcomboboxF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxF1ActionPerformed(evt);
            }
        });
        jcomboboxF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcomboboxF1KeyReleased(evt);
            }
        });

        jtextF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextF1KeyReleased(evt);
            }
        });

        new JScrollPane(jtablef, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jtablef.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtablef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtablef);

        jlableF2.setText("Cari Berdasarkan");

        jcomboboxF2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", "=*", "*=", "*=*" }));
        jcomboboxF2.setSelectedIndex(3);
        jcomboboxF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxF2ActionPerformed(evt);
            }
        });
        jcomboboxF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcomboboxF2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcomboboxF1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcomboboxF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextF1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboboxF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboboxF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public void Cari() {
        try {
            this.jtablef.setQuery(this.Query + " HAVING " + this.DbColomName.get(JcomCari.jcomboboxF1.getSelectedIndex()) + getjcomtypecari() + this.Order);
            this.jtablef.tampilkan();
        } catch (Exception localException) {
        }
    }

    String getjcomtypecari() {
        switch (jcomboboxF2.getSelectedIndex()) {
            case 0:
                return " = '" + jtextF1.getText() + "' ";
            case 1:
                return " Like '" + jtextF1.getText() + "%' ";
            case 2:
                return " Like '%" + jtextF1.getText() + "' ";
            case 3:
                if (jtextF1.getText().equals("")) {
                    return " Like '%" + jtextF1.getText() + "%' ";
                } else {
                    return " REGEXP '" + jtextF1.getText().replace(" ", ".+") + "' ";
                }
            default:
                return "EROR";
        }
    }

    private void jtextF1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextF1KeyReleased
        Cari();
    }//GEN-LAST:event_jtextF1KeyReleased

    private void jcomboboxF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxF1ActionPerformed
        Cari();
    }//GEN-LAST:event_jcomboboxF1ActionPerformed

    private void jcomboboxF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxF2ActionPerformed
        Cari();        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboboxF2ActionPerformed

    private void jcomboboxF2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcomboboxF2KeyReleased
        Cari();        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboboxF2KeyReleased

    private void jcomboboxF1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcomboboxF1KeyReleased
        Cari();        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboboxF1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static KomponenGUI.JcomboboxF jcomboboxF1;
    public static KomponenGUI.JcomboboxF jcomboboxF2;
    private KomponenGUI.JlableF jlableF2;
    public KomponenGUI.JtableF jtablef;
    public static KomponenGUI.JtextF jtextF1;
    // End of variables declaration//GEN-END:variables
}
