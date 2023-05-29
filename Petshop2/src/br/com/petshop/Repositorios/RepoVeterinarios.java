package br.com.petshop.Repositorios;
import java.util.ArrayList;


import br.com.petshop.Negocio.Veterinario;


public class RepoVeterinarios implements RepoInterfaceVet{
	private ArrayList<Veterinario> vet;

	public RepoVeterinarios() {
		this.vet = new ArrayList<Veterinario>();
	}
	
	public Veterinario getVet(String cpf){
		int indice;
		indice = indiceBusca(cpf);
		return vet.get(indice);

	}
	
	public void setVet(Veterinario vet){
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
	
	public boolean existeVet(String cpf){
		int indice;
		indice = indiceBusca(cpf);
		if(indice!=-1) {
			return true;
		}
		return false;
	}
	
	public boolean estaVazio(){
		if(vet.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void listarVeterinario() {
		for(Veterinario aux: vet) {
			System.out.println(aux.toString());
		}
	}
}
