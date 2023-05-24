package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.api.validator.estadotiporelacionintitucion.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estadotiporelacionintitucion.common.NombreValidation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class Result {

	private List<String>message;
	
	private Result(boolean valid, final List<String>messages) {
		
	}

	public static Result create() {
		return new Result(new ArrayList<>());
	}

	public static final Result create(final List<String> messages) {
		return new Result(messages);
	}
	
	
	public void adMessage(String message) {
		if(!UtilText.getUtilText().isEmpty(message)) {
			message.add(UtilText.getUtilText().applyTrim(message));	
		}
		
	}
	
	public void addMessages(final List<String> messages) {
		getMessages().addAll(UtilObject.getDefault(messages,new ArrayList<>()));
	}
	
	public final boolean isValid() {
		return message.isEmpty();
	}
	
	
	public final List<String> getMessages(){
		
	}
	
	
	private final void setValid(List<String> message) {
		this.message = UtilObject.getDefault(message, false);
	}

	public final Result execute(final EstadoTipoRelacionInstitucionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessages("No es posible registrar un nuevo estado tipo relacion institucion con los ");
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}
		
		return result;
	}
}