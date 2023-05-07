package br.com.petshop.Classes;

import java.util.Scanner;
import br.com.petshop.Repositorios.*;

public class Petshop {
	
	private double petshopLucro = 0.0;
	private boolean secao;
	private String logadoComo;
	private Scanner ler = new Scanner(System.in);
	
	public Petshop() {
		this.secao = false;
		this.logadoComo = "";
	}
	
	public void setPetshopLucro(double lucro) {
		if(lucro>=0) {
			this.petshopLucro = lucro;
		}
	}
	
	public double getPetshopLucro() {
		return this.petshopLucro;
	}
	
	public void setSecao(boolean secao) {
		this.secao =secao;
	}
	
	public boolean getSecao() {
		return this.secao;
	}
		
	
	public void setupAdmPrincipal(RepoCliente repoCli, RepoVeterinarios repoVet, RepoVendedor repoVend, RepoAdministrador repoAdm){
		if(this.secao) {
			if(this.logadoComo.equals("Administrador")) {
				System.out.println("+---- PAINEL PRINCIPAL ----+");
				System.out.println("|(1) - Painel de Gerencia  |");
				System.out.println("|(2) - Painel de vendas    |");
				System.out.println("|(4) - Sair                |");
				System.out.println("+--------------------------+");
			}else if(this.logadoComo.equals("Vendedor")) {
				System.out.println("+---- PAINEL PRINCIPAL ----+");
				System.out.println("|(2) - Painel de vendas    |");
				System.out.println("|(4) - Sair                |");
				System.out.println("+--------------------------+");
			}else if(this.logadoComo.equals("Veterinario")) {
				System.out.println("+---- PAINEL PRINCIPAL ----+");
				System.out.println("|(2) - Painel de vendas    |");
				System.out.println("|(3) - Painel Veterinario  |");
				System.out.println("|(4) - Sair                |");
				System.out.println("+--------------------------+");
			}
		}else {
		
			System.out.println(this.secao);
			System.out.println("+------ LOGIN ------+");
			login(repoCli, repoVet, repoVend, repoAdm);
			System.out.println("VOCE LOGOU COMO: " + this.logadoComo);
		}

	}
	
	public void setupAdm() {
		System.out.println("+---------- PAINEL PETSHOP ADM ----------+");
		System.out.println("|(1) - Adicionar Cliente                 |");
		System.out.println("|(2) - Listar Clientes                   |");
		System.out.println("|(3) - Remover Cliente                   |");
		System.out.println("|(4) - Adicionar Servico                 |");
		System.out.println("|(5) - Editar Preco Servico              |");
		System.out.println("|(6) - Remover Servico                   |");
		System.out.println("|(7) - Adicionar Veterinario             |");
		System.out.println("|(8) - Remover Veterinario               |");
		System.out.println("|(9) - Listar Veterinarios               |");
		System.out.println("|(10) - Editar valor p/ hora veterinario |");
		System.out.println("|(11) - Adicionar Adm                    |");
		System.out.println("|(12) - Listar Adm                       |");
		System.out.println("|(13) - Remover Adm                      |");
		System.out.println("|(14) - Adcionar Vendedor                |");
		System.out.println("|(15) - Listar Vendedores                |");
		System.out.println("|(16) - Remover Vendedor                 |");
		System.out.println("|(17) - Voltar                           |");
		System.out.println("+----------------------------------------+");
	}
	
	public void setupAdmServ() {
		System.out.println("+---- PAINEL PETSHOP SERVICO ----+");
		System.out.println("|(1) - Realizar servico / VENDER |");
		System.out.println("|(2) - Listar Clientes           |");
		System.out.println("|(3) - Gerar pagamento Cliente   |");
		System.out.println("|(4) - Consultar divida Cliente  |");
		System.out.println("|(5) - Listar Servicos           |");
		System.out.println("|(6) - Gerar Faturamento do dia  |");
		System.out.println("|(7) - Adicionar Cliente         |");
		System.out.println("|(8) - Adicionar Servico         |");
		System.out.println("|(9) - Voltar ao inicio          |");
		System.out.println("+--------------------------------+");
	}
	
	public void setupVet() {
		System.out.println("+--- PAINEL VETERINARIO ---+");
		System.out.println("|(1) - Examinar Pet        |");
		System.out.println("|(2) - Vacinacao de Pet    |");
		System.out.println("|(3) - Voltar              |");
		System.out.println("+--------------------------+");
	}
	
