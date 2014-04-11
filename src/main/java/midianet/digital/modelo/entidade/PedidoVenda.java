package midianet.digital.modelo.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import midianet.framework.persistencia.entidade.Entidade;

import org.hibernate.validator.NotEmpty;


@Entity
@Table(name = "TB_PEDIDO_VENDA")
//@NamedQueries({
//	@NamedQuery(name	= "Cliente.obterPorCnpj", 
//				query	= "SELECT c FROM Cliente c where c.cnpj = :cnpj"),
//				@NamedQuery(name	= "Cliente.listarPorCnpj", 
//				query	= "SELECT c FROM Cliente c where c.cnpj like :cnpj order by c.cnpj"),
//				@NamedQuery(name	= "Cliente.listarPorRazaoSocial", 
//				query	= "SELECT c FROM Cliente c where c.razaoSocial like :razaoSocial order by c.razaoSocial "),
//				@NamedQuery(name	= "Cliente.listarPorCnpjERazaoSocial", 
//				query	= "SELECT c FROM Cliente c where c.cnpj like :cnpj and c.razaoSocial like :razaoSocial order by c.razaoSocial "),
//})
@SequenceGenerator(name = "seqPedidoVenda", sequenceName = "SQ_PEDIDO_VENDA_ID")
public class PedidoVenda extends Entidade<Long> {
	
	private static final long serialVersionUID = -6681362166617476688L;

	@Id
	@GeneratedValue(generator = "seqPedidoVenda")
	@Column(name = "PDVE_ID")
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PDVE_DATA_EMISSAO", nullable = false)
	private Date dataEmissao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PESS_ID_CLIENTE", nullable = false)
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PESS_ID_VENDEDOR", nullable = false)
	private Vendedor vendedor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "PESS_ID_TRANSPORTADORA", nullable = false)
	private Transportadora transportadora;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "FOPG_ID", nullable = false)
	private FormaPagamento formaPagamento;
	
	@Column(name = "PDVE_OBSERVACAO",nullable = true, length = 255)
	private String observacao;
	
	@Column(name = "PDVE_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true; 
	
	@Size(min =  1, max = 990)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="PDVE_ID")
	@NotEmpty
	private List<PedidoVendaItem> itens;
	
	public Double getTotal(){
		Double retorno = 0.0;
		
		if(itens != null && itens.size() > 0){
			for(final PedidoVendaItem item  : itens){
				retorno += item.getSubTotal();
			}
		}
		
		return retorno;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(final Date data) {
		this.dataEmissao = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(final Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(final FormaPagamento forma) {
		this.formaPagamento = forma;
	}
	
	public Transportadora getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(final Transportadora transportadora) {
		this.transportadora = transportadora;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}
	
	public List<PedidoVendaItem> getItens() {
		
		if(itens == null){
			itens = new ArrayList<PedidoVendaItem>();
		}
		
		return itens;
	}
	
	public void setItens(final List<PedidoVendaItem> itens) {
		this.itens = itens;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean equals(final Object objeto) {
		boolean retorno = false;
		
		if(objeto != null && id != null && this.getClass().equals(objeto.getClass())){
			retorno = id.compareTo(((PedidoVenda)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}		
	
}
