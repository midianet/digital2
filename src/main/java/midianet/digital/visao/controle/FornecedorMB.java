package midianet.digital.visao.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import midianet.digital.modelo.entidade.Bairro;
import midianet.digital.modelo.entidade.Banco;
import midianet.digital.modelo.entidade.Cep;
import midianet.digital.modelo.entidade.Fornecedor;
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.negocio.BairroBO;
import midianet.digital.modelo.negocio.BancoBO;
import midianet.digital.modelo.negocio.CepBO;
import midianet.digital.modelo.negocio.MunicipioBO;
import midianet.digital.modelo.negocio.UfBO;
import midianet.digital.negocio.FornecedorAS;
import midianet.framework.excessao.InfraExcessao;
import midianet.framework.excessao.NegocioExcessao;
import midianet.framework.jsf.util.JSFUtil;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class FornecedorMB implements Serializable {
	private static final long serialVersionUID = -7077975531349566756L;
	
	private Fornecedor formulario = null;
	
	private PessoaJuridicaFiltro formularioPesquisa = null;
	
	private List<Fornecedor> resultadoPesquisa = null;
	
	private Fornecedor selecionado = null;
	
	@ManagedProperty(value = "#{fornecedorAS}")
	private FornecedorAS fornecedorAS;
	
	@ManagedProperty(value = "#{bancoBO}")
	private BancoBO bancoBO;
	
	@ManagedProperty(value = "#{cepBO}")
	private CepBO cepBO;
	
	@ManagedProperty(value = "#{ufBO}")
	private UfBO ufBO;
	
	@ManagedProperty(value = "#{municipioBO}")
	private MunicipioBO municipioBO;
	
	@ManagedProperty(value = "#{bairroBO}")
	private BairroBO bairroBO;
	
	public void setFornecedorAS(final FornecedorAS as) {
		this.fornecedorAS = as;
	}
	
	public void setBancoBO(final BancoBO bo) {
		this.bancoBO = bo;
	}
	
	public void setBairroBO(BairroBO bo) {
		this.bairroBO = bo;
	}
	
	public void setMunicipioBO(MunicipioBO bo) {
		this.municipioBO = bo;
	}
	
	public void setCepBO(CepBO bo) {
		this.cepBO = bo;
	}
	
	public void setUfBO(UfBO bo) {
		this.ufBO = bo;
	}
	
	public List<Uf> getListaUfs(){
		List<Uf> retorno = null;
		try {
			retorno = ufBO.listarTodos();//clienteAS.listarTodosUf();
		} catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
	}
	
	public List<Municipio> getListaMunicipios(){
		List<Municipio> retorno = null;
		
		if(formulario.getUf() != null){
			try{
				retorno = municipioBO.listarPorUf(formulario.getUf());
			}catch(final NegocioExcessao e){
				JSFUtil.adicionarMensagemAlterta(e.getMessage());
			}catch(final InfraExcessao e){
				JSFUtil.adicionarMensagemErro(e.getMessage());
			}
		}
		
		return retorno;
	}
	
	public List<Bairro> getListaBairros(){
		List<Bairro> retorno = null;
		
		if(formulario.getMunicipio() != null){
			try{
				retorno = bairroBO.listarMunicipio(formulario.getMunicipio());
			}catch(final NegocioExcessao e){
				JSFUtil.adicionarMensagemAlterta(e.getMessage());
			}catch(final InfraExcessao e){
				JSFUtil.adicionarMensagemErro(e.getMessage());
			}
		}
		
		return retorno;
	}
	
	@PostConstruct
	public void inicial(){
		novo();
	}
	
	public void setSelecionado(final Fornecedor fornecedor){
		if(fornecedor != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			this.formulario =  fornecedor;
		}
	}
	
	public Fornecedor getSelecionado() {
		return selecionado;
	}
	
	public List<Fornecedor> getResultadoPesquisa() {
		return resultadoPesquisa;
	}
	
	public void abrirPesquisa(){
		formularioPesquisa = new PessoaJuridicaFiltro();
		resultadoPesquisa = new ArrayList<Fornecedor>();
	}
	
	public void pesquisar(){
		
		try {
			resultadoPesquisa = fornecedorAS.listarPorFiltro(formularioPesquisa);
		}catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public Fornecedor getFormulario() {
		return formulario;
	}
	
	public PessoaJuridicaFiltro getFormularioPesquisa() {
		if(formularioPesquisa == null){
			formularioPesquisa = new PessoaJuridicaFiltro();
		}
		return formularioPesquisa;
	}
	
	public List<Banco> getListaBancos(){
		List<Banco> retorno = null;
		try {
			retorno = bancoBO.listarTodos();
		} catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
	}
	
	public void novo(){
		formulario = new Fornecedor();
	}
	
	public void pesquisarCnpj(){
		
		try{
			Fornecedor fornecedor = fornecedorAS.obterPorCnpj(formulario.getCnpj());
			
			if(fornecedor != null){
				formulario = fornecedor;
			}
			
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void salvar(){
		try{
			fornecedorAS.salvar(formulario);
			JSFUtil.adicionarMensagemInformacao("Fornecedor gravado com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void preencherEndereco(){
		formulario.setUf(null);
		formulario.setMunicipio(null);
		formulario.setLogradouro(null);
		formulario.setBairro(null);
		
		if(formulario.getCep() != null && !formulario.getCep().trim().isEmpty()){
			
			try{
				Cep cep = null;
				cep = cepBO.obterPorCep(formulario.getCep());
				
				if(cep != null){
					formulario.setUf(cep.getUf());
					formulario.setMunicipio(cep.getMunicipio());
					formulario.setBairro(cep.getBairro());
					formulario.setLogradouro(cep.getLogradouro());
				}
				
			}catch(final NegocioExcessao e){
				JSFUtil.adicionarMensagemAlterta(e.getMessage());
			}catch(final InfraExcessao e){
				JSFUtil.adicionarMensagemErro(e.getMessage());
			}
			
		}
		
	}
	
	public void excluir(){
		try{
			fornecedorAS.excluir(formulario);
			JSFUtil.adicionarMensagemInformacao("Fornecedor excluído com sucesso.");
			novo();
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}