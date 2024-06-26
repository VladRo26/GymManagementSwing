/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TurisGym;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author turis
 */
public class Classes extends javax.swing.JFrame {

    /**
     * Creates new form Classes
     */
     Connection con;
     PreparedStatement pst;
    
    public Classes() {
        initComponents();
        Connect();
        LoadTrainers();
        LoadClassTypes();
        DisplayClasses();
    }
    
    public void Connect() {
        try {
            // Update with your database connection details
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-STANKTQ:1433;databaseName=PROJECT;encrypt=true;trustServerCertificate=true;", "Vlad", "****");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
   

    
  private void LoadTrainers() {
        try {
            String sql = "SELECT TrainerID, FirstName, LastName FROM Trainers";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            CcomboBox.removeAllItems(); // Clear existing items
            while (rs.next()) {
                int trainerID = rs.getInt("TrainerID");
                String fullName = rs.getString("FirstName") + " " + rs.getString("LastName");
                 CcomboBox.addItem(fullName + " - " + trainerID);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading trainers: " + ex.getMessage());
        }
    }
    
       private void DisplayClasses() {
               try {
        String sql = "SELECT c.ClassID, ct.TypeName AS ClassType, ct.Description, t.FirstName + ' ' + t.LastName AS TrainerName, c.StartTime, c.Duration, c.Capacity " +
                 "FROM Classes c " +
                 "JOIN ClassTypes ct ON c.ClassTypeID = ct.ClassTypeID " +
                 "JOIN Trainers t ON c.TrainerID = t.TrainerID";
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) EquipmentTable.getModel();
        model.setRowCount(0); // Clear existing data

        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getInt("ClassID"));
            row.add(rs.getString("ClassType"));
            row.add(rs.getString("TrainerName"));
            row.add(rs.getTimestamp("StartTime"));
            row.add(rs.getInt("Duration"));
            row.add(rs.getInt("Capacity"));
            row.add(rs.getString("Description")); 
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading classes: " + ex.getMessage());
    }
    }
       
     private void LoadClassTypes() {
    try {
        String sql = "SELECT ClassTypeID, TypeName FROM ClassTypes";
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        CTypeComboBox.removeAllItems(); // Clear existing items
        while (rs.next()) {
            int classTypeID = rs.getInt("ClassTypeID");
            String typeName = rs.getString("TypeName");
            CTypeComboBox.addItem(typeName + " - " + classTypeID);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading class types: " + ex.getMessage());
    }
    }
    
    private void clearFields() {
    // Clear all text fields
    CName.setText("");
    CDuration.setText("");
    CCapacity.setText("");
    CDescription.setText("");

    // Reset the date chooser to current date or null
    CStarTime.setDate(null);

    // Reset combo boxes to the first item if exists
    if (CcomboBox.getItemCount() > 0) {
        CcomboBox.setSelectedIndex(0);
    }
    if (CTypeComboBox.getItemCount() > 0) {
        CTypeComboBox.setSelectedIndex(0);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CDuration = new javax.swing.JTextField();
        CStarTime = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        Addbtn = new javax.swing.JButton();
        Editbtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentTable = new javax.swing.JTable();
        CCapacity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CcomboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CDescription = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        CTypeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setText("Logout");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel14.setText("Go back");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Manage Classes");

        jLabel6.setText("Name");

        CName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNameActionPerformed(evt);
            }
        });

        jLabel7.setText("Start Time");

        jLabel8.setText("Duration");

        CDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDurationActionPerformed(evt);
            }
        });

        jLabel11.setText("Type");

        Addbtn.setText("Add");
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        Editbtn.setText("Edit");
        Editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditbtnMouseClicked(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });

        jLabel12.setText("Classes");

        EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Trainer", "StartTime", "Duration", "Capacity", "Description"
            }
        ));
        EquipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(EquipmentTable);

        CCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCapacityActionPerformed(evt);
            }
        });

        jLabel13.setText("Capacity");

        CcomboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Trainer");

        CDescription.setColumns(20);
        CDescription.setRows(5);
        jScrollPane2.setViewportView(CDescription);

        jLabel9.setText("Description");

        CTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Addbtn)
                                        .addGap(85, 85, 85)
                                        .addComponent(Editbtn))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(24, 24, 24)))
                                .addGap(106, 106, 106)
                                .addComponent(DeleteBtn))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addGap(104, 104, 104)
                                        .addComponent(jLabel7)
                                        .addGap(127, 127, 127))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CStarTime, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 530, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(155, 155, 155))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CStarTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Addbtn)
                    .addComponent(Editbtn)
                    .addComponent(DeleteBtn))
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addGap(0, 666, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void CNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNameActionPerformed

    private void CDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDurationActionPerformed

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        // TODO add your handling code here:
          try {
        String name = CName.getText();
        String description = CDescription.getText();
        String selectedClassType = (String) CTypeComboBox.getSelectedItem();
        int classTypeID = Integer.parseInt(selectedClassType.split(" - ")[1]);
        int duration = Integer.parseInt(CDuration.getText());
        java.util.Date startTime = CStarTime.getDate();
        int capacity = Integer.parseInt(CCapacity.getText());
        String selectedTrainer = (String) CcomboBox.getSelectedItem();
        int trainerID = Integer.parseInt(selectedTrainer.split(" - ")[1]);

        if (name.isEmpty() || duration <= 0 || startTime == null || capacity <= 0 || selectedTrainer == null) {
            JOptionPane.showMessageDialog(this, "Please enter all required fields.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStartTime = sdf.format(startTime);

        // Check for existing class at the same time
        String checkSql = "SELECT COUNT(*) FROM Classes WHERE TrainerID = ? AND StartTime = ?";
        pst = con.prepareStatement(checkSql);
        pst.setInt(1, trainerID);
        pst.setString(2, formattedStartTime);
        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Trainer already has a class at this time.");
            return;
        }

        // Check if description needs updating
        String typeCheckSql = "SELECT Description FROM ClassTypes WHERE ClassTypeID = ?";
        pst = con.prepareStatement(typeCheckSql);
        pst.setInt(1, classTypeID);
        ResultSet typeRs = pst.executeQuery();
        if (typeRs.next() && !typeRs.getString("Description").equals(description)) {
            String updateTypeSql = "UPDATE ClassTypes SET Description = ? WHERE ClassTypeID = ?";
            pst = con.prepareStatement(updateTypeSql);
            pst.setString(1, description);
            pst.setInt(2, classTypeID);
            pst.executeUpdate();
        }

        // Insert new class
        String sql = "INSERT INTO Classes (ClassTypeID, TrainerID, StartTime, Duration, Capacity) VALUES (?, ?, ?, ?, ?)";
        pst = con.prepareStatement(sql);
        pst.setInt(1, classTypeID);
        pst.setInt(2, trainerID);
        pst.setString(3, formattedStartTime);
        pst.setInt(4, duration);
        pst.setInt(5, capacity);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Class Added Successfully");
        DisplayClasses();
        clearFields();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error Adding Class: " + ex.getMessage());
    }

    }//GEN-LAST:event_AddbtnMouseClicked

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AddbtnActionPerformed

    private void EditbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditbtnMouseClicked
        // TODO add your handling code here:
        try {
        int selectedRow = EquipmentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a class to edit.");
            return;
        }

        int classID = Integer.parseInt(EquipmentTable.getValueAt(selectedRow, 0).toString());
        String name = CName.getText();
        String description = CDescription.getText(); // Getting description from JTextArea
        String selectedClassType = (String) CTypeComboBox.getSelectedItem();
        int classTypeID = Integer.parseInt(selectedClassType.split(" - ")[1]);
        int duration = Integer.parseInt(CDuration.getText());
        java.util.Date startTime = CStarTime.getDate();
        int capacity = Integer.parseInt(CCapacity.getText());
        String selectedTrainer = (String) CcomboBox.getSelectedItem();
        int trainerID = Integer.parseInt(selectedTrainer.split(" - ")[1]);

        if (name.isEmpty() || duration <= 0 || startTime == null || capacity <= 0 || selectedTrainer == null) {
            JOptionPane.showMessageDialog(this, "Please enter all required fields including the description.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStartTime = sdf.format(startTime);

        String checkSql = "SELECT COUNT(*) FROM Classes WHERE TrainerID = ? AND StartTime = ? AND ClassID != ?";
        pst = con.prepareStatement(checkSql);
        pst.setInt(1, trainerID);
        pst.setString(2, formattedStartTime);
        pst.setInt(3, classID);
        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Trainer already has a class at this time.");
            return;
        }

        // Update description in ClassTypes if changed
        String typeCheckSql = "SELECT Description FROM ClassTypes WHERE ClassTypeID = ?";
        pst = con.prepareStatement(typeCheckSql);
        pst.setInt(1, classTypeID);
        ResultSet typeRs = pst.executeQuery();
        if (typeRs.next() && !typeRs.getString("Description").equals(description)) {
            String updateTypeSql = "UPDATE ClassTypes SET Description = ? WHERE ClassTypeID = ?";
            pst = con.prepareStatement(updateTypeSql);
            pst.setString(1, description);
            pst.setInt(2, classTypeID);
            pst.executeUpdate();
        }

        String sql = "UPDATE Classes SET ClassTypeID=?, TrainerID=?, StartTime=?, Duration=?, Capacity=? WHERE ClassID=?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, classTypeID);
        pst.setInt(2, trainerID);
        pst.setString(3, formattedStartTime);
        pst.setInt(4, duration);
        pst.setInt(5, capacity);
        pst.setInt(6, classID);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Class Updated Successfully");
        clearFields();
        DisplayClasses();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error Updating Class: " + ex.getMessage());
    }
    }//GEN-LAST:event_EditbtnMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        // TODO add your handling code here:
            try {
            int selectedRow = EquipmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a class to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this class?", "Delete Class", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int classID = Integer.parseInt(EquipmentTable.getValueAt(selectedRow, 0).toString());
                String sql = "DELETE FROM Classes WHERE ClassID=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, classID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Class Deleted Successfully");
                DisplayClasses();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Deleting Class: " + ex.getMessage());
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void EquipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentTableMouseClicked
        // TODO add your handling code here:
    int selectedRow = EquipmentTable.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) EquipmentTable.getModel();
    CName.setText(model.getValueAt(selectedRow, 1).toString());
    CTypeComboBox.setSelectedItem(model.getValueAt(selectedRow, 1).toString());
    CStarTime.setDate((java.util.Date) model.getValueAt(selectedRow, 3));
    CDuration.setText(model.getValueAt(selectedRow, 4).toString());
    CCapacity.setText(model.getValueAt(selectedRow, 5).toString());

    // Update JTextArea with the description from the selected row
    CDescription.setText(model.getValueAt(selectedRow, 6).toString()); // 6 is the index where description is stored

    String trainerName = model.getValueAt(selectedRow, 2).toString();
    for (int i = 0; i < CcomboBox.getItemCount(); i++) {
        String item = (String) CcomboBox.getItemAt(i);
        if (item.split(" - ")[0].equals(trainerName)) {
            CcomboBox.setSelectedIndex(i);
            break;
        }
    }
    }//GEN-LAST:event_EquipmentTableMouseClicked

    private void CCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCapacityActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
    // TODO add your handling code here:
    if (!evt.isShiftDown() && !evt.isControlDown()) {
        int row = EquipmentTable.rowAtPoint(evt.getPoint());
        if (row == -1) {
            EquipmentTable.clearSelection();
            clearFields();  // Optionally clear the input fields too
        }
    }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Members().setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Classes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTextField CCapacity;
    private javax.swing.JTextArea CDescription;
    private javax.swing.JTextField CDuration;
    private javax.swing.JTextField CName;
    private com.toedter.calendar.JDateChooser CStarTime;
    private javax.swing.JComboBox<String> CTypeComboBox;
    private javax.swing.JComboBox<String> CcomboBox;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton Editbtn;
    private javax.swing.JTable EquipmentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
