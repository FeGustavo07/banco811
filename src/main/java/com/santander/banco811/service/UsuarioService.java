package com.santander.banco811.service;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {

    Page<Usuario> getAll(String nome, int pagina, int tamanho);

    List<UsuarioResponse> getAllByCpf(String cpf, int pagina, int tamanho);

    UsuarioResponse create(UsuarioRequest usuarioRequest);

    UsuarioResponse getById(Integer id);

    UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);
}
