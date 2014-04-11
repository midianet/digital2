package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Transportadora;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class TransportadoraDAO extends GenericoDAO<Transportadora> {
	
	@SuppressWarnings("unchecked")
	public List<Transportadora> listarPorCnpj(final String cnpj) throws InfraExcessao{
		List<Transportadora> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Transportadora.listarPorCnpj");
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
	public List<Transportadora> listarPorRazaoSocial(final String razaoSocial)throws InfraExcessao{
		List<Transportadora> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Transportadora.listarPorRazaoSocial");
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
	public List<Transportadora> listarPorCnpjERazaoSocial(final String cnpj, final String razaoSocial)throws InfraExcessao{
		List<Transportadora> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Transportadora.listarPorCnpjERazaoSocial");
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
	
	public Transportadora obterPorCnpj(final String cnpj) throws InfraExcessao{
		Transportadora retorno = null;
		Query consulta = null;
		try{
			consulta =  persistencia.createNamedQuery("Transportadora.obterPorCnpj");
			consulta.setParameter("cnpj", cnpj);
			retorno = (Transportadora) consulta.getSingleResult();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final NonUniqueResultException e){
			//retorno =  (Transportadora) consulta.getResultList().get(0);
			throw new InfraExcessao(e);
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
}