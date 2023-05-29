package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Excecoes.ValorInvalidoException;
import br.com.petshop.Negocio.Petshop;

public class TelaCliente {
	private Petshop fachada;
	private Scanner ler;
	
	public TelaCliente (Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
	}
	
	public void gerarPagemento() {
		System.out.print("DIGITE O CPF DO CLIENTE: ");
		String cpf = ler.next();
		System.out.print("DIGITE O CALOR A DESCONTAR DA DIVIDA DO CLIENTE: (XX,XX)");
		double valor = ler.nextDouble();
		try {
			fachada.fazerPagamentoCliente(cpf, valor);
			System.out.println(">>>>> PAGAMENTO REALIZADO COM SUCESSO! <<<<<");
		}catch(NaoExisteUsuarioException e1) {
			System.out.println("CLIENTE NAO ENCONTRADO!");
		}catch(ValorInvalidoException e2) {
			System.out.println("VALOR INVALIDO!");
		}
	}
}
