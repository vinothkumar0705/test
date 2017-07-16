package org.vino.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.vino.messenger.database.DatabaseClass;
import org.vino.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World!", "Vinoth"));
		messages.put(2L, new Message(2, "Hello Rest!", "Vinoth"));
	}
	
	public List<Message> getAllMessages(){
		/*Message m1 = new Message(1L, "Hello World", "Vnoth");
		Message m2 = new Message(2L, "Hello Rest", "Vnoth");
		Message m3 = new Message(3L, "Hello Jersey", "Vnoth");
		List<Message> messages = new ArrayList<Message>();
		messages.add(m1);
		messages.add(m2);
		messages.add(m3);
		return messages;*/
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
