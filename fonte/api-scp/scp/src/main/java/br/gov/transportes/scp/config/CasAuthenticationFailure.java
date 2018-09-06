package br.gov.transportes.scp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CasAuthenticationFailure implements AuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private String redirectAfter;

    @Value("${jhipster.security.authentication.jwt.secret}")
    private String encryptionSecret;

    public CasAuthenticationFailure withRedirectAfter(String redirectAfter) {
        this.redirectAfter = redirectAfter;
        return this;
    }

    @Override
    public void onAuthenticationFailure(
        HttpServletRequest request,
        HttpServletResponse response,
        AuthenticationException exception
    ) throws IOException, ServletException {
    	System.out.println("aqui");
        redirectStrategy.sendRedirect(request, response, redirectAfter);
    }
}
