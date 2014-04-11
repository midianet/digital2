/*
 * CodigoVerificacaoDiferenteExcessao.java
 * 
 * Criado pela equipe de desenvolvimento do RHNet
 * integrante do Sistema de Recadastramento do Servidor.
 * 
 * Midianet 2014.
 * 
 * Todos os direitos Copyright estão reservados.
 */
package midianet.digital.excessao;

import midianet.framework.excessao.NegocioExcessao;

/**
 * CodigoVerificacaoDiferenteExcessao
 * Classe que representa a excessao genêrica para o campo de verificação de um capcha.
 * 
 * @category Excessao
 * 
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class CodigoVerificacaoDiferenteExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padrão da Excessão
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public CodigoVerificacaoDiferenteExcessao(){
	    super("MSG0034");
	}
	
}