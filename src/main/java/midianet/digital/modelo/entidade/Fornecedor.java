package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FORNECEDOR")
@NamedQueries({
	@NamedQuery(name	= "Fornecedor.obterPorCnpj", 
				query	= "SELECT f FROM Fornecedor f where f.cnpj = :cnpj"),
				@NamedQuery(name	= "Fornecedor.listarPorCnpj", 
				query	= "SELECT f FROM Fornecedor f where f.cnpj like :cnpj order by f.cnpj"),
				@NamedQuery(name	= "Fornecedor.listarPorRazaoSocial", 
				query	= "SELECT f FROM Fornecedor f where f.razaoSocial like :razaoSocial order by f.razaoSocial "),
				@NamedQuery(name	= "Fornecedor.listarPorCnpjERazaoSocial", 
				query	= "SELECT f FROM Fornecedor f where f.cnpj like :cnpj and f.razaoSocial like :razaoSocial order by f.razaoSocial "),
})
public class Fornecedor extends PessoaJuridica {
	private static final long serialVersionUID = 2261543255930418357L;
	
	@Column(name = "PESS_VENDEDOR", nullable = true , length = 60)
	private String vendedor;
	
	@Column(name = "PESS_FINANCEIRO", nullable = true , length = 60)
	private String financeiro;
	
	@ManyToOne
	@JoinColumn(name = "BANC_ID_CPRIM")
	private Banco contaPrimarioBanco;
	
	@Column(name = "PESS_CPRIM_AGENCIA", nullable = true)
	private String contaPrimariaAgencia;
	
	@Column(name = "PESS_CPRIM_NUMERO", nullable = true)
	private String contaPrimariaNumero;
	
	@Column(name = "PESS_CPRIM_FAVORECIDO", length = 60, nullable = true)
	private String contaPrimariaFavorecido;
	
	@ManyToOne
	@JoinColumn(name = "BANC_ID_CSECUM", nullable = true)
	private Banco contaSecundariaBanco;
	
	@Column(name = "PESS_CSECU_AGENCIA", nullable = true)
	private String contaSecundariaAgencia;
	
	@Column(name = "PESS_CSECU_NUMERO", nullable = true)
	private String contaSecundariaNumero;
	
	@Column(name = "PESS_CSECU_FAVORECIDO", length = 60, nullable = true)
	private String contaSecundariaFavorecido;
	
	public String getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(final String nome) {
		this.vendedor = nome;
	}
	
	public String getFinanceiro() {
		return financeiro;
	}
	
	public void setFinanceiro(final String nome) {
		this.financeiro = nome;
	}
	
	public Banco getContaPrimarioBanco() {
		return contaPrimarioBanco;
	}
	
	public void setContaPrimarioBanco(Banco banco) {
		this.contaPrimarioBanco = banco;
	}
	
	public String getContaPrimariaAgencia() {
		return contaPrimariaAgencia;
	}
	
	public void setContaPrimariaAgencia(final String numero) {
		this.contaPrimariaAgencia = numero;
	}
	
	public String getContaPrimariaNumero() {
		return contaPrimariaNumero;
	}
	
	public void setContaPrimariaNumero(final String numero) {
		this.contaPrimariaNumero = numero;
	}
	
	public String getContaPrimariaFavorecido() {
		return contaPrimariaFavorecido;
	}
	
	public void setContaPrimariaFavorecido(final String favorecido) {
		this.contaPrimariaFavorecido = favorecido;
	}
	
	public Banco getContaSecundariaBanco() {
		return contaSecundariaBanco;
	}
	
	public void setContaSecundariaBanco(final Banco banco) {
		this.contaSecundariaBanco = banco;
	}
	
	public String getContaSecundariaAgencia() {
		return contaSecundariaAgencia;
	}
	
	public void setContaSecundariaAgencia(final String numero) {
		this.contaSecundariaAgencia = numero;
	}
	
	public String getContaSecundariaNumero() {
		return contaSecundariaNumero;
	}
	
	public void setContaSecundariaNumero(final String numero) {
		this.contaSecundariaNumero = numero;
	}
	
	public String getContaSecundariaFavorecido() {
		return contaSecundariaFavorecido;
	}
	
	public void setContaSecundariaFavorecido(final String favorecido) {
		this.contaSecundariaFavorecido = favorecido;
	}
	
}