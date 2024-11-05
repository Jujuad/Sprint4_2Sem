package br.com.fiap.Sprint4_2sem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class JwtTokenProvider {
    private static final String SECRET_KEY = "sua_chave";
    private static final Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");

    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (Exception e) {

            System.out.println("Token inválido: " + e.getMessage());
            return false; 
        }
    }
}
