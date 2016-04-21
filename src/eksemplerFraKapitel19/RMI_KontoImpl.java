package eksemplerFraKapitel19;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;

public class RMI_KontoImpl extends UnicastRemoteObject implements RMI_KontoI
{
        private final String navn = "Marcus";
	private int saldo = 100; // man starter med 100 kroner
	private ArrayList<String> bevægelser = new ArrayList<>();

	public RMI_KontoImpl() throws java.rmi.RemoteException 
	{
	}
        
        public void overførsel(int kroner)
{
	int nySaldo = saldo + kroner; // her beregnes ny saldo
	String s = "Overførsel på "+kroner+" kr. Ny saldo er "+saldo+" kr.";
	System.out.println(s);
	//try { Thread.sleep(1000); } catch (InterruptedException ex) { } // transaktionen gemmes
	saldo = nySaldo; // her er transaktionen gemt
	bevægelser.add(s);
}

	public int saldo()
	{
		System.out.println("Der spørges om saldoen. Den er "+saldo+" kr.");
		return saldo;
	}

	public ArrayList<String> bevægelser()
	{
		System.out.println("Der spørges på alle bevægelser.");
		return bevægelser;
	}
        
        public void hævning(int kroner)
        {
            saldo = saldo - kroner;
            String s = "Hævning på "+kroner+"kr. Ny saldo er "+saldo+"kr.";
            bevægelser.add(s);
            System.out.println(s);
        }
        
        public String getNavn(){
            System.out.println("Navnet på kontoen er "+navn+".");
            return navn;
        }

}