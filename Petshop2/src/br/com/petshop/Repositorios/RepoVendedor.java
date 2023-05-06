package br.com.petshop.Repositorios;

import java.util.ArrayList;
import br.com.petshop.Classes.Vendedor;

public class RepoVendedor {
	private ArrayList<Vendedor> vendedores;
	
	public RepoVendedor() {
		this.vendedores = new ArrayList<Vendedor>();
	}

	public Vendedor getVendedores(String cpf) {
		int indice = indiceBusca(cpf);
		if(indice>=0) {
			return vendedores.get(indice);
		}
		return null;
	}

	public void setVendedores(Vendedor vendedore) {
		this.vendedores.add(vendedore);
	}
	
	private int indiceBusca(String cpf) {
		int indice = -1;
		for(int j = 0; j<vendedores.size(); j++) {
			if(vendedores.get(j).getCpf().equals(cpf)) {
				indice = j;
				break;
			}
		}
		return indice;
	}
	
	public boolean existeVendedor(String cpf) {
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaVazio() {
		if(vendedores.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listarVendedores() {
		for(Vendedor aux :  vendedores) {
			System.out.println(aux.toString());
		}
	}
	
	public void excluirVendedor(String cpf) {
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			this.vendedores.remove(indice);
		}
	}
}
