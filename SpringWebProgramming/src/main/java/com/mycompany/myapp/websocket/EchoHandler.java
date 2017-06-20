package com.mycompany.myapp.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EchoHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(EchoHandler.class);
	
	//연결이 성공되었을 때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {		
		LOGGER.info("");
	}
	
	//메시지를 받았을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOGGER.info("");
		String strMessage = message.getPayload();
		TextMessage textMessage = new TextMessage(strMessage);
		session.sendMessage(textMessage);
	}
	
	//연결이 종료되었을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {		
		LOGGER.info("");
	}
}
