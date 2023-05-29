package br.com.petshop.Iu;

import br.com.petshop.Excecoes.ExisteUsuarioException;
import br.com.petshop.Negocio.Administrador;
import br.com.petshop.Negocio.Petshop;
import br.com.petshop.Negocio.Vendedor;
import br.com.petshop.Negocio.Veterinario;

public class Main {

	public static void main(String[] args) {
		Petshop fachada = new Petshop(); 
		TelaPrincipal telaprincipal = new TelaPrincipal(fachada);
		
		/*                   USUARIOS DEFAULT                                */
		Vendedor vend = new Vendedor("Maria", "123456789-00", "123");
		Veterinario vet = new Veterinario("Pedro", "789623478-06", 10.99, "123");
		Administrador adm = new Administrador("Allan", "000000000-69","123");
		try {
			fachada.adicionarVendedor(vend);
		} catch (ExisteUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fachada.adicionarVeterinario(vet);
		} catch (ExisteUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fachada.adicionarAdm(adm);
		} catch (ExisteUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*                   USUARIOS DEFAULT                                */
		
		telaprincipal.iniciar();
	}

}
