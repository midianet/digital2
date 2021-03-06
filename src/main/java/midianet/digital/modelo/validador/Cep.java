package midianet.digital.modelo.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Constraint(validatedBy = CepValidador.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {
	String message() default "Cep inv�lido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[]  payload() default {};
	
}