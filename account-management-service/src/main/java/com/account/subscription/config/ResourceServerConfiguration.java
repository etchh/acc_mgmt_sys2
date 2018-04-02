//package com.account.subscription.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//	
//	
//	private static final String PARTNERS_RESOURCE_ID = "partners";
//	
//	private static final String SELF_EMPLOYED_RESOURCE_ID = "self-employed";
//	
//	private static final String CONTRACTOR_RESOURCE_ID = "contractors";
//	
//	@Autowired
//    private AccessDeniedHandler accessDeniedHandler;
//	
//	
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(PARTNERS_RESOURCE_ID).stateless(false);
//		resources.resourceId(SELF_EMPLOYED_RESOURCE_ID).stateless(false);
//		resources.resourceId(CONTRACTOR_RESOURCE_ID).stateless(false);
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.
//		anonymous().disable().csrf().disable().authorizeRequests()
//        .antMatchers("/", "/home", "/about","/subscribe").permitAll()
//        .antMatchers("/admin/**").hasAnyRole("ADMIN")
//        .antMatchers("/user/**").hasAnyRole("USER")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .permitAll()
//        .and()
//        .logout()
//        .permitAll()
//		.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//		
//	}
//
//}
