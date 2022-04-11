package com.santander.banco811.service.Impl;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repository.UsuarioRepository;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(String nome, int pagina, int tamanho) {
        PageRequest pageRequest = PageRequest.of(
                pagina,
                tamanho,
                Sort.Direction.DESC,
                "nome"
        );

        if (nome != null) {
            return usuarioRepository.findByNome(nome, pageRequest);
        } else {
            return usuarioRepository.findAll(pageRequest);
        }

    }

    @Override
    public List<UsuarioResponse> getAllByCpf(String cpf, int pagina, int tamanho) {
        PageRequest pageRequest = PageRequest.of(
                pagina,
                tamanho,
                Sort.Direction.DESC,
                "nome"
        );

        return usuarioRepository.findByCpf(cpf, pageRequest);
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());

        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public void delete(Integer id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }
}
