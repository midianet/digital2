package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Produto;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO extends GenericoDAO<Produto> {
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarPorCodigoENome(final String codigo, final String nome) throws InfraExcessao{
		List<Produto> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Produto.listarPorCodigoENome");
			consulta.setParameter("codigo", codigo +"%");
			consulta.setParameter("nome", nome +"%");
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarPorCodigo(final String codigo) throws InfraExcessao{
		List<Produto> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Produto.listarPorCodigo");
			consulta.setParameter("codigo",  codigo +"%");
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarPorNome(final String nome) throws InfraExcessao{
		List<Produto> retorno = null;
		Query consulta = null;
		
		try{
			consulta =  persistencia.createNamedQuery("Produto.listarPorNome");
			consulta.setParameter("nome",  nome +"%");
			retorno = consulta.getResultList();
		}catch(final NoResultException e){
			retorno = null;
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
	public Produto obterPorCodigo(final String codigo) throws InfraExcessao{
		Produto retorno = null;
		Query consulta = null;
		try{
			consulta =  persistencia.createNamedQuery("Produto.obterPorCodigo");
			consulta.setParameter("codigo", codigo);
			retorno = (Produto) consulta.getSingleResult();
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