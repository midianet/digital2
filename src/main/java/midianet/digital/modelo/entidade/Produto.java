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
import javax.validation.constraints.NotNull;

import midianet.framework.persistencia.entidade.Entidade;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(	name 			= "seqProduto", 
					sequenceName	= "SQ_PROD_ID")

@NamedQueries({
	@NamedQuery(name	= "Produto.listarPorCodigoENome", 
				query	= "SELECT p FROM Produto p join fetch p.grupo join fetch p.unidadeMedida where p.codigo like :codigo and p.nome like :nome order by p.nome"),
	@NamedQuery(name	= "Produto.listarPorCodigo", 
				query	= "SELECT p FROM Produto p join fetch p.grupo join fetch p.unidadeMedida where p.codigo like :codigo order by p.codigo"),
	@NamedQuery(name	= "Produto.listarPorNome", 
				query	= "SELECT p FROM Produto p join fetch p.grupo join fetch p.unidadeMedida where p.nome like :nome order by p.nome"),
	@NamedQuery(name	= "Produto.obterPorCodigo", 
				query	= "SELECT p FROM Produto p join fetch p.grupo join fetch p.unidadeMedida where p.codigo = :codigo")
})
public class Produto extends Entidade<Long> {
	
	private static final long serialVersionUID = 1724330977692464362L;
	
	@Id
	@GeneratedValue(generator = "seqProduto")
	@Column(name = "PROD_ID")
	private Long id;
	
	@NotBlank
	@Column(name = "PROD_CODIGO",length = 19 , nullable = false, unique = true )
	private String codigo;
	
	@NotBlank
	@Column(name = "PROD_NOME",length = 60 , nullable = false )
	private String nome;
	
	@Column(name = "PROD_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
//	@Column(name = "PROD_IMAGEM")
//	private String imagem;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRGR_ID")
	private GrupoProduto grupo;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRUN_ID")
	private UnidadeMedida unidadeMedida;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public GrupoProduto getGrupo() {
		return grupo;
	}
	
	public void setGrupo(final GrupoProduto grupo) {
		this.grupo = grupo;
	}
	
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public void setUnidadeMedida(final UnidadeMedida unidade) {
		this.unidadeMedida = unidade;
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
			retorno = id.compareTo(((Produto)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}