package co.edu.uco.publiuco.api.controller.response;

import java.util.list;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;

public final class Response<T> {
	
	private List<T> = data;
	private List<String> = Messages;

	public Response(final List<T> data, final List<String> messages) {
		super();
		this.data = data;
		this.messages = messages;
	}
	
	public Response() {
		super();
		this.data = data;
		this.messages = messages;
	}
	
	public final List<T> getData() {
		return data;
	}
	
	public final List<String> getMessages() {
		return messages;
	}
	
	public final void setMessages(final List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList());
	}
	
}
