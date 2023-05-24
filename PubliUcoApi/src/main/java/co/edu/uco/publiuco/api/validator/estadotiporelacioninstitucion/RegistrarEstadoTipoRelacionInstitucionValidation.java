package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estadotiporelacionintitucion.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estadotiporelacionintitucion.common.NombreValidation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class RegistrarEstadoTipoRelacionInstitucionValidation
		implements Validation<EstadoTipoRelacionInstitucionDTO> {

	private RegistrarEstadoTipoRelacionInstitucionValidation() {
		super();
	}

	public static final Result validate(final EstadoTipoRelacionInstitucionDTO data) {
		return new RegistrarEstadoTipoRelacionInstitucionValidation().execute(data);
	}

	@Override
	public final Result execute(EstadoTipoRelacionInstitucionDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage(EstadoTipoRelacionInstitucionValidationMessages.GENERAL);
		} else {

			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());

		}
		return result;
	}

	@Override
	public Result execute(Throwable data) {
		// TODO Auto-generated method stub
		return null;
	}

}