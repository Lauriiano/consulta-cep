package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.Regiao;

@Component
public class SulService extends RegioesService implements Regiao {

	public ResponseDTO pegarFrete(CepRequestDTO requestCep, ResponseDTO responseDTO) {
		Integer codRegiao = Integer.parseInt(requestCep.cep.substring(0, 1));
		
		if(this.getRegiaoSul().contains(codRegiao)) {
			responseDTO.setFrete(this.getValorSul());
		}
		return responseDTO;
	}

}
