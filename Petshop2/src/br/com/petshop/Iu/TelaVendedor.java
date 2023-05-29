package br.com.petshop.Iu;

import java.util.Scanner;
import br.com.petshop.Negocio.Petshop;

public class TelaVendedor {
	private Petshop fachada;
	private Scanner ler;
	private TelaCadastros cadastro;
	private TelaListagens listagem;
	private TelaRealizarServicos realizarServ;
	private TelaCliente opcoesCli;
	
	public TelaVendedor(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
		this.cadastro = new TelaCadastros(this.fachada);
		this.listagem = new TelaListagens(this.fachada);
		this.realizarServ = new TelaRealizarServicos(this.fachada);
		this.opcoesCli = new TelaCliente(this.fachada);
	}
	
	public void iniciar() {
		boolean repeticao = true;
		while(repeticao) {
			System.out.println(">>>>> TELA VENDEDOR <<<<<");
			System.out.println("(1) - ADICIONAR CLIENTE");
			System.out.println("(2) - ADICIONAR SERVICOS");
			System.out.println("(3) - LISTAR CLIENTES");
			System.out.println("(4) - LISTAR SERVICOS");
			System.out.println("(5) - REALIZAR SERVICO/VENDER");
			System.out.println("(6) - CONSULTAR DIVIDA DO CLIENTE");
			System.out.println("(7) - PAGAMENTO DE DIVIDA DO CLIENTE");
			System.out.println("(8) - SAIR");
			
			int opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				cadastro.cadastrarCliente();
				break;
			case 2:
				cadastro.cadastrarServicos();
				break;
			case 3:
				listagem.listarClientes();
				break;
			case 4:
				listagem.listarServicos();
				break;
			case 5:
				realizarServ.realizarServico();
				break;
			case 6:
				listagem.listarDividaCiente();
				break;
			case 7:
				opcoesCli.gerarPagemento();
				break;
			case 8:
				this.fachada.setSecaoAtiva(false);
				repeticao = false;
				break;
			default:
				System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE!");
				break;
			}
		}
	}
}
