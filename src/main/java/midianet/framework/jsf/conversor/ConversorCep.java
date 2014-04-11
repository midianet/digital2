package midianet.framework.jsf.conversor;

import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;

import midianet.framework.util.TextoUtil;

@FacesConverter(value = "conversorCep")
public class ConversorCep implements Converter {
	
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
	    	
	    	if(valor != null && valor.toString().length() == 8){
	    		
	    		
				try {
					final MaskFormatter formatador = new MaskFormatter("##.###-###");
		    		formatador.setValueContainsLiteralCharacters(false);					
					retorno = formatador.valueToString(valor.toString());
	    		} catch (final ParseException e) {
	    			retorno = valor.toString();
	    		}
	    	}else{
	    		retorno = valor.toString();
	    	}
	    }
	    
	    return retorno;
	}
	
}	