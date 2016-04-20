package komponentmis;
import java.util.ArrayList;

public interface RMI_KontoI extends java.rmi.Remote
{
	void overførsel(int kroner)    throws java.rmi.RemoteException;
	int saldo()                    throws java.rmi.RemoteException;
        void hævning(int kroner)        throws java.rmi.RemoteException;
        String getNavn()                throws java.rmi.RemoteException;
	ArrayList<String> bevægelser() throws java.rmi.RemoteException;
}