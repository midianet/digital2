
package midianet.digital.visao.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import midianet.digital.modelo.entidade.Bairro;
import midianet.digital.modelo.entidade.Cep;
import midianet.digital.modelo.entidade.Cliente;
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.filtro.PessoaJuridicaFiltro;
import midianet.digital.modelo.negocio.BairroBO;
import midianet.digital.modelo.negocio.CepBO;
import midianet.digital.modelo.negocio.MunicipioBO;
import midianet.digital.modelo.negocio.UfBO;
import midianet.digital.negocio.ClienteAS;
import midianet.framework.excessao.InfraExcessao;
import midianet.framework.excessao.NegocioExcessao;
import midianet.framework.jsf.util.JSFUtil;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {
	private static final long serialVersionUID = -5531505103291071225L;
	
	private Cliente formulario;
	
	private PessoaJuridicaFiltro formularioPesquisa;
	
	private List<Cliente> resultadoPesquisa = null;
	
	private Cliente clienteSelecionado = null;
	
	@ManagedProperty(value = "#{clienteAS}")
	private ClienteAS clienteAS;
	
	@ManagedProperty(value = "#{cepBO}")
	private CepBO cepBO;
	
	@ManagedProperty(value = "#{ufBO}")
	private UfBO ufBO;
	
	@ManagedProperty(value = "#{municipioBO}")
	private MunicipioBO municipioBO;
	
	@ManagedProperty(value = "#{bairroBO}")
	private BairroBO bairroBO;
	
	public void setClienteAS(final ClienteAS as) {
		this.clienteAS = as;
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
	
	@PostConstruct
	public void inicial(){
		novo();
	}
	
	public void setClienteSelecionado(Cliente cliente){
		if(cliente != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			this.formulario =  cliente;
		}
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	
	public List<Cliente> getResultadoPesquisa() {
		
		return resultadoPesquisa;
	}
	
	public void abrirPesquisa(){
		formularioPesquisa = new PessoaJuridicaFiltro();
		if(resultadoPesquisa == null){
			resultadoPesquisa = new ArrayList<Cliente>();
		}
		resultadoPesquisa = new ArrayList<Cliente>();
	}
	
	public void pesquisar(){
		
		try {
			resultadoPesquisa = clienteAS.listarPorFiltro(formularioPesquisa);
		}catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public Cliente getFormulario() {
		return formulario;
	}
	
	public PessoaJuridicaFiltro getFormularioPesquisa() {
		if(formularioPesquisa == null){
			formularioPesquisa = new PessoaJuridicaFiltro();
		}
		return formularioPesquisa;
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
	
	public void novo(){
		formulario = new Cliente();
	}
	
	public void pesquisarCnpj(){
		
		try{
			Cliente cliente = clienteAS.obterPorCnpj(formulario.getCnpj());
			
			if(cliente != null){
				formulario = cliente;
			}
				
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void salvar(){
		try{
			clienteAS.salvar(formulario);
			JSFUtil.adicionarMensagemInformacao("Cliente gravado com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			clienteAS.excluir(formulario);
			JSFUtil.adicionarMensagemInformacao("Cliente excluído com sucesso.");
			novo();
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
	
}