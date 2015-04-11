package Client.src.transferObjects;

import java.io.Serializable;

public class MessageTO implements Serializable {

	private String from;
	private String to;
	private String room;
	private String type;
	private String body;
	
	public MessageTO(String from, String to, String room, String type, String body) {
		
		this.from = from;
		this.to = to;
		this.room = room;
		this.type = type;
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
