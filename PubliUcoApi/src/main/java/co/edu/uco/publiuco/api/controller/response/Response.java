package co.edu.uco.publiuco.api.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;

public final class Response<T> {

	private List<T> data;
	private List<String> messages;

	public Response(final List<T> data, final List<String> messages) {
		super();
		this.data = data;
		this.messages = messages;
	}

	public Response() {
		super();
		setData(new ArrayList<>());
		setMessages(new ArrayList<>());
	}

	public final List<T> getData() {
		return data;
	}

	public final void setData(List<T> data) {
		this.data = UtilObject.getDefault(data, new ArrayList<>());
	}

	public final List<String> getMessages() {
		return messages;
	}

	public final void setMessages(List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}

}
