package com.br.zamp.security;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
  private final JwtEncoder encoder;

  public JwtService(JwtEncoder encoder) {
    this.encoder = encoder;
  }

  public String generateToken(AuthUser user) {
    Instant now = Instant.now();
    long expiry = 36000L;

    Set<GrantedAuthority> rolesAndPermissions = new HashSet<>(user.getAuthorities());
    rolesAndPermissions.addAll(user.getPermissions());

    String scope =
        rolesAndPermissions.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

    JwtClaimsSet claims =
        JwtClaimsSet.builder()
            .issuer("spring-security-jwt")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(user.getUsername())
            .claim("id", user.getUser().getId())
            .claim("maxLevel", user.getUser().getMaxUserProfileLevel().getLevel())
            .claim("scope", scope)
            .build();

    return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
}
