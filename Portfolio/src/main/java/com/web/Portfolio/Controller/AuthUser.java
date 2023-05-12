package com.web.Portfolio.Controller;

import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Service.UserService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthUser {
    private SecretKey secret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private String encodedSecret = Base64.getEncoder().encodeToString(secret.getEncoded());

    public void setSecretKey(SecretKey secretKey) {
        this.secret = secretKey;
    }

    public SecretKey getSecretKey() {
        return this.secret;
    }

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario user) throws Exception {
        Usuario usuario = userService.getUserByEmail(user.getEmail());

        Map<String, String> responseError = new HashMap<>();
        responseError.put("error", "Usuario o contraeña invalida");
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseError);
        }

        if (!user.getContraseña().equals(usuario.getContraseña())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseError);
        }

        //this.setSecretKey(Keys.secretKeyFor(SignatureAlgorithm.HS512));
        String jwt = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", "Usuario")
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();

        Map<String, String> response = new HashMap<>();

        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }

    public boolean isJwtValid(String jwt, SecretKey secretKey) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    



    // log out no se hace por que simplemente se puede borrar el jwt del lado del
    // cliente
}
