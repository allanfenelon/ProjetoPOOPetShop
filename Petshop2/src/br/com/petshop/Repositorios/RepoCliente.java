package br.com.petshop.Repositorios;
import java.util.ArrayList;

import br.com.petshop.Classes.*;
public class RepoCliente {
	private ArrayList<Cliente> clientes;
	
	public RepoCliente() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void setClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public Cliente getCliente(String cpf){
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			return clientes.get(indice);
		}
		return null;
	}
	
	private int indiceBusca(String cpf) {
		int indice = -1;
		for(int j = 0;j<clientes.size();j++) {
			if(clientes.get(j).getCpf().equals(cpf)) {
				indice = j;
				break;
			}
		}
		return indice;
	}
	
	public void modificarCliente(String cpf, Cliente newCliente) {
		if(!repoVazio()) {
			int indice;
			indice = indiceBusca(cpf);
			if(indice>=0) {
				this.clientes.set(indice, newCliente);
			}
		}
	}
	
	public void excluirCliente(String cpf) {
		if(!repoVazio()) {
			int indice;
			indice = indiceBusca(cpf);
			if(indice>=0) {
				this.clientes.remove(indice);
			}
		}
	}
	
	public void listarCLiente() {
		for(Cliente aux : clientes) {
			System.out.println(aux.toString());
		}
	}
	
	public boolean repoVazio() {
		if(clientes.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean existeCliente(String cpf) {
		int i;
		i = indiceBusca(cpf);
		if(i>=0) {
			return true;
		}else {
			return false;
		}
	}
}
