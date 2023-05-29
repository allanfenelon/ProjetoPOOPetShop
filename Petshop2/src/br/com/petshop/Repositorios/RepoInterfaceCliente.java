package br.com.petshop.Repositorios;


import br.com.petshop.Negocio.Cliente;

public interface RepoInterfaceCliente {
	
	void setClientes(Cliente cliente);
	Cliente getCliente(String cpf);
	void modificarCliente(String cpf, Cliente newCliente);
	void excluirCliente(String cpf);
	void listarCLiente();
	boolean repoVazio();
	boolean existeCliente(String cpf);
}
