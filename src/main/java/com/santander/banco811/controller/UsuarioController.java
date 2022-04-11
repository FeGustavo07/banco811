package com.santander.banco811.controller;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Usuario> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int pagina,
            @RequestParam(required = false, defaultValue = "3") int tamanho

    ) {
        return usuarioService.getAll(nome, pagina, tamanho);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse getById(@PathVariable Integer id) {
        return usuarioService.getById(id);
    }

    @GetMapping("/cpf")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> getAllByCpf(
            @RequestParam String cpf,
            @RequestParam(required = false, defaultValue = "0") int pagina,
            @RequestParam(required = false, defaultValue = "3") int tamanho
    ) {
        return usuarioService.getAllByCpf(cpf, pagina, tamanho);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        usuarioService.delete(id);
    }
}
