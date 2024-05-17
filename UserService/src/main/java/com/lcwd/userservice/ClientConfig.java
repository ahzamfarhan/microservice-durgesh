package com.lcwd.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lcwd.userservice.interceptors.RestTemplateInterceptor;


@Configuration
@Component
public class ClientConfig {
	
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	
	@Autowired
	private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		
		interceptors.add(new RestTemplateInterceptor(
				manager(clientRegistrationRepository, oAuth2AuthorizedClientRepository)));
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	
	
	@Bean
	public OAuth2AuthorizedClientManager manager(
	
		ClientRegistrationRepository clientRegistrationRepository,
		OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository  
	) {
	
		OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder
													.builder()
													.clientCredentials().build();
	
		DefaultOAuth2AuthorizedClientManager  defaultoAuth2AuthorizedClientManager = 
		new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, 
												 oAuth2AuthorizedClientRepository);
	
		defaultoAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
	
		return defaultoAuth2AuthorizedClientManager;
	}
}
