package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import midianet.framework.persistencia.entidade.Entidade;

@Entity
@Table(name = "TB_UF")
@NamedQueries({
	@NamedQuery(name	= "Uf.listarTodos", 
				query	= "SELECT u FROM Uf u order by u.nome")
	
})
public class Uf extends Entidade<String>{
	private static final long serialVersionUID = 3428027528752703813L;

	@Id
	@Column(name = "UFED_ID", length = 2) 
	private String id;
	
	@Column(name = "UFED_NOME", length = 60 ,nullable = false)
	private String nome;
	
	@Column(name = "UFED_ATIVO", nullable = false, columnDefinition = "boolean default true")
	private Boolean ativo = true;
	
	public String getId() {
		return id;
	}
	
	public void setId(final String id) {
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
			retorno = id.compareTo(((Uf)objeto).getId()) == 0;
		}
		
		return retorno;
		
	}
	
}