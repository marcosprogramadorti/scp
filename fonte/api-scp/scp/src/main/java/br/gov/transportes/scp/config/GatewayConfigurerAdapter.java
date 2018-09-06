package br.gov.transportes.scp.config;

import br.gov.transportes.scp.security.AuthoritiesConstants;
import br.gov.transportes.scp.security.JWTConfigurer;
import br.gov.transportes.scp.security.TokenProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.AuthenticationEntryPoint;

import static org.assertj.core.api.Assertions.extractProperty;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.activation.UnsupportedDataTypeException;

public abstract class GatewayConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(GatewayConfigurerAdapter.class);

            
    //protected String redirectAfterLogin = demoServiceProperty.getRedirect();
    
//    protected String adminUser  = demoServiceProperty.getUsername();
//
//    protected String service  = demoServiceProperty.getSecurity();
//    
//    protected String serviceHome = demoServiceProperty.getHome();
//    
//    protected String serviceLogin = demoServiceProperty.getPrefix();
//
//    protected String serviceLogout = demoServiceProperty.getLogout();
//    
//    protected String casUrlPrefix = demoServiceProperty.getPrefix();

    //protected String redirectAfterLogin = demoServiceProperty.getRedirect();
    
    protected String adminUser  = "admin";

    protected String service  = "http://localhost:8080/login/cas";
    
    protected String serviceHome = "http://localhost:8080/";
    
    protected String serviceLogin = "https://sso.dev.mt.transportes.gov.br/sso/login";

    protected String serviceLogout = "https://sso.dev.mt.transportes.gov.br/sso/logout";
    
    protected String casUrlPrefix = "https://sso.dev.mt.transportes.gov.br/sso";    
    
    protected String redirectAfterLogin = "http://localhost:8080/exemplo";
    
 
    @Autowired
    protected TokenProvider tokenProvider;

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) {
        AuthenticationProvider provider = gatewayAuthenticationProvider();
        auth.authenticationProvider(provider);
        log.info("Registrando provider={}",Optional.ofNullable(provider)
            .map(Object::getClass)
            .map(Class::getSimpleName)
            .orElse("null"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureAuthenticationFilter(http);
        AuthenticationEntryPoint entrypoint = gatewayAuthenticationEntryPoint();
        log.info("Regiatrando entry point={}", Optional.ofNullable(entrypoint)
            .map(Object::getClass)
            .map(Class::getSimpleName)
            .orElse("null"));
        this.httpExceptionHandling(http, entrypoint);
    }

    private void httpExceptionHandling(HttpSecurity http, AuthenticationEntryPoint entrypoint) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(entrypoint)
        .and().csrf().disable().headers().frameOptions().disable()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests()
        .antMatchers("/cas/**").permitAll()
        .antMatchers("/login/**").permitAll()
        .antMatchers("/api/register").permitAll()
        .antMatchers("/api/activate").permitAll()
        .antMatchers("/api/authenticate").permitAll()
        .antMatchers("/api/account/reset_password/init").permitAll()
        .antMatchers("/api/account/reset_password/finish").permitAll()
        .antMatchers("/api/logout").permitAll()
        .antMatchers("/api/profile-info").permitAll()
        .antMatchers("/api/**").authenticated()
        .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
        .antMatchers("/v2/api-docs/**").permitAll()
        .antMatchers("/swagger-resources/configuration/ui").permitAll()
        .antMatchers("/swagger-ui/index.html").hasAuthority(AuthoritiesConstants.ADMIN)
        .and().apply(securityConfigurerAdapter());
    }


    public AuthenticationEntryPoint gatewayAuthenticationEntryPoint() {
        return null;
    }

    public AuthenticationProvider gatewayAuthenticationProvider() {
        return null;
    }

    protected void configureAuthenticationFilter(HttpSecurity http) {
        // gancho
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/assets/**")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/index.html");
    }
}
