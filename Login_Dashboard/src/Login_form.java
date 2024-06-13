/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CH
 */
public class Login_form extends javax.swing.JFrame {

    /**
     * Creates new form Login_form
     */
    public Login_form() {
        initComponents();
        
        //center the form
        this.setLocationRelativeTo(null);
        
        //set icons
        jLabel_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/X4.png")));
        jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/User.png")));
        jLabel_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/Lock.png")));
        jLabel_showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/Eye.png")));
        jLabel_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/Up.png")));
        //set borders
        Border panelBorder = BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black);
        jPanel_container.setBorder(panelBorder);       
        
        Border titleBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
        jLabel_title.setBorder(titleBorder); 
        
    }

    //validate signup
    public boolean validation()
    {
        String username,passkey;
        username=jTextField_username.getText();
        passkey=jPasswordField_password.getText();
        try {
               if(username.equals(""))
               {
                   //JOptionPane.showMessageDialog(this,"please enter username");
                   //jLabel_message_text.setText("Enter Your Username First");                 
                   //return false;
                   throw new UserCheck();
               }
               else if(passkey.equals(""))
               {
                   //JOptionPane.showMessageDialog(this,"please enter password");
                   //jLabel_message_text.setText("Enter Your Passkey First");
                   //return false;
                   throw new UserCheck();
               }
        }
        catch(UserCheck u)
        {
            if(username.equals(""))
            {
                jLabel_message_text.setText("Enter Your Username First");
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
              else if(passkey.equals(""))
            {
                jLabel_message_text.setText("You Need To Enter Your Password"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
        }
       return true;
    }
    
    public void verify()
    {
        /*String username=txtusername.getText();
        String passwd=txtpasswd.getText();*/
        
        try
        {
          Class.forName("org.apache.derby.client.ClientAutoloadedDriver");
          java.sql.Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/signupdemo;create=true");
          //java.sql.Statement st=con.createStatement(); 
          String sql = "Select *from signup where username=? and passkey=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jTextField_username.getText());
            pst.setString(2,jPasswordField_password.getText());
            ResultSet rs = pst.executeQuery();
             if(rs.next())
            {
                //JOptionPane.showMessageDialog(null,"Username and Password Matched");
                this.dispose();
                //jLabel_dtext.setText("Username and Password Matched");         
                Dashboard_Form dashboard = new Dashboard_Form();
                dashboard.setVisible(true);
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"Username and Password Do not Matched");
                //jLabel_dtext.setText("Username and Password Not Matched");
                jLabel_message_text.setText("Username and Password Not Matched");
                jTextField_username.setText("");
                jPasswordField_password.setText("");
            }
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
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

        jPanel_container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_user = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jLabel_pass = new javax.swing.JLabel();
        jPasswordField_password = new javax.swing.JPasswordField();
        jButton_login = new javax.swing.JButton();
        jCheckBox_showPass = new javax.swing.JCheckBox();
        jLabel_showPass = new javax.swing.JLabel();
        jPanel_message = new javax.swing.JPanel();
        jLabel_up = new javax.swing.JLabel();
        jLabel_message_text = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_container.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel_title.setBackground(new java.awt.Color(0, 0, 204));
        jLabel_title.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 51));
        jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_title.setText("PPVC LOGIN");
        jLabel_title.setOpaque(true);

        jLabel_user.setBackground(new java.awt.Color(204, 255, 255));
        jLabel_user.setOpaque(true);

        jTextField_username.setBackground(new java.awt.Color(0, 0, 204));
        jTextField_username.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jTextField_username.setForeground(new java.awt.Color(255, 255, 0));
        jTextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usernameActionPerformed(evt);
            }
        });

        jLabel_pass.setBackground(new java.awt.Color(204, 255, 255));
        jLabel_pass.setOpaque(true);

        jPasswordField_password.setBackground(new java.awt.Color(0, 0, 204));
        jPasswordField_password.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jPasswordField_password.setForeground(new java.awt.Color(255, 255, 0));
        jPasswordField_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_passwordActionPerformed(evt);
            }
        });

        jButton_login.setBackground(new java.awt.Color(255, 0, 0));
        jButton_login.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jButton_login.setForeground(new java.awt.Color(255, 255, 0));
        jButton_login.setText("Login");
        jButton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        jCheckBox_showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_showPassActionPerformed(evt);
            }
        });

        jLabel_showPass.setBackground(new java.awt.Color(204, 255, 255));
        jLabel_showPass.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel_showPass.setForeground(new java.awt.Color(255, 255, 0));
        jLabel_showPass.setOpaque(true);

        jPanel_message.setBackground(new java.awt.Color(240, 52, 52));

        jLabel_up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_upMouseClicked(evt);
            }
        });

        jLabel_message_text.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_message_text.setText("message");

        javax.swing.GroupLayout jPanel_messageLayout = new javax.swing.GroupLayout(jPanel_message);
        jPanel_message.setLayout(jPanel_messageLayout);
        jPanel_messageLayout.setHorizontalGroup(
            jPanel_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_message_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_up, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_messageLayout.setVerticalGroup(
            jPanel_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_messageLayout.createSequentialGroup()
                .addComponent(jLabel_up, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_messageLayout.createSequentialGroup()
                .addComponent(jLabel_message_text, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_login, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jLabel_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox_showPass, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_username)
                            .addComponent(jPasswordField_password, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jLabel_showPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField_password, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox_showPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_showPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_message, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
        );

        jLabel_close.setBackground(new java.awt.Color(0, 153, 153));
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.setOpaque(true);
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Sign Up");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Forgot Passkey");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_containerLayout = new javax.swing.GroupLayout(jPanel_container);
        jPanel_container.setLayout(jPanel_containerLayout);
        jPanel_containerLayout.setHorizontalGroup(
            jPanel_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel_containerLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_containerLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel_containerLayout.setVerticalGroup(
            jPanel_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_containerLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //timer to hide the message panel
      Timer timerUp = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(jPanel_message.getHeight() != 0)
            {
               jPanel_message.setBounds(jPanel_message.getX(), jPanel_message.getY(), jPanel_message.getWidth(), jPanel_message.getHeight() - 5);
            }
            else
            {
                timerUp.stop();
            }
        }
    });
    
    //timer to show message panel
      Timer timerDown = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(jPanel_message.getHeight() != 60)
            {
               jPanel_message.setBounds(jPanel_message.getX(), jPanel_message.getY(), jPanel_message.getWidth(), jPanel_message.getHeight() + 5);
            }
            else
            {
                timerDown.stop();
            }
        }
    });
       
    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
        // TODO add your handling code here:show the panel message
         // get values
        /* String username  = jTextField_username.getText().trim();
        String password = String.valueOf(jPasswordField_password.getPassword()).trim();
        
        try
        {
            if(username.equals(""))
            {
                //jLabel_message_text.setText("Enter Your Username First");
                throw new UserCheck();
            }

        // if the password is empty
            else if(password.equals(""))
            {
                //jLabel_message_text.setText("You Need To Enter Your Password"); 
                throw new UserCheck();
            }
        
         // if everything is ok
            else if(username.equals("ch") && password.equals("ch@202002"))
            {
                this.dispose();
                Dashboard_Form dashboard = new Dashboard_Form();
                dashboard.setVisible(true);
            }
            else if(username.equals("pw") && password.equals("pw@092003"))
            {
                this.dispose();
                Dashboard_Form dashboard = new Dashboard_Form();
                dashboard.setVisible(true);
            }
            else if(username.equals("vp") && password.equals("vp@052003"))
            {
                this.dispose();
                Dashboard_Form dashboard = new Dashboard_Form();
                dashboard.setVisible(true);
            }
            else if(username.equals("pk") && password.equals("pk@092004"))
            {
                this.dispose();
                Dashboard_Form dashboard = new Dashboard_Form();
                dashboard.setVisible(true);
            }
 
        // if the username or password are incorrect
        else
        {
           throw new UserCheck();
        }
        }
        catch(UserCheck u)
        {
              if(username.equals(""))
            {
                jLabel_message_text.setText("Enter Your Username First");
            }
              else if(password.equals(""))
            {
                jLabel_message_text.setText("You Need To Enter Your Password"); 
            }
            else
              {
                  jLabel_message_text.setText("Incorrect Username or Password");
              } 
            System.out.println("Exception:"+u);
            System.out.println("PLZ TRY AGAIN");
            System.out.println("***************");
        }
        */
        if(validation()==true)
        {
            verify();
        }
        timerDown.start();
        
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void jCheckBox_showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_showPassActionPerformed
        // TODO add your handling code here:show and hide the password
         if(jCheckBox_showPass.isSelected())
        {
            jPasswordField_password.setEchoChar((char)0);
        }
         else
        {
            jPasswordField_password.setEchoChar('*');
        }
        
    }//GEN-LAST:event_jCheckBox_showPassActionPerformed

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        // TODO add your handling code here:close the form
        this.dispose();
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_upMouseClicked
        // TODO add your handling code here:hide the panel message
        timerUp.start();
    }//GEN-LAST:event_jLabel_upMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Signup_Form signup = new Signup_Form();
        signup.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

    private void jPasswordField_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_login;
    private javax.swing.JCheckBox jCheckBox_showPass;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_message_text;
    private javax.swing.JLabel jLabel_pass;
    private javax.swing.JLabel jLabel_showPass;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_up;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_container;
    private javax.swing.JPanel jPanel_message;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}

class UserCheck extends Exception
{  
    UserCheck()
    {    
        super();  
        System.out.println("User/Password Is InValid");
    }  
}