	public void setupVetExaminar() {
		System.out.println("+--- PAINEL VETERINARIO (EXAMINAR) ---+");
		System.out.println("|(1) - Diagoniscar Pet                |");
		System.out.println("|(2) - Tratamento do Pet              |");
		System.out.println("|(3) - Voltar                         |");
		System.out.println("+-------------------------------------+");
	}
	
	
	public void addCliente(RepoCliente repoCli) {
		System.out.print("Digite o cpf do cliente: ");
		String cpf = ler.next();
		if(!repoCli.existeCliente(cpf)) {
			System.out.print("Digite o nome do cliente: ");
			String nome = ler.next();
			System.out.print("Digite o telefone: ");
			String tel = ler.next();
			System.out.print("Digite o nome do Pet: ");
			String nomePet = ler.next();
			System.out.println("Digite o tipo do animal: ");
			String tipo = ler.next();
			Pet auxP = new Pet(nomePet, tipo);
			Cliente auxC = new Cliente(nome, cpf, auxP, tel);
			repoCli.setClientes(auxC);
			System.out.println("CLIENTE ADICIONADO COM SUCESSO!");
		}else {
			System.out.println("O CLIENTE JA EXISTE!");
		}

	}
	
	public void listarClientes(RepoCliente repoCli) {
		if(repoCli.repoVazio()) {
			System.out.println("+--------------------");
			System.out.println("vazio");
			System.out.println("+--------------------");
		}else {
			System.out.println("-> LISTAGEM DE CLIENTES <-");
			repoCli.listarCLiente();
			System.out.println("+------------------------+");
		}
	}
	
	public void removeCliente(RepoCliente repoCli) {
		if(!repoCli.repoVazio()) {
			System.out.print("Digite o cpf da pessoa que quer remover: ");
			String cpf = ler.next();
			if(repoCli.existeCliente(cpf)) {
				repoCli.excluirCliente(cpf);
				System.out.println("CLIENTE REMOVIDO COM SUCESSO!");
			}else {
				System.out.println("NAO EH POSSIVEL REMOVER CLIENTE QUE NAO EXISTE!");
			}
		}else {
			System.out.println("NAO POSSUI CLIENTES PARA EXCLUIR!");
		}
		
	}
	
	public void listarServico(RepoServicos repoServ) {
		if(repoServ.estaVazio()) {
			System.out.println("+--------------------");
			System.out.println("vazio");
			System.out.println("+--------------------");
		}else {
			System.out.println("-> LISTAGEM DE SERVICOS <-");
			repoServ.listarServicos();
			System.out.println("+------------------------+");
		}
	}
	
	public void addServico(RepoServicos repoServ) {
		
		System.out.print("Digite o nome do servico: ");
		String nomeServ = ler.next();
		if(!repoServ.existeServico(nomeServ)) {
			System.out.println("Digite o valor do servico: no tipo xx,xx (com vírgula) ");
			double valor = ler.nextDouble();
			Servicos auxS = new Servicos(nomeServ, valor);
			repoServ.setServicos(auxS);
			System.out.println("SERVICO ADICIONADO COM SUCESSO!");
		}else {
			System.out.println("NAO FOI POSSIVEL ADICONAR SERVICO, POIS JA EXISTE!");
		}
		

	}
	
