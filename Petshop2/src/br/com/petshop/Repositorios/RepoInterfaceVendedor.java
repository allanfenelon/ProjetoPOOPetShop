package br.com.petshop.Repositorios;

import br.com.petshop.Negocio.Vendedor;

public interface RepoInterfaceVendedor {

	Vendedor getVendedores(String cpf);
	void setVendedores(Vendedor vendedore);
	boolean existeVendedor(String cpf);
	boolean estaVazio();
	void listarVendedores();
	void excluirVendedor(String cpf);
}
