/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentmis;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lenovo
 */
public class UdloansMis_CheckForServer implements Runnable {
    public boolean isConnectedToServer = false;


    private static UdloansMis_UdlånsMis GUI;

    public UdloansMis_CheckForServer(UdloansMis_UdlånsMis GUI) {
        this.GUI = GUI;
    }
    
    @Override
    public void run() {
        while (true) {
            isConnectedToServer = (!isConnectedToServer);
            GUI.CheckServer(isConnectedToServer);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UdloansMis_CheckForServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public boolean CheckServer(){
        
        return isConnectedToServer;
    }
}
