package com.santander.banco811.dto.usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UsuarioRequest {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
}
