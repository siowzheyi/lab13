package exercise7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import DemoCpServerDate.ServerDateFrame;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * This class launch the server side application using TCP.
 * The server count translate a given string into another language
 * Each connected client will received the translated text from the server.
 * Result will be displayed at GUI
 * 
 * @author Siow Zhe Yi
 *
 */

public class TCPServer {
	
	/*
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		

		// Launch the server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other
		int portNo = 1234;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		// declaration of text translation class object
		TextTranslation texttranslation = new TextTranslation();
		
		// counter to keep track the number of requested connection
		int totalRequest = 0;

		System.out.println("Waiting for connection...");
		// server need to be alive 
		while(true) {

			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// accept client request for connection
			Socket clientSocket = serverSocket.accept();

			// get translated text
			String translatedText = texttranslation.chooseString();
			
			// create stream to write data on network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// send current data to the client
			outputStream.writeBytes(translatedText);
			
			// flush the output stream
			outputStream.flush();
			
			// close the socket
			clientSocket.close();
			

			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + translatedText);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
	}
}
