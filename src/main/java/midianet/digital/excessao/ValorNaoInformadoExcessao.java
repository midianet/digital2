/*
 * CampoNaoInformadoExcessao.java
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
 * CampoNaoInformadoExcessao
 * Classe que representa a excessao gen�rica para um campo que esteja com o valor vazio ou nulo.
 * 
 * @category Excessao
 *
 * @see NegocioExcessao
 *
 * @author Marcos Fernando Costa.
 */
public class ValorNaoInformadoExcessao extends NegocioExcessao{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padr�o da Excess�o
	 * 
	 * @param campo Nome do campo n�o informado ou nulo.
	 * 
	 * @author Marcos Fernando Costa.
	 */	
	public ValorNaoInformadoExcessao(final String campo){
	    super("MSG001",campo);
	}
	
}