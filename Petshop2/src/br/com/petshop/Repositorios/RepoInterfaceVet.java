package br.com.petshop.Repositorios;

import br.com.petshop.Negocio.Veterinario;

public interface RepoInterfaceVet {

	Veterinario getVet(String cpf);
	void setVet(Veterinario vet);
	void modificarVet(String cpf, Veterinario newVet);
	void excluirVet(String cpf);
	boolean existeVet(String cpf);
	boolean estaVazio();
	void listarVeterinario();
}
