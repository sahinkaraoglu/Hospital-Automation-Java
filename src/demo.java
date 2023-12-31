
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class demo extends javax.swing.JFrame {

    DefaultTableModel model;

    public demo() {
        initComponents();
        populateTable();

    }

    public void populateTable() {

        model = (DefaultTableModel) tblKnowledge.getModel();
        model.setRowCount(0);
        try {
            ArrayList<City> cities = getCities();
            for (City city : cities) {
                Object[] row = {
                    city.getId(),
                    city.getFirstName(),
                    city.getLastName(),
                    city.getPhoneNumber(),
                    city.getEmail(),
                    city.getComplaint(),
                    city.getCity()};
                model.addRow(row);
            }
        } catch (SQLException ex) {

        }
    }

    public ArrayList<City> getCities() throws SQLException {

        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<City> cities = null;

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from City");
            cities = new ArrayList<City>();
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt("id"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Email"),
                        resultSet.getString("Complaint"),
                        resultSet.getString("City")
                ));
            }

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return cities;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKnowledge = new javax.swing.JTable();
        tbxFirstName = new javax.swing.JTextField();
        tbxLastName = new javax.swing.JTextField();
        tbxPhoneNumber = new javax.swing.JTextField();
        tbxComplaint = new javax.swing.JTextField();
        tbxEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tbxCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnNew1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("İsim : ");

        jLabel2.setText("Soy İsim : ");

        jLabel3.setText("Şikayet :");

        jLabel4.setText("Tel No :");

        jLabel5.setText("Email : ");

        tblKnowledge.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "İsim", "Soy İsim", "Telefon No", "Email", "Şikayet", "Şehir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKnowledge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKnowledgeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblKnowledge);
        if (tblKnowledge.getColumnModel().getColumnCount() > 0) {
            tblKnowledge.getColumnModel().getColumn(0).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(1).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(2).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(3).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(4).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(5).setResizable(false);
            tblKnowledge.getColumnModel().getColumn(6).setResizable(false);
        }

        btnAdd.setText("Kaydet");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Sil");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Yeni Kayıt");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel6.setText("Şehir :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Hasta Kayıt");

        btnNew1.setText("Yenile");
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxLastName)
                                    .addComponent(tbxFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tbxEmail)
                                .addComponent(tbxCity)
                                .addComponent(tbxComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(56, 56, 56))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tbxFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tbxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tbxComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnNew)
                            .addComponent(btnDelete)
                            .addComponent(btnNew1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            String sql = "insert into city (FirstName,LastName,PhoneNumber,Email,Complaint,City) values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, tbxFirstName.getText());
            statement.setString(2, tbxLastName.getText());
            statement.setString(3, tbxPhoneNumber.getText());
            statement.setString(4, tbxEmail.getText());
            statement.setString(5, tbxComplaint.getText());
            statement.setString(6, tbxCity.getText());
            int result = statement.executeUpdate();
            populateTable();
            FieldClean();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void FieldClean(){
        tbxFirstName.setText("");
        tbxLastName.setText("");
        tbxComplaint.setText("");
        tbxPhoneNumber.setText("");
        tbxEmail.setText("");
        tbxCity.setText("");
    }
    
    
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      FieldClean();
    }//GEN-LAST:event_btnNewActionPerformed


    private void tblKnowledgeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKnowledgeMousePressed
            
        
        tbxFirstName.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 1).toString());
        tbxLastName.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 2).toString());
        tbxPhoneNumber.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 3).toString());
        tbxEmail.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 4).toString());
        tbxComplaint.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 5).toString());
        tbxCity.setText(tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 6).toString());


    }//GEN-LAST:event_tblKnowledgeMousePressed

    public void KayitSil(String ID) {

        try {
            Connection connection = null;
            DbHelper dbHelper = new DbHelper();
            Statement statement = null;
            int resultSet;
            ArrayList<City> cities = null;

            populateTable();

            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("Delete FROM  city where id=" + ID);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
    }


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String ID = tblKnowledge.getValueAt(tblKnowledge.getSelectedRow(), 0).toString();
        KayitSil(ID);
        populateTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed
        populateTable();
        FieldClean();
    }//GEN-LAST:event_btnNew1ActionPerformed

   

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKnowledge;
    private javax.swing.JTextField tbxCity;
    private javax.swing.JTextField tbxComplaint;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxFirstName;
    private javax.swing.JTextField tbxLastName;
    private javax.swing.JTextField tbxPhoneNumber;
    // End of variables declaration//GEN-END:variables

}
