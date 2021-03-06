
package voting.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;


public class Login extends javax.swing.JFrame {

    public static String admin_name;
    public static String user_password;
    public static String voter_name;
    public static String voter_pass;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
Connection con;
PreparedStatement pst;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        HelpText = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel("<html>1. Cast your Vote<br/><br/>2. Enroll to Vote<br/><br/>3. Update my Details<br/><br/>4. Enroll as a candidate</html>", SwingConstants.CENTER);
        jPanel4 = new javax.swing.JPanel();
        VoterLoginLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        AdminPasswordLabel = new javax.swing.JLabel();
        AdminPassword = new javax.swing.JPasswordField();
        LoginAdmin = new javax.swing.JButton();
        ResetAdmin = new javax.swing.JButton();
        VoterIDLabel = new javax.swing.JLabel();
        VoterID = new javax.swing.JTextField();
        VoterPasswordLabel = new javax.swing.JLabel();
        jvoterpassword = new javax.swing.JPasswordField();
        LoginVoter = new javax.swing.JButton();
        ResetVoter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AdminLoginLabel = new javax.swing.JLabel();
        CreateAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(47, 46, 127));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/VotingPortalTheme.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 255, 255)));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

        HelpText.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        HelpText.setForeground(new java.awt.Color(255, 255, 255));
        HelpText.setText("How can we help you?");
        jPanel3.add(HelpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 0));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 180));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 520));

        jPanel4.setBackground(new java.awt.Color(218, 223, 225));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VoterLoginLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        VoterLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VoterLoginLabel.setText("Voter Login");
        jPanel4.add(VoterLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameLabel.setText("Username");
        jPanel4.add(UsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel4.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 208, 30));

        AdminPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdminPasswordLabel.setText("Password");
        jPanel4.add(AdminPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 68, -1));

        AdminPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPasswordActionPerformed(evt);
            }
        });
        jPanel4.add(AdminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 208, 30));

        LoginAdmin.setBackground(new java.awt.Color(47, 46, 127));
        LoginAdmin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LoginAdmin.setForeground(new java.awt.Color(255, 255, 255));
        LoginAdmin.setText("Login");
        LoginAdmin.setActionCommand("");
        LoginAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginAdmin.setBorderPainted(false);
        LoginAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginAdminActionPerformed(evt);
            }
        });
        jPanel4.add(LoginAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 84, 30));

        ResetAdmin.setBackground(new java.awt.Color(47, 46, 127));
        ResetAdmin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ResetAdmin.setForeground(new java.awt.Color(255, 255, 255));
        ResetAdmin.setText("Reset");
        ResetAdmin.setActionCommand("");
        ResetAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ResetAdmin.setBorderPainted(false);
        ResetAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResetAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetAdminActionPerformed(evt);
            }
        });
        jPanel4.add(ResetAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, 30));

        VoterIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VoterIDLabel.setText("VoterID");
        jPanel4.add(VoterIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 50, -1));
        jPanel4.add(VoterID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 209, 30));

        VoterPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VoterPasswordLabel.setText("Password");
        jPanel4.add(VoterPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 339, -1, -1));

        jvoterpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jvoterpasswordActionPerformed(evt);
            }
        });
        jPanel4.add(jvoterpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 209, 30));

        LoginVoter.setBackground(new java.awt.Color(47, 46, 127));
        LoginVoter.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LoginVoter.setForeground(new java.awt.Color(255, 255, 255));
        LoginVoter.setText("Login");
        LoginVoter.setActionCommand("");
        LoginVoter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginVoter.setBorderPainted(false);
        LoginVoter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginVoter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginVoterActionPerformed(evt);
            }
        });
        jPanel4.add(LoginVoter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 80, 30));

        ResetVoter.setBackground(new java.awt.Color(47, 46, 127));
        ResetVoter.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ResetVoter.setForeground(new java.awt.Color(255, 255, 255));
        ResetVoter.setText("Reset");
        ResetVoter.setActionCommand("");
        ResetVoter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ResetVoter.setBorderPainted(false);
        ResetVoter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResetVoter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetVoterActionPerformed(evt);
            }
        });
        jPanel4.add(ResetVoter, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 80, 30));

        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 5, 42, 19));

        jLabel4.setText("jLabel4");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 0, -1, 28));

        AdminLoginLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        AdminLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminLoginLabel.setText("Admin Login");
        jPanel4.add(AdminLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        CreateAccount.setBackground(new java.awt.Color(218, 223, 225));
        CreateAccount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        CreateAccount.setText("Create an Account");
        CreateAccount.setBorder(null);
        CreateAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });
        jPanel4.add(CreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 210, 40));
        CreateAccount.setBorderPainted(false);

        CreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CreateAccount.setActionCommand("");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 290, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void LoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginAdminActionPerformed
        try {
            
           
            admin_name = Username.getText();
            user_password = String.valueOf(AdminPassword.getPassword());
            con = DriverManager.getConnection("jdbc:mysql://localhost/votingportal","root","");
            pst = con.prepareStatement("select*from admin where name=? and password=?");
            pst.setString(1, Username.getText());
            pst.setString(2, String.valueOf(AdminPassword.getPassword()));
            ResultSet result = pst.executeQuery();
            if(result.next()){
                
                
                AdminDashboard v=new AdminDashboard();
                v.setVisible(true);
                
                dispose();
              
            }
            else{
                JOptionPane.showMessageDialog(null, "invalid username or password");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoginAdminActionPerformed

    private void ResetAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetAdminActionPerformed
                                Username.setText(null);
				AdminPassword.setText(null);
    }//GEN-LAST:event_ResetAdminActionPerformed

    private void jvoterpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jvoterpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jvoterpasswordActionPerformed

    private void AdminPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPasswordActionPerformed

    private void LoginVoterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginVoterActionPerformed
       
         try {
            
            voter_name =VoterID.getText();
            voter_pass = String.valueOf(jvoterpassword.getPassword());
            con = DriverManager.getConnection("jdbc:mysql://localhost/votingportal","root","");
            pst = con.prepareStatement("select voterid,password from addvoter1 where voterid=? and password=?");           
            pst.setString(1, VoterID.getText());
            pst.setString(2, String.valueOf(jvoterpassword.getPassword()));
            ResultSet result = pst.executeQuery();
            if(result.next()){
                
                
                VoterDashboard s=new VoterDashboard();
                s.setVisible(true);
                
                dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "invalid username or password");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }//GEN-LAST:event_LoginVoterActionPerformed

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed
        // TODO add your handling code here:
        Addvoter av =  new Addvoter();
        av.setVisible(true);
        dispose();
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void ResetVoterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetVoterActionPerformed
         VoterID.setText(null);
	 jvoterpassword.setText(null);
    }//GEN-LAST:event_ResetVoterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminLoginLabel;
    private javax.swing.JPasswordField AdminPassword;
    private javax.swing.JLabel AdminPasswordLabel;
    private javax.swing.JButton CreateAccount;
    private javax.swing.JLabel HelpText;
    private javax.swing.JButton LoginAdmin;
    private javax.swing.JButton LoginVoter;
    private javax.swing.JButton ResetAdmin;
    private javax.swing.JButton ResetVoter;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField VoterID;
    private javax.swing.JLabel VoterIDLabel;
    private javax.swing.JLabel VoterLoginLabel;
    private javax.swing.JLabel VoterPasswordLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jvoterpassword;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    
}
