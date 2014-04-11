package midianet.digital.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CEP")
public class Cep implements Serializable{
	private static final long serialVersionUID = -5051376736352014242L;

	@Id
	@Column(name = "CEP_ID", nullable = false , length = 8 )
	private String cep;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UF_ID")
	private Uf uf;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MUNI_ID")
	private Municipio municipio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BAIR_ID")
	private Bairro bairro;
	
	@Column(name = "CEP_LOGRADOURO")
	private String logradouro;
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(final String cep) {
		this.cep = cep;
	}
	
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(final Uf uf) {
		this.uf = uf;
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
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public boolean equals(final Object objeto) {
		boolean retorno = false;
		
		if(objeto != null && cep != null && this.getClass().equals(objeto.getClass())){
			retorno = cep.compareTo(((Cep)objeto).getCep()) == 0;
		}
		
		return retorno;
		
	}	
	
}