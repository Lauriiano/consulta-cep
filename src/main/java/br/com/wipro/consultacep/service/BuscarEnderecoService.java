package br.com.wipro.consultacep.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.wipro.consultacep.domain.exceptions.RequestErroViaCep;
import br.com.wipro.consultacep.dtos.ResponseDTO;

@Component
public class BuscarEnderecoService {
	public ResponseDTO buscarEndereco(String cep) {
		try {			
			return new RestTemplate().getForEntity("https://viacep.com.br/ws/"+cep+"/json/", ResponseDTO.class).getBody();
		}catch(Exception e) {
			throw new RequestErroViaCep("Erro ao Buscar o cep");
		}
	}
}	
