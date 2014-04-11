package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.Banco;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class BancoDAO extends GenericoDAO<Banco> {
	
	@SuppressWarnings("unchecked")
	public List<Banco> listarTodos() throws InfraExcessao{
		List<Banco> bancos = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("Banco.listarTodos");
			
			bancos = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return bancos;
		
	}
	
}