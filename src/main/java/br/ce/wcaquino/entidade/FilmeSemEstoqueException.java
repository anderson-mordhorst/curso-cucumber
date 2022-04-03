package br.ce.wcaquino.entidade;

public class FilmeSemEstoqueException extends Exception {

	private static final long serialVersionUID = -992432350908338914L;

	public FilmeSemEstoqueException() {
		super("Filme sem estoque.");
	}
}
