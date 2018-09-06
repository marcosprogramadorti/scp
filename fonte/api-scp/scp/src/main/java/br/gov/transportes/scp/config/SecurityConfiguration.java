package br.gov.transportes.scp.config;
 
import br.com.basis.sca.servidor.servico.GedaiServiceTicketValidator;
import br.com.basis.sca.servidor.servico.GedaiUserDetailsService;
import br.gov.transportes.scp.security.UserNotActivatedException;
import br.gov.transportes.scp.service.UserDetailsService;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

@Order(100)
@Primary
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends GatewayConfigurerAdapter {

    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new SessionFixationProtectionStrategy();
    }

    @Bean
    public Filter applicationAuthenticationFilter()  {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();

            try {
                casAuthenticationFilter.setAuthenticationManager(authenticationManager());
                casAuthenticationFilter.setAuthenticationSuccessHandler(casAuthenticationSuccessHandler());
                casAuthenticationFilter.setAuthenticationFailureHandler(casAuthenticationFailure());
                casAuthenticationFilter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy());
                casAuthenticationFilter.setServiceProperties(serviceProperties());
            } catch (Exception e) {
                throw new UserNotActivatedException(e.getMessage(), e);
            }

        return casAuthenticationFilter;
    }

    @Override
    protected void configureAuthenticationFilter(HttpSecurity http) {
        http.addFilter(applicationAuthenticationFilter());
    }

    @Bean
    public AuthenticationSuccessHandler casAuthenticationSuccessHandler() {
        return new CasAuthenticationSuccessHandler()
            .withRedirectAfterLogin(redirectAfterLogin);
    }


    public AuthenticationFailureHandler casAuthenticationFailure() {
        return new CasAuthenticationFailure()
            .withRedirectAfter(redirectAfterLogin);
    }

    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(service);
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

    @Bean(name = "userDatailsService")
    public UserDetailsService gatewayUserDetailsService() {
        return new UserDetailsService();
    }

    @Bean
    public AuthenticationUserDetailsService authenticationUserDetailsService() {
        return new GedaiUserDetailsService();
    }

    @Bean
    public Set<String> adminList() {
        Set<String> admins = new HashSet<>();
        if (!adminUser.isEmpty()) {
            admins.add(adminUser);
        }
        return admins;
    }

    @Bean
    public Cas20ServiceTicketValidator Cas20ServiceTicketValidator() {
        return new Cas20ServiceTicketValidator(casUrlPrefix);
    }

    @Bean
    public AuthenticationProvider gatewayAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        casAuthenticationProvider.setAuthenticationUserDetailsService(new GedaiUserDetailsService());
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(new GedaiServiceTicketValidator(casUrlPrefix));
        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only");
        return casAuthenticationProvider;
    }


    @Bean
    public AuthenticationEntryPoint gatewayAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(serviceLogin);
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }

    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

    @Bean
    public LogoutFilter requestCasGlobalLogoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter(serviceLogout + "?service="
            + serviceHome, new SecurityContextLogoutHandler());
        logoutFilter.setLogoutRequestMatcher(new AntPathRequestMatcher("/cas/logout", "GET"));
        return logoutFilter;
    }
}
