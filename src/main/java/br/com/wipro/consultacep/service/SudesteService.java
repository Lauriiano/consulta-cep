package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.Regiao;

@Component
public class SudesteService extends RegioesService implements Regiao {

	public ResponseDTO pegarFrete(CepRequestDTO requestCep, ResponseDTO responseDTO) {
		String codRegiao = requestCep.cep.substring(0, 1);
		
		if(this.getRegiaoSudeste().contains(Integer.parseInt(codRegiao))) {
			responseDTO.setFrete(this.getValorSudeste());
		}
		return responseDTO;		
	}

}
