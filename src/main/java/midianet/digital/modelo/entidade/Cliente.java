package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "TB_CLIENTE")
@NamedQueries({
	@NamedQuery(name	= "Cliente.obterPorCnpj", 
				query	= "SELECT c FROM Cliente c where c.cnpj = :cnpj"),
				@NamedQuery(name	= "Cliente.listarPorCnpj", 
				query	= "SELECT c FROM Cliente c where c.cnpj like :cnpj order by c.cnpj"),
				@NamedQuery(name	= "Cliente.listarPorRazaoSocial", 
				query	= "SELECT c FROM Cliente c where c.razaoSocial like :razaoSocial order by c.razaoSocial "),
				@NamedQuery(name	= "Cliente.listarPorCnpjERazaoSocial", 
				query	= "SELECT c FROM Cliente c where c.cnpj like :cnpj and c.razaoSocial like :razaoSocial order by c.razaoSocial "),
})
public class Cliente extends PessoaJuridica {
	private static final long serialVersionUID = -6924171354150445030L;

	@Column(name = "PESS_COMPRAS_NOME", nullable = true , length = 60)
	private String responsavelCompras;
	
	@Column(name = "PESS_COMPRAS_NIVER", nullable = true , length = 4)
	private String responsalveComprasAniversario;

	@Column(name = "PESS_FINANCEIRO_NOME", nullable = true , length = 60)
	private String responsavelFinanceiro;
	
	@Column(name = "PESS_SUFRAMA", nullable = true , length = 14)
	private String suframa;
	
	public void setSuframa(final String numero) {
		this.suframa = numero;
	}
	
	public String getSuframa() {
		return suframa;
	}
	
	public String getResponsavelCompras() {
		return responsavelCompras;
	}
	
	public void setResponsavelCompras(final String nome) {
		this.responsavelCompras = nome;
	}
	
	public String getResponsalveComprasAniversario() {
		return responsalveComprasAniversario;
	}
	
	public void setResponsalveComprasAniversario(final String data) {
		this.responsalveComprasAniversario = data;
	}
	
	public String getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}
	
	public void setResponsavelFinanceiro(final String nome) {
		this.responsavelFinanceiro = nome;
	}
	
}
