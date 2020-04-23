import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Definição da variável socket para armazenar a classe socket do servidor	
		ServerSocket welcomeSocket;
		// Definição da variável output stream para armazenar os valores que serão escritos e enviados ao cliente
		DataOutputStream socketOutput;     	
		// Definição da variável inputstream para armazenar os valores que serão recebidos no servidor
	    DataInputStream socketInput;
	    // Definição de uma variável BuffReader para facilitar manipulação de textos
	    BufferedReader socketEntrada;
	    // Cria um novo objeto calculadora
	    Calculadora calc = new Calculadora();
		try {
			// Cria um socket servidor na porta especificada
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //número de clientes
	      // Mostra uma mensagem de servidor online
	      System.out.println ("Servidor no ar");
	      while(true) { 
	    	   // Fica aguardando uma conexão no socket e a aceita
	           Socket connectionSocket = welcomeSocket.accept();
	           // Incrementa um no número de clientes
	           i++;
	           // Mostra uma mensagem de nova conexão
	           System.out.println ("Nova conexão");
	           
	           //Interpretando dados do servidor
	           // Cria um inputstream recebendo a resposta do cliente a partir do socket criado
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	           // Lê uma linha de texto presente no BufferedReader
               String operacao= socketEntrada.readLine();
               // Lê a próxima linha de texto presente no BufferedReader
               String oper1=socketEntrada.readLine();
               // Lê a próxima linha de texto presente no BufferedReader
               String oper2=socketEntrada.readLine();
               // Cria um variável String para armazenar o resultado da calculadora
               String result;

               // Verifica qual a operação requisitada pelo o cliente
               if(operacao.equals("1")) {
            	   // Chamando a operação de soma na calculadora
            	   result = ""+calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
               } else if(operacao.equals("2")){
            	   // Chamando a operação de subtração na calculadora
            	   result = ""+calc.subtracao(Double.parseDouble(oper1),Double.parseDouble(oper2));
               } else if(operacao.equals("3")) {
            	   // Chamando a operação de divisão na calculadora
            	   result = ""+calc.divisao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                } else if(operacao.equals("4")) {
                	// Chamando a operação de multiplicação na calculadora
                	result = ""+calc.multiplicacao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                } else {
                	// Caso não seja uma opção válida, coloca uma mensagem de operação inválida no resultado
                	result = "operação inválida!";
                }
               
               // Enviando dados para o servidor
               // Cria um outputstream a partir do socket criado para poder enviar dados ao cliente
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
               // Escreve o resultado no outputstream
	           socketOutput.writeBytes(result+ '\n');
	           // Mostra o resultado no console
	           System.out.println(result);	    
	           // Envia os dados escritos no outputstream para o cliente
	           socketOutput.flush();
	           // Fecha a stream
	           socketOutput.close();

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}
