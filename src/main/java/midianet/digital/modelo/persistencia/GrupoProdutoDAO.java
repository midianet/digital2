package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.GrupoProduto;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class GrupoProdutoDAO extends GenericoDAO<GrupoProduto> {
	
	@SuppressWarnings("unchecked")
	public List<GrupoProduto> listarTodos() throws InfraExcessao{
		List<GrupoProduto> retorno = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("GrupoProduto.listarTodos");
			
			retorno = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
		
	}
	
}