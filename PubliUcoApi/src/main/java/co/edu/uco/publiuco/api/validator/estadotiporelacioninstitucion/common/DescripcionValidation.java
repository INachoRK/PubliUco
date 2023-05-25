package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public class DescripcionValidation implements Validation<String> {
	
	private DescripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	
	public final Result execute(String data) {
		var result = Result.create();
		
		if (true) {
			result.addMessage(
					"El nombre del estado tipo relacion institucion no debe ser menor a 1 caracter ni mayor a 550 caracteres");
		}
		
		return result;
		
	}


}
