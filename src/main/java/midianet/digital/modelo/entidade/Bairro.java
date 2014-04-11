package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import midianet.framework.persistencia.entidade.Entidade;

@Entity
@Table(name = "TB_BAIRRO")
@SequenceGenerator(	name 			= "seqBairro", 
					sequenceName	= "SQ_BAIR_ID")
@NamedQueries({
	@NamedQuery(name	= "Bairro.listarPorMunicipio", 
				query	= "SELECT b FROM Bairro b where b.municipio = :municipio order by b.nome"),
	@NamedQuery(name	= "Bairro.obterPorMunicipioeNome", 
				query	= "SELECT b FROM Bairro b where b.municipio = :municipio and b.nome = :nome")
})
public class Bairro extends Entidade<Long> {
	
	private static final long serialVersionUID = 1724330977692464362L;
	
	@Id
	@GeneratedValue(generator = "seqBairro")
	@Column(name = "BAIR_ID")
	private Long id;
	
	@Column(name = "BAIR_NOME",length = 60 , nullable = false )
	private String nome;

	@Column(name = "BAIR_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MUNI_ID")
	private Municipio municipio;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(final Municipio municipio) {
		this.municipio = municipio;
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
			retorno = id.compareTo(((Bairro)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}