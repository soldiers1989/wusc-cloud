package com.cxc.chat.easemob;

import com.sun.jersey.api.client.Client;

public class ClientUtil {
	
	public static final Client client = init();
	
	private static Client init() {
		Client client = new Client();
		client.setConnectTimeout(50000);
		client.setReadTimeout(50000);
		client.setFollowRedirects(true);
		return client;
	}
}
