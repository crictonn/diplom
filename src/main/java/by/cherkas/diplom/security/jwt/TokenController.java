package by.cherkas.diplom.security.jwt;

import by.cherkas.diplom.user.User;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    private final AuthenticationManager manager;

    public TokenController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody User user){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return JwtUtils.generateToken((User) authentication.getPrincipal());
    }

    @GetMapping("/claims")
    public ResponseEntity<Claims> getClaims(@RequestParam String token){
        return ResponseEntity.ok(JwtUtils.getClaims(token));
    }
}
