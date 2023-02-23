package br.com.wipro.consultacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.CepService;

@RestController
@RequestMapping("v1")
public class CepController {
	
	@Autowired
	private CepService cepService;

	@PostMapping("/consulta-endereco")
	public ResponseDTO consultarCep(@RequestBody CepRequestDTO requestDTO) {
		return cepService.consultarEndereco(requestDTO);
	}
}
