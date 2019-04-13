package com.i9sites.websocket_java;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebSocketHandler handler = new WebSocketHandler() {
			@Override
			public void configure(WebSocketServletFactory factory) {
				factory.register(WSHandler.class);
			}
		};
		server.setHandler(handler);
		server.start();
		server.join();
	}
}