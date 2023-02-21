package br.com.wipro.consultacep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.service.interfaces.ValidacaoCep;

@Service
public class CepService {

	@Autowired
	List<ValidacaoCep> validacoes;
	
	public void consultarEndereco(CepRequestDTO requestDTO) {
		this.validacoes.forEach(validacao -> validacao.validar(requestDTO.CEP));
	}
	
}
