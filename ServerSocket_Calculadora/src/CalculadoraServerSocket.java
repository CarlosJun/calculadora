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
		// Defini��o da vari�vel socket para armazenar a classe socket do servidor	
		ServerSocket welcomeSocket;
		// Defini��o da vari�vel output stream para armazenar os valores que ser�o escritos e enviados ao cliente
		DataOutputStream socketOutput;     	
		// Defini��o da vari�vel inputstream para armazenar os valores que ser�o recebidos no servidor
	    DataInputStream socketInput;
	    // Defini��o de uma vari�vel BuffReader para facilitar manipula��o de textos
	    BufferedReader socketEntrada;
	    // Cria um novo objeto calculadora
	    Calculadora calc = new Calculadora();
		try {
			// Cria um socket servidor na porta especificada
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //n�mero de clientes
	      // Mostra uma mensagem de servidor online
	      System.out.println ("Servidor no ar");
	      while(true) { 
	    	   // Fica aguardando uma conex�o no socket e a aceita
	           Socket connectionSocket = welcomeSocket.accept();
	           // Incrementa um no n�mero de clientes
	           i++;
	           // Mostra uma mensagem de nova conex�o
	           System.out.println ("Nova conex�o");
	           
	           //Interpretando dados do servidor
	           // Cria um inputstream recebendo a resposta do cliente a partir do socket criado
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	           // L� uma linha de texto presente no BufferedReader
               String operacao= socketEntrada.readLine();
               // L� a pr�xima linha de texto presente no BufferedReader
               String oper1=socketEntrada.readLine();
               // L� a pr�xima linha de texto presente no BufferedReader
               String oper2=socketEntrada.readLine();
               // Cria um vari�vel String para armazenar o resultado da calculadora
               String result;

               // Verifica qual a opera��o requisitada pelo o cliente
               if(operacao.equals("1")) {
            	   // Chamando a opera��o de soma na calculadora
            	   result = ""+calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
               } else if(operacao.equals("2")){
            	   // Chamando a opera��o de subtra��o na calculadora
            	   result = ""+calc.subtracao(Double.parseDouble(oper1),Double.parseDouble(oper2));
               } else if(operacao.equals("3")) {
            	   // Chamando a opera��o de divis�o na calculadora
            	   result = ""+calc.divisao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                } else if(operacao.equals("4")) {
                	// Chamando a opera��o de multiplica��o na calculadora
                	result = ""+calc.multiplicacao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                } else {
                	// Caso n�o seja uma op��o v�lida, coloca uma mensagem de opera��o inv�lida no resultado
                	result = "opera��o inv�lida!";
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
