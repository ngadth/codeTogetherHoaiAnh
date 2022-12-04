/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.forgotPasswordCtl;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author hoaianh_Kyros
 */
public class ResetPasswordFrm extends javax.swing.JFrame {

    /**
     * Creates new form ResetPasswordFrm
     */
    public ResetPasswordFrm() {
        initComponents();
        this.setSize(1210, 720);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBtn();
    }
    
    public void setBtnNoBorder(JButton button) {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() {
        setBtnNoBorder(btnOke);
        setBtnNoBorder(btnBack);
    }
    
    
    public void reset()
    {
        txtPassword.setText("");
        txtPasswordAgain.setText("");
    }
    
    public boolean checkBlankField()
    {
        return txtPassword.getText().isEmpty() || txtPasswordAgain.getText().isEmpty();
    }
    
    public boolean regexPassword(String str) // Kiem tra password co hop le hay ko? (it nhat 8 ky tu, 1 chu cai, 1 chu thuong, 1 ky tu dac biet)
    {
      String pattern = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&+=])\\S{8,}\\z";
      return str.matches(pattern);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOke = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordAgain = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnOke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkeActionPerformed(evt);
            }
        });
        getContentPane().add(btnOke);
        btnOke.setBounds(520, 520, 140, 70);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(30, 60, 90, 90);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(txtPassword);
        txtPassword.setBounds(600, 270, 415, 60);

        txtPasswordAgain.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(txtPasswordAgain);
        txtPasswordAgain.setBounds(600, 380, 410, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/RESET.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkeActionPerformed
        if(!checkBlankField())
        {
            if(txtPasswordAgain.getText().equals(txtPassword.getText()))
            {
                if(regexPassword(txtPassword.getText()))
                {
                    new forgotPasswordCtl().resetPassword(forgotPasswordCtl.username, txtPassword.getText());
                    JOptionPane.showMessageDialog(null, "Change password sucessfully");
                    this.dispose();
                    new LoginFrm();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Password must contain at least eight characters, "
                                + "at least one number and both lower and uppercase letters and special characters");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Password does not match. Please enter again");
                this.reset();
            }
        }
    }//GEN-LAST:event_btnOkeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new LoginFrm();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ResetPasswordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPasswordFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordAgain;
    // End of variables declaration//GEN-END:variables
}