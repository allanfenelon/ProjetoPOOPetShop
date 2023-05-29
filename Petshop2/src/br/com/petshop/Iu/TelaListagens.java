package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteServicoException;
import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Excecoes.PetSemDiagnosticoException;
import br.com.petshop.Negocio.Petshop;
import br.com.petshop.Repositorios.RepoAdministrador;
import br.com.petshop.Repositorios.RepoCliente;
import br.com.petshop.Repositorios.RepoServicos;

public class TelaListagens {

	private Petshop fachada;
	private Scanner ler;
	
	public TelaListagens(Petshop fachada) {
		this.ler = new Scanner(System.in);
		this.fachada = fachada;
	}
	
	public void listarClientes() {
		try {
			RepoCliente aux= fachada.retornarClientes();
			System.out.println("+-----------------------+");
			aux.listarCLiente();
			System.out.println("+-----------------------+");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("+----- VAZIO -----+");
		}
	}
	public void listarAdms() {
		try {
			RepoAdministrador aux = fachada.retornarAdms();
			System.out.println("+-----------------------+");
			aux.listarAdm();
			System.out.println("+-----------------------+");
		}catch(NaoExisteUsuarioException e) {
			System.out.println("+----- VAZIO -----+");
		}
	}
	
	public void listarServicos() {
		try {
			RepoServicos aux = fachada.retornarServicos();
			System.out.println("+-----------------------+");
			aux.listarServicos();
			System.out.println("+-----------------------+");
		}catch(NaoExisteServicoException e) {
			System.out.println("+----- VAZIO -----+");
		}
	}
	
	public void listarDividaCiente() {
		System.out.print("CPF DO CLIENTE: ");
		String cpf = ler.next();
		try {
			System.out.println("O SALDO DEVEDOR EH: " + fachada.retornarDividaCliente(cpf));
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO FOI POSSIVEL ENCONTRAR USUARIO COM ESSE CPF!");
		}
	}
	
	public void listarDiagnosticoPet() {
		System.out.print("CPF DO CLIENTE: ");
		String cpf = ler.next();
		try {
			System.out.println("DIAGNOSTICO: " + fachada.retornarDiagnosticoPet(cpf));
		}catch(NaoExisteUsuarioException e) {
			System.out.println("NAO ENCONTRAMOS USUARIO COM ESSE CPF!");
		}catch(PetSemDiagnosticoException e2) {
			System.out.println("O PET NAO FOI DIAGNOSTICADO AINDA!");
		}
	}
}
