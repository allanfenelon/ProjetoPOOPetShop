package br.com.petshop.Repositorios;

import br.com.petshop.Negocio.Administrador;

public interface RepoInterfaceAdm {
	Administrador getAdministradores(String cpf);
	void setAdministradores(Administrador administrador);
	void excluirAdm(String cpf);
	boolean existeAdm(String cpf);
	boolean estaVazio();
	void listarAdm();
	
}
