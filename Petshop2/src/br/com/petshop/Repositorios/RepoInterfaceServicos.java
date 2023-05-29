package br.com.petshop.Repositorios;

import br.com.petshop.Negocio.Servicos;

public interface RepoInterfaceServicos {
	
	void setServicos(Servicos servico);
	Servicos getServicos(String nome);
	void listarServicos();
	void modificarServico(String nome, Servicos newServico);
	void modificarPrecoServico(String nome, double valor);
	void excluirServico(String nome);
	boolean existeServico(String nome);
	boolean estaVazio();

}
