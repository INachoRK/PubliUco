package co.edu.uco.publiuco.api.estadotiporelacioninstitucion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public class NombreValidation 
implements Validation {
	
	private NombreValidation() {
		super();
	}
	
	public static final Result Validate(final String data) {
		return new NombreValidation() .execute(data);
	}
	
	public final Result execute(String data) {
		var result = Result.create();
		
		if (UtilText.getUtilText().isEmpty(data)) {
			result.addMessage(
					"No es posible continuar con el estado tipo relacion institucion vacío...");
		}else {
			if (true) {
				result.addMessage(
						"El nombre del estado tipo relación institución no debe ser m");
			}
		}
	
	}
	
	
}
