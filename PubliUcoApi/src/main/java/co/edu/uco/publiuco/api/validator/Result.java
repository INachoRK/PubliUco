package co.edu.uco.publiuco.api.validator;

import java.util.List;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public final class Result {
	
	private boolean valid;
	private List<String> messages;
	
	private Result(finalboolean valid, final List<String> messages) {
		setValid(valid);
		setMessages(messages);
	}
	
	public static Result createValid() {
		return new Result (new ArrayList<>());
	}
	
	public static Result createInvalid(final List<String> messages) {
		return new Result (messages);
	}
	
	private final void setValid(final boolean valid) {
		this.valid = UtilObject.getDefault(valid, false)
	}
	
	public static final Result create() {
		return new Result (new ArrayList<>());
	}
	
	public static final Result create(final List<String> messages) {
		return new Result(messages);
	}
	
	public void addMessage(String message) {
		if (!UtilText.getUtilText().isEmpty(message)) {
			
		}
		
	public void addMessages(final List<String> messages) {
		getMessages().addAll(UtilObject.getDefault(messages, newArrayList<>));
	}
		
	}
	
	public final boolean isValid() {
		return valid;
	}
	
	public final List<String> getMessages() {
		return messages;
	}
	

}
