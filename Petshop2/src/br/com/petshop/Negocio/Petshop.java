package br.com.petshop.Negocio;

import br.com.petshop.Excecoes.ExisteServicoException;
import br.com.petshop.Excecoes.ExisteUsuarioException;
import br.com.petshop.Excecoes.NaoExisteServicoException;
import br.com.petshop.Excecoes.NaoExisteUsuarioException;
import br.com.petshop.Excecoes.PetJaTemDiagnosticoException;
import br.com.petshop.Excecoes.PetSemDiagnosticoException;
import br.com.petshop.Excecoes.SenhaIncorretaException;
import br.com.petshop.Excecoes.ValorInvalidoException;
import br.com.petshop.Repositorios.RepoAdministrador;
import br.com.petshop.Repositorios.RepoCliente;
import br.com.petshop.Repositorios.RepoInterfaceAdm;
import br.com.petshop.Repositorios.RepoInterfaceCliente;
import br.com.petshop.Repositorios.RepoInterfaceServicos;
import br.com.petshop.Repositorios.RepoInterfaceVendedor;
import br.com.petshop.Repositorios.RepoInterfaceVet;
import br.com.petshop.Repositorios.RepoServicos;
import br.com.petshop.Repositorios.RepoVendedor;
import br.com.petshop.Repositorios.RepoVeterinarios;

public class Petshop {
	private RepoInterfaceCliente repoCli;
	private RepoInterfaceServicos repoServico;
	private RepoInterfaceVet repoVet;
	private RepoInterfaceAdm repoAdm;
	private RepoInterfaceVendedor repoVend;
	
	boolean secaoAtiva;
	String tipoUser; // V - vendedor - A - ADM e VE- Veterinário
	
	/* GERAL PETSHOP */
	
	public Petshop() {
		this.repoCli = new RepoCliente();
		this.repoServico= new RepoServicos();
		this.repoVet = new RepoVeterinarios();
		this.repoAdm = new RepoAdministrador();
		this.repoVend = new RepoVendedor();
		this.secaoAtiva = false;
		this.tipoUser = "";
	}
	
	 public boolean getSecaoAtiva() {
		return this.secaoAtiva;
	}
	 
	 public String getTipoUser() {
		 return this.tipoUser;
	 }
	 public void setSecaoAtiva(boolean cond) {
		 this.secaoAtiva =cond;
	 }
	
	public void adicionarCliente(Cliente cli) throws ExisteUsuarioException {
		if(this.repoCli.existeCliente(cli.getCpf())) {
			 throw new ExisteUsuarioException();
		}else {
			this.repoCli.setClientes(cli);
		}
	}
	
	public void adicionarAdm(Administrador adm) throws ExisteUsuarioException{
		if(this.repoAdm.existeAdm(adm.getCpf())) {
			throw new ExisteUsuarioException();
		}else {
			this.repoAdm.setAdministradores(adm);
		}
	}
	
	public void adicionarServico(Servicos serv) throws ExisteServicoException, ValorInvalidoException{
		if(this.repoServico.existeServico(serv.getNomeServico())) {
			throw new ExisteServicoException();
		}else {
			if(serv.getPreco()<0) {
				throw new ValorInvalidoException();
			}else {
				this.repoServico.setServicos(serv);
			}
		}
	}
	
	public RepoCliente retornarClientes() throws NaoExisteUsuarioException{
		if(this.repoCli.repoVazio()) {
			throw new NaoExisteUsuarioException();
		}else {
			return (RepoCliente) this.repoCli;
		}
	}
	
	public RepoAdministrador retornarAdms() throws NaoExisteUsuarioException{
		if(this.repoAdm.estaVazio()) {
			throw new NaoExisteUsuarioException();
		}else {
			return (RepoAdministrador) this.repoAdm;
		}
	}
	
	public RepoServicos retornarServicos() throws NaoExisteServicoException{
		if(this.repoServico.estaVazio()) {
			throw new NaoExisteServicoException();
		}else {
			return (RepoServicos) this.repoServico;
		}
	}
	
