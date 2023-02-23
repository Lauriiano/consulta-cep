package br.com.wipro.consultacep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.Regiao;
import br.com.wipro.consultacep.service.interfaces.ValidacaoCep;

@Service
public class CepService {

	@Autowired
	List<ValidacaoCep> validacoes;
	
	@Autowired
	List<Regiao> regioes;
	
	@Autowired
	BuscarEnderecoService buscarEndereco;
	
	private ResponseDTO response;
	
	public ResponseDTO consultarEndereco(CepRequestDTO requestDTO) {
		
		String cep = requestDTO.cep.replace("-", "");
		
		this.validacoes.forEach(validacao -> validacao.validar(cep));
		
		this.response = this.buscarEndereco.buscarEndereco(cep);
		
		this.regioes.forEach((regiao) -> {
			this.response = regiao.pegarFrete(requestDTO, this.response);
		});
		
		return this.response;

	}
	
}
