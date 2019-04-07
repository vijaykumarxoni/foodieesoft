/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.frames;

import geeks.foodieesoft.beans.Permissions;
import geeks.foodieesoft.beans.UserPermissions;
import geeks.foodieesoft.beans.UserType;
import geeks.foodieesoft.dao.DBManager;
import geeks.foodieesoft.dao.DBManagerInterface;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vksoni
 */
public class UserPermissionsPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPermisssion
     */
    DBManagerInterface dbManager;
    DefaultComboBoxModel comboBoxModelUserType;
    public ArrayList<UserType> user_types_list;
    public ArrayList<Permissions> unassign_permission_list;
    public ArrayList<Permissions> assign_permission_list;

    public static int user_id = LoginPage.user_id;
    public static int user_type_id = LoginPage.user_cat_id;

    DefaultListModel permission_unassign_list_model;
    DefaultListModel permission_assign_list_model;

    public UserPermissionsPage() {
        initComponents();

        dbManager = new DBManager();
        comboBoxModelUserType = (DefaultComboBoxModel) this.jComboBoxUserType.getModel();
        this.jComboBoxUserType.setVisible(true);
        permission_assign_list_model = new DefaultListModel();
        permission_unassign_list_model = new DefaultListModel();
        this.jListAssignedPermsission.setModel(permission_assign_list_model);
        this.jListUnAssignedPermisssion.setModel(permission_unassign_list_model);
        showInUserTypesComboBox();
        showInAssginPermissionList(user_types_list.get(this.jComboBoxUserType.getSelectedIndex()).getUser_cat_id());
        showInUnassginPermissionList(user_types_list.get(this.jComboBoxUserType.getSelectedIndex()).getUser_cat_id());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxUserType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAssignedPermsission = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListUnAssignedPermisssion = new javax.swing.JList<>();
        jButtonUpdatePermissions = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUnassign = new javax.swing.JButton();
        jLabelMin = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxUserType.setBackground(new java.awt.Color(0, 0, 51));
        jComboBoxUserType.setForeground(new java.awt.Color(0, 204, 0));
        jComboBoxUserType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUserTypeItemStateChanged(evt);
            }
        });
        jComboBoxUserType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxUserTypeMouseClicked(evt);
            }
        });
        jComboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 550, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Assigned Permissions");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 250, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 550, -1));

        jScrollPane1.setViewportView(jListAssignedPermsission);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 300, 390));

        jScrollPane2.setViewportView(jListUnAssignedPermisssion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 300, 390));

        jButtonUpdatePermissions.setBackground(new java.awt.Color(0, 204, 0));
        jButtonUpdatePermissions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdatePermissions.setForeground(new java.awt.Color(0, 0, 51));
        jButtonUpdatePermissions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/update.png"))); // NOI18N
        jButtonUpdatePermissions.setText("Update Permission");
        jButtonUpdatePermissions.setBorder(null);
        jButtonUpdatePermissions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePermissionsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdatePermissions, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 190, 50));

        jButtonBack.setBackground(new java.awt.Color(0, 204, 0));
        jButtonBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(0, 0, 51));
        jButtonBack.setText("Back");
        jButtonBack.setBorder(null);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("USER TYPE*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Unassigned Permissions");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 270, -1));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus-icon-0.png"))); // NOI18N
        jButtonAdd.setBorder(null);
        jButtonAdd.setBorderPainted(false);
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 60, 70));

        jButtonUnassign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Minus_icon.png"))); // NOI18N
        jButtonUnassign.setBorder(null);
        jButtonUnassign.setBorderPainted(false);
        jButtonUnassign.setContentAreaFilled(false);
        jButtonUnassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnassignActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUnassign, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 530));

        jLabelMin.setBackground(new java.awt.Color(255, 0, 0));
        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMin.setText("-");
        jLabelMin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 40, 40));

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
        getContentPane().add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("User Permisisons");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUserTypeActionPerformed

    private void jButtonUpdatePermissionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePermissionsActionPerformed
            JOptionPane.showMessageDialog(this, "Updated Permissions Succesfully");
            
            
    }//GEN-LAST:event_jButtonUpdatePermissionsActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HomePage(user_id,user_type_id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jComboBoxUserTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxUserTypeMouseClicked

    private void jComboBoxUserTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeItemStateChanged
        // TODO add your handling code here:
        int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex()).getUser_cat_id();
        showInAssginPermissionList(user_cat_id);
        showInUnassginPermissionList(user_cat_id);


    }//GEN-LAST:event_jComboBoxUserTypeItemStateChanged

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        // TODO add your handling code here:

        this.jLabelExit.setBackground(Color.red);
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        // TODO add your handling code here:
        this.jLabelExit.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (!(this.jListUnAssignedPermisssion.isSelectionEmpty())) {
            int permission_id = unassign_permission_list.get(this.jListUnAssignedPermisssion.getSelectedIndex()).getPermission_id();
            int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex()).getUser_cat_id();
            dbManager.savePermission(new UserPermissions(user_cat_id, permission_id));
            showInAssginPermissionList(user_cat_id);
            showInUnassginPermissionList(user_cat_id);
        } else {
            JOptionPane.showMessageDialog(this, "Please select permission from Unassigned Permssion List ");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUnassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnassignActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        if (!(this.jListAssignedPermsission.isSelectionEmpty())) {
            int permission_id = assign_permission_list.get(this.jListAssignedPermsission.getSelectedIndex()).getPermission_id();
            int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex()).getUser_cat_id();
            dbManager.deletePermission(new UserPermissions(user_cat_id, permission_id));
            showInAssginPermissionList(user_cat_id);
            showInUnassginPermissionList(user_cat_id);
        } else {
            JOptionPane.showMessageDialog(this, "Please select permission from Assigned Permssion List ");

        }

    }//GEN-LAST:event_jButtonUnassignActionPerformed

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
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPermissionsPage().setVisible(true);
            }
        });
    }

    public void showInUserTypesComboBox() {
        user_types_list = dbManager.getAllUserTypes();
        for (UserType userType : user_types_list) {

            this.jComboBoxUserType.addItem("" + userType.getUser_type());

        }
    }

    public void showInUnassginPermissionList(int user_cat_id) {
        unassign_permission_list = dbManager.getUnassignedPermissions(user_cat_id);
        this.permission_unassign_list_model.clear();
        for (Permissions permission : unassign_permission_list) {
            this.permission_unassign_list_model.addElement("" + permission.getPermission_name());
        }
    }

    public void showInAssginPermissionList(int user_cat_id) {
        assign_permission_list = dbManager.getAssignedPermissions(user_cat_id);
        this.permission_assign_list_model.clear();
        for (Permissions permission : assign_permission_list) {
            this.permission_assign_list_model.addElement("" + permission.getPermission_name());
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonUnassign;
    private javax.swing.JButton jButtonUpdatePermissions;
    private javax.swing.JComboBox<String> jComboBoxUserType;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JList<String> jListAssignedPermsission;
    private javax.swing.JList<String> jListUnAssignedPermisssion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
