package com.neldale.SpringBoot.controller;

import com.neldale.SpringBoot.config.TokenProvider;
import com.neldale.SpringBoot.model.AuthToken;
import com.neldale.SpringBoot.model.LoginUser;
import com.neldale.SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.neldale.SpringBoot.model.Constants.TOKEN_PREFIX;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> register(/*@RequestBody */LoginUser loginUser) throws Exception {
        authenticate(loginUser.getUsername(), loginUser.getPassword());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("DARABAKHOUL", e);
        }
    }

}
