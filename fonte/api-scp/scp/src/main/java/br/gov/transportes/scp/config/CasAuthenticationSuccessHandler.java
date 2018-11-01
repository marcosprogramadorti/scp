package br.gov.transportes.scp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.gov.transportes.scp.security.JWTConfigurer;
import br.gov.transportes.scp.security.TokenProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CasAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger log = LoggerFactory.getLogger(CasAuthenticationSuccessHandler.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private String redirectAfterLogin;

    @Autowired
    private TokenProvider tokenProvider;

    public CasAuthenticationSuccessHandler withRedirectAfterLogin(String redirectAfterLogin) {
        this.redirectAfterLogin = redirectAfterLogin;
        return this;
    }

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) throws IOException, ServletException {
        log.debug("Login ok!");
        String ticketParam = request.getParameter("ticket");
        String ticketAttr = (String) request.getAttribute("ticket");
        String ticket = Optional.ofNullable(ticketAttr).orElse(ticketParam);
        if (redirectAfterLogin != null) {
            tokenProvider.init();
            String token = tokenProvider.createToken(authentication, true);
            response.setHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + token);
            redirectStrategy.sendRedirect(request, response, redirectAfterLogin + "/"  + token);
        }
    }
}
