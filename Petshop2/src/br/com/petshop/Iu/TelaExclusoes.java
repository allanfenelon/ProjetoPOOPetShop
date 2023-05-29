package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Negocio.Petshop;

public class TelaExclusoes {
	private Petshop fachada;
	private Scanner ler;
	
	public TelaExclusoes(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
	}
	
	public void excluirCliente() {
		System.out.print("DIGITE O CPF DO CLIENTE QUE QUER EXCLUIR: ");
		String cpf = ler.next();
		try {
			fachada.excluirCliente(cpf);
			System.out.println(">>>>> CLIENTE EXCLUIDO COM SUCESSO! <<<<<");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO ENCONTRAMOS USUARIO COM ESSE CPF! OPRECAO NAO FEITA!");
		}
	}
	
	public void excluirAdm() {
		System.out.print("DIGITE O CPF DO ADM QUE QUER EXCLUIR: ");
		String cpf = ler.next();
		try {
			fachada.excluirAmd(cpf);
			System.out.println(">>>>> ADM EXCLUIDO COM SUCESSO! <<<<<");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO ENCONTRAMOS USUARIO COM ESSE CPF! OPRECAO NAO FEITA!");
		}
	}
	
	public void excluirVendedor() {
		System.out.print("DIGITE O CPF DO VENDEDOR QUE QUER EXCLUIR: ");
		String cpf = ler.next();
		try {
			fachada.excluirVendedor(cpf);
			System.out.println(">>>>> VENDEDOR EXCLUIDO COM SUCESSO! <<<<<");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO ENCONTRAMOS USUARIO COM ESSE CPF! OPRECAO NAO FEITA!");
		}
	}
	
	public void excluirVeterinario() {
		System.out.print("DIGITE O CPF DO VETERINARIO QUE QUER EXCLUIR: ");
		String cpf = ler.next();
		try {
			fachada.excluirVeterinario(cpf);
			System.out.println(">>>>> VETERINARIO EXCLUIDO COM SUCESSO! <<<<<");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO ENCONTRAMOS USUARIO COM ESSE CPF! OPRECAO NAO FEITA!");
		}
	}

}
