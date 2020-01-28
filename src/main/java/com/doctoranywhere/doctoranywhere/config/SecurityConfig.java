package com.doctoranywhere.doctoranywhere.config;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.doctoranywhere.doctoranywhere.security.FirebaseAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger log=LogManager.getLogger(SecurityConfig.class);
	
	@Autowired
	private FirebaseAuthenticationTokenFilter firebaseAuthenticationTokenFilter;
	
	@Value(value = "${application.security.allowedorigins}")
	private String[] allowedOrgin;
	
	@Value(value = "${application.security.allowedmethods}")
	private String[] allowedMethods;
	
	 @Override
	 public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
     }
	 
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/app/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Custom security filter
        httpSecurity.addFilterBefore(firebaseAuthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);
    }
	
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(allowedOrgin));
        configuration.setAllowedMethods(Arrays.asList(allowedMethods));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        log.info("CORS"+allowedOrgin+"-"+allowedMethods);
        return source;
    }

}