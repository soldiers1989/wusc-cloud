package com.cxc.ms.gateway.main;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class DefaultFallbackProvider implements ZuulFallbackProvider {

	private HttpHeaders headers;
	
	private ClientHttpResponse clientHttpResponse;
	
	@PostConstruct
	public void init() {
		headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        clientHttpResponse = new ClientHttpResponse() {
			@Override
			public HttpHeaders getHeaders() {
				return headers;
			}
			@Override
			public InputStream getBody() throws IOException {
				return null;
			}
			@Override
			public String getStatusText() throws IOException {
				return "503";
			}
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.SERVICE_UNAVAILABLE;
			}
			@Override
			public int getRawStatusCode() throws IOException {
				return 503;
			}
			@Override
			public void close() {
				
			}
		};
	}
	@Override
	public ClientHttpResponse fallbackResponse() {
		return clientHttpResponse;
	}
	@Override
	public String getRoute() {
		return "*";
	}
}
