package br.gov.transportes.scp.security;

import org.springframework.security.core.Authentication;

import java.util.List;

@FunctionalInterface
public interface TokenProfileProvider {

    public List<AuthenticationProfile> getProfiles(Authentication authentication);
}
