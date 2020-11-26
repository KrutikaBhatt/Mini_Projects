
package voting.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class UpdateVoter extends javax.swing.JFrame {

    
    public UpdateVoter() {
       
        
        
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingportal","root","");
            PreparedStatement pst = con.prepareStatement("select *from addvoter1 where voterid=? and password=?");
            pst.setString(1,Login.voter_name);
            pst.setString(2,Login.voter_pass);
            ResultSet result = pst.executeQuery();
            
            while(result.next()){
                Name.setText(result.getString("name"));
                Address.setText(result.getString("address"));
                Age.setText(result.getString("age"));
                AadhaarNumber.setText(result.getString("Aadhar_no"));
                Password.setText(result.getString("password"));
                String gender = result.getString("sex");
                if(gender.equals("Male"))
                    Gender.select(1);
                else if(gender.equals("Female"))
                    Gender.select(2);
                else
                    Gender.select(3);
                    
                
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(UpdateVoter.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jDialog5 = new javax.swing.JDialog();
        jDialog6 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        Address = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        AadhaarNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Gender = new java.awt.Choice();
        PasswordCheck = new javax.swing.JCheckBox();
        NameCheck = new javax.swing.JCheckBox();
        AddressCheck = new javax.swing.JCheckBox();
        GenderCheck = new javax.swing.JCheckBox();
        AgeCheck = new javax.swing.JCheckBox();
        AadhaarNumberCheck = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(218, 223, 225));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Address.setEditable(false);
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        jPanel3.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Full Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 20));

        Name.setEditable(true);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jPanel3.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Address");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Password");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        Age.setEditable(false);
        jPanel3.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 230, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Age");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 30, -1));

        Password.setEditable(false);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jPanel3.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 230, 30));

        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 100, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Gender");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        AadhaarNumber.setEditable(false);
        jPanel3.add(AadhaarNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Aadhaar Number");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        Gender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Gender.setEnabled(false);
        jPanel3.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 30));
        Gender.add("");
        Gender.add("Male");
        Gender.add("Female");
        Gender.add("Others");

        PasswordCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordCheckActionPerformed(evt);
            }
        });
        jPanel3.add(PasswordCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        NameCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameCheckActionPerformed(evt);
            }
        });
        jPanel3.add(NameCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        AddressCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressCheckActionPerformed(evt);
            }
        });
        jPanel3.add(AddressCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        GenderCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderCheckActionPerformed(evt);
            }
        });
        jPanel3.add(GenderCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        AgeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeCheckActionPerformed(evt);
            }
        });
        jPanel3.add(AgeCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        AadhaarNumberCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AadhaarNumberCheckActionPerformed(evt);
            }
        });
        jPanel3.add(AadhaarNumberCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabel2.setText("Eg : xxxx xxxx xxxx");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 120, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 340, 500));

        jPanel4.setBackground(new java.awt.Color(240, 158, 8));

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));

        Back.setBackground(new java.awt.Color(255, 255, 255));
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Add Voter");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update Voter");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(523, 523, 523))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(715, 715, 715)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(574, 574, 574)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(272, 272, 272)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(851, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(jLabel11)
                    .addContainerGap(367, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if((Name.getText().length()==0) || (Age.getText().length()==0) || AadhaarNumber.getText().length()==0 || Address.getText().length() == 0 || Password.getText().length() ==0 || Gender.getSelectedItem()==Gender.getItem(0)) {
          JOptionPane.showMessageDialog(this, "Empty fields cannot be inserted");
        } else {
            
            try {
            
            if((checkname(Name.getText())) && (checkage(Age.getText())) && checkAadhar(AadhaarNumber.getText())){
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingportal","root","");
            String sql="update addvoter1 set name='"+Name.getText()+"',address='"+Address.getText()+"',age='"+Age.getText()+"',password='"+Password.getText()+"',Aadhar_no='"+AadhaarNumber.getText()+"',sex='"+Gender.getSelectedItem()+"'  where voterid='"+Login.voter_name+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Details updated successfully.");
            VoterDashboard vdb = new VoterDashboard();
            vdb.setVisible(true);
            dispose();
            }
            else if ((checkname(Name.getText()))==false){
            JOptionPane.showMessageDialog(null, "Name not in proper format");
            }
            else if((checkage(Age.getText())) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Age ");
            }
            else if(checkAadhar(AadhaarNumber.getText()) == false){
            JOptionPane.showMessageDialog(null, "Enter proper Aadhar number format ");
            }
            
            
            
            } catch (SQLException ex) {
            Logger.getLogger(Addvoter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        
        
    }//GEN-LAST:event_NameActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        VoterDashboard vdb = new VoterDashboard();
        vdb.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void NameCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameCheckActionPerformed
        // TODO add your handling code here:
        Name.setEditable(NameCheck.isSelected());
    }//GEN-LAST:event_NameCheckActionPerformed

    private void AddressCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressCheckActionPerformed
        // TODO add your handling code here:
        Address.setEditable(AddressCheck.isSelected());
    }//GEN-LAST:event_AddressCheckActionPerformed

    private void GenderCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderCheckActionPerformed
        // TODO add your handling code here:
        Gender.setEnabled(GenderCheck.isSelected());
    }//GEN-LAST:event_GenderCheckActionPerformed

    private void AgeCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeCheckActionPerformed
        // TODO add your handling code here:
        Age.setEditable(AgeCheck.isSelected());
    }//GEN-LAST:event_AgeCheckActionPerformed

    private void AadhaarNumberCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AadhaarNumberCheckActionPerformed
        // TODO add your handling code here:
        AadhaarNumber.setEditable(AadhaarNumberCheck.isSelected());
    }//GEN-LAST:event_AadhaarNumberCheckActionPerformed

    private void PasswordCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordCheckActionPerformed
        // TODO add your handling code here:
        Password.setEditable(PasswordCheck.isSelected());
    }//GEN-LAST:event_PasswordCheckActionPerformed

    
    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateVoter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AadhaarNumber;
    private javax.swing.JCheckBox AadhaarNumberCheck;
    private javax.swing.JTextField Address;
    private javax.swing.JCheckBox AddressCheck;
    private javax.swing.JTextField Age;
    private javax.swing.JCheckBox AgeCheck;
    private javax.swing.JButton Back;
    private java.awt.Choice Gender;
    private javax.swing.JCheckBox GenderCheck;
    private javax.swing.JTextField Name;
    private javax.swing.JCheckBox NameCheck;
    private javax.swing.JTextField Password;
    private javax.swing.JCheckBox PasswordCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    private boolean checkname(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c);
            if(!(Character.isAlphabetic(c)) && (c!=' ')) {
                
                return false;
                
            }
        }
        return true;
    }

    private boolean checkage(String text) {
        /*String regex = "^[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        int user_age=Integer.parseInt(text);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
        return user_age>=18 && user_age<=200&& (matcher.matches());*/
        try{
        int user_age=Integer.parseInt(text);
        if(user_age>=18 && user_age<=200){
            
            return true;
        }
        else{
            return false;
        }
        
           }
        catch(Exception e){
            return false;
        }
        
    }

    private boolean checkAadhar(String text) {
        if(text.length()!=14){
            return false;
        }
        else{
        String regex= "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
        return matcher.matches();
        }
    }
}
