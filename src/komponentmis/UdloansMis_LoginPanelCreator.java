/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentmis;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JFrame;

/**
 *
 * @author hippomormor
 */
public class UdloansMis_LoginPanelCreator {

    public UdloansMis_LogInJPanel loginPanel;
    public JFrame vindue = new JFrame("UdlånsMis v1.0");

    public void paintLogin() throws NotBoundException, MalformedURLException, RemoteException {

        String user;
        char[] pass;
        loginPanel = new UdloansMis_LogInJPanel();

        vindue.add(loginPanel);
        // Get screen size:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Set window size:
        vindue.setSize(245, 150);
        // Calculate centre:
        vindue.setLocation(((screenWidth / 2) - vindue.getWidth() / 2), ((screenHeight / 2) - vindue.getHeight() / 2));
        vindue.setResizable(false);
        vindue.setVisible(true);

        // Add windowListener to check for window closing;
        vindue.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
