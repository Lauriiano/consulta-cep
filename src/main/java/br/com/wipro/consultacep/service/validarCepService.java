package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;

import br.com.wipro.consultacep.domain.exceptions.CepInvalidoException;
import br.com.wipro.consultacep.service.interfaces.ValidacaoCep;

@Component
public class validarCepService implements ValidacaoCep {

	public void validar(String cep) {
		if(!cep.matches("[0-9]{5}-[0-9]{3}") && !cep.matches("[0-9]{5}[0-9]{3}")) {
			throw new CepInvalidoException("CEP invalido");
		}
	}
	
}
