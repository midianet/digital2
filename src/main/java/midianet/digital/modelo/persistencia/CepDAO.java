package midianet.digital.modelo.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import midianet.digital.modelo.entidade.Cep;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class CepDAO{
	
	@PersistenceContext
	protected EntityManager persistencia;
	
	public Cep obterPorCep(final String cep) throws InfraExcessao{
		Cep retorno = null;
		
		try{
			retorno = persistencia.find(Cep.class, cep);
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
		
	}
	
	public void salvar(final Cep cep) throws InfraExcessao{
		
		try{
			
			persistencia.persist(cep);
			
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
	}
}