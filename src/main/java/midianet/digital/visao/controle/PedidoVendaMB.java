package midianet.digital.visao.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import midianet.digital.modelo.entidade.Cliente;
import midianet.digital.modelo.entidade.FormaPagamento;
import midianet.digital.modelo.entidade.PedidoVenda;
import midianet.digital.modelo.entidade.PedidoVendaItem;
import midianet.digital.modelo.entidade.Produto;
import midianet.digital.modelo.entidade.Transportadora;
import midianet.digital.modelo.entidade.UnidadeMedida;
import midianet.digital.modelo.entidade.Vendedor;
import midianet.digital.modelo.filtro.PedidoVendaFiltro;
import midianet.digital.modelo.filtro.ProdutoFiltro;
import midianet.digital.modelo.negocio.FormaPagamentoBO;
import midianet.digital.modelo.negocio.VendedorBO;
import midianet.digital.negocio.ClienteAS;
import midianet.digital.negocio.PedidoVendaAS;
import midianet.digital.negocio.ProdutoAS;
import midianet.digital.negocio.TransportadoraAS;
import midianet.framework.excessao.InfraExcessao;
import midianet.framework.jsf.util.JSFUtil;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class PedidoVendaMB implements Serializable {
	private static final long serialVersionUID = -5531505103291071225L;
	
	private PedidoVenda 	formulario 				  = null;
	private PedidoVendaFiltro formularioPesquisaPedido = null;
	private ProdutoFiltro	formularioPesquisaProduto = null;
	private PedidoVendaItem	formularioItem		= null;

	
	private List<PedidoVenda> resultadoPesquisaPedido = null;
	private List<PedidoVendaItem> resultadoPesquisaProduto = null;
	
	private boolean pedidoNovo = false;
	
	@ManagedProperty(value = "#{vendedorBO}")
	private VendedorBO vendedorBO;
	
	@ManagedProperty(value = "#{formaPagamentoBO}")
	private FormaPagamentoBO formaPagamentoBO;
	
	@ManagedProperty(value = "#{transportadoraAS}")
	private TransportadoraAS transportadoraAS;
	
	@ManagedProperty(value = "#{pedidoVendaAS}")
	private PedidoVendaAS  pedidoVendaAS;
	
	@ManagedProperty(value = "#{clienteAS}")
	private ClienteAS clienteAS;
	
	@ManagedProperty(value = "#{produtoAS}")
	private ProdutoAS produtoAS;
	
	public void setTransportadoraAS(final TransportadoraAS as) {
		this.transportadoraAS = as;
	}
	
	public void setPedidoVendaAS(final PedidoVendaAS as){
		this.pedidoVendaAS = as;
	}
	
	public void setProdutoAS(final ProdutoAS as) {
		this.produtoAS = as;
	}
	
	public void setClienteAS(final ClienteAS as) {
		this.clienteAS = as;
	}
	
	public void setVendedorBO(final VendedorBO bo) {
		this.vendedorBO = bo;
	}
	
	public void setFormaPagamentoBO(final FormaPagamentoBO bo) {
		this.formaPagamentoBO = bo;
	}
	
	@PostConstruct
	public void inicial(){
		novo();
	}
	
	public boolean ePedidoNovo(){
		return pedidoNovo;
	}
	
	public void buscarPedido(){
		try{
			PedidoVenda pedido = pedidoVendaAS.obterPedidoVendaPorId(formulario.getId());
			
			if(pedido != null){
				formulario = pedido;
				pedidoNovo = true;
			}else{
				novo();
			}
			
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void pesquisarPedido(){
		
	}
	
	public void pesquisarCnpj(){
		
		try{
			Cliente cliente = clienteAS.obterPorCnpj(formulario.getCliente().getCnpj());
			
			if(cliente != null){
				formulario.setCliente(cliente);
			}else{
				formulario.setCliente(new Cliente());
			}
			
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void addItemPedido(){
		formulario.getItens().add(formularioItem);
		
		formularioItem = new PedidoVendaItem();
		formularioItem.setProduto(new Produto());
		formularioItem.getProduto().setUnidadeMedida(new UnidadeMedida());
	}
	
	public void removeItemPedido(ActionEvent evento) {
		
		final PedidoVendaItem item =(PedidoVendaItem) evento.getComponent().getAttributes().get("item");
		
		if(item != null){
			formulario.getItens().remove(item);
		}
	}
	
	public void pesquisarProduto(){
		
		try{
			Produto produto = produtoAS.obterPorCodigo(formularioItem.getProduto().getCodigo());
			
			formularioItem.setQuantidade(null);
			formularioItem.setValorUnitario(null);
			
			if(produto != null){
				formularioItem.setProduto(produto);

			}else{
				formularioItem.setProduto(new Produto());
			}
			
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void setProdutoSelecionado(final Produto produto){
		
		if(formularioItem != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			formularioItem.setProduto(produto);
			formularioItem.setQuantidade(null);
			formularioItem.setValorUnitario(null);
		}
		
	}
	
	public Produto getProdutoSelecionado() {
		
		Produto retorno = null;
		
		if(formularioItem != null){
			retorno = formularioItem.getProduto();
			
		}
		
		return retorno;
		
	}
	
	public Cliente getClienteSelecionado() {
		
		Cliente retorno = null;
		
		if(formulario != null){
			retorno = formulario.getCliente();
		}
		
		return retorno;
	}
	
	public boolean podeAddProduto(){
		boolean retorno = false;
		
		if(formularioItem != null && formularioItem.getQuantidade() != null && formularioItem.getValorUnitario() != null ){
			retorno = formularioItem.getQuantidade().longValue() > 0 && formularioItem.getValorUnitario().longValue() > 0;
		}
		
		return retorno;
	}
	
	public void setClienteSelecionado(final Cliente cliente) {
		
		if(formulario != null){
			RequestContext.getCurrentInstance().reset("frCadastro");
			formulario.setCliente(cliente);
		}
	}
	
	public List<PedidoVendaItem> getResultadoPesquisaProduto() {
		
		return resultadoPesquisaProduto;
	}
	
	public void abrirPesquisaPedido(){
		formularioPesquisaPedido = new PedidoVendaFiltro();
		resultadoPesquisaPedido = new ArrayList<PedidoVenda>();
	}
	public void abrirPesquisaProduto(){
		formularioPesquisaProduto = new ProdutoFiltro();
		resultadoPesquisaProduto = new ArrayList<PedidoVendaItem>();
	}
	
	public PedidoVenda getFormulario() {
		return formulario;
	}
	
	public PedidoVendaItem getFormularioItem(){
		return formularioItem;
	}
	
	public ProdutoFiltro getFormularioPesquisaProduto() {
		if(formularioPesquisaProduto == null){
			formularioPesquisaProduto = new ProdutoFiltro();
		}
		return formularioPesquisaProduto;
	}
	
	public List<FormaPagamento> getListaFormasPagamento(){
		List<FormaPagamento> retorno = null;
		
		try {
			retorno = formaPagamentoBO.listarTodos();
		} catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
		
	}
	
	public List<Transportadora> getListaTransportadoras(){
		List<Transportadora> retorno = null;
		
		try {
			retorno = transportadoraAS.listarTodos();
		} catch (final InfraExcessao e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
		
	}
	
	public List<Vendedor> getListaVendedores(){
		List<Vendedor> retorno = null;
		
		try{
			retorno = vendedorBO.listarTodos();
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
		return retorno;
	}
	
	public void novo(){
		pedidoNovo = true;
		
		formulario = new PedidoVenda();
		formulario.setDataEmissao(new Date());
		formulario.setCliente(new Cliente());
		formulario.setItens(new ArrayList<PedidoVendaItem>());
		
		formularioItem	= new PedidoVendaItem();
		formularioItem.setProduto(new Produto());
		formularioItem.getProduto().setUnidadeMedida(new UnidadeMedida());
		
	}
	
	public void salvar(final ActionEvent actionEvent){
		
		try{
			pedidoVendaAS.salvar(formulario);
			pedidoNovo = false;
			JSFUtil.adicionarMensagemInformacao("Pedido gravado com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	public void salvar(){
		try{
			
			if(formulario.getId() == 0){
				formulario.setId(null);
			}
			
			pedidoVendaAS.salvar(formulario);
			pedidoNovo = false;
			JSFUtil.adicionarMensagemInformacao("Pedido gravado com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir(){
		try{
			pedidoVendaAS.excluir(formulario);
			novo();
			JSFUtil.adicionarMensagemInformacao("Produto excluído com sucesso.");
		}catch(final InfraExcessao e){
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
}