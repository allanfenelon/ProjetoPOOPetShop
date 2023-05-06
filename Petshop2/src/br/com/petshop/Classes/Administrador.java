package br.com.petshop.Classes;

public class Administrador extends Usuario{
	
	private String senha;

	public Administrador(String nome, String cpf, String senha) {
		super(nome, "Administrador", cpf);
		this.senha = senha;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + ", cpf: " + super.getCpf() + ", tipo de usuario: " + super.getTipoUsuario() + ", senha: " + this.senha;
	}

}
