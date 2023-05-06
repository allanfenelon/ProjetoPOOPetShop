package principal;

import java.util.Scanner;

import br.com.petshop.Classes.Administrador;
import br.com.petshop.Classes.Petshop;
import br.com.petshop.Classes.Vendedor;
import br.com.petshop.Classes.Veterinario;
import br.com.petshop.Repositorios.RepoAdministrador;
import br.com.petshop.Repositorios.RepoCliente;
import br.com.petshop.Repositorios.RepoServicos;
import br.com.petshop.Repositorios.RepoVendedor;
import br.com.petshop.Repositorios.RepoVeterinarios;

public class Principal {

	public static void main(String arg[]) {
		RepoCliente repoCli = new RepoCliente();
		RepoServicos repoServico= new RepoServicos();
		Petshop petshop = new Petshop();
		RepoVeterinarios repoVet = new RepoVeterinarios();
		RepoAdministrador repoAdm = new RepoAdministrador();
		RepoVendedor repoVend = new RepoVendedor();
		
		/* USUARIOS PARA O BACKLOG */
		Administrador auxAdm = new Administrador("Carlos", "123456789-00", "123");
		repoAdm.setAdministradores(auxAdm);
		Vendedor auxvend = new Vendedor("Ana", "456789123-02", "456");
		repoVend.setVendedores(auxvend);
		Veterinario auxVet = new Veterinario("Beatriz", "147852369-32", 50.32, "789");
		repoVet.setVet(auxVet);
		/* -------------------- */
		boolean laco = true;
		try (Scanner ler = new Scanner(System.in)) {
			int condicao = 0;
			while (laco) {
				if(!petshop.getSecao()) {
					petshop.setupAdmPrincipal(repoCli, repoVet, repoVend, repoAdm);
				}
				petshop.setupAdmPrincipal(repoCli, repoVet, repoVend, repoAdm);
				condicao = ler.nextInt();
				if (condicao == 1 && petshop.getLogadoComo().equals("Administrador")) {
					boolean cond2 = true;
					while (cond2) {
						petshop.setupAdm();
						condicao = ler.nextInt();
						switch (condicao) {
						case 1:
							petshop.addCliente(repoCli);
							break;
						case 2:
							petshop.listarClientes(repoCli);
							break;
						case 3:
							petshop.removeCliente(repoCli);
							break;
						case 4:
							petshop.addServico(repoServico);
							break;
						case 5:
							petshop.editValorServico(repoServico);
							break;
						case 6:
							petshop.removeServico(repoServico);
							break;
						case 7:
							petshop.adicionarVet(repoVet);
							break;
						case 8:
							petshop.removerVet(repoVet);
							break;
						case 9:
							petshop.listarVet(repoVet);
							break;
						case 10:
							petshop.editarValorVeterinario(repoVet);
							break;
						case 11:
							petshop.addAdm(repoAdm);
							break;
						case 12:
							petshop.listarAdm(repoAdm);
							break;
						case 13:
							petshop.removeAdm(repoAdm);
							break;
						case 14:
							petshop.addVendedor(repoVend);
							break;
						case 15:
							petshop.listarVendedor(repoVend);
							break;
						case 16:
							petshop.removerVendedor(repoVend);
							break;
						case 17:
							cond2 = false;
							break;
						default:
							System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE");
							break;
						}
					}
				} else if (condicao == 2) {
					boolean cond3 = true;
					int condd;
					while (cond3) {
						petshop.setupAdmServ();
						condd = ler.nextInt();
						switch (condd) {
						case 1:
							petshop.realizarServ(repoServico, repoCli);
							break;
						case 2:
							petshop.listarClientes(repoCli);
							break;
						case 3:
							petshop.gerarPagamento(repoCli);
							break;
						case 4:
							petshop.consultarDividaCli(repoCli);
							break;
						case 5:
							petshop.listarServico(repoServico);
							break;
						case 6:
							petshop.retornarFaturamento();
							break;
						case 7:
							petshop.addCliente(repoCli);
							break;
						case 8:
							petshop.addServico(repoServico);
							break;
						case 9:
							cond3 = false;
							break;
						default:
							System.out.println("OPCAO INVALIDA!");
							break;
						}
					}
				} else if (condicao == 3 && petshop.getLogadoComo().equals("Veterinario")) {
					boolean condVet = true;
					int lerVet;
					while (condVet) {
						petshop.setupVet();
						lerVet = ler.nextInt();
						switch (lerVet) {
						case 1:
							boolean condExame = true;
							while (condExame) {
								petshop.setupVetExaminar();
								lerVet = ler.nextInt();
								switch (lerVet) {
								case 1:
									petshop.diaginosticarPet(repoVet, repoCli);
									break;
								case 2:
									petshop.tratarPet(repoVet, repoCli);
									break;
								case 3:
									condExame = false;
									break;

								default:
									System.out.println("OPCAO INVALIDA, TENTE NOVAMENTE!");
									break;
								}
							}
							break;
						case 2:
							petshop.vacinarPet(repoVet, repoCli);
							break;
						case 3:
							condVet = false;
							break;

						default:
							System.out.println("OPCAO INVALIDA, TENTE NOVAMENTE!");
							break;
						}
					}
				}else if(condicao == 4) {
					petshop.logout();
				}else {
					System.out.println("OPCAO INVALIDA!");
				}

			}
			ler.close();
		}
		
	}
}
