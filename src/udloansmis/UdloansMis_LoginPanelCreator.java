/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author hippomormor
 */
public class UdloansMis_LoginPanelCreator {

    public UdloansMis_LogInPanel loginPanel;
    public JFrame vindue = new JFrame("UdlånsMis v1.0");

    public void paintLogin() throws NotBoundException, MalformedURLException, RemoteException {

  
            // Create jPanel
            loginPanel = new UdloansMis_LogInPanel();
            
            // Add panel to window
            vindue.add(loginPanel);
            
            // Get screen size:
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = (int) screenSize.getWidth();
            int screenHeight = (int) screenSize.getHeight();
            
            // Make program quit if window is closed/removed, to avoid circumventing security
            vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);          
            
            // Set allways on top
            vindue.setAlwaysOnTop(true);
            
            // Set window size:
            vindue.setSize(233, 160);
            //vindue.setSize((screenWidth / 10), (screenHeight / 10));
            
            // Calculate centre:
            vindue.setLocation(((screenWidth / 2) - vindue.getWidth() / 2), ((screenHeight / 2) - vindue.getHeight() / 2));
            
            // Disable resizing
            vindue.setResizable(false);
            
            // Show window
            vindue.setVisible(true);
            
            // Add windowListener to check for window closing;
            vindue.addWindowListener(new WindowAdapter() {
                
                @Override
                public void windowClosing(WindowEvent e) {
                    
                    // Close program if log-in window closes, to avoid circumventing security
                    System.exit(0);
                }
            });
  
    }
}
