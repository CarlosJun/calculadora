import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculadoraCliente {
	
	public static void main(String[] args) {
		// Cria uma variável para armazenar um serviço de nomes Registry, inicialmente nulo
		Registry reg = null;
		// Cria uma calculadora, inicialmente sem referência a um objeto.
		ICalculadora calc;		
		try {
			// Obtem o serviço de nomes em execução na porta especificada
			reg = LocateRegistry.getRegistry(1099);
		    // Faz um lookup buscando a referência do objeto pelo identificador "calculadora"
			calc = (ICalculadora) reg.lookup("calculadora");
			// Mostra no console o resultado do método multiplicação fazendo uma chamada remota na calculadora
			System.out.println(calc.multiplicacao(3,2));
		} catch (RemoteException | NotBoundException e) {
				System.out.println(e);
				System.exit(0);
		}
	}		

}
