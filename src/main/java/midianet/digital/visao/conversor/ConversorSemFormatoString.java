package midianet.digital.visao.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import midianet.framework.util.TextoUtil;

@FacesConverter(value = "conversorSemFormatoString")
public class ConversorSemFormatoString implements Converter {
	
	@Override
	public final Object getAsObject(final FacesContext contexto, final UIComponent componente, final String valor) {
	    Object retorno = null;
	    
	    if(valor != null && !valor.trim().isEmpty()) {
	    	retorno = TextoUtil.apenasNumeros(valor);
	    }
		
		return retorno;
		
	}
	
	@Override
	public final String getAsString(final FacesContext contexto, final UIComponent componente, final Object valor) {
	    String retorno = null;
	    
	    if(valor != null){
	    	return valor.toString();
	    }
	    
	    return retorno;
	}
	
}	