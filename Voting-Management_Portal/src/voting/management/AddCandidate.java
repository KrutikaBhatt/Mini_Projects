/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.management;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AddCandidate extends javax.swing.JFrame {

   
    public AddCandidate() {
        initComponents();
        partysign();
        this.setLocationRelativeTo(null);
    }
    Connection con;
    PreparedStatement pst;
    public void partysign()
        {


        jpsign.addItem("");
        jpsign.addItem("Lotus");
        jpsign.addItem("Hand");
        jpsign.addItem("Elephant");
        jpsign.addItem("CPI");
        jpsign.addItem("NCP");


        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        a = new javax.swing.JPanel();
        NameOfParty = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        AadhaarNumber = new javax.swing.JLabel();
        AadhaarNumberText = new javax.swing.JTextField();
        Age = new javax.swing.JLabel();
        AgeText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ConstituencyText = new javax.swing.JTextField();
        Gender = new javax.swing.JLabel();
        GenderText = new java.awt.Choice();
        Add = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Constituency = new javax.swing.JLabel();
        NameOfPartyChoice = new javax.swing.JComboBox<>();
        jpsign = new java.awt.Choice();
        Constituency1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        a.setBackground(new java.awt.Color(47, 46, 128));

        NameOfParty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NameOfParty.setForeground(new java.awt.Color(255, 255, 255));
        NameOfParty.setText("Name Of Party");

        Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Candidate Name");

        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });

        AadhaarNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AadhaarNumber.setForeground(new java.awt.Color(255, 255, 255));
        AadhaarNumber.setText("Aadhaar Number");

        Age.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Age.setForeground(new java.awt.Color(255, 255, 255));
        Age.setText("Age");

        AgeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeTextActionPerformed(evt);
            }
        });

        Gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Gender.setForeground(new java.awt.Color(255, 255, 255));
        Gender.setText("Gender");

        Add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Constituency.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Constituency.setForeground(new java.awt.Color(255, 255, 255));
        Constituency.setText("Constituency");

        NameOfPartyChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ","Bharatiya Janata Party (BJP)", "Indian National Congress (INC)", "Communist Party Of India (CPI)", "Bahujan Samaj Party(BSP)", "Nationalist Congress Party (NCP)"}));
        NameOfPartyChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameOfPartyChoiceActionPerformed(evt);
            }
        });

        jpsign.setEnabled(false);

        Constituency1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Constituency1.setForeground(new java.awt.Color(255, 255, 255));
        Constituency1.setText("Sign");

        javax.swing.GroupLayout aLayout = new javax.swing.GroupLayout(a);
        a.setLayout(aLayout);
        aLayout.setHorizontalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aLayout.createSequentialGroup()
                        .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpsign, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ConstituencyText)
                                .addComponent(AgeText)
                                .addComponent(AadhaarNumberText)
                                .addComponent(NameText)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                                    .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AadhaarNumber)
                                        .addComponent(Name)
                                        .addComponent(NameOfParty)
                                        .addComponent(Gender)
                                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(128, 128, 128))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(GenderText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Constituency, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NameOfPartyChoice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(aLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Constituency1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
        );
        aLayout.setVerticalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameOfParty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameOfPartyChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AadhaarNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AadhaarNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Age)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgeText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Gender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Constituency, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ConstituencyText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Constituency1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        GenderText.add("");
        GenderText.add("Male");
        GenderText.add("Female");
        GenderText.add("Others");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 280, 510));

        jPanel1.setBackground(new java.awt.Color(218, 223, 225));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Candidate ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if(NameText.getText().length()==0 || GenderText.getSelectedItem()== GenderText.getItem(0) || ConstituencyText.getText().length()==0 || AgeText.getText().length()==0 ||
              NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(0) || jpsign.getSelectedItem()== jpsign.getItem(0)  ){
            JOptionPane.showMessageDialog(this, "Empty fields cannot be inserted");
        }
        else {
        try {
            if((checkname(NameText.getText())) && (checkage(AgeText.getText())) && checkAadhar(AadhaarNumberText.getText())){
            con = DriverManager.getConnection("jdbc:mysql://localhost/votingportal","root","");
            String sql="insert into partylist1(name,sex,age,Constituency,Party_name,Sign_name,Aadhar_no)values(?,?,?,?,?,?,?)";
            pst =con.prepareStatement(sql);
            pst.setString(1, NameText.getText());
            pst.setString(2, GenderText.getItem(GenderText.getSelectedIndex()));
            pst.setString(4, ConstituencyText.getText());
            
            String s=AgeText.getText();
            
            int i=Integer.parseInt(s);
            if(i>=18)
            {
                pst.setString(3, AgeText.getText());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "age must greater than 18");}
            
            
            pst.setString(5, NameOfPartyChoice.getSelectedItem().toString());
            pst.setString(6, jpsign.getItem(jpsign.getSelectedIndex()));
            pst.setString(7,AadhaarNumberText.getText());
            pst.execute();
           
            JOptionPane.showMessageDialog(null, "Candidate Added Successfully !!");
            AdminDashboard adb = new AdminDashboard();
            adb.setVisible(true);
            dispose();
            }
            else if ((checkname(NameText.getText()))==false){
            JOptionPane.showMessageDialog(null, "Name not in proper format");
            }
            else if((checkage(AgeText.getText())) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Age ");
            }
            else if(checkAadhar(AadhaarNumberText.getText()) == false){
            JOptionPane.showMessageDialog(null, "Enter proper Aadhar number format ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddCandidate.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_AddActionPerformed

    private void AgeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AdminDashboard h = new AdminDashboard();
       h.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
       NameOfPartyChoice.setSelectedItem(" ");
       NameText.setText(null);
       AgeText.setText(null);
       AadhaarNumberText.setText(null);
       GenderText.select(0);
       ConstituencyText.setText(null);
    }//GEN-LAST:event_ClearActionPerformed

    private void NameOfPartyChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameOfPartyChoiceActionPerformed
        if(NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(1))
            {
                jpsign.select(1);
            }
            else if(NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(2)){
                jpsign.select(2);
            }
            else if(NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(3)){
                jpsign.select(3);
            }
            else if(NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(4)){
                jpsign.select(4);
            }
            else if(NameOfPartyChoice.getSelectedItem()== NameOfPartyChoice.getItemAt(5)){
                jpsign.select(5);
            }
    }//GEN-LAST:event_NameOfPartyChoiceActionPerformed

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
            java.util.logging.Logger.getLogger(AddCandidate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCandidate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCandidate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCandidate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCandidate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AadhaarNumber;
    private javax.swing.JTextField AadhaarNumberText;
    private javax.swing.JButton Add;
    private javax.swing.JLabel Age;
    private javax.swing.JTextField AgeText;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel Constituency;
    private javax.swing.JLabel Constituency1;
    private javax.swing.JTextField ConstituencyText;
    private javax.swing.JLabel Gender;
    private java.awt.Choice GenderText;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NameOfParty;
    private javax.swing.JComboBox<String> NameOfPartyChoice;
    private javax.swing.JTextField NameText;
    private javax.swing.JPanel a;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private java.awt.Choice jpsign;
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