	public void editValorServico(RepoServicos repoServ) {
		
		if(!repoServ.estaVazio()) {
			System.out.print("Digite o nome do servico: ");
			String nomeS = ler.next();
			
			if(repoServ.existeServico(nomeS)) {
				System.out.println("Digite o novo valor do servico: ");
				double valor = ler.nextDouble();
				repoServ.modificarPrecoServico(nomeS, valor);
				System.out.println("O VALOR DO SERVICO FOI ALTERADO!");
			}else {
				System.out.println("SERVICO NAO ENCONTRADO!");
			}	

		}else {
			System.out.println("NAO EXISTE SERVICOS PARA EDITAR!");
		}
	}
		
	
	public void removeServico(RepoServicos repoServ) {
		if(!repoServ.estaVazio()) {
			System.out.println("Digite o nome do servico que deseja remover: ");
			String nomeS = ler.next();
			if(repoServ.existeServico(nomeS)) {
				repoServ.excluirServico(nomeS);
				System.out.println("SERVICO EXCLUIDO COM SUCESSO!");
			}else {
				System.out.println("SERVICO NAO ENCONTADO!");
			}
		}else {
			System.out.println("NAO HA SERVICOS PARA EXCLUIR!");
		}

	}
	
	
	public void realizarServ(RepoServicos repS, RepoCliente repC) {
		System.out.print("Digite o nome do servico que vai realizar: ");
		String nomeServ = ler.next();
		System.out.print("Digite o CPF do cliente: ");
		String cpfCli = ler.next();
		if(repS.existeServico(nomeServ) && repC.existeCliente(cpfCli)) {
			Servicos auxS = repS.getServicos(nomeServ);
			Cliente auxC = repC.getCliente(cpfCli);
			if((auxS != null)&&(auxC !=null)) {
				double valorServ = auxS.getPreco();
				auxC.setDivida(valorServ);
				System.out.println("Realizamos o servico para o cliente: " + auxC.getNome() + "Seu saldo dividor é: " + auxC.getDivida());
				System.out.println("[LEMBRETE] Lembre de oferecer um petisco ao pet do Cliente!");
				System.out.println("O pet se chama: " + auxC.getPet().getNome());
			}else {
				System.out.println("Algo deu errado ops");
			}
		}else {
			System.out.println("Servico/produto ou Cliente inexisdtentes!");
		}
	}
	
	public void gerarPagamento(RepoCliente repC) {
		Cliente auxC;
		System.out.print("Digite o CPF do cliente: ");
		String cpf = ler.next();
		if(repC.existeCliente(cpf)) {
			auxC = repC.getCliente(cpf);
			double divida = auxC.getDivida();
			if(divida==0) {
				System.out.println("O cliente: " + auxC.getNome() + "Não há dividas!");
			}else {
				System.out.println("A divida de: " + auxC.getDivida() + "do clente" + auxC.getNome() + "Foi quitada!");
				this.setPetshopLucro(auxC.getDivida());
				auxC.setDivida(0.00);
			}
		}
	}
	
	
	public void consultarDividaCli(RepoCliente repC) {
		Cliente auxC;
		System.out.print("Digite o CPF do cliente: ");
		String cpf = ler.next();
		if(repC.existeCliente(cpf)) {
			auxC = repC.getCliente(cpf);
			System.out.println("O valor que o cliente " + auxC.getNome() + "deve é de: R$" + auxC.getDivida());
		}else {
			System.out.println("CLIENTE NAO ENCONTRADO!");
		}
	}
	
	public void retornarFaturamento() {
		System.out.println("O lucro do dia foi de: R$" + this.petshopLucro);
	}
	
	public void adicionarVet(RepoVeterinarios repoVet) {
		System.out.print("Digite o CPF do veterinario: ");
		String cpfVet = ler.next();
		if(!repoVet.existeVet(cpfVet)) {
			System.out.print("Digite o nome do Veterinario: ");
			String nomeVet = ler.next();
			System.out.print("Digite o valor por hora desse veterinario: ");
			double valorHora = ler.nextDouble();
			System.out.print("Digite a senha desse Veterinario: ");
			String senha = ler.next();
			Veterinario auxVet= new Veterinario(nomeVet, cpfVet, valorHora, senha);
			repoVet.setVet(auxVet);
			System.out.println("VETERINARIO ADICIONADO COM SUCESSO!");
		}else {
			System.out.println("VETERINARIO JA EXISTE NO SISTEMA!");
		}
	}
	
	public void removerVet(RepoVeterinarios repoVet) {
		if(!repoVet.estaVazio()) {
			System.out.print("Digite o cpf do veterinario: ");
			String cpfVet = ler.next();
			if(repoVet.existeVet(cpfVet)) {
				repoVet.excluirVet(cpfVet);
				System.out.println("VETERINARIO EXCLUIDO COM SUCESSO!");
			}else {
				System.out.println("VETERINARIO NAO ENCONTRADO!");
			}
		}else {
			System.out.println("NAO EXISTE NENHUM VETERINARIO CADASTRADO!");
		}
	}
	
	public void listarVet(RepoVeterinarios repoVet) {
		if(repoVet.estaVazio()) {
			System.out.println("+--------------------");
			System.out.println("vazio");
			System.out.println("+--------------------");
		}else {
			System.out.println("-> LISTAGEM DE SERVICOS <-");
			repoVet.listarVeterinario();
			System.out.println("+------------------------+");
		}
	}
	
