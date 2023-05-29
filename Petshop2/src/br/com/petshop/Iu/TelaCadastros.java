package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.ExisteServicoException;
import br.com.petshop.Excecoes.ExisteUsuarioException;
import br.com.petshop.Excecoes.ValorInvalidoException;
import br.com.petshop.Negocio.Administrador;
import br.com.petshop.Negocio.Cliente;
import br.com.petshop.Negocio.Pet;
import br.com.petshop.Negocio.Petshop;
import br.com.petshop.Negocio.Servicos;
import br.com.petshop.Negocio.Vendedor;
import br.com.petshop.Negocio.Veterinario;

public class TelaCadastros {
	
	private Petshop fachada;
	private Scanner ler;
	
	public TelaCadastros(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
	}
	
	public void cadastrarCliente() {
		System.out.print("NOME DO CLIENTE: ");
		String nomeCliente = ler.next();
		System.out.print("CPF DO CLIENTE: ");
		String cpfCliente = ler.next();
		System.out.print("TELEFONE DO CLIENTE: ");
		String telefone = ler.next();
		System.out.print("NOME DO PET: ");
		String nomePet = ler.next();
		Pet auxPet;
		while(true) {
			System.out.println("TIPO DE PET: (1) - CACHORRO (2) - GATO");
			int tipoPet = ler.nextInt();
			if(tipoPet==1) {
				auxPet = new Pet(nomePet, "CACHORRO");
				break;
			}else if(tipoPet == 2) {
				auxPet = new Pet(nomePet, "GATO");
				break;
			}else {
				System.out.println("VALOR INVALIDO! TENTE NOVAMENTE");
			}
		}
		Cliente auxCli = new Cliente(nomeCliente, cpfCliente, auxPet,telefone);
		try {
			fachada.adicionarCliente(auxCli);
			System.out.println(">>>>> CLIENTE ADICIONADO COM SUCESSO! <<<<<");
		}catch(ExisteUsuarioException e){
			System.out.println("USUARIO JA EXISTENTE!");
		}
	}
	
	public void cadastrarServicos() {
		while(true) {
			System.out.print("NOME DO SERVICO: ");
			String nome = ler.next();
			System.out.println("VALOR DO SERVICO: (USE XX,XX) ");
			double valor = ler.nextDouble();
			Servicos auxServ = new Servicos(nome, valor);
			try {
				fachada.adicionarServico(auxServ);
				System.out.println(">>>>> SERVICO ADICIONADO COM SUCESSO! <<<<<");
				break;
			}catch(ExisteServicoException e) {
				System.out.println("JA EXISTE ESSE SERVICO!");
				break;
			}catch(ValorInvalidoException e2) {
				System.out.println("VALOR INVALIDO, TENTE NOVAMENTE!");
			}
		}
	}
	
	public void cadastrarVendedor() {
		System.out.print("NOME VENDEDOR: ");
		String nome = ler.next();
		System.out.println("CPF VENDEDOR: ");
		String cpf = ler.next();
		System.out.println("SENHA: ");
		String senha = ler.next();
		Vendedor aux = new Vendedor(nome, cpf, senha);
		try {
			fachada.adicionarVendedor(aux);
			System.out.println(">>>>> VENDEDOR CADASTRADO COM SUCESSO! <<<<<");
		}catch(ExisteUsuarioException e) {
			System.out.println("ESSE VENDEDOR JA ESTA NO SISTEMA!");
		}
	}
	
	public void cadastrarVeterinario() {
		System.out.print("NOME VENDEDOR: ");
		String nome = ler.next();
		System.out.println("CPF VENDEDOR: ");
		String cpf = ler.next();
		System.out.println("SENHA: ");
		String senha = ler.next();
		Veterinario aux = new Veterinario(nome, cpf, 0.0, senha);
		try {
			fachada.adicionarVeterinario(aux);
			System.out.println(">>>>> VETERINARIO CADASTRADO COM SUCESSO! <<<<<");
		}catch(ExisteUsuarioException e) {
			System.out.println("VETERINARIO JA ESTA NO SISTEMA!");
		}
	}
	
	public void cadastrarAdm() {
		System.out.print("NOME ADM: ");
		String nome = ler.next();
		System.out.println("CPF ADM: ");
		String cpf = ler.next();
		System.out.println("SENHA: ");
		String senha = ler.next();
		Administrador aux = new Administrador(nome, cpf, senha);
		try {
			this.fachada.adicionarAdm(aux);
			System.out.println("ADMINISTRADOR ADICIONADO COM SUCESSO!");
		} catch (ExisteUsuarioException e) {
			System.out.println("ADMINISTRADOR JA EXISTE!");
		}
	}

}
