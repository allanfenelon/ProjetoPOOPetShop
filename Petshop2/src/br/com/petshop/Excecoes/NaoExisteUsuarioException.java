package br.com.petshop.Excecoes;

public class NaoExisteUsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6502249131735293268L;
	
	public NaoExisteUsuarioException() {
		System.out.println("USUARIO NAO ESTÁ NO SISTEMA!");
	}
	


}
