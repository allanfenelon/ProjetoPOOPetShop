package br.com.petshop.Excecoes;

public class SenhaIncorretaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -692066106300794074L;
	
	public SenhaIncorretaException() {
		System.out.println("SENHA INCORRETA!");
	}

}
