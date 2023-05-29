package br.com.petshop.Repositorios;

import java.util.ArrayList;


import br.com.petshop.Negocio.Administrador;

public class RepoAdministrador implements RepoInterfaceAdm{
	private ArrayList<Administrador> administradores;
	
	public RepoAdministrador() {
		this.administradores = new ArrayList<Administrador>();
	}

	public Administrador getAdministradores(String cpf){
		int indice = indiceBusca(cpf);
	
		return administradores.get(indice);
		
	}

	public void setAdministradores(Administrador administrador){
		this.administradores.add(administrador);
		
	}
	
	private int indiceBusca(String cpf) {
		int indice = -1;
		for(int j = 0; j<administradores.size(); j++) {
			if(administradores.get(j).getCpf().equals(cpf)) {
				indice = j;
				break;
			}
		}
		return indice;
	}
	
	public void excluirAdm(String cpf){
		int indice;
		indice = indiceBusca(cpf);

		this.administradores.remove(indice);
	}
	
	public boolean existeAdm(String cpf){
		int indice;
		indice = indiceBusca(cpf);
		if(indice!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaVazio(){
		if(administradores.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void listarAdm() {

		for(Administrador aux : administradores) {
			System.out.println(aux.toString());
		}

	}
	
}
