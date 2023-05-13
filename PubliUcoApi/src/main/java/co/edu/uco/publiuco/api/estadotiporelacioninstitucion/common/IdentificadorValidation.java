package co.edu.uco.publiuco.api.estadotiporelacioninstitucion.common;

import co.edu.publiuco.api.validator.Result;
import co.edu.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;

public class IdentificadorValidation implements Validation<UUID> {

	private IdentificadorValidation
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);
	}
	
	public final Result execute (UUID data) {
		result = Result.create();
		
		if (UtilObject.isNull(data)) {
			var result = result.addMessage(
					"No es posible continuar con el identificador del estado tipo relacion ")
		}
		
	}
	
}
