package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteServicoException;
import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Negocio.Petshop;


public class TelaRealizarServicos {

	
	private Petshop fachada;
	private Scanner ler;

	
	public TelaRealizarServicos(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
	}
	
	public void realizarServico() {
		System.out.print("DIGITE O CPF DO CLIENTE: ");
		String cpf = ler.next();
		System.out.print("NOME DO SERVICO PARA REALIZAR: ");
		String nome = ler.next();
		try {
			fachada.realizarServico(cpf, nome);
		}catch(NaoExisteServicoException e1) {
			System.out.println("SERVICO NAO ENCONTRADO!");
		}catch(NaoExisteUsuarioException e2) {
			System.out.println("NAO EXISTE CLIENTE COM ESSE CPF!");
		}
		
		
	}
}
