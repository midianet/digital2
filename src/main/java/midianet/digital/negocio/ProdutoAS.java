package midianet.digital.negocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import midianet.digital.modelo.entidade.Produto;
import midianet.digital.modelo.filtro.ProdutoFiltro;
import midianet.digital.modelo.persistencia.ProdutoDAO;
import midianet.framework.excessao.InfraExcessao;

import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor=Exception.class)
public class ProdutoAS {
	private final String separador = System.getProperty("file.separator");
	@Resource
	private ProdutoDAO produtoDAO;
	
	@Transactional(readOnly = false)
	public void salvar(final Produto produto, final UploadedFile upload) throws InfraExcessao{
		
		final boolean novo = produto.getId() == null;
		
		if(novo){
			produtoDAO.incluir(produto);
		}else{	
			produtoDAO.alterar(produto);
		}
		
		if(upload != null){
			salvarFoto(produto.getId().toString(),upload);
		}
		
	}
	
	public String obterNomeArquivo(final String id){
		return "P" + id.toString() + ".jpg";
	}
	
	private void salvarFoto(final String id, final UploadedFile upload) throws InfraExcessao{ //TODO: Tirar isso daki
		
		try {
			final String diretorio_arquivos = System.getProperty("imagemServletProduto_diretorio_arquivos");
			final File arquivoNovo = new File(diretorio_arquivos + separador + obterNomeArquivo(id));
			final InputStream entrada = upload.getInputstream();
			final FileOutputStream saida = new FileOutputStream(arquivoNovo, false);
			
			int b;
			
			while ((b = entrada.read()) != -1){
				saida.write(b);
			}
			
			entrada.close();
			saida.close();	
		} catch (final IOException e) {
			throw new InfraExcessao(e);
		}
		
	}
	
	public Produto obterPorCodigo(final String codigo) throws InfraExcessao{
		
		final Produto retorno = produtoDAO.obterPorCodigo(codigo); 
		
		return retorno;
	}
	
	public Produto obterProdutoPorId(final Long id) throws InfraExcessao{
		
		final Produto retorno = produtoDAO.obterPorId(id); 
		
		return retorno;
	}
	
	@Transactional(readOnly=false)
	public void excluir(final Produto produto) throws InfraExcessao{
		produtoDAO.excluir(produto);
	}
	
	public List<Produto> listarPorFiltro(final ProdutoFiltro filtro) throws InfraExcessao{
		List<Produto> retorno = null;
		
		final boolean filtrarCodigo = filtro.getCodigo() != null && !filtro.getCodigo().trim().isEmpty();
		final boolean filtrarNome = filtro.getNome() != null && !filtro.getNome().trim().isEmpty();
		
		if(filtrarCodigo && filtrarNome){
			retorno = produtoDAO.listarPorCodigoENome(filtro.getCodigo(), filtro.getNome());
		}else if(filtrarCodigo){
			retorno = produtoDAO.listarPorCodigo(filtro.getCodigo());
		}else if(filtrarNome){
			retorno = produtoDAO.listarPorNome(filtro.getNome());
		}
		
		return retorno;
		
	}
	
}