	public void realizarServico(String cpfcli, String nomeServ) throws NaoExisteServicoException, NaoExisteUsuarioException{
		
		if(this.repoCli.existeCliente(cpfcli)) {
			if(this.repoServico.existeServico(nomeServ)) {
				double valorServico = this.repoServico.getServicos(nomeServ).getPreco();
				this.repoCli.getCliente(cpfcli).setDivida(valorServico);
			}else {
				throw new NaoExisteServicoException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public double retornarDividaCliente(String cpfcli) throws NaoExisteUsuarioException{
		if(this.repoCli.existeCliente(cpfcli)) {
			return this.repoCli.getCliente(cpfcli).getDivida();
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void fazerPagamentoCliente(String cpfcli, double valor) throws NaoExisteUsuarioException, ValorInvalidoException{
		if(this.repoCli.existeCliente(cpfcli)) {
			if(valor<0) {
				throw new ValorInvalidoException();
			}else {
				this.repoCli.getCliente(cpfcli).setDivida((-1)*(valor));
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	/* ------------------------------- */
	
	/* VET */
	
	public void diagnosticarPet(String cpfcli, String cpfVet, String diagnostico) throws NaoExisteUsuarioException, PetJaTemDiagnosticoException{
		if(this.repoCli.existeCliente(cpfcli)||this.repoVet.existeVet(cpfVet)) {
			if(this.repoCli.getCliente(cpfcli).getPet().getObservacaoVet()) {
				throw new PetJaTemDiagnosticoException();
			}else {
				this.repoCli.getCliente(cpfcli).getPet().setNomeVeterinario(this.repoVet.getVet(cpfVet).getNome());
				this.repoCli.getCliente(cpfcli).getPet().setObservacaoVet(true);
				this.repoCli.getCliente(cpfcli).getPet().setProblemaPet(diagnostico);
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public String retornarDiagnosticoPet(String cpfcli) throws NaoExisteUsuarioException, PetSemDiagnosticoException{
		if(this.repoCli.existeCliente(cpfcli)) {
			if(this.repoCli.getCliente(cpfcli).getPet().getObservacaoVet()) {
				return this.repoCli.getCliente(cpfcli).getPet().getProblemaPet();
			}else {
				throw new PetSemDiagnosticoException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void tratarPet(String cpfcli, double valor) throws NaoExisteUsuarioException, PetSemDiagnosticoException, ValorInvalidoException{
		if(this.repoCli.existeCliente(cpfcli)) {
			if(this.repoCli.getCliente(cpfcli).getPet().getObservacaoVet()) {
				if(valor>=0) {
					this.repoCli.getCliente(cpfcli).getPet().setNomeVeterinario("");
					this.repoCli.getCliente(cpfcli).getPet().setObservacaoVet(false);
					this.repoCli.getCliente(cpfcli).getPet().setProblemaPet("");
					this.repoCli.getCliente(cpfcli).setDivida(valor);
				}else {
					throw new ValorInvalidoException();
				}
			}else {
				throw new PetSemDiagnosticoException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void vacinarPet(String cpfcli, double valor) throws NaoExisteUsuarioException, ValorInvalidoException{
		if(this.repoCli.existeCliente(cpfcli)) {
			if(valor>=0) {
				this.repoCli.getCliente(cpfcli).setDivida(valor);
			}else {
				throw new ValorInvalidoException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	/* ----------------------------------------- */
	
	/* adm */
	
	public void excluirCliente(String cpfcli) throws NaoExisteUsuarioException{
		if(this.repoCli.existeCliente(cpfcli)) {
			this.repoCli.excluirCliente(cpfcli);
		}else{
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void excluirVendedor(String cpfven) throws NaoExisteUsuarioException{
		if(this.repoVend.existeVendedor(cpfven)){
			this.repoVend.excluirVendedor(cpfven);
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void excluirVeterinario(String cpfvet) throws NaoExisteUsuarioException{
		if(this.repoVet.existeVet(cpfvet)) {
			this.repoVet.excluirVet(cpfvet);
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void excluirAmd(String cpfAdm) throws NaoExisteUsuarioException{
		if(this.repoAdm.existeAdm(cpfAdm)) {
			this.repoAdm.excluirAdm(cpfAdm);
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public void adicionarVendedor(Vendedor vend) throws ExisteUsuarioException {
		if(this.repoVend.existeVendedor(vend.getCpf())) {
			 throw new ExisteUsuarioException();
		}else {
			this.repoVend.setVendedores(vend);
		}
	}
	
	public void adicionarVeterinario(Veterinario vet) throws ExisteUsuarioException {
		if(this.repoVet.existeVet(vet.getCpf())) {
			 throw new ExisteUsuarioException();
		}else {
			this.repoVet.setVet(vet);
		}
	}
	
	/* ---------------------------- */
	
	public boolean loginVendedor(String cpf, String senha) throws SenhaIncorretaException,NaoExisteUsuarioException{
		if(repoVend.existeVendedor(cpf)) {
			Vendedor aux = repoVend.getVendedores(cpf);
			if(senha.equals(aux.getSenha())) {
				this.secaoAtiva =true;
				this.tipoUser ="V";
				return true;
			}else {
				throw new SenhaIncorretaException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public boolean loginVeterinario(String cpf, String senha) throws SenhaIncorretaException,NaoExisteUsuarioException{
		if(this.repoVet.existeVet(cpf)) {
			Veterinario aux = this.repoVet.getVet(cpf);
			if(aux.getSenha().equals(senha)) {
				this.secaoAtiva =true;
				this.tipoUser ="VE";
				return true;
			}else {
				throw new SenhaIncorretaException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}
	
	public boolean loginAdm(String cpf, String senha) throws SenhaIncorretaException,NaoExisteUsuarioException{
		if(this.repoAdm.existeAdm(cpf)) {
			Administrador aux = this.repoAdm.getAdministradores(cpf);
			if(aux.getSenha().equals(senha)) {
				this.secaoAtiva =true;
				this.tipoUser ="A";
				return true;
			}else {
				throw new SenhaIncorretaException();
			}
		}else {
			throw new NaoExisteUsuarioException();
		}
	}

}
