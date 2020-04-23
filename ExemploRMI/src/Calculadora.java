import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Implementa a interface definida para calculadora
public class Calculadora implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	private static int chamadas = 0;
	
	// M�todo de soma da calculadora
	public int soma(int a, int b) throws RemoteException {
		// Mostra a quantidade de opera��es realizadas no servidor at� o momento
		System.out.println("M�todo soma chamado " + chamadas++);
		// Realiza a opera��o de soma
		return a + b;
	}
	// M�todo de subtra��o da calculadora
	public int subtracao(int a, int b) throws RemoteException {
		// Mostra a quantidade de opera��es realizadas no servidor at� o momento
		System.out.println("M�todo subtra��o chamado " + chamadas++);
		// Realiza a opera��o de subtra��o
		return a - b;
	}
	// M�todo de multiplica��o da calculadora
	public int multiplicacao(int a, int b) throws RemoteException {
		// Mostra a quantidade de opera��es realizadas no servidor at� o momento
		System.out.println("M�todo multiplica��o chamado " + chamadas++);
		// Realiza a opera��o de multiplica��o
		return a * b;
	}
	// M�todo de divis�o da calculadora
	public int divisao(int a, int b) throws RemoteException {
		// Mostra a quantidade de opera��es realizadas no servidor at� o momento
		System.out.println("M�todo divis�o chamado " + chamadas++);
		// Realiza a opera��o de divis�o
		return a / b;
	}


	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException  {
		// Cria um objeto calculadora
		Calculadora calculadora = new Calculadora();	
		// Cria um servi�o de nomes Registry, inicialmente nulo
		Registry reg = null;
		// Cria o stub (proxy) para a comunica��o remota, exportando o servidor na porta especificada (1100)
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.
				exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			// Cria a refer�ncia para o servi�o de nomes na porta especificada, caso n�o exista
			reg = LocateRegistry.createRegistry(1099);
		// Se n�o for poss�vel criar o servi�o de nomes, verifica se j� existe um servi�o na porta especificada
		} catch (Exception e) {
			try {
				// Obtem o servi�o de nomes em execu��o na porta especificada
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		// Associa o identificador "calculadora" ao stub que foi criado
		reg.rebind("calculadora", stub);
	}
}
