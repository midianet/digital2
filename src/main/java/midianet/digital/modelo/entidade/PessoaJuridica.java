package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "TB_PESSOA_JURIDICA")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaJuridica extends Pessoa{
	
	private static final long serialVersionUID = 6196533962758821088L;
	
	@CNPJ
	@NotBlank
	@Column(name = "PESS_CNPJ", nullable = false , length = 14)// TODO: Acrescentar depois, unique = true)
	private String cnpj;
	
	@NotBlank
	@Column(name = "PESS_RAZAO", nullable = false , length = 80)
	private String razaoSocial;
	
	@NotBlank
	@Column(name = "PESS_FANTASIA", nullable = false, length = 80)
	private String fantasia;
	
	@NotBlank
	@Column(name = "PESS_INSCRICAO", nullable = true , length = 30)
	private String inscricaoEstadual;
	
	@Column(name = "PESS_FONE_FAX",nullable = true, length = 20)
	private String fax;
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(final String numero) {
		cnpj = numero;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(final String nome) {
		this.razaoSocial = nome;
	}
	
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(final String nome) {
		this.fantasia = nome;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(final String numero) {
		this.inscricaoEstadual = numero;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(final String numero) {
		this.fax = numero;
	}
	
}