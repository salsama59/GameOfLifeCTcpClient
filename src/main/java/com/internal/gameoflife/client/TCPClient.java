package com.internal.gameoflife.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * This class represent the tcp client.
 * It purpose is to read from the socket input stream in order to display the simulation data.
 * @author syeponde
 */
public class TCPClient {
	public static void main(String argv[]) throws Exception {
		while(true) {
			try (Socket clientSocket = new Socket("localhost", 4444)) {
				if(!clientSocket.isInputShutdown()) {
					InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String serverMessage = null;
					while((serverMessage = bufferedReader.readLine()) != null) {
						System.out.println(serverMessage);
					}
				}
			}
		}
	}
}