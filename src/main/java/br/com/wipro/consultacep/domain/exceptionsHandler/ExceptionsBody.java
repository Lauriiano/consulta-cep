package br.com.wipro.consultacep.domain.exceptionsHandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionsBody {

	private LocalDateTime dataHora;
	private String mensagem;
	
}
