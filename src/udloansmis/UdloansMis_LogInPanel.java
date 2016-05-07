
package udloansmis;

import RMI.IDatabaseRMI;
import java.awt.Window;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.swing.SwingUtilities;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import security.TokenHandlerClient;

/**
 *
 * @author Christian Genter
 */
public class UdloansMis_LogInPanel extends javax.swing.JPanel {

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
        jTextServer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(237, 150));

        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jTextUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Brugernavn");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adgangskode");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonOK.setText("Forbind");
        jButtonOK.setFocusPainted(false);
        jButtonOK.setFocusable(false);
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Annuller");
        jButtonCancel.setFocusPainted(false);
        jButtonCancel.setFocusable(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTextServer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextServer.setText("54.93.171.44");
        jTextServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextServerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Server-IP");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextServer, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jTextUser)))
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonOK});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField, jTextServer, jTextUser});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextServer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonOK});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jPasswordField, jTextUser});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jTextServer});

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

    private void jTextServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextServerActionPerformed
        // React to 'Enter'-button in server-ip-field
        init();
    }//GEN-LAST:event_jTextServerActionPerformed

    // Check password and do Diffie-Hellman key-exchange
    private void init() {
        try {
            // Save server ip from server-ip-field
            String serverIP;
            if (!jTextServer.getText().equals(""))
                serverIP = jTextServer.getText();
            else
                serverIP = "54.93.171.44";

            // Check RMI-server state to avoid client hang
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(() -> {
                IDatabaseRMI service = (IDatabaseRMI) LocateRegistry
                        .getRegistry(serverIP, 1099).lookup("databaseRMI");
                return null;
            });

            // Wait 5 seconds
            try {
                future.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException | TimeoutException |
                    ExecutionException e) {
                throw new RemoteException();
            }

            // Create brugeradmin SOAP-interface
            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
            QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
            Service service = Service.create(url, qname);
            brugerautorisation.transport.soap.Brugeradmin brugerAdmin = service.getPort(brugerautorisation.transport.soap.Brugeradmin.class);

            // Create database RMI-interface
            databaseRMI = (IDatabaseRMI) Naming.lookup("rmi://" + serverIP + "/databaseRMI");

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
                        System.out.println("Nøgleudveksling godkendt");

                        // Hide log-in panel
                        Window w = SwingUtilities.getWindowAncestor(this);
                        w.setVisible(false);

                        // Create GUI
                        GUI = new UdloansMis_UdlånsMis(tokenhandler, databaseRMI, serverIP);
                        GUI.init();
                        GUI.setResizable(true);
                        GUI.setSize(896, 743);
                        GUI.setTitle("UdlånsMis v1.0");
                        GUI.setVisible(true);
                    } else {
                        // If credentials are accepted from javabog/brugeradmin, but rejected from server (different user on server and client)
                        System.out.println("Nøgleudveksling fejlet");
                        jLabelInfo.setText("Forkert brugernavn/adgangskode");
                        jTextUser.setText("");
                        jPasswordField.setText("");
                    }
                }
            } catch (Exception ex) {
                // If credentials are rejected from javabog/brugeradmin, then prompt user and clear text-/password-field
                jLabelInfo.setText("Forkert brugernavn/adgangskode");
                jTextUser.setText("");
                jPasswordField.setText("");
            }
            // If server is not responding prompt user
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            jLabelInfo.setText("Kan ikke forbinde til server");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextServer;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables
}
