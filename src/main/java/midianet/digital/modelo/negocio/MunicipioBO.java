package midianet.digital.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;

import midianet.digital.excessao.ValorNaoInformadoExcessao;
import midianet.digital.modelo.entidade.Municipio;
import midianet.digital.modelo.entidade.Uf;
import midianet.digital.modelo.persistencia.MunicipioDAO;
import midianet.framework.excessao.InfraExcessao;

import org.springframework.stereotype.Component;

@Component
public class MunicipioBO {

	@Resource
	private MunicipioDAO municipioDAO;
	
	public List<Municipio> listarPorUf(final Uf uf) throws ValorNaoInformadoExcessao, InfraExcessao{
		
		if(uf == null){
			throw new ValorNaoInformadoExcessao("Uf");
		}
		
		return municipioDAO.listarPorUf(uf);
		
	}
	
	public Municipio obterMunicipioPorUfeNome(final Uf uf, final String nome) throws ValorNaoInformadoExcessao, InfraExcessao{
		
		if(uf == null){
			throw new ValorNaoInformadoExcessao("Uf");
		}
		
		if(nome == null){
			throw new ValorNaoInformadoExcessao("Nome");
		}
		
		return municipioDAO.obterMunicipioPorUfeNome(uf, nome);
		
	}
	
	public void salvar(final Municipio municipio) throws InfraExcessao{
		
		if(municipio.getId() == null){
			incluir(municipio);
		}else{
			municipioDAO.alterar(municipio);
		}
	}
	
	public void incluir(final Municipio municipio) throws InfraExcessao{
		municipioDAO.incluir(municipio);
	}
	
}