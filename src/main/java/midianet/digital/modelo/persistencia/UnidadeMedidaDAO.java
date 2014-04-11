package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.UnidadeMedida;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class UnidadeMedidaDAO extends GenericoDAO<UnidadeMedida> {
	
	@SuppressWarnings("unchecked")
	public List<UnidadeMedida> listarTodas() throws InfraExcessao{
		List<UnidadeMedida> retorno = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("UnidadeMedida.listarTodas");
			
			retorno = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	
	}
	
}