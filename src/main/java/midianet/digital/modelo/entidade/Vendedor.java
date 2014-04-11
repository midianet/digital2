package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VENDEDOR")
@NamedQueries({
	@NamedQuery(name	= "Vendedor.obterPorCpf", 
				query	= "SELECT v FROM Vendedor v where v.cpf = :cpf"),
				@NamedQuery(name	= "Vendedor.listarTodos", 
				query	= "SELECT v FROM Vendedor v order by v.nome"),
})
public class Vendedor extends PessoaFisica {
	private static final long serialVersionUID = 2261543255930418357L;
	
	@Column(name = "PESS_COMISSIONADO")
	private Boolean comissionado;

	public Boolean getComissionado() {
		 return comissionado;
	 }
	 
	 public void setComissionado(final Boolean comissionado) {
		this.comissionado = comissionado;
	 }
}