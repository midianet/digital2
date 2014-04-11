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
@Table(name = "TB_MUNICIPIO")
@SequenceGenerator(	name 			= "seqMunicipio", 
					sequenceName	= "SQ_MUNI_ID")
@NamedQueries({
	@NamedQuery(name	= "Municipio.listarPorUf", 
				query	= "SELECT m FROM Municipio m where m.uf = :uf order by m.nome"),
	@NamedQuery(name	= "Municipio.obterPorUfENome", 
				query	= "SELECT m FROM Municipio m where m.uf = :uf and m.nome = :nome")
})
public class Municipio extends Entidade<Long> {
	
	private static final long serialVersionUID = 1724330977692464362L;
	
	@Id
	@GeneratedValue(generator = "seqMunicipio")
	@Column(name = "MUNI_ID")
	private Long id;
	
	@Column(name = "MUNI_NOME",length = 60 , nullable = false )
	private String nome;

	@Column(name = "MUNI_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UF_ID")
	private Uf uf;
	
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
	
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(final Uf uf) {
		this.uf = uf;
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
			retorno = id.compareTo(((Municipio)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}