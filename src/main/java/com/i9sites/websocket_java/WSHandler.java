package com.i9sites.websocket_java;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class WSHandler {
	
	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		System.out.println(statusCode + " " + reason);
		
	}
	
	@OnWebSocketError
	public void onError(Throwable error) {
		System.out.println(error.getMessage());		
	}
	
	@OnWebSocketConnect
	public void onConnect(Session session) {
		try {
			session.getRemote().sendString("Hello websocket jetty");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@OnWebSocketMessage
	public void onMessage(String msg) {
	System.out.println(msg);	
	}

}
