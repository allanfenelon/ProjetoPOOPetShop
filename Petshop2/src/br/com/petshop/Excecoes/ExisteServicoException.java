package br.com.petshop.Excecoes;

public class ExisteServicoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096226643475102871L;

	public ExisteServicoException() {
		System.out.println("JA EXISTE SERVICO COM ESSE NOME!");
	}
}
