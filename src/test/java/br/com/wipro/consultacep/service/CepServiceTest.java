package br.com.wipro.consultacep.service;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.wipro.consultacep.domain.exceptions.CepInvalidoException;
import br.com.wipro.consultacep.dtos.CepRequestDTO;
import br.com.wipro.consultacep.dtos.ResponseDTO;
import br.com.wipro.consultacep.service.interfaces.ValidacaoCep;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("CepServiceTest")
public class CepServiceTest {
	
	@MockBean
	List<ValidacaoCep> validacoes;
	
	@MockBean
	BuscarEnderecoService buscarEndereco;
	
	@Autowired
	CepService cepService;
	
	@Test
	@DisplayName("Não deve passar na verificação de frete")
	public void should_not_pass_zipcode_verification() {
		
		CepRequestDTO request = new CepRequestDTO();
		request.setCep("227706500");
		
		ResponseDTO response = new ResponseDTO();
		response.setCep("22770650");
		response.setLogradouro("Rua pintor leandro joaquim");
		
		
		try {
			ResponseDTO res = this.cepService.consultarEndereco(request);
			
			Mockito.verifyNoInteractions(buscarEndereco);
			Assertions.assertNull(res);
		}catch(CepInvalidoException e) {}

	}
	
	@Test
	@DisplayName("Deve retornar o objeto com o frete")
	public void should_return_a_zip_object() {
		
		CepRequestDTO request = new CepRequestDTO();
		request.setCep("22770650");
		
		ResponseDTO response = new ResponseDTO();
		response.setCep("22770650");
		response.setLogradouro("Rua pintor leandro joaquim");
		
		Mockito.when(buscarEndereco.buscarEndereco("22770650")).thenReturn(response);
		
		ResponseDTO res = this.cepService.consultarEndereco(request);
		
		Assertions.assertNotNull(res.getFrete());
	}
	

	@Test
	@DisplayName("Deve retornar valor de frete para Sul")
	public void should_return_value_facing_south_region() {
		
		List<String> ceps = List.of("80250030", "91349900");
		
		
		ceps.forEach((cep) -> {		
			
			RegioesService regioes = new RegioesService();
			ResponseDTO response = new ResponseDTO();
			response.setCep(cep);
			
			response.setLogradouro("Rua pintor leandro joaquim");
			Mockito.when(buscarEndereco.buscarEndereco(cep)).thenReturn(response);
			CepRequestDTO request = new CepRequestDTO();
			request.setCep(cep);
			
			ResponseDTO res = this.cepService.consultarEndereco(request);
			
			Assertions.assertNotNull(res.getFrete());
			Assertions.assertEquals(regioes.getValorSul(), res.getFrete());
		});
		
	}
	
	@Test
	@DisplayName("Deve retornar valor de frete para Centro Oeste")
	public void should_return_value_facing_center_west_region() {
		
		List<String> ceps = List.of("74563220");
		
		
		ceps.forEach((cep) -> {		
			
			RegioesService regioes = new RegioesService();
			ResponseDTO response = new ResponseDTO();
			response.setCep(cep);
			
			response.setLogradouro("Rua pintor leandro joaquim");
			Mockito.when(buscarEndereco.buscarEndereco(cep)).thenReturn(response);
			CepRequestDTO request = new CepRequestDTO();
			request.setCep(cep);
			
			ResponseDTO res = this.cepService.consultarEndereco(request);
			
			Assertions.assertNotNull(res.getFrete());
			Assertions.assertEquals(regioes.getValorCentroOeste(), res.getFrete());
		});
		
	}
	
	@Test
	@DisplayName("Deve retornar valor de frete para Sudeste")
	public void should_return_value_facing_southeast_region() {
		
		List<String> ceps = List.of("22770650", "01310100");
		
		
		ceps.forEach((cep) -> {		
			
			RegioesService regioes = new RegioesService();
			ResponseDTO response = new ResponseDTO();
			response.setCep(cep);
			
			response.setLogradouro("Rua pintor leandro joaquim");
			Mockito.when(buscarEndereco.buscarEndereco(cep)).thenReturn(response);
			CepRequestDTO request = new CepRequestDTO();
			request.setCep(cep);
			
			ResponseDTO res = this.cepService.consultarEndereco(request);
			
			Assertions.assertNotNull(res.getFrete());
			Assertions.assertEquals(regioes.getValorSudeste(), res.getFrete());
		});
		
	}
	
	
}
