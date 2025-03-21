package com.mercadolibre.final_project_bootcamp_esp_2.service.auth;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationRequest;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.RegisteredUserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public RegisteredUserDto registerOne(UserDto newUser) {
        User user = userService.registerOne(newUser);
        RegisteredUserDto userDto = new RegisteredUserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().name());
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);
        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getName());
        extraClaims.put("role",user.getRole().name());
        extraClaims.put("authorities",user.getAuthorities());
        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest autRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                autRequest.getUsername(), autRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);
        User user = userService
                .findOneByUsername(autRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with username: " + autRequest.getUsername()));
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        AuthenticationResponse authRsp = new AuthenticationResponse();
        authRsp.setJwt(jwt);
        return authRsp;
    }

    public boolean validateToken(String jwt) {
        try{
            jwtService.extractUsername(jwt);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User findLoggedInUser() {

        UsernamePasswordAuthenticationToken auth =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        String username = (String) auth.getPrincipal();
        return userService.findOneByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found. Username: " + username));
    }
}