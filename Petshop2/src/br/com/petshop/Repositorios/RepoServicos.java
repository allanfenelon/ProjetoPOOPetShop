package br.com.petshop.Repositorios;

import java.util.ArrayList;
import br.com.petshop.Classes.Servicos;

public class RepoServicos {
	private ArrayList<Servicos> servicos;
	
	public RepoServicos() {
		this.servicos = new ArrayList<Servicos>();
	}
	
	public void setServicos(Servicos servico) {
		this.servicos.add(servico);
	}
	
	public Servicos getServicos(String nome){
		int indice;
		indice = indiceBusca(nome);
		if(indice>=0) {
			return servicos.get(indice);
		}
		return null;
	}
	
	public void listarServicos() {
		for(Servicos aux : servicos) {
			System.out.println(aux.toString());
		}
	}
	
	private int indiceBusca(String nome) {
		int indice = -1;
		for(int j = 0; j<servicos.size(); j++) {
			if(servicos.get(j).getNomeServico().equals(nome)) {
				indice = j;
				break;
			}
		}
		return indice;
	}
	
	
	public void modificarServico(String nome, Servicos newServico) {
		int indice;
		indice = indiceBusca(nome);
		if(indice>=0) {
			this.servicos.set(indice, newServico);
		}else {
			System.out.println("Não foi possivel remover!");
		}
	}
	
	public void modificarPrecoServico(String nome, double valor) {
		int indice;
		indice = indiceBusca(nome);
		if(indice>=0) {
			this.servicos.get(indice).setPreco(indice);
		}
	}
	
	
	public void excluirServico(String nome) {
		if(!estaVazio()) {
			int indice;
			indice = indiceBusca(nome);
			if(existeServico(nome)) {
				servicos.remove(indice);
				System.out.println("REMOVIDO COM SUCESSO!");
			}
			System.out.println("ERRO!");
		}
		System.out.println("NAO HA NADA PARA EXCLUIR!");
		
	}
	
	public boolean existeServico(String nome) {
		int i;
		i = indiceBusca(nome);
		if(i>=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaVazio() {
		if(servicos.size() == 0) {
			return true;
		}
		return false;
	}
	
}