	public void editarValorVeterinario(RepoVeterinarios repoVet) {
		if(!repoVet.estaVazio()) {
			System.out.print("Digite o CPF do veterinario: ");
			String cpfVet = ler.next();
			if(repoVet.existeVet(cpfVet)) {
				System.out.print("Digite o novo valor por hora do veterinario: ");
				double valor = ler.nextDouble();
				if(valor>=0) {
					repoVet.getVet(cpfVet).setValorPorHora(valor);
					System.out.println("VALOR POR HORA ALTERADO COM SUCESSO!");
				}else {
					System.out.println("VALOR NAO ALTERADO! POIS O VALOR EH INVALIDO!");
				}
			}
			else {
				System.out.println("VATERINARIO NAO ENCONTRADO!");
			}
		}else {
			System.out.println("NAO EXISTE NENHUM VETERINARIO PARA ALTERAR");
		}
	}
	
	public void diaginosticarPet(RepoVeterinarios repoVet, RepoCliente repoCli) {
		if(!(repoVet.estaVazio() || repoCli.repoVazio())) {
			System.out.print("Digite o cpf do veterinario: ");
			String cpfVet = ler.next();
			System.out.println("Digite o cpf do cliente: ");
			String cpdCli = ler.next();
			if(repoVet.existeVet(cpfVet) && repoCli.existeCliente(cpfVet)) {
				System.out.println("Existe algum problema com o PET? (1) - SIM (2) - NAO");
				int leitura = ler.nextInt();
				if(leitura == 1) {
					repoCli.getCliente(cpdCli).getPet().setObservacaoVet(true);
					repoCli.getCliente(cpdCli).getPet().setNomeVeterinario(repoVet.getVet(cpfVet).getNome());
					System.out.print("Descreva o problema do PET: ");
					String problema = ler.next();
					repoCli.getCliente(cpdCli).getPet().setProblemaPet(problema);
					System.out.print("DIGITE O VALOR DESSA CONSULTA PARA CADASTRAR NA DIVIDA DO CLIENTE: ");
					double divida = ler.nextDouble();
					repoCli.getCliente(cpdCli).setDivida(divida);
				}else if(leitura == 2){
					System.out.println("OTIMO!");
					System.out.print("DIGITE O VALOR DESSA CONSULTA PARA CADASTRAR NA DIVIDA DO CLIENTE: ");
					double divida = ler.nextDouble();
					repoCli.getCliente(cpdCli).setDivida(divida);
				}else {
					System.out.println("NAO FOI POSSIVEL COMPLETAR SUA OPERACAO!");
				}
			}
		}else {
			System.out.println("OPERACAO INVALIDA!, NAO EXISTE VETERINARIO OU CLIENTE!");
		}
	}

	
	public void tratarPet(RepoVeterinarios repoVet, RepoCliente repoCli) {
		if(!(repoVet.estaVazio()||repoCli.repoVazio())) {
			System.out.print("Digite o cpf do veterinario: ");
			String cpfVet = ler.next();
			System.out.println("Digite o cpf do cliente: ");
			String cpdCli = ler.next();
			if(repoVet.existeVet(cpfVet)&&repoCli.existeCliente(cpdCli)) {
				if(repoCli.getCliente(cpdCli).getPet().getObservacaoVet()||(repoCli.getCliente(cpdCli).getPet().getNomeVeterinario().equals(repoVet.getVet(cpfVet).getNome()))) {
					System.out.println("Iremos tratar o PET: " + repoCli.getCliente(cpdCli).getPet().getNome());
					System.out.println("A observacao desse PET eh: " + repoCli.getCliente(cpdCli).getPet().getProblemaPet());
					System.out.println("DIGITE QUANTAS HORAS VOCE VAI USAR PARA ESTE CASO, LEMBRE-SE QUE SERVIRA COMO BASE DO QUE GANHARA!: ");
					double qtdHora = ler.nextDouble();
					double valorDivida = qtdHora * repoVet.getVet(cpfVet).getValorPorHora();
					repoCli.getCliente(cpdCli).setDivida(valorDivida);
					repoCli.getCliente(cpdCli).getPet().setNomeVeterinario("");
					repoCli.getCliente(cpdCli).getPet().setObservacaoVet(false);
					repoCli.getCliente(cpdCli).getPet().setProblemaPet("");
					repoVet.getVet(cpfVet).setValorGanho(valorDivida);
					System.out.println("VOCE ACABOU DE TRATAR O PET: " + repoCli.getCliente(cpdCli).getPet().getNome());

					
				}else {
					if(!repoCli.getCliente(cpdCli).getPet().getObservacaoVet()) {
						System.out.println("O PET NAO POSSUI NENHUMA OBSERVACAO PARA TRATAMENTO");
					}else {
						System.out.println("O vaterinario: " + repoVet.getVet(cpfVet).getNome() + " nao eh reponsavel por esse caso!");
						System.out.println("Esse caso eh do veterinario: " + repoCli.getCliente(cpfVet).getPet().getNomeVeterinario());
					}
				}
			}else {
				System.out.println("NAO FOI POSSIVEL LOCALIZAR O VETERINARIO OU CLIENTE!");
			}
		}else {
			System.out.println("OPRACAO INVALIDA! NAO EXISTE VETERINARIO OU CLIENTE NO BANCO!");
		}
	}

