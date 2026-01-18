package org.example.securityjwt.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtAuthConverter implements Converter<Jwt, JwtAuthenticationToken> {

  @Override
  public JwtAuthenticationToken convert(Jwt jwt) {
    Collection<SimpleGrantedAuthority> authorities = extractRoles(jwt);
    return new JwtAuthenticationToken(jwt, authorities);
  }

  private Collection<SimpleGrantedAuthority> extractRoles(Jwt jwt) {
    Map<String, Object> realmAccess = jwt.getClaim("realm_access");
    if (realmAccess == null || realmAccess.get("roles") == null) {
      return List.of();
    }

    List<String> roles = (List<String>) realmAccess.get("roles");

    return roles.stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
        .collect(Collectors.toList());
  }
}
