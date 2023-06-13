package exercise3;

import java.io.BufferedReader;
import demotcpclientdate.ClientDateFrame;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author Siow Zhe Yi
 *
 */

public class ClientTextApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientDateFrame clientDateFrame = new ClientDateFrame();
		clientDateFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientDateFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the total number in the text
		String numberText = bufferedReader.readLine();
		System.out.println("Total number in the text: " + numberText);
		
		clientDateFrame.updateServerText(numberText);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