	public void vacinarPet(RepoVeterinarios repoVet, RepoCliente repoCli) {
		if(!(repoVet.estaVazio()||repoCli.repoVazio())){
			System.out.print("Digite o cpf do veterinario: ");
			String cpfVet = ler.next();
			System.out.println("Digite o cpf do cliente: ");
			String cpdCli = ler.next();
			if(repoVet.existeVet(cpfVet)&&repoCli.existeCliente(cpdCli)) {
				System.out.print("Digite o valor da vacina: ");
				double valor = ler.nextDouble();
				if(valor>=0) {
					System.out.println("VOCE ACABA DE VACINAR O PET: " + repoCli.getCliente(cpdCli).getPet().getNome());
					repoCli.getCliente(cpdCli).setDivida(valor);
				}else {
					System.out.println("VALOR INVALIDO!");
				}
			}else {
				System.out.println("VETERINARIO OU CLIENTE NAO ENCONTRADO!");
			}
		}else {
			System.out.println("NAO EXISTE VETERINARIO OU NAO EXISTE CLIENTES!");
		}
	}

	public String getLogadoComo() {
		return logadoComo;
	}

	public void setLogadoComo(String logadoComo) {
		this.logadoComo = logadoComo;
	}
	
	
	public void login(RepoCliente repoCli, RepoVeterinarios repoVet, RepoVendedor repoVend, RepoAdministrador repoAdm) {
		boolean condicao =true;
		while(condicao) {
			System.out.println("(1) - Logar como Vendedor");
			System.out.println("(2) - Logar como ADM");
			System.out.println("(3) - Logar como Veterinário");
			int opcao = ler.nextInt();
			if(opcao == 1) {
				if(!repoVend.estaVazio()) {
					System.out.print("Digite o CPF: ");
					String cpf = ler.next();
					System.out.print("Difite a senha: ");
					String senha = ler.next();
					if(repoVend.existeVendedor(cpf)) {
						if(repoVend.getVendedores(cpf).getSenha().equals(senha)){
							this.secao = true;
							this.logadoComo = repoVend.getVendedores(cpf).getTipoUsuario();
							System.out.println("Logado com sucesso!");
							condicao = false;
							
						}else {
							System.out.println("SENHA INCORRETA!");
						}
					}else {
						System.out.println("VENDEDOR NAO ENCONTRADO!");
					}
				}else {
					System.out.println("NAO EXISTE VENDEDORES PARA FAZER LOGIN!");
				}
			}else if(opcao == 2) {
				if(!repoAdm.estaVazio()) {
					System.out.print("Digite o CPF: ");
					String cpf = ler.next();
					System.out.print("Digite a senha: ");
					String senha = ler.next();
					if(repoAdm.existeAdm(cpf)) {
						if(repoAdm.getAdministradores(cpf).getSenha().equals(senha)) {
							this.secao = true;
							this.logadoComo = repoAdm.getAdministradores(cpf).getTipoUsuario();
							System.out.println("LOGADO COM SUCESSO!");
							condicao = false;
						}
					}else {
						System.out.println("NAO EXISTE ADM COM ESSE CPF!");
					}
				}else {
					System.out.println("NAO EXISTE ADM PARA FAZER LOGIN!");
				}
			}else if(opcao == 3) {
				if(!repoVet.estaVazio()) {
					System.out.print("Digite o CPF: ");
					String cpf =ler.next();
					if(repoVet.existeVet(cpf)) {
						System.out.print("Digite a senha: ");
						String senha = ler.next();
						if(repoVet.getVet(cpf).getSenha().equals(senha)) {
							System.out.println("LOGIN FEITO COM SUCESSO!");
							this.secao = true;
							this.logadoComo = repoVet.getVet(cpf).getTipoUsuario();
							System.out.println("Logado com sucesso!");
							condicao = false;
						}else {
							System.out.println("SENHA INCORRETA!");
						}
						
					}else {
						System.out.println("CPF INVALIDO, TENTE NOVAMENTE!");
					}
				}else {
					System.out.println("NAO EXISTE CONTAS DE VETERINARIO!");
				}
			}else {
				System.out.println("OPCAO INVALIDA, TENTE NOVAMENTE!");
			}
		}
	}
	
