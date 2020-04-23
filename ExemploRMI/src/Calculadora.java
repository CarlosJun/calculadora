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
	
	// Método de soma da calculadora
	public int soma(int a, int b) throws RemoteException {
		// Mostra a quantidade de operações realizadas no servidor até o momento
		System.out.println("Método soma chamado " + chamadas++);
		// Realiza a operação de soma
		return a + b;
	}
	// Método de subtração da calculadora
	public int subtracao(int a, int b) throws RemoteException {
		// Mostra a quantidade de operações realizadas no servidor até o momento
		System.out.println("Método subtração chamado " + chamadas++);
		// Realiza a operação de subtração
		return a - b;
	}
	// Método de multiplicação da calculadora
	public int multiplicacao(int a, int b) throws RemoteException {
		// Mostra a quantidade de operações realizadas no servidor até o momento
		System.out.println("Método multiplicação chamado " + chamadas++);
		// Realiza a operação de multiplicação
		return a * b;
	}
	// Método de divisão da calculadora
	public int divisao(int a, int b) throws RemoteException {
		// Mostra a quantidade de operações realizadas no servidor até o momento
		System.out.println("Método divisão chamado " + chamadas++);
		// Realiza a operação de divisão
		return a / b;
	}


	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException  {
		// Cria um objeto calculadora
		Calculadora calculadora = new Calculadora();	
		// Cria um serviço de nomes Registry, inicialmente nulo
		Registry reg = null;
		// Cria o stub (proxy) para a comunicação remota, exportando o servidor na porta especificada (1100)
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.
				exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			// Cria a referência para o serviço de nomes na porta especificada, caso não exista
			reg = LocateRegistry.createRegistry(1099);
		// Se não for possível criar o serviço de nomes, verifica se já existe um serviço na porta especificada
		} catch (Exception e) {
			try {
				// Obtem o serviço de nomes em execução na porta especificada
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		// Associa o identificador "calculadora" ao stub que foi criado
		reg.rebind("calculadora", stub);
	}
}
