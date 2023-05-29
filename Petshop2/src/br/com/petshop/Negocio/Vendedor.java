package br.com.petshop.Negocio;

public class Vendedor extends Usuario{
	
	private String senha;

	public Vendedor(String nome, String cpf, String senha) {
		super(nome, "Vendedor", cpf);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + ", cpf: " + super.getCpf() + ", tipo de usuario: " + super.getTipoUsuario() +", senha: " + this.senha;
	}

}