	public void addAdm(RepoAdministrador repoAdm) {
		System.out.print("Digite o nome do Administrador: ");
		String nome = ler.next();
		System.out.print("Digite o CPF do Administrador: ");
		String cpf = ler.next();
		if(!repoAdm.existeAdm(cpf)) {
			System.out.print("Digite a senha: ");
			String senha = ler.next();
			Administrador auxadm = new Administrador(nome, cpf, senha);
			repoAdm.setAdministradores(auxadm);
			System.out.println("ADM ADICIONADO COM SUCESSO!");
		}else {
			System.out.println("JA EXISTE UM ADM COM ESSE CPF!");
		}
	}
	
	public void listarAdm(RepoAdministrador repoAdm) {
		if(repoAdm.estaVazio()) {
			System.out.println("+--------------------");
			System.out.println("vazio");
			System.out.println("+--------------------");
		}else {
			System.out.println("-> LISTAGEM DE ADMS <-");
			repoAdm.listarAdm();
			System.out.println("+------------------------+");
		}
	}
	
	public void removeAdm(RepoAdministrador repoAdm) {
		if(!repoAdm.estaVazio()) {
			System.out.print("Digite o CPF do adm que quer remover: ");
			String cpf = ler.next();
			if(repoAdm.existeAdm(cpf)) {
				repoAdm.excluirAdm(cpf);
				System.out.println("ADM REMOVIDO COM SUCESSO!");
			}else
				System.out.println("O ADM COM ESSE CPF NAO EXISTE NO NOSSO BANCO DE DADOS!");
		}else {
			System.out.println("REPOSITORIO VAZIO, NADA A REMOVER!");
		}
	}
	
	public void addVendedor(RepoVendedor repoVend) {
		System.out.print("Digite o nome do vendedor: ");
		String nome = ler.next();
		System.out.print("Digite o CPFdo vendedodor: ");
		String cpf = ler.next();
		if(!repoVend.existeVendedor(cpf)) {
			System.out.print("Digite a senha do vendedor: ");
			String senha = ler.next();
			Vendedor aux = new Vendedor(nome, cpf, senha);
			repoVend.setVendedores(aux);
		}else {
			System.out.println("JA EXISTE VENDEDOR COM ESSE CPF!");
		}
	}
	
	public void listarVendedor(RepoVendedor repoVend) {
		if(repoVend.estaVazio()) {
			System.out.println("+--------------------");
			System.out.println("vazio");
			System.out.println("+--------------------");
		}else {
			System.out.println("-> LISTAGEM DE ADMS <-");
			repoVend.listarVendedores();
			System.out.println("+------------------------+");
		}
	}
	
	public void removerVendedor(RepoVendedor repoVend) {
		if(!repoVend.estaVazio()) {
			System.out.print("Digite o cpf do vendedor: ");
			String cpf = ler.next();
			if(repoVend.existeVendedor(cpf)) {
				repoVend.excluirVendedor(cpf);
			}else {
				System.out.println("NAO EXISTE VENDEDOR COM ESSE CPF!");
			}
		}else {
			System.out.println("NAO EXISTE NENHUM VENDEDOR NO BANCO DE DADOS!");
		}
	}
	
	public void logout() {
		this.logadoComo = "";
		this.secao = false;
		System.out.println("DESLOGADO COM SUCESSO!");
	}
	
}