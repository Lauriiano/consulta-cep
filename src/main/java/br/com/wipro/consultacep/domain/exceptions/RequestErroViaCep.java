package br.com.wipro.consultacep.domain.exceptions;

public class RequestErroViaCep extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequestErroViaCep(String mensagem) {
		super(mensagem);
	}

}
