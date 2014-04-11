package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.Uf;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class UfDAO extends GenericoDAO<Uf> {
	
	@SuppressWarnings("unchecked")
	public List<Uf> listar(final String query)throws InfraExcessao{
		List<Uf> retorno = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery(query);
			retorno = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
}