package br.gov.transportes.scp.service;

import br.gov.transportes.scp.security.AuthoritiesConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    private Set<String> admins;

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken casAssertionAuthenticationToken)
        throws UsernameNotFoundException {
        String login = Optional.ofNullable(casAssertionAuthenticationToken.getPrincipal())
            .map(Object::toString)
            .orElse("");
        String lower = login.toLowerCase();
        String permissao = "";
        Map<String, String> parametros = extraiParametrosDoCAS(casAssertionAuthenticationToken);
        if(parametros != null) {
             permissao = parametros.get("permissao");
            if(permissao == null) {
                permissao = "";
            }
        }
        Collection<SimpleGrantedAuthority> roles = extraiRoles(permissao);
        log.debug("CAS Auth '{}'", login);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.addAll(roles);

        return new User(lower, "***", grantedAuthorities);
    }

    private Collection<SimpleGrantedAuthority> extraiRoles(String permissao) {
        List<String> permissoes = Arrays.asList(String.join(",", AuthoritiesConstants.USER, permissao)
            .split(","));

        permissoes.removeIf(s -> s == null || s.isEmpty());

        return permissoes.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private Map<String, String> extraiParametrosDoCAS(CasAssertionAuthenticationToken casAssertionAuthenticationToken) {
        return Optional.ofNullable(casAssertionAuthenticationToken.getAssertion())
            .map(Assertion::getPrincipal)
            .map(AttributePrincipal::getAttributes)
            .map(a -> {
                HashMap<String, String> hash = new HashMap<>();
                a.forEach((s, o) -> {
                    hash.put((String)s, o.toString()
                        .toLowerCase());
                });
                return hash;
            })
            .orElse(null);
    }

}
