/*
 * CodigoVerificacaoDiferenteExcessao.java
 * 
 * Criado pela equipe de desenvolvimento do RHNet
 * integrante do Sistema de Recadastramento do Servidor.
 * 
 * Midianet 2014.
 * 
 * Todos os direitos Copyright est�o reservados.
 */
package midianet.digital.excessao;

import midianet.framework.excessao.NegocioExcessao;

/**
 * CodigoVerificacaoDiferenteExcessao
 * Classe que representa a excessao gen�rica para o campo de verifica��o de um capcha.
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
	 * Construtor padr�o da Excess�o
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public CodigoVerificacaoDiferenteExcessao(){
	    super("MSG0034");
	}
	
}