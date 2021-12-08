package io.murad.askdev.controller;

import io.murad.askdev.dto.AuthenticationResponse;
import io.murad.askdev.dto.LoginRequest;
import io.murad.askdev.dto.RefreshTokenRequest;
import io.murad.askdev.dto.RegisterRequest;
import io.murad.askdev.model.RefreshToken;
import io.murad.askdev.security.JwtProvider;
import io.murad.askdev.service.AuthService;
import io.murad.askdev.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


/*
 *
 *   @author Md Murad Hossain
 *
 */

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody LoginRequest loginRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        AuthenticationResponse authResponse = authService.signIn(loginRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> signOut(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return new ResponseEntity<>("Refresh token deleted successfully",HttpStatus.OK);
    }


}
