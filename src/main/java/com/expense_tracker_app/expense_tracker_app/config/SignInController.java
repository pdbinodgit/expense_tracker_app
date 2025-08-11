package com.expense_tracker_app.expense_tracker_app.config;

import com.expense_tracker_app.expense_tracker_app.customexception.TrackerException;
import com.expense_tracker_app.expense_tracker_app.customresponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/url")
public class SignInController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseEntity<ApiResponse<?>> signIn(@RequestBody TokenRequest tokenRequest){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword()));
            String token= jwtService.generateToken(authentication.getName());

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK,"Token generate successfully",new TokenResponse(token, authentication.getName())git ));

    }
}
