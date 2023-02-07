package qodous.erp.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private Long TOKEN_VALIDITY = 604800L;
    private String TOKEN_SECRET = "ERP-API";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.putIfAbsent("sub", userDetails.getUsername());
        claims.putIfAbsent("created", new Date());
        return Jwts
                .builder()
                .setClaims(claims)
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();
    }

    private boolean isTokenExpired(String token) {
        Date expireDate = getClaims(token).getExpiration();
        return expireDate.before(new Date());
    }

    private Claims getClaims(String token) {
        Claims claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
        return claims;
    }

    private Date getExpirationDate() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String userName = extractUserNameFromToken(token);
        return  (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUserNameFromToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
}
