/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import RMI.IDatabaseRMI;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.awt.Window;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;
import security.TokenHandlerClient;

/**
 *
 * @author hippomormor
 */
public class UdloansMis_LogInPanel extends javax.swing.JPanel {

    private Brugeradmin brugerAdmin;

    private IDatabaseRMI databaseRMI;

    private UdloansMis_UdlånsMis GUI;

    /**
     * Creates new form UdloansMis_LogIn
     *
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    public UdloansMis_LogInPanel() throws NotBoundException, MalformedURLException, RemoteException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField = new javax.swing.JPasswordField();
        jTextUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jTextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUserActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButtonOK.setText("Ok");
        jButtonOK.setFocusPainted(false);
        jButtonOK.setFocusable(false);
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.setFocusPainted(false);
        jButtonCancel.setFocusable(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonOK});

    }// </editor-fold>//GEN-END:initComponents

    private void jTextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUserActionPerformed
        // React to 'Enter'-button in username-field
        init();
    }//GEN-LAST:event_jTextUserActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // React to OK-button
        init();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // Exit if Cancel-button is clicked
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // React to 'Enter'-button in password-field
        init();
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    // Check password and do Diffie-Hellman key-exchange
    private void init() {
        try {
            // Create brugeradmin RMI-interface
            brugerAdmin = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
            
            // Create database RMI-interface
            databaseRMI = (IDatabaseRMI) Naming.lookup("rmi://52.28.66.187/databaseRMI");
            // Save username from text-field
            String user = jTextUser.getText();
            
            // Save password from password-field
            char[] pass = jPasswordField.getPassword();
            
            try {
                // Check javabog-brugeradmin if user is OK
                if (brugerAdmin.hentBruger(user, new String(pass)) != null) {
                    
                    // Create tokenhandler with user + password
                    TokenHandlerClient tokenhandler = new TokenHandlerClient(user, new String(pass));
                    
                    tokenhandler.setID(databaseRMI.getNewID());
                    
                    // Send own token to server. Then generate key from server token
                    tokenhandler.generateKey(databaseRMI.exchangeTokens(tokenhandler.getPublicToken(), tokenhandler.getID()));
                    
                    // Send own key and request key from server
                    BigInteger serverKey = databaseRMI.exchangeKeys(tokenhandler.getKeyToken(), tokenhandler.getID());
                    
                    // Check if server-key matches own key
                    if (tokenhandler.checkKey(serverKey)) {
                        System.out.println("Key matching successful");
                        
                        // Hide log-in panel
                        Window w = SwingUtilities.getWindowAncestor(this);
                        w.setVisible(false);
                        
                        // Create GUI
                        GUI = new UdloansMis_UdlånsMis(tokenhandler, databaseRMI);      // <------------------------------------------------------------- HER ER DIN MAIN :)
                        GUI.init();
                        GUI.setVisible(true);
                    } else {
                        // If credentials are accepted from javabog/brugeradmin, but rejected from server (different user on server and client)
                        System.out.println("Key matching unsuccessful");
                        jLabelInfo.setText("Wrong username or password");
                        jTextUser.setText("");
                        jPasswordField.setText("");
                    }
                }
            } catch (Exception ex) {
                // If credentials are rejected from javabog/brugeradmin, then prompt user and clear text-/password-field
                jLabelInfo.setText("Wrong username or password");
                jTextUser.setText("");
                jPasswordField.setText("");
            }
        // If server is not responding prompt user
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                jLabelInfo.setText("  Unable to connect to server");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables
}
