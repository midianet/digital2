package midianet.digital.modelo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Uf;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Repository;

@Repository
public class MunicipioDAO extends GenericoDAO<Municipio> {
	
	@SuppressWarnings("unchecked")
	public List<Municipio> listarPorUf(final Uf uf) throws InfraExcessao{
		List<Municipio> municipios = null;
		
		try{
			final Query consulta =  persistencia.createNamedQuery("Municipio.listarPorUf");
			consulta.setParameter("uf", uf);
			
			municipios = consulta.getResultList();
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return municipios;
		
	}
	
	public Municipio obterMunicipioPorUfeNome(final Uf uf, final String nome) throws InfraExcessao{
		
		Municipio retorno = null;
		
		try{
			final Query consulta = persistencia.createNamedQuery("Municipio.obterPorUfENome");
			consulta.setParameter("uf",uf);
			consulta.setParameter("nome", nome);
			
			retorno = (Municipio) consulta.getSingleResult();
			
		}catch(final NoResultException e){
		
		}catch(final Exception e){
			throw new InfraExcessao(e);
		}
		
		return retorno;
	}
	
}