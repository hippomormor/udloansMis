/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_UdlånsMisMain {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        try {
            
        // Set cross-platform Java look and feel (also called "Metal") - Blev nød til at ændre LookAndFeel, 
        // så log-in vinduet ikke resizede mellem Windows, Linux og Mac
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
       e.printStackTrace();
    }
      
        // Log-in (Din main bliver nu kørt fra "UdloansMis_LoginPanel", under "jButtonOKActionPerformed()" og "init()", efter log-in er accepteret af jacobs server og nøglerne er lavet og tjekket);       
        UdloansMis_LoginPanelCreator loginhandler = new UdloansMis_LoginPanelCreator();
        loginhandler.paintLogin();
    }
}
