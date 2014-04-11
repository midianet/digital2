/*
 * CampoInvalidoExcessao.java
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
 * CampoInvalidoExcessao
 * Classe que representa a excessao gen�rica para a campos com valores inv�lidos.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class CampoInvalidoExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padr�o da Excess�o
	 * 
	 * @param campo Nome do campo com valor inv�lido.
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public CampoInvalidoExcessao(final String campo){
	    super("MSG002",campo);
	}
	
	/**
	 * 
	 * @param campo
	 * @param explicacao
	 */
	public CampoInvalidoExcessao(final String campo, final String explicacao){
	    super("MSG004",campo,explicacao);
	}
	
}