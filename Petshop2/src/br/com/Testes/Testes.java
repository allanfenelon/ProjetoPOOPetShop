package br.com.Testes;

import br.com.petshop.Classes.Administrador;
import br.com.petshop.Classes.Petshop;
import br.com.petshop.Classes.Vendedor;
import br.com.petshop.Classes.Veterinario;
import br.com.petshop.Repositorios.RepoAdministrador;
import br.com.petshop.Repositorios.RepoCliente;
import br.com.petshop.Repositorios.RepoServicos;
import br.com.petshop.Repositorios.RepoVendedor;
import br.com.petshop.Repositorios.RepoVeterinarios;



public class Testes {

	public static void main(String[] args) {
		RepoCliente repoCli = new RepoCliente();
		RepoServicos repoServico= new RepoServicos();
		Petshop petshop = new Petshop();
		RepoVeterinarios repoVet = new RepoVeterinarios();
		RepoAdministrador repoAdm = new RepoAdministrador();
		RepoVendedor repoVend = new RepoVendedor();
		
		/* USUARIOS PARA O BACKLOG */
		Administrador auxAdm = new Administrador("Carlos", "123456789-00", "123");
		repoAdm.setAdministradores(auxAdm);
		Vendedor auxvend = new Vendedor("Ana", "456789123-02", "456");
		repoVend.setVendedores(auxvend);
		Veterinario auxVet = new Veterinario("Beatriz", "147852369-32", 50.32, "789");
		repoVet.setVet(auxVet);
		/* -------------------- */
		
		
		System.out.println("Adicione um cliente: ");
		petshop.addCliente(repoCli);
		System.out.println("Adicione um adm: ");
		petshop.addAdm(repoAdm);
		System.out.println("Adicione um Vendedor: ");
		petshop.addVendedor(repoVend);
		System.out.println("Adicone um servico: ");
		petshop.addServico(repoServico);
		System.out.println("listando clientes: ");
		petshop.listarClientes(repoCli);
		System.out.println("Listando adms:");
		petshop.listarAdm(repoAdm);
		System.out.println("Listando vendedores:");
		petshop.listarVendedor(repoVend);
		System.out.println("Listando Servicos:");
		petshop.listarServico(repoServico);

	}

}
