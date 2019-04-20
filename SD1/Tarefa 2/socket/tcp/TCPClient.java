package socket.tcp;

import java.net.*;
import java.io.*;
import java.math.BigDecimal;

public class TCPClient {
	public static void main(String args[]) {
		// arguments supply message and hostname of destination
		Socket s = null;
		BigDecimal a = new BigDecimal("0.3");
		BigDecimal b = new BigDecimal("0.2");
		BigDecimal soma = a.add(b);
		BigDecimal sub = a.subtract(b);
		BigDecimal multi = a.multiply(b);
		BigDecimal div = a.divide(b);
		
		
		Operacoes op;
		Mensagem mensagem = new Mensagem();
		
		op = Operacoes.SOMA;
		mensagem.setTipoOperacao(op);

		op = Operacoes.SUBTRACAO;
		mensagem.setTipoOperacao(op);
		
		op = Operacoes.MULTIPLICACAO;
		mensagem.setTipoOperacao(op);
		
		op = Operacoes.DIVISAO;
		mensagem.setTipoOperacao(op);

		try {
			int serverPort = new Integer(args[2]);
			s = new Socket(args[1], serverPort);
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			out.writeUTF(args[0]);
			String data = in.readUTF();
			System.out.println("Received: " + data);
		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
		}
	}
}