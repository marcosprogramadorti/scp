package br.gov.transportes.scp.repository.solicitacaoacesso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.transportes.scp.model.SolicitacaoAcesso;
import br.gov.transportes.scp.model.SolicitacaoAcessoArquivo;
import br.gov.transportes.scp.repository.solicitacaoacesso.interfaces.SolicitacaoAcessoArquivoRepository;
import br.gov.transportes.scp.repository.solicitacaoacesso.interfaces.SolicitacaoAcessoRepository;

@Service
public class SolicitacaoAcessoService {
	
	@Autowired
	SolicitacaoAcessoRepository solicitacaoAcessoRepository;
	
	@Autowired
	SolicitacaoAcessoArquivoRepository solicitacaoAcessoArquivoRepository;
	
	public List<SolicitacaoAcesso> listarTodos() {
		
		return solicitacaoAcessoRepository.findAll();
		
	}
	
	public SolicitacaoAcesso salvarOuAtualizar(SolicitacaoAcesso solicitacaoAcesso) {
		
		SolicitacaoAcesso solicitacaoAcessoSalva = solicitacaoAcessoRepository.save(solicitacaoAcesso);

		// Salva os Documentos
		for (SolicitacaoAcessoArquivo documento : solicitacaoAcesso.getSolicitacaoAcessoArquivos()) {
			documento.getId().setIdSolicitacaoAcesso(solicitacaoAcessoSalva.getId());
			salvarDocumento(documento);
		}
		
		return solicitacaoAcessoSalva;
		
	}
	
	public SolicitacaoAcessoArquivo salvarDocumento(SolicitacaoAcessoArquivo solicitacaoAcessoArquivo) {
		
	     return solicitacaoAcessoArquivoRepository.save(solicitacaoAcessoArquivo);
	     
	  }

}
