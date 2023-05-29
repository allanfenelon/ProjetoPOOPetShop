package br.com.petshop.Excecoes;

public class NaoExisteServicoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7847042967927421459L;
	
	public NaoExisteServicoException() {
		System.out.println("NAO EXISTE SERVICO!");
	}

}
