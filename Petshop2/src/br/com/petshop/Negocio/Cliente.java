package br.com.petshop.Negocio;

public class Cliente extends Usuario{

	private String tel;
	private double divida;
	private Pet pet;
	
	public Cliente(String nome, String cpf, Pet pet, String tel) {
		super(nome, "Cliente", cpf);
		this.pet = pet;
		this.tel = tel;
	}
	

	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setDivida(double divida) {
		if(divida>=0) {
			this.divida += divida;
		}
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public String getTel() {
		return this.tel;
	}
	

	
	public double getDivida() {
		return this.divida;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() +", Cpf: " +  super.getCpf() +", Nome pet: "+ pet.getNome() + ", tipo Pet: " + pet.getTipoAnimal() +", Divida: R$" + this.divida + ", Telefone: "+this.tel;
	}
	
}
