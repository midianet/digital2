package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.Vendedor;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class VendedorDAO extends GenericoDAO<Vendedor> {
	
	@SuppressWarnings("unchecked")
	public List<Vendedor> listarTodos() throws InfraExcessao{
		List<Vendedor> vendedors = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("Vendedor.listarTodos");
			
			vendedors = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return vendedors;
		
	}
	
}