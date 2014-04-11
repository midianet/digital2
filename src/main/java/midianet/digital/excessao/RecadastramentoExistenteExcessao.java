/*
 * RecadastramentoExistente.java
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
 * RecadastramentoExistente
 * Classe que representa a excessao na tentativa de recadastramento duplicado.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class RecadastramentoExistenteExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padr�o da Excess�o
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public RecadastramentoExistenteExcessao(){
	    super("MSG301");
	}
	
}