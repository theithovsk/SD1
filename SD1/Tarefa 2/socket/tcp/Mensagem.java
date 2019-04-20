package socket.tcp;

import java.io.Serializable;
import java.util.ArrayList;

public class Mensagem implements Serializable {
	private Operacoes tipoOperacao;

	private ArrayList<Object> lista = new ArrayList<Object>();

	public Operacoes getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(Operacoes tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public ArrayList<Object> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Object> lista) {
		this.lista = lista;
	}
	
	

}
