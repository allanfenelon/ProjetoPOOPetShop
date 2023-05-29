package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Negocio.Petshop;

public class TelaAdm {

	private Petshop fachada;
	private Scanner ler;
	private TelaVendedor vendedor;
	private TelaExclusoes exclusoes;
	private TelaCadastros cadastros;
	private TelaListagens listagens;
	
	public TelaAdm(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
		this.vendedor = new TelaVendedor(this.fachada);
		this.exclusoes = new TelaExclusoes(this.fachada);
		this.cadastros = new TelaCadastros(this.fachada);
		this.listagens = new TelaListagens(this.fachada);
	}
	
	
	public void iniciar() {
		boolean repeticao = true;
		while(repeticao) {
			System.out.println(">>>>> TELA ADM <<<<<");
			System.out.println("(1) - TELA DE VENDAS");
			System.out.println("(2) -  TELA DE GERENCIA");
			System.out.println("(3) - SAIR");
			int opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				this.vendedor.iniciar();
				break;
			case 2:
				boolean rep = true;
				while(rep) {
					System.out.println(">>>>> GERENCIA(ADM) <<<<<");
					System.out.println("(1) - EXCLUIR CLIENTE");
					System.out.println("(2) - EXCLUIR VENDEDOR");
					System.out.println("(3) - EXCLUIR VETERINARIO");
					System.out.println("(4) - ADICIONAR VENDEDOR");
					System.out.println("(5) - ADICIONAR VETERINARIO");
					System.out.println("(6) - ADICIONAR ADM");
					System.out.println("(7) - LISTAR ADMS");
					System.out.println("(8) - REMOVER ADM");
					System.out.println("(9) -  SAIR");
					int op = ler.nextInt();
					switch (op) {
					case 1:
						this.exclusoes.excluirCliente();
						break;
					case 2:
						this.exclusoes.excluirVendedor();
						break;
					case 3:
						this.exclusoes.excluirVeterinario();
						break;
					case 4:
						this.cadastros.cadastrarVendedor();
						break;
					case 5:
						this.cadastros.cadastrarVeterinario();
						break;
					case 6:
						this.cadastros.cadastrarAdm();
						break;
					case 7:
						this.listagens.listarAdms();
						break;
					case 8:
						this.exclusoes.excluirAdm();
						break;
					case 9:
						this.fachada.setSecaoAtiva(false);
						rep = false;
						break;
					default:
						System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE!");
						break;
					}
				}
				break;
			case 3:
				repeticao = false;
				break;
			default:
				System.out.println("OPCAO INVALIDA! TENETE NOVAMENTE!");
				break;
			}
		}
	}
}
