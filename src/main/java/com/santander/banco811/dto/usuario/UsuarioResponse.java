package com.santander.banco811.dto.usuario;

import com.santander.banco811.model.Usuario;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String nome;
    private String email;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCriacao;

    public UsuarioResponse(Usuario usuario) {
        this.nome = usuario.getNome();
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.dataAtualizacao = usuario.getDataAtualizacao();
        this.dataCriacao = usuario.getDataCriacao();
    }

    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }

}
