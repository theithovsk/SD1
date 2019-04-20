package socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class Connection extends Thread {

	ObjectInputStream in;
	ObjectOutputStream out;
	Socket clientSocket;

	public Connection(Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;

			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());

			this.start();
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

	public void run() {
		try { // an echo server
			String data = in.readUTF();
			String response = "Mensagem " + data + " recebida com sucesso!";
			out.writeUTF(response);
			System.out.println(
					"IP Cliente:" + clientSocket.getInetAddress() + "Porta Cliente: " + clientSocket.getPort());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
			// write object
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				/* close failed */}
		}
	}
}