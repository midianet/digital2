package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Fornecedor;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class FornecedorDAO extends GenericoDAO<Fornecedor> {
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarPorCnpj(final String cnpj) throws InfraExcessao{
		List<Fornecedor> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Fornecedor.listarPorCnpj");
			consulta.setParameter("cnpj",   cnpj + "%");
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarPorRazaoSocial(final String razaoSocial)throws InfraExcessao{
		List<Fornecedor> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Fornecedor.listarPorRazaoSocial");
			consulta.setParameter("razaoSocial", razaoSocial + "%");
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarPorCnpjERazaoSocial(final String cnpj, final String razaoSocial)throws InfraExcessao{
		List<Fornecedor> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Fornecedor.listarPorCnpjERazaoSocial");
			consulta.setParameter("cnpj", "%" + cnpj);
			consulta.setParameter("razaoSocial", "%" + razaoSocial);
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	public Fornecedor obterPorCnpj(final String cnpj) throws InfraExcessao{
		Fornecedor retorno = null;
		Query consulta = null;
		try{
			consulta =  persistencia.createNamedQuery("Fornecedor.obterPorCnpj");
			consulta.setParameter("cnpj", cnpj);
			retorno = (Fornecedor) consulta.getSingleResult();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final NonUniqueResultException e){
			//retorno =  (Fornecedor) consulta.getResultList().get(0);
			throw new InfraExcessao(e);
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
}