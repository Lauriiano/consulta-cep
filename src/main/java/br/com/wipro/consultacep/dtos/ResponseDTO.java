package br.com.wipro.consultacep.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
	public String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private double frete;
}
