
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CH
 */
public class Signup_Form extends javax.swing.JFrame {
    
    /**
     * Creates new form Sign-up_Form
     */
    public Signup_Form() 
    {
        initComponents();
        
        //center the form
        this.setLocationRelativeTo(null);
        
         jLabel_show1.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/Eye.png")));
         jLabel_up1.setIcon(new javax.swing.ImageIcon(getClass().getResource("IMAGES/Up.png")));
        
    }
   
    //validate signup
    public boolean validation()
    {
        String username,passkey,email;
        username=jTextField_User1.getText();
        passkey=jPasswordField_password1.getText();
        email=jTextField_Email.getText();
        
        boolean alphabets = passkey.matches(".*[a-zA-Z]+.*");
	boolean numbers = passkey.matches(".*[0-9]+.*");
	Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
	Matcher m = specialCharacters.matcher(passkey);
        
        try {
               if(username.equals(""))
               {
                   //JOptionPane.showMessageDialog(this,"please enter username");
                   //jLabel_message_text.setText("Enter Your Username First");                 
                   //return false;
                   throw new UserCheck1();
               }
               else if(passkey.equals(""))
               {
                   //JOptionPane.showMessageDialog(this,"please enter password");
                   //jLabel_message_text.setText("Enter Your Passkey First");
                   //return false;
                   throw new UserCheck1();
               }
               else if(email.equals(""))
               {
                   //JOptionPane.showMessageDialog(this,"please enter password");
                   //jLabel_message_text.setText("Enter Your Passkey First");
                   //return false;
                   throw new UserCheck1();
               }
               
               else if(passkey.length()<8)
                {
                    throw new InvalidLength();
		}
		else if(alphabets==false)
		{
                    throw new InvalidNoOfAlphabets();
		}
		else if(numbers==false)
		{
                    throw new InvalidNoOfNumbers();
		}
		else if(!(m.find()))
		{
                    throw new InvalidNoOfSpecialCharacters();
		}  
        }
        
        catch(Exception u)
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
                else if(email.equals(""))
            {
                jLabel_message_text.setText("You Need To Enter Your Email"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
             else if(passkey.length()<8)
            {
                jLabel_message_text.setText("Lenght must be greater than 8"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
            else if(alphabets==false)
            {
                jLabel_message_text.setText("Atleast 1 alphabet must be there"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
            else if(numbers==false)
            {
                jLabel_message_text.setText("Atleast 1 number must be there"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }
            else if(!(m.find()))
            {
                jLabel_message_text.setText("Atleast 1 special character must be there"); 
                System.out.println("Exception:"+u);
                System.out.println("PLZ TRY AGAIN");
                System.out.println("***************");
                return false;
            }         
        }
       return true;
    }
       
    //insert into derby database
    public void insertIntoDB()
    {
        String username,passkey,email;
        username=jTextField_User1.getText();
        passkey=jPasswordField_password1.getText();
        email=jTextField_Email.getText();
     try 
     {
        Class.forName("org.apache.derby.client.ClientAutoloadedDriver");
        java.sql.Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/signupdemo;create=true");
        java.sql.Statement st=con.createStatement();
        String sql = "insert into signup values('"+username+"','"+passkey+"','"+email+"')";
        st.execute(sql);
        //JOptionPane.showMessageDialog(this,"Account created");
        jLabel_message_text.setText("Account Created"); 
     }
     catch(Exception e)
     {
        JOptionPane.showMessageDialog(this,e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_User1 = new javax.swing.JTextField();
        jPasswordField_password1 = new javax.swing.JPasswordField();
        jLabel_show1 = new javax.swing.JLabel();
        jCheckBox_show2 = new javax.swing.JCheckBox();
        jButton_signup = new javax.swing.JButton();
        jPanel_message = new javax.swing.JPanel();
        jLabel_up1 = new javax.swing.JLabel();
        jLabel_message_text = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PPVC SIGNUP");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("UserName :");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("PassKey  :");

        jTextField_User1.setBackground(new java.awt.Color(0, 0, 204));
        jTextField_User1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jTextField_User1.setForeground(new java.awt.Color(255, 255, 0));

        jPasswordField_password1.setBackground(new java.awt.Color(0, 0, 204));
        jPasswordField_password1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jPasswordField_password1.setForeground(new java.awt.Color(255, 255, 0));

        jCheckBox_show2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_show2ActionPerformed(evt);
            }
        });

        jButton_signup.setBackground(new java.awt.Color(0, 153, 153));
        jButton_signup.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jButton_signup.setForeground(new java.awt.Color(255, 255, 0));
        jButton_signup.setText("SIGN-UP");
        jButton_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signupActionPerformed(evt);
            }
        });

        jPanel_message.setBackground(new java.awt.Color(240, 52, 52));
        jPanel_message.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_message.setToolTipText("");
        jPanel_message.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel_up1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_up1MouseClicked(evt);
            }
        });

