package we.cod.bnz.account.services.impl;

import we.cod.bnz.account.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {

  public String generateToken(UserDetails details) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : generateToken");
    return Jwts.builder().setSubject(details.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
            .signWith(getLoginKey(), SignatureAlgorithm.HS256)
            .compact();
  }

  public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails details) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : generateRefreshToken");
    return Jwts.builder()
            .setClaims(extraClaims).setSubject(details.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
            .signWith(getLoginKey(), SignatureAlgorithm.HS256)
            .compact();
  }


  public String extractUsername(String token) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : extractUsername");
    return extractClaim(token, Claims::getSubject);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : extractClaim");
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public static Claims extractAllClaims(String token) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : extractAllClaims");
    return Jwts.parserBuilder().setSigningKey(getLoginKey()).build().parseClaimsJws(token).getBody();
  }

  private static Key getLoginKey() {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : getLoginKey");
    byte[] key = Decoders.BASE64.decode("GFLDr0Sqk4HMmmFS1pgHQtJgGXcLamkYxIvpRt2yK5I=");
    return Keys.hmacShaKeyFor(key);
  }

  public boolean isTokenValid(String token, UserDetails details) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : isTokenValid");
    final String username = extractUsername(token);
    return (username.equals(details.getUsername()) && !isTokenExpired(token));
  }

  public boolean isTokenExpired(String token) {
    System.out.println("we.cod.bnz.account : JWTServiceImpl : isTokenExpired");
    return extractClaim(token, Claims::getExpiration).before(new Date());
  }
}
