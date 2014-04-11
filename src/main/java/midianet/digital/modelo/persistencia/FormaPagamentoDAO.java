package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.Query;

import midianet.digital.modelo.entidade.FormaPagamento;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class FormaPagamentoDAO extends GenericoDAO<FormaPagamento> {
	
	@SuppressWarnings("unchecked")
	public List<FormaPagamento> listarTodos() throws InfraExcessao{
		List<FormaPagamento> retorno = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("FormaPagamento.listarTodos");
			
			retorno = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
		
	}
	
}