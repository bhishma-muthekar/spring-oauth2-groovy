package com.harman.springboot.demo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value('${security.jwt.client-id}')
	String clientId

	@Value('${security.jwt.client-secret}')
	String clientSecret

	@Value('${security.jwt.grant-type}')
	String grantType

	@Value('${security.jwt.scope-read}')
	String scopeRead

	@Value('${security.jwt.scope-write}')
	String scopeWrite = "write"

	@Value('${security.jwt.resource-ids}')
	String resourceIds

	@Autowired
	TokenStore tokenStore

	@Autowired
	JwtAccessTokenConverter accessTokenConverter

	@Autowired
	AuthenticationManager authenticationManager

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer
				.inMemory()
				.withClient(clientId)
				.secret(clientSecret)
				.authorizedGrantTypes(grantType)
				.scopes(scopeRead, scopeWrite)
				.resourceIds(resourceIds)
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain()
		enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter))
		endpoints.tokenStore(tokenStore)
				.accessTokenConverter(accessTokenConverter)
				.tokenEnhancer(enhancerChain)
				.authenticationManager(authenticationManager)
	}
}
