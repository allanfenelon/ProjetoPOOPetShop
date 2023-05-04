package br.com.petshop.Classes;


public class Veterinario extends Usuario{
	
	private double valorPorHora;
	
	private double valorGanho;


	public Veterinario(String nome, String cpf, double valorPorHora) {
		super(nome, "Vaterinario", cpf);
		this.valorPorHora = valorPorHora;
		this.valorGanho = 0.00;
	}
	
	public void setValorGanho(double valor) {
		this.valorGanho +=valor;
	}
	
	public double getValorGanho() {
		return this.valorGanho;
	}
	
	public void setValorPorHora(double valor) {
		this.valorPorHora = valor;
	}
	
	public double getValorPorHora() {
		return this.valorPorHora;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + " Com o cargo de: " + super.getTipoUsuario() + " cpf:" + super.getCpf() + " valor por hora: " + this.valorPorHora +" e tem um saldo ganho de: " + this.valorGanho;
	}
	
	
	

}
