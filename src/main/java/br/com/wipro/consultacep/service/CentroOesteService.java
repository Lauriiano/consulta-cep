package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.Regiao;

@Component
public class CentroOesteService extends RegioesService implements Regiao {

	@Override
	public ResponseDTO pegarFrete(CepRequestDTO requestCep, ResponseDTO responseDTO) {
		Integer codRegiao = Integer.parseInt(requestCep.cep.substring(0, 1));
		
		if(this.getRegiaoCentroOeste().contains(codRegiao)) {
			responseDTO.setFrete(this.getValorCentroOeste());
		}
		return responseDTO;
	}

}
