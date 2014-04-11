package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Cliente;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO extends GenericoDAO<Cliente>{
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarPorCnpj(final String cnpj) throws InfraExcessao{
		List<Cliente> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Cliente.listarPorCnpj");
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
	public List<Cliente> listarPorRazaoSocial(final String razaoSocial)throws InfraExcessao{
		List<Cliente> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Cliente.listarPorRazaoSocial");
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
	public List<Cliente> listarPorCnpjERazaoSocial(final String cnpj, final String razaoSocial)throws InfraExcessao{
		List<Cliente> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Cliente.listarPorCnpjERazaoSocial");
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
	
	public Cliente obterPorCnpj(final String cnpj) throws InfraExcessao{
		Cliente retorno = null;
		Query consulta = null;
		try{
			consulta =  persistencia.createNamedQuery("Cliente.obterPorCnpj");
			consulta.setParameter("cnpj", cnpj);
			retorno = (Cliente) consulta.getSingleResult();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final NonUniqueResultException e){
			//retorno =  (Cliente) consulta.getResultList().get(0);
			throw new InfraExcessao(e);
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
}