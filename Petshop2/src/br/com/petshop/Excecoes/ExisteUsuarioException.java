package br.com.petshop.Excecoes;

public class ExisteUsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -413854923361949645L;
	
	public ExisteUsuarioException() {
		System.out.println("USUARIO JA EXISTE NO NOSSO SISTEMA!");
	}

}
