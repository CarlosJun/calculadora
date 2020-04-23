import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CalculadoraClientSocket {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// Defini��o dos valores utilizados na opera��o
		double oper1=40,oper2=4;
		// Op��o que definir� qual opera��o ser� utilizada
		int operacao=3; //1-somar 2-subtrair 3-dividir 4-multiplicar
		// String para armazenar o resultado
		String result="";
        try {

        	// Conex�o com o Servidor
        	// Cria��o do socket para comunica��o com servidor atribuindo ip e n�mero de porta
            Socket clientSocket = new Socket("192.168.15.200", 9090);
            // Cria um output stream a partir do socket criado para poder enviar dados ao servidor
            DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            
            //Enviando os dados
            // Escreve a op��o da opera��o requerida no output stream
            socketSaidaServer.writeBytes(operacao+"\n");
            // Escreve o primeiro valor da opera��o no output stream
            socketSaidaServer.writeBytes(oper1+ "\n");
            // Escreve o segundo valor da opera��o no outputstream
            socketSaidaServer.writeBytes( oper2+ "\n");
            // Envia os dados escritos no outputstream para o servidor
            socketSaidaServer.flush();

            //Recebendo a resposta
            // Cria um inputstream recebendo a resposta do servidor a partir do socket criado
            BufferedReader messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            // L� o resultado da opera��o enviada pelo o servidor
            result=messageFromServer.readLine();
            // Mostra o resultado no console
            System.out.println("resultado="+result);
            // Fecha o socket
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


	}

}
