package midianet.digital.modelo.filtro;

import java.math.BigDecimal;
import java.util.Date;


public class PedidoVendaFiltro{
	
	private Long id;
	private Date dataInicio;
	private Date dataFim;
	private String cnpj;
	private String razaoSocial;
	private BigDecimal totalMinimo;
	private BigDecimal totalMaximo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(final Date data) {
		this.dataInicio = data;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(final Date data) {
		this.dataFim = data;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(final String numero) {
		this.cnpj = numero;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(final String nome) {
		this.razaoSocial = nome;
	}
	
	public BigDecimal getTotalMinimo() {
		return totalMinimo;
	}
	
	public void setTotalMinimo(final BigDecimal valor) {
		this.totalMinimo = valor;
	}
	
	public BigDecimal getTotalMaximo() {
		return totalMaximo;
	}
	
	public void setTotalMaximo(final BigDecimal valor) {
		this.totalMaximo = valor;
	}
	
}
