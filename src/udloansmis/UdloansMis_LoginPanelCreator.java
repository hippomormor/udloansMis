
package udloansmis;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JFrame;

/**
 *
 * @author Christian Genter
 */
public class UdloansMis_LoginPanelCreator {

    public UdloansMis_LogInPanel loginPanel;
    public JFrame vindue = new JFrame();

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
            
            // Set size according to OS
            final String OS = System.getProperty("os.name").toLowerCase();
            if (OS.contains("linux"))
                vindue.setSize(240, 183);
            else if (OS.contains("mac"))
               vindue.setSize(240, 205); 
            else
               vindue.setSize(240, 220); 
            
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
