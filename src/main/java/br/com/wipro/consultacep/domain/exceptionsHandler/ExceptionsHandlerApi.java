package br.com.wipro.consultacep.domain.exceptionsHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.wipro.consultacep.domain.exceptions.CepInvalidoException;

@ControllerAdvice
public class ExceptionsHandlerApi {

	private ExceptionsBody bodyException;
	
	@ExceptionHandler(CepInvalidoException.class)
	public ResponseEntity<?> cepInvalidoException(CepInvalidoException e) {
		
		bodyException = ExceptionsBody.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage())
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyException);
	}
	
}
