package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import midianet.framework.persistencia.entidade.Entidade;

@Entity
@Table(name = "TB_PRODUTO_UNIDADE")
@SequenceGenerator(	name 			= "seqProdUnidade", 
					sequenceName	= "SQ_PRUN_ID")

@NamedQueries({
	@NamedQuery(name	= "UnidadeMedida.listarTodas", 
				query	= "SELECT u FROM UnidadeMedida u order by u.nome")
})
public class UnidadeMedida extends Entidade<Long> {
	private static final long serialVersionUID = 7759841236140347037L;
	
	@Id
	@GeneratedValue(generator = "seqProdUnidade")
	@Column(name = "PRUN_ID")
	private Long id;
	
	@Column(name = "PRUN_NOME",length = 60 , nullable = false )
	private String nome;

	@Column(name = "PRUN_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
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
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean equals(final Object objeto) {
		boolean retorno = false;
		
		if(objeto != null && id != null && this.getClass().equals(objeto.getClass())){
			retorno = id.compareTo(((UnidadeMedida)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}