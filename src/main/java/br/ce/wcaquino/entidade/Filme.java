package br.ce.wcaquino.entidade;

public class Filme {

	private int estoque;	
	private int aluguel;

	public void setEstoque(int quantidade) {
		this.estoque = quantidade;		
	}
	
	public int getEstoque() {
		return estoque;
	}

	public void setAluguel(int valor) {
		this.aluguel = valor;		
	}
	
	public int getAluguel() {
		return aluguel;
	}
	
	public void decrementarEstoque(int quantidade) {
		this.estoque = this.estoque - quantidade;
	}
}
