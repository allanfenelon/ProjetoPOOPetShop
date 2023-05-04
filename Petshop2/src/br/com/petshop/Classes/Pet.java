package br.com.petshop.Classes;

public class Pet {
	private String nome;
	private String tipoAnimal;
	private String problemaPet;
	private boolean observacaoVet;
	private String nomeVeterinario;
	
	public Pet(String nome, String tipoAnimal) {
		
		this.nome = nome;
		this.tipoAnimal = tipoAnimal;
		this.problemaPet = "";
		this.observacaoVet =false;
		this.nomeVeterinario = "";
		
	}
	
	public void setNomeVeterinario(String nomeVet) {
		this.nomeVeterinario = nomeVet;
	}
	
	public String getNomeVeterinario() {
		return this.nomeVeterinario;
	}
	
	public void setObservacaoVet(boolean observacao) {
		this.observacaoVet = observacao;
	}
	
	public boolean getObservacaoVet() {
		return this.observacaoVet;
	}
	
	public void setProblemaPet(String problema) {
		this.problemaPet = problema;
	}
	
	public String getProblemaPet() {
		return this.problemaPet;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public void setTipoAnimal(String tipoAnimal) {
		
		this.tipoAnimal = tipoAnimal;
		
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTipoAnimal() {
		return this.tipoAnimal;
	}
	
	
	@Override
	public String toString() {
		if(!this.observacaoVet) {
			return "Nome Pet: " + this.nome + ", tipo: " + this.tipoAnimal;
		}else {
			return "Nome Pet: " + this.nome + ", tipo: " + this.tipoAnimal + ", O pet possui o seguinte problema: " + this.problemaPet + ", é paciente do veterinario: " + this.nomeVeterinario;
		}
		
	}
}
