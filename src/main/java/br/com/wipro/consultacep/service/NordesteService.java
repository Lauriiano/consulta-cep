package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.Regiao;

@Component
public class NordesteService extends RegioesService implements Regiao {

	public ResponseDTO pegarFrete(CepRequestDTO requestCep, ResponseDTO responseDTO) {
		Integer codRegiao = Integer.parseInt(requestCep.cep.substring(0, 1));
		
		if(codRegiao == 6) {
			codRegiao = Integer.parseInt(requestCep.cep.substring(0, 2));
		}
		
		if(this.getRegiaoNordeste().contains(codRegiao)) {
			responseDTO.setFrete(this.getValorNordeste());
		}
		return responseDTO;
	}

}
