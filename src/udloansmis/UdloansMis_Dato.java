/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_Dato implements Runnable { 

    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM-yyyy HH:mm:ss");
    private java.util.Date date;
    private static UdloansMis_UdlånsMis GUI;
    public UdloansMis_Dato(UdloansMis_UdlånsMis GUI) {
        date = new java.util.Date();
        this.GUI = GUI;
    }
    
    
    @Override
    public void run(){
        while(true){
            date = new java.util.Date();
            //System.out.println(dateFormat.format(date));

            GUI.setDate(dateFormat.format(date));
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UdloansMis_Dato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}

