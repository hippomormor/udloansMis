/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Lenovo
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
        
        // Log-in (Din main bliver nu kørt fra "UdloansMis_LoginPanel", under "jButtonOKActionPerformed()" og "init()". 
        // Den starter efter log-in er accepteret af jacobs server og nøglerne er lavet og tjekket);       
        UdloansMis_LoginPanelCreator loginhandler = new UdloansMis_LoginPanelCreator();
        loginhandler.paintLogin();
    }
}
