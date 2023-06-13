package exercise6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * This method manage the connection to the server.
 * 
 * @author Siow Zhe Yi
 *
 */
public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException{
		
		// Connect to the server @localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(),1234);
		
		// read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// display the translated text
		String translatedText = bufferedReader.readLine();
		System.out.println("here is from client: " + translatedText);
		
		// close everything 
		bufferedReader.close();
		socket.close();		
	}
}