        jLabel_message_text.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel_message_text.setForeground(new java.awt.Color(255, 255, 0));
        jLabel_message_text.setToolTipText("");

        javax.swing.GroupLayout jPanel_messageLayout = new javax.swing.GroupLayout(jPanel_message);
        jPanel_message.setLayout(jPanel_messageLayout);
        jPanel_messageLayout.setHorizontalGroup(
            jPanel_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_messageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_up1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_message_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_messageLayout.setVerticalGroup(
            jPanel_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_messageLayout.createSequentialGroup()
                .addComponent(jLabel_up1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_message_text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("To_LOGIN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 52, 52));
        jButton2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLOSE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("E-Mail  :");

        jTextField_Email.setBackground(new java.awt.Color(0, 0, 204));
        jTextField_Email.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jTextField_Email.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Email))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_User1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel_show1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox_show2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField_password1)
                            .addComponent(jButton_signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_message, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_User1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_Email)
                        .addGap(1, 1, 1)))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_show2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_show1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_message, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(600, 600, 600))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //timer to hide the message panel
     Timer timerUp = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //To change body of generated methods, choose Tools | Templates.
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
     
     //timer to show the message panel
     Timer timerDown = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //To change body of generated methods, choose Tools | Templates.
             if(jPanel_message.getHeight() != 100)
            {
               jPanel_message.setBounds(jPanel_message.getX(), jPanel_message.getY(), jPanel_message.getWidth(), jPanel_message.getHeight() + 5);
            }
            else
            {
                timerDown.stop();
            }
        }
     });
    
    private void jCheckBox_show2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_show2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox_show2.isSelected())
        {
            jPasswordField_password1.setEchoChar((char)0);
        }
         else
        {
            jPasswordField_password1.setEchoChar('*');
        }   
        
    }//GEN-LAST:event_jCheckBox_show2ActionPerformed

    private void jButton_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signupActionPerformed
        // TODO add your handling code here:
        
        if(validation()==true)
        {
            insertIntoDB();
        }        
        timerDown.start();
    }//GEN-LAST:event_jButton_signupActionPerformed

    private void jLabel_up1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_up1MouseClicked
        // TODO add your handling code here:
        timerUp.start();
    }//GEN-LAST:event_jLabel_up1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login_form login = new Login_form();
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_signup;
    private javax.swing.JCheckBox jCheckBox_show2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_message_text;
    private javax.swing.JLabel jLabel_show1;
    private javax.swing.JLabel jLabel_up1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_message;
    private javax.swing.JPasswordField jPasswordField_password1;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_User1;
    // End of variables declaration//GEN-END:variables
}

 //error handling
    class UserCheck1 extends Exception
{  
    UserCheck1()
    {    
        super();  
        System.out.println("Account Not Created");
    }  
}

class InvalidLength extends Exception{  
 InvalidLength(){  
  super();  
  System.out.println("Check PassKey");
 }  
}  

class InvalidNoOfAlphabets extends Exception{  
	 InvalidNoOfAlphabets(){  
	  super();  
	  System.out.println("Check PassKey");
	 }  
	}

class InvalidNoOfNumbers extends Exception{  
	 InvalidNoOfNumbers(){  
	  super();  
	  System.out.println("Check PassKey");
	 }  
	} 

class InvalidNoOfSpecialCharacters extends Exception{  
	 InvalidNoOfSpecialCharacters(){  
	  super();  
	  System.out.println("Check PassKey");
	 }  
	} 
