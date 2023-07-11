package com.infinitecodes.jsShopBackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception  {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .oauth2ResourceServer()
                .jwt()
                .decoder(jwtDecoder());
    }

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(List.of(
                HttpMethod.GET.name(),
                HttpMethod.PUT.name(),
                HttpMethod.POST.name(),
                HttpMethod.DELETE.name()
        ));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
        return source;
    }



    JwtDecoder jwtDecoder() {

        OAuth2TokenValidator<Jwt> withAudience = new AudienceValidator(audience);
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
        OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

        NimbusJwtDecoder jwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);

        jwtDecoder.setJwtValidator(validator);

        return jwtDecoder;
    }

}

/*
1.
antMatcher(String antPattern) - Allows configuring the HttpSecurity to only be invoked when matching the provided ant pattern.
mvcMatcher(String mvcPattern) - Allows configuring the HttpSecurity to only be invoked when matching the provided Spring MVC pattern.

Generally mvcMatcher is more secure than an antMatcher. As an example:

* antMatchers("/secured") matches only the exact /secured URL
* mvcMatchers("/secured") matches /secured as well as /secured/, /secured.html, /secured.xyz

and therefore is more general and can also handle some possible configuration mistakes.

2.
permitAll() does exactly what it says. It allows (permits) any user's (all) session to be authorized to execute that method.

The way spring manages its authentication and authorization means that anyone accessing your site is provided with a session.
This session can be anonymous, or authenticated (user's provided some kind of credential and the system has accepted it).
Alternatives to permitAll (hasPermission() for example) will usually check the user's authentication to ensure they have some
role or group assigned to them before allowing the annotated class/method to be invoked.

3.
anyRequest().authenticated() means, that any request must be authenticated otherwise the Spring app will return a 401 response.

Example: Everyone needs to be authorized to execute a method, to be able to log in, and then they can get authenticated.
Because if they would not be authorized to execute the GET method, they have no change at being authenticated.

4.
cors

5.
configurationSource(corsConfigurationSource())

6.
oauth2ResourceServer

7.
jwt()

8.
decoder(jwtDecoder())



*/