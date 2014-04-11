package midianet.digital.visao.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import midianet.digital.modelo.entidade.GrupoProduto;
import midianet.digital.modelo.entidade.Produto;
import midianet.digital.modelo.entidade.UnidadeMedida;
import midianet.digital.modelo.filtro.ProdutoFiltro;
import midianet.digital.modelo.negocio.GrupoProdutoBO;
import midianet.digital.modelo.negocio.UnidadeMedidaBO;
import midianet.digital.negocio.ProdutoAS;
import midianet.framework.excessao.InfraExcessao;
import midianet.framework.jsf.util.JSFUtil;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;



@ManagedBean
@ViewScoped
public class ProdutoMB implements Serializable {
	private static final long serialVersionUID = -5531505103291071225L;
	
	private Produto formulario = null;
	
	private ProdutoFiltro formularioPesquisa = null;
	
	private List<Produto> resultadoPesquisa = null;
	
	private Produto selecionado = null;
	
	@ManagedProperty(value = "#{produtoAS}")
	private ProdutoAS produtoAS;
	
	@ManagedProperty(value = "#{grupoProdutoBO}")
	private GrupoProdutoBO grupoProdutoBO;
	
	@ManagedProperty(value = "#{unidadeMedidaBO}")
	private UnidadeMedidaBO unidadeMedidaBO;
	
	private UploadedFile arquivoTemporario = null;
	
	public String getImagem() {
		
		if(arquivoTemporario != null){
			return "/imgprd?nomeArquivo=memoria";
		}else if(formulario != null && formulario.getId() != null){
			return "/imgprd?nomeArquivo=" + produtoAS.obterNomeArquivo(formulario.getId().toString());
		}else{
			return "/imgprd?nomeArquivo=XXX";
		}
		
	}
	
	public void setProdutoAS(final ProdutoAS as) {
		this.produtoAS = as;
	}
	
	public void setGrupoProdutoBO(final GrupoProdutoBO bo) {
		this.grupoProdutoBO = bo;
	}
	
	public void setUnidadeMedidaBO(final UnidadeMedidaBO bo) {
		this.unidadeMedidaBO = bo;
	}
	
	@PostConstruct
	public void inicial(){
		novo();
	}
	
	public void setSelecionado(final Produto produto){
		if(produto != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			this.formulario =  produto;
		}
	}
	
	public Produto getSelecionado() {
		return selecionado;
	}
	
	public List<Produto> getResultadoPesquisa() {
		
		return resultadoPesquisa;
	}
	
	public void abrirPesquisa(){
		formularioPesquisa = new ProdutoFiltro();
		resultadoPesquisa = new ArrayList<Produto>();
	}
	
	public void pesquisar(){
		
		try {
			resultadoPesquisa = produtoAS.listarPorFiltro(formularioPesquisa);
		}catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public Produto getFormulario() {
		return formulario;
	}
	
	public ProdutoFiltro getFormularioPesquisa() {
		if(formularioPesquisa == null){
			formularioPesquisa = new ProdutoFiltro();
		}
		return formularioPesquisa;
	}
	
	public List<UnidadeMedida> getListaUnidades(){
		List<UnidadeMedida> retorno = null;
		try {
			retorno = unidadeMedidaBO.listarTodas();
		} catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
	}
	
	public List<GrupoProduto> getListaGrupos(){
		List<GrupoProduto> retorno = null;
		
		try{
			retorno = grupoProdutoBO.listarTodos();
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

		
		return retorno;
	}
	
	public void novo(){
		formulario = new Produto();
		arquivoTemporario = null;
	}
	
	public void pesquisarCodigo(){
		
		try{
			Produto produto = produtoAS.obterPorCodigo(formulario.getCodigo());
			
			if(produto != null){
				formulario = produto;
			}
				
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void salvar(){
		try{
			produtoAS.salvar(formulario, arquivoTemporario);
			arquivoTemporario = null;
			JSFUtil.adicionarMensagemInformacao("Produto gravado com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			produtoAS.excluir(formulario);
			JSFUtil.adicionarMensagemInformacao("Produto excluído com sucesso.");
			novo();
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void upload(final FileUploadEvent event) {
		 arquivoTemporario = event.getFile(); //org.primefaces.model.DefaultUploadedFile
		 
		 ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("upload",arquivoTemporario);
		 
	}
	
}