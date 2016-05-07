
package udloansmis;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Christian Genter
 */
public class UdloansMis_UdlånsMisMain {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {


        // Check & set Nimbus theme
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            try {
                // Set default theme if Nimbus is not found
                System.out.println("Nimbus not found - resolving to default Look & Feel");
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(UdloansMis_UdlånsMisMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        UdloansMis_LoginPanelCreator loginhandler = new UdloansMis_LoginPanelCreator();
        loginhandler.paintLogin();
    }
}
