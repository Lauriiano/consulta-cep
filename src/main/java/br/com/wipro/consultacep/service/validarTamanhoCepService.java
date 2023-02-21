package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.domain.exceptions.CepInvalidoException;
import br.com.wipro.consultacep.service.interfaces.ValidacaoCep;

@Component
public class validarTamanhoCepService implements ValidacaoCep {

	public void validar(String cep) {
		if(cep.length() > 8 || cep.length() < 1) {
			throw new CepInvalidoException("CEP invalido");
		}
	}
	
}
