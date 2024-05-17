package com.lcwd.userservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;

@Configuration
@Component
@AllArgsConstructor
public class FeginClientInterceptor implements RequestInterceptor {

	OAuth2AuthorizedClientManager manger;
	
	@Override
	public void apply(RequestTemplate template) {

		System.out.println("apply()");
		
		String token = manger.authorize(OAuth2AuthorizeRequest
					.withClientRegistrationId("my-internal-client").principal("internal").build())
					.getAccessToken().getTokenValue();
			
		System.out.println("$$$ OPEN FEIGN---> TOKEN --> " + token);
		
		template.header("Authorization", "Bearer " + token);
	}

	
}
