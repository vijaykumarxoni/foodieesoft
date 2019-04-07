/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.frames;

import com.sun.glass.events.KeyEvent;
import geeks.foodieesoft.beans.User;
import geeks.foodieesoft.dao.DBManager;
import geeks.foodieesoft.dao.DBManagerInterface;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vksoni
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public static int user_id;
    public static int user_cat_id;
    DBManagerInterface dbManager;
    User user;

    public LoginPage() {
        initComponents();
        dbManager = new DBManager();
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
        jTextFieldUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldUsername.setText("Enter Username");
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUsernameMouseClicked(evt);
            }
        });
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 260, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 260, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 260, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jPasswordFieldPassword.setText("@Enter_Password");
        jPasswordFieldPassword.setBorder(null);
        jPasswordFieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldPasswordMouseClicked(evt);
            }
        });
        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 260, -1));

        jButtonLogin.setBackground(new java.awt.Color(0, 204, 0));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 51));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setBorder(null);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 260, 30));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 580, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Untitled-1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 580, 220));

        jLabelExit.setBackground(new java.awt.Color(0, 0, 51));
        jLabelExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabelExit.setOpaque(true);
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });
        getContentPane().add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 40, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Login Form");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        if (!(this.jTextFieldUsername.getText().equals("Enter Username")
            && this.jPasswordFieldPassword.getText().equals("@Enter_Password"))) {

        user = dbManager.userAuthentication(this.jTextFieldUsername.getText(),
            this.jPasswordFieldPassword.getText());
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Invalid Password or username!");
            this.jTextFieldUsername.setText("Enter Username");
            this.jPasswordFieldPassword.setText("@Enter_Password");
        } else if ((user.getUser_name().equals(this.jTextFieldUsername.getText()))
            && (user.getPassword().equals(this.jPasswordFieldPassword.getText()))) {
            this.jTextFieldUsername.setText("");
            this.jPasswordFieldPassword.setText("@Enter_Password");
            user_id = user.getUser_id();
            user_cat_id = user.getUser_cat_id();
            new HomePage(user_id, user_cat_id).setVisible(true);
            this.dispose();
        }
        } else {
            JOptionPane.showMessageDialog(this, "Please type Username & Password");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if (this.jPasswordFieldPassword.getText().equalsIgnoreCase("@Enter_Password")) {
            this.jPasswordFieldPassword.setText("");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!(this.jTextFieldUsername.getText().equals("Enter Username")
                && this.jPasswordFieldPassword.getText().equals("@Enter_Password"))) {

            user = dbManager.userAuthentication(this.jTextFieldUsername.getText(),
                this.jPasswordFieldPassword.getText());
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid Password or username!");
                this.jTextFieldUsername.setText("Enter Username");
                this.jPasswordFieldPassword.setText("@Enter_Password");
            } else if ((user.getUser_name().equals(this.jTextFieldUsername.getText()))
                && (user.getPassword().equals(this.jPasswordFieldPassword.getText()))) {
                this.jTextFieldUsername.setText("");
                this.jPasswordFieldPassword.setText("");
                user_id = user.getUser_id();
                user_cat_id = user.getUser_cat_id();
                new HomePage(user_id, user_cat_id).setVisible(true);// if pass correct than open homepage
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please type Username & Password");
        }

        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void jPasswordFieldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordMouseClicked
        if (this.jPasswordFieldPassword.getText().equalsIgnoreCase("@Enter_Password")) {
            this.jPasswordFieldPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldPasswordMouseClicked

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        // TODO add your handling code here:
        if (this.jTextFieldUsername.getText().equalsIgnoreCase("Enter Username")) {
            this.jTextFieldUsername.setText("");
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!(this.jTextFieldUsername.getText().equals("Enter Username")
                && this.jPasswordFieldPassword.getText().equals("@Enter_Password"))) {

            user = dbManager.userAuthentication(this.jTextFieldUsername.getText(),
                this.jPasswordFieldPassword.getText());
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid Password or username!");
                this.jTextFieldUsername.setText("Enter Username");
                this.jPasswordFieldPassword.setText("@Enter_Password");
            } else if ((user.getUser_name().equals(this.jTextFieldUsername.getText()))
                && (user.getPassword().equals(this.jPasswordFieldPassword.getText()))) {
                this.jTextFieldUsername.setText("");
                this.jPasswordFieldPassword.setText("@Enter_Password");
                user_id = user.getUser_id();
                user_cat_id = user.getUser_cat_id();
                new HomePage(user_id, user_cat_id).setVisible(true);// if pass correct than open homepage
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please type Userna        this.jLabelExit.setBackground(new Color(0,0,51));\n" +
"me & Password");
        }
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jTextFieldUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsernameMouseClicked
        if (this.jTextFieldUsername.getText().equalsIgnoreCase("Enter Username")) {
            this.jTextFieldUsername.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsernameMouseClicked

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        this.jLabelExit.setBackground(Color.red);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        this.jLabelExit.setBackground(new Color(0, 0, 51));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelExitMouseExited

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
