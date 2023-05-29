package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Excecoes.SenhaIncorretaException;
import br.com.petshop.Negocio.Petshop;

public class TelaPrincipal {
	private Petshop fachada;
	private Scanner ler;
	private TelaVendedor vendedor;
	private TelaVeterinario veterinario;
	private TelaAdm adm;
	
	public TelaPrincipal(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
		this.vendedor = new TelaVendedor(this.fachada);
		this.veterinario = new TelaVeterinario(this.fachada);
		this.adm = new TelaAdm(this.fachada);
	}
	
	public void iniciar() {
		while(true) {
			System.out.println(">>>> LOGIN <<<<");
			System.out.println("(1) - LOGIN VENDEDOR");
			System.out.println("(2) - LOGIN VETERINARIO");
			System.out.println("(3) - LOGIN ADMINISTRADOR");
			System.out.println("(4) - SAIR");
			int opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.println(">>>>> LOGIN VENDEDOR <<<<<");
				System.out.print("CPF: ");
				String cpf = ler.next();
				System.out.print("SENHA: ");
				String senha = ler.next();
				try {
					if(fachada.loginVendedor(cpf, senha)&&fachada.getSecaoAtiva()) {
						this.vendedor.iniciar();
					}
					
				}catch(SenhaIncorretaException e1) {
					System.out.println("SENHA INCORRETA!");
				}catch(NaoExisteUsuarioException e2) {
					System.out.println("USUARIO NAO EXISTE!");
				}
				break;
			case 2:
				System.out.println(">>>>> LOGIN VETERINARIO <<<<<");
				System.out.print("CPF: ");
				String cpf1 = ler.next();
				System.out.print("SENHA: ");
				String senha1 = ler.next();
				try {
					if(fachada.loginVeterinario(cpf1, senha1)&&fachada.getSecaoAtiva()) {
						this.veterinario.iniciar();
					}
				}catch(SenhaIncorretaException e1) {
					System.out.println("SENHA INCORRETA!");
				}catch(NaoExisteUsuarioException e2) {
					System.out.println("USUARIO NAO EXISTE!");
				}
				break;
			case 3:
				System.out.println(">>>>> LOGIN ADMINISTRADOR <<<<<");
				System.out.print("CPF: ");
				String cpf11 = ler.next();
				System.out.print("SENHA: ");
				String senha11 = ler.next();
				try {
					if(fachada.loginAdm(cpf11, senha11)&&fachada.getSecaoAtiva()) {
						this.adm.iniciar();
					}
				}catch(SenhaIncorretaException e1) {
					System.out.println("SENHA INCORRETA!");
				}catch(NaoExisteUsuarioException e2) {
					System.out.println("USUARIO NAO EXISTE!");
				}
				break;
			case 4:
				System.out.println("SAINDO...");
				System.exit(0);
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
		}
	}
}
