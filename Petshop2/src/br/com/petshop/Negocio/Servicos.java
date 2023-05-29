package br.com.petshop.Negocio;

public class Servicos {
	private String nomeServico;
	private double preco;
	
	public Servicos(String nomeServico, double preco) {
		this.nomeServico = nomeServico;
		this.preco = preco;
	}
	
	public void setNomeServico(String nome) {
		if(!nome.isEmpty()) {
			this.nomeServico = nome;
		}
	}
	
	public void setPreco(double preco) {
		if(preco>=0) {
			this.preco = preco;
		}
	}
	
	public String getNomeServico() {
		return this.nomeServico;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void atualizaPreco(double preco) {
		if(preco>=0 && preco!=this.preco) {
			this.preco = preco;
		}
	}
	@Override
	public String toString() {
		return "Nome: " + this.nomeServico + ", preco: R$" + this.preco;
	}
}
