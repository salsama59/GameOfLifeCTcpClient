package com.internal.gameoflife.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class TCPClient {
	public static void main(String argv[]) throws Exception {
		while(true) {
			Socket clientSocket = new Socket("localhost", 4444);
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