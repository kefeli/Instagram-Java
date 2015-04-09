package com.sola.instagram.test;

import org.junit.Test;

import com.sola.instagram.auth.InstagramAuthentication;
import com.sola.instagram.io.Scopes.Scope;

public class InstagramAuthenticationTest {
	@Test
	public void testBuildAuthUrl() throws Exception {
		/*
		 * Test that no Exception is thrown 
		 */
		InstagramAuthentication auth =  new InstagramAuthentication();
		String authUrl = auth.setRedirectUri("your_redirect_url")
                .setClientSecret("your_app_secrect")
                .setClientId("your_client_id")
                .addScope(Scope.COMMENTS).addScope(Scope.LIKES)
                .getAuthorizationUri();
		System.out.println(authUrl);
	}
}
