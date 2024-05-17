package com.lcwd.userservice.interceptors;

import java.io.IOException;

import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;

@Configuration
@Component
@AllArgsConstructor
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

	private OAuth2AuthorizedClientManager manager;
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		
		System.out.println("apply() of REST");
		
		String token = manager.authorize(OAuth2AuthorizeRequest
												.withClientRegistrationId("my-internal-client")
													.principal("internal").build())
												.getAccessToken().getTokenValue();

		System.out.println("$$$ REST ---> TOKEN --> " + token);
		
		request.getHeaders().add("Authorization", "Bearer " + token);

		return execution.execute(request, body);
	}
} 

