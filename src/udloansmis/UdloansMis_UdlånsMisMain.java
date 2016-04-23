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
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_UdlånsMisMain {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}

        // Log-in (Din main bliver nu kørt fra "UdloansMis_LoginPanel", under "jButtonOKActionPerformed()" og "init()". 
        // Den starter efter log-in er accepteret af jacobs server og nøglerne er lavet og tjekket);       
        UdloansMis_LoginPanelCreator loginhandler = new UdloansMis_LoginPanelCreator();
        loginhandler.paintLogin();
    }
}
