/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import RMI.IDatabaseRMI;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.TokenHandlerClient;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_CheckForServer implements Runnable {

    public boolean isConnectedToServer = false;
    private boolean isConnectionDropped = false;
    private String serverIP;    

    private final UdloansMis_UdlånsMis GUI;
    private final TokenHandlerClient tokenhandler;
    private IDatabaseRMI database;

    public UdloansMis_CheckForServer(UdloansMis_UdlånsMis GUI, TokenHandlerClient tokenhandler, IDatabaseRMI database, String serverIP) {
        this.GUI = GUI;
        this.tokenhandler = tokenhandler;
        this.database = database;
        this.serverIP = serverIP;
    }

    @Override
    public void run() {
        while (true) {

            try {
                // check if connection was dropped & re-init RMI and make DH key-exchange if true
                if (!isConnectedToServer && isConnectionDropped) {
                    
                    // Restart RMI-connection
                    database = (IDatabaseRMI) Naming.lookup("rmi://" + serverIP + "/databaseRMI");
                    
                    tokenhandler.setID(database.getNewID());
                    
                    // Send own token to server. Then generate key from server token
                    tokenhandler.generateKey(database.exchangeTokens(tokenhandler.getPublicToken(), tokenhandler.getID()));

                    // Send own key and request key from server
                    isConnectedToServer = tokenhandler.checkKey(database.exchangeKeys(tokenhandler.getKeyToken(), tokenhandler.getID()));
                    isConnectionDropped = false;
                    
                    // Update GUI-status
                    GUI.CheckServer(isConnectedToServer);

                } else {
                    
                    // Exchange keys with server, set boolean & check server-key
                    isConnectedToServer = tokenhandler.checkKey(database.exchangeKeys(tokenhandler.getKeyToken(), tokenhandler.getID()));
                    
                    // Update GUI-status
                    GUI.CheckServer(isConnectedToServer);           
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UdloansMis_CheckForServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            // Catch exception when server is missing and set booleans
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                isConnectedToServer = false;
                isConnectionDropped = true;
                GUI.CheckServer(isConnectedToServer);
            }
        }
    }
}
