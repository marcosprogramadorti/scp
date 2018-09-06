package br.gov.transportes.scp.security;

import org.springframework.context.annotation.Profile;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TokenProfileProviderImpl implements TokenProfileProvider {
    @Override
    public List<AuthenticationProfile> getProfiles(Authentication authentication) {
        Stream<String> profiles = Arrays.stream(getAttribute(authentication, "perfis").split(","));
        String[] names = getAttribute(authentication, "nomesperfis").split(",");
        List<AuthenticationProfile> list = new ArrayList<>();

        profiles.forEach((String s) -> {
            AuthenticationProfile authenticationProfile = new AuthenticationProfile();
            authenticationProfile.setAcronym(s);
            list.add(authenticationProfile);
        });

        getName(names, list);

        list.sort(Comparator.comparing(AuthenticationProfile::getAcronym));
        return list;

    }

    private void getName(String[] names, List<AuthenticationProfile> list) {
        for (int i = 0; i < list.size(); i++) {
            AuthenticationProfile authenticationProfile = list.get(i);
            if (i <= names.length -1) {
                authenticationProfile.setName(names[i]);
            } else {
                authenticationProfile.setName(authenticationProfile.getAcronym());
            }
        }
    }

    private String getAttribute(Authentication authentication, String key) {
        Map<String, Object> attributes = ((CasAuthenticationToken) authentication).getAssertion().getPrincipal().getAttributes();
        return attributes.entrySet().stream()
            .filter(map -> map.getKey().equals(key))
            .map(map -> (String) map.getValue())
            .findFirst().orElse("");
    }
}
