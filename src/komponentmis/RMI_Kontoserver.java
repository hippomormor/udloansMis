package komponentmis;
import java.rmi.Naming;
public class RMI_Kontoserver
{
	public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

		RMI_KontoI k = new RMI_KontoImpl();
		Naming.rebind("rmi://localhost/kontotjeneste", k);
		System.out.println("Kontotjeneste registreret.");
	}
}
/*
	// På serveren javabog.dk - start med f.eks.:
	// java -Djava.rmi.server.hostname=javabog.dk -cp oop-projekt.jar kapitel_19.RMI_Kontoserver
		java.rmi.registry.LocateRegistry.createRegistry(20099); // lyt på port 20099
		RMI_KontoI k = new RMI_KontoImpl();
		System.setProperty("java.rmi.server.hostname", "javabog.dk");
		Naming.rebind("rmi://javabog.dk:20099/kontotjeneste", k);
*/
