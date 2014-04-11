package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import midianet.digital.modelo.validador.Cep;
import midianet.framework.persistencia.entidade.Entidade;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_PESSOA")
@SequenceGenerator(name = "seqPessoa", sequenceName = "SQ_PESS_ID")
public abstract class Pessoa extends Entidade<Long>{
	private static final long serialVersionUID = 1651061550864088624L;
	
	@Id
	@GeneratedValue(generator = "seqPessoa")
	@Column(name = "PESS_ID")
	private Long id;
	
	@Email
	@NotBlank
	@Column(name = "PESS_EMAIL", nullable = true, length = 60)
	private String email;
	 
	@Cep
	@NotBlank
	@Column(name = "CEP_ID", nullable = false , length = 8 )
	private String cep;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "UFED_ID", nullable = false)
	private Uf uf;
	
	@NotBlank
	@Column(name = "PESS_ENDERECO", nullable = false, length = 120)
	private String logradouro;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "MUNI_ID",nullable = false)
	private Municipio municipio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "BAIR_ID",nullable = false)
	private Bairro bairro;
	
	@NotBlank
	@Column(name = "PESS_NUMERO",nullable = false, length = 25)
	private String numero;
	
	@Column(name = "PESS_COMPLEMENTO",nullable = true, length = 60)
	private String complemento;
	
	@NotBlank
	@Column(name = "PESS_FONE",nullable = true, length = 20)
	private String telefone;
	
	@Column(name = "PESS_FONE_COMERCIAL",nullable = true, length = 20)
	private String telefoneComercial;
	
	@NotBlank
	@Column(name = "PESS_OBSERVACAO",nullable = true, length = 255)
	private String observacao;
	
	@Column(name = "PESS_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true; 
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(final String numero) {
		this.cep = numero;
	}
	
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(final Uf uf) {
		this.uf = uf;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(final Municipio municipio) {
		this.municipio = municipio;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	
	public void setBairro(final Bairro bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(final String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(final String numero) {
		this.telefone = numero;
	}
	
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	
	public void setTelefoneComercial(final String numero) {
		this.telefoneComercial = numero;
	}
	
	public void setObservacao(final String observacao) {
		this.observacao = observacao;
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
			retorno = id.compareTo(((Pessoa)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}	
	
}