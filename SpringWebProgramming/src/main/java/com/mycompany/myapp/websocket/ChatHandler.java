package com.mycompany.myapp.websocket;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatHandler.class);	
	private List<WebSocketSession> list = new Vector<>();
	
	
	
	//연결이 성공되었을 때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {		
		LOGGER.info("");
		list.add(session);
	}
	
	//메시지를 받았을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOGGER.info("");	
		for(WebSocketSession wss:list){
			wss.sendMessage(message);
		}
	}
	
	//연결이 종료되었을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {		
		LOGGER.info("");
		list.remove(session);
	}
}
