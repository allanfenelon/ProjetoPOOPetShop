package br.com.petshop.Classes;

public class Usuario {
	private String nome;
	private String tipoUsuario;
	private String cpf;
	
	public Usuario(String nome,String tipoUsuario, String cpf) {
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	

	

	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;

	}
	
	public String getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	@Override
	public String toString() {
		return "Usuario:" + this.nome + ", Tipo: " + this.tipoUsuario + ", Cpf: " + this.cpf;
	}
	
	
}
