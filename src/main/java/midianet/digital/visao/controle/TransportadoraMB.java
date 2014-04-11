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
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Transportadora;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.negocio.BairroBO;
import midianet.digital.modelo.negocio.BancoBO;
import midianet.digital.modelo.negocio.CepBO;
import midianet.digital.modelo.negocio.MunicipioBO;
import midianet.digital.modelo.negocio.UfBO;
import midianet.digital.negocio.TransportadoraAS;
import midianet.framework.excessao.InfraExcessao;
import midianet.framework.excessao.NegocioExcessao;
import midianet.framework.jsf.util.JSFUtil;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class TransportadoraMB implements Serializable {
	private static final long serialVersionUID = -7077975531349566756L;
	
	private Transportadora formulario = null;
	
	private PessoaJuridicaFiltro formularioPesquisa = null;
	
	private List<Transportadora> resultadoPesquisa = null;
	
	private Transportadora selecionado = null;
	
	@ManagedProperty(value = "#{transportadoraAS}")
	private TransportadoraAS transportadoraAS;
	
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
	
	public void setTransportadoraAS(final TransportadoraAS as) {
		this.transportadoraAS = as;
	}
	
	public void setBancoBO(final BancoBO bo) {
		this.bancoBO = bo;
	}
	
	public void setBairroBO(final BairroBO bo) {
		this.bairroBO = bo;
	}
	
	public void setMunicipioBO(final MunicipioBO bo) {
		this.municipioBO = bo;
	}
	
	public void setCepBO(final CepBO bo) {
		this.cepBO = bo;
	}
	
	public void setUfBO(final UfBO bo) {
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
	
	public void setSelecionado(final Transportadora transportadora){
		if(transportadora != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			this.formulario =  transportadora;
		}
	}
	
	public Transportadora getSelecionado() {
		return selecionado;
	}
	
	public List<Transportadora> getResultadoPesquisa() {
		return resultadoPesquisa;
	}
	
	public void abrirPesquisa(){
		formularioPesquisa = new PessoaJuridicaFiltro();
		resultadoPesquisa = new ArrayList<Transportadora>();
	}
	
	public void pesquisar(){
		
		try {
			resultadoPesquisa = transportadoraAS.listarPorFiltro(formularioPesquisa);
		}catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public Transportadora getFormulario() {
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
		formulario = new Transportadora();
	}
	
	public void pesquisarCnpj(){
		
		try{
			Transportadora transportadora = transportadoraAS.obterPorCnpj(formulario.getCnpj());
			
			if(transportadora != null){
				formulario = transportadora;
			}
			
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void salvar(){
		try{
			transportadoraAS.salvar(formulario);
			JSFUtil.adicionarMensagemInformacao("Transportadora gravada com sucesso.");
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
			transportadoraAS.excluir(formulario);
			JSFUtil.adicionarMensagemInformacao("Transportadora excluída com sucesso.");
			novo();
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}