package midianet.digital.modelo.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_PEDIDO_VENDA_ITEM")
@SequenceGenerator(name = "seqPedidoVendaItem", sequenceName = "SQ_PEDIDO_VENDA_ITEM_ID")
public class PedidoVendaItem implements Serializable {
	private static final long serialVersionUID = 4514151981870499885L;
	
	@Id
	@GeneratedValue(generator = "seqPedidoVendaItem")
	@Column(name = "PVIT_ID")
	private Long id;
	
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "PROD_ID", nullable = false)
	private Produto produto;
	
	//@NotNull
	@Column(name = "PVIT_QUANTIDADE")
	private BigDecimal quantidade;
	
	//@NotNull
	@Column(name = "PVIT_VALOR_UNITARIO")
	private BigDecimal valorUnitario;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(final Produto produto) {
		this.produto = produto;
	}
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(final BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public void setValorUnitario(final BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	@Transient
	public Double getSubTotal(){
		Double retorno = 0.0;
		
		if(valorUnitario != null && quantidade != null ){
			retorno = valorUnitario.multiply(quantidade).doubleValue();
		}
		
		return retorno;
	}
}