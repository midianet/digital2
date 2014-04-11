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
@Table(name = "TB_BANCO")
@SequenceGenerator(	name 			= "seqBanco", sequenceName	= "SQ_BANC_ID")
@NamedQueries({@NamedQuery( name	= "Banco.listarTodos", 
							query	= "SELECT b FROM Banco b order by b.nome")
})
public class Banco extends Entidade<Long> {
	private static final long serialVersionUID = 6519444269674332339L;
	
	@Id
	@GeneratedValue(generator = "seqBanco")
	@Column(name = "BANC_ID")
	private Long id;
	
	@Column(name = "BANC_CODIGO",length = 6 , nullable = false )
	private String codigo;
	
	@Column(name = "BANC_NOME",length = 30 , nullable = false )	
	private String nome;
	
	@Column(name = "BANC_ATIVO", nullable = false, columnDefinition = "boolean default true")	
	private Boolean ativo;
	
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
	
	@Override
	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public Boolean getAtivo() {
		return ativo;
	}
	
	public boolean equals(final Object objeto) {
		boolean retorno = false;
		
		if(objeto != null && id != null && this.getClass().equals(objeto.getClass())){
			retorno = id.compareTo(((Banco)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}