package midianet.digital.modelo.validador;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidador implements ConstraintValidator<Cep, String> {
	
	@Override
	public void initialize(final Cep cep) {
		
	}
	
	@Override
	public boolean isValid(final String valor, final ConstraintValidatorContext contexto) {
		return true;
	}

}
