package com.kinetichealth.backendcore.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO (
        @NotBlank(message = "O email é obrigatório")
        String login,

        @NotBlank(message = "A senha é obrigatório")
        String password
){
}
