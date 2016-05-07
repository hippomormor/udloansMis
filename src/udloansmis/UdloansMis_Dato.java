
package udloansmis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas D. Høybye-Jensen
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

            GUI.setDate(dateFormat.format(date));
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UdloansMis_Dato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}

