/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentmis;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_UdlånsMisMain {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        // Log-in (Din main bliver nu kørt fra "UdloansMis_LoginjPanel", under "jButtonOKActionPerformed()" efter log-in er accepteret af jacobs server);
        
        UdloansMis_LoginPanelCreator loginhandler = new UdloansMis_LoginPanelCreator();
        loginhandler.paintLogin();
    }
}
