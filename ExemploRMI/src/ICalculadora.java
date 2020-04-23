import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface com as operações da calculadora para um objeto remoto
public interface ICalculadora extends Remote{
	// Definição dos métodos que extende Remote devem levantar a exceção RemoteException
	// Definição do método de soma
	public int soma(int a, int b) throws RemoteException;
	// Definição do método de subtração
	public int subtracao(int a, int b) throws RemoteException;
	// Definição do método de multiplicação
	public int multiplicacao(int a, int b) throws RemoteException;
	// Definição do método de divisão
	public int divisao(int a, int b) throws RemoteException;
}
