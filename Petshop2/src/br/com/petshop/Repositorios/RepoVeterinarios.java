package br.com.petshop.Repositorios;
import java.util.ArrayList;

import br.com.petshop.Classes.Veterinario;


public class RepoVeterinarios {
	private ArrayList<Veterinario> vet;

	public RepoVeterinarios() {
		this.vet = new ArrayList<Veterinario>();
	}
	
	public Veterinario getVet(String cpf){
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			return vet.get(indice);
		}
		return null;
	}
	
	public void setVet(Veterinario vet) {
		this.vet.add(vet);
	}
	
	private int indiceBusca(String cpf) {
		int indice = -1;
		for(int j = 0; j<vet.size(); j++) {
			if(vet.get(j).getCpf().equals(cpf)) {
				indice = j;
				break;
			}
		}
		return indice;
	}
	
	public void modificarVet(String cpf, Veterinario newVet) {
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			this.vet.set(indice, newVet);
		}

	}
	
	public void excluirVet(String cpf) {
		int indice;
		indice = indiceBusca(cpf);
		if(indice>=0) {
			this.vet.remove(indice);
		}
	}
	
	public boolean existeVet(String cpf) {
		int indice;
		indice = indiceBusca(cpf);
		if(indice!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaVazio() {
		if(vet.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listarVeterinario() {
		for(Veterinario aux: vet) {
			System.out.println(aux.toString());
		}
	}
}
