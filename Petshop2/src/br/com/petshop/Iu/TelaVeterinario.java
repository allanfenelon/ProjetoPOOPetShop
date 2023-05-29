package br.com.petshop.Iu;

import java.util.Scanner;

import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Excecoes.PetJaTemDiagnosticoException;
import br.com.petshop.Excecoes.PetSemDiagnosticoException;
import br.com.petshop.Excecoes.ValorInvalidoException;
import br.com.petshop.Negocio.Petshop;

public class TelaVeterinario {
	private Petshop fachada;
	private Scanner ler;
	private TelaVendedor vendedor;
	private TelaListagens listagem;
	
	public TelaVeterinario(Petshop fachada) {
		this.fachada = fachada;
		this.ler =new Scanner(System.in);
		this.vendedor = new TelaVendedor(this.fachada);
		this.listagem = new TelaListagens(this.fachada);
	}
	
	public void iniciar() {
		boolean repeticao = true;
		while(repeticao) {
			System.out.println(">>>>> TELA VETERINARIO <<<<<");
			System.out.println("(1) - TELA DE VENDAS");
			System.out.println("(2) - TELA DO VETERINARIO");
			System.out.println("(3) - SAIR");
			int opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				vendedor.iniciar();
				break;
			case 2:
				boolean rep = true;
				while(rep) {
					System.out.println(">>>>> VETERINARIO <<<<<");
					System.out.println("(1) - DIAGNOSTICAR PET");
					System.out.println("(2) - CONSULTAR PROBLEMA DO PET");
					System.out.println("(3) - TRATAR PET");
					System.out.println("(4) - VACINAR PET");
					System.out.println("(5) - SAIR");
					int opcao1 = ler.nextInt();
					switch (opcao1) {
					case 1:
						System.out.print("CPF DO CLIENTE: ");
						String cpfCli = ler.next();
						System.out.print("CPF DO VETERINARIO RESPONSAVEL: ");
						String cpfVet = ler.next();
						System.out.print("DIAGNOTICO DO PET: ");
						String diagnostico = ler.next();
						try {
							fachada.diagnosticarPet(cpfCli, cpfVet, diagnostico);
							System.out.println("DIAGNOSTICO FEITO COM SUCESSO!");
						} catch (NaoExisteUsuarioException e1) {
							System.out.println("NAO EXISTE CLIENTE COM ESSE CPF!");
							
						} catch (PetJaTemDiagnosticoException e2) {
							System.out.println("O PET JA TEM DIAGNOSTICO!!");
						}
						
						break;
					case 2:
						listagem.listarDiagnosticoPet();
						break;
					case 3:
						System.out.print("CPF DO CLIENTE: ");
						String cpf = ler.next();
						System.out.print("VALOR DO TRATAMENTO: (xx,xx)");
						double valor = ler.nextDouble();
						try {
							fachada.tratarPet(cpf, valor);
							System.out.println("TRATAMENTO CONCLUIDO!");
						}catch(NaoExisteUsuarioException e) {
							System.out.println("NAO EXISTE CLIENTE COM ESSE CPF!");
						}catch(PetSemDiagnosticoException e) {
							System.out.println("O PET NAO POSSUI PROBLEMAS PARA TRATAR!");
						}catch(ValorInvalidoException e) {
							System.out.println("VALOR INVALIDO!");
						}
						break;
					case 4:
						System.out.print("CPF DO CLIENTE: ");
						String cpf1 = ler.next();
						System.out.print("DIGITE O VALOR DA VACINACAO: ");
						double valor1 = ler.nextDouble();
						try {
							fachada.vacinarPet(cpf1, valor1);
							System.out.println("PET VACINADO!");
						} catch (NaoExisteUsuarioException e) {
							System.out.println("NAO EXISTE CLIENTE COM ESSE CPF!");
						} catch (ValorInvalidoException e) {
							System.out.println("VALOR INVALIDO!");
						}
						break;
					case 5:
						rep = false;
						break;
					default:
						System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE!");
						break;
					}
				}
				break;
			case 3:
				this.fachada.setSecaoAtiva(false);
				repeticao = false;
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
		}
	}
}
