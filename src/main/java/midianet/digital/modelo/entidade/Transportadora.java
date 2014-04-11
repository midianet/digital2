package midianet.digital.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRANSPORTADORA")
@NamedQueries({
	@NamedQuery(name	= "Transportadora.obterPorCnpj", 
				query	= "SELECT t FROM Transportadora t where t.cnpj = :cnpj"),
				@NamedQuery(name	= "Transportadora.listarPorCnpj", 
				query	= "SELECT t FROM Transportadora t where t.cnpj like :cnpj order by t.cnpj"),
				@NamedQuery(name	= "Transportadora.listarPorRazaoSocial", 
				query	= "SELECT t FROM Transportadora t where t.razaoSocial like :razaoSocial order by t.razaoSocial "),
				@NamedQuery(name	= "Transportadora.listarPorCnpjERazaoSocial", 
				query	= "SELECT t FROM Transportadora t where t.cnpj like :cnpj and t.razaoSocial like :razaoSocial order by t.razaoSocial "),
})
public class Transportadora extends PessoaJuridica {
	private static final long serialVersionUID = 4990808772387343714L;
	
	@Column(name = "PESS_ATENDENTE", nullable = true , length = 30)
	private String atendente;

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(final String atendente) {
		this.atendente = atendente;
	}
	
}