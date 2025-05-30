package by.cherkas.diplom.security.jwt;

import by.cherkas.diplom.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "dfhgjskgjsdkalvbjnkdwlhguierjhvnfjkwlhsvjckdbahjwryhlweuioqcnvjewloghvgioqfndjal";

    public static String generateToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("Role", user.getRole())
                .expiration(new Date(System.currentTimeMillis() + 60000 * 60 * 24))
                .signWith(getSigningKey())
                .compact();
    }

    public static Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static boolean isTokenValid(String token){
        return !isExpired(token);
    }

    private static boolean isExpired(String token){
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private static SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
