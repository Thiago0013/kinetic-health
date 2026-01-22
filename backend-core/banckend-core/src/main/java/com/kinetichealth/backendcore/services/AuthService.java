package com.kinetichealth.backendcore.services;

import com.kinetichealth.backendcore.dto.LoginDTO;
import com.kinetichealth.backendcore.dto.UserRegisterDTO;
import com.kinetichealth.backendcore.models.Users;
import com.kinetichealth.backendcore.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService, @Lazy AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public void register(UserRegisterDTO dto){
        if(userRepository.existsByEmail(dto.email())){
            throw new RuntimeException("ERRO: Já existe uma conta com esse email.");
        }

        Users newUsers = Users.builder()
                .fullName(dto.fullName())
                .email(dto.email())
                .passwordHash(passwordEncoder.encode(dto.password()))
                .age(dto.age())
                .gender(dto.gender())
                .dailyWaterGoalMl(2000)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(newUsers);
    }

    public String login(LoginDTO dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());

        var auth = authenticationManager.authenticate(usernamePassword);

        return tokenService.generateToken((Users) Objects.requireNonNull(auth.getPrincipal()));
    }
}
