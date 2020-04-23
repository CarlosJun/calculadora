import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {

	public static void main(String[] args) {
	
	// Define vari�vel String para armazenar o resultado
	String result="";
    try {
        // Cria um objeto URL com o endere�o do servidor
        URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
        // Cria uma URLConnection que representa uma conex�o com o objeto remoto, com endere�o defnido na url
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        // Configura o timeout de leitura em ms
        conn.setReadTimeout(10000);
        // Configura o timeout de conex�o em ms
        conn.setConnectTimeout(15000);
        // Configura o m�todo utilizado na requisi��o como POST
        conn.setRequestMethod("POST");
        // Configura o doinput como true para conex�o ser utilizada como entrada 
        conn.setDoInput(true);
        // Configura o dooutput como true para conex�o tamb�m ser utilizada como sa�da 
        conn.setDoOutput(true) ;

        //ENVIO DOS PARAMETROS
        // Cria um outputstream para a conex�o criada
        OutputStream os = conn.getOutputStream();
        // Cria um bufferWrite para facilitar a escrita no outputstream, utilizando o encoder UTF-8
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        // Escreve a requisi��o no bufferWrite, indicando os valores e a op��o da opera��o implemtnada no servidor
        writer.write("oper1=15&oper2=3&operacao=3"); //1-somar 2-subtrair 3-multiplicar 4-dividir
        // Envia a mensagem ao servidor
        writer.flush();
        // Fecha a stream
        writer.close();
        // Fecha o output stream
        os.close();
        
        // Cria uma vari�vel para armazenar o c�digo de resposta do servidor
		int responseCode=conn.getResponseCode();
		// Se a resposta for equivalente ao c�digo do HTTP_OK
		if (responseCode == HttpsURLConnection.HTTP_OK) {
		
		    //RECBIMENTO DOS PARAMETROS
		    // Cria um bufferReader para facilitar a leitura do inputstream, utilizando o encoder UTF-8
		    BufferedReader br = new BufferedReader(
		            new InputStreamReader(conn.getInputStream(), "utf-8"));
		    // Cria uma vari�vel StringBuilder vazia
		    StringBuilder response = new StringBuilder();
		    // Cria uma string para armazenar a leitura do inputstream 
		    String responseLine = null;
		    // Enquanto o intputstream tiver respostas diferentes de null
		    while ((responseLine = br.readLine()) != null) {
		    	// Anexa a mensagem lida na stream removendo os espa�os em branco
		        response.append(responseLine.trim());
		    }
		    // Retorna a string escrita na resposta
		    result = response.toString();
		    // Mostra no console a mensagem de resposta do servidor
		    System.out.println("Resposta do Servidor PHP="+result);
		    }
		    
		} catch (IOException e) {
		    e.printStackTrace();
    }
	}
}
