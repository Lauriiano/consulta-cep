package br.com.wipro.consultacep.service.interfaces;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;

public interface Regiao {
	public ResponseDTO pegarFrete(CepRequestDTO requestCep, ResponseDTO responseDTO);
}
