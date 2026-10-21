package br.com.docodigoaocontrato.taskforge.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtService {

    private static final String SECRET = "ACESSO SECRETO PARA ENTRAR NO TASKFORGE";
    private final SecretKey chave = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private static final long UMA_HORA = 1000L * 60 * 60;

    public String gerarToken(String email, String usuario) {
        return Jwts.builder()
                .claim("nome", usuario)
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + UMA_HORA))
                .signWith(chave)
                .compact();
    }

    public String validarObterEmail(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(chave)            // confere a assinatura com a nossa chave
                    .build()
                    .parseSignedClaims(token)     // abre o token (estoura se nao bater)
                    .getPayload()
                    .getSubject();                // o email que a gente pos no subject
        } catch (Exception e) {
            return null;                          // cracha nao confiavel
        }
    }


}
