package midianet.digital.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
@Table(name = "TB_PESSOA_FISICA")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = -9011608570587926400L;
	
	@Column(name = "PESS_CPF", nullable = false , length = 11) 
	private String cpf;
	
	@Column(name = "PESS_NOME", nullable = false, length = 80)
	private String nome;
	
	@Column(name = "PESS_RG", nullable = false , length = 10) 
	private String rg;

	@Column(name = "PESS_RG_EMISS", nullable = false , length = 15) 
	private String rgEmissor;	
	
	@Past
	@Temporal(TemporalType.DATE )
	private Date dataNascimento;
	
	@Column(name = "PESS_FONE_CELULAR",nullable = true, length = 15)
	private String telefoneCelular;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCPF(final String numero) {
		cpf = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(final String numero) {
		this.rg = numero;
	}
	
	public String getRgEmissor() {
		return rgEmissor;
	}
	
	public void setRgEmissor(final String emissor) {
		this.rgEmissor = emissor;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(final Date data) {
		this.dataNascimento = data;
	}
	
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	
	public void setTelefoneCelular(final String numero) {
		this.telefoneCelular = numero;
	}
	
}