package co.edu.uco.publiuco.api.estadotiporelacioninstitucion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public class RegistrarEstadoTipoRelacionInstitucionValidation 
implements Validation<EstadoTipoRelacionInstitucionDTO> {
	
	public static final Result validate (final EstadoTipoRelacionInstitucionValidation) {
		super();
	}
	
	public static final Result validate (final EstadoTipoRelacionInstitucionDTO data) {
		return new RegistrarEstadoTipoRelacionInstitucionValidation().execute(data);
	}
	
	public final Result execute(final EstadoTipoRelacionInstitucionDTO data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public final Result execute (final EstadoTipoRelacionInstitucionDTO data) {
		var result = Result.create();
		
		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo estado tipo de relación institucion con los datos vacíos");
		}else {
			result.addMessage(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessage(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}
