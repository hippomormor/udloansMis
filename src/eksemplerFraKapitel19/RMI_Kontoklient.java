package eksemplerFraKapitel19;
import java.rmi.Naming;
import java.util.ArrayList;

public class RMI_Kontoklient
{
	public static void main(String[] arg) throws Exception
	{
		//  RMI_KontoI k =(RMI_KontoI) Naming.lookup("rmi://javabog.dk:20099/kontotjeneste");
		RMI_KontoI k =(RMI_KontoI) Naming.lookup("rmi://localhost/kontotjeneste");
                long tid = System.currentTimeMillis();
                for(int i = 0; i<50; i++){
                    k.overførsel(1);
                    k.hævning(1);
                }
                long tid2 = System.currentTimeMillis();
                System.out.println("Tiden for 100 RMI transaktioner er: " + (tid2-tid)+"mS");
                System.out.println("Tiden for 1 RMI transaktion er: " + ((tid2-tid)/100)+"mS");
		
                k.getNavn();
                System.out.println( "Saldo er: "+ k.saldo() );
		ArrayList<String> bevægelser = k.bevægelser();
		System.out.println( "Bevægelser er: "+ bevægelser );
                
	}
}