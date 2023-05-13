package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	private EstadoTipoRelacionInstitucionFacade facade;
	
	public EstadoTipoRelacionInstitucionController() {
		facade = new 
	}
	
	@GetMapping("/dummy")
	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.create();
	}
	
	@GetMapping
	public List<EstadoTipoRelacionInstitucionDTO> list(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {

		public ResponseEntity<Response<EstadoTipoRealcionInstitucionDTO>> List(@RequestParam EstadoTipoRelacionInstitucionDTO);	
		
		List<EstadoTipoRelacionInstitucionDTO> list = new ArrayList<>();
		List.add(EstadoTipoRelacionInstitucionDTO.create());
		List.add(EstadoTipoRelacionInstitucionDTO.create());
		List.add(EstadoTipoRelacionInstitucionDTO.create());
		List.add(EstadoTipoRelacionInstitucionDTO.create());
		List.add(EstadoTipoRelacionInstitucionDTO.create());
		
		List<String> messages = new ArrayList<>();
		messages.add("Estados de tipo de relacion institucion consultados exitosamente");
		
		Response<EstadoTipoRelacionInstitucionDTO> response = new
				Response<> (List, messages);
		
		return new ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>>
			(response, HttpStatus.OK);

		return list;

	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id) {

		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(id);

	}
	
	@PostMapping
	public ResponseEntity create(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		
		var statuscode = HttpStatus.OK;
		
		try {
			var result = RegistrarEstadoTipoRelacionInstitucionValidation.validate(dto);
			
			if (result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages()
						.add("El nuevo estado tipo relación institución se ha registrado de forma satisfactoria");
			}else {
				statuscode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
			
		}catch(PubliUcoException exception) {
			statuscode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUsermessage());
			System.err.printIn(exception.getTechnicalMessage());
			System.err.printIn(exception.getType());
			exception.printStackTrace();
		}catch(Exception exception) {
			statuscode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add(
					"Se ha presentado un problema inesperado. Por favor intentar de nuevo y si el problema persiste contacte a un administrador");
			System.err.printIn(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response, stauscode);

	}
	
	@PutMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id, @RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		return dto.setIdentificador(id);

	}
	
	@DeleteMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO delete(@PathVariable UUID id) {
		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(id);

	}

}