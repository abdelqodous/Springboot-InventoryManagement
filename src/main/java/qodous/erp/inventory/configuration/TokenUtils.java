/*
 * package qodous.erp.inventory.configuration;
 * 
 * import java.util.Date; import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jws; import
 * io.jsonwebtoken.Jwts; import io.jsonwebtoken.SignatureAlgorithm;
 * 
 * @Component public class TokenUtils {
 * 
 * private Long TOKEN_VALIDITY = 604800L; private String TOKEN_SECRET =
 * "ERP-API";
 * 
 * public String generateToken(ErpUserDetails userDetails) { Map<String, Object>
 * claims = new HashMap<>(); claims.putIfAbsent("sub",
 * userDetails.getUsername()); claims.putIfAbsent("created", new Date());
 * 
 * return Jwts.builder().setClaims(claims).setExpiration(getExpirationDate())
 * .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact(); }
 * 
 * private Date getExpirationDate() { // TODO Auto-generated method stub return
 * new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000); }
 * 
 * public boolean isTokenValid(String token, ErpUserDetails userDetails) {
 * String userName = getUserNameFromToken(token); return
 * (userName.equals(userDetails.getUsername()) && !isTokenExpired(token)); }
 * 
 * public String getUserNameFromToken(String token) { Claims claims =
 * getClaims(token); return claims.getSubject(); }
 * 
 * private Claims getClaims(String token) { Claims claims =
 * Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
 * return claims; }
 * 
 * 
 * 
 * private boolean isTokenExpired(String token) { Date expireDate =
 * getClaims(token).getExpiration(); return expireDate.before(new Date()); } }
 */