import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface com as opera��es da calculadora para um objeto remoto
public interface ICalculadora extends Remote{
	// Defini��o dos m�todos que extende Remote devem levantar a exce��o RemoteException
	// Defini��o do m�todo de soma
	public int soma(int a, int b) throws RemoteException;
	// Defini��o do m�todo de subtra��o
	public int subtracao(int a, int b) throws RemoteException;
	// Defini��o do m�todo de multiplica��o
	public int multiplicacao(int a, int b) throws RemoteException;
	// Defini��o do m�todo de divis�o
	public int divisao(int a, int b) throws RemoteException;
}
