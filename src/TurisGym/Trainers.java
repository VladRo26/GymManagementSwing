/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TurisGym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author turis
 */
public class Trainers extends javax.swing.JFrame {

    /**
     * Creates new form Trainers
     */
    public Trainers() {
        initComponents();
        Connect();
        DisplayTrainers();
    }
    
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://DESKTOP-STANKTQ:1433;databaseName=PROJECT;encrypt=true;trustServerCertificate=true;";
    String user="Vlad";
    String pass="****";
  
    Connection con;
    ResultSet rs;
    
      public void Connect(){
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
      
     private void DisplayTrainers() {
    String sql = "SELECT TrainerID, FirstName, LastName, Specialization, DateOfBirth, HireDate, PricePerMonth, PhoneNumber, Gender FROM Trainers";
    try (PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        // Assuming TrTable is already initialized with a DefaultTableModel somewhere in initComponents()
        DefaultTableModel model = (DefaultTableModel) TrTable.getModel();
        model.setRowCount(0);  // Clear existing data

        while (rs.next()) {
            Object[] row = new Object[9];  // There are 9 columns in the table
            row[0] = rs.getInt("TrainerID");
            row[1] = rs.getString("FirstName");
            row[2] = rs.getString("LastName");
            row[3] = rs.getString("Specialization");
            row[4] = rs.getDate("DateOfBirth");
            row[5] = rs.getDate("HireDate");
            row[6] = rs.getBigDecimal("PricePerMonth");
            row[7] = rs.getString("PhoneNumber");
            row[8] = rs.getString("Gender");
            model.addRow(row);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading trainers: " + e.getMessage());
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
        TrText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TrPhoneNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TrSpecialization = new javax.swing.JTextField();
        TrGenderCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TrBirthDate = new com.toedter.calendar.JDateChooser();
        TrHireDate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        Addbtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TrTable = new javax.swing.JTable();
        TrPriceText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        MemberTrainersbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setText("Logout");

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
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addContainerGap(489, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Manage Trainers");

        jLabel6.setText("TrainerName");

        TrText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrTextActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone Number");

        TrPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrPhoneNumberActionPerformed(evt);
            }
        });

        jLabel8.setText("Specialization");

        TrSpecialization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrSpecializationActionPerformed(evt);
            }
        });

        TrGenderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel9.setText("Gender");

        jLabel10.setText("BirthDate");

        jLabel11.setText("HireDate");

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

        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });

        Deletebtn.setText("Delete");
        Deletebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletebtnMouseClicked(evt);
            }
        });

        jLabel12.setText("TRAINERS LIST");

        TrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TrainerID", "FirstName", "LastName", "Specialization", "DateOfBirth", "HireDate", "PricePerMonth", "PhoneNumber", "Gender"
            }
        ));
        TrTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TrTable);

        TrPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrPriceTextActionPerformed(evt);
            }
        });

        jLabel13.setText("PricePerMonth");

        MemberTrainersbtn.setText("See members");
        MemberTrainersbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberTrainersbtnMouseClicked(evt);
            }
        });
        MemberTrainersbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberTrainersbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(TrText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(TrHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TrPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(Addbtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(EditBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(TrSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(TrGenderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TrBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Deletebtn)
                        .addGap(36, 36, 36)
                        .addComponent(MemberTrainersbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TrPriceText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(368, 368, 368))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(155, 155, 155))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel6)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TrGenderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TrHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Addbtn)
                            .addComponent(EditBtn)
                            .addComponent(Deletebtn)
                            .addComponent(MemberTrainersbtn))
                        .addGap(18, 18, 18)))
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addGap(0, 684, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TrTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrTextActionPerformed

    private void TrPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrPhoneNumberActionPerformed

    private void TrSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrSpecializationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrSpecializationActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddbtnActionPerformed

    private void TrPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrPriceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrPriceTextActionPerformed

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        // TODO add your handling code here:
          try {
        // Validation for Phone Number
        String phoneNumber = TrPhoneNumber.getText();
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Phone number must contain 10 digits.");
            return;
        }

        // Validation for Birth Date (must be at least 18 years old)
        java.util.Date birthDate = TrBirthDate.getDate();
        if (birthDate == null || !isValidAdult(birthDate)) {
            JOptionPane.showMessageDialog(this, "Trainer must be at least 18 years old.");
            return;
        }

        // Validation for Salary (must not be negative)
        BigDecimal salary;
        try {
            salary = new BigDecimal(TrPriceText.getText());
            if (salary.compareTo(BigDecimal.ZERO) < 0) {
                JOptionPane.showMessageDialog(this, "Salary cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid salary amount.");
            return;
        }

        // SQL INSERT statement
        String sql = "INSERT INTO Trainers (FirstName, LastName, Specialization, DateOfBirth, HireDate, PricePerMonth, PhoneNumber, Gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Assuming your GUI fields are separated for First and Last Names and adjusting other field names accordingly
        String fullName = TrText.getText();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        // Setting parameters for the PreparedStatement
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, TrSpecialization.getText());
        pst.setDate(4, new java.sql.Date(birthDate.getTime()));
        pst.setDate(5, new java.sql.Date(TrHireDate.getDate().getTime()));
        pst.setBigDecimal(6, salary);
        pst.setString(7, phoneNumber);
        pst.setString(8, (String) TrGenderCombo.getSelectedItem());

        // Execute the update
        pst.executeUpdate();

        // Feedback to user
        JOptionPane.showMessageDialog(this, "Insert Successfully");
        DisplayTrainers();
        
        // Optionally, clear the form fields after successful insertion
        clearFormFields();
    } catch (Exception e) {
        // Handle exceptions and provide feedback
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_AddbtnMouseClicked

    private void TrTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrTableMouseClicked
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) TrTable.getModel();
    
    // Get the selected row index
    int selectedRowIndex = TrTable.getSelectedRow();
    
    // Set the form fields with the table row values
    TrText.setText(model.getValueAt(selectedRowIndex, 1).toString() + " " + model.getValueAt(selectedRowIndex, 2).toString()); // Combining FirstName and LastName
    TrPhoneNumber.setText(model.getValueAt(selectedRowIndex, 7).toString());
    TrSpecialization.setText(model.getValueAt(selectedRowIndex, 3).toString());
    TrPriceText.setText(model.getValueAt(selectedRowIndex, 6).toString());
    
    // Set the gender combo box
    String gender = model.getValueAt(selectedRowIndex, 8).toString();
    TrGenderCombo.setSelectedItem(gender);
    
    // Set the date choosers
    TrBirthDate.setDate((java.util.Date)model.getValueAt(selectedRowIndex, 4));
    TrHireDate.setDate((java.util.Date)model.getValueAt(selectedRowIndex, 5));
    }//GEN-LAST:event_TrTableMouseClicked

    private void DeletebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletebtnMouseClicked
        // TODO add your handling code here:
          int selectedRowIndex = TrTable.getSelectedRow();

    if (selectedRowIndex >= 0) { // Check if a row is actually selected
        // Inform the user about the impact of deletion
        String message = "Deleting this trainer will set the TrainerID to NULL for both classes assigned to this trainer " +
                         "and members trained by this trainer. Do you want to proceed?";
        int confirm = JOptionPane.showConfirmDialog(this, message, "Delete Trainer", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            // Get the TrainerID from the selected row
            int trainerId = Integer.parseInt(TrTable.getValueAt(selectedRowIndex, 0).toString());

            // Update related tables to set TrainerID to NULL
            try {
                con.setAutoCommit(false); // Start transaction

                // Update Classes table
                String updateClassesSql = "UPDATE Classes SET TrainerID = NULL WHERE TrainerID = ?";
                try (PreparedStatement pst = con.prepareStatement(updateClassesSql)) {
                    pst.setInt(1, trainerId);
                    pst.executeUpdate();
                }

                // Update MemberTrainers table
                String updateMemberTrainersSql = "UPDATE MemberTrainers SET TrainerID = NULL WHERE TrainerID = ?";
                try (PreparedStatement pst = con.prepareStatement(updateMemberTrainersSql)) {
                    pst.setInt(1, trainerId);
                    pst.executeUpdate();
                }

                // Delete the trainer
                String deleteTrainerSql = "DELETE FROM Trainers WHERE TrainerID = ?";
                try (PreparedStatement pst = con.prepareStatement(deleteTrainerSql)) {
                    pst.setInt(1, trainerId);
                    pst.executeUpdate();
                }

                con.commit(); // Commit transaction

                // Refresh the display
                DisplayTrainers();

                // Clear any selection or input fields if necessary
                clearFormFields();

                JOptionPane.showMessageDialog(this, "Trainer deleted successfully.");
            } catch (SQLException e) {
                try {
                    con.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error rolling back transaction: " + ex.getMessage());
                }
                JOptionPane.showMessageDialog(this, "Error deleting trainer: " + e.getMessage());
            } finally {
                try {
                    con.setAutoCommit(true); // Restore auto-commit mode
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error restoring auto-commit mode: " + ex.getMessage());
                }
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a trainer to delete.");
    }  
    }//GEN-LAST:event_DeletebtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        // TODO add your handling code here:
          int selectedRowIndex = TrTable.getSelectedRow();
    
    if (selectedRowIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please select a trainer to edit.");
        return;
    }

    try {
        // Gather data from the form
        String fullName = TrText.getText();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts.length > 0 ? nameParts[0] : "";
        String lastName = nameParts.length > 1 ? nameParts[1] : "";
        String phoneNumber = TrPhoneNumber.getText();
        String specialization = TrSpecialization.getText();
        java.util.Date birthDate = TrBirthDate.getDate();
        java.util.Date hireDate = TrHireDate.getDate();
        String gender = (String) TrGenderCombo.getSelectedItem();
        BigDecimal salary = new BigDecimal(TrPriceText.getText());

        // Validation for Phone Number
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Phone number must contain 10 digits.");
            return;
        }

        // Validation for Birth Date (must be at least 18 years old)
        if (birthDate == null || !isValidAdult(birthDate)) {
            JOptionPane.showMessageDialog(this, "Trainer must be at least 18 years old.");
            return;
        }

        // Validation for Salary (must not be negative)
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this, "Salary cannot be negative.");
            return;
        }

        // Prepare SQL UPDATE statement
        String sql = "UPDATE Trainers SET FirstName=?, LastName=?, Specialization=?, DateOfBirth=?, HireDate=?, PricePerMonth=?, PhoneNumber=?, Gender=? WHERE TrainerID=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, specialization);
        pst.setDate(4, new java.sql.Date(birthDate.getTime()));
        pst.setDate(5, new java.sql.Date(hireDate.getTime()));
        pst.setBigDecimal(6, salary);
        pst.setString(7, phoneNumber);
        pst.setString(8, gender);
        pst.setInt(9, Integer.parseInt(TrTable.getValueAt(selectedRowIndex, 0).toString()));

        // Execute the update
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Trainer updated successfully.");

        // Refresh the displayed data
        DisplayTrainers();
        clearFormFields();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_EditBtnMouseClicked

    private void MemberTrainersbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberTrainersbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberTrainersbtnActionPerformed

    private void MemberTrainersbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberTrainersbtnMouseClicked
        // TODO add your handling code here:
            int selectedRowIndex = TrTable.getSelectedRow();
    if (selectedRowIndex != -1) {
        int trainerId = Integer.parseInt(TrTable.getValueAt(selectedRowIndex, 0).toString()); // Assuming 0 is the column index for TrainerID
        MemberTrainers memberTrainersForm = new MemberTrainers(trainerId);
        memberTrainersForm.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a trainer first.");
    }
        
    }//GEN-LAST:event_MemberTrainersbtnMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Members().setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked
    private boolean isValidAdult(java.util.Date birthDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);
        return !birthDate.after(cal.getTime());
    }

    private void clearFormFields() {
        TrText.setText("");
        TrSpecialization.setText("");
        TrPhoneNumber.setText("");
        TrBirthDate.setCalendar(null);
        TrHireDate.setCalendar(null);
        TrPriceText.setText("");
    }
        
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
            java.util.logging.Logger.getLogger(Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trainers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton MemberTrainersbtn;
    private com.toedter.calendar.JDateChooser TrBirthDate;
    private javax.swing.JComboBox<String> TrGenderCombo;
    private com.toedter.calendar.JDateChooser TrHireDate;
    private javax.swing.JTextField TrPhoneNumber;
    private javax.swing.JTextField TrPriceText;
    private javax.swing.JTextField TrSpecialization;
    private javax.swing.JTable TrTable;
    private javax.swing.JTextField TrText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
