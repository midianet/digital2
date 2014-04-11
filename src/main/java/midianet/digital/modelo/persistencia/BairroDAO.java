package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Bairro;
import midianet.digital.modelo.entidade.Municipio;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class BairroDAO extends GenericoDAO<Bairro> {
	
	@SuppressWarnings("unchecked")
	public List<Bairro> listarPorMunicipio(final Municipio municipio) throws InfraExcessao{
		List<Bairro> bairros = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("Bairro.listarPorMunicipio");
			consulta.setParameter("municipio", municipio);
			
			bairros = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return bairros;
		
	}
	
	public Bairro obterBairroPorMunicipioENome(final Municipio municipio , final String nome ) throws InfraExcessao{
	
		Bairro retorno = null;
		
		try{
			final Query consulta = persistencia.createNamedQuery("Bairro.obterPorMunicipioeNome");
			consulta.setParameter("municipio",municipio);
			consulta.setParameter("nome", nome);
			
			retorno = (Bairro) consulta.getSingleResult();
		}catch(final NoResultException e){
			
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
		
	}
	
}