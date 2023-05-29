package br.com.petshop.Excecoes;

public class PetSemDiagnosticoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 269361251184935024L;
	
	public PetSemDiagnosticoException() {
		System.out.println("O PET NAO POSSUI OBSERVACAO!");
	}

}
