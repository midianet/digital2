
package midianet.digital.modelo.remoto;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import midianet.digital.excessao.SemConexaoInternetExcessao;
import midianet.digital.modelo.entidade.CepCorreios;
import midianet.framework.excessao.InfraExcessao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CepJSON {
	
	public CepCorreios obterPorCEP(final String cep) throws SemConexaoInternetExcessao , InfraExcessao {
	    final int zero   = 0;
	    final int um     = 1;
	    final int dois   = 2;
	    final int tres   = 3;
	    final int quatro = 4;
		
		final Map<String, String> query = new HashMap<String, String>();
		CepCorreios retorno = null;
		
		query.put("cepEntrada",cep);
		query.put("tipoCep", "");
		query.put("cepTemp", "");
		query.put("metodo", "buscarCep");

//		System.setProperty("http.proxyHost", "10.6.60.56");
//		System.setProperty("http.proxyPort", "2303");
		
		try {
			final Document doc = Jsoup.connect("http://m.correios.com.br/movel/buscaCepConfirma.do").data(query).post();
			
			final Elements resposta = doc.select(".respostadestaque");
			
			if(resposta != null && resposta.size() >= quatro) {
				retorno = new CepCorreios();

				retorno.setBairro(resposta.get(um).text());
				retorno.setLocalidade(resposta.get(dois).text());

				String logradouro = resposta.get(zero).text();
				
				if(logradouro.contains("-")){
					logradouro = logradouro.substring(0,logradouro.indexOf("-")); 
				}
				
				retorno.setLogradouro(logradouro);

				retorno.setCep(resposta.get(tres).text());
			}
		}catch(final UnknownHostException e){
			throw new SemConexaoInternetExcessao();
		} catch(final Exception e){
		    throw new InfraExcessao(e);
		}
		
		return retorno;
		
	}
	